
package DTO;

import javax.persistence.*;


@Entity
@Table(name = "mon", catalog = "studentmanagement")
public class MonHoc {

    private String ma;
    private String ten;
    private String phong;
    private String nam;
    private int hocKy;

    public MonHoc()
    {
        ma=ten=phong=nam="";
        hocKy=0;
    }
    public MonHoc(String ma, String ten,String phong,String nam,int hocKy) {
        this.ma = ma;
        this.ten = ten;
        this.phong=phong;
        this.nam=nam;
        this.hocKy=hocKy;
    }

    @Id
    @Column(name = "ma", unique = true, nullable = false)
    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    @Column(name = "ten")
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Column(name = "phong")
    public String getPhong()
    {
        return phong;
    }

    public void setPhong(String phong)
    {
        this.phong=phong;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }
}

