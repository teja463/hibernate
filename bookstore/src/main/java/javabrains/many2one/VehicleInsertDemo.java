package javabrains.many2one;

import hibernate.manytoone.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class VehicleInsertDemo {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        Vehicle vehicle = new Vehicle();
        vehicle.setName("Vehicle without owner");

        UserDetails user = new UserDetails();
        user.setName("Teja...");
//        vehicle.setUser(null);

        entityManager.persist(vehicle);
        transaction.commit();
        entityManager.close();
    }
}
