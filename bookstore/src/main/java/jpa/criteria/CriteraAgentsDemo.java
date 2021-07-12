package jpa.criteria;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class CriteraAgentsDemo {

    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<Agent> criteriaQuery = criteriaBuilder.createQuery(Agent.class);

        Root<Agent> root = criteriaQuery.from(Agent.class);
        criteriaQuery.select(root);

        List<String> areas = new ArrayList<>();
        areas.add("London");
        areas.add("Chennai");

        List<Predicate> filterBy = new ArrayList<>();
        filterBy.add(criteriaBuilder.in(root.get("workingArea")));
        filterBy.add(criteriaBuilder.gt(root.get("commission"), 0.13));

        List<Order> orderBy = new ArrayList<>();
        orderBy.add(criteriaBuilder.asc(root.get("agentName")));
        orderBy.add(criteriaBuilder.desc(root.get("commission")));

        criteriaQuery.where(filterBy.toArray(new Predicate[filterBy.size()]));
        criteriaQuery.orderBy(orderBy);

        TypedQuery<Agent> query1 = em.createQuery(criteriaQuery);
        List<Agent> resultList = query1.getResultList();
        System.out.println(resultList);

        em.close();
    }
}
