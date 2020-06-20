package Controller;

import View.DoiMatKhauView;
import View.LopView;

import javax.swing.*;

public class DoiMatKhauController {

        public static void createGUI()
        {
                DoiMatKhauView doiMatKhauView=new DoiMatKhauView();
                JPanel root=doiMatKhauView.getPanel_main();
                JFrame frame=new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(root);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
        }
}
