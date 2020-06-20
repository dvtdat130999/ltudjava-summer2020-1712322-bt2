package View;

import Controller.*;
import DAO.PhucKhaoDiemDAO;
import DTO.PhucKhaoDiem;

import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaoThoiGianPhucKhaoView {
    private JPanel panel_main;
    private JPanel panel_menu;
    private JButton btn_dmk;
    private JButton btn_dx;
    private JButton btn_import;
    private JButton btn_qll;
    private JButton btn_tpk;
    private JButton btn_tkb;
    private JButton btn_diem;
    private JButton btn_dspk;
    private JLabel label_nbd;
    private JTextField tf_nbd;
    private JTextField tf_tbd;
    private JTextField tf_nambd;
    private JLabel label_nkt;
    private JTextField tf_nkt;
    private JTextField tf_tkt;
    private JTextField tf_namkt;
    private JPanel panel_tpk;
    private JButton btn_xntpk;

    public TaoThoiGianPhucKhaoView()
    {
        JPanel root=this.getPanel_main();
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

        btn_xntpk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");


                String ngay1=tf_nbd.getText();
                String thang1=tf_tbd.getText();
                String nam1= tf_nambd.getText();
                String firstDate=ngay1+"-"+thang1+"-"+nam1;
                Date date1 = null;
                Date date2=null;


                String ngay2=tf_nkt.getText();
                String thang2=tf_tkt.getText();
                String nam2= tf_namkt.getText();
                String secondDate=ngay2+"-"+thang2+"-"+nam2;

                if(Util.Util.stringCompare(ngay1,"")!=0
                    &&Util.Util.stringCompare(ngay2,"")!=0
                    &&Util.Util.stringCompare(thang1,"")!=0
                    &&Util.Util.stringCompare(thang2,"")!=0
                    &&Util.Util.stringCompare(nam1,"")!=0
                    &&Util.Util.stringCompare(nam2,"")!=0)
                {
                    try {
                        date1=sdf.parse(firstDate);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        date2=sdf.parse(secondDate);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    if(date1.compareTo(date2)>=0)
                    {
                        JOptionPane.showMessageDialog(getPanel_main(),"Ngày kết thúc phải sau ngày bắt đầu");

                    }
                    else
                    {
                        PhucKhaoDiem pkd=new PhucKhaoDiem(date1,date2);

                        PhucKhaoDiemDAO.addPhucKhaoDiem(pkd);

                        JOptionPane.showMessageDialog(getPanel_main(),"Tạo thời gian phúc khảo thành công");

                    }

                }
                else
                {
                    JOptionPane.showMessageDialog(getPanel_main(),"Hãy nhập đủ thông tin");

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
                DoiMatKhauController.createGUI();
            }
        });

        btn_import.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                ImportController.createGUI();
            }
        });

        btn_qll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                LopController.createGUI();
            }
        });

        btn_tkb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                ThoiKhoaBieuController.createGUI();
            }
        });

        btn_diem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                BangDiemController.createGUI();
            }
        });

        btn_tpk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                TaoThoiGianPhucKhaoController.createGUI();
            }
        });

        btn_dspk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                DanhSachPhucKhaoController.createGUI();
            }
        });
    }

    public JPanel getPanel_main()
    {
        return panel_main;
    }

}
