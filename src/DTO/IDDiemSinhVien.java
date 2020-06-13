package DTO;

import java.io.Serializable;
import java.util.Objects;

public class IDDiemSinhVien implements Serializable {
    private String maMon;
    private int mssv;

    public IDDiemSinhVien() {

    }

    public IDDiemSinhVien(String maMon, int mssv) {
        this.maMon = maMon;
        this.mssv = mssv;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public int getMssv() {
        return mssv;
    }

    public void setMssv(int mssv) {
        this.mssv = mssv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IDDiemSinhVien)) return false;
        IDDiemSinhVien that = (IDDiemSinhVien) o;
        return getMssv() == that.getMssv() &&
                getMaMon().equals(that.getMaMon());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaMon(), getMssv());
    }
}
