package site.tejap.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import site.tejap.dto.UserDetails;

/**
 * @author BPonnuru
 *
 * @desc Gets the details from DB
 */
public class HibernateTest2 {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		UserDetails user = (UserDetails) session.get(UserDetails.class, 2);
		System.out.println(user);
	}
}
