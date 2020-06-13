package DAO;

import DTO.Lop;
import DTO.SinhVien;
import DTO.SinhVien_Mon;
import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class SinhVien_MonDAO {
    private static SessionFactory factory;
    public static void addSinhVienMon(SinhVien_Mon sm) {
        // get session factory
        factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(sm);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void deleteSinhVienMon(SinhVien_Mon sm)
    {
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(sm);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List listSinhVienMon()
    {
        List listSinhVienMon=new ArrayList<SinhVien>();

        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {

            listSinhVienMon=session.createQuery("FROM SinhVien_Mon").list();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listSinhVienMon;
    }
}
