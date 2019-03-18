package cn.com.starshopping.action;

import cn.com.starshopping.dao.ShangpinxinxiDao;
import cn.com.starshopping.pojo.ShangpinxinxiEntity;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Jxhun
 * Date: 2019/03/06
 * Description: 商品管理业务逻辑层
 * Version: V1.0
 */
@Namespace("/Shangpinxinxi")
@ParentPackage("json-default")
public class ShangpinxinxiAction {

    private Map<String, String> map = new HashMap<>();  // 定义一个map属性传递结果

    // 注入商品信息Dao对象，注意这个对象名是和ShangpinxinxiDao类头上Component命名相匹配的
    @Value("#{shangpinxinxiDao}")
    private ShangpinxinxiDao shangpinxinxiDao;

    public ShangpinxinxiEntity sp;    // 用一个entity对象来接收前端数据

    public String execute() {
        HttpServletRequest request = ServletActionContext.getRequest(); // 得到request
//        HttpServletResponse response = ServletActionContext.getResponse(); // 得到request
        return "json";
    }

    /**
     * 修改商品信息方法，根据前台传入到的商品编号来修改
     * 首先根据runCode得到用户是才进入页面还是点击了修改按钮，进行对应的分发
     * 如果是第一次进来就根据商品编号查询商品信息返回到页面
     * 点击修改按钮进来就获取相应的参数然后调用修改方法进行修改，修改成功返回成功状态码
     *
     * @return Result 的 name
     */
    @Action(value = "update", results = {
            @Result(name = "json", type = "json", params = {"root", "data"})})
    public String update() {
        HttpServletRequest request = ServletActionContext.getRequest(); // 得到request
        // 获取前端传入的状态码
        String runCode = request.getParameter("runCode");
        System.out.println(runCode);
        // 如果状态码存在则进入，以此排除第一次进入判断成功却不带值的情况
        if (runCode != null) {
            // 获取为0代表进入查询方法展现给操作员对应的全部信息
            if (runCode.equals("0")) {
//                String shangPinBianHao = request.getParameter("ShangPinBianHao");
                String hql = "select s.id,s.shangPinMingChen,s.shangPinLeiXin,s.shangPinGuiGe1,s.shangPinGuiGe2," +
                        "s.pinPai,s.shangPinJiaGe,s.shangPinChengBen,s.yueXiaoLiang,s.zongXiaoLiang from" +
                        " ShangpinxinxiEntity s where s.shangPinBianHao=?0";
                System.out.println(sp.getShangPinMingChen());
                List list = shangpinxinxiDao.selectShangPin(hql, new Object[]{sp.getShangPinBianHao()});  // 调用查询方法
                Object[] objArr = (Object[]) list.get(0);   // 由于商品编号为唯一的，所以得到的是一条数据
                System.out.println(Arrays.toString(objArr));
                JSONObject json = new JSONObject();  // 装结果
                json.put("id", objArr[0]);                  // 存入id
                json.put("ShangPinMingChen", objArr[1]);    // 存入商品名称
                json.put("ShangPinLeiXin", objArr[2]);      // 存入商品类型
                json.put("ShangPinGuiGe1", objArr[3]);       // 存入商品规格1
                json.put("ShangPinGuiGe2", objArr[4]);       // 存入商品规格2
                json.put("PinPai", objArr[5]);               // 存入品牌
                json.put("ShangPinJiaGe", objArr[6]);        // 存入价格
                json.put("ShangPinChengBen", objArr[7]);     // 存入成本
                json.put("YueXiaoLiang", objArr[8]);         // 存入月销量
                json.put("ZongXiaoLiang", objArr[9]);        // 存入总销量
                map.put("data", json.toString());   // 存入map
                map.put("returncode", "200");   // 200 代表查询成功
            } else {
//                String id = request.getParameter("id");
//                String ShangPinMingChen = request.getParameter("ShangPinMingChen");
//                String PinPai = request.getParameter("PinPai");
//                String ShangPinJiaGe = request.getParameter("ShangPinJiaGe");
//                String ShangPinChengBen = request.getParameter("ShangPinChengBen");
//                String ShangPinZhuangTai = request.getParameter("ShangPinZhuangTai");
                List<ShangpinxinxiEntity> list = new ArrayList<>();
//                ShangpinxinxiEntity shangpinxinxiEntity = new ShangpinxinxiEntity();
//                shangpinxinxiEntity.setId(Integer.parseInt(id));  // 传入id
//                shangpinxinxiEntity.setShangPinMingChen(ShangPinMingChen);  // 传入商品名称
//                shangpinxinxiEntity.setPinPai(PinPai);  // 传入品牌
//                shangpinxinxiEntity.setShangPinJiaGe(Integer.parseInt(ShangPinJiaGe));  // 传入商品价格
//                shangpinxinxiEntity.setShangPinChengBen(Integer.parseInt(ShangPinChengBen));  // 传入商品成本
//                shangpinxinxiEntity.setShangPinZhuangTai(Integer.parseInt(ShangPinZhuangTai));   // 传入商品状态
                list.add(sp);    // 存入list
                shangpinxinxiDao.updateShangPinXinXi(list);  // 调用修改方法传入list参数
                map.put("returncode", "200");  // 修改成功状态码200
            }
        }
        map.put("username", "大老板");
        return "json";
    }


