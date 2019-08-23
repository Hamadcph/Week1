package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

public class EntityRunner {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

        EntityManager em = emf.createEntityManager();

        Customer c1 = new Customer("Hamad", "Shah");
        Customer c2 = new Customer("Sazvan", "Kasim Ali");
        Customer c3 = new Customer("Jacob", "Jabr");

        try {
            em.getTransaction().begin();
            em.persist(c1);
            System.out.println("Customer: " + c1.toString());
            em.persist(c2);
            em.persist(c3);
            em.getTransaction().commit();
            System.out.println("Customer: " + c1.toString());
        } finally {

            em.close();
        }
    }

}
