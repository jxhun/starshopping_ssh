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
@Table(name = "leixingguigexinxibiao", schema = "starshopping", catalog = "")
public class LeixingguigexinxibiaoEntity {
    private int id;
    private String leiXing;
    private String guiGe1;
    private String guiGe2;
    private String daLeiXin;

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
    @Column(name = "LeiXing")
    public String getLeiXing() {
        return leiXing;
    }

    public void setLeiXing(String leiXing) {
        this.leiXing = leiXing;
    }

    @Basic
    @Column(name = "GuiGe1")
    public String getGuiGe1() {
        return guiGe1;
    }

    public void setGuiGe1(String guiGe1) {
        this.guiGe1 = guiGe1;
    }

    @Basic
    @Column(name = "GuiGe2")
    public String getGuiGe2() {
        return guiGe2;
    }

    public void setGuiGe2(String guiGe2) {
        this.guiGe2 = guiGe2;
    }

    @Basic
    @Column(name = "DaLeiXin")
    public String getDaLeiXin() {
        return daLeiXin;
    }

    public void setDaLeiXin(String daLeiXin) {
        this.daLeiXin = daLeiXin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeixingguigexinxibiaoEntity that = (LeixingguigexinxibiaoEntity) o;

        if (id != that.id) return false;
        if (leiXing != null ? !leiXing.equals(that.leiXing) : that.leiXing != null) return false;
        if (guiGe1 != null ? !guiGe1.equals(that.guiGe1) : that.guiGe1 != null) return false;
        if (guiGe2 != null ? !guiGe2.equals(that.guiGe2) : that.guiGe2 != null) return false;
        if (daLeiXin != null ? !daLeiXin.equals(that.daLeiXin) : that.daLeiXin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (leiXing != null ? leiXing.hashCode() : 0);
        result = 31 * result + (guiGe1 != null ? guiGe1.hashCode() : 0);
        result = 31 * result + (guiGe2 != null ? guiGe2.hashCode() : 0);
        result = 31 * result + (daLeiXin != null ? daLeiXin.hashCode() : 0);
        return result;
    }
}
