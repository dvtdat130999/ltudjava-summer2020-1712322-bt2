package View;

import Controller.LopController;
import DAO.NguoiDungDAO;
import DTO.NguoiDung;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DangNhapView {


    private JButton btn_dmk;
    private JButton btn_dx;
    private JButton btn_import;
    private JButton btn_qll;
    private JButton btn_qllm;
    private JButton btn_tkb;
    private JButton btn_diem;
    private JLabel label_tk;
    private JTextField tf_tk;
    private JLabel label_mk;
    private JPasswordField pf_mk;
    private JButton btn_dn;
    private JPanel panel_main;

    public DangNhapView() {
        btn_dn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taiKhoan=tf_tk.getText();
                String matKhau=String.valueOf(pf_mk.getPassword());

                if(NguoiDungDAO.searchNguoiDung(taiKhoan,matKhau))
                {
                    if(Util.Util.stringCompare(taiKhoan,"giaovu")==0)
                    {
                        LopController.createGUI();
                        /*DangNhapView.setVisible(false);*/
                    }
                    if(Util.Util.stringCompare(taiKhoan,"giaovu")!=0)
                    {
                        System.out.println("Sinh Vien dang nhap thanh cong");
                        /*DangNhapView.setVisible(false);*/
                    }
                }

            }
        });
    }
    public JPanel getPanel_main()
    {
        return panel_main;
    }
}
