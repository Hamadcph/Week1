package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hamad
 */
public class EntityRunner {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

        EntityManager em = emf.createEntityManager();
        Book b1 = new Book("Learn JPA");
        System.out.println("Book1: " + b1.toString());
        Book b2 = new Book("Learn JS");
        Book b3 = new Book("Learn REACT");
      
        try {

            em.getTransaction().begin();
            em.persist(b1);
            em.persist(b2);
            em.persist(b3);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        System.out.println("Book1: " + b1.toString());
    }
}
