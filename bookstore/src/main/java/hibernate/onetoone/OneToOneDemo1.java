package hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneDemo1 {

    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();

        Person person = session.get(Person.class, 1);
        System.out.println(person.getName());
        System.out.println("person.getPassport().getPassportId() = " + person.getPassport().getPassportId());

        session.close();
    }
}
