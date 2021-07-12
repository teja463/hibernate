package hibernate.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToOneDemo3 {

    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        Project project = session.get(Project.class, 2);
        Employee employee = new Employee("Divya", project);

        session.save(employee);
        transaction.commit();
        session.close();
    }
}
