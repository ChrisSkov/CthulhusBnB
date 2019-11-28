/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Chris
 */
@Entity
@Table(name = "hotels")
public class Hotel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String stars;
    

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Country country;

    @OneToMany(targetEntity=Room.class, cascade = CascadeType.PERSIST, mappedBy = "hotel")
    private List<Room> room;

    public Hotel(String name, String stars, Country country, List<Room> room) {
        this.name = name;
        this.stars = stars;
        this.country = country;
        this.room = room;
    }

    @Override
    public String toString() {
        return "Hotel{" + ", name=" + name + ", stars=" + stars + ", country=" + country.getName() + '}';
    }
    
    public Hotel()
    {
    }
    public int getId()
    {
        return id;
    }
    


    public void setId(int id)
    {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Room> getRoom() {
        return room;
    }

    public void setRoom(List<Room> room) {
        this.room = room;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.stars);
        hash = 67 * hash + Objects.hashCode(this.country);
        hash = 67 * hash + Objects.hashCode(this.room);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hotel other = (Hotel) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.stars, other.stars)) {
            return false;
        }
        if (!Objects.equals(this.country, other.country)) {
            return false;
        }
        if (!Objects.equals(this.room, other.room)) {
            return false;
        }
        return true;
    }

 
    

}
