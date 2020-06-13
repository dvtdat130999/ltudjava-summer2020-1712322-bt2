package Demo;

import DAO.LopDAO;
import DTO.*;

import DAO.*;
import Util.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo {
    public static void main(String[] args) throws IOException {
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
        /*Lop a=ImportCSV.ReadCsvFile("lop1.csv");
        System.out.println("Lop: "+a.getTenLop());
        List<SinhVien>sv=a.getSinhVien();
        for(SinhVien s: sv)
        {
            System.out.println("MSSV: "+s.getMssv());
            System.out.println("Họ và tên: "+s.getHoTen());
            System.out.println("Gioi tinh: "+s.getGioiTinh());
            System.out.println("CMND: "+s.getCmnd());
        }*/

        //chuc nang 1
        /*Lop a=ImportCSVLop.ReadCsvFile("lop1.csv");
        LopDAO.addLop(a);*/

        //chuc nang 2
        /*Lop a=ImportCSV.ReadCsvFile("lop1.csv");
        SinhVien b=new SinhVien();
        b.setLop(a);
        b.setMssv(1742006);
        b.setHoTen("Trần Kiều X");
        b.setCmnd("987612345");
        b.setGioiTinh("Nữ");
        SinhVienDAO.addSinhVien(b);*/

        //import file lop_mon
        /*Lop_MonHoc lm=ImportCSVLopMon.ReadCsvFile("lop2_mon1.csv");
        System.out.println("Lop, mon, nam, hoc ky:"+lm.getLop()+", " +lm.getMaMon() +", "+lm.getNam()+ ", "+lm.getHocKy());
        for(SinhVien a:lm.getSinhvien())
        {
            System.out.println("Ma : "+a.getMssv());
            System.out.println("Ten : "+a.getHoTen());
            System.out.println("Gioi tinh: "+a.getGioiTinh());
            System.out.println("CMND: "+a.getCmnd());
            System.out.println("");
        }*/
        //chuc nang 3 chua duoc
       /* ThoiKhoaBieu tkb=ImportCSVTkb.ReadCsvFile("tkb1.csv");
        System.out.println("Lop, nam, hoc ky:"+tkb.getLop() +", "+tkb.getNam()+ ", "+tkb.getHocKy());
        for(MonHoc a:tkb.getMon())
        {
            System.out.println("Ma mon: "+a.getMa());
            System.out.println("Ten mon: "+a.getTen());
            System.out.println("Phong: "+a.getPhong());
            System.out.println("");
        }
        ThoiKhoaBieuDAO.addTkb(tkb);*/


        List<SinhVien> svs=SinhVien.listSinhVienLop("17HCB");
        for(SinhVien a:svs)
        {
            System.out.println("Ma : "+a.getMssv());
            System.out.println("Ten : "+a.getHoTen());
            System.out.println("Gioi tinh: "+a.getGioiTinh());
            System.out.println("CMND: "+a.getCmnd());
            System.out.println("");
        }

    }
}
