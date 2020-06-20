package DAO;

import DTO.Lop;
import DTO.PhucKhaoDiem;
import DTO.SinhVien;
import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class PhucKhaoDiemDAO {
    private static SessionFactory factory;
    public static void addPhucKhaoDiem(PhucKhaoDiem pkd) {
        // get session factory
        factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(pkd);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public static List listPhucKhaoDiem() {
        List listPhucKhao=new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {

            listPhucKhao=session.createQuery("FROM PhucKhaoDiem").list();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listPhucKhao;
    }

}
