package hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManyDemo2 {

    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        CustomView customView = new CustomView("View 3");
        CustomViewColumns column1 = new CustomViewColumns("Column 1");
        CustomViewColumns column2 = new CustomViewColumns("Column 2");

        customView.getColumns().add(column1);
        customView.getColumns().add(column2);

        session.persist(customView);
        transaction.commit();
        session.close();
    }
}
