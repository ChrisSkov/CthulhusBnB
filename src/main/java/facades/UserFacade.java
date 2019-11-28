package facades;

import entities.Country;
import entities.Hotel;
import entities.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import errorhandling.AuthenticationException;
import errorhandling.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;

/**
 * @author lam@cphbusiness.dk
 */
public class UserFacade {

    private static EntityManagerFactory emf;
    private static UserFacade instance;
    private List<Country> countries;

    public UserFacade() {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static UserFacade getUserFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new UserFacade();
        }
        return instance;
    }

    public User getVeryfiedUser(String username, String password) throws AuthenticationException {
        EntityManager em = emf.createEntityManager();
        User user;
        try {
            user = em.find(User.class, username);
            if (user == null || !user.verifyPassword(password)) {
                throw new AuthenticationException("Invalid user name or password");
            }
        } finally {
            em.close();
        }
        return user;
    }

    public Country getCountry(String name) throws NotFoundException {
        Country country = null;
        for (Country c : this.countries) {
            if (c.getName().equals(name)) {
                country = c;
            }
        }
        if (country == null) {
            throw new NotFoundException("No country by that name exists.");
        }
        return country;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Hotel> getAllHotel() throws NotFoundException {
        EntityManager em = getEntityManager();
        List<Hotel> allHotels = new ArrayList<>();
        try {
            allHotels = em.createQuery("select b from Hotel b", Hotel.class).getResultList();

            if (allHotels.size() == 0 || allHotels == null) {
                throw new NotFoundException("No hotels found");
            }
        } finally {
            em.close();
        }
        return allHotels;
    }

    public List<Hotel> searchForHotel(String search) throws NotFoundException {

        List<Hotel> all = getAllHotel();
        List<Hotel> result = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).toString().toLowerCase().contains(search.toLowerCase())) {
                result.add(all.get(i));
            }

        }
        return result;

    }

    public List<Country> getAllCountry() throws NotFoundException {
        EntityManager em = getEntityManager();
        List<Country> allCountries = new ArrayList<>();
        try {
            allCountries = em.createQuery("select c from Country c", Country.class).getResultList();

            if (allCountries.size() == 0 || allCountries == null) {
                throw new NotFoundException("No country found");
            }
        } finally {
            em.close();
        }
        return allCountries;
    }

    public List<Country> searchForCountry(String search) throws NotFoundException {

        List<Country> all = getAllCountry();
        List<Country> result = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).toString().contains(search)) {
                result.add(all.get(i));
            }

        }
        return result;

    }
    
        public User createUser(String userName, String userPass) {
        if (userName != null && !userName.isEmpty() && userPass != null && !userPass.isEmpty()) {
            User u = new User(userName, userPass);
            EntityManager em = getEntityManager();
            try {
                em.getTransaction().begin();
                em.persist(u);
                em.getTransaction().commit();
                return u;
            } finally {
                em.close();
            }
        }
        return null;
    }

}
