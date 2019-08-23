package dbfacade;

import entity.Customer;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FacadeRunner {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        CustomerFacade cf = CustomerFacade.getCustomerFacade(emf);
        Customer c1 = cf.addCustomer("Hamad", "Shah");
        Customer c2 = cf.addCustomer("Jacob", "Jabr");
        Customer c3 = cf.addCustomer("Saz", "Kasim");
        System.out.println("Customer1: " + cf.findByID(c1.getId()));
        System.out.println("Customer2: " + cf.findByID(c2.getId()));
        System.out.println("Customer3: " + cf.findByID(c3.getId()));
        List<Customer> customer = cf.allCustomers();
        for (Customer c : customer) {
            System.out.println(c.toString());
        }
    }
}
