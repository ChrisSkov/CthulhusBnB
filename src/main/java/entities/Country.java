/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Table;

/**
 *
 * @author Chris
 */
@Entity
@Table(name = "countries")
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "country")
    private List<Hotel> hotels;
    private String name;
    
    public List<Hotel> getHotels() {
        return hotels;
    }

    public Country(List<Hotel> hotels, String name) {
        this.hotels = hotels;
        this.name = name;
    }
    
    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Country() {
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Country)) {
            return false;
        }
        Country other = (Country) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Country[ id=" + id + " ]";
    }

    public static void main(String[] args) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("pu");
        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();

        Country c1 = new Country();
        Country c2 = new Country();
        Country c3 = new Country();
        Country c4 = new Country();
        Country c5 = new Country();

        c1.setName("Denmark");
        c2.setName("England");
        c3.setName("USA");
        c4.setName("Spain");
        c5.setName("Nigeria");

        entitymanager.persist(c1);
        entitymanager.persist(c2);
        entitymanager.persist(c3);
        entitymanager.persist(c4);
        entitymanager.persist(c5);

        Hotel h1 = new Hotel();
        Hotel h2 = new Hotel();
        Hotel h3 = new Hotel();
        Hotel h4 = new Hotel();
        Hotel h5 = new Hotel();

        h1.setName("Radisson hotel");
        h1.setCountry(c1);
        h1.setStars("5-stars");

        h2.setName("London hotel");
        h2.setCountry(c2);
        h2.setStars("3-stars");

        h3.setName("NY hotel");
        h3.setCountry(c3);
        h3.setStars("6-stars");

        h4.setName("Madrid hotel");
        h4.setCountry(c4);
        h4.setStars("2-stars");

        h5.setName("Osas hotel");
        h5.setCountry(c5);
        h5.setStars("10-stars");

        Room r1 = new Room();
        Room r2 = new Room();
        Room r3 = new Room();
        Room r4 = new Room();
        Room r5 = new Room();

        r1.setAvailible(true);
        r1.setHotel(h1);
        r1.setPrice(500);

        r2.setAvailible(false);
        r2.setHotel(h2);
        r2.setPrice(300);

        r3.setAvailible(true);
        r3.setHotel(h3);
        r3.setPrice(100);

        r4.setAvailible(true);
        r4.setHotel(h4);
        r4.setPrice(150);

        r5.setAvailible(false);
        r5.setHotel(h5);
        r5.setPrice(1000);

        List<Room> roomsList = new ArrayList<>();
        roomsList.add(r1);
        roomsList.add(r2);
        roomsList.add(r3);
        roomsList.add(r4);
        roomsList.add(r5);

        h1.setRoom(roomsList);
        h2.setRoom(roomsList);
        h3.setRoom(roomsList);
        h4.setRoom(roomsList);
        h5.setRoom(roomsList);

        entitymanager.persist(h1);
        entitymanager.persist(h2);
        entitymanager.persist(h3);
        entitymanager.persist(h4);
        entitymanager.persist(h5);

        User user = new User("user", "1234");
        User admin = new User("admin", "1234");
        User both = new User("user_admin", "1234");

        Role userRole = new Role("user");
        Role adminRole = new Role("admin");
        user.addRole(userRole);
        admin.addRole(adminRole);
        both.addRole(userRole);
        both.addRole(adminRole);
        entitymanager.persist(userRole);
        entitymanager.persist(adminRole);
        entitymanager.persist(user);
        entitymanager.persist(admin);
        entitymanager.persist(both);

        entitymanager.getTransaction().commit();
        entitymanager.close();
        emfactory.close();

    }

}
