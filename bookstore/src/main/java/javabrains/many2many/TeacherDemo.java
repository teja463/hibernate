package javabrains.many2many;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TeacherDemo {

    public static void main(String[] args) {
//        insert();
        update();
    }

    private static void find(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Teacher teacher = entityManager.find(Teacher.class, 5);

        System.out.println(teacher.getName());
        teacher.getStudents().forEach(s -> System.out.println(s.getName()));

        entityManager.persist(teacher);
        transaction.commit();
        entityManager.close();
    }
    private static void update() {
        find();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Teacher teacher = entityManager.find(Teacher.class, 5);

//        teacher.getStudents().remove(0);
        Student s1 = new Student();
        s1.setName("Test2");

        Student test1 = null;
        for(Student s: teacher.getStudents()){
            if(s.getName().equals("Test1")){
                test1 = s;
            }
        }
        teacher.getStudents().remove(test1);
//        teacher.getStudents().add(s1);

        entityManager.persist(teacher);
        transaction.commit();
        entityManager.close();

        find();
    }

    private static void insert() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Teacher t1 = new Teacher();
        t1.setName("Teja");

        Student s1 = new Student();
        s1.setName("Havish");

        t1.getStudents().add(s1);

        entityManager.persist(t1);

        transaction.commit();
        entityManager.close();
    }
}
