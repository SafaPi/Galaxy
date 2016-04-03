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
 * @author gafsi
 */
public class AppeldoffreDAO {
      private Connection connection;

    public AppeldoffreDAO() {
        connection = DataSource.getInstance().getConnection();
    }

    public void addAppeldoffre(Appeldoffre appeldoffre) {
        try {
            String req = "insert into appeldoffre (nom,description,mail,proprietaire,telephone,adresse) values (?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, appeldoffre.getNom());
            ps.setString(2, appeldoffre.getDescription());
            ps.setString(3, appeldoffre.getMail());
            ps.setInt(4, appeldoffre.getProprietaire().getId());
            ps.setInt(5, appeldoffre.getTelephone());
             ps.setString(6, appeldoffre.getAdresse());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("erreur lors de linsertion");
            ex.printStackTrace();
        }
    }

    public void updateAppeldoffre(Appeldoffre appeldoffre) {
        String requete = "update appeldoffre set nom=? and description=? and"
                + " mail=? and telephone=? and adresse=? where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, appeldoffre.getNom());
            ps.setString(2, appeldoffre.getDescription());
            ps.setString(3, appeldoffre.getMail());
            ps.setInt(4, appeldoffre.getTelephone());
             ps.setString(5, appeldoffre.getAdresse());
            ps.setInt(6, appeldoffre.getId());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }
  
    public void removeAppeldoffreById(int id) {
        String requete = "delete from appeldoffre where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("appeldoffre supprimé");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    public Appeldoffre findAppeldoffreById(int id) {
        Appeldoffre appeldoffre =new Appeldoffre();
        UserDAO userDAO=new UserDAO();
        String requete = "select * from appeldoffre where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                appeldoffre.setId(resultat.getInt(1));
                appeldoffre.setProprietaire(userDAO.findUserById(resultat.getInt(2)));
                appeldoffre.setNom(resultat.getString(3));
                appeldoffre.setDescription(resultat.getString(4));
                appeldoffre.setMail(resultat.getString(5));
                appeldoffre.setTelephone(resultat.getInt(6));
                appeldoffre.setAdresse(resultat.getString(7));
            }
            return appeldoffre;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche de l'appel d'offre " + ex.getMessage());
            return null;
        }
    }

    public List<Appeldoffre> findAppeldoffreByProprtie(String proprtie,Object value) {
        Appeldoffre appeldoffre =new Appeldoffre();
        List<Appeldoffre> listeappelsdoffres = new ArrayList<>();
        UserDAO userDAO=new UserDAO();
        String requete = "select * from appeldoffre where ?=?";
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
                appeldoffre.setId(resultat.getInt(1));
                appeldoffre.setProprietaire(userDAO.findUserById(resultat.getInt(2)));
                appeldoffre.setNom(resultat.getString(3));
                appeldoffre.setDescription(resultat.getString(4));
                appeldoffre.setMail(resultat.getString(5));
                appeldoffre.setTelephone(resultat.getInt(6));
                appeldoffre.setAdresse(resultat.getString(7));
                listeappelsdoffres.add(appeldoffre);
            }
            return listeappelsdoffres;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche des appels d'offre " + ex.getMessage());
            return null;
        }
    }

    public List<Appeldoffre> findAll() {
        List<Appeldoffre> listeappeldoffres = new ArrayList<>();
        UserDAO userDAO=new UserDAO();
        String requete = "select * from appeldoffre";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Appeldoffre appeldoffre =new Appeldoffre();
                appeldoffre.setId(resultat.getInt(1));
                appeldoffre.setProprietaire(userDAO.findUserById(resultat.getInt(2)));
                appeldoffre.setNom(resultat.getString(3));
                appeldoffre.setDescription(resultat.getString(4));
                appeldoffre.setMail(resultat.getString(5));
                appeldoffre.setTelephone(resultat.getInt(6));
                appeldoffre.setAdresse(resultat.getString(7));
                listeappeldoffres.add(appeldoffre);
            }
            return listeappeldoffres;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des appels d'offres " + ex.getMessage());
            return null;
        }
    }
}

  

