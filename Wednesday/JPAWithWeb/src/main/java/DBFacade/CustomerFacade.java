package DBFacade;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import Entities.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;


public class CustomerFacade {
    
    private static EntityManagerFactory emf;
    private static CustomerFacade instance;

    public CustomerFacade() {
    }

    public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();    
        }
        return instance;
    }

    public Customer findByID(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Customer c1 = em.find(Customer.class, id);
            return c1;
        } finally {
            em.close();
        }
    }

    public int getNumberOfCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query
                    = em.createQuery("Select customer from Customer customer", Customer.class);
            return query.getMaxResults();
        } finally {
            em.close();
        }
    }

    public List<Customer> allCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query
                    = em.createQuery("Select customer from Customer customer", Customer.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    Customer addCustomer(String fName, String lName) {
        Customer c1 = new Customer(fName, lName);
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(c1);
            em.getTransaction().commit();
            return c1;
        }finally {
            em.close();
        }

    }

}


