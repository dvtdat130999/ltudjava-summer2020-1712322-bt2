package Controller;

import View.BangDiemView;
import View.ThoiKhoaBieuView;

import javax.swing.*;

public class BangDiemController {
    public BangDiemController()
    {

    }

    public static void createGUI()
    {
        BangDiemView bangDiemView=new BangDiemView();
        JPanel root=bangDiemView.getPanel_main();
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}
