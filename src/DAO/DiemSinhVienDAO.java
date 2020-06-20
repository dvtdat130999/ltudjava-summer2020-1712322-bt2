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
            if(dsv.getKetQua()!="Đậu"&&dsv.getKetQua()!="Rớt")
            {
                if(dsv.getDiemTong()>=5)
                {
                    dsv.setKetQua("Đậu");
                }
                else
                    dsv.setKetQua("Rớt");
            }
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
        DiemSinhVien temp=DiemSinhVien.DiemMotSinhVienMotLop(a.getLop(),a.getMaMon(),a.getNam(),a.getHocKy(),a.getMssv());
        deleteDiemSinhVien(temp);
        addDiemSinhVien(a);
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
