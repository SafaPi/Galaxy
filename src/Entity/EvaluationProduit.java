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
public class EvaluationProduit {
    private int id;
    private int rating;
    private User User_id;
    private Produit Produit_id;

    public EvaluationProduit() {
    }

    public EvaluationProduit(int id, int rating, User User_id, Produit Produit_id) {
        this.id = id;
        this.rating = rating;
        this.User_id = User_id;
        this.Produit_id = Produit_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public User getUser_id() {
        return User_id;
    }

    public void setUser_id(User User_id) {
        this.User_id = User_id;
    }

    public Produit getProduit_id() {
        return Produit_id;
    }

    public void setProduit_id(Produit Produit_id) {
        this.Produit_id = Produit_id;
    }

    @Override
    public String toString() {
        return "EvaluationProduit{" + "id=" + id + ", rating=" + rating + ", User_id=" + User_id + ", Produit_id=" + Produit_id + '}';
    }

    
    
}
