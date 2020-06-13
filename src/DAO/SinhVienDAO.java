package DAO;

import DTO.Lop;
import DTO.SinhVien;
import Util.HibernateUtil;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SinhVienDAO {
    private static SessionFactory factory;
    public static void addSinhVien(SinhVien sv) {
        // get session factory
        factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(sv);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List listSinhVien() {
        List listSinhVien=new ArrayList<SinhVien>();

        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {

            listSinhVien=session.createQuery("FROM SinhVien").list();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listSinhVien;
    }



    public static SinhVien searchSinhVien(int mssv) {
        SinhVien sv = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            sv = (SinhVien) session.get(SinhVien.class, mssv);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return sv;
    }


}
