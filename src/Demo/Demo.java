package Demo;

import DAO.LopDAO;
import DTO.*;

import DAO.*;
import Util.Util;

import java.io.IOException;
import java.util.*;

public class Demo {
    private static boolean isLogin=false;

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
        /*Lop a=ImportCSVLop.ReadCsvFile("lop1.csv");
        LopDAO.addLop(a);
        List<SinhVien>sv=SinhVien.listSinhVienLop(a.getTenLop());
        for(SinhVien b:sv)
        {
            NguoiDung res=new NguoiDung(String.valueOf(b.getMssv()),String.valueOf(b.getMssv()));
            NguoiDungDAO.addNguoiDung(res);
        }*/

        //yeu cau 2
        /*Lop a=ImportCSVLop.ReadCsvFile("lop1.csv");
        SinhVien b=new SinhVien();
        b.setLop(a);
        b.setMssv(1742006);
        b.setHoTen("Trần Kiều X");
        b.setCmnd("987612345");
        b.setGioiTinh("Nữ");
        SinhVienDAO.addSinhVien(b);
        NguoiDung res=new NguoiDung(String.valueOf(b.getMssv()),String.valueOf(b.getMssv()));
        NguoiDungDAO.addNguoiDung(res);*/





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
            System.out.println("Mã : "+a.getMssv());
            System.out.println("Tên : "+a.getHoTen());
            System.out.println("Giới tính: "+a.getGioiTinh());
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
            System.out.println("Mã : "+a.getMssv());
            System.out.println("Tên : "+a.getHoTen());
            System.out.println("Giới tính: "+a.getGioiTinh());
            System.out.println("CMND: "+a.getCmnd());
            System.out.println("");
        }*/


        //xem danh sach sinh vien theo lop-mon
        /*List<SinhVien>sv2=SinhVien.listSinhVienLopMon("18HCB","CTT001");
        for(SinhVien a:sv2)
        {
            System.out.println("Mã : "+a.getMssv());
            System.out.println("Tên : "+a.getHoTen());
            System.out.println("Giới tính: "+a.getGioiTinh());
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
            System.out.println("Mã môn: "+a.getMa());
            System.out.println("Tên môn: "+a.getTen());
            System.out.println("Phòng: "+a.getPhong());
            System.out.println("");
        }*/

        //yeu cau 7

        /*List<DiemSinhVien>dsv=ImportCSVDiem.ReadCsvFile("diem_lop2_mon1.csv");

        String lop=dsv.get(0).getLop();
        String mon=dsv.get(0).getMaMon();
        String nam=dsv.get(0).getNam();
        int hocKy=dsv.get(0).getHocKy();
        System.out.println("Lop, mon, nam, hoc ky:"+lop+", "+mon+", "+nam+", "+hocKy);
        System.out.println();
        for(DiemSinhVien a:dsv)
        {
            Demo.printDiemSinhVien(a);


        }

        //add diem sinh vien vao database
        for(DiemSinhVien a:dsv)
        {
            DiemSinhVienDAO.addDiemSinhVien(a);
        }*/

        //yeu cau 8
        //xem lai bang diem theo lop, mon, hoc ky, nam

        /*String lop="18HCB";
        String mon="CTT001";
        String nam="2019-2020";
        int hocKy=1;
        List<DiemSinhVien>dsv=DiemSinhVien.listDiemSinhVien(lop,mon,nam,hocKy);

        for(DiemSinhVien a:dsv)
        {
            Demo.printDiemSinhVien(a);


        }*/

        //cho biet ai dau, ai rot

        //xem tat ca sinh vien dau va rot nhu tren

        //xem cac sinh vien dau
        String lop="18HCB";
        String mon="CTT001";
        String nam="2019-2020";
        int hocKy=1;
        /*List<DiemSinhVien>dsv=DiemSinhVien.listSinhVienDau(lop,mon,nam,hocKy);
        for(DiemSinhVien a:dsv)
        {
                        Demo.printDiemSinhVien(a);


        }*/

        //xem cac sinh vien rot
        /*List<DiemSinhVien>dsv=DiemSinhVien.listSinhVienRot(lop,mon,nam,hocKy);
        for(DiemSinhVien a:dsv)
        {
            Demo.printDiemSinhVien(a);

        }*/

        //thong ke phan tram dau, phan tram rot
/*
        DiemSinhVien.thongKeDauRot(lop,mon,nam,hocKy);
*/

        //yeu cau 11
        //giao vu
        /*NguoiDung nd=new NguoiDung("giaovu","giaovu");
        NguoiDungDAO.addNguoiDung(nd);*/

        //dang nhap
        /*NguoiDung a=Demo.nhapTaiKhoanVaMatKhau();
        Demo.DangNhap(a);*/

        //doi mat khau
/*
        Demo.DoiMatKhau();
*/

    }

    public static void printSinhVien(SinhVien a)
    {
        System.out.println("MSSV: "+a.getMssv());
        System.out.println("Họ và tên: "+a.getHoTen());
        System.out.println("Gioi tinh: "+a.getGioiTinh());
        System.out.println("CMND: "+a.getCmnd());

        System.out.println();

    }
    public static void printDiemSinhVien(DiemSinhVien a)
    {
        System.out.println("Lớp: "+a.getLop());
        System.out.println("Môn: "+a.getMaMon());
        System.out.println("MSSV: "+a.getMssv());
        System.out.println("Họ tên: "+a.getHoTen());
        System.out.println("Điểm GK: "+a.getDiemGk());
        System.out.println("Điểm CK: "+a.getDiemCk());
        System.out.println("Điểm khác: "+a.getDiemKhac());
        System.out.println("Điểm tổng: "+a.getDiemTong());
        System.out.println("Kết quả: "+a.getKetQua());

        System.out.println();
    }

    public static NguoiDung nhapTaiKhoanVaMatKhau()
    {

        System.out.print("Tài khoản:");
        Scanner sc=new Scanner(System.in);
        String taikhoan=sc.nextLine();
        System.out.print("Mật khẩu:");
        String matkhau=sc.nextLine();
        NguoiDung res=new NguoiDung(taikhoan,matkhau);

        return res;
    }

    public static void DangNhap(NguoiDung a)
    {
        if(NguoiDungDAO.searchNguoiDung(a.getTaiKhoan(),a.getMatKhau()))
        {
            isLogin=true;
            System.out.print("Bạn đã đăng nhập thành công");

        }
        else
        {
            System.out.print("Sai tài khoản hoặc mật khẩu");

        }
    }
    public static void DangXuat()
    {
        isLogin=false;

    }

    public static void DoiMatKhau()
    {
        System.out.println("Đổi mật khẩu");
        System.out.println("");

        System.out.print("Tài khoản: ");
        Scanner sc=new Scanner(System.in);
        String taikhoan=sc.nextLine();
        System.out.print("Mật khẩu cũ: ");
        String matkhau=sc.nextLine();
        System.out.print("Mật khẩu mới: ");
        String matkhauMoi=sc.nextLine();
        if(NguoiDungDAO.searchNguoiDung(taikhoan,matkhau))
        {
            NguoiDungDAO.updateNguoiDung(taikhoan,matkhauMoi);
            System.out.print("Đổi mật khẩu thành công, hãy đăng nhập lại");

        }
        else {
            System.out.print("Tài khoản hoặc mật khẩu cũ nhập sai");

        }
    }
}
