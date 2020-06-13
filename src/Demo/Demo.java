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

        //yeu cau 1
        /*Lop a=ImportCSVLop.ReadCsvFile("lop2.csv");
        LopDAO.addLop(a);*/

        //yeu cau 2
        /*Lop a=ImportCSV.ReadCsvFile("lop1.csv");
        SinhVien b=new SinhVien();
        b.setLop(a);
        b.setMssv(1742006);
        b.setHoTen("Trần Kiều X");
        b.setCmnd("987612345");
        b.setGioiTinh("Nữ");
        SinhVienDAO.addSinhVien(b);*/




        //yeu cau 3
        //import file thoi khoa bieu

        /*ThoiKhoaBieu tkb=ImportCSVTkb.ReadCsvFile("tkb2.csv");
        List<MonHoc>mon=tkb.getMon();

        //add mon hoc vao database
        for(MonHoc a:mon)
        {
            MonHocDAO.addMonHoc(a);
        }
        //add lop-mon vao database

        List<Lop_MonHoc> lm=new ArrayList<>();

        for(MonHoc a:mon)
        {
            Lop_MonHoc res=new Lop_MonHoc();
            res.setTenLop(tkb.getLop());
            res.setMaMon(a.getMa());
            lm.add(res);
        }
        for(Lop_MonHoc a:lm)
        {
            Lop_MonHocDAO.addLopMon(a);
        }


        List<SinhVien>sv=SinhVien.listSinhVienLop(tkb.getLop());
        for(SinhVien a: sv)
        {
            for(MonHoc b:mon)
            {
                SinhVien_Mon sm=new SinhVien_Mon();
                sm.setMssv(a.getMssv());
                sm.setMaMon(b.getMa());
                sm.setTenLop(tkb.getLop());
                SinhVien_MonDAO.addSinhVienMon(sm);
            }

        }*/





        //import file lop_mon
        /*SinhVien_Lop_Mon lm=ImportCSVLopMon.ReadCsvFile("lop2_mon1.csv");
        MonHoc lm_m=MonHocDAO.searchMonHoc(lm.getMaMon());
        System.out.println("Lop, mon, nam, hoc ky:"+lm.getTenLop()+", " +lm.getMaMon() +", "+lm_m.getNam()+","+lm_m.getHocKy());
        for(SinhVien a:lm.getSinhVien())
        {
            System.out.println("Ma : "+a.getMssv());
            System.out.println("Ten : "+a.getHoTen());
            System.out.println("Gioi tinh: "+a.getGioiTinh());
            System.out.println("CMND: "+a.getCmnd());
            System.out.println("");
        }*/
        /*SinhVien_Lop_Mon lm=ImportCSVLopMon.ReadCsvFile("lop2_mon1.csv");
        List<SinhVien>sv=lm.getSinhVien();*/

        //yeu cau 4
        //Xoa bo 1 mon hoc cua sinh vien, them vao 1 sinh vien
        /*SinhVien_Mon sm1=new SinhVien_Mon(1742005,"CTT001","18HCB");
        SinhVien_MonDAO.addSinhVienMon(sm1);*/
        /*SinhVien_Mon sm2=new SinhVien_Mon(1842001,"CTT001","18HCB");
        SinhVien_MonDAO.deleteSinhVienMon(sm2);*/

        //yeu cau 5

        //xem danh sach sinh vien trong lop
        /*List<SinhVien> sv=SinhVien.listSinhVienLop("18HCB");
        for(SinhVien a:sv)
        {
            System.out.println("Ma : "+a.getMssv());
            System.out.println("Ten : "+a.getHoTen());
            System.out.println("Gioi tinh: "+a.getGioiTinh());
            System.out.println("CMND: "+a.getCmnd());
            System.out.println("");
        }*/


        //xem danh sach sinh vien theo lop-mon
        /*List<SinhVien>sv2=SinhVien.listSinhVienLopMon("18HCB","CTT001");
        for(SinhVien a:sv2)
        {
            System.out.println("Ma : "+a.getMssv());
            System.out.println("Ten : "+a.getHoTen());
            System.out.println("Gioi tinh: "+a.getGioiTinh());
            System.out.println("CMND: "+a.getCmnd());
            System.out.println("");
        }*/

        //yeu cau 6

        //lay tkb tu database

        /*ThoiKhoaBieu test=new ThoiKhoaBieu();
        test.setLop("18HCB");
        List<MonHoc>mon=MonHoc.searchByLop(test.getLop());
        test.setMon(mon);

        System.out.println("Lop:"+test.getLop());
        for(MonHoc a:mon)
        {
            System.out.println("Ma mon: "+a.getMa());
            System.out.println("Ten mon: "+a.getTen());
            System.out.println("Phong: "+a.getPhong());
            System.out.println("");
        }*/





    }
}
