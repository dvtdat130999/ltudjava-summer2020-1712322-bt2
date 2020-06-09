package DTO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "lop", catalog = "studentmanagement")
public class Lop {

    private String tenLop;

    private List<SinhVien> sinhVien;

    public Lop()
    {
        tenLop=null;
    }
    public Lop(String tenLop) {
        this.tenLop = tenLop;
    }

    @Id
    @Column(name = "ten", nullable = false)
    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    @OneToMany(targetEntity=SinhVien.class,mappedBy = "lop",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public List<SinhVien> getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(List<SinhVien> sinhVien) {
        this.sinhVien = sinhVien;
    }

}
