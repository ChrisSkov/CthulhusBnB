/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "Country")
    private List<Hotel> hotels;

    public int getId()
    {
        return id;
    }

    public Country()
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
        if (!(object instanceof Country))
        {
            return false;
        }
        Country other = (Country) object;
        if (this.id != other.id)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "entities.Country[ id=" + id + " ]";
    }

}
