package javabrains.one2one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class WifeInsertDemo {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        Husband husband = new Husband();
        husband.setName("Husband");

        Wife wife = new Wife();
        wife.setName("Wife");
        wife.addHusband(husband);

        entityManager.persist(wife);
        transaction.commit();
        entityManager.close();
    }
}
