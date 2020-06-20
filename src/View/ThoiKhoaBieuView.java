package View;

import Controller.*;
import DAO.LopDAO;
import DTO.Lop;
import DTO.MonHoc;
import DTO.SinhVien;
import DTO.ThoiKhoaBieu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ThoiKhoaBieuView {
    private JButton btn_dmk;
    private JButton btn_dx;
    private JButton btn_import;
    private JButton btn_qll;
    private JButton btn_tkb;
    private JButton btn_diem;
    private JPanel panel_main;
    private JComboBox cb_lop;
    private JLabel label_lop;
    private JTable tb_dsmonlop;
    private JButton btn_xem;
    private JPanel panel_menu;
    private JButton btn_tpk;
    private JButton btn_dspk;


    String lopDuocChon="";
    List<MonHoc> listMonHoc;
    String data[][];
    Object column[] = { "Mã môn", "Tên môn", "Phòng học","Năm","Học kỳ" };
    public ThoiKhoaBieuView()
    {
        //lay ten lop cho JComboBox
        List<Lop> listLop= LopDAO.listLop();

        for(int i=0;i<listLop.size();i++)
        {
            Lop a=listLop.get(i);

            cb_lop.addItem(a.getTenLop());

        }

        cb_lop.setSelectedIndex(0);
        createTable();
    }

    public JPanel getPanel_main()
    {
        return panel_main;
    }

    public void createTable()
    {
        JPanel root=getPanel_main();
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //mac dinh cho index=0
        //danh sach mon hoc theo lop
        lopDuocChon = "" + cb_lop.getItemAt(
                cb_lop.getSelectedIndex());
        listMonHoc= MonHoc.searchByLop(lopDuocChon);
        data=parseMonToListString(listMonHoc);
        tb_dsmonlop.setModel(new DefaultTableModel(data,column));

        //action cho viec nhan nut "Xem"
        btn_xem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //danh sach mon hoc theo lop
                lopDuocChon = "" + cb_lop.getItemAt(
                        cb_lop.getSelectedIndex());
                listMonHoc= MonHoc.searchByLop(lopDuocChon);
                data=parseMonToListString(listMonHoc);
                tb_dsmonlop.setModel(new DefaultTableModel(data,column));
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

    public String[][] parseMonToListString(List<MonHoc> mh)
    {


        String res[][]=new String[mh.size()][];
        for(int i=0;i<mh.size();i++)
        {
            MonHoc a=mh.get(i);
            String maMon=a.getMa();
            String tenMon=a.getTen();
            String phong=a.getPhong();
            String nam=a.getNam();
            String hocKy=String.valueOf(a.getHocKy());

            String temp[]={maMon,tenMon,phong,nam,hocKy};
            res[i]=temp;
        }
        return res;

    }
}
