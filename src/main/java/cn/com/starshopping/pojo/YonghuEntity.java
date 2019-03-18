package cn.com.starshopping.pojo;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Jxhun
 * Date: 2019/03/06
 * Description:
 * Version: V1.0
 */
@Entity
@Table(name = "yonghu", schema = "starshopping", catalog = "")
public class YonghuEntity {
    private int id;
    private String yongHuMing;
    private String niCheng;
    private String xingMing;
    private String xingBie;
    private String shengRi;
    private String xingZuo;
    private String juZhuDi;
    private String touXiang;
    private String jiaXiang;

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
    @Column(name = "YongHuMing")
    public String getYongHuMing() {
        return yongHuMing;
    }

    public void setYongHuMing(String yongHuMing) {
        this.yongHuMing = yongHuMing;
    }

    @Basic
    @Column(name = "NiCheng")
    public String getNiCheng() {
        return niCheng;
    }

    public void setNiCheng(String niCheng) {
        this.niCheng = niCheng;
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
    @Column(name = "XingBie")
    public String getXingBie() {
        return xingBie;
    }

    public void setXingBie(String xingBie) {
        this.xingBie = xingBie;
    }

    @Basic
    @Column(name = "ShengRi")
    public String getShengRi() {
        return shengRi;
    }

    public void setShengRi(String shengRi) {
        this.shengRi = shengRi;
    }

    @Basic
    @Column(name = "XingZuo")
    public String getXingZuo() {
        return xingZuo;
    }

    public void setXingZuo(String xingZuo) {
        this.xingZuo = xingZuo;
    }

    @Basic
    @Column(name = "JuZhuDi")
    public String getJuZhuDi() {
        return juZhuDi;
    }

    public void setJuZhuDi(String juZhuDi) {
        this.juZhuDi = juZhuDi;
    }

    @Basic
    @Column(name = "TouXiang")
    public String getTouXiang() {
        return touXiang;
    }

    public void setTouXiang(String touXiang) {
        this.touXiang = touXiang;
    }

    @Basic
    @Column(name = "JiaXiang")
    public String getJiaXiang() {
        return jiaXiang;
    }

    public void setJiaXiang(String jiaXiang) {
        this.jiaXiang = jiaXiang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        YonghuEntity that = (YonghuEntity) o;

        if (id != that.id) return false;
        if (yongHuMing != null ? !yongHuMing.equals(that.yongHuMing) : that.yongHuMing != null) return false;
        if (niCheng != null ? !niCheng.equals(that.niCheng) : that.niCheng != null) return false;
        if (xingMing != null ? !xingMing.equals(that.xingMing) : that.xingMing != null) return false;
        if (xingBie != null ? !xingBie.equals(that.xingBie) : that.xingBie != null) return false;
        if (shengRi != null ? !shengRi.equals(that.shengRi) : that.shengRi != null) return false;
        if (xingZuo != null ? !xingZuo.equals(that.xingZuo) : that.xingZuo != null) return false;
        if (juZhuDi != null ? !juZhuDi.equals(that.juZhuDi) : that.juZhuDi != null) return false;
        if (touXiang != null ? !touXiang.equals(that.touXiang) : that.touXiang != null) return false;
        if (jiaXiang != null ? !jiaXiang.equals(that.jiaXiang) : that.jiaXiang != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (yongHuMing != null ? yongHuMing.hashCode() : 0);
        result = 31 * result + (niCheng != null ? niCheng.hashCode() : 0);
        result = 31 * result + (xingMing != null ? xingMing.hashCode() : 0);
        result = 31 * result + (xingBie != null ? xingBie.hashCode() : 0);
        result = 31 * result + (shengRi != null ? shengRi.hashCode() : 0);
        result = 31 * result + (xingZuo != null ? xingZuo.hashCode() : 0);
        result = 31 * result + (juZhuDi != null ? juZhuDi.hashCode() : 0);
        result = 31 * result + (touXiang != null ? touXiang.hashCode() : 0);
        result = 31 * result + (jiaXiang != null ? jiaXiang.hashCode() : 0);
        return result;
    }
}
