package javabrains.entitycollection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class Demo {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        UserDetails user = new UserDetails();
        user.setName("Teja");

        Address address1 = new Address("BLR", "KA", "IN");
        Address address2 = new Address("VJA", "AP", "IN");
        Set<Address> addresses = new HashSet<>();
        addresses.add(address1);
        addresses.add(address2);

        user.setAddresses(addresses);

        Vehicle car = new Vehicle();
        car.setName("BMW Car");

        em.persist(user);
        em.persist(car);
        transaction.commit();
        em.close();
        emf.close();
    }
}
