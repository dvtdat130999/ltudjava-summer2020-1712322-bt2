package DTO;

import javax.persistence.*;

@Entity
@Table(name = "sinhvien_mon", catalog = "studentmanagement")
@IdClass(IDSinhVien_Mon.class)
public class SinhVien_Mon {
    @Id
    @Column(name = "mssv", nullable = false)
    private int mssv;

    @Id
    @Column(name = "maMon", nullable = false)
    private String maMon;

    @Column(name = "tenLop")
    private String tenLop;
    public SinhVien_Mon() {
        mssv=0;
        maMon=tenLop="";
    }

    public SinhVien_Mon(int mssv, String maMon,String tenLop) {
        this.mssv = mssv;
        this.maMon = maMon;
        this.tenLop=tenLop;
    }

    public int getMssv() {
        return mssv;
    }

    public void setMssv(int mssv) {
        this.mssv = mssv;
    }


    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }
}
