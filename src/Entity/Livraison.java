/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

/**
 *
 * @author gafsi
 */
public class Livraison {
     private int id;
    private String modelivraison;
    private Adresse adresse;

    public Livraison() {
    }

    public Livraison(int id, String modelivraison, Adresse adresse) {
        this.id = id;
        this.modelivraison = modelivraison;
        this.adresse = adresse;
    }

    public Livraison(String modelivraison, Adresse adresse) {
        this.modelivraison = modelivraison;
        this.adresse = adresse;
    }

    public int getId() {
        return id;
    }

    public String getModelivraison() {
        return modelivraison;
    }

    public void setModelivraison(String modelivraison) {
        this.modelivraison = modelivraison;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Lvraison{" + "id=" + id + ", modelivraison=" + modelivraison + ", adresse=" + adresse + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
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
        final Livraison other = (Livraison) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
