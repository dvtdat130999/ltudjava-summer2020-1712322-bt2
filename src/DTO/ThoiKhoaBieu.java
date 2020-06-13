package DTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class ThoiKhoaBieu {
    private String lop;

    private List<MonHoc> mon;


    public ThoiKhoaBieu()
    {
        lop="";
        this.mon = new ArrayList<MonHoc>();

    }
    public ThoiKhoaBieu(String lop) {
        this.lop = lop;

        this.mon = new ArrayList<MonHoc>();
    }

    public List<MonHoc> getMon() {
        return mon;
    }

    public void setMon(List<MonHoc> mon) {
        this.mon = mon;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }










}
