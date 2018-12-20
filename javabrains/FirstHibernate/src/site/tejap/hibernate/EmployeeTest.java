package site.tejap.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import site.tejap.dto.Employee;
import site.tejap.dto.Offer;

public class EmployeeTest {

	public static void main(String[] args) {
		
		Employee teja = new Employee();
		teja.setName("Teja");
		
		Offer offer = new Offer();
		offer.setCompany("IBM");
		
		Offer offer2 = new Offer();
		offer2.setCompany("Rockwell");
		
		teja.getOffers().add(offer);
		teja.getOffers().add(offer2);
		
		offer.setEmployee(teja);
		offer2.setEmployee(teja);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(teja);
		session.save(offer);
		session.save(offer2);
		
		transaction.commit();
		
		Offer offer3 = (Offer)session.get(Offer.class, 1);
		System.out.println(offer3.getCompany());
		System.out.println(offer3.getEmployee().getName());
		session.close();
	}
}
