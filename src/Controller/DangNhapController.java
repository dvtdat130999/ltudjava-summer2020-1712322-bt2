package Controller;

import DTO.NguoiDung;
import View.DangNhapView;
import View.DoiMatKhauView;
import View.LopView;

import javax.swing.*;

public class DangNhapController {
    private NguoiDung nguoiDung;
    private DangNhapView dangNhapView;
    private LopView lopView;

    public DangNhapController(DangNhapView view)
    {
       /* this.dangNhapView=view;
        this.nguoiDung=new NguoiDung();
        view.addLoginListener(new LoginListener())*/

    }
    public static void createGUI()
    {
        DangNhapView dangNhapView=new DangNhapView();
        JPanel root=dangNhapView.getPanel_main();
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
