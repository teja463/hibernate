package javabrains.many2many;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.stream.Collectors;

public class Demo {


    public static void main(String[] args) {
//        insertDemo();
        findDemo();
    }

    private static void insertDemo() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        UserDetails user = new UserDetails();
        user.setName("Teja");

        Vehicle car = new Vehicle();
        car.setName("car");

        Vehicle bike = new Vehicle();
        bike.setName("bike");

        user.getVehicles().add(car);
        user.getVehicles().add(bike);

        entityManager.persist(user);
        transaction.commit();
        entityManager.close();
    }

    private static void findDemo(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        UserDetails userDetails = entityManager.find(UserDetails.class, 1);
        System.out.println(userDetails.getName());
        System.out.println(userDetails.getVehicles().stream().map( vehicle -> vehicle.getName()).collect(Collectors.toList()));

        transaction.commit();
        entityManager.close();
    }
}
