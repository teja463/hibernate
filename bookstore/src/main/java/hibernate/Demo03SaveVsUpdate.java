package hibernate;

import hibernate.entity.HelloWorld;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Demo03SaveVsUpdate {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        final Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        HelloWorld hw1 = session.get(HelloWorld.class, 2);
        hw1.setName("Random name");

        transaction.commit();
        session.close();


        final Session session1 = sessionFactory.openSession();
        Transaction transaction1 = session1.beginTransaction();

        HelloWorld hw2 = session1.get(HelloWorld.class, 2);
        hw1.setName("Changed for hw2");
        session1.merge(hw1);

        transaction1.commit();
        session1.close();
    }
}
