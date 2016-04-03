/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.sql.Blob;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import org.apache.myfaces.custom.fileupload.UploadedFile;

/**
 *
 * @author SafaPC
 */
public class Produit {
    private int id;
    private String nom;
    private String description; 
    private float prix;
    private int qantite;
    private int promotion;
    private String marque;
    private int nbvente;
    private int nbPointBase;
    private Blob image;
   private UploadedFile uploadedFile;
     //private String urlImage;
    //**
   private String urlImage;
   private int valider;
    private Date dateajout;
   
    private User user;
    private Categorie categorie_id;

    public Produit(int id, String nom, String description, float prix, int qantite, int promotion, String marque, int nbvente, int nbPointBase, Blob image, UploadedFile uploadedFile, String urlImage, int valider, Date dateajout, User user, Categorie categorie_id) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.qantite = qantite;
        this.promotion = promotion;
        this.marque = marque;
        this.nbvente = nbvente;
        this.nbPointBase = nbPointBase;
        this.image = image;
        this.uploadedFile = uploadedFile;
        this.urlImage = urlImage;
        this.valider = valider;
        this.dateajout = dateajout;
        this.user = user;
        this.categorie_id = categorie_id;
    }

    public Produit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getQantite() {
        return qantite;
    }

    public void setQantite(int qantite) {
        this.qantite = qantite;
    }

    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getNbvente() {
        return nbvente;
    }

    public void setNbvente(int nbvente) {
        this.nbvente = nbvente;
    }

    public int getNbPointBase() {
        return nbPointBase;
    }

    public void setNbPointBase(int nbPointBase) {
        this.nbPointBase = nbPointBase;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public int getValider() {
        return valider;
    }

    public void setValider(int valider) {
        this.valider = valider;
    }

    public Date getDateajout() {
        return dateajout;
    }

    public void setDateajout(Date dateajout) {
        this.dateajout = dateajout;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Categorie getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(Categorie categorie_id) {
        this.categorie_id = categorie_id;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", nom=" + nom + ", description=" + description + ", prix=" + prix + ", qantite=" + qantite + ", promotion=" + promotion + ", marque=" + marque + ", nbvente=" + nbvente + ", nbPointBase=" + nbPointBase + ", image=" + image + ", uploadedFile=" + uploadedFile + ", urlImage=" + urlImage + ", valider=" + valider + ", dateajout=" + dateajout + ", user=" + user + ", categorie_id=" + categorie_id + '}';
    }

    

    
}