package javabrains.changedetection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Demo {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        UserDetails user = new UserDetails();
        user.setName("Teja");

        entityManager.persist(user);
        user.setName("Before commit");

        transaction.commit();
        entityManager.close();

    }
}
