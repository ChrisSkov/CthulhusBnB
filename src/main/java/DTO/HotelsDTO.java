/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;


import java.util.ArrayList;
import java.util.List;
import entities.Hotel;


/**
 *
 * @author artin
 */
public class HotelsDTO {
    
    private List<HotelDTO> HotelDTO = new ArrayList<HotelDTO>();
    public HotelsDTO(List<Hotel> hotel) {
        
        for(int i = 0; i < hotel.size(); i++) {
           this.hotelsDTO.add(new HotelDTO(hotel.get(i)));
            
        }
        
        
    }
   
    public List<HotelDTO> getHotelsDTO() {
        return hotelsDTO;
    }

    
}
