package jpa.jpqa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertDemo {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Guide guide = new Guide();
        guide.setName("Teja");
        guide.setSalary(96000);

        Student student = new Student();
        student.setName("Student 1");
        student.setEnrollmentId("1000");

        Student student2 = new Student();
        student.setName("Student 2");
        student.setEnrollmentId("2000");

        guide.getStudent().add(student);
        guide.getStudent().add(student2);

        entityManager.persist(guide);

        transaction.commit();

    }
}
