package hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneDemo2 {

    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        Wife wife = new Wife("Ramya");
        Husband husband = new Husband("Teja",wife);

        session.save(husband);
        session.getTransaction().commit();
        session.close();
    }
}
