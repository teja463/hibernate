package javabrains.many2one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserInsertDemo {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        UserDetails user = new UserDetails();
        user.setName("Teja");

        Vehicle vehicle = new Vehicle();
        vehicle.setName("BMW");

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setName("Audi");

        user.getVehicles().add(vehicle);
        user.getVehicles().add(vehicle2);
//        user.addVehicle(vehicle);
//        user.addVehicle(vehicle2);

        entityManager.persist(user);
        transaction.commit();
        entityManager.close();
    }
}
