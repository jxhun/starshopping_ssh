package cn.jxhun.action;

import cn.com.starshopping.dao.ShangpinxinxiDao;
import cn.com.starshopping.pojo.ShangpinxinxiEntity;
import cn.com.starshopping.pojo.TestEntity;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Jxhun
 * Date: 2019/03/06
 * Description:
 * Version: V1.0
 */
@Namespace("/json01")
@ParentPackage("json-default")
public class TestAction {

    //    List<String> hm = new ArrayList<>();
    @Autowired
    private ShangpinxinxiDao shangpinxinxiDao;
    Map<String, String> map = new HashMap<>();

    @Action(value = "login", results = {
            @Result(name = "json", type = "json", params = {"json", "data"}),
            @Result(name = "error", location = "/error.jsp")})
    public String execute() {
        HttpServletRequest request = ServletActionContext.getRequest(); // 得到request
        HttpServletResponse response = ServletActionContext.getResponse(); // 得到request
        String action = request.getParameter("action");
        System.out.println(action);
//        String hql = "select l.guiGe1,l.guiGe2 from LeixingguigexinxibiaoEntity l where l.leiXing=?0";
//        List list = shangpinxinxiDao.selectShangPin(hql, new Object[]{"男装"});
//        System.out.println(list);
//        for (Object o : list) {
////            ShangpinxinxiEntity shangpinxinxiEntity = (ShangpinxinxiEntity) o;
//            Object[] objArray = (Object[]) o;
//            for (int i = 0; i < objArray.length; i++) {
//                System.out.println(objArray[i]);
//            }
//        }
        List<TestEntity> list = new ArrayList<>();
        String[] str = {"张三1","张三2","张三3","张三4","张三5","张三6"};
        for (int i = 0; i < str.length; i++){
            TestEntity testEntity = new TestEntity();
            testEntity.setTname(str[i]);
            list.add(testEntity);
        }
//        shangpinxinxiDao.saveShangPin(list);
        map.put("returncode", "100");
        return "json";
    }

    public Map<String, String> getData() {
        System.out.println("--------getHm");
        return map;
    }
}
