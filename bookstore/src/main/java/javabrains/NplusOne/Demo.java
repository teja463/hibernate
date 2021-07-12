package javabrains.NplusOne;

import javabrains.many2one.Comment;
import javabrains.many2one.Vehicle;

import javax.persistence.*;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Comment> query = entityManager.createQuery("from CommentM2O", Comment.class);
        List<Comment> comments = query.getResultList();
        comments.forEach(comment -> {
            System.out.println(comment.getText());
        });
    }
}
