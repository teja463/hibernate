package site.tejap.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import site.tejap.dto.UserDetails5;
import site.tejap.dto.Vehicle2;

public class HibernateTest7OneToManyDemo {

	public static void main(String[] args) {

		UserDetails5 user = new UserDetails5();
		user.setName("Teja");
		
		Vehicle2 car = new Vehicle2();
		car.setVehicleName("BMW 7 Series");
		
		Vehicle2 jeep = new Vehicle2();
		jeep.setVehicleName("Jeep");
		
		user.getVehicles().add(car);
		user.getVehicles().add(jeep);
		
		car.setUser(user);
		jeep.setUser(user);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(user);
		session.save(car);
		session.save(jeep);
		
		transaction.commit();
		session.close();
		
	
	}
}
