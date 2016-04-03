/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author ali
 */
public class Localisation {

    public Localisation() {
    }
    
    private int id;
    private String latitude;
    private String longitude;
    private String nom;

    public Localisation(int id, String latitude, String longitude, String nom) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nom = nom;
    }

    public Localisation(String latitude, String longitude, String nom) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.nom = nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Localisation{" + "id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + ", nom=" + nom + '}';
    }
    
    
    
}
