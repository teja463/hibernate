package hibernate.enumdemo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EnumDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        final Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        BusinessUser user = new BusinessUser("Teja", BusinessUserType.BIZ_TYPE2);

        session.persist(user);
        transaction.commit();

        session.close();

    }
}
