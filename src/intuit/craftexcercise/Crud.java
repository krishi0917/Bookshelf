package intuit.craftexcercise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Crud {
	Session session;
	SessionFactory s;
	public Crud(){}
	
	public Session crudOpen(){
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		return session;
	}
	
	public void crudClose(){
		session.close();
		s.close();
	}
	public long save(Record r){
		long id = 0;
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		session.save(r);
		session.getTransaction().commit();		
		session.close();
		s.close();
		return id;
	}
	
	public Record get(Record r, long id){
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		Record newR;
		newR = (Record)session.get(r.getClass(), id);
		session.close();
		s.close();
		return newR;
	}
	
	public void update(Record r){
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		session.update(r);
		session.getTransaction().commit();
		session.close();
		s.close();
	}
	
	public void delete(Record r){
		s = SessionFactoryObj.getSessionFactory();
		session = s.openSession();
		session.beginTransaction();
		session.delete(r);
		session.getTransaction().commit();
		session.close();
		s.close();
	}

}
