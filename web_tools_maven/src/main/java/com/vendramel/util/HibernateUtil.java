package com.vendramel.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
    
    private static final SessionFactory sessionFactory;
    public static final String HIBERNATE_SESSION = "hibernate_session";
    
    static{
        
        try {
            
            System.out.println("Configurando a Session!");
            
            Configuration configuration = new Configuration().configure();
            
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                        
            System.out.println("Session criada corretamente!");
        } catch (Exception e) {
            System.out.println("Erro ao iniciar Session -> " + e);
            throw new ExceptionInInitializerError(e);
        }
        
        
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}