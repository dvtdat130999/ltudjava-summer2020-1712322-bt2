package DAO;


import DTO.NguoiDung;
import DTO.SinhVien;

import Util.HibernateUtil;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

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
        NguoiDung nguoiDung=new NguoiDung(String.valueOf(sv.getMssv()),String.valueOf(sv.getMssv()));
        NguoiDungDAO.addNguoiDung(nguoiDung);
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
    public static List searchSinhVienByTen(String hoTen) {
        List listSinhVien = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql="FROM SinhVien where hoTen='"+hoTen+"'";
            listSinhVien=session.createQuery(hql).list();

        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return listSinhVien;
    }
    public static void deleteSinhVien(SinhVien sv) {
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(sv);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void updateSinhVien(SinhVien a)
    {
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            SinhVien sv = (SinhVien) session.get(SinhVien.class, a.getMssv());
            sv.setMssv(a.getMssv());
            sv.setLop(a.getLop());
            sv.setHoTen(a.getHoTen());
            sv.setGioiTinh(a.getGioiTinh());
            sv.setCmnd(a.getCmnd());

            session.update(sv);
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
