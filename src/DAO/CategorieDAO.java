/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Categorie;
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
 * @author jomaa
 */
public class CategorieDAO {
       private Connection connection;

    public CategorieDAO() {
        connection = DataSource.getInstance().getConnection();
    }

    public void addCategorie(Categorie categorie) {
        try {
            String req = "insert into categorie (nom,description) values (?,?)";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, categorie.getNom());
            ps.setString(2, categorie.getDescription());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("erreur lors de linsertion");
            ex.printStackTrace();
        }
    }

    public void updateCategorie(Categorie categorie) {
        String requete = "update categorie set nom=? and description=? where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, categorie.getNom());
            ps.setString(2, categorie.getDescription());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }
  
    public void removecategorieById(int id) {
        String requete = "delete from categorie where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("categorie supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    public Categorie findcategorieById(int id) {
        Categorie categorie =new Categorie();
        UserDAO userDAO=new UserDAO();
        String requete = "select * from categorie where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                categorie.setId(resultat.getInt(1));
                categorie.setNom(resultat.getString(4));
                categorie.setDescription(resultat.getString(5));
            }
            return categorie;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche de la categorie " + ex.getMessage());
            return null;
        }
    }

    public Categorie findcategorieByNom(String Nom) {
        Categorie categorie =new Categorie();
        UserDAO userDAO=new UserDAO();
        String requete = "select * from categorie where nom=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, Nom);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                categorie.setId(resultat.getInt(1));
                categorie.setNom(resultat.getString(4));
                categorie.setDescription(resultat.getString(5));
            }
            return categorie;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche de la categorie " + ex.getMessage());
            return null;
        }
    }
    public List<Categorie> findcategorieByProprtie(String proprtie,Object value) {
        Categorie categorie =new Categorie();
        List<Categorie> listecategories = new ArrayList<>();
        UserDAO userDAO=new UserDAO();
        String requete = "select * from categorie where ?=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, proprtie);
            if(value.getClass().isInstance(new String()))
            ps.setString(2, (String)value);
            else if(value.getClass().isInstance(Integer.TYPE))
            ps.setInt(2, (int)value);
            else if(value.getClass().isInstance(Float.TYPE))
            ps.setFloat(2, (Float)value);
            else{
                System.out.println("type incompatible");
                return null;
            }
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                categorie.setId(resultat.getInt(1));
                categorie.setNom(resultat.getString(4));
                categorie.setDescription(resultat.getString(5));
               listecategories.add(categorie);
            }
            return listecategories;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche des acategories " + ex.getMessage());
            return null;
        }
    }

    public List<Categorie> findAll() {
        List<Categorie> listecategories = new ArrayList<>();
        UserDAO userDAO=new UserDAO();
        String requete = "select * from categorie";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Categorie categorie =new Categorie();
                categorie.setId(resultat.getInt(1));
                categorie.setNom(resultat.getString(4));
                categorie.setDescription(resultat.getString(5));
                
                listecategories.add(categorie);
            }
            return listecategories;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des categories " + ex.getMessage());
            return null;
        }
    }
    
 
}
