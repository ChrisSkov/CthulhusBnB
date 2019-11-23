/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Chris
 */
public class Country implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @OneToMany(cascade = CascadeType.PERSIST, mappedby = "country")
    private List<Hotel> hotels;

    public List getHotels()
    {
        return hotels;
    }

    public Country(List hotels)
    {
        this.hotels = hotels;
    }

 
}
