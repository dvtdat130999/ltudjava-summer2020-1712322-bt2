package DTO;

import DAO.Lop_MonHocDAO;
import DAO.MonHocDAO;
import DAO.PhucKhaoSinhVienDAO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
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

    @Column(name = "ngayPhucKhao",columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    Date ngayPhucKhao ;

    public PhucKhaoSinhVien() {
    }

    public PhucKhaoSinhVien(int mssv, String hoTen, String mon,
                            int cotDiem, double diemMongMuon, String lyDo,String tinhTrang,Date ngayPhucKhao) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.mon = mon;
        this.cotDiem = cotDiem;
        this.diemMongMuon = diemMongMuon;
        this.lyDo = lyDo;
        this.tinhTrang=tinhTrang;
        this.ngayPhucKhao=ngayPhucKhao;
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

    public Date getNgayPhucKhao() {
        return ngayPhucKhao;
    }

    public void setNgayPhucKhao(Date ngayPhucKhao) {
        this.ngayPhucKhao = ngayPhucKhao;
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

    public static PhucKhaoSinhVien searchByNgay(Date date1,Date date2)
    {
        List<PhucKhaoSinhVien>listPk= PhucKhaoSinhVienDAO.listPhucKhaoSinhVien();
        PhucKhaoSinhVien res=new PhucKhaoSinhVien();
        for(PhucKhaoSinhVien a:listPk)
        {
            if(a.getNgayPhucKhao().compareTo(date1)>=0
                && a.getNgayPhucKhao().compareTo(date2)<=0)
            {
                res=a;
                break;
            }
        }
        return res;
    }

    public static List giuaHaiNgay(Date date1,Date date2)
    {
        List<PhucKhaoSinhVien>listPk= PhucKhaoSinhVienDAO.listPhucKhaoSinhVien();
        List<PhucKhaoSinhVien> res=new ArrayList<>();
        for(PhucKhaoSinhVien a:listPk)
        {
            if(a.getNgayPhucKhao().compareTo(date1)>=0
                    && a.getNgayPhucKhao().compareTo(date2)<=0)
            {
                res.add(a);

            }
        }
        return res;
    }

    public static PhucKhaoSinhVien searchPhucKhao(int mssv,String tenMon,int cotDiem)
    {
        List<PhucKhaoSinhVien>list=PhucKhaoSinhVienDAO.listPhucKhaoSinhVien();
        PhucKhaoSinhVien res=null;
        for(PhucKhaoSinhVien a:list)
        {
            if(a.getMssv()==mssv && Util.Util.stringCompare(tenMon,a.getHoTen())==0 && cotDiem==a.getCotDiem())
            {
                res=a;
                break;

            }
        }
        return res;

    }
}
