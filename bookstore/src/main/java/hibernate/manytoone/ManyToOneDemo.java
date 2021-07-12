package hibernate.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class ManyToOneDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Guide guide = new Guide("Guide 6");
        Student student = new Student("Student 6", guide);

        session.persist(student);

        transaction.commit();
        session.close();
    }
}
