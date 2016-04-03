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
import java.sql.Statement;
import java.util.*;
import technique.DataSource;

/**
 *
 * @author jomaa
 */
public class CommandeDAO {
    
private Connection connection;

    public CommandeDAO() {
        connection=DataSource.getInstance().getConnection();
    }
//
//    public void addCommande(Commande commande) {
//        try {
//            String req = "insert into commande (dateCommande,totalCommande,valider,Panier_id,Livraison_id) values (?,?)";
//            PreparedStatement ps = connection.prepareStatement(req);
//            ps.setDate(1, commande.getDatecommande());
//            ps.setFloat(2, commande.getTotalcommande());
//            ps.setBoolean(3, commande.isValider());
//            ps.setInt(4, commande.getPanier().getId());
//            ps.setInt(5, commande.getLivraison().getId());
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println("erreur lors de linsertion");
//            ex.printStackTrace();
//        }
//    }
//
//    public void updateCommande(Commande commande) {
//        String requete = "update categorie set nom=? and description=? where id=?";
//        try {
//            PreparedStatement ps = connection.prepareStatement(requete);
//            ps.setString(1, commande.getNom());
//            ps.setString(2, commande.getDescription());
//            ps.executeUpdate();
//            System.out.println("Mise à jour effectuée avec succès");
//        } catch (SQLException ex) {
//            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
//        }
//    }
//  
//    public void removeCommandeById(int id) {
//        String requete = "delete from commande where id=?";
//        try {
//            PreparedStatement ps = connection.prepareStatement(requete);
//            ps.setInt(1, id);
//            ps.executeUpdate();
//            System.out.println("commande supprimé");
//        } catch (SQLException ex) {
//            System.out.println("erreur lors de la suppression " + ex.getMessage());
//        }
//    }
//
//    public Commande findCommandeById(int id) {
//        Commande commande =new Commande();
//        UserDAO userDAO=new UserDAO();
//        String requete = "select * from commande where id=?";
//        try {
//            PreparedStatement ps = connection.prepareStatement(requete);
//            ps.setInt(1, id);
//            ResultSet resultat = ps.executeQuery();
//            while (resultat.next()) {
//                commande.setId(resultat.getInt(1));
//                commande.setNom(resultat.getString(4));
//                commande.setDescription(resultat.getString(5));
//            }
//            return commande;
//
//        } catch (SQLException ex) {
//            System.out.println("erreur lors de la recherche de la commande " + ex.getMessage());
//            return null;
//        }
//    }
//
//    public List<Commande> findcategorieByProprtie(String proprtie,Object value) {
//        Commande commande =new Commande();
//        List<Commande> listecommande = new ArrayList<>();
//        UserDAO userDAO=new UserDAO();
//        String requete = "select * from commande where ?=?";
//        try {
//            PreparedStatement ps = connection.prepareStatement(requete);
//            ps.setString(1, proprtie);
//            if(value.getClass().isInstance(new String()))
//            ps.setString(2, (String)value);
//            else if(value.getClass().isInstance(Integer.TYPE))
//            ps.setInt(2, (int)value);
//            else if(value.getClass().isInstance(Float.TYPE))
//            ps.setFloat(2, (Float)value);
//            else{
//                System.out.println("type incompatible");
//                return null;
//            }
//            ResultSet resultat = ps.executeQuery();
//            while (resultat.next()) {
//                categorie.setId(resultat.getInt(1));
//                categorie.setNom(resultat.getString(4));
//                categorie.setDescription(resultat.getString(5));
//               listecategories.add(categorie);
//            }
//            return listecategories;
//
//        } catch (SQLException ex) {
//            System.out.println("erreur lors de la recherche des commandes " + ex.getMessage());
//            return null;
//        }
//    }

    public List<Commande> findAll() {
        List<Commande> listecommandes = new ArrayList<>();
        PanierDAO panier =new PanierDAO();
        String requete = "select * from commande";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Commande commande =new Commande();
                commande.setId(resultat.getInt(1));
                commande.setDatecommande(resultat.getDate(2));
                commande.setTotalcommande(resultat.getFloat(3));
                commande.setValider(resultat.getBoolean(4));
                commande.setPanier(panier.findPanierById(resultat.getInt(5)));               
                listecommandes.add(commande);
            }
            return listecommandes;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des commande " + ex.getMessage());
            return null;
        }
    }
}
