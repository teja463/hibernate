package jpa;

import jpa.entity.HelloWorld;

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

        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setName("Hello World");

        entityManager.persist(helloWorld);

        transaction.commit();
        entityManager.close();
    }
}
