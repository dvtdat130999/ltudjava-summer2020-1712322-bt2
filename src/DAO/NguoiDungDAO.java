package DAO;

import DTO.Lop;
import DTO.NguoiDung;
import DTO.SinhVien;
import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class NguoiDungDAO {
    private static SessionFactory factory;
    public static void addNguoiDung(NguoiDung nd) {
        // get session factory
        factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(nd);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List listNguoiDung() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List nguoiDung=null;
        try{
            tx = session.beginTransaction();
            nguoiDung = session.createQuery("FROM NguoiDung").list();

            tx.commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return nguoiDung;
    }

    public static boolean searchNguoiDung(String taiKhoan,String matKhau)
    {
        NguoiDung res = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        boolean result=false;
        try {
            res = (NguoiDung) session.get(NguoiDung.class, taiKhoan);
            if(res==null)
            {
                result= false;
            }
            else
            {
                if(Util.Util.stringCompare(res.getMatKhau(),matKhau)==0)
                {
                    result=  true;
                }
                else
                {
                    result=  false;
                }
            }
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return result;
    }

    public static void updateNguoiDung(String taiKhoan,String matKhau)
    {
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            NguoiDung nd = (NguoiDung) session.get(NguoiDung.class, taiKhoan);
            nd.setMatKhau(matKhau);
            session.update(nd);
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
