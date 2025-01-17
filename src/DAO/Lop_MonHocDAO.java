package DAO;

import DTO.Lop_MonHoc;
import DTO.SinhVien;
import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Lop_MonHocDAO {
    private static SessionFactory factory;

    public static void addLopMon(Lop_MonHoc lm) {
        // get session factory
        factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(lm);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List listLopMon() {
        List listLopMon=new ArrayList<Lop_MonHoc>();

        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {

            listLopMon=session.createQuery("FROM Lop_MonHoc").list();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listLopMon;
    }




}
