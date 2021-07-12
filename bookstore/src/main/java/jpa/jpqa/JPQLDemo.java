package jpa.jpqa;

import javax.persistence.*;
import java.util.List;

public class JPQLDemo {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        /*Query query = entityManager.createQuery("select guide from JpaGuide as guide where guide.id = :id");
        query.setParameter("id", 3);
        Guide resultList = (Guide) query.getSingleResult();
        System.out.println(resultList);

        Query countQuery = entityManager.createQuery("select count(guide) from JpaGuide as guide");
        Long count = (Long)countQuery.getSingleResult();
        System.out.println("count" + count);*/

        Query query1 = entityManager.createQuery("select guide from JpaGuide as guide join guide.student student");
        List resultList = query1.getResultList();
        System.out.println(resultList);

        transaction.commit();
        if (null != entityManager && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
