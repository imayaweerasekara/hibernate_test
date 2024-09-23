package org.example.config;

import org.example.entity.Address;
import org.example.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryCofiguration;
    private SessionFactory sessionFactory;
    private FactoryConfiguration() {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Address.class).addAnnotatedClass(Customer.class);
        sessionFactory=configuration.buildSessionFactory();
    }
    public static FactoryConfiguration getInstance() {
        return (factoryCofiguration==null)?factoryCofiguration=new FactoryConfiguration():factoryCofiguration;
    }
    public Session getSession() {
        return sessionFactory.openSession();
    }
}


