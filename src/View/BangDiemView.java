package View;

import Controller.*;
import DAO.DiemSinhVienDAO;
import DAO.LopDAO;
import DAO.MonHocDAO;
import DTO.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BangDiemView {
    private JPanel panel_main;
    private JPanel panel_menu;
    private JButton btn_dmk;
    private JButton btn_dx;
    private JButton btn_import;
    private JButton btn_qll;
    private JButton btn_tpk;
    private JButton btn_tkb;
    private JButton btn_diem;
    private JComboBox cb_lop;
    private JComboBox cb_mon;
    private JButton btn_xem;
    private JTable table_diem;
    private JComboBox cb_nam;
    private JComboBox cb_hocky;
    private JPanel panel_dslop;
    private JLabel label_cblop;
    private JLabel label_mon;
    private JLabel label_nam;
    private JScrollPane sp_bangdiem;
    private JPanel panel_change;
    private JTextField tf_gk;
    private JTextField tf_ck;
    private JTextField tf_dk;
    private JTextField tf_dt;
    private JLabel label_gk;
    private JLabel label_ck;
    private JLabel label_khac;
    private JLabel label_tong;
    private JTextField tf_mssv;
    private JLabel label_mssv;
    private JTextField tf_hoTen;
    private JLabel label_hoTen;
    private JButton btn_editDsv;
    private JButton btn_tk;
    private JLabel label_kq;
    private JComboBox cb_kq;
    private JButton btn_dspk;

    String lopDuocChon="";
    String monDuocChon="";
    String namDuocChon="";
    String hocKyDuocChon="";
    String ketQuaDuocChon="";
    List<DiemSinhVien> diemSinhVienList;
    String data[][];
    Object column[] = { "MSSV", "Họ tên", "Điểm GK","Điểm CK","Điểm khác","Điểm tổng" };
    public BangDiemView()
    {

        //Lay ten lop cho JComboBox
        List<Lop> listLop= LopDAO.listLop();

        for(int i=0;i<listLop.size();i++)
        {
            Lop a=listLop.get(i);

            cb_lop.addItem(a.getTenLop());

        }

        cb_lop.setSelectedIndex(0);

        //lay ten mon cho JComboBox

        List<MonHoc> listMon= MonHocDAO.listMonHoc();
        for(MonHoc a:listMon)
        {
            cb_mon.addItem(a.getMa());

        }
        cb_mon.setSelectedIndex(0);

        //lay nam cho JComboBox
        List<String>listNam=DiemSinhVien.listNam();
        for(String a:listNam)
        {
            cb_nam.addItem(a);
        }

        //lay hoc ky cho JComboBox
        List<Integer>listHocKy=DiemSinhVien.listHocKy();
        for(int a:listHocKy)
        {
            cb_hocky.addItem(String.valueOf(a));
        }

        //lay ket qua cho JComboBox
        cb_kq.addItem("");
        cb_kq.addItem("Đậu");
        cb_kq.addItem("Rớt");
        cb_kq.setSelectedIndex(0);
        createTable();
    }

    public JPanel getPanel_main()
    {
        return panel_main;
    }

    public void createTable()
    {
        JPanel root=this.getPanel_main();
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
        //mac dinh cho index=0
        lopDuocChon = "" + cb_lop.getItemAt(
                cb_lop.getSelectedIndex());
        monDuocChon=""+cb_mon.getItemAt(cb_mon.getSelectedIndex());
        namDuocChon=""+cb_nam.getItemAt(cb_nam.getSelectedIndex());
        hocKyDuocChon=""+cb_hocky.getItemAt(cb_hocky.getSelectedIndex());
        diemSinhVienList=DiemSinhVien.listDiemSinhVien(lopDuocChon,monDuocChon,namDuocChon,Integer.parseInt(hocKyDuocChon));
        data=parseDiemSinhVienToListString(diemSinhVienList);
        table_diem.setModel(new DefaultTableModel(data,column));


        //action khi nhan nut "Xem"
        btn_xem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cb_kq.getSelectedIndex()==0)
                {
                    lopDuocChon = "" + cb_lop.getItemAt(
                            cb_lop.getSelectedIndex());
                    monDuocChon=""+cb_mon.getItemAt(cb_mon.getSelectedIndex());
                    namDuocChon=""+cb_nam.getItemAt(cb_nam.getSelectedIndex());
                    hocKyDuocChon=""+cb_hocky.getItemAt(cb_hocky.getSelectedIndex());
                    diemSinhVienList=DiemSinhVien.listDiemSinhVien(lopDuocChon,monDuocChon,namDuocChon,Integer.parseInt(hocKyDuocChon));
                    data=parseDiemSinhVienToListString(diemSinhVienList);
                    table_diem.setModel(new DefaultTableModel(data,column));
                }
                else
                {
                    lopDuocChon = "" + cb_lop.getItemAt(
                            cb_lop.getSelectedIndex());
                    monDuocChon=""+cb_mon.getItemAt(cb_mon.getSelectedIndex());
                    namDuocChon=""+cb_nam.getItemAt(cb_nam.getSelectedIndex());
                    hocKyDuocChon=""+cb_hocky.getItemAt(cb_hocky.getSelectedIndex());
                    ketQuaDuocChon=""+cb_kq.getItemAt(cb_kq.getSelectedIndex());
                    diemSinhVienList=DiemSinhVien.listSinhVienTheoKetQua(lopDuocChon,monDuocChon,namDuocChon,Integer.parseInt(hocKyDuocChon),ketQuaDuocChon);
                    data=parseDiemSinhVienToListString(diemSinhVienList);
                    table_diem.setModel(new DefaultTableModel(data,column));
                }
            }
        });

        //action khi nhan nut "Sua"
        btn_editDsv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tenLop=lopDuocChon;
                String maMon=monDuocChon;
                String nam=namDuocChon;
                int hocKy=Integer.parseInt(hocKyDuocChon);
                int mssv=Integer.parseInt(tf_mssv.getText());
                String hoTen=tf_hoTen.getText();
                double gk=Double.parseDouble(tf_gk.getText());
                double ck=Double.parseDouble(tf_ck.getText());
                double dk=Double.parseDouble(tf_dk.getText());
                double dt=Double.parseDouble(tf_dt.getText());
                DiemSinhVien newDsv=new DiemSinhVien();
                newDsv.setDiemTong(dt);
                newDsv.setDiemKhac(dk);
                newDsv.setDiemCk(ck);
                newDsv.setDiemGk(gk);
                newDsv.setHoTen(hoTen);
                newDsv.setMssv(mssv);
                newDsv.setLop(tenLop);
                newDsv.setMaMon(maMon);
                newDsv.setNam(nam);
                newDsv.setHocKy(hocKy);


                DiemSinhVienDAO.updateDiemSinhVien(newDsv);

                diemSinhVienList=DiemSinhVien.listDiemSinhVien(lopDuocChon,monDuocChon,namDuocChon,Integer.parseInt(hocKyDuocChon));
                data=parseDiemSinhVienToListString(diemSinhVienList);
                table_diem.setModel(new DefaultTableModel(data,column));
            }
        });

        btn_tk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(diemSinhVienList.size()>0)
                {
                    double svDau=DiemSinhVien.sinhVienDau(lopDuocChon,monDuocChon,namDuocChon,Integer.parseInt(hocKyDuocChon));
                    double svRot=DiemSinhVien.sinhVienRot(lopDuocChon,monDuocChon,namDuocChon,Integer.parseInt(hocKyDuocChon));
                    double phanTramDau=DiemSinhVien.phanTramDau(lopDuocChon,monDuocChon,namDuocChon,Integer.parseInt(hocKyDuocChon));
                    double phanTramRot=DiemSinhVien.phanTramRot(lopDuocChon,monDuocChon,namDuocChon,Integer.parseInt(hocKyDuocChon));

                    String message="Lớp "+lopDuocChon+"-"+monDuocChon+" năm "+namDuocChon+" học kỳ "+hocKyDuocChon+":\n"
                            +"Số sinh viên đậu: "+svDau+" ("+phanTramDau+" %)\n"
                            +"Số sinh viên rớt: "+svRot+" ("+phanTramRot+" %)\n";
                    JOptionPane.showMessageDialog(panel_main,message);
                }



            }
        });

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
                DoiMatKhauController.createGUI();
            }
        });

        btn_import.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                ImportController.createGUI();
            }
        });

        btn_qll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                LopController.createGUI();
            }
        });

        btn_tkb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                ThoiKhoaBieuController.createGUI();
            }
        });

        btn_diem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                BangDiemController.createGUI();
            }
        });

        btn_tpk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                TaoThoiGianPhucKhaoController.createGUI();
            }
        });
        btn_dspk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                DanhSachPhucKhaoController.createGUI();
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

            String temp[]={mssv,hoTen,diemGk,diemCk,diemKhac,diemTong};

            res[i]=temp;
        }

        return res;
    }


}
