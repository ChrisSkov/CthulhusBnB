/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Chris
 */
@Entity
@Table(name = "Rooms")
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Hotel hotel;
    private int price;
    private boolean availible;

    public int getId()
    {
        return id;
    }

    public Room()
    {
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Room))
        {
            return false;
        }
        Room other = (Room) object;
        if (this.id != other.id)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "entities.Room[ id=" + id + " ]";
    }

}
