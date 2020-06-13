package DAO;

import DTO.DiemSinhVien;
import DTO.Lop;
import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

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

}
