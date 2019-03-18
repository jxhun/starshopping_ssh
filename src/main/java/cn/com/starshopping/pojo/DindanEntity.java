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
@Table(name = "dindan", schema = "starshopping", catalog = "")
public class DindanEntity {
    private int id;
    private String dingDanBianHao;
    private String yongHuMing;
    private String shangPinXinXi;
    private String wuLiuDanHao;
    private Integer dingDanZongE;
    private Timestamp dingDanShiJian;
    private Integer dingDanZhuangTai;
    private String shouHuoDiZhi;

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
    @Column(name = "DingDanBianHao")
    public String getDingDanBianHao() {
        return dingDanBianHao;
    }

    public void setDingDanBianHao(String dingDanBianHao) {
        this.dingDanBianHao = dingDanBianHao;
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
    @Column(name = "ShangPinXinXi")
    public String getShangPinXinXi() {
        return shangPinXinXi;
    }

    public void setShangPinXinXi(String shangPinXinXi) {
        this.shangPinXinXi = shangPinXinXi;
    }

    @Basic
    @Column(name = "WuLiuDanHao")
    public String getWuLiuDanHao() {
        return wuLiuDanHao;
    }

    public void setWuLiuDanHao(String wuLiuDanHao) {
        this.wuLiuDanHao = wuLiuDanHao;
    }

    @Basic
    @Column(name = "DingDanZongE")
    public Integer getDingDanZongE() {
        return dingDanZongE;
    }

    public void setDingDanZongE(Integer dingDanZongE) {
        this.dingDanZongE = dingDanZongE;
    }

    @Basic
    @Column(name = "DingDanShiJian")
    public Timestamp getDingDanShiJian() {
        return dingDanShiJian;
    }

    public void setDingDanShiJian(Timestamp dingDanShiJian) {
        this.dingDanShiJian = dingDanShiJian;
    }

    @Basic
    @Column(name = "DingDanZhuangTai")
    public Integer getDingDanZhuangTai() {
        return dingDanZhuangTai;
    }

    public void setDingDanZhuangTai(Integer dingDanZhuangTai) {
        this.dingDanZhuangTai = dingDanZhuangTai;
    }

    @Basic
    @Column(name = "ShouHuoDiZhi")
    public String getShouHuoDiZhi() {
        return shouHuoDiZhi;
    }

    public void setShouHuoDiZhi(String shouHuoDiZhi) {
        this.shouHuoDiZhi = shouHuoDiZhi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DindanEntity that = (DindanEntity) o;

        if (id != that.id) return false;
        if (dingDanBianHao != null ? !dingDanBianHao.equals(that.dingDanBianHao) : that.dingDanBianHao != null)
            return false;
        if (yongHuMing != null ? !yongHuMing.equals(that.yongHuMing) : that.yongHuMing != null) return false;
        if (shangPinXinXi != null ? !shangPinXinXi.equals(that.shangPinXinXi) : that.shangPinXinXi != null)
            return false;
        if (wuLiuDanHao != null ? !wuLiuDanHao.equals(that.wuLiuDanHao) : that.wuLiuDanHao != null) return false;
        if (dingDanZongE != null ? !dingDanZongE.equals(that.dingDanZongE) : that.dingDanZongE != null) return false;
        if (dingDanShiJian != null ? !dingDanShiJian.equals(that.dingDanShiJian) : that.dingDanShiJian != null)
            return false;
        if (dingDanZhuangTai != null ? !dingDanZhuangTai.equals(that.dingDanZhuangTai) : that.dingDanZhuangTai != null)
            return false;
        if (shouHuoDiZhi != null ? !shouHuoDiZhi.equals(that.shouHuoDiZhi) : that.shouHuoDiZhi != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dingDanBianHao != null ? dingDanBianHao.hashCode() : 0);
        result = 31 * result + (yongHuMing != null ? yongHuMing.hashCode() : 0);
        result = 31 * result + (shangPinXinXi != null ? shangPinXinXi.hashCode() : 0);
        result = 31 * result + (wuLiuDanHao != null ? wuLiuDanHao.hashCode() : 0);
        result = 31 * result + (dingDanZongE != null ? dingDanZongE.hashCode() : 0);
        result = 31 * result + (dingDanShiJian != null ? dingDanShiJian.hashCode() : 0);
        result = 31 * result + (dingDanZhuangTai != null ? dingDanZhuangTai.hashCode() : 0);
        result = 31 * result + (shouHuoDiZhi != null ? shouHuoDiZhi.hashCode() : 0);
        return result;
    }
}
