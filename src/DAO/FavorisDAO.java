/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entity.Categorie;
import Entity.Favoris;
import Entity.Produit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import technique.DataSource;

/**
 *
 * @author gafsi
 */
public class FavorisDAO {
    private Connection connection;
    public FavorisDAO() {
         connection = DataSource.getInstance().getConnection();
    }
    
     public void addFavoris() {
        try {
            String req = "insert into Favoris () values ()";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("erreur lors de linsertion");
            ex.printStackTrace();
        }
    }
      public void addFavorisProduits(Favoris favoris,Produit produit) {
        try {
            String req = "INSERT INTO favoris_produit(favoris_id, produit_id) VALUES (?,?) ";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, favoris.getId());
            ps.setInt(2, produit.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("erreur lors de linsertion");
            ex.printStackTrace();
        }
    }
  
    public void removeProduitById(int id) {
        String requete = "DELETE FROM favoris_produit WHERE produit_id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("produit supprimé du favoris");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    public Favoris findFavorisById(int id) {
        ProduitDAO produit =new ProduitDAO();
        Favoris favoris=new Favoris();
        String requete = "SELECT * FROM favoris, favoris_produit where favoris.id = favoris_produit.favoris_id and favoris.id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                favoris.setId(resultat.getInt(1));
                favoris.addProduit(produit.findProduitById(resultat.getInt(3)));
            }
            return favoris;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du favoris " + ex.getMessage());
            return null;
        }
    }

   
 
  
}
