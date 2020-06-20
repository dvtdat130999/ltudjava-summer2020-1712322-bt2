package View;

import Controller.*;
import DAO.PhucKhaoSinhVienDAO;
import DTO.NguoiDung;
import DTO.PhucKhaoSinhVien;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SinhVienPhucKhaoView {
    private JPanel panel_main;
    private JPanel panel_menu;
    private JButton btn_dmk;
    private JButton btn_dx;
    private JButton btn_diem;
    private JButton btn_pk;
    private JButton btn_tkb;
    private JPanel panel_pk;
    private JLabel label_mssv;
    private JTextField tf_mssv;
    private JLabel label_mon;
    private JTextField tf_mon;
    private JLabel label_ht;
    private JTextField tf_ht;
    private JLabel label_cd;
    private JComboBox cb_cd;
    private JLabel label_dmm;
    private JTextField tf_dmm;
    private JLabel label_ld;
    private JTextField tf_ld;
    private JButton btn_guipk;

    public SinhVienPhucKhaoView(NguoiDung nguoiDung)
    {
        //lấy thông tin cho cột điểm JComboBox
        List<String>cotDiem=new ArrayList<>();
        cotDiem.add("Điểm giữa kỳ");
        cotDiem.add("Điểm cuối kỳ");
        cotDiem.add("Điểm khác");
        cotDiem.add("Điểm tổng");
        cb_cd.addItem("");

        for(String diem:cotDiem)
        {
            cb_cd.addItem(diem);
        }
        cb_cd.setSelectedIndex(0);


        JPanel root=this.getPanel_main();
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //action khi nhấn gửi
        btn_guipk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Util.Util.stringCompare(tf_dmm.getText(),"")!=0
                        && Util.Util.stringCompare(tf_mssv.getText(),"")!=0
                && Util.Util.stringCompare(tf_ht.getText(),"")!=0
                && Util.Util.stringCompare(tf_mon.getText(),"")!=0
                && Util.Util.stringCompare(tf_ld.getText(),"")!=0
                && cb_cd.getSelectedIndex()!=0)
                {
                    PhucKhaoSinhVien pk=new PhucKhaoSinhVien();
                    pk.setMssv(Integer.parseInt(tf_mssv.getText()));
                    pk.setHoTen(tf_ht.getText());
                    pk.setMon(tf_mon.getText());
                    String diem=String.valueOf(cb_cd.getItemAt(cb_cd.getSelectedIndex()));
                    int cotDiem=0;
                    if(Util.Util.stringCompare(diem,"Điểm giữa kỳ")==0)
                    {
                        cotDiem=1;
                    }
                    if(Util.Util.stringCompare(diem,"Điểm cuối kỳ")==0)
                    {
                        cotDiem=2;
                    }
                    if(Util.Util.stringCompare(diem,"Điểm khác")==0)
                    {
                        cotDiem=3;
                    }
                    if(Util.Util.stringCompare(diem,"Điểm tổng")==0)
                    {
                        cotDiem=4;
                    }
                    pk.setCotDiem(cotDiem);
                    pk.setDiemMongMuon(Double.parseDouble(tf_dmm.getText()));
                    pk.setLyDo(tf_ld.getText());
                    pk.setTinhTrang("Chưa xem");
                    pk.setNgayPhucKhao(new Date());
                    PhucKhaoSinhVienDAO.addPhucKhaoSinhVien(pk);

                    JOptionPane.showMessageDialog(panel_main,"Gửi phúc khảo thành công");
                }
                else
                {
                    JOptionPane.showMessageDialog(panel_main,"Hãy nhập đủ thông tin");
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


    public JPanel getPanel_main()
    {
        return  panel_main;
    }
}
