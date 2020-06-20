package View;

import Controller.*;
import DAO.*;
import DTO.*;
import Demo.ImportCSVDiem;
import Demo.ImportCSVLop;
import Demo.ImportCSVTkb;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImportView {
    private JButton btn_dmk;
    private JButton btn_dx;
    private JButton btn_import;
    private JButton btn_qll;
    private JButton btn_tkb;
    private JButton btn_diem;
    private JPanel panel_import;
    private JTextField tf_tenfile;
    private JPanel panel_main;
    private JPanel panel_menu;
    private JButton btn_tpk;
    private JButton btn_dspk;
    private JComboBox cb_lf;
    private JButton btn_cf;
    private JButton btn_if;

    String fileDuocChon="";
    public ImportView()
    {

        //thông tin cho loại file
        List<String>loaiFile=new ArrayList<>();
        loaiFile.add("Lớp");
        loaiFile.add("Môn");
        loaiFile.add("Điểm");
        cb_lf.addItem("");
        for(String loai:loaiFile)
        {
            cb_lf.addItem(loai);
        }
        cb_lf.setSelectedIndex(0);

        //chọn file
        btn_cf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JFileChooser fileDialog = new JFileChooser();
                int returnVal = fileDialog.showOpenDialog(panel_main);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    java.io.File file = fileDialog.getSelectedFile();
                    tf_tenfile.setText("" + file.getName());
                    fileDuocChon=tf_tenfile.getText();
                } else {

                }

            }
        });

        //action khi nhấn import
        btn_if.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cb_lf.getSelectedIndex()==1)
                {
                    try {
                        importFileLop();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                if(cb_lf.getSelectedIndex()==2)
                {
                    try {
                        importFileMon();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                if(cb_lf.getSelectedIndex()==3)
                {
                    try {
                        importFileDiem();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                JOptionPane.showMessageDialog(panel_main,"Import thành công");
            }
        });
        JPanel root=this.getPanel_main();
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

    public JPanel getPanel_main()
    {
        return panel_main;
    }

    public void importFileLop() throws IOException {
        Lop a=ImportCSVLop.ReadCsvFile(fileDuocChon);
        LopDAO.addLop(a);
        List<SinhVien>sv=SinhVien.listSinhVienLop(a.getTenLop());
        for(SinhVien b:sv)
        {
            NguoiDung res=new NguoiDung(String.valueOf(b.getMssv()),String.valueOf(b.getMssv()));
            NguoiDungDAO.addNguoiDung(res);
        }
    }

    public void importFileMon() throws IOException {
        ThoiKhoaBieu tkb= ImportCSVTkb.ReadCsvFile(fileDuocChon);
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

        }

    }

    public void importFileDiem() throws IOException {
        List<DiemSinhVien>dsv= ImportCSVDiem.ReadCsvFile(fileDuocChon);

        for(DiemSinhVien a:dsv)
        {
            DiemSinhVienDAO.addDiemSinhVien(a);
        }

    }
}
