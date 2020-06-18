package DAO;

import DTO.DiemSinhVien;
import DTO.Lop;
import DTO.Lop_MonHoc;
import DTO.PhucKhaoSinhVien;
import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhucKhaoSinhVienDAO {
    private static SessionFactory factory;

    public static void addPhucKhaoSinhVien(PhucKhaoSinhVien pksv) {
        // get session factory
        factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(pksv);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List listPhucKhaoSinhVien() {
        List listLopMon=new ArrayList<Lop_MonHoc>();

        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {

            listLopMon=session.createQuery("FROM PhucKhaoSinhVien").list();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listLopMon;
    }

    public static void updatePhucKhaoSinhVien(PhucKhaoSinhVien a)
    {
        PhucKhaoSinhVienDAO.deletePhucKhaoSinhVien(a);
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập tình trạng phúc khảo:");
        String tinhTrang=sc.nextLine();
        a.setTinhTrang(tinhTrang);
        PhucKhaoSinhVienDAO.addPhucKhaoSinhVien(a);
        System.out.println("Cập nhật tình trạng thành công");

    }

    public static void deletePhucKhaoSinhVien(PhucKhaoSinhVien pk) {
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(pk);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


}
