package javabrains.one2one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveDemo {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        UserDetails user = new UserDetails();
        user.setName("Teja");

        Vehicle vehicle = new Vehicle();
        vehicle.setName("Jaguar");

        user.setVehicle(vehicle);
//        UserDetails user = em.find(UserDetails.class, 4);
//        em.remove(user);
        em.persist(user);
        transaction.commit();
        em.close();
    }
}
