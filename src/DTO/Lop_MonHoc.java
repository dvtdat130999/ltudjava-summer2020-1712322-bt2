package DTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Lop_MonHoc {
    private String lop;
    private String maMon;
    private Set<SinhVien> sinhvien;

    public Lop_MonHoc(String lop, String maMon) {
        this.lop = lop;
        this.maMon = maMon;
        this.sinhvien = new HashSet<SinhVien>();
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

    public Set<SinhVien> getSinhvien() {
        return sinhvien;
    }

    public void setSinhvien(Set<SinhVien> sinhvien) {
        this.sinhvien = sinhvien;
    }
}
