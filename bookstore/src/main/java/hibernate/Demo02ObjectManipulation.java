package hibernate;

import hibernate.entity.HelloWorld;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Demo02ObjectManipulation {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        final Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        HelloWorld helloWorld = session.get(HelloWorld.class, 2);
        helloWorld.setName("Automatic dirty checking 6");

        transaction.commit();
        session.close();


        final Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        helloWorld.setName("After session2 is closed");
        session2.update(helloWorld);
        session2.getTransaction().commit();
        session2.close();
    }
}
