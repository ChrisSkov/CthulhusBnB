package rest;

import DTO.HotelDTO;
import entities.Country;
import entities.Hotel;
import entities.User;
import errorhandling.NotFoundException;
import facades.UserFacade;
import facades.fetchFacade;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import utils.EMF_Creator;

/**
 * @author lam@cphbusiness.dk
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("info")
public class APIResource {

    private static EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    private fetchFacade api = new fetchFacade();
    private static UserFacade FACADE = UserFacade.getUserFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello anonymous\"}";
    }

//    @GET
//    @Path("HotelList")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getJsonPeopleList() {
//        fetchFacade af = new fetchFacade();
//        String url = "https://cthulhusbnb.herokuapp.com/";
//        String url2 = "https://artinshotel.herokuapp.com/";
//        List<String> l = new ArrayList();
//        List<String> li = new ArrayList();
//        l.add("Hotels/");
//        l.add("Rooms/");
//        li.add("hotel/");
//        List<List<String>> res = new ArrayList<List<String>>();
//        res.add(li);
//        res.add(l);
//        return af.fetch(res).toString();
//    }
    @GET
    @Path("HotelList")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJsonArtinList() {
        fetchFacade af = new fetchFacade();
        String url = "https://cthulhusbnb.herokuapp.com/";
        List<String> l = new ArrayList();
        l.add("Hotels/");
        return af.fetch(url, l).toString();
    }

    @GET
    @Path("country/{index}")
    @Produces(MediaType.APPLICATION_JSON)
    public Country getCities(@PathParam(value = "index") String index) throws NotFoundException {
        return FACADE.getCountry(index);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String allUsers() {

        EntityManager em = EMF.createEntityManager();
        try {
            List<User> users = em.createQuery("select user from User user").getResultList();
            return "[" + users.size() + "]";
        } finally {
            em.close();
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("allc")
    public String allCountries() {

        EntityManager em = EMF.createEntityManager();
        try {
            List<Country> users = em.createQuery("select country from Country country").getResultList();
            return "[" + users.size() + "]";
        } finally {
            em.close();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user")
    @RolesAllowed("user")
    public String getFromUser() {
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Hello to User: " + thisuser + "\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("admin")
    @RolesAllowed("admin")
    public String getFromAdmin() {
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Hello to (admin) User: " + thisuser + "\"}";
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("allHotels")

    public String getAllHotels() throws NotFoundException {
        List<HotelDTO> allHotels = new ArrayList<>();
        List<Hotel> hotels = FACADE.getAllHotel();
        for (Hotel h : hotels) {
            allHotels.add(new HotelDTO(h));

        }

        return GSON.toJson(allHotels);
    }

    @Path("allHotels/{search}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String makeSearch(@PathParam("search") String search) throws NotFoundException {
        List<Hotel> result = new ArrayList<>();
        List<Hotel> hotels = FACADE.searchForHotel(search);

        for (Hotel h : hotels) {
            result.add(h);
        }

        return GSON.toJson(result);
    }

}
