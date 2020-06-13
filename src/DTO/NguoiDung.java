package DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
