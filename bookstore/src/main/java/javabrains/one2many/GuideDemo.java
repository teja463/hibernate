package javabrains.one2many;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GuideDemo {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Guide guide = new Guide();
        guide.setName("Ramya");

        Student student = new Student();
        student.setName("JB");

        Student student2 = new Student();
        student2.setName("Another JB");

        guide.getStudents().add(student);
        guide.getStudents().add(student2);

        entityManager.persist(guide);
        transaction.commit();
        entityManager.close();

    }
}
