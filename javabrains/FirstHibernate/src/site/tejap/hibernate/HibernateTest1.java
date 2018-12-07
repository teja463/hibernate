package site.tejap.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import site.tejap.dto.UserDetails;

public class HibernateTest1 {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		
		user.setUserId(1000);
		user.setUserName("teja464");
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		Transaction transaction2 = session.getTransaction();
		transaction2.commit();
		System.out.println(transaction.equals(transaction2));
	}
}
