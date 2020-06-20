package View;

import Controller.*;
import DAO.PhucKhaoSinhVienDAO;
import DTO.PhucKhaoSinhVien;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DanhSachPhucKhaoView {
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
    private JPanel panel_dspk;
    private JPanel panel_npk;
    private JLabel label_nbd;
    private JTextField tf_nbd;
    private JTextField tf_tbd;
    private JTextField tf_nambd;
    private JLabel label_nkt;
    private JTextField tf_nkt;
    private JTextField tf_tkt;
    private JTextField tf_namkt;
    private JButton btn_xntpk;
    private JTable tb_dspk;
    private JLabel label_mssv;
    private JTextField tf_mssv;
    private JLabel label_ht;
    private JTextField tf_mon;
    private JTextField tf_cotdiem;
    private JLabel label_cotdiem;
    private JLabel label_tt;
    private JTextField tf_tt;
    private JButton btn_cn;


    Date ngayBatDau=null;
    Date ngayKetThuc=null;
    List<PhucKhaoSinhVien> phucKhaoSinhVienList;
    String data[][];
    Object column[] = { "MSSV", "Họ tên", "Môn","Cột điểm cần phúc khảo","Điểm mong muốn","Lý do","Tình trạng" };


    public DanhSachPhucKhaoView()
    {
        JPanel root=this.getPanel_main();
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);


        //bat dau hien ra danh sach phuc khao sinh vien nop
        btn_xntpk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");


                String ngay1=tf_nbd.getText();
                String thang1=tf_tbd.getText();
                String nam1= tf_nambd.getText();
                String firstDate=ngay1+"-"+thang1+"-"+nam1;



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
                        ngayBatDau=sdf.parse(firstDate);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        ngayKetThuc=sdf.parse(secondDate);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    if(ngayBatDau.compareTo(ngayKetThuc)>=0)
                    {
                        JOptionPane.showMessageDialog(getPanel_main(),"Ngày kết thúc phải sau ngày bắt đầu");

                    }
                    else
                    {
                        //hiện ra danh sách phúc khảo giữa 2 ngày vừa nhập
                        phucKhaoSinhVienList=PhucKhaoSinhVien.giuaHaiNgay(ngayBatDau,ngayKetThuc);
                        data=parseDSPKToListString(phucKhaoSinhVienList);
                        tb_dspk.setModel(new DefaultTableModel(data,column));

                    }

                }
                else
                {
                    JOptionPane.showMessageDialog(getPanel_main(),"Hãy nhập đủ thông tin");

                }


            }
        });

        btn_cn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int mssv=Integer.parseInt(tf_mssv.getText());
                String mon= tf_mon.getText();
                String cot=tf_cotdiem.getText();
                int diem=0;
                if(Util.Util.stringCompare(cot,"Điểm giữa kỳ")==0)
                {
                    diem=1;
                }
                if(Util.Util.stringCompare(cot,"Điểm cuối kỳ")==0)
                {
                    diem=2;
                }
                if(Util.Util.stringCompare(cot,"Điểm khác")==0)
                {
                    diem=3;
                }
                if(Util.Util.stringCompare(cot,"Điểm tổng")==0)
                {
                    diem=4;
                }
                PhucKhaoSinhVien search=PhucKhaoSinhVien.searchByMssvMonCotDiem(mssv,mon,diem);
                search.setTinhTrang(tf_tt.getText());
                PhucKhaoSinhVienDAO.updatePhucKhaoSinhVien(search);

                phucKhaoSinhVienList=PhucKhaoSinhVien.giuaHaiNgay(ngayBatDau,ngayKetThuc);
                data=parseDSPKToListString(phucKhaoSinhVienList);
                tb_dspk.setModel(new DefaultTableModel(data,column));
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
    public String[][]parseDSPKToListString(List<PhucKhaoSinhVien>list)
    {
        String res[][]=new String[list.size()][];
        for(int i=0;i<list.size();i++)
        {
            PhucKhaoSinhVien a=list.get(i);
            String mssv=String.valueOf(a.getMssv());
            String hoTen=a.getHoTen();
            String mon=a.getMon();
            String cotDiem=null;
            if(a.getCotDiem()==1)
            {
                cotDiem="Điểm giữa kỳ";

            }
            if(a.getCotDiem()==2)
            {
                cotDiem="Điểm cuối kỳ";

            }
            if(a.getCotDiem()==3)
            {
                cotDiem="Điểm khác";

            }
            if(a.getCotDiem()==4)
            {
                cotDiem="Điểm tổng";

            }

            String diemMongMuon=String.valueOf(a.getDiemMongMuon());
            String lyDo=a.getLyDo();
            String temp[]={mssv,hoTen,mon,cotDiem,diemMongMuon,lyDo,a.getTinhTrang()};
            res[i]=temp;
        }
        return res;
    }
}
