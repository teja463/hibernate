package site.tejap.hibernate;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import site.tejap.dto.UserDetails;

/**
 * @author BPonnuru
 *	
 * @Desc 
 * Saves the details into DB
 *
 */
public class HibernateTest1 {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserName("teja464");
		user.setDescription("Sample description");
		user.setDob(new Date());
		user.setGender("Male");

		UserDetails user2 = new UserDetails();
		user2.setDescription("Second user updated");
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		session.save(user2);
		Transaction transaction2 = session.getTransaction();
		transaction2.commit();
		session.close();
		
		System.out.println(transaction.equals(transaction2));
		
	}
}
