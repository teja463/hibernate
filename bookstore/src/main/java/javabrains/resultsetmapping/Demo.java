package javabrains.resultsetmapping;

import javax.persistence.*;
import java.util.List;

public class Demo {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Query nativeQuery = entityManager.createNativeQuery("select uf.id, uf.name, tf.name as fruit from temp_userfruit uf inner join temp_fruit tf on uf.id = tf.user_id", "UserFruitMapping");
        List<UserFruitMapping> resultList = (List<UserFruitMapping>)nativeQuery.getResultList();
        resultList.forEach(System.out::println);

//        TypedQuery<Actor> query = entityManager.createQuery("select a from MyActor a", Actor.class);
//        List<Actor> resultList1 = query.getResultList();
//        System.out.println(resultList1);

    }

    private static void insert(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Actor a = new Actor("Test1", 100000.00);
        Actor b = new Actor("Test2", 200000.00);
        Actor c = new Actor("Test3", 300000.00);

        entityManager.persist(a);
        entityManager.persist(b);
        entityManager.persist(c);
        transaction.commit();
        entityManager.close();
    }
}
