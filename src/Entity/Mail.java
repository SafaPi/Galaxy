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
public class Mail {
    private int id;
    private String nom;
    private String from;
    private String text;

    public Mail() {
    }

    public Mail(int id, String nom, String from, String text) {
        this.id = id;
        this.nom = nom;
        this.from = from;
        this.text = text;
    }

    public Mail(String nom, String from, String text) {
        this.nom = nom;
        this.from = from;
        this.text = text;
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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.id;
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
        final Mail other = (Mail) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mail{" + "id=" + id + ", nom=" + nom + ", from=" + from + ", text=" + text + '}';
    }
    

    
}
