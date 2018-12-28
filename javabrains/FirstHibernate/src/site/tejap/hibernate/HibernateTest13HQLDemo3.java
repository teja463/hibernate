package site.tejap.hibernate;

import java.util.List;
import java.util.stream.IntStream;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import site.tejap.dto.UserDetails8;

/**
 * @author bponnuru
 * HQL demo with named and query parameters
 */
public class HibernateTest13HQLDemo3 {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		IntStream.range(1, 10).forEach(a -> {
			UserDetails8 user = new UserDetails8();
			user.setName("User "+a);
			session.save(user);
			
		});

		transaction.commit();
		session.close();
		
		Session session2 = factory.openSession();
		transaction = session2.beginTransaction();
		
		Query query = session2.getNamedQuery("UserDetails.byId");
		query.setInteger("id", 5);
		query.setString("name", "User 5");
		
		Query query2 = session2.getNamedQuery("UserDetila.byName");
		query2.setString("name", "User 6");
		
		((List<UserDetails8>) query.list()).forEach(user -> {
			System.out.println(user.getName());
		});
		
		((List<UserDetails8>) query2.list()).forEach(user -> {
			System.out.println(user.getName());
		});
		
		session2.close();
	}
}
