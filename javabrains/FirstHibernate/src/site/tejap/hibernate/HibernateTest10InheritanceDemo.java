package site.tejap.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import site.tejap.dto.Bike;
import site.tejap.dto.Car;
import site.tejap.dto.Vehicle5;

public class HibernateTest10InheritanceDemo {

	public static void main(String[] args) {
		
		Vehicle5 vehicle = new Vehicle5();
		vehicle.setName("Generic vehicle");
		
		Car car  =new Car();
		car.setName("Porche");
		car.setSteering("Car steering");
		
		Bike bike = new Bike();
		bike.setName("Bike");
		bike.setHandle("Bike Handle");
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(vehicle);
		session.save(car);
		session.save(bike);
		
		transaction.commit();
		session.close();
	}
}
