package entity;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Temporal(TemporalType.DATE)
    private java.util.Date created;
    private String firstName;
    private String lastName;


    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.created = new Date();
    }

    public Customer() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreated() {
        return created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer:" + "id = " + id + ", firstName = " + firstName + ", LastName = " + lastName + ", created = " + created;
    }

}
