package DTO;

import DAO.NguoiDungDAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "nguoidung", catalog = "studentmanagement")
public class NguoiDung {
    private String taiKhoan;
    private String matKhau;

    public NguoiDung() {
        taiKhoan=matKhau="";
    }

    public NguoiDung(String taiKhoan, String matKhau) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    @Id
    @Column(name = "taiKhoan", unique = true, nullable = false)
    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    @Column(name = "matKhau", nullable = false)
    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public static boolean checkNguoiDung(String taiKhoan,String matKhau)
    {
        List<NguoiDung> nguoiDungList= NguoiDungDAO.listNguoiDung();
        for(NguoiDung a: nguoiDungList)
        {
            if(Util.Util.stringCompare(a.getTaiKhoan(),taiKhoan)==0
                && Util.Util.stringCompare(a.getMatKhau(),matKhau)==0)
            {
                return true;
            }
        }
        return false;
    }

}
