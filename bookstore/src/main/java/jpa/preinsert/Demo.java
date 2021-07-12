package jpa.preinsert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Demo {

    public static void main(String[] args) {
//        preInsertStrategy();
        identityStrategy();
    }

    private static void identityStrategy() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println("Flush Mode" + entityManager.getFlushMode());
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        UserIdentity user1 = new UserIdentity("Teja");
        UserIdentity user2 = new UserIdentity("Ramya");

        entityManager.persist(user1);
        entityManager.persist(user2);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    private static void preInsertStrategy() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println("Flush Mode" + entityManager.getFlushMode());
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        User user1 = new User("Teja");
        User user2 = new User("Ramya");

        entityManager.persist(user1);
        entityManager.persist(user2);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
