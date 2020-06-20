package View;

import Controller.*;
import DAO.NguoiDungDAO;
import DTO.NguoiDung;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SinhVienDoiMatKhauView {
    private JPanel panel_main;
    private JPanel panel_menu;
    private JButton btn_dmk;
    private JButton btn_dx;
    private JButton btn_diem;
    private JButton btn_pk;
    private JButton btn_tkb;
    private JPanel panel_dmk;
    private JLabel label_tk;
    private JTextField tf_tk;
    private JLabel label_mkc;
    private JPasswordField pf_mkc;
    private JLabel label_mkm;
    private JPasswordField pf_mkm;
    private JButton btn_doimatkhau;

    public SinhVienDoiMatKhauView(NguoiDung nguoiDung)
    {
        JPanel root=this.getPanel_main();
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        btn_doimatkhau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taiKhoan=tf_tk.getText();
                String mkc=String.valueOf(pf_mkc.getPassword());
                String mkm=String.valueOf(pf_mkm.getPassword());

                if(NguoiDungDAO.searchNguoiDung(taiKhoan,mkc))
                {
                    NguoiDungDAO.updateNguoiDung(taiKhoan,mkm);
                    JOptionPane.showMessageDialog(panel_main,"Đổi mật khẩu thành công");
                }
                else
                {
                    JOptionPane.showMessageDialog(panel_main,"Sai tài khoản hoặc mật khẩu cũ");

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
        return panel_main;
    }
}
