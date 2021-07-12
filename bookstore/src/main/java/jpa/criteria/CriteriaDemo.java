package jpa.criteria;

import jpa.jpqa.Guide;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.List;

public class CriteriaDemo {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
        EntityManager em = emf.createEntityManager();


        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<Guide> criteria = criteriaBuilder.createQuery(Guide.class);
        Root<Guide> root = criteria.from(Guide.class);
        CriteriaQuery<Guide> query2 = criteria.select(root);

        TypedQuery<Guide> query1 = em.createQuery(query2);
        List<Guide> resultList1 = query1.getResultList();
        System.out.println(resultList1);


        CriteriaQuery<String> criteria2 = criteriaBuilder.createQuery(String.class);
        Root<Guide> root2 = criteria2.from(Guide.class);
        Path<String> name = root2.get("name");
        CriteriaQuery<String> select = criteria2.select(name);


    }
}
