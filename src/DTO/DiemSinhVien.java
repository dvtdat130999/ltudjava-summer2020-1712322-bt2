package DTO;

public class DiemSinhVien {
    private SinhVien sinhVien;
    private double diemGk;
    private double diemCk;
    private double diemKhac;
    private double diemTong;
    private String lop;
    private String maMon;

    public DiemSinhVien(SinhVien sinhVien, double diemGk, double diemCk, double diemKhac, double diemTong, String lop, String maMon) {
        this.sinhVien = sinhVien;
        this.diemGk = diemGk;
        this.diemCk = diemCk;
        this.diemKhac = diemKhac;
        this.diemTong = diemTong;
        this.lop = lop;
        this.maMon = maMon;
    }

    public SinhVien getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }

    public double getDiemGk() {
        return diemGk;
    }

    public void setDiemGk(double diemGk) {
        this.diemGk = diemGk;
    }

    public double getDiemCk() {
        return diemCk;
    }

    public void setDiemCk(double diemCk) {
        this.diemCk = diemCk;
    }

    public double getDiemKhac() {
        return diemKhac;
    }

    public void setDiemKhac(double diemKhac) {
        this.diemKhac = diemKhac;
    }

    public double getDiemTong() {
        return diemTong;
    }

    public void setDiemTong(double diemTong) {
        this.diemTong = diemTong;
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


}
