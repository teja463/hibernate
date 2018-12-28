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
 * HQL demo with pagination 
 */
public class HibernateTest11HQLDemo1 {

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
		
		Query query = session2.createQuery("from UserDetails8 where id > 5");
		query.setFirstResult(0);
		query.setMaxResults(2);
		List<UserDetails8> list = (List<UserDetails8>) query.list();
		list.forEach( user -> {
			System.out.println(user.getName());
		});
		
		session2.close();
	}
}
