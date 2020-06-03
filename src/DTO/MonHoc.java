package DTO;

import javax.persistence.Column;
import javax.persistence.Id;

public class MonHoc {
    private String ma;
    private String ten;

    public MonHoc(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }
    @Id
    @Column(name = "mssv", unique = true, nullable = false)
    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
