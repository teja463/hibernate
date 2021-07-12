package javabrains.temp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Set;

public class Demo {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Vehicle vehicle = entityManager.find(Vehicle.class, 15);
        System.out.println(vehicle.getName());
        System.out.println(vehicle.getUser());

//        entityManager.persist(bike);
        transaction.commit();
        entityManager.close();
    }
}
