package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.entity.HelloWorld;

public class Demo01 {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		HelloWorld hw = new HelloWorld();
		hw.setName("Teja");
		
		session.save(hw);
		transaction.commit();
		session.close();
	}
}
