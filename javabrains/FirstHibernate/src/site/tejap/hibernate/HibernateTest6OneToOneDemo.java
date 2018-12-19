package site.tejap.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import site.tejap.dto.UserDetails4;
import site.tejap.dto.Vehicle;

public class HibernateTest6OneToOneDemo {

	public static void main(String[] args) {
		
		Vehicle car = new Vehicle();
		car.setVehicleName("BMW 7 Series");
		
		UserDetails4 user = new UserDetails4();
		user.setName("Teja");
		user.setVehicle(car);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(user);
		session.save(car);
		
		transaction.commit();
		session.close();
		
	}
}
