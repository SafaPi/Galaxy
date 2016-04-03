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
public class Appeldoffre {
    private int id;
    private String nom;
    private String description;
    private User proprietaire;
    private String mail;
    private int telephone;
    private String adresse;

    public Appeldoffre(int id, String nom, String Description, User proprietaire, String Mail, int Telephone, String Adresse) {
        this.id = id;
        this.nom = nom;
        this.description = Description;
        this.proprietaire = proprietaire;
        this.mail = Mail;
        this.telephone = Telephone;
        this.adresse = Adresse;
    }

    public Appeldoffre(String nom, String Description, User proprietaire, String Mail, int Telephone, String Adresse) {
        this.nom = nom;
        this.description = Description;
        this.proprietaire = proprietaire;
        this.mail = Mail;
        this.telephone = Telephone;
        this.adresse = Adresse;
    }

    public Appeldoffre() {
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

    public void setDescription(String Description) {
        this.description = Description;
    }

    public User getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(User proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String Mail) {
        this.mail = Mail;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int Telephone) {
        this.telephone = Telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String Adresse) {
        this.adresse = Adresse;
    }

    @Override
    public String toString() {
        return "Appeldoffre{" + "id=" + id + ", nom=" + nom + ", Description=" + description + ", proprietaire=" + proprietaire + ", Mail=" + mail + ", Telephone=" + telephone + ", Adresse=" + adresse + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Appeldoffre other = (Appeldoffre) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
