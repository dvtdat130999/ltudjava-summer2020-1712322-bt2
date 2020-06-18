package DTO;

import DAO.Lop_MonHocDAO;
import DAO.MonHocDAO;
import DAO.PhucKhaoSinhVienDAO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "phuckhaosinhvien", catalog = "studentmanagement")
@IdClass(IDPhucKhaoSinhVien.class)
public class PhucKhaoSinhVien {
    @Id
    @Column(name = "mssv",  nullable = false)
    int mssv;

    @Column(name = "hoTen",  nullable = false)
    String hoTen;

    @Id
    @Column(name = "mon",  nullable = false)
    String mon;

    @Id
    @Column(name = "cotDiem",  nullable = false)
    int cotDiem;

    @Column(name = "diemMongMuon",  nullable = false)
    double diemMongMuon;

    @Column(name = "lyDo")
    String lyDo;

    @Column(name = "tinhTrang")
    String tinhTrang;
    public PhucKhaoSinhVien() {
    }

    public PhucKhaoSinhVien(int mssv, String hoTen, String mon,
                            int cotDiem, double diemMongMuon, String lyDo,String tinhTrang) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.mon = mon;
        this.cotDiem = cotDiem;
        this.diemMongMuon = diemMongMuon;
        this.lyDo = lyDo;
        this.tinhTrang=tinhTrang;
    }


    public int getMssv() {
        return mssv;
    }

    public void setMssv(int mssv) {
        this.mssv = mssv;
    }




    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getCotDiem() {
        return cotDiem;
    }

    public void setCotDiem(int cotDiem) {
        this.cotDiem = cotDiem;
    }


    public double getDiemMongMuon() {
        return diemMongMuon;
    }

    public void setDiemMongMuon(double diemMongMuon) {
        this.diemMongMuon = diemMongMuon;
    }


    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public static PhucKhaoSinhVien searchByMssvMonCotDiem(int mssv,String mon,int cotDiem)
    {
        List<PhucKhaoSinhVien>listPk= PhucKhaoSinhVienDAO.listPhucKhaoSinhVien();
        PhucKhaoSinhVien res=new PhucKhaoSinhVien();
        for(PhucKhaoSinhVien a:listPk)
        {
            if(Util.Util.stringCompare(a.getMon(),mon)==0 && a.getMssv()==mssv && a.getCotDiem()==cotDiem)
            {
                res=a;
                break;
            }
        }
        return res;
    }
}
