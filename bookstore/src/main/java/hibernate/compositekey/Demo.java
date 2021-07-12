package hibernate.compositekey;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Demo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        final Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        ParentPrimaryKey key = new ParentPrimaryKey("Parent", "2");
        Parent parent = new Parent(key);

        Child child1 = new Child("P2 -> Child1");
        Child child2 = new Child("P2 -> Child2");

        parent.addChild(child1);
        parent.addChild(child2);

        session.persist(parent);

        transaction.commit();
        session.close();
    }
}
