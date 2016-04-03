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
class SujetDAO {
    private int id;
    private String titre;
    private String sujet;
    private UserDAO user;

    public SujetDAO() {
    }

    public SujetDAO(int id, String titre, String sujet, UserDAO user) {
        this.id = id;
        this.titre = titre;
        this.sujet = sujet;
        this.user = user;
    }

    public SujetDAO(String titre, String sujet, UserDAO user) {
        this.titre = titre;
        this.sujet = sujet;
        this.user = user;
    }

    public int getId() {
        return id;
    }
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public UserDAO getUser() {
        return user;
    }

    public void setUser(UserDAO user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.id;
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
        final SujetDAO other = (SujetDAO) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sujet{" + "id=" + id + ", titre=" + titre + ", sujet=" + sujet + ", user=" + user + '}';
    }
    
    

    
}
