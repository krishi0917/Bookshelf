package intuit.craftexcercise;

import java.text.Annotation;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class SessionFactoryObj {
		
	@SuppressWarnings("deprecation")
	public static SessionFactory getSessionFactory(){
		return new AnnotationConfiguration().configure().buildSessionFactory();
	}
}
