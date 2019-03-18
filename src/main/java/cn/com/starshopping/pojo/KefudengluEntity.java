package cn.com.starshopping.pojo;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Jxhun
 * Date: 2019/03/06
 * Description:
 * Version: V1.0
 */
@Entity
@Table(name = "kefudenglu", schema = "starshopping", catalog = "")
public class KefudengluEntity {
    private int id;
    private String xingMing;
    private String shouJiHaoMa;
    private String miMa;
    private Integer zhuangTai;
    private String shenFenZheng;
    private Timestamp zuiHouDengLu;
    private Timestamp zuiHouQianDao;
    private Integer cuoWuCiShu;
    private String youXiang;
    private String xingBie;
    private Integer qiandaocishu;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "XingMing")
    public String getXingMing() {
        return xingMing;
    }

    public void setXingMing(String xingMing) {
        this.xingMing = xingMing;
    }

    @Basic
    @Column(name = "ShouJiHaoMa")
    public String getShouJiHaoMa() {
        return shouJiHaoMa;
    }

    public void setShouJiHaoMa(String shouJiHaoMa) {
        this.shouJiHaoMa = shouJiHaoMa;
    }

    @Basic
    @Column(name = "MiMa")
    public String getMiMa() {
        return miMa;
    }

    public void setMiMa(String miMa) {
        this.miMa = miMa;
    }

    @Basic
    @Column(name = "ZhuangTai")
    public Integer getZhuangTai() {
        return zhuangTai;
    }

    public void setZhuangTai(Integer zhuangTai) {
        this.zhuangTai = zhuangTai;
    }

    @Basic
    @Column(name = "ShenFenZheng")
    public String getShenFenZheng() {
        return shenFenZheng;
    }

    public void setShenFenZheng(String shenFenZheng) {
        this.shenFenZheng = shenFenZheng;
    }

    @Basic
    @Column(name = "ZuiHouDengLu")
    public Timestamp getZuiHouDengLu() {
        return zuiHouDengLu;
    }

    public void setZuiHouDengLu(Timestamp zuiHouDengLu) {
        this.zuiHouDengLu = zuiHouDengLu;
    }

    @Basic
    @Column(name = "ZuiHouQianDao")
    public Timestamp getZuiHouQianDao() {
        return zuiHouQianDao;
    }

    public void setZuiHouQianDao(Timestamp zuiHouQianDao) {
        this.zuiHouQianDao = zuiHouQianDao;
    }

    @Basic
    @Column(name = "CuoWuCiShu")
    public Integer getCuoWuCiShu() {
        return cuoWuCiShu;
    }

    public void setCuoWuCiShu(Integer cuoWuCiShu) {
        this.cuoWuCiShu = cuoWuCiShu;
    }

    @Basic
    @Column(name = "YouXiang")
    public String getYouXiang() {
        return youXiang;
    }

    public void setYouXiang(String youXiang) {
        this.youXiang = youXiang;
    }

    @Basic
    @Column(name = "XingBie")
    public String getXingBie() {
        return xingBie;
    }

    public void setXingBie(String xingBie) {
        this.xingBie = xingBie;
    }

    @Basic
    @Column(name = "qiandaocishu")
    public Integer getQiandaocishu() {
        return qiandaocishu;
    }

    public void setQiandaocishu(Integer qiandaocishu) {
        this.qiandaocishu = qiandaocishu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KefudengluEntity that = (KefudengluEntity) o;

        if (id != that.id) return false;
        if (xingMing != null ? !xingMing.equals(that.xingMing) : that.xingMing != null) return false;
        if (shouJiHaoMa != null ? !shouJiHaoMa.equals(that.shouJiHaoMa) : that.shouJiHaoMa != null) return false;
        if (miMa != null ? !miMa.equals(that.miMa) : that.miMa != null) return false;
        if (zhuangTai != null ? !zhuangTai.equals(that.zhuangTai) : that.zhuangTai != null) return false;
        if (shenFenZheng != null ? !shenFenZheng.equals(that.shenFenZheng) : that.shenFenZheng != null) return false;
        if (zuiHouDengLu != null ? !zuiHouDengLu.equals(that.zuiHouDengLu) : that.zuiHouDengLu != null) return false;
        if (zuiHouQianDao != null ? !zuiHouQianDao.equals(that.zuiHouQianDao) : that.zuiHouQianDao != null)
            return false;
        if (cuoWuCiShu != null ? !cuoWuCiShu.equals(that.cuoWuCiShu) : that.cuoWuCiShu != null) return false;
        if (youXiang != null ? !youXiang.equals(that.youXiang) : that.youXiang != null) return false;
        if (xingBie != null ? !xingBie.equals(that.xingBie) : that.xingBie != null) return false;
        if (qiandaocishu != null ? !qiandaocishu.equals(that.qiandaocishu) : that.qiandaocishu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (xingMing != null ? xingMing.hashCode() : 0);
        result = 31 * result + (shouJiHaoMa != null ? shouJiHaoMa.hashCode() : 0);
        result = 31 * result + (miMa != null ? miMa.hashCode() : 0);
        result = 31 * result + (zhuangTai != null ? zhuangTai.hashCode() : 0);
        result = 31 * result + (shenFenZheng != null ? shenFenZheng.hashCode() : 0);
        result = 31 * result + (zuiHouDengLu != null ? zuiHouDengLu.hashCode() : 0);
        result = 31 * result + (zuiHouQianDao != null ? zuiHouQianDao.hashCode() : 0);
        result = 31 * result + (cuoWuCiShu != null ? cuoWuCiShu.hashCode() : 0);
        result = 31 * result + (youXiang != null ? youXiang.hashCode() : 0);
        result = 31 * result + (xingBie != null ? xingBie.hashCode() : 0);
        result = 31 * result + (qiandaocishu != null ? qiandaocishu.hashCode() : 0);
        return result;
    }
}
