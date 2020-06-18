package DTO;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "phuckhaodiem", catalog = "studentmanagement")
public class PhucKhaoDiem {
    Date ngayBatDau ;
    Date ngayKetThuc;


    public PhucKhaoDiem() {
    }

    public PhucKhaoDiem(Date ngayBatDau, Date ngayKetThuc) {
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    @Id
    @Column(name = "startDate",unique = true,nullable = false, columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    @Column(name = "endDate",columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }


}
