/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entity.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import technique.DataSource;

/**
 *
 * @author gafsi
 */
class PanierDAO {
    private Connection connection;

    public PanierDAO() {
        connection=DataSource.getInstance().getConnection();
    }
      public Panier findPanierById(int id) {
        Panier panier =new Panier();
        ProduitDAO produit =new ProduitDAO();
        String req="SELECT * FROM panier, panier_produit where panier.id = panier_produit.panier_id and panier.id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                panier.setId(resultat.getInt(1));
                panier.addProduit(produit.findProduitById(resultat.getInt(4)));
            }
            return panier;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du panier " + ex.getMessage());
            return null;
        }
    }

   

    
}
