package DTO;

import java.util.ArrayList;

public class ThoiKhoaBieu {
    private String lop;
    private String phong;
    private ArrayList<MonHoc> mon;

    public ThoiKhoaBieu(String lop, String phong) {
        this.lop = lop;
        this.phong = phong;
        this.mon = new ArrayList<>();
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public ArrayList<MonHoc> getMon() {
        return mon;
    }

    public void setMon(ArrayList<MonHoc> mon) {
        this.mon = mon;
    }
}