    /**
     * 这个方法用来删除商品
     * 首先获取前端传过来的用户选择的id组成的一个类似数组的字符串，分解字符串得到id
     * 查询id对应的商品是否正在上架中，在上架中返回returnCode为1，如果不是调用删除方法删除商品
     *
     * @return 成功返回对应的Result name
     */
    @Action(value = "delete", results = {
            @Result(name = "json", type = "json", params = {"root", "data"})})
    public String delete() {
        HttpServletRequest request = ServletActionContext.getRequest(); // 得到request
        JSONObject jsonObject = new JSONObject();
        // 获取前端组成的id字符串
        String idArray = request.getParameter("ids");
        // 如果该字符串长度为0说明前端没有进行勾选，不进行操作直接返回
        if (idArray == null || idArray.length() == 0) {
            map.put("returnCode", "2");
        } else {
            // 证明有值后将字符串分为字符串数组
            String[] ids = idArray.split(",");
            ArrayList<String> arrayList = new ArrayList<>();
            // 轮询数组放入集合中，排除空值
            for (int i = 0; i < ids.length; i++) {
                if (!ids[i].equals("")) {
                    arrayList.add(ids[i]);
                }
            }
            // 将集合遍历组成新的sql片段
            String newsql = "(";
            for (String a : arrayList) {
                newsql = newsql + a + ",";
            }
            int index = newsql.lastIndexOf(",");
            newsql = newsql.substring(0, index);
            newsql = newsql + ")";
            // 这个hql用来查找选中的id是否上架中的货物，如果是上架中的货物无法删除
            String hql = "select s.id from ShangpinxinxiEntity s where s.id in " + newsql + " and s.shangPinZhuangTai = 1";
            // 查询传入的id中有没有对应正在上架中的货物，有则不操作返回，无则进行删除操作
            List list = shangpinxinxiDao.selectShangPin(hql, null);  // 查询得到list如果不为空，那么就说明是上架中的货物
            if (list != null && list.size() == 0) {   // 如果list的元素个数为0，那么说明选中的商品不是上架中的货物
                List<ShangpinxinxiEntity> listDelete = new ArrayList<>();
                for (int i = 0; i < arrayList.size(); i++) {
                    ShangpinxinxiEntity shangpinxinxiEntity = new ShangpinxinxiEntity();
                    shangpinxinxiEntity.setId(Integer.parseInt(arrayList.get(i)));   // 将id传入删除对应的对象
                    listDelete.add(shangpinxinxiEntity);
                }
                shangpinxinxiDao.deleteShangPinXinXi(listDelete);
                map.put("returnCode", "0");
            } else {
                map.put("returnCode", "1");
            }
        }
        jsonObject.put("username", "大老板");
        return "json";
    }

