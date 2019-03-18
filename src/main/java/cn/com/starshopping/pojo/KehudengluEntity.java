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
@Table(name = "kehudenglu", schema = "starshopping", catalog = "")
public class KehudengluEntity {
    private int id;
    private String shouJiHaoMa;
    private String youXiang;
    private String miMa;
    private Integer dengLuCiShu;
    private Timestamp zuiHouYiCiDengLuShiJian;
    private Integer cuoWuCiShu;
    private Integer zhuangTai;
    private Timestamp zhuCeShiJian;
    private String uuid;
    private Timestamp dongJieShiJian;

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
    @Column(name = "ShouJiHaoMa")
    public String getShouJiHaoMa() {
        return shouJiHaoMa;
    }

    public void setShouJiHaoMa(String shouJiHaoMa) {
        this.shouJiHaoMa = shouJiHaoMa;
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
    @Column(name = "MiMa")
    public String getMiMa() {
        return miMa;
    }

    public void setMiMa(String miMa) {
        this.miMa = miMa;
    }

    @Basic
    @Column(name = "DengLuCiShu")
    public Integer getDengLuCiShu() {
        return dengLuCiShu;
    }

    public void setDengLuCiShu(Integer dengLuCiShu) {
        this.dengLuCiShu = dengLuCiShu;
    }

    @Basic
    @Column(name = "ZuiHouYiCiDengLuShiJian")
    public Timestamp getZuiHouYiCiDengLuShiJian() {
        return zuiHouYiCiDengLuShiJian;
    }

    public void setZuiHouYiCiDengLuShiJian(Timestamp zuiHouYiCiDengLuShiJian) {
        this.zuiHouYiCiDengLuShiJian = zuiHouYiCiDengLuShiJian;
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
    @Column(name = "ZhuangTai")
    public Integer getZhuangTai() {
        return zhuangTai;
    }

    public void setZhuangTai(Integer zhuangTai) {
        this.zhuangTai = zhuangTai;
    }

    @Basic
    @Column(name = "ZhuCeShiJian")
    public Timestamp getZhuCeShiJian() {
        return zhuCeShiJian;
    }

    public void setZhuCeShiJian(Timestamp zhuCeShiJian) {
        this.zhuCeShiJian = zhuCeShiJian;
    }

    @Basic
    @Column(name = "UUID")
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Basic
    @Column(name = "DongJieShiJian")
    public Timestamp getDongJieShiJian() {
        return dongJieShiJian;
    }

    public void setDongJieShiJian(Timestamp dongJieShiJian) {
        this.dongJieShiJian = dongJieShiJian;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KehudengluEntity that = (KehudengluEntity) o;

        if (id != that.id) return false;
        if (shouJiHaoMa != null ? !shouJiHaoMa.equals(that.shouJiHaoMa) : that.shouJiHaoMa != null) return false;
        if (youXiang != null ? !youXiang.equals(that.youXiang) : that.youXiang != null) return false;
        if (miMa != null ? !miMa.equals(that.miMa) : that.miMa != null) return false;
        if (dengLuCiShu != null ? !dengLuCiShu.equals(that.dengLuCiShu) : that.dengLuCiShu != null) return false;
        if (zuiHouYiCiDengLuShiJian != null ? !zuiHouYiCiDengLuShiJian.equals(that.zuiHouYiCiDengLuShiJian) : that.zuiHouYiCiDengLuShiJian != null)
            return false;
        if (cuoWuCiShu != null ? !cuoWuCiShu.equals(that.cuoWuCiShu) : that.cuoWuCiShu != null) return false;
        if (zhuangTai != null ? !zhuangTai.equals(that.zhuangTai) : that.zhuangTai != null) return false;
        if (zhuCeShiJian != null ? !zhuCeShiJian.equals(that.zhuCeShiJian) : that.zhuCeShiJian != null) return false;
        if (uuid != null ? !uuid.equals(that.uuid) : that.uuid != null) return false;
        if (dongJieShiJian != null ? !dongJieShiJian.equals(that.dongJieShiJian) : that.dongJieShiJian != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (shouJiHaoMa != null ? shouJiHaoMa.hashCode() : 0);
        result = 31 * result + (youXiang != null ? youXiang.hashCode() : 0);
        result = 31 * result + (miMa != null ? miMa.hashCode() : 0);
        result = 31 * result + (dengLuCiShu != null ? dengLuCiShu.hashCode() : 0);
        result = 31 * result + (zuiHouYiCiDengLuShiJian != null ? zuiHouYiCiDengLuShiJian.hashCode() : 0);
        result = 31 * result + (cuoWuCiShu != null ? cuoWuCiShu.hashCode() : 0);
        result = 31 * result + (zhuangTai != null ? zhuangTai.hashCode() : 0);
        result = 31 * result + (zhuCeShiJian != null ? zhuCeShiJian.hashCode() : 0);
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        result = 31 * result + (dongJieShiJian != null ? dongJieShiJian.hashCode() : 0);
        return result;
    }
}
