package Controller;

import View.LopView;
import View.ThoiKhoaBieuView;

import javax.swing.*;

public class ThoiKhoaBieuController {
    public ThoiKhoaBieuController(){}

    public static void createGUI()
    {
        ThoiKhoaBieuView thoiKhoaBieuView=new ThoiKhoaBieuView();
        JPanel root=thoiKhoaBieuView.getPanel_main();
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}