    /**
     * 这个方法用来对商品信息管理查询的管理
     * 通过前端传来的信息进行拼接等方式组装HQL完成查询操作并分页
     *
     * @return 返回到Result
     */
    @Action(value = "chaxun", results = {
            @Result(name = "json", type = "json", params = {"root", "data"})})
    public String select() {
        HttpServletRequest request = ServletActionContext.getRequest(); // 得到request
//        JSONObject jsonObject = new JSONObject();
//        String runCode = request.getParameter("runCode");
//        // 如果有用户名则获取状态码，如果不为零说明是获取数据用，反之是获取用户名用
//        else if (runCode != null && runCode.equals("0")){
//            return new JSONObject("{\"username\":"+xingMing+"}");
//        }
        int page = 1;
        int limit = 10;
        String now_page = request.getParameter("page");
        String now_limit = request.getParameter("limit");
        // 设初始页码为1，若从前端能获取到页码则替换
        if (!now_page.equals("")) {
            page = Integer.parseInt(now_page);
        }
        // 设分页信息为10，若从前端能获取到页码则替换
        if (!now_limit.equals("")) {
            limit = Integer.parseInt(now_limit);
        }
        // 将前端数据传入Dao取出各字段值组成集合，并将对应的占位符字符串放入集合最后
        ArrayList<Object> newsql = newSql(request);
        // 将组成的集合传入后台，将集合最后拼接进sql，再遍历值进入占位符得到返回的JSONArray
        int max = newsql.size();
        String hql = "select count(s.id) from ShangpinxinxiEntity s" + newsql.get(max - 1); // 首先拿到HQL
        Object[] objArray = new Object[max - 1];   // 创建一个数组拿到条件值
        for (int i = 0; i < max - 1; i++) {   //  循环将条件存入数组
            objArray[i] = newsql.get(i);     // 存入
        }
        List list = shangpinxinxiDao.selectShangPin(hql, objArray);  // 查询商品总条数，不需要分页调用selectShangPin方法
        Integer cout = Integer.parseInt(list.get(0).toString()); // 查询商品条数得到的只有一条记录，所以直接取出来
        System.out.println("---ShangpinxinxiAction88----总条数 = " + cout);
        hql = "select s.id,s.shangPinBianHao,s.shangPinZuBianHao,s.shangPinMingChen,s.shangPinLeiXin,s.shangPinGuiGe1,s.shangPinGuiGe2," +
                "s.pinPai,s.shangPinJiaGe,s.shangPinChengBen,s.yueXiaoLiang,s.zongXiaoLiang,s.shangPinZhuangTai,s.caoZuoShiJian from" +
                " ShangpinxinxiEntity s" + newsql.get(max - 1); // 查询商品信息HQL
        list = shangpinxinxiDao.selectShangPinXinXi(hql, objArray, page, limit);  // 查询商品信息，需要分页调用selectShangPinXinXi方法
        System.out.println("---ShangpinxinxiAction93------商品信息结果" + list);
        JSONArray jsonArray = new JSONArray();   // 定义一个JSONArray存放查询结果
        // 这个数组用来存放jsonObj的key
        String[] jsonKey = {"id", "shangPinBianHao", "shangPinZuBianHao", "shangPinMingCheng", "shangPinLeiXin", "shangPinGuiGe1", "shangPinGuiGe2",
                "pinPai", "shangPinJiaGe", "shangPinChengBen", "yueXiaoLiang", "zongXiaoLiang", "shangPinZhuangTai", "caoZuoShiJian"};
        for (Object obj : list) { // 循环取出存入
            Object[] objArr = (Object[]) obj;
            JSONObject jsonObj = new JSONObject();    // 定义一个JSONObject存放查询结果然后存入JSONArray中
            for (int i = 0; i < objArr.length; i++) {
                jsonObj.put(jsonKey[i], objArr[i]);   //  存入jsonObj
            }
            jsonArray.put(jsonObj);    // jsonObj存入jsonArray
        }
        System.out.println("---ShangpinxinxiAction112------商品信息结果JSONArray" + jsonArray);
        Integer all_page = (jsonArray.length() - 1) / 10 + 1;
        // 传入前端插件需要的全部信息数
        map.put("total", all_page.toString());
        // 传入前端插件需要的全部信息数
        map.put("count", cout.toString());
        // 传入前端插件需要的返回状态码
        map.put("code", "0");
        // 传入前端插件需要的回执信息
        map.put("msg", "");
        // 传入前端插件需要的全部信息
        map.put("data", jsonArray.toString());
        // 传入前端需要的用户名
        return "json";
    }

