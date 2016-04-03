/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Metier;
import DAO.CategorieDAO;
import DAO.PubliciteDAO;
//import DAO.UserDAO;
import Entity.*;

//import DAO.UserDAO;
import Entity.Produit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import static jdk.nashorn.internal.runtime.Debug.id;
import technique.DataSource;

/**
 *
 * @author SafaPC
 */
public class coucheMetier {
    
    Connection connection;
    private PreparedStatement statement;

    

   

    public coucheMetier() {
connection = DataSource.getInstance().getConnection();    }

    
    public List<Produit> findProduitNonValide() {
        List<Produit> listeproduits = new ArrayList<>();
       // UserDAO userDAO = new UserDAO();
        CategorieDAO categorieDAO = new CategorieDAO();
        String requete = "select * from produit where valider=0";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                Produit produit = new Produit();
                produit.setId(resultat.getInt(1));
                //produit.setUser(userDAO.findUserById(resultat.getInt(2)));
                produit.setCategorie_id(categorieDAO.findcategorieById(resultat.getInt(3)));
                produit.setNom(resultat.getString(4));
                produit.setDescription(resultat.getString(5));
                produit.setPrix(resultat.getFloat(6));
                produit.setQantite(resultat.getInt(7));
                produit.setPromotion(resultat.getInt(8));
                produit.setMarque(resultat.getString(9));
                produit.setNbvente(resultat.getInt("nbVente"));
                listeproduits.add(produit);

            }
            return listeproduits;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des adresses " + ex.getMessage());
            return null;
        }
    }
    public boolean validerProduit(int id){
         String url = " update produit set valider=1 where id=?";
       try {
           
            PreparedStatement prst = connection.prepareStatement(url);
            prst.setInt(1, id);
            prst.executeUpdate();
            System.out.println("validation avec succes");
            return true;
        } catch (SQLException ex) {
            System.err.println("Echec de validation!");
            return false;
        }
    }
    public Produit rechercher() {
 Produit produit = new Produit();
        CategorieDAO categorieDAO = new CategorieDAO();
     //   UserDAO userDAO = new UserDAO();
        String requete = "select * from produit where categorie_id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            //ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                produit.setId(resultat.getInt(1));
               // produit.setUser(userDAO.findUserById(resultat.getInt(2)));
                produit.setCategorie_id(categorieDAO.findcategorieById(resultat.getInt(3)));
                produit.setNom(resultat.getString(4));
                produit.setDescription(resultat.getString(5));
                produit.setPrix(resultat.getFloat(6));
                produit.setQantite(resultat.getInt(7));
                produit.setPromotion(resultat.getInt(8));

            }
            return produit;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du produit " + ex.getMessage());
            return null;
        }
    }
    public List<Produit> findNonValid() {
        List<Produit> listeprod = new ArrayList<>();
       // UserDAO userDAO = new UserDAO();
CategorieDAO categorieDAO = new CategorieDAO();
        String requete = "select * from produit where valider=0";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
 Produit produit = new Produit();
                
                String destinatoin = "C:\\Users\\SafaPC\\Desktop\\projet\\AllForDeal\\src\\com\\images" + System.getProperty("file.separator") + resultat.getString("nom") + ".png";
                File ff = new File(destinatoin);
                
                
                produit.setId(resultat.getInt(1));
                //produit.setUser(userDAO.findUserById(resultat.getInt(2)));
                produit.setCategorie_id(categorieDAO.findcategorieById(resultat.getInt(3)));
                produit.setNom(resultat.getString(4));
                produit.setDescription(resultat.getString(5));
                produit.setPrix(resultat.getFloat(6));
                Blob blob = resultat.getBlob("image");
                produit.setQantite(resultat.getInt(7));
                produit.setPromotion(resultat.getInt(8));
                produit.setMarque(resultat.getString(9));
                produit.setNbvente(resultat.getInt("nbVente"));
                //lecture du blob et écriture sur le disque 
                BufferedImage image = ImageIO.read(blob.getBinaryStream());
                FileOutputStream stream = new FileOutputStream(ff);
                ImageIO.write(image, "png", stream);
                produit.setImage(blob);

                listeprod.add(produit);

            }
            return listeprod;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return null;
        } catch (IOException ex) {
            Logger.getLogger(PubliciteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
}
    }
