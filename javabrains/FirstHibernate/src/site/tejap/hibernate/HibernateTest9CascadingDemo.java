package site.tejap.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import site.tejap.dto.UserDetails7;
import site.tejap.dto.Vehicle4;

public class HibernateTest9CascadingDemo {

	public static void main(String[] args) {

		UserDetails7 user = new UserDetails7();
		user.setName("Teja");

		Vehicle4 vehicle = new Vehicle4();
		vehicle.setName("Car");

		Vehicle4 vehicle2 = new Vehicle4();
		vehicle2.setName("Jeep");
		
		user.getVehicles().add(vehicle);
		user.getVehicles().add(vehicle2);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.persist(user);
		
		transaction.commit();
		session.close();

	}
}
