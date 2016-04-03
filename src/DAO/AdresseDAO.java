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
import java.util.ArrayList;
import java.util.List;
import technique.DataSource;

/**
 *
 * @author Maher
 */
public class AdresseDAO {

    private Connection connection;

    public AdresseDAO() {
        connection = DataSource.getInstance().getConnection();
    }

    public void addAdresse(Adresse adresse) {
        try {
            String req = "insert into adresse (rue,ville,codePostal,pays,user) values (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, adresse.getRue());
            ps.setString(2, adresse.getVille());
            ps.setInt(3, adresse.getCodePostal());
            ps.setString(4, adresse.getPays());
            ps.setInt(5, adresse.getUser().getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("erreur lors de linsertion");
            ex.printStackTrace();
        }
    }

    public void updateAdresse(Adresse adresse) {
        String requete = "update depot set rue=? and ville=?and codePostal=? and"
                + " pays=? where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, adresse.getRue());
            ps.setString(2, adresse.getVille());
            ps.setInt(3, adresse.getCodePostal());
            ps.setString(4, adresse.getVille());
            ps.setInt(5, adresse.getId());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }
  
    public void removeAdresseById(int id) {
        String requete = "delete from adresse where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Adresse supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    public Adresse findAdresseById(int id) {
        Adresse adresse =new Adresse();
        UserDAO userDAO=new UserDAO();
        String requete = "select * from adresse where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                adresse.setId(resultat.getInt(1));
                adresse.setCodePostal(resultat.getInt("codePostal"));
                adresse.setRue(resultat.getString("rue"));
                adresse.setPays(resultat.getString("pays"));
                adresse.setUser(userDAO.findUserById(resultat.getInt("user")));
            }
            return adresse;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche d'adresse " + ex.getMessage());
            return null;
        }
    }

    public Adresse findAdresseByProprtie(String proprtie,Object value) {
        Adresse adresse =new Adresse();
        List<Adresse> listeadresses = new ArrayList<>();
        UserDAO userDAO=new UserDAO();
        String requete = "select * from depot where ?=?";
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
                adresse.setId(resultat.getInt(1));
                adresse.setCodePostal(resultat.getInt("codePostal"));
                adresse.setRue(resultat.getString("rue"));
                adresse.setPays(resultat.getString("pays"));
                adresse.setUser(userDAO.findUserById(resultat.getInt("user")));
                listeadresses.add(adresse);
            }
            return adresse;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche des adresses " + ex.getMessage());
            return null;
        }
    }

    public List<Adresse> findAll() {
        List<Adresse> listeadresses = new ArrayList<>();
        UserDAO userDAO=new UserDAO();
        String requete = "select * from adresse";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Adresse adresse =new Adresse();
                adresse.setId(resultat.getInt(1));
                adresse.setCodePostal(resultat.getInt("codePostal"));
                adresse.setRue(resultat.getString("rue"));
                adresse.setPays(resultat.getString("pays"));
                adresse.setUser(userDAO.findUserById(resultat.getInt("user")));
                listeadresses.add(adresse);
            }
            return listeadresses;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des adresses " + ex.getMessage());
            return null;
        }
    }
}
