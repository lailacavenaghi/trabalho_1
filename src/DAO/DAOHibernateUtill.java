package DAO;



import org.hibernate.SessionFactory;

import org.hibernate.cfg.AnnotationConfiguration;



public class DAOHibernateUtill {

    

    private static final SessionFactory sessionFactory;

    

    static{

        try{

            //Fabrica de sessão

            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();   

        }catch(Throwable excecao){

            System.err.println("Criação do SessionFactory falhou!" + excecao);

            throw new ExceptionInInitializerError(excecao);

        }

    }

    

    public static SessionFactory getsessionFactory(){

        return sessionFactory;

    }

}