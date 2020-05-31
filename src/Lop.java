import java.util.ArrayList;

public class Lop {
    private String tenLop;
    private ArrayList<SinhVien> sinhVien;

    public Lop(String tenLop) {
        this.tenLop = tenLop;
        this.sinhVien = new ArrayList<>();
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public ArrayList<SinhVien> getSinhVien() {
        return sinhVien;
    }

    public void setSinhVien(ArrayList<SinhVien> sinhVien) {
        this.sinhVien = sinhVien;
    }

}
