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
@Table(name = "shangpinxinxi", schema = "starshopping", catalog = "")
public class ShangpinxinxiEntity {
    private int id;
    private String shangPinBianHao;
    private String shangPinZuBianHao;
    private String shangPinMingChen;
    private String shangPinLeiXin;
    private String shangPinGuiGe1;
    private String shangPinGuiGe2;
    private String pinPai;
    private int shangPinJiaGe;
    private int shangPinChengBen;
    private String shangPinMiaoSu;
    private Integer yueXiaoLiang;
    private Integer zongXiaoLiang;
    private Integer shangPinZhuangTai;
    private Timestamp caoZuoShiJian;
    private String leiXin;

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
    @Column(name = "ShangPinBianHao")
    public String getShangPinBianHao() {
        return shangPinBianHao;
    }

    public void setShangPinBianHao(String shangPinBianHao) {
        this.shangPinBianHao = shangPinBianHao;
    }

    @Basic
    @Column(name = "ShangPinZuBianHao")
    public String getShangPinZuBianHao() {
        return shangPinZuBianHao;
    }

    public void setShangPinZuBianHao(String shangPinZuBianHao) {
        this.shangPinZuBianHao = shangPinZuBianHao;
    }

    @Basic
    @Column(name = "ShangPinMingChen")
    public String getShangPinMingChen() {
        return shangPinMingChen;
    }

    public void setShangPinMingChen(String shangPinMingChen) {
        this.shangPinMingChen = shangPinMingChen;
    }

    @Basic
    @Column(name = "ShangPinLeiXin")
    public String getShangPinLeiXin() {
        return shangPinLeiXin;
    }

