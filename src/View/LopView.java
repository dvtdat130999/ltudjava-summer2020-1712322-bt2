package View;

import Controller.*;
import DAO.LopDAO;
import DAO.MonHocDAO;
import DAO.SinhVienDAO;
import DTO.Lop;
import DTO.MonHoc;
import DTO.SinhVien;
import Demo.Demo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LopView {


    private JButton btn_dmk;
    private JButton btn_dx;
    private JButton btn_import;
    private JButton btn_qll;
    private JButton btn_tkb;
    private JButton btn_diem;
    private JPanel panel_check;
    private JLabel label_mssv;
    private JTextField tf_mssv;
    private JLabel label_hoTen;
    private JTextField tf_hoTen;
    private JLabel label_gt;
    private JTextField tf_gt;
    private JLabel label_cmnd;
    private JTextField tf_cmnd;
    private JLabel label_lop;
    private JTextField tf_lop;
    private JButton btn_addsv;
    private JButton btn_editsv;
    private JPanel panel_dslop;
    private JLabel label_cblop;
    private JComboBox cb_lop;
    private JTable table_dslop;
    private JButton btn_xem;
    private JPanel panel_main;
    private JScrollPane sp_dslop;
    private JComboBox cb_mon;
    private JLabel label_mon;
    private JPanel panel_menu;
    private JButton btn_tpk;
    private JButton btn_dspk;

    String lopDuocChon="";
    String monDuocChon="";
    List<SinhVien> sinhVienList;
    String data[][];
    Object column[] = { "MSSV", "Họ tên", "Giới tính","CMND","Lớp" };
    public LopView()
    {

        //lay ten lop cho JComboBox
        List<Lop> listLop= LopDAO.listLop();

        for(int i=0;i<listLop.size();i++)
        {
            Lop a=listLop.get(i);

            cb_lop.addItem(a.getTenLop());

        }

        cb_lop.setSelectedIndex(0);

        //lay ten mon cho JComboBox
        //cho 1 item la rong de co the xem danh sach theo lop
        cb_mon.addItem("");
        List<MonHoc> listMon= MonHocDAO.listMonHoc();
        for(MonHoc a:listMon)
        {
            cb_mon.addItem(a.getMa());

        }
        cb_mon.setSelectedIndex(0);
        createTable();
        fillStudentFromSelectedRow();
    }

    public void  createTable()
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
        sinhVienList=SinhVien.listSinhVienLop(lopDuocChon);

        data=parseSinhVienToListString(sinhVienList);
        table_dslop.setModel(new DefaultTableModel(
                data,column
        ));

        //action khi chon lai lop khac
        btn_xem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //danh sach sinh vien theo lop
                if (cb_lop.getSelectedIndex() != -1&&cb_mon.getSelectedIndex()==0) {
                    lopDuocChon = "" + cb_lop.getItemAt(
                            cb_lop.getSelectedIndex());
                    sinhVienList=SinhVien.listSinhVienLop(lopDuocChon);
                    data=parseSinhVienToListString(sinhVienList);
                    table_dslop.setModel(new DefaultTableModel(
                            data,column
                    ));
                }

                //danh sach sinh vien theo lop-mon
                if (cb_lop.getSelectedIndex() != -1&&cb_mon.getSelectedIndex()!=0) {
                    lopDuocChon = "" + cb_lop.getItemAt(
                            cb_lop.getSelectedIndex());
                    monDuocChon=""+cb_mon.getItemAt(cb_mon.getSelectedIndex());
                    sinhVienList=SinhVien.listSinhVienLopMon(lopDuocChon,monDuocChon);
                    data=parseSinhVienToListString(sinhVienList);
                    table_dslop.setModel(new DefaultTableModel(
                            data,column
                    ));
                }

            }
        });


        //action khi nhan nut add
        btn_addsv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int mssv=Integer.parseInt(tf_mssv.getText());
                String hoTen=tf_hoTen.getText();
                String gioiTinh=tf_gt.getText();
                String cmnd=tf_cmnd.getText();
                String tenLop=tf_lop.getText();
                Lop lop=LopDAO.searchLop(tenLop);
                SinhVien svMoi=new SinhVien(mssv,hoTen,gioiTinh,cmnd,lop);
                SinhVienDAO.addSinhVien(svMoi);

                sinhVienList=SinhVien.listSinhVienLop(lopDuocChon);
                data=parseSinhVienToListString(sinhVienList);
                table_dslop.setModel(new DefaultTableModel(
                        data,column
                ));
            }
        });
        //action khi nhan nut delete
