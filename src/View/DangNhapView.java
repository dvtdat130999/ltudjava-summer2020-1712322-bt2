package View;

import Controller.LopController;
import Controller.SinhVienXemDiemController;
import DAO.NguoiDungDAO;
import DTO.NguoiDung;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DangNhapView {


    private JLabel label_tk;
    private JTextField tf_tk;
    private JLabel label_mk;
    private JPasswordField pf_mk;
    private JButton btn_dn;
    private JPanel panel_main;

    public DangNhapView() {
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(getPanel_main());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        btn_dn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taiKhoan=tf_tk.getText();
                String matKhau=String.valueOf(pf_mk.getPassword());

                if(NguoiDungDAO.searchNguoiDung(taiKhoan,matKhau))
                {
                    if(Util.Util.stringCompare(taiKhoan,"giaovu")==0)
                    {
                        frame.setVisible(false);

                        LopController.createGUI();
                    }
                    if(Util.Util.stringCompare(taiKhoan,"giaovu")!=0)
                    {
                        frame.setVisible(false);

                        SinhVienXemDiemController.createGUI(new NguoiDung(taiKhoan,matKhau));

                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(frame,"Sai tài khoản hoặc mật khẩu");
                }

            }
        });
    }
    public JPanel getPanel_main()
    {
        return panel_main;
    }
}
