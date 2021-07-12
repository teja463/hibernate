package javabrains.jpql;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) {
        jpqlDemo();
//        namedQueryDemo();
//        namedNativeQuery();
    }

    private static void namedNativeQuery() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Query query = entityManager.createNamedQuery("UserDetails.byName");
        query.setParameter("name", "Teja");
        UserDetails user = (UserDetails) query.getSingleResult();
        System.out.println(user.getName());

        transaction.commit();
        entityManager.close();
    }

    private static void namedQueryDemo(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Query query = entityManager.createNamedQuery("UserDetails.byId");
        query.setParameter("id", 2);
        UserDetails user = (UserDetails) query.getSingleResult();
        System.out.println(user.getName());

        transaction.commit();
        entityManager.close();
    }

    private static void jpqlDemo(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<UserDetails> query = entityManager.createQuery("select u from JPQLUser u where u.id=:id", UserDetails.class);
        query.setParameter("id", 1);
        List<UserDetails> resultList = query.getResultList();
        System.out.println(resultList);

        TypedQuery<UserDetails> query1 = entityManager.createQuery("select new JPQLUser(u.id, u.name) from JPQLUser u", UserDetails.class);
        List<UserDetails> resultList1 = query1.getResultList();
        System.out.println(resultList1);

        Query nativeQuery = entityManager.createNativeQuery("select * from change_user", UserDetails.class);
        List resultList2 = nativeQuery.getResultList();
        transaction.commit();
        entityManager.close();
    }
}
