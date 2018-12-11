package site.tejap.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import site.tejap.dto.Address;
import site.tejap.dto.UserDetails3;

public class HibernateTest5 {

	public static void main(String[] args) {
		
		UserDetails3 user = new UserDetails3();
		user.setUserName("teja46d3");
		
		Address address = new Address();
		address.setCity("HYD");
		address.setState("TS");
		
		user.getAddress().add(address);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
	}
}
