package DTO;

import DAO.Lop_MonHocDAO;
import DAO.SinhVienDAO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "lop_mon", catalog = "studentmanagement")
@IdClass(IDLop_MonHoc.class)
public class Lop_MonHoc  {
    @Id
    @Column(name = "tenLop", nullable = false)
    private String tenLop;

    @Id
    @Column(name = "maMon", nullable = false)
    private String maMon;

    public Lop_MonHoc() {
        tenLop=maMon="";
    }

    public Lop_MonHoc(String tenLop, String maMon) {
        this.tenLop = tenLop;
        this.maMon = maMon;
    }


    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }


    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }



}
