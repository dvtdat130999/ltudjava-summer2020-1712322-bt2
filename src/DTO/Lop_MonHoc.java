package DTO;

import java.util.ArrayList;

public class Lop_MonHoc {
    private String lop;
    private String maMon;
    private ArrayList<SinhVien> sinhvien;

    public Lop_MonHoc(String lop, String maMon) {
        this.lop = lop;
        this.maMon = maMon;
        this.sinhvien = new ArrayList<>();
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public ArrayList<SinhVien> getSinhvien() {
        return sinhvien;
    }

    public void setSinhvien(ArrayList<SinhVien> sinhvien) {
        this.sinhvien = sinhvien;
    }
}
