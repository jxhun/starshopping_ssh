package cn.com.starshopping.dao;

import cn.com.starshopping.pojo.ShangpinxinxiEntity;
import cn.com.starshopping.pojo.TestEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jxhun
 * Date: 2019/03/06
 * Description: 商品信息管理数据持久层
 * Version: V1.0
 */
@Transactional
@Component
public class ShangpinxinxiDao {

    @Value("#{hibernateTemplate}")
    private HibernateTemplate hibernateTemplate;

    public ShangpinxinxiDao() {
        System.out.println("---ShangpinxinxiDao---");
    }

    // HibernateDaoSupport自带hibernateTemplate的set、get方法，不用显式就可以注入

    /**
     * 这个方法用来不分页的商品管理查询，可以重用
     *
     * @param hql      查询的HQL，需要注意外部写IDEA不会有提示
     * @param objArray 占位符对应的值用一个Object[]的数组封装
     * @return 返回结果list集合，按照常规方法取出
     */
    public List<?> selectShangPin(String hql, Object[] objArray) {
        return hibernateTemplate.find(hql, objArray);
    }

    /**
     * 修改方法
     * 这个方法存在很多不足调用过多的set get
     * @param list action传过来的对象集合
     */
    public void updateShangPinXinXi(final List<ShangpinxinxiEntity> list) {
        for (int i = 0; i < list.size(); i++) {
            ShangpinxinxiEntity shangpinxinxiEntity = hibernateTemplate.get(ShangpinxinxiEntity.class, list.get(i).getId());
            shangpinxinxiEntity.setShangPinMingChen(list.get(i).getShangPinMingChen());  // 传入商品名称
            shangpinxinxiEntity.setPinPai(list.get(i).getPinPai());  // 传入品牌
            shangpinxinxiEntity.setShangPinJiaGe(list.get(i).getShangPinJiaGe());  // 传入商品价格
            shangpinxinxiEntity.setShangPinChengBen(list.get(i).getShangPinChengBen());  // 传入商品成本
            shangpinxinxiEntity.setShangPinZhuangTai(list.get(i).getShangPinZhuangTai());   // 传入商品状态
            hibernateTemplate.update(shangpinxinxiEntity);
        }
    }


    /**
     * 批量删除
     *
     * @param list action传过来的对象集合
     */
    public void deleteShangPinXinXi(final List<ShangpinxinxiEntity> list) {
        for (int i = 0; i < list.size(); i++) {
            hibernateTemplate.delete(list.get(i));
        }
    }


    /**
     * 这个方法用来删除商品，使用了hibernateTemplate回调机制然后按照hibernate的批量新增方法进行删除
     * 因为涉及到批处理，所以需要回调
     * 注意，由于这个类用了@Transactional管理事务，所以全程不需要对事务进行操作，否则会报错
     *
     * @param list 封装了多个ShangpinxinxiEntity对象的集合，用来新增
     */
    public void deleteShangPin(final List<ShangpinxinxiEntity> list) {
        hibernateTemplate.execute(     // 这个List用来接收doInHibernate()方法的返回结果
                new HibernateCallback() {

                    @Override
                    public Object doInHibernate(Session session)
                            throws HibernateException {
                        for (ShangpinxinxiEntity shangpinxinxiEntity : list) {
                            Integer id = shangpinxinxiEntity.getId();   // 得到ID
                            shangpinxinxiEntity = session.get(ShangpinxinxiEntity.class, id);//变成持久化对象
                            session.delete(shangpinxinxiEntity);   // 调用删除方法
                        }
                        session.flush();
                        session.clear();
                        return null;
                    }
                }
        );

    }


    /**
     * 这个方法用来新增商品，使用了hibernateTemplate回调机制然后按照hibernate的批量新增方法进行新增
     * 注意，由于这个类用了@Transactional管理事务，所以全程不需要对事务进行操作，否则会报错
     *
     * @param list 封装了多个ShangpinxinxiEntity对象的集合，用来新增
     */
    public void saveShangPin(final List<ShangpinxinxiEntity> list) {
        hibernateTemplate.execute(     // 这个List用来接收doInHibernate()方法的返回结果
                new HibernateCallback() {

                    @Override
                    public Object doInHibernate(Session session)
                            throws HibernateException {
                        for (ShangpinxinxiEntity shangpinxinxiEntity : list) {
                            session.save(shangpinxinxiEntity);
                        }
                        session.flush();
                        session.clear();
                        return null;
                    }
                }
        );

    }


    /**
     * 新增测试方法
     *
     * @param list
     */
    public void saveTest(final List<TestEntity> list) {
        hibernateTemplate.execute(     // 这个List用来接收doInHibernate()方法的返回结果
                new HibernateCallback() {

                    @Override
                    public Object doInHibernate(Session session)
                            throws HibernateException {
                        for (TestEntity testEntity : list) {
                            session.save(testEntity);
                        }
                        session.flush();
                        session.clear();
                        return null;
                    }
                }
        );

    }


    /**
     * 这个方法用来查询商品信息，并做好分页查询
     *
     * @param hql      查询语句
     * @param objArray 存放条件参数
     * @param page     当前页码
     * @param pageSize 每页条数
     * @return 返回结果list
     */
    public List<?> selectShangPinXinXi(final String hql, final Object[] objArray, final int page, final int pageSize) {

        //利用HibernateTemplate.execute()方法，以回调方式使用,不需要关闭session
        List costList = (List) hibernateTemplate.execute(     // 这个List用来接收doInHibernate()方法的返回结果
                new HibernateCallback() {

                    @Override
                    public Object doInHibernate(Session session)
                            throws HibernateException {
                        //使用session对象
                        Query query = session.createQuery(hql);
                        for (int i = 0; i < objArray.length; i++) {   // 循环添加条件
                            query.setParameter(i, objArray[i]);
                        }
                        int begin = (page - 1) * pageSize;   // 使用当前页码和每页页数计算出分页开始下标
                        query.setFirstResult(begin);        // 分页条件开始下标
                        query.setMaxResults(pageSize);      // 分页条件每页条数

                        return query.list();     // 返回结果list
                    }
                }
        );

        return costList;
    }


    /**
     * 这个方法用来实现分页，考虑到需要添加条件，所以这个方法不能共用
     *
     * @param page     当前页码
     * @param pageSize 每页数量
     * @return 得到查询结果list集合
     */
    public List<?> findPage(final int page, final int pageSize) {

        //利用HibernateTemplate.execute()方法，以回调方式使用,不需要关闭session
        List costList = (List) hibernateTemplate.execute(     // 这个List用来接收doInHibernate()方法的返回结果
                new HibernateCallback() {

                    @Override
                    public Object doInHibernate(Session session)
                            throws HibernateException {
                        // 这里创建hql，也可以作为参数传入
                        String hql = "from ShangpinxinxiEntity";
                        //使用session对象
                        Query query = session.createQuery(hql);

                        int begin = (page - 1) * pageSize;   // 使用当前页码和每页页数计算出分页开始下标
                        query.setFirstResult(begin);
                        query.setMaxResults(pageSize);

                        return query.list();     // 返回结果list
                    }
                }
        );

        return costList;
    }


}
