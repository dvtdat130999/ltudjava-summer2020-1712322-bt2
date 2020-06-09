package DAO;

import DTO.Lop;
import DTO.SinhVien;
import Util.HibernateUtil;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LopDAO {
    private static SessionFactory factory;
    public static void addLop(Lop lop) {
        // get session factory
        factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(lop);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List listLop() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List lop=null;
        try{
            tx = session.beginTransaction();
            lop = session.createQuery("FROM Lop").list();

            tx.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return lop;
    }

    public static void updateLop(String tenLop)
    {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Lop lop = (Lop) session.get(Lop.class, tenLop);
            session.update(lop);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void deleteLop(String tenLop) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Lop lop = (Lop) session.get(Lop.class, tenLop);
            session.delete(lop);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static Lop searchLop(String tenLop)
    {
        Lop lop = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            lop = (Lop) session.get(Lop.class, tenLop);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return lop;
    }

}
