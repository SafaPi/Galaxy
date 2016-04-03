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
class Service {
    private int id;
    private String nom;
    private String Description;
    private User proprietaire;
    private boolean valider;
    private int estimation;
    private Categorie Categorie;
    private String Mail;
    private int Telephone;
    private String Adresse;

    public Service() {
    }

    public Service(int id, String nom, String Description, User proprietaire, boolean valider, int estimation, Categorie Categorie, String Mail, int Telephone, String Adresse) {
        this.id = id;
        this.nom = nom;
        this.Description = Description;
        this.proprietaire = proprietaire;
        this.valider = valider;
        this.estimation = estimation;
        this.Categorie = Categorie;
        this.Mail = Mail;
        this.Telephone = Telephone;
        this.Adresse = Adresse;
    }

    public Service(String nom, String Description, User proprietaire, boolean valider, int estimation, Categorie Categorie, String Mail, int Telephone, String Adresse) {
        this.nom = nom;
        this.Description = Description;
        this.proprietaire = proprietaire;
        this.valider = valider;
        this.estimation = estimation;
        this.Categorie = Categorie;
        this.Mail = Mail;
        this.Telephone = Telephone;
        this.Adresse = Adresse;
    }

    public int getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public User getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(User proprietaire) {
        this.proprietaire = proprietaire;
    }

    public boolean isValider() {
        return valider;
    }

    public void setValider(boolean valider) {
        this.valider = valider;
    }

    public int getEstimation() {
        return estimation;
    }

    public void setEstimation(int estimation) {
        this.estimation = estimation;
    }

    public Categorie getCategorie() {
        return Categorie;
    }

    public void setCategorie(Categorie Categorie) {
        this.Categorie = Categorie;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public int getTelephone() {
        return Telephone;
    }

    public void setTelephone(int Telephone) {
        this.Telephone = Telephone;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Service other = (Service) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Service{" + "id=" + id + ", nom=" + nom + ", Description=" + Description + ", proprietaire=" + proprietaire + ", valider=" + valider + ", estimation=" + estimation + ", Categorie=" + Categorie + ", Mail=" + Mail + ", Telephone=" + Telephone + ", Adresse=" + Adresse + '}';
    }
    
    
}
