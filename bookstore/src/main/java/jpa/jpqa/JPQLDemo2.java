package jpa.jpqa;

import javax.persistence.*;

public class JPQLDemo2 {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
/*
        SampleTable sampleTable = entityManager.find(SampleTable.class, 1);
        System.out.println(sampleTable);*/

        TypedQuery<String> query = entityManager.createQuery("select s.name from SampleTable s where s.id = :id", String.class);
        query.setParameter("id", 1);
        String singleResult = query.getSingleResult();
        System.out.println(singleResult);

        transaction.commit();
        entityManager.close();

    }
}
