package View;

import Controller.DangNhapController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoiMatKhauView {
    private JPanel panel_main;
    private JPanel panel_menu;
    private JButton btn_dmk;
    private JButton btn_dx;
    private JButton btn_import;
    private JButton btn_qll;
    private JButton btn_qllm;
    private JButton btn_tkb;
    private JButton btn_diem;
    private JPanel panel_dmk;
    private JLabel label_mkc;
    private JTextField tf_mkc;
    private JLabel label_mkm;
    private JPasswordField pf_mkm;
    private JButton btn_doimatkhau;

    public DoiMatKhauView()
    {
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
    }




    public JPanel getPanel_main()
    {
        return panel_main;
    }


}
