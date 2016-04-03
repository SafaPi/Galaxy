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
class Sujet {
    private int id;
    private String titre;
    private String sujet;
    private User user;

    public Sujet() {
    }

    public Sujet(int id, String titre, String sujet, User user) {
        this.id = id;
        this.titre = titre;
        this.sujet = sujet;
        this.user = user;
    }

    public Sujet(String titre, String sujet, User user) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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
        final Sujet other = (Sujet) obj;
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
