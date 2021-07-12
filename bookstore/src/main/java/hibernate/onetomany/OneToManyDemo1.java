package hibernate.onetomany;

import hibernate.manytoone.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyDemo1 {

    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Project project = session.get(Project.class, 2);

        System.out.println(project);
        session.close();
    }
}
