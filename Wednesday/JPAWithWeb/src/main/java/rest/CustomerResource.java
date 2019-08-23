package rest;

import DBFacade.CustomerFacade;
import Entities.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * REST Web Service
 *
 * @author hamad
 */
@Path("customer")
public class CustomerResource {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static CustomerFacade instance;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CustomerResource
     */
    public CustomerResource() {
    }

    /**
     * Retrieves representation of an instance of rest.CustomerResource
     * @return an instance of java.lang.String
     */
    @Path("all")
    @GET
    //@Produces(MediaType.APPLICATION_JSON)
    public int getAllCustomersJson() {
        
        CustomerFacade cf = new CustomerFacade();
        cf.allCustomers();
        return cf.getNumberOfCustomers();
        
    }
    
        @GET
    @Path("random")
    @Produces(MediaType.APPLICATION_JSON)
    public String getRandomCustomerJson() {
        return "";
    }


}
    

    /**
     * PUT method for updating or creating an instance of CustomerResource
     * @param content representation for the resource
     */
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void putJson(String content) {
//    
//    }
    
    
    

