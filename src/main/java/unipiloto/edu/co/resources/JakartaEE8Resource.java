package unipiloto.edu.co.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import unipiloto.edu.co.entidad.Persona;

/**
 *
 * @author 
 */
@Path("rest")
public class JakartaEE8Resource {
        

    private static Map<Integer, Persona> persons = new HashMap<Integer, Persona>();
    
    static{
        for (int i = 0; i < 11; i++) {
            Persona person = new Persona();
            int id = i + 1;
            int age =(new Random().nextInt(40)+1);
            person.setId(id);
            person.setFullName("My wonderfull Person " + id);
            person.setAge(age);           
            person.setSalary(age*278/3);
            persons.put(id, person);
        }
    }
    
    @GET
    @Path("getPersonByIdXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Persona getPersonByIdXML(@PathParam("id") int id){
        return persons.get(id);
    }
    @GET
    @Path("getPersonByIdJson/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Persona getPersonByIdJson(@PathParam("id") int id){
        return persons.get(id);
    }
    @GET
    @Path("getAllPersonsInXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Persona> getAllPersonsInXML(){
        return new ArrayList<Persona>(persons.values());
    }
    @GET
    @Path("getAllPersonsInJson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> getAllPersonsInJson(){
        return new ArrayList<Persona>(persons.values());
    }
    //Metodo promedio de salarios
    public double averageSalary(){
        int sumSalarys = 0;
        int cantPersons = persons.size();
        
        for (Persona persona : persons.values()) {
            sumSalarys += persona.getSalary();
        }
        
        return sumSalarys /cantPersons;
    }
    
    @GET
    @Path("getAverageSalaryInXML")
    @Produces(MediaType.APPLICATION_XML)
    public String getAverageSalaryInXML(){
        double average = averageSalary();
        return "El promedio de los salarios de todas las personas es " +average;
    }
    //Metodo suma de salarios
    public int sumSalarys(){
        int sumSalarys = 0;        
        for (Persona persona : persons.values()) {
            sumSalarys += persona.getSalary();
        }
        
        return sumSalarys;
    }   
    
    @GET
    @Path("getSumSalarysInJson")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSumSalaryInJson(){
        int sum = sumSalarys();
        return "La suma de todos los salarios es " +sum;
    }
    
    
    @POST
    @Path("addPersonInJson")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Persona addPersonInJson(Persona person){
        System.out.println(person.getId());
        persons.put(new Integer(person.getId()), person);
        return person;
    }
  
}
