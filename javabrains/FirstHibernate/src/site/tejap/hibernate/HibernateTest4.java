package site.tejap.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import site.tejap.dto.Address2;
import site.tejap.dto.UserDetails2;

/**
 * @author BPonnuru
 * 
 * @Desc
 * To demonstrate saving collection to DB in a different table using ElementCollection and also generating the primary id for 
 * the sub table
 */
public class HibernateTest4 {

	public static void main(String[] args) {
		UserDetails2 user = new UserDetails2();

		user.setUserName("Teja");
		
		Address2 addr1  =new Address2();
		addr1.setCity("HYD");
		addr1.setState("TS");
		
		Address2 addr2  =new Address2();
		addr2.setCity("BLR");
		addr2.setState("KA");
		
		user.getAddress().add(addr1);
		user.getAddress().add(addr2);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(user);
		transaction.commit();
		session.close();
	}
}