/*
        btn_deletesvn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int mssv=Integer.parseInt(tf_mssv.getText());
                String hoTen=tf_hoTen.getText();
                String gioiTinh=tf_gt.getText();
                String cmnd=tf_cmnd.getText();
                String tenLop=tf_lop.getText();
                Lop lop=LopDAO.searchLop(tenLop);
                SinhVien sv=new SinhVien(mssv,hoTen,gioiTinh,cmnd,lop);
                SinhVienDAO.deleteSinhVien(sv);

                sinhVienList=SinhVien.listSinhVienLop(lopDuocChon);
                data=parseSinhVienToListString(sinhVienList);
                table_dslop.setModel(new DefaultTableModel(
                        data,column
                ));
            }
        });
*/

        //action khi nhan edit
        btn_editsv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int mssv=Integer.parseInt(tf_mssv.getText());
                String hoTen=tf_hoTen.getText();
                String gioiTinh=tf_gt.getText();
                String cmnd=tf_cmnd.getText();
                String tenLop=tf_lop.getText();
                Lop lop=LopDAO.searchLop(tenLop);
                SinhVien sv=new SinhVien(mssv,hoTen,gioiTinh,cmnd,lop);
                SinhVienDAO.updateSinhVien(sv);

                sinhVienList=SinhVien.listSinhVienLop(lopDuocChon);
                data=parseSinhVienToListString(sinhVienList);
                table_dslop.setModel(new DefaultTableModel(
                        data,column
                ));
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

    public String[][] parseSinhVienToListString(List<SinhVien> sv)
    {


        String res[][]=new String[sv.size()][];
        for(int i=0;i<sv.size();i++)
        {
            SinhVien a=sv.get(i);
            String mssv=Integer.toString(a.getMssv());
            String lop=a.getLop().getTenLop();
            String temp[]={mssv,a.getHoTen(),a.getGioiTinh(),a.getCmnd(),lop};
            res[i]=temp;
        }

        return res;
    }

    public JPanel getPanel_main()
    {
        return panel_main;
    }

    public void fillStudentFromSelectedRow()
    {
        //lay index hang duoc chon
        int row=table_dslop.getSelectedRow();
        if(row>0)
        {
            tf_mssv.setText(table_dslop.getModel().getValueAt(row,0).toString());
            tf_hoTen.setText(table_dslop.getModel().getValueAt(row,1).toString());
            tf_gt.setText(table_dslop.getModel().getValueAt(row,2).toString());
            tf_cmnd.setText(table_dslop.getModel().getValueAt(row,3).toString());
            tf_lop.setText(table_dslop.getModel().getValueAt(row,4).toString());

            //hien thi Edit button
            btn_editsv.setEnabled(true);
            //tat hien thi Add button
            btn_addsv.setEnabled(false);
        }
    }

    public SinhVien layThongTinSinhVien() {
        // validate student

        try {
            SinhVien student = new SinhVien();
            if (tf_mssv.getText() != null && !"".equals(tf_mssv.getText())) {
            }
            student.setMssv(Integer.parseInt(tf_mssv.getText()));

            student.setHoTen(tf_hoTen.getText());
            student.setGioiTinh(tf_gt.getText());
            student.setCmnd(tf_cmnd.getText());
            Lop a=LopDAO.searchLop(tf_lop.getText());
            student.setLop(a);
            return student;
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(panel_main, message);
    }
    /*public void showStudent(SinhVien student) {
        tf_mssv.setText("" + student.getMssv());
        tf_hoTen.setText(student.getHoTen());
        tf_gt.setText("" + student.getGioiTinh());
        tf_cmnd.setText(student.getCmnd());
        tf_lop.setText("" + student.getLop().getTenLop());
        // enable Edit
        btn_editsv.setEnabled(true);
        // disable Add button
        btn_addsv.setEnabled(false);
    }*/


}
