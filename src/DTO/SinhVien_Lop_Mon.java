package DTO;

import java.util.List;

public class SinhVien_Lop_Mon {
    private String tenLop;
    private String maMon;
    private List<SinhVien> sinhVien;

    public SinhVien_Lop_Mon() {
    }

    public SinhVien_Lop_Mon(String tenLop, String maMon, List<SinhVien> sinhVien) {
        this.tenLop = tenLop;
        this.maMon = maMon;
        this.sinhVien = sinhVien;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public List<SinhVien> getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(List<SinhVien> sinhVien) {
        this.sinhVien = sinhVien;
    }
}
