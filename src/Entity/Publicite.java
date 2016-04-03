/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.sql.Blob;
import java.sql.Date;
import org.apache.myfaces.custom.fileupload.UploadedFile;
/**
 *
 * @author Dridi
 */
public class Publicite {
    private int id;
    private String type ;
    private String sujet;
    private String nom;
    private String lieu;
    private Date date;
    private User user;
    private Blob image;
    private UploadedFile uploadedFile;
    
    //**
    String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UploadedFile getUploadedFile() {
        
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
    

    public Publicite() {
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public Publicite(String type, String sujet, String nom, String lieu, Date date, User user, Blob image) {
        this.type = type;
        this.sujet = sujet;
        this.nom = nom;
        this.lieu = lieu;
        this.date = date;
        this.user = user;
        this.image = image;
    }

    public Publicite(int id, String type, String sujet, String nom, String lieu, Date date, User user, Blob image) {
        this.id = id;
        this.type = type;
        this.sujet = sujet;
        this.nom = nom;
        this.lieu = lieu;
        this.date = date;
        this.user = user;
        this.image = image;
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Publicite{" + "id=" + id + ", type=" + type + ", sujet=" + sujet + ", nom=" + nom + ", lieu=" + lieu + ", date=" + date + ", user=" + user + ", image=" + image + ", uploadedFile=" + uploadedFile + ", url=" + url + '}';
    }


    
    
    
}
