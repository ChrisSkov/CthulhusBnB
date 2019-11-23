/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 *
 * @author Chris
 */
public class Room implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Hotel hotels;
    private int price;
    private boolean availible;
}
