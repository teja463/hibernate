package jpa.version;

import javax.persistence.*;
import java.util.List;

public class Client1 {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Student student = new Student("Test 1", 2000);
        student.setId(10);
        entityManager.persist(student);

        transaction.commit();
        entityManager.close();

    }
}
