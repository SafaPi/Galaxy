/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entity.*;

/**
 *
 * @author gafsi
 */
public class LvraisonDAO {
     private int id;
    private String modelivraison;
    private AdresseDAO adresse;

    public LvraisonDAO() {
    }

    public LvraisonDAO(int id, String modelivraison, AdresseDAO adresse) {
        this.id = id;
        this.modelivraison = modelivraison;
        this.adresse = adresse;
    }

    public LvraisonDAO(String modelivraison, AdresseDAO adresse) {
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

    public AdresseDAO getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseDAO adresse) {
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
        final LvraisonDAO other = (LvraisonDAO) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
