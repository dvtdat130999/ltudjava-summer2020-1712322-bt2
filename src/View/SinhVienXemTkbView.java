package View;

import Controller.*;
import DTO.DiemSinhVien;
import DTO.MonHoc;
import DTO.NguoiDung;
import DTO.SinhVien;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SinhVienXemTkbView {
    private JPanel panel_main;
    private JPanel panel_menu;
    private JButton btn_dmk;
    private JButton btn_dx;
    private JButton btn_diem;
    private JButton btn_pk;
    private JButton btn_tkb;
    private JLabel label_nam;
    private JComboBox cb_nam;
    private JButton btn_xem;
    private JTable tb_tkbsv;
    private JPanel panel_tkb;
    private JComboBox cb_hk;

    String namDuocChon="";
    String hocKyDuocChon="";
    List<MonHoc> listMonHoc;

    String data[][];
    Object column[] = { "Mã môn", "Tên môn", "Phòng học" };
    public SinhVienXemTkbView(NguoiDung nguoiDung)
    {
        //lấy nam cho JComboBox
        List<String>listNam= MonHoc.listNam();
        for(String a:listNam)
        {
            cb_nam.addItem(a);
        }
        cb_nam.setSelectedIndex(0);
        //lấy hoc ky cho JComboBox
        List<Integer>listHocKy= MonHoc.listHocKy();
        for(int a:listHocKy)
        {
            cb_hk.addItem(String.valueOf(a));
        }
        cb_hk.setSelectedIndex(0);
        createTable(nguoiDung);
    }

    public JPanel getPanel_main()
    {
        return panel_main;
    }

    public void createTable(NguoiDung nguoiDung)
    {
        JPanel root=this.getPanel_main();
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

        //mac dinh cho index=0

        namDuocChon=""+cb_nam.getItemAt(cb_nam.getSelectedIndex());
        hocKyDuocChon=""+cb_hk.getItemAt(cb_hk.getSelectedIndex());
        listMonHoc= MonHoc.tkbSinhVien(namDuocChon,Integer.parseInt(hocKyDuocChon),Integer.parseInt(nguoiDung.getTaiKhoan()));
        data=parseMonHocToListString(listMonHoc);
        tb_tkbsv.setModel(new DefaultTableModel(data,column));
        //action khi nhan nut "Xem"
        btn_xem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                namDuocChon=""+cb_nam.getItemAt(cb_nam.getSelectedIndex());
                hocKyDuocChon=""+cb_hk.getItemAt(cb_hk.getSelectedIndex());
                listMonHoc= MonHoc.tkbSinhVien(namDuocChon,Integer.parseInt(hocKyDuocChon),Integer.parseInt(nguoiDung.getTaiKhoan()));
                data=parseMonHocToListString(listMonHoc);
                tb_tkbsv.setModel(new DefaultTableModel(data,column));

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

    public String[][] parseMonHocToListString(List<MonHoc>monHocs)
    {
        String res[][]=new String[monHocs.size()][];
        for(int i=0;i<monHocs.size();i++)
        {
            MonHoc a=monHocs.get(i);
            String maMon=a.getMa();
            String tenMon=a.getTen();
            String phong=a.getPhong();


            String temp[]={maMon,tenMon,phong};
            res[i]=temp;
        }
        return res;
    }
}
