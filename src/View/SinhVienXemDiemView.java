package View;

import Controller.*;
import DAO.LopDAO;
import DAO.MonHocDAO;
import DTO.DiemSinhVien;
import DTO.Lop;
import DTO.MonHoc;
import DTO.NguoiDung;
import Demo.Demo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SinhVienXemDiemView {
    private JPanel panel_main;
    private JPanel panel_menu;
    private JButton btn_dmk;
    private JButton btn_dx;
    private JButton btn_diem;
    private JButton btn_pk;
    private JButton btn_tkb;
    private JPanel panel_dslop;
    private JLabel label_cblop;
    private JComboBox cb_lop;
    private JLabel label_mon;
    private JComboBox cb_mon;
    private JLabel label_nam;
    private JComboBox cb_nam;
    private JComboBox cb_hocky;
    private JLabel label_kq;
    private JComboBox cb_kq;
    private JButton btn_xem;
    private JScrollPane sp_bangdiem;
    private JTable table_diem;

    String lopDuocChon="";
    String monDuocChon="";
    String namDuocChon="";
    String hocKyDuocChon="";
    String ketQuaDuocChon="";
    List<DiemSinhVien> diemSinhVienList=new ArrayList<>();
    String data[][];
    String column[]={"Mã môn","Tên môn","Điểm GK","Điểm CK","Điểm khác","Điểm tổng","Kết quả"};


    public SinhVienXemDiemView(NguoiDung nguoiDung)
    {

        //ban dau chi can cung cap nam va hoc ky de xem diem

        //Lay ten lop cho JComboBox
        List<Lop> listLop= LopDAO.listLop();

        cb_lop.addItem("");
        for(int i=0;i<listLop.size();i++)
        {
            Lop a=listLop.get(i);

            cb_lop.addItem(a.getTenLop());

        }
        cb_lop.setSelectedIndex(0);

        //lay ten mon cho JComboBox

        List<MonHoc> listMon= MonHocDAO.listMonHoc();
        cb_mon.addItem("");
        for(MonHoc a:listMon)
        {
            cb_mon.addItem(a.getMa());

        }
        cb_mon.setSelectedIndex(0);

        //lay nam cho JComboBox
        List<String>listNam=DiemSinhVien.listNam();
        if(listNam.size()>0)
        {
            for(String a:listNam)
            {
                cb_nam.addItem(a);
            }
            cb_nam.setSelectedIndex(0);
        }

        //lay hoc ky cho JComboBox

        List<Integer>listHocKy=DiemSinhVien.listHocKy();
        if(listHocKy.size()>0)
        {
            for(int a:listHocKy)
            {
                cb_hocky.addItem(String.valueOf(a));
            }
            cb_hocky.setSelectedIndex(0);
        }
        if(listHocKy.size()>0 &&listNam.size()>0)
        {
            //lay ket qua cho JComboBox
            cb_kq.addItem("");
            cb_kq.addItem("Đậu");
            cb_kq.addItem("Rớt");
            cb_kq.setSelectedIndex(0);

        }
        createTable(nguoiDung);



    }

    public JPanel getPanel_main()
    {
        return panel_main;
    }

    public void createTable(NguoiDung nguoiDung)
    {
        if(cb_kq.getSelectedIndex()!=-1)
        {
            //mac dinh cho index=0
            lopDuocChon = "" + cb_lop.getItemAt(
                    cb_lop.getSelectedIndex());
            monDuocChon=""+cb_mon.getItemAt(cb_mon.getSelectedIndex());
            namDuocChon=""+cb_nam.getItemAt(cb_nam.getSelectedIndex());
            hocKyDuocChon=""+cb_hocky.getItemAt(cb_hocky.getSelectedIndex());
            diemSinhVienList=DiemSinhVien.DiemMotSinhVien(namDuocChon,Integer.parseInt(hocKyDuocChon),Integer.parseInt(nguoiDung.getTaiKhoan()));
            data=parseDiemSinhVienToListString(diemSinhVienList);
            table_diem.setModel(new DefaultTableModel(data,column));
        }

        //action khi nhan nut "Xem"
        btn_xem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cb_kq.getSelectedIndex()==0 && cb_lop.getSelectedIndex()==0 && cb_mon.getSelectedIndex()==0)
                {

                    namDuocChon=""+cb_nam.getItemAt(cb_nam.getSelectedIndex());
                    hocKyDuocChon=""+cb_hocky.getItemAt(cb_hocky.getSelectedIndex());

                    diemSinhVienList=DiemSinhVien.DiemMotSinhVien(namDuocChon,Integer.parseInt(hocKyDuocChon),
                            Integer.parseInt(nguoiDung.getTaiKhoan()));

                    data=parseDiemSinhVienToListString(diemSinhVienList);
                    table_diem.setModel(new DefaultTableModel(data,column));
                }
                if(cb_kq.getSelectedIndex()!=0 &&cb_lop.getSelectedIndex()==0 && cb_mon.getSelectedIndex()==0)
                {
                    namDuocChon=""+cb_nam.getItemAt(cb_nam.getSelectedIndex());
                    hocKyDuocChon=""+cb_hocky.getItemAt(cb_hocky.getSelectedIndex());
                    ketQuaDuocChon=""+cb_kq.getItemAt(cb_kq.getSelectedIndex());
                    diemSinhVienList=DiemSinhVien.DiemMotSinhVienTheoKetQua(namDuocChon,Integer.parseInt(hocKyDuocChon),
                            Integer.parseInt(nguoiDung.getTaiKhoan()), ketQuaDuocChon);
                    data=parseDiemSinhVienToListString(diemSinhVienList);
                    table_diem.setModel(new DefaultTableModel(data,column));
                }

                if(cb_lop.getSelectedIndex()>0 && cb_mon.getSelectedIndex()>0&& cb_kq.getSelectedIndex()==0 )
                {
                    lopDuocChon = "" + cb_lop.getItemAt(
                            cb_lop.getSelectedIndex());
                    monDuocChon=""+cb_mon.getItemAt(cb_mon.getSelectedIndex());
                    namDuocChon=""+cb_nam.getItemAt(cb_nam.getSelectedIndex());
                    hocKyDuocChon=""+cb_hocky.getItemAt(cb_hocky.getSelectedIndex());
                    List<DiemSinhVien>temp=new ArrayList<>();
                    temp.add(DiemSinhVien.DiemMotSinhVienMotLop(lopDuocChon,monDuocChon,namDuocChon,Integer.parseInt(hocKyDuocChon),
                            Integer.parseInt(nguoiDung.getTaiKhoan())));
                    data=parseDiemSinhVienToListString(temp);
                    table_diem.setModel(new DefaultTableModel(data,column));
                }
                if(cb_lop.getSelectedIndex()>0 && cb_mon.getSelectedIndex()>0&& cb_kq.getSelectedIndex()!=0 )
                {
                    lopDuocChon = "" + cb_lop.getItemAt(
                            cb_lop.getSelectedIndex());
                    monDuocChon=""+cb_mon.getItemAt(cb_mon.getSelectedIndex());
                    namDuocChon=""+cb_nam.getItemAt(cb_nam.getSelectedIndex());
                    hocKyDuocChon=""+cb_hocky.getItemAt(cb_hocky.getSelectedIndex());
                    ketQuaDuocChon=""+cb_kq.getItemAt(cb_kq.getSelectedIndex());
                    List<DiemSinhVien>temp=new ArrayList<>();
                    DiemSinhVien ketQua=DiemSinhVien.DiemMotSinhVienTheoKetQuaLopMon(lopDuocChon,monDuocChon,namDuocChon,Integer.parseInt(hocKyDuocChon),
                            Integer.parseInt(nguoiDung.getTaiKhoan()),ketQuaDuocChon);
                    temp.add(ketQua);
                    data=parseDiemSinhVienToListString(temp);
                    table_diem.setModel(new DefaultTableModel(data,column));
                }

            }
        });

        JPanel root=getPanel_main();
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
        btn_dx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                DangNhapController.createGUI();
            }
        });

        btn_dmk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                SinhVienDoiMatKhauController.createGUI(nguoiDung);
            }
        });
        btn_diem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                SinhVienXemDiemController.createGUI(nguoiDung);
            }
        });

        btn_tkb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                SinhVienXemTkbController.createGUI(nguoiDung);
            }
        });
        btn_pk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                SinhVienPhucKhaoController.createGUI(nguoiDung);
            }
        });

    }

    public String[][] parseDiemSinhVienToListString(List<DiemSinhVien> sv)
    {


        String res[][]=new String[sv.size()][];
        for(int i=0;i<sv.size();i++)
        {
            DiemSinhVien a=sv.get(i);
            String mssv=String.valueOf(a.getMssv());
            String hoTen=a.getHoTen();
            String diemGk=String.valueOf(a.getDiemGk());
            String diemCk=String.valueOf(a.getDiemCk());
            String diemKhac=String.valueOf(a.getDiemKhac());
            String diemTong=String.valueOf(a.getDiemTong());
            String ketQua=a.getKetQua();
            String temp[]={mssv,hoTen,diemGk,diemCk,diemKhac,diemTong,ketQua};

            res[i]=temp;
        }

        return res;
    }
}
