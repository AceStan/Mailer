package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
 
	private static final SessionFactory sessionFactory;
	static{
		try{
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		}
		catch(Throwable t){
			System.err.println("Initial SessionFactiry Creation failed"+t);
			throw new  ExceptionInInitializerError();
		}
	}
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
}
