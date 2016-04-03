/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.*;
import java.util.Calendar;
import java.util.Date;



/**
 *
 * @author jomaa
 */
public class CommentaireServiceDAO {
    private int id;
    private String commentaire;
    private  Date dateComm;
    private UserDAO user;
    private ServiceDAO service;

    public CommentaireServiceDAO() {
        this.dateComm=Calendar.getInstance().getTime();
    }

    public CommentaireServiceDAO(int id, String commentaire, UserDAO user, ServiceDAO service) {
        this.id = id;
        this.commentaire = commentaire;
        this.user = user;
        this.service = service;
        this.dateComm=Calendar.getInstance().getTime();
    }

    public CommentaireServiceDAO(String commentaire, UserDAO user, ServiceDAO service) {
        this.commentaire = commentaire;
        this.user = user;
        this.service = service;
        this.dateComm=Calendar.getInstance().getTime();
    }
    
    

    public int getId() {
        return id;
    }

    public Date getDateComm() {
        return this.dateComm;
    }

    
    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
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

    public void setService(ServiceDAO service) {
        this.service = service;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
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
        final CommentaireServiceDAO other = (CommentaireServiceDAO) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CommentaireService{" + "id=" + id + ", commentaire=" + commentaire + ", user=" + user + ", service=" + service + '}';
    }
    
    
    
    
    
    
}
