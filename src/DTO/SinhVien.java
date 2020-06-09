package DTO;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import javax.persistence.*;

@Entity
@Table(name = "sinhvien", catalog = "studentmanagement")
public class SinhVien {

    private int mssv;

    private String hoTen;

    private String gioiTinh;

    private String cmnd;


    private Lop lop;

    public SinhVien()
    {

    }
    public SinhVien(int mssv, String hoTen, String gioiTinh, String cmnd, Lop lop) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.cmnd = cmnd;
        this.lop = lop;
    }

    @Id
    @Column(name = "mssv", unique = true, nullable = false)
    public int getMssv() {
        return mssv;
    }

    public void setMssv(int mssv) {
        this.mssv = mssv;
    }

    @Column(name = "hoTen")
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    @Column(name = "gioiTinh")
    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    @Column(name = "cmnd")
    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    @ManyToOne
    @JoinColumn(name="lop", nullable=false)
    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }
}

