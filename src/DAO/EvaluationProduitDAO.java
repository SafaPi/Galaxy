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
public class EvaluationProduitDAO {
    private int id;
    private int rating;
    private UserDAO user;
    private ProduitDAO produit;

    public EvaluationProduitDAO() {
    }

    public EvaluationProduitDAO(int id, int note, UserDAO user, ProduitDAO produit) {
        this.id = id;
        this.rating = note;
        this.user = user;
        this.produit = produit;
    }

    public EvaluationProduitDAO(int note, UserDAO user, ProduitDAO produit) {
        this.rating = note;
        this.user = user;
        this.produit = produit;
    }

    public int getId() {
        return id;
    }
    public int getRating() {
        return rating;
    }

    public void setRating(int note) {
        this.rating = note;
    }

    public UserDAO getUser() {
        return user;
    }

    public void setUser(UserDAO user) {
        this.user = user;
    }

    public ProduitDAO getProduit() {
        return produit;
    }

    public void setProduit(ProduitDAO produit) {
        this.produit = produit;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final EvaluationProduitDAO other = (EvaluationProduitDAO) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Evaluationprod{" + "id=" + id + ", note=" + rating + ", user=" + user + ", produit=" + produit + '}';
    }
    
    
    
}
