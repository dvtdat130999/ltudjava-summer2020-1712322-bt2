package DTO;

import java.io.Serializable;
import java.util.Objects;

public class IDPhucKhaoSinhVien implements Serializable {
    protected int mssv;
    protected String mon;
    protected int cotDiem;

    public IDPhucKhaoSinhVien() {
    }

    public IDPhucKhaoSinhVien(int mssv, String hoTen,int cotDiem) {
        this.mssv = mssv;
        this.mon = hoTen;
        this.cotDiem=cotDiem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IDPhucKhaoSinhVien)) return false;
        IDPhucKhaoSinhVien that = (IDPhucKhaoSinhVien) o;
        return mssv == that.mssv &&
                cotDiem == that.cotDiem &&
                Objects.equals(mon, that.mon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mssv, mon, cotDiem);
    }
}
