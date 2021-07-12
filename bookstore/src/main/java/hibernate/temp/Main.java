package hibernate.temp;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();



        One one = new One();
        one.setName("Ramya");
        one.setEmail("ramya@sadf.com");

        Many many = new Many();
        many.setAddress("sklm");

        Many many1 = new Many();
        many1.setAddress("blr");

        one.getAddresses().add(many);
        one.getAddresses().add(many1);

        session.persist(one);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
