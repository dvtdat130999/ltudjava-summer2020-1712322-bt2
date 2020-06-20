
package DTO;

import DAO.DiemSinhVienDAO;
import DAO.Lop_MonHocDAO;
import DAO.MonHocDAO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "mon", catalog = "studentmanagement")
public class MonHoc {

    private String ma;
    private String ten;
    private String phong;
    private String nam;
    private int hocKy;

    public MonHoc()
    {
        ma=ten=phong=nam="";
        hocKy=0;
    }
    public MonHoc(String ma, String ten,String phong,String nam,int hocKy) {
        this.ma = ma;
        this.ten = ten;
        this.phong=phong;
        this.nam=nam;
        this.hocKy=hocKy;
    }

    @Id
    @Column(name = "ma", unique = true, nullable = false)
    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    @Column(name = "ten")
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Column(name = "phong")
    public String getPhong()
    {
        return phong;
    }

    public void setPhong(String phong)
    {
        this.phong=phong;
    }

    @Column(name = "nam")
    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }


    @Column(name = "hocKy")
    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }

    public static List searchByLop(String tenLop)
    {
        List<Lop_MonHoc>listLm= Lop_MonHocDAO.listLopMon();
        List<MonHoc>res=new ArrayList<>();
        for(Lop_MonHoc a:listLm)
        {
            if(Util.Util.stringCompare(a.getTenLop(),tenLop)==0)
            {
                MonHoc b= MonHocDAO.searchMon(a.getMaMon());
                res.add(b);
            }
        }
        return res;
    }

    public static List searchByNamHocKy(String nam,int hocKy)
    {
        List<MonHoc>monHocList=MonHocDAO.listMonHoc();
        List<MonHoc>res=new ArrayList<>();
        for(MonHoc a: monHocList)
        {
            if(Util.Util.stringCompare(nam,a.getNam())==0 && hocKy==a.getHocKy())
            {
                res.add(a);
            }
        }
        return res;
    }

    public static List listMonHoc(List<String>maMon)
    {
        List<MonHoc>res=new ArrayList<>();
        for(String ma:maMon)
        {
            MonHoc a=MonHocDAO.searchMon(ma);
            res.add(a);
        }
        return res;
    }
    public static List tkbSinhVien(String nam,int hocKy,int mssv)
    {
        //lấy các thông tin từ bảng sinhvien-mon những môn mà sinh viên học trong năm, học kỳ
        List<SinhVien_Mon>sinhVien_monList=SinhVien_Mon.listMonHocSinhVienTheoNamHocKy(mssv,nam,hocKy);

        //lấy các mã môn vừa kiếm được
        List<String>maMon2=new ArrayList<>();
        for(SinhVien_Mon a:sinhVien_monList)
        {
            maMon2.add(a.getMaMon());

        }

        //lấy ra thông tin các môn học từ các mã môn vừa kiếm được
        List<MonHoc>res=new ArrayList<>();
        res=listMonHoc(maMon2);


        return res;

    }

    public static List listNam()
    {
        List<MonHoc>monHocs= MonHocDAO.listMonHoc();
        List<String>nam=new ArrayList<>();
        for(MonHoc a:monHocs)
        {
            if(nam.contains(a.getNam())==false)
            {
                nam.add(a.getNam());
            }
        }
        return nam;
    }
    public static List listHocKy()
    {
        List<MonHoc>monHocs= MonHocDAO.listMonHoc();
        List<Integer>hocKy=new ArrayList<>();
        for(MonHoc a:monHocs)
        {
            if(hocKy.contains(a.getHocKy())==false)
            {
                hocKy.add(a.getHocKy());
            }
        }
        return hocKy;

    }
}

