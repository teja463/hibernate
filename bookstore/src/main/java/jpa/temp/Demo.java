package jpa.temp;

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

        One one = entityManager.find(One.class, 1);
        System.out.println(one.getName());
        System.out.println(one.getAddresses().size());

        entityManager.persist(one);
        transaction.commit();
        entityManager.close();

        EntityManager entityManager2 = entityManagerFactory.createEntityManager();
        EntityTransaction transaction2 = entityManager2.getTransaction();
        transaction2.begin();

        one.setName("Test....");
        entityManager2.merge(one);

        transaction2.commit();
        entityManager2.close();

    }
}
