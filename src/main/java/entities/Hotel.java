/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

/**
 *
 * @author artin
 */
public class Hotel implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //other classes
    @ManyToOne(cascade = CascadeType.PERSIST, mappedby = "country")
    private Country country;
    private Room rooms;

    //self contained fields
    private String id;
    private String index;
    private String name;
    private String description;

    public Hotel(String id, String index, String name, String description, Country country, Room rooms)
    {
        this.id = id;
        this.index = index;
        this.name = name;
        this.description = description;
        this.country = country;
        this.rooms = rooms;
    }

    public Country getCountry()
    {
        return country;
    }

    public void setCountry(Country country)
    {
        this.country = country;
    }

    public Room getRooms()
    {
        return rooms;
    }

    public void setRooms(Room rooms)
    {
        this.rooms = rooms;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getIndex()
    {
        return index;
    }

    public void setIndex(String index)
    {
        this.index = index;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

}