    /**
     * 将前端的字段值依次查询并放入集合，再将组成的sql放入集合最后
     *
     * @param request
     * @return
     */
    public ArrayList<Object> newSql(HttpServletRequest request) {
        String[] keys = {"s.shangPinBianHao", "s.shangPinZuBianHao", "s.shangPinMingCheng", "s.shangPinLeiXin",
                "s.shangPinGuiGe1", "s.shangPinGuiGe2", "s.sinPai", "s.shangPinJiaGe", "s.shangPinChengBen",
                "s.yueXiaoLiang", "s.zongXiaoLiang", "s.shangPinZhuangTai", "s.caoZuoShiJian"};
        String[] key2 = {"ShangPinBianHao", "ShangPinZuBianHao", "ShangPinMingCheng", "ShangPinLeiXin",
                "ShangPinGuiGe1", "ShangPinGuiGe2", "SinPai", "ShangPinJiaGe", "ShangPinChengBen",
                "YueXiaoLiang", "ZongXiaoLiang", "ShangPinZhuangTai", "CaoZuoShiJian"};
        String newsql = " where ";
        ArrayList<Object> new_keys = new ArrayList<>();
        int i = 0;
        int j = 0;
        for (String key : keys) {
            String value = request.getParameter(key2[i]);
            System.out.println("value" + value);
            if (value != null && !value.equals("")) {
                newsql = newsql + key + " = ?" + j + " and ";
                if (key2[i].equals("ShangPinJiaGe") || key2[i].equals("ShangPinChengBen") || key2[i].equals("YueXiaoLiang") ||
                        key2[i].equals("ZongXiaoLiang") || key2[i].equals("ShangPinZhuangTai")) {  // 有的字段需要输入int类型的，所以需要判断并转换
                    new_keys.add(Integer.parseInt(value));
                } else if (key2[i].equals("CaoZuoShiJian")) {  // 如果是时间，那么也要做相应的转换
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    try {
                        new_keys.add(simpleDateFormat.parse(value));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                } else {
                    new_keys.add(value);
                }
                j++;
            }
            i++;
        }
        int index = newsql.lastIndexOf(" and");
        if (index == -1) {
            newsql = "";
        } else {
            newsql = newsql.substring(0, index);
        }
        new_keys.add(newsql);
        return new_keys;
    }


    /**
     * 这个方法完成了对商品的新增，包括商品信息以及商品的图片新增
     */
    @Action(value = "xinZeng", results = {
            @Result(name = "json", type = "json", params = {"root", "data"})})
    public String saveShangPin() {
        HttpServletRequest request = ServletActionContext.getRequest(); // 得到request
        String runCode = request.getParameter("runCode");  // 得到一个前台传入的runCode
        System.out.println(runCode);
        JSONObject jsonObject = new JSONObject();   // 新建一个JSONObject
        // 如果状态码为0，则进入类型规格信息表获取规格名
        if (runCode.equals("0")) {
            String leiXing = request.getParameter("LeiXing");  // 得到类型
            String zuBianHao;
            for (; ; ) {
                zuBianHao = ("" + ((int) (Math.random() * 100000000) + 100000000)).substring(1);
                // 查询商品组编号HQL
                String hql = "select s.id from ShangpinxinxiEntity s where s.shangPinZuBianHao=?0";
                // 调用查询方法，查询得到list集合，如果查询到这个组编号存在，那么list中就有元素，如果不存在，那么size为0
                List list = shangpinxinxiDao.selectShangPin(hql, new Object[]{zuBianHao});
                if (list.size() == 0) {
                    break;                 // 如果查询到组编号不存在，那么就跳出循环，组编号可用
                }
            }
            String hql = "select l.guiGe1,l.guiGe2 from LeixingguigexinxibiaoEntity l where l.leiXing=?0"; // 查询规格hql语句
            List list = shangpinxinxiDao.selectShangPin(hql, new Object[]{leiXing});    // 调用公用的查询方法
            for (Object o : list) {                  // 遍历出查询结果
                Object[] objArray = (Object[]) o;
                map.put("LeiXing", leiXing);    // 类型存入JSONObject
                map.put("GuiGe1", objArray[0].toString()); // 规格1存入JSONObject
                map.put("GuiGe2", objArray[1].toString()); // 规格2存入JSONObject
            }
            map.put("zuBianHao", zuBianHao);  // 组编号存入
        } // 如果执行码为1则进入添加数据库并创建对应文件夹
        else if (runCode.equals("1")) {
            String ShangPinLeiXin = request.getParameter("ShangPinLeiXin");   // 得到商品类型
            String hql = "select l.daLeiXin from LeixingguigexinxibiaoEntity l where l.leiXing=?0";  // 查询大类型hql语句
            List list = shangpinxinxiDao.selectShangPin(hql, new Object[]{ShangPinLeiXin});   // 得到查询结果list
            // 因为只查询一个字段，所以得到就是一个字符串型的list，而且结果只有一条所以直接get(0)
            String daLeiXin = (String) list.get(0);
            String[] guiGe01 = request.getParameter("ShangPinGuiGe1").split(",");  // 得到商品规格1
            String[] guiGe02 = request.getParameter("ShangPinGuiGe2").split(",");  // // 得到商品规格2
            List<ShangpinxinxiEntity> shangPinList = new ArrayList<>();
            for (int i = 0; i < guiGe01.length; i++) {  // 这个循环取出规格1
                for (int j = 0; j < guiGe02.length; j++) {  // 这个循环取出规格2 两个循环达到每个规格1对应一个规格2
                    ShangpinxinxiEntity shangpinxinxiEntity = new ShangpinxinxiEntity();
                    shangpinxinxiEntity.setShangPinBianHao(request.getParameter("ShangPinZuBianHao") + "-A" + i + "B" + j); // 传入商品编号
                    shangpinxinxiEntity.setShangPinZuBianHao(request.getParameter("ShangPinZuBianHao")); // 传入商品组编号
                    shangpinxinxiEntity.setShangPinMingChen(request.getParameter("ShangPinMingChen"));  // 传入商品名称
                    shangpinxinxiEntity.setShangPinLeiXin(request.getParameter("ShangPinLeiXin")); // 传入商品类型
                    shangpinxinxiEntity.setShangPinGuiGe1(guiGe01[i]);  // 传入商品规格1
                    shangpinxinxiEntity.setShangPinGuiGe2(guiGe02[j]);  // 传入商品规格2
                    shangpinxinxiEntity.setPinPai(request.getParameter("PinPai"));  // 传入商品品牌
                    try {   // 这个try是避免传入的价格和成本格式不正确或者为空
                        shangpinxinxiEntity.setShangPinJiaGe(Integer.parseInt(request.getParameter("ShangPinJiaGe")));
                        shangpinxinxiEntity.setShangPinChengBen(Integer.parseInt(request.getParameter("ShangPinChengBen")));
                    } catch (NumberFormatException e) {
                        map.put("returncode", "-100");  // 发生异常，直接结束方法
                        return "json";
                    }
                    shangpinxinxiEntity.setShangPinMiaoSu(request.getParameter("ShangPinMiaoSu"));
                    shangpinxinxiEntity.setCaoZuoShiJian(new Timestamp(System.currentTimeMillis()));
                    shangpinxinxiEntity.setLeiXin(daLeiXin);
                    shangPinList.add(shangpinxinxiEntity);   // 添加到商品List中
                }
            }
            shangpinxinxiDao.saveShangPin(shangPinList);   // 调用新增方法，传入封装的list
            creatFile(request);    // 调用方法创建文件夹存放图片
        }// 图片文件的上传
        else if (runCode.equals("2")) {
            try {
                fileUpLoad(request);   // 调用文件上传方法
            } catch (IOException e) {
                e.printStackTrace();
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
        map.put("username", "大老板");
        return "json";
    }

    public Map<String, String> getData() {
        System.out.println("----------getData");
        System.out.println("map = " + map);
        return map;
    }

    /**
     * 根据组编号创建文件夹
     * 直接沿用老方法，不对方法做更改
     *
     * @param request
     */
    public void creatFile(HttpServletRequest request) {
        ServletContext servletContext = request.getServletContext();
        File file = null;
        String[] urls = new String[4];
        urls[0] = servletContext.getRealPath(File.separator + request.getParameter("ShangPinZuBianHao") + File.separator);
        urls[1] = servletContext.getRealPath(File.separator + request.getParameter("ShangPinZuBianHao") + File.separator + "缩略图" + File.separator);
        urls[2] = servletContext.getRealPath(File.separator + request.getParameter("ShangPinZuBianHao") + File.separator + "浏览图" + File.separator);
        urls[3] = servletContext.getRealPath(File.separator + request.getParameter("ShangPinZuBianHao") + File.separator + "详情图" + File.separator);
        for (String i : urls) {
            file = new File(i);
            if (!file.exists()) {
                try {
                    file.mkdir();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ShangPinZuBianHao", request.getParameter("ShangPinZuBianHao"));
    }

    /**
     * 文件上传方法
     *
     * @param request
     * @return 上传成功返回true
     * @throws IOException
     * @throws FileUploadException
     */
    public boolean fileUpLoad(HttpServletRequest request) throws IOException, FileUploadException {
        // 注意，在实际开发中，尽量把服务器的下载目录通过filter屏蔽掉，因为在没有屏蔽之前，用户可以通过手动请求路径获取文件信息
        // 状态机，false代表上传失败，true代表成功
        boolean action = false;
        // 设置请求对象语言编码为UTF-8
        request.setCharacterEncoding("UTF-8");
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart) {
            System.out.println("true");
            // 创建工厂（这里用的是工厂模式）
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // 获取ServletContext
            ServletContext servletContext = request.getServletContext();
            // 获取从ServletContext中得到上传来的数据，fileupload固定的参数：javax.servlet.context.tempdir
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            // fileupload封装上传来的文件的各种属性（上传来的文件的大小、文件名等）
            factory.setRepository(repository);
            // fileupload生成对应的数据参数对象
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 把request转成fileupload中FileItem的实例
            List<FileItem> items = upload.parseRequest(request);
            int count = 0;
            String shangPinZuBianHao = request.getParameter("ShangPinZuBianHao");
            String url = request.getParameter("url");
            if (url.equals("0")) {
                url = "缩略图";
            } else if (url.equals("1")) {
                url = "浏览图";
            } else {
                url = "详情图";
            }
            for (FileItem item : items) {
                // 获取服务器物理路径的根路径，必须至少使用斜杠参数，否则会报空指针
                // 需要注意的是，在idea中测试时，路径会在当前工程的war_exploded路径下，此路径idea加载工程时，可能会被重置，如果在测试时遇到重置的情况，手动添加一个物理路径
                int i = item.getName().lastIndexOf('.');
                String type = item.getName().substring(i);
                String new_url = servletContext.getRealPath(File.separator) + File.separator + shangPinZuBianHao + File.separator + url + File.separator + count + type;
                // 基于服务器部署的物理路径创建文件对象
                File file = new File(new_url);
                if (!file.exists()) {   // 判断文件是否存在
                    try {
                        // 这里的警告可以使用注解或者jdk新版的注释解决
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                FileOutputStream fos = new FileOutputStream(file);
                // 创建输入流 从输入流获取字节数组
                InputStream fis = item.getInputStream();
                // 创建接收字节数组
                byte b[] = new byte[1024];
                // 默认读取-1
                int read = -1;
                // 循环读取知道读取完毕
                while ((read = fis.read(b)) != -1) {
                    fos.write(b, 0, read);
                }
                fis.close();
                fos.flush();
                fos.close();
                count++;
            }
            action = true;     // 上传成功
        }
        return action;
    }

    public ShangpinxinxiEntity getSp() {
        System.out.println("---getSp----" + sp);
        return sp;
    }

    public void setSp(ShangpinxinxiEntity sp) {
        System.out.println("---setSp----" + sp);
        this.sp = sp;
    }
}
