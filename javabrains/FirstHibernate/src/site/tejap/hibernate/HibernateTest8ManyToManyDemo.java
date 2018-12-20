package site.tejap.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import site.tejap.dto.UserDetails6;
import site.tejap.dto.Vehicle3;

public class HibernateTest8ManyToManyDemo {

	public static void main(String[] args) {
		
		UserDetails6 user = new UserDetails6();
		user.setName("Teja");
		
		Vehicle3 vehicle = new Vehicle3();
		vehicle.setName("Car");
		
		Vehicle3 vehicle2 = new Vehicle3();
		vehicle2.setName("Bike");
		
		user.getVehicles().add(vehicle);
		user.getVehicles().add(vehicle2);
		
		vehicle.getUsers().add(user);
		vehicle2.getUsers().add(user);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(user);
		session.save(vehicle);
		session.save(vehicle2);
		
		transaction.commit();
		session.close();
		
	}
}
