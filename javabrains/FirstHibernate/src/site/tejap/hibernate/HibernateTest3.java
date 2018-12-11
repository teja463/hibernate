package site.tejap.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import site.tejap.dto.Address;
import site.tejap.dto.UserDetails;

/**
 * @author BPonnuru
 *
 * Embedded objects and overriding attribute properties in embedded objects
 */
public class HibernateTest3 {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		UserDetails user = new UserDetails();
		user.setUserName("teja464");
		user.setDescription("Sample description");
		user.setDob(new Date());
		user.setGender("Male");

		
		Address address = new Address();
		address.setCity("Hyderabad");
		address.setState("TS");
		
		Address office = new Address();
		address.setCity("Bangalore");
		address.setState("KA");
		
		user.setHomeAddress(address);
		user.setOfficeAddress(office);
		session.save(user);
		transaction.commit();
		session.close();
		
		
	}
}
