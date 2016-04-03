/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

/**
 *
 * @author Dridi
 */
public class Adresse {
    private int id;
    private String rue;
    private String Ville;
    private int codePostal;
    private String pays;
    private User user;

    public Adresse() {
    }

    public Adresse(String rue, String Ville, int codePostal, String pays, User user) {
        this.rue = rue;
        this.Ville = Ville;
        this.codePostal = codePostal;
        this.pays = pays;
        this.user = user;
    }

    public Adresse(int id, String rue, String Ville, int codePostal, String pays, User user) {
        this.id = id;
        this.rue = rue;
        this.Ville = Ville;
        this.codePostal = codePostal;
        this.pays = pays;
        this.user = user;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String Ville) {
        this.Ville = Ville;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Adresse{" + "id=" + id + ", rue=" + rue + ", Ville=" + Ville + ", codePostal=" + codePostal + ", pays=" + pays + ", user=" + user + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id;
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
        final Adresse other = (Adresse) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}
