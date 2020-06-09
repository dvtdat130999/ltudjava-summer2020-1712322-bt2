
package DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "mon", catalog = "studentmanagement")
public class MonHoc {
    @Id
    @Column(name = "ma", unique = true, nullable = false)
    private String ma;

    @Column(name = "ten")
    private String ten;

    public MonHoc(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

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

