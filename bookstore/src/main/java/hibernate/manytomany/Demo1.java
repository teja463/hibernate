package hibernate.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Demo1 {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        final Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Movie darkNight = new Movie("Dark Knight");
        Movie interstellar = new Movie("Interstellar");

        Actor bale = new Actor("Christian Bale");

        Actor bane = new Actor("Bane");

        Actor mathew = new Actor("Mathew Maccnoahey");

        darkNight.getActors().add(bale);
        darkNight.getActors().add(bane);

        interstellar.getActors().add(mathew);

        session.persist(darkNight);
        session.persist(interstellar);

        transaction.commit();
        session.close();
    }
}
