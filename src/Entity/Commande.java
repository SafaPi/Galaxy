/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.*;
import java.util.Calendar;


/**
 *
 * @author jomaa
 */
public class Commande {
    
    private int id;
    private Date datecommande;
    private float totalcommande;
    private boolean  valider;
    private Livraison livraison;
    private Panier panier;

    public Commande() {
        this.datecommande =  Calendar.getInstance().getTime();
    }

    public Commande(Float totalcommande, boolean valider, Livraison reference, Panier panier) {
        this.datecommande = (Date) Calendar.getInstance().getTime();
        this.totalcommande = totalcommande;
        this.valider = valider;
        this.livraison = reference;
        this.panier = panier;
    }

    public Commande(int id, float totalcommande, boolean valider, Livraison reference, Panier panier) {
        this.id = id;
        this.datecommande = datecommande;
        this.totalcommande = totalcommande;
        this.valider = valider;
        this.livraison = reference;
        this.panier = panier;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatecommande() {
        return datecommande;
    }

    public void setDatecommande(Date datecommande) {
        this.datecommande = datecommande;
    }

    public float getTotalcommande() {
        return totalcommande;
    }

    public void setTotalcommande(float totalcommande) {
        this.totalcommande = totalcommande;
    }

    public boolean isValider() {
        return valider;
    }

    public void setValider(boolean valider) {
        this.valider = valider;
    }

    public Livraison getLivraison() {
        return livraison;
    }

    public void setLivraison(Livraison reference) {
        this.livraison = reference;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", datecommande=" + datecommande + ", totalcommande=" + totalcommande + ", valider=" + valider + ", reference=" + livraison + ", panier=" + panier + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
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
        final Commande other = (Commande) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
