/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
import entities.Country; 

import entities.Hotel;

/**
 *
 * @author artin
 */
public class HotelDTO {
    
    private String name;
    private String stars;
    private String country;
   // private Hotel hotel;

    public HotelDTO(Hotel hotel)
    {
        this.name = hotel.getName();
        this.stars = hotel.getStars();
        this.country = hotel.getCountry().getName();
        //this.hotel = hotel.getHotel();

    }

    
    
}
