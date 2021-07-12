package javabrains.temp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AppUserDemo {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();


        AppUser appUser = entityManager.find(AppUser.class, 2L);
        MyUser user = new MyUser();
        user.setName("Teja");

        MyVehicle car = new MyVehicle();
        car.setName("BMW");

        user.addMyVehicle(car);
        user.setAppUser(appUser);

        entityManager.persist(user);
        transaction.commit();
        entityManager.close();
    }
}
