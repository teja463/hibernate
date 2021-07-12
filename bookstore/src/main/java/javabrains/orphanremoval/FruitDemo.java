package javabrains.orphanremoval;

import com.sun.beans.editors.ColorEditor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FruitDemo {

    public static void main(String[] args) {
//        userInsert();
        delete();

    }

    private static void delete() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        UserFruit userFruit = entityManager.find(UserFruit.class, 10);
        userFruit.setName("Teja updated");

        Set<Fruit> fruits2 = userFruit.getFruits();
        Fruit fruit = null;
        for(Fruit f : fruits2){
            if(f.getName().equals("Apple")){
                fruit = f;
            }
        }
        fruits2.remove(fruit);

        entityManager.persist(userFruit);
        transaction.commit();
        entityManager.close();
    }

    private static void userInsert(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello-world");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Fruit fruit1 = new Fruit();
        fruit1.setName("Mango");

        Fruit fruit2 = new Fruit();
        fruit2.setName("Apple");

        UserFruit user = new UserFruit();
        user.setName("Havish");
        user.addFruit(fruit1);
        user.addFruit(fruit2);

        entityManager.persist(user);
        transaction.commit();
        entityManager.close();
    }
}
