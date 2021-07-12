package hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneDemo {

    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        Passport passport = new Passport();
        passport.setPassportId("J2839833");

        Person person = new Person("Ramya", passport);
        session.persist(person);

        transaction.commit();
        session.close();
    }
}
