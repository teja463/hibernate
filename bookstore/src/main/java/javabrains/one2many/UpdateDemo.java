package javabrains.one2many;

import hibernate.manytoone.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateDemo {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        Vehicle car = new Vehicle();
        car.setName("Audi Car");


        UserDetails user = entityManager.find(UserDetails.class, 2);
        user.getVehicle().add(car);

        entityManager.persist(user);
        transaction.commit();
        entityManager.close();
    }
}
