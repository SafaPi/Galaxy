
package Entity;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;


public class Commentaire {
    
    
      private int id;
      private Produit produit;
      private User user;
      private String  corps;
      private Date dateComm;

    public Commentaire() {
        this.dateComm=Date.valueOf(LocalDate.now());
    }

    public Commentaire(int id, Produit produit, User user, String corps) {
        this.id = id;
        this.produit = produit;
        this.user = user;
        this.corps = corps;
        this.dateComm=Date.valueOf(LocalDate.now().format(DateTimeFormatter.ofPattern("d MMM uuuu")));
    }

    public Commentaire(Produit produit, User user, String corps, Date dateComm) {
        this.produit = produit;
        this.user = user;
        this.corps = corps;
        this.dateComm=Date.valueOf(LocalDate.now().format(DateTimeFormatter.ofPattern("d MMM uuuu")));
    }
      
      

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id=id;
    }


    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCorps() {
        return corps;
    }

    public void setCorps(String corps) {
        this.corps = corps;
    }

    public Date getDateComm() {
        return dateComm;
    }



    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", produit=" + produit + ", user=" + user + ", corps=" + corps + ", dateComm=" + dateComm + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
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
        final Commentaire other = (Commentaire) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
     
      
      
      
      
      
     
    
      
    
}
