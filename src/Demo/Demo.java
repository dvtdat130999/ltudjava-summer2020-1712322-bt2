package Demo;

import Controller.*;
import DAO.LopDAO;
import DTO.*;

import DAO.*;
import Util.Util;
import View.LopView;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class Demo {
    private static boolean isLogin=false;

    public static void main(String[] args) throws IOException, ParseException {


        //yeu cau 1
        /*Lop a=ImportCSVLop.ReadCsvFile("lop2.csv");
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

        /*ThoiKhoaBieu tkb=ImportCSVTkb.ReadCsvFile("tkb1.csv");
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


        //add mon hoc cua tung sinh vien vao database
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


        //yeu cau 4
        //Xoa bo 1 mon hoc cua sinh vien, them vao 1 sinh vien
        /*SinhVien_Mon sm1=new SinhVien_Mon(1742005,"CTT001","18HCB");
        SinhVien_MonDAO.addSinhVienMon(sm1);
        SinhVien_Mon sm2=new SinhVien_Mon(1842001,"CTT001","18HCB");
        SinhVien_MonDAO.deleteSinhVienMon(sm2);*/

        //yeu cau 5

        //xem danh sach sinh vien trong lop

/*
        LopController.createGUI();
*/
        /*List<MonHoc>list=MonHocDAO.listMonHoc();
        for(MonHoc a:list)
        {
            System.out.println("Ma: "+a.getMa());
            System.out.println("Ten: "+a.getTen());
            System.out.println("Phong: "+a.getPhong());
            System.out.println("Nam: "+a.getNam());
            System.out.println("Hoc ky: "+a.getHocKy());

        }*/
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
/*
        ThoiKhoaBieuController.createGUI();
*/
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
/*
        BangDiemController.createGUI();
*/
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
        /*String lop="18HCB";
        String mon="CTT001";
        String nam="2019-2020";
        int hocKy=1;*/
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
        //yeu cau 9
        /*List<SinhVien> test=SinhVienDAO.searchSinhVienByTen("Hồ Thị E");
        Demo.printSinhVien(test.get(0));*/
        /*DiemSinhVienDAO.updateDiemSinhVien("18HCB","CTT001",
                                    "2019-2020",1,1742005);*/

       /* DiemSinhVien a=DiemSinhVien.DiemMotSinhVienMotLop("18HCB","CTT001",
                "2019-2020",1,1742005);*/
/*
        Demo.printDiemSinhVien(a);
*/
        /*DiemSinhVienDAO.updateDiemSinhVien(a);*/

        //yeu cau 10
/*
        SinhVienXemDiemController.createGUI(new NguoiDung("1742005","1742005"));
*/
        //yeu cau 11
        //giao vu
        /*NguoiDung nd=new NguoiDung("giaovu","giaovu");
        NguoiDungDAO.addNguoiDung(nd);*/

        //dang nhap
/*
        DangNhapController.createGUI();
*/
        /*NguoiDung a=Demo.nhapTaiKhoanVaMatKhau();
        Demo.DangNhap(a);*/
/*
        DangNhapController.createGUI();
*/
        //yeu cau 12
        //doi mat khau
/*
        DoiMatKhauController.createGUI();
*/
/*
        Demo.DoiMatKhau();
*/
        //yeu cau 13
        //tao phuc khao diem
        /*PhucKhaoDiem pkd=Demo.taoPhucKhaoDiem();
        PhucKhaoDiemDAO.addPhucKhaoDiem(pkd);*/


        //yeu cau 14,15
        /*PhucKhaoSinhVien pksv=Demo.taoPhucKhaoSinhVien();
        PhucKhaoSinhVienDAO.addPhucKhaoSinhVien(pksv);*/

        /*List<PhucKhaoDiem> test1=PhucKhaoDiemDAO.listPhucKhaoDiem();
        List<PhucKhaoSinhVien>test=PhucKhaoSinhVien.giuaHaiNgay(test1.get(0).getNgayBatDau(),test1.get(0).getNgayKetThuc());
        for(PhucKhaoSinhVien a:test)
        {
            printPhucKhaoSinhVien(a);
        }*/




        DangNhapController.createGUI();


    }

    public static PhucKhaoDiem taoPhucKhaoDiem() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");


        System.out.println("Ngày bắt đầu:");

        System.out.print("Ngày:");
        Scanner sc=new Scanner(System.in);
        String ngay=sc.nextLine();
        System.out.print("Tháng:");
        String thang=sc.nextLine();
        System.out.print("Năm:");
        String nam=sc.nextLine();

        String firstDate=ngay+"-"+thang+"-"+nam;
        Date date1=sdf.parse(firstDate);
        System.out.println("Ngày kết thúc:");

        System.out.print("Ngày:");
        ngay=sc.nextLine();
        System.out.print("Tháng:");
        thang=sc.nextLine();
        System.out.print("Năm:");
        nam=sc.nextLine();
        String secondDate=ngay+"-"+thang+"-"+nam;

        Date date2=sdf.parse(secondDate);
        PhucKhaoDiem pkd=new PhucKhaoDiem(date1,date2);
        return pkd;
    }

    public static PhucKhaoSinhVien taoPhucKhaoSinhVien()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập thông tin phúc khảo:");
        System.out.println("MSSV:");
        int mssv=sc.nextInt();
        sc.nextLine();

        System.out.println("Họ tên:");
        String hoTen=sc.nextLine();
        System.out.println("Môn:");
        String mon=sc.nextLine();
        System.out.println("Cột điểm cần phúc khảo, 1 cho giữa kỳ, 2 cho cuối kỳ" +
                            ", 3 cho điểm khác, 4 cho điểm tổng:");
        int cot=sc.nextInt();

        System.out.println("Điểm mong muốn:");
        double diemMongMuon=sc.nextDouble();
        sc.nextLine();

        System.out.println("Lý do, rõ ràng cụ thể:");
        String lyDo=sc.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
        Date today=new Date();
        PhucKhaoSinhVien pksv=new PhucKhaoSinhVien(mssv,hoTen,mon,cot,diemMongMuon,lyDo,"Chưa xem",today);
        return pksv;



    }

    public static void printPhucKhaoSinhVien(PhucKhaoSinhVien a)
    {
        System.out.println("MSSV: "+a.getMssv());
        System.out.println("Họ tên: "+a.getHoTen());
        System.out.println("Môn: "+a.getMon());
        String cot=null;
        if(a.getCotDiem()==1)
        {
            cot="Điểm giữa kỳ";

        }
        if(a.getCotDiem()==2)
        {
            cot="Điểm cuối kỳ";

        }
        if(a.getCotDiem()==3)
        {
            cot="Điểm khác";

        }
        if(a.getCotDiem()==4)
        {
            cot="Điểm tổng";

        }


        System.out.println("Cột điểm: "+cot);
        System.out.println("Điểm mong muốn: "+a.getDiemMongMuon());
        System.out.println("Lý do: "+a.getLyDo());
        System.out.println("Tình trạng: "+a.getTinhTrang());

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        System.out.println("Ngày phúc khảo: "+df.format(a.getNgayPhucKhao()));
        System.out.println();
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
