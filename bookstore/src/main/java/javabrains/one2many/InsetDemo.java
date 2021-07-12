package javabrains.one2many;

import hibernate.manytoone.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsetDemo {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        Vehicle car = new Vehicle();
        car.setName("BMW Car");

        Vehicle bike = new Vehicle();
        bike.setName("Pulsar 150");

        UserDetails user = new UserDetails();
        user.setName("New Teja");
        user.getVehicle().add(car);
        user.getVehicle().add(bike);

        entityManager.persist(user);
        transaction.commit();
        entityManager.close();
    }
}
