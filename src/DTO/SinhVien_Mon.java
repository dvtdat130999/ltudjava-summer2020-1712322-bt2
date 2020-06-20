package DTO;

import DAO.SinhVien_MonDAO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sinhvien_mon", catalog = "studentmanagement")
@IdClass(IDSinhVien_Mon.class)
public class SinhVien_Mon {
    @Id
    @Column(name = "mssv", nullable = false)
    private int mssv;

    @Id
    @Column(name = "maMon", nullable = false)
    private String maMon;

    @Column(name = "tenLop")
    private String tenLop;
    public SinhVien_Mon() {
        mssv=0;
        maMon=tenLop="";
    }

    public SinhVien_Mon(int mssv, String maMon,String tenLop) {
        this.mssv = mssv;
        this.maMon = maMon;
        this.tenLop=tenLop;
    }

    public int getMssv() {
        return mssv;
    }

    public void setMssv(int mssv) {
        this.mssv = mssv;
    }


    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public static SinhVien_Mon searchByMssvMaMon(int mssv,String maMon)
    {
        List<SinhVien_Mon>list= SinhVien_MonDAO.listSinhVienMon();
        SinhVien_Mon res=new SinhVien_Mon();
        for(SinhVien_Mon a:list)
        {
            if(Util.Util.stringCompare(a.getMaMon(),maMon)==0 && a.getMssv()==mssv)
            {
                res=a;
            }
        }
        return res;
    }

    public static List listMonHocSinhVienTheoNamHocKy(int mssv,String nam,int hocKy)
    {
        //tim cac mon hoc theo nam, hoc ky
        List<MonHoc>listMon=MonHoc.searchByNamHocKy(nam,hocKy);

        //lay cac ma mon cua cac mon hoc vua tim duoc
        List<String>maMon=new ArrayList<>();
        for(MonHoc a:listMon)
        {
            if(maMon.contains(a.getMa())==false)
            {
                maMon.add(a.getMa());

            }
            else
            {

            }
        }

        //lấy từ bảng sinhvien-mon ta được các mã môn của các môn sinh viên theo học trong học kỳ
        List<SinhVien_Mon>sinhVien_mons=new ArrayList<>();

        for(String mon:maMon)
        {
            SinhVien_Mon sinhVien_mon=SinhVien_Mon.searchByMssvMaMon(mssv,mon);
            if(sinhVien_mon.getMssv()!=0)
            {
                sinhVien_mons.add(sinhVien_mon);

            }
        }
        return sinhVien_mons;
    }
}
