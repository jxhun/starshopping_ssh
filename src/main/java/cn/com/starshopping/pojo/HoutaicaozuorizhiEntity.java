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
@Table(name = "houtaicaozuorizhi", schema = "starshopping", catalog = "")
public class HoutaicaozuorizhiEntity {
    private int id;
    private String yongHuMing;
    private String caoZuoJiLu;
    private String shiJian;

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
    @Column(name = "CaoZuoJiLu")
    public String getCaoZuoJiLu() {
        return caoZuoJiLu;
    }

    public void setCaoZuoJiLu(String caoZuoJiLu) {
        this.caoZuoJiLu = caoZuoJiLu;
    }

    @Basic
    @Column(name = "ShiJian")
    public String getShiJian() {
        return shiJian;
    }

    public void setShiJian(String shiJian) {
        this.shiJian = shiJian;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HoutaicaozuorizhiEntity that = (HoutaicaozuorizhiEntity) o;

        if (id != that.id) return false;
        if (yongHuMing != null ? !yongHuMing.equals(that.yongHuMing) : that.yongHuMing != null) return false;
        if (caoZuoJiLu != null ? !caoZuoJiLu.equals(that.caoZuoJiLu) : that.caoZuoJiLu != null) return false;
        if (shiJian != null ? !shiJian.equals(that.shiJian) : that.shiJian != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (yongHuMing != null ? yongHuMing.hashCode() : 0);
        result = 31 * result + (caoZuoJiLu != null ? caoZuoJiLu.hashCode() : 0);
        result = 31 * result + (shiJian != null ? shiJian.hashCode() : 0);
        return result;
    }
}
