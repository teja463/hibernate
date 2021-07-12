package javabrains.many2one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CommentDemo {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        UserDetails userDetails = entityManager.find(UserDetails.class, 7);

        for (int i = 0; i < 5; i++) {
            Comment comment = new Comment();
            comment.setText("Test " + i);
            userDetails.getComments().add(comment);
            comment.setUser(userDetails);
        }

        entityManager.persist(userDetails);
        transaction.commit();
        entityManager.close();

    }
}