    public void setShangPinLeiXin(String shangPinLeiXin) {
        this.shangPinLeiXin = shangPinLeiXin;
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
    @Column(name = "PinPai")
    public String getPinPai() {
        return pinPai;
    }

    public void setPinPai(String pinPai) {
        this.pinPai = pinPai;
    }

    @Basic
    @Column(name = "ShangPinJiaGe")
    public int getShangPinJiaGe() {
        return shangPinJiaGe;
    }

    public void setShangPinJiaGe(int shangPinJiaGe) {
        this.shangPinJiaGe = shangPinJiaGe;
    }

    @Basic
    @Column(name = "ShangPinChengBen")
    public int getShangPinChengBen() {
        return shangPinChengBen;
    }

    public void setShangPinChengBen(int shangPinChengBen) {
        this.shangPinChengBen = shangPinChengBen;
    }

    @Basic
    @Column(name = "ShangPinMiaoSu")
    public String getShangPinMiaoSu() {
        return shangPinMiaoSu;
    }

    public void setShangPinMiaoSu(String shangPinMiaoSu) {
        this.shangPinMiaoSu = shangPinMiaoSu;
    }

    @Basic
    @Column(name = "YueXiaoLiang")
    public Integer getYueXiaoLiang() {
        return yueXiaoLiang;
    }

    public void setYueXiaoLiang(Integer yueXiaoLiang) {
        this.yueXiaoLiang = yueXiaoLiang;
    }

    @Basic
    @Column(name = "ZongXiaoLiang")
    public Integer getZongXiaoLiang() {
        return zongXiaoLiang;
    }

    public void setZongXiaoLiang(Integer zongXiaoLiang) {
        this.zongXiaoLiang = zongXiaoLiang;
    }

    @Basic
    @Column(name = "ShangPinZhuangTai")
    public Integer getShangPinZhuangTai() {
        return shangPinZhuangTai;
    }

    public void setShangPinZhuangTai(Integer shangPinZhuangTai) {
        this.shangPinZhuangTai = shangPinZhuangTai;
    }

    @Basic
    @Column(name = "CaoZuoShiJian")
    public Timestamp getCaoZuoShiJian() {
        return caoZuoShiJian;
    }

    public void setCaoZuoShiJian(Timestamp caoZuoShiJian) {
        this.caoZuoShiJian = caoZuoShiJian;
    }

    @Basic
    @Column(name = "LeiXin")
    public String getLeiXin() {
        return leiXin;
    }

    public void setLeiXin(String leiXin) {
        this.leiXin = leiXin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShangpinxinxiEntity that = (ShangpinxinxiEntity) o;

        if (id != that.id) return false;
        if (shangPinJiaGe != that.shangPinJiaGe) return false;
        if (shangPinChengBen != that.shangPinChengBen) return false;
        if (shangPinBianHao != null ? !shangPinBianHao.equals(that.shangPinBianHao) : that.shangPinBianHao != null)
            return false;
        if (shangPinZuBianHao != null ? !shangPinZuBianHao.equals(that.shangPinZuBianHao) : that.shangPinZuBianHao != null)
            return false;
        if (shangPinMingChen != null ? !shangPinMingChen.equals(that.shangPinMingChen) : that.shangPinMingChen != null)
            return false;
        if (shangPinLeiXin != null ? !shangPinLeiXin.equals(that.shangPinLeiXin) : that.shangPinLeiXin != null)
            return false;
        if (shangPinGuiGe1 != null ? !shangPinGuiGe1.equals(that.shangPinGuiGe1) : that.shangPinGuiGe1 != null)
            return false;
        if (shangPinGuiGe2 != null ? !shangPinGuiGe2.equals(that.shangPinGuiGe2) : that.shangPinGuiGe2 != null)
            return false;
        if (pinPai != null ? !pinPai.equals(that.pinPai) : that.pinPai != null) return false;
        if (shangPinMiaoSu != null ? !shangPinMiaoSu.equals(that.shangPinMiaoSu) : that.shangPinMiaoSu != null)
            return false;
        if (yueXiaoLiang != null ? !yueXiaoLiang.equals(that.yueXiaoLiang) : that.yueXiaoLiang != null) return false;
        if (zongXiaoLiang != null ? !zongXiaoLiang.equals(that.zongXiaoLiang) : that.zongXiaoLiang != null)
            return false;
        if (shangPinZhuangTai != null ? !shangPinZhuangTai.equals(that.shangPinZhuangTai) : that.shangPinZhuangTai != null)
            return false;
        if (caoZuoShiJian != null ? !caoZuoShiJian.equals(that.caoZuoShiJian) : that.caoZuoShiJian != null)
            return false;
        if (leiXin != null ? !leiXin.equals(that.leiXin) : that.leiXin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (shangPinBianHao != null ? shangPinBianHao.hashCode() : 0);
        result = 31 * result + (shangPinZuBianHao != null ? shangPinZuBianHao.hashCode() : 0);
        result = 31 * result + (shangPinMingChen != null ? shangPinMingChen.hashCode() : 0);
        result = 31 * result + (shangPinLeiXin != null ? shangPinLeiXin.hashCode() : 0);
        result = 31 * result + (shangPinGuiGe1 != null ? shangPinGuiGe1.hashCode() : 0);
        result = 31 * result + (shangPinGuiGe2 != null ? shangPinGuiGe2.hashCode() : 0);
        result = 31 * result + (pinPai != null ? pinPai.hashCode() : 0);
        result = 31 * result + shangPinJiaGe;
        result = 31 * result + shangPinChengBen;
        result = 31 * result + (shangPinMiaoSu != null ? shangPinMiaoSu.hashCode() : 0);
        result = 31 * result + (yueXiaoLiang != null ? yueXiaoLiang.hashCode() : 0);
        result = 31 * result + (zongXiaoLiang != null ? zongXiaoLiang.hashCode() : 0);
        result = 31 * result + (shangPinZhuangTai != null ? shangPinZhuangTai.hashCode() : 0);
        result = 31 * result + (caoZuoShiJian != null ? caoZuoShiJian.hashCode() : 0);
        result = 31 * result + (leiXin != null ? leiXin.hashCode() : 0);
        return result;
    }
}
