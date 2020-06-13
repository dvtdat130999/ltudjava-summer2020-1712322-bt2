package DTO;


import DAO.DiemSinhVienDAO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "diem_sinhvien", catalog = "studentmanagement")
@IdClass(IDDiemSinhVien.class)
public class DiemSinhVien {
    @Id
    @Column(name = "maMon", nullable = false)
    private String maMon;

    @Id
    @Column(name = "mssv", nullable = false)
    private int mssv;

    @Column(name = "hoTen")
    private String hoTen;

    @Column(name = "diemGK")
    private double diemGk;

    @Column(name = "diemCk")
    private double diemCk;

    @Column(name = "diemKhac")
    private double diemKhac;

    @Column(name = "diemTong")
    private double diemTong;

    @Column(name = "tenLop")
    private String lop;

    @Column(name = "nam")
    private String nam;

    @Column(name = "hocKy")
    private int hocKy;

    @Column(name = "ketQua")
    private String ketQua;
    public DiemSinhVien() {
        mssv=hocKy=0;
        diemCk=diemGk=diemKhac=diemTong=0;
        hoTen=lop=maMon=nam="";
    }

    public int getMssv() {
        return mssv;
    }

    public void setMssv(int mssv) {
        this.mssv = mssv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
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

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }

    public void setKetQua(String ketQua)
    {
        this.ketQua=ketQua;
    }

    public String getKetQua()
    {
        return ketQua;
    }
    public static List listDiemSinhVien(String tenLop, String maMon,String nam,int hocKy)
    {
        List<DiemSinhVien>dsv= DiemSinhVienDAO.listDiemSinhVien();
        List<DiemSinhVien>res=new ArrayList<>();
        for(DiemSinhVien a:dsv)
        {
            if( Util.Util.stringCompare(a.getLop(),tenLop)==0
                    &&Util.Util.stringCompare(a.getMaMon(),maMon)==0
                    && Util.Util.stringCompare(a.getNam(),nam)==0 && a.getHocKy()==hocKy)
            {
                res.add(a);
            }
        }

        return res;
    }

    public static List listSinhVienDau(String tenLop, String maMon,String nam,int hocKy)
    {
        List<DiemSinhVien>dsv=listDiemSinhVien(tenLop,maMon,nam,hocKy);
        List<DiemSinhVien>res=new ArrayList<>();
        for(DiemSinhVien a:dsv)
        {
            if(Util.Util.stringCompare(a.getKetQua(),"Đậu")==0)
            {
                res.add(a);
            }
        }
        return res;

    }

    public static List listSinhVienRot(String tenLop, String maMon,String nam,int hocKy)
    {
        List<DiemSinhVien>dsv=listDiemSinhVien(tenLop,maMon,nam,hocKy);
        List<DiemSinhVien>res=new ArrayList<>();
        for(DiemSinhVien a:dsv)
        {
            if(Util.Util.stringCompare(a.getKetQua(),"Rớt")==0)
            {
                res.add(a);
            }
        }
        return res;

    }
    public static void thongKeDauRot(String tenLop, String maMon,String nam,int hocKy)
    {
        List<DiemSinhVien>dsv=listDiemSinhVien(tenLop,maMon,nam,hocKy);
        double countDau=0;
        double countRot=0;
        double phanTramDau=0;
        double phanTramRot=0;
        double count=dsv.size();
        for(DiemSinhVien a:dsv)
        {
            if(Util.Util.stringCompare(a.getKetQua(),"Đậu")==0)
            {
                countDau=countDau+1;
            }
            else
                countRot=countRot+1;
        }
        phanTramDau=countDau/count*100;
        phanTramRot=countRot/count*100;
        System.out.println("Lớp, môn, năm, học kỳ: "+tenLop+", "+maMon+", "+nam+", "+hocKy);
        System.out.println("Số lượng đậu: "+countDau);
        System.out.println("Phần trăm đậu: "+phanTramDau);
        System.out.println("Số lượng rớt: "+countRot);
        System.out.println("Phần trăm rớt: "+phanTramRot);

    }
}
