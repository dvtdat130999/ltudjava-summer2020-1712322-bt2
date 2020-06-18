package DAO;

import DTO.DiemSinhVien;
import DTO.Lop;
import DTO.NguoiDung;
import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class DiemSinhVienDAO {

    private static SessionFactory factory;
    public static void addDiemSinhVien(DiemSinhVien dsv) {
        // get session factory
        factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(dsv);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List listDiemSinhVien() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List dsv=null;
        try{
            tx = session.beginTransaction();
            dsv = session.createQuery("FROM DiemSinhVien").list();

            tx.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return dsv;
    }

    public static void updateDiemSinhVien(DiemSinhVien a )
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Điểm giữa kỳ:");
        double gk=sc.nextDouble();
        System.out.print("Điểm cuối kỳ:");
        double ck=sc.nextDouble();
        System.out.print("Điểm khác:");
        double k=sc.nextDouble();
        System.out.print("Điểm tổng:");
        double tong=sc.nextDouble();
        deleteDiemSinhVien(a);
        a.setDiemGk(gk);
        a.setDiemCk(ck);
        a.setDiemKhac(k);
        a.setDiemTong(tong);
        if(a.getDiemTong()>=5)
        {
            a.setKetQua("Đậu");
        }
        else
        {
            a.setKetQua("Rớt");
        }
        DiemSinhVienDAO.addDiemSinhVien(a);
        System.out.println("Update thành công");
    }

    public static void deleteDiemSinhVien(DiemSinhVien diem) {
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(diem);
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
