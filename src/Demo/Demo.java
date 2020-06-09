package Demo;

import DAO.LopDAO;
import DTO.Lop;
import DTO.SinhVien;

import DAO.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        /*List<Lop> listLop=LopDAO.listLop();
        for(Lop a: listLop)
        {
            System.out.println("Lop:" + a.getTenLop());
            System.out.println("");

            for(SinhVien b: a.getSinhVien())
            {
                System.out.println("MSSV: "+ b.getMssv());
                System.out.println("Ten: "+ b.getHoTen());
                System.out.println("Gioi tinh: "+ b.getGioiTinh());
                System.out.println("CMND: "+ b.getCmnd());

                System.out.println("");

            }
        }*/
        /*List<SinhVien> ds=SinhVienDAO.listSinhVien();
        for(int i=0; i<ds.size(); i++){
            SinhVien sv=ds.get(i);
            System.out.println("MSSV: "+sv.getMssv());
            System.out.println("Họ và tên: "+sv.getHoTen());
            System.out.println("Gioi tinh: "+sv.getGioiTinh());
            System.out.println("CMND: "+sv.getCmnd());

        }*/
        /*SinhVien check=SinhVienDAO.searchSinhVien(1712322);
        Lop lopCheck=check.getLop();
        SinhVien addnewsv=new SinhVien(1713333,"Khong co","Khong ro","0123123123",lopCheck);

        System.out.println("Lop: "+lopCheck.getTenLop());*/
        /*List listLop=LopDAO.listLop();
        for(int i=0;i<listLop.size();i++)
        {
            Lop a=(Lop)listLop.get(i);
            System.out.println("Lop: "+a.getTenLop());

        }*/

    }
}
