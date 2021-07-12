package hibernate.embed;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbaddableDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Address address = new Address("1-3-32", "Vijayawada", "Andhra Pradesh");
        Person person = new Person("Ramya", address);

        session.save(person);
        tx.commit();
        session.close();
    }
}
