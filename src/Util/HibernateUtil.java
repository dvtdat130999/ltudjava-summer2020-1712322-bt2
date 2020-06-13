package Util;

import DTO.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate-annotation.cfg.xml
            Configuration configuration = new Configuration();

            configuration.configure("hibernate.cfg.xml");

            configuration.addAnnotatedClass(Lop.class);
            configuration.addAnnotatedClass(SinhVien.class);
            configuration.addAnnotatedClass(MonHoc.class);
            configuration.addAnnotatedClass(Lop_MonHoc.class);
            configuration.addAnnotatedClass(SinhVien_Mon.class);
            configuration.addAnnotatedClass(DiemSinhVien.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();


            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            return sessionFactory;
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
}

