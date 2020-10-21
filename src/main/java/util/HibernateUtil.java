package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import net.bytebuddy.asm.Advice.This;

public class HibernateUtil {
	
	private static final SessionFactory FACTORY = createSessionFactory();
	
	private static SessionFactory createSessionFactory() {
		
		SessionFactory factory = null;
		try {
			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
			factory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
			return factory;
		} catch (Exception e) {
			e.printStackTrace();
			return factory;
		}
		
	}
	
	public static SessionFactory getSessionFactory() {
		return FACTORY;
	}
	public static void closeSessionFactory() {
		if(FACTORY != null) {
			FACTORY.close();
		}
	}
	

}
