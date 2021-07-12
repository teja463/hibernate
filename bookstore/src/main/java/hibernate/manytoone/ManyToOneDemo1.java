package hibernate.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class ManyToOneDemo1 {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();


        User user = new User("Teja");
        Address address = new Address( "tset", user);

        session.persist(address);

        transaction.commit();
        session.close();
    }
}
