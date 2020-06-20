package DAO;

import DTO.Lop;
import DTO.MonHoc;
import DTO.SinhVien;
import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MonHocDAO {
    private static SessionFactory factory;
    public static void addMonHoc(MonHoc monHoc) {
        // get session factory
        factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(monHoc);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List listMonHoc() {
        List listMonHoc=new ArrayList<SinhVien>();

        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {

            listMonHoc=session.createQuery("FROM MonHoc").list();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listMonHoc;
    }

    public static MonHoc searchMon(String maMon)
    {
        MonHoc mon = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            mon = (MonHoc) session.get(MonHoc.class, maMon);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return mon;
    }

}
