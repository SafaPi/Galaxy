/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gafsi
 */
public class Favoris {
    private int id;
    private List<Produit> produit;

    public Favoris() {
        produit=new ArrayList<Produit>();
    }

    public Favoris(int id, Produit produit) {
        this.id = id;
        this.produit.add(produit);
    }

    public Favoris(Produit produit) {
        this.produit.add(produit);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public List<Produit> getProduit() {
        return produit;
    }

    public void addProduit(Produit produit) {
        this.produit.add(produit);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Favoris other = (Favoris) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Favoris{" + "id=" + id + ", produit=" + produit + '}';
    }
    
    
}
