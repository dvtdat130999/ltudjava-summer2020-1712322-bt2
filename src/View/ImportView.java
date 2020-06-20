package View;

import Controller.DangNhapController;
import org.hibernate.boot.model.source.spi.JpaCallbackSource;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImportView {
    private JPanel panel_menu;
    private JButton btn_dmk;
    private JButton btn_dx;
    private JButton btn_import;
    private JButton btn_qll;
    private JButton btn_qllm;
    private JButton btn_tkb;
    private JButton btn_diem;
    private JPanel panel_import;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton btn_fi;
    private JPanel panel_main;

    public ImportView()
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
