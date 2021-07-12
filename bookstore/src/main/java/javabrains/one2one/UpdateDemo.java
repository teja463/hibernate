package javabrains.one2one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateDemo {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        UserDetails user = em.find(UserDetails.class, 2);
        user.setName("Teja ...");

        Vehicle vehicle = user.getVehicle();
        vehicle.setName("Jaguar...");

        user.setVehicle(vehicle);
//        UserDetails user = em.find(UserDetails.class, 4);
//        em.remove(user);
        em.persist(user);
        transaction.commit();
        em.close();
    }
}
