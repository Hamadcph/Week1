
package rest;

import entities.Animals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * REST Web Service
 *
 * @author hamad
 */
@Path("animal")
public class AnimalResource {
    
    @Context
    private UriInfo context;
    List<Animals> animals = new ArrayList<>();
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    

    public AnimalResource() {
       
   }
    
    @GET
    //@Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "Hello from my first web service";         
    }
    @GET
    @Path("lion")
    @Produces(MediaType.APPLICATION_JSON)
     public String getLion() {
        return "LIIIOOOON";             
    }

    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }    
    
    @GET
    @Path("random")
    @Produces(MediaType.APPLICATION_JSON)
    public String getRandomAnimalJson() {
        
        animals.add(new Animals("Tiger",new Date(20/01/2017), "roar"));
        animals.add(new Animals("Dog", new Date(21/04/95), "bark"));
        animals.add(new Animals("Giraffe",new Date(20/3/2003), "dunno"));
        animals.add(new Animals("Cat",new Date(20/3/2004), "mjaw")); 
        Random random = new Random();
        
        //int index = random.nextInt(animals.size());
        Animals random1 = animals.get(random.nextInt(animals.size()));
        
        return new Gson().toJson(random1);

	}
    
}
