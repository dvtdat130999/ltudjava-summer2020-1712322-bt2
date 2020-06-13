package DTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "thoikhoabieu", catalog = "studentmanagement")
public class ThoiKhoaBieu {
    private String lop;
    private String nam;
    private int hocKy;
    private List<MonHoc> mon;


    public ThoiKhoaBieu()
    {
        lop=nam="";
        hocKy=0;
        this.mon = new ArrayList<MonHoc>();

    }
    public ThoiKhoaBieu(String lop,String nam,int hocKy) {
        this.lop = lop;
        this.nam=nam;
        this.hocKy=hocKy;
        this.mon = new ArrayList<MonHoc>();
    }

    public List<MonHoc> getMon() {
        return mon;
    }

    public void setMon(List<MonHoc> mon) {
        this.mon = mon;
    }
    @Id
    @Column(name = "lop", unique = true, nullable = false)
    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    @Id
    @Column(name = "nam", nullable = false)
    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    @Id
    @Column(name = "hocKy", nullable = false)
    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }





}
