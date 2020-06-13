package DTO;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "lop_mon", catalog = "studentmanagement")
public class Lop_MonHoc {
    private String tenLop;
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
