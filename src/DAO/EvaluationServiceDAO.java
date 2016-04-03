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
public class EvaluationServiceDAO {
    private int id;
    private int rating;
    private UserDAO user;
    private ServiceDAO service;

    public EvaluationServiceDAO() {
    }

    public EvaluationServiceDAO(int id, int note, UserDAO user, ServiceDAO service) {
        this.id = id;
        this.rating = note;
        this.user = user;
        this.service = service;
    }

    public EvaluationServiceDAO(int note, UserDAO user, ServiceDAO service) {
        this.rating = note;
        this.user = user;
        this.service = service;
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

    public ServiceDAO getService() {
        return service;
    }

    public void setProduit(ServiceDAO service) {
        this.service = service;
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
        final EvaluationServiceDAO other = (EvaluationServiceDAO) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Evaluationprod{" + "id=" + id + ", note=" + rating + ", user=" + user + ", service=" + service + '}';
    }
    
    
    
}
