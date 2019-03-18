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
@Table(name = "gouwuche", schema = "starshopping", catalog = "")
public class GouwucheEntity {
    private int id;
    private String yongHuMing;
    private String shangPinBianHao;
    private int shangPinShuLiang;
    private String shangPinMiaoShu;
    private String shangPinGuiGe1;
    private String shangPinGuiGe2;
    private Double shangPinJiaGe;
    private String imgurl;
    private String shangPinMingChen;

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
    @Column(name = "ShangPinBianHao")
    public String getShangPinBianHao() {
        return shangPinBianHao;
    }

    public void setShangPinBianHao(String shangPinBianHao) {
        this.shangPinBianHao = shangPinBianHao;
    }

    @Basic
    @Column(name = "ShangPinShuLiang")
    public int getShangPinShuLiang() {
        return shangPinShuLiang;
    }

    public void setShangPinShuLiang(int shangPinShuLiang) {
        this.shangPinShuLiang = shangPinShuLiang;
    }

    @Basic
    @Column(name = "ShangPinMiaoShu")
    public String getShangPinMiaoShu() {
        return shangPinMiaoShu;
    }

    public void setShangPinMiaoShu(String shangPinMiaoShu) {
        this.shangPinMiaoShu = shangPinMiaoShu;
    }

    @Basic
    @Column(name = "ShangPinGuiGe1")
    public String getShangPinGuiGe1() {
        return shangPinGuiGe1;
    }

    public void setShangPinGuiGe1(String shangPinGuiGe1) {
        this.shangPinGuiGe1 = shangPinGuiGe1;
    }

    @Basic
    @Column(name = "ShangPinGuiGe2")
    public String getShangPinGuiGe2() {
        return shangPinGuiGe2;
    }

    public void setShangPinGuiGe2(String shangPinGuiGe2) {
        this.shangPinGuiGe2 = shangPinGuiGe2;
    }

    @Basic
    @Column(name = "ShangPinJiaGe")
    public Double getShangPinJiaGe() {
        return shangPinJiaGe;
    }

    public void setShangPinJiaGe(Double shangPinJiaGe) {
        this.shangPinJiaGe = shangPinJiaGe;
    }

    @Basic
    @Column(name = "imgurl")
    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    @Basic
    @Column(name = "ShangPinMingChen")
    public String getShangPinMingChen() {
        return shangPinMingChen;
    }

    public void setShangPinMingChen(String shangPinMingChen) {
        this.shangPinMingChen = shangPinMingChen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GouwucheEntity that = (GouwucheEntity) o;

        if (id != that.id) return false;
        if (shangPinShuLiang != that.shangPinShuLiang) return false;
        if (yongHuMing != null ? !yongHuMing.equals(that.yongHuMing) : that.yongHuMing != null) return false;
        if (shangPinBianHao != null ? !shangPinBianHao.equals(that.shangPinBianHao) : that.shangPinBianHao != null)
            return false;
        if (shangPinMiaoShu != null ? !shangPinMiaoShu.equals(that.shangPinMiaoShu) : that.shangPinMiaoShu != null)
            return false;
        if (shangPinGuiGe1 != null ? !shangPinGuiGe1.equals(that.shangPinGuiGe1) : that.shangPinGuiGe1 != null)
            return false;
        if (shangPinGuiGe2 != null ? !shangPinGuiGe2.equals(that.shangPinGuiGe2) : that.shangPinGuiGe2 != null)
            return false;
        if (shangPinJiaGe != null ? !shangPinJiaGe.equals(that.shangPinJiaGe) : that.shangPinJiaGe != null)
            return false;
        if (imgurl != null ? !imgurl.equals(that.imgurl) : that.imgurl != null) return false;
        if (shangPinMingChen != null ? !shangPinMingChen.equals(that.shangPinMingChen) : that.shangPinMingChen != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (yongHuMing != null ? yongHuMing.hashCode() : 0);
        result = 31 * result + (shangPinBianHao != null ? shangPinBianHao.hashCode() : 0);
        result = 31 * result + shangPinShuLiang;
        result = 31 * result + (shangPinMiaoShu != null ? shangPinMiaoShu.hashCode() : 0);
        result = 31 * result + (shangPinGuiGe1 != null ? shangPinGuiGe1.hashCode() : 0);
        result = 31 * result + (shangPinGuiGe2 != null ? shangPinGuiGe2.hashCode() : 0);
        result = 31 * result + (shangPinJiaGe != null ? shangPinJiaGe.hashCode() : 0);
        result = 31 * result + (imgurl != null ? imgurl.hashCode() : 0);
        result = 31 * result + (shangPinMingChen != null ? shangPinMingChen.hashCode() : 0);
        return result;
    }
}
