package DTO;

import DAO.LopDAO;
import DAO.MonHocDAO;
import DAO.SinhVienDAO;
import DAO.SinhVien_MonDAO;
import Util.Util;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
        mssv=0;
        hoTen=gioiTinh=cmnd="";
        lop=null;
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

    public static List listSinhVienLop(String tenLop) {

        List <SinhVien>list= SinhVienDAO.listSinhVien();

        List<SinhVien> result= new ArrayList<SinhVien>();
        for(int i=0;i<list.size();i++)
        {
            if(Util.stringCompare(list.get(i).getLop().getTenLop(),tenLop)==0)
            {
                result.add(list.get(i));
            }
        }
        return result;
    }

    public static List listSinhVienLopMon(String tenLop,String maMon)
    {
        List <SinhVien_Mon>svm= SinhVien_MonDAO.listSinhVienMon();
        List<SinhVien> result= new ArrayList<SinhVien>();
        for(int i=0;i<svm.size();i++)
        {
            int mssv= svm.get(i).getMssv();
            String mon=svm.get(i).getMaMon();
            String lop=svm.get(i).getTenLop();
            SinhVien sv= SinhVienDAO.searchSinhVien(mssv);
            if(Util.stringCompare(mon,maMon)==0&&Util.stringCompare(tenLop,lop)==0 )
            {
                result.add(sv);
            }
        }
        return result;

    }


}

