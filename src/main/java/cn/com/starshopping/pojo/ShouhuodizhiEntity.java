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
@Table(name = "shouhuodizhi", schema = "starshopping", catalog = "")
public class ShouhuodizhiEntity {
    private int id;
    private String yongHuMing;
    private String shouHuoRen;
    private String suoZaiDiQu;
    private String xiangXiDiZhi;
    private String youBian;
    private String lianXiDianHua;
    private int zhuangtai;

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
    @Column(name = "ShouHuoRen")
    public String getShouHuoRen() {
        return shouHuoRen;
    }

    public void setShouHuoRen(String shouHuoRen) {
        this.shouHuoRen = shouHuoRen;
    }

    @Basic
    @Column(name = "SuoZaiDiQu")
    public String getSuoZaiDiQu() {
        return suoZaiDiQu;
    }

    public void setSuoZaiDiQu(String suoZaiDiQu) {
        this.suoZaiDiQu = suoZaiDiQu;
    }

    @Basic
    @Column(name = "XiangXiDiZhi")
    public String getXiangXiDiZhi() {
        return xiangXiDiZhi;
    }

    public void setXiangXiDiZhi(String xiangXiDiZhi) {
        this.xiangXiDiZhi = xiangXiDiZhi;
    }

    @Basic
    @Column(name = "YouBian")
    public String getYouBian() {
        return youBian;
    }

    public void setYouBian(String youBian) {
        this.youBian = youBian;
    }

    @Basic
    @Column(name = "LianXiDianHua")
    public String getLianXiDianHua() {
        return lianXiDianHua;
    }

    public void setLianXiDianHua(String lianXiDianHua) {
        this.lianXiDianHua = lianXiDianHua;
    }

    @Basic
    @Column(name = "zhuangtai")
    public int getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(int zhuangtai) {
        this.zhuangtai = zhuangtai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShouhuodizhiEntity that = (ShouhuodizhiEntity) o;

        if (id != that.id) return false;
        if (zhuangtai != that.zhuangtai) return false;
        if (yongHuMing != null ? !yongHuMing.equals(that.yongHuMing) : that.yongHuMing != null) return false;
        if (shouHuoRen != null ? !shouHuoRen.equals(that.shouHuoRen) : that.shouHuoRen != null) return false;
        if (suoZaiDiQu != null ? !suoZaiDiQu.equals(that.suoZaiDiQu) : that.suoZaiDiQu != null) return false;
        if (xiangXiDiZhi != null ? !xiangXiDiZhi.equals(that.xiangXiDiZhi) : that.xiangXiDiZhi != null) return false;
        if (youBian != null ? !youBian.equals(that.youBian) : that.youBian != null) return false;
        if (lianXiDianHua != null ? !lianXiDianHua.equals(that.lianXiDianHua) : that.lianXiDianHua != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (yongHuMing != null ? yongHuMing.hashCode() : 0);
        result = 31 * result + (shouHuoRen != null ? shouHuoRen.hashCode() : 0);
        result = 31 * result + (suoZaiDiQu != null ? suoZaiDiQu.hashCode() : 0);
        result = 31 * result + (xiangXiDiZhi != null ? xiangXiDiZhi.hashCode() : 0);
        result = 31 * result + (youBian != null ? youBian.hashCode() : 0);
        result = 31 * result + (lianXiDianHua != null ? lianXiDianHua.hashCode() : 0);
        result = 31 * result + zhuangtai;
        return result;
    }
}
