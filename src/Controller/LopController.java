package Controller;

import DAO.LopDAO;
import DAO.SinhVienDAO;
import DTO.SinhVien;
import View.LopView;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LopController {
    private LopDAO lopDAO;
    private LopView lopView;


    public LopController(LopView view)
    {
        /*this.lopView=view;
        lopDAO=new LopDAO();

        view.addAddStudentListener(new AddStudentListener());
        view.addEdiStudentListener(new EditStudentListener());

        view.fillStudentFromSelectedRow();*/
    }
    public static void createGUI()
    {
        new LopView();

    }
    //lop AddStudentListener cho su kien click "Add"
    /*class AddStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            SinhVien student = lopView.layThongTinSinhVien();
            if (student != null) {
                SinhVienDAO.addSinhVien(student);
                studentView.showStudent(student);
                studentView.showListStudents(studentDao.getListStudents());
                studentView.showMessage("Thêm thành công!");
            }
        }
    }*/


    //dien thong tin hang student duoc chon
    class ListStudentSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            lopView.fillStudentFromSelectedRow();
        }
    }
}
