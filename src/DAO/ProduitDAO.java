/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import org.apache.myfaces.custom.fileupload.UploadedFile;
import technique.DataSource;


/**
 *
 * @author SafaPC
 */
public class ProduitDAO {

    Connection connection;
    private PreparedStatement statement;
 DataBufferByte data;
     private UploadedFile uploadedFile;

    public ProduitDAO() {
        connection = DataSource.getInstance().getConnection();
    }

    public void addProduit(Produit produit) throws FileNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {

            String req = "insert into produit (categorie_id,nom,description,prix,qantite,promotion,marque,nbvente,valider,nbPointBase,dateajout,image) values (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1, produit.getCategorie_id().getId());
            ps.setString(2, produit.getNom());
            ps.setString(3, produit.getDescription());
        ps.setFloat(4, produit.getPrix());
            ps.setInt(5, produit.getQantite());
            ps.setInt(6, produit.getPromotion());
            ps.setString(7, produit.getMarque());
            ps.setInt(8, produit.getNbvente());
            ps.setInt(9, produit.getValider());
            ps.setInt(10, produit.getNbPointBase());
            ps.setDate(11, produit.getDateajout());
          File ff = new File(produit.getUrlImage());
          FileInputStream fin = new FileInputStream(ff);
          ps.setBinaryStream(12, fin, (int) ff.length());
//           ps.setInt(8, produit.getUser().getId());
             ps.executeUpdate();
        } catch (SQLException ex) {
       Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Produit findProduitById(int id) {
        Produit produit = new Produit();
        CategorieDAO categorieDAO = new CategorieDAO();
        UserDAO userDAO = new UserDAO();
        String requete = "select * from produit where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                produit.setId(resultat.getInt(1));
                produit.setUser(userDAO.findUserById(resultat.getInt(2)));
                produit.setCategorie_id(categorieDAO.findcategorieById(resultat.getInt(3)));
                produit.setNom(resultat.getString(4));
                produit.setDescription(resultat.getString(5));
                produit.setPrix(resultat.getFloat(6));
                produit.setQantite(resultat.getInt(7) );
                produit.setPromotion(resultat.getInt(8));
                produit.setMarque(resultat.getString(9));

            }
            return produit;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du produit " + ex.getMessage());
            return null;
        }
    }

    public List<Produit> findAll() {
        List<Produit> listeproduits = new ArrayList<>();
        UserDAO userDAO = new UserDAO();
        CategorieDAO categorieDAO = new CategorieDAO();
        String requete = "select * from produit where valider=1";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                Produit produit = new Produit();
                produit.setId(resultat.getInt(1));
                produit.setUser(userDAO.findUserById(resultat.getInt(2)));
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
            System.out.println("erreur lors du chargement des produits " + ex.getMessage());
            return null;
        }
    }

    public void deleteProduit(int id) {

        String requete = "delete from produit where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Suppression effectué avec succées");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    public boolean modifier(Produit produit) {
        try {
            String url = " UPDATE Produit SET nom=?, description=?, prix=?, qantite=?, marque=?,nbvente=?, categorie_id=? WHERE id=?";
            PreparedStatement prst = connection.prepareStatement(url);
            prst.setString(1, produit.getNom());
            prst.setString(2, produit.getDescription());
            prst.setFloat(3, produit.getPrix());
            prst.setInt(4, produit.getQantite());
            prst.setString(5, produit.getMarque());
            prst.setInt(6, produit.getNbvente());
            prst.setInt(7, produit.getCategorie_id().getId());
            prst.setInt(8, produit.getId());
            
            System.out.println(produit);

            prst.executeUpdate();
            System.out.println("Modification avec succes");
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean supp(int c) {
        try {
            String url = " DELETE FROM produit WHERE id=" + c + "";
            PreparedStatement ps = connection.prepareStatement(url);

            ps.execute(url);
            System.out.println("produit supprimé du favoris");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProduitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public Produit AffichagesProduitsbyNom(String nom) {
        Produit produit = new Produit();

        String s = null;
        String requete = "SELECT * FROM Produit where nom like '%" + nom + "%'";
       UserDAO userDAO = new UserDAO();
        CategorieDAO categorieDAO = new CategorieDAO();
        try {
            Statement statement = DataSource.getInstance().getConnection()
                    .createStatement();

            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                produit.setId(resultat.getInt(1));
                produit.setUser(userDAO.findUserById(resultat.getInt(2)));
                produit.setCategorie_id(categorieDAO.findcategorieById(resultat.getInt(3)));
                produit.setNom(resultat.getString(4));
                produit.setDescription(resultat.getString(5));
                produit.setPrix(resultat.getFloat(6));
                produit.setQantite(resultat.getInt(7));
                produit.setPromotion(resultat.getInt(8));
                produit.setMarque(resultat.getString(9));
                produit.setNbvente(resultat.getInt("nbVente"));

            }
            return produit;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement de detail du produit " + ex.getMessage());
            return null;
        }

    }

    public Produit findProduitByProprtie(String proprtie, Object value) {
        Produit produit = new Produit();
        List<Produit> produits = new ArrayList<>();
        UserDAO userDAO = new UserDAO();
        String requete = "select * from produit where ?=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, proprtie);
            if (value.getClass().isInstance(new String())) {
                ps.setString(2, (String) value);
            } else if (value.getClass().isInstance(Integer.TYPE)) {
                ps.setInt(2, (int) value);
            } else if (value.getClass().isInstance(Float.TYPE)) {
                ps.setFloat(2, (Float) value);
            } else {
                System.out.println("type incompatible");
                return null;
            }
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                produit.setId(resultat.getInt(1));
                produit.setNom(resultat.getString("nom"));
                produit.setDescription(resultat.getString("description"));
                produit.setPrix(resultat.getInt("prix"));
//                produit.setQantite(resultat.getInt("quantite"));
//                produit.setPromotion(resultat.getInt("promotion"));
//                produit.setMarque(resultat.getString("marque"));
//                produit.setNbvente(resultat.getInt("nbvente"));
                produits.add(produit);
            }
            return produit;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche des produits" + ex.getMessage());
            return null;
        }
    }
    
    public List<Produit> findProd() {
         List<Produit> listeprod = new ArrayList<>();
       // UserDAO userDAO = new UserDAO();
CategorieDAO categorieDAO = new CategorieDAO();
        String requete = "select * from produit where valider=1";
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

    public List<Produit> findProdByCategorie(String categorie) {
                   List<Produit> listeprod = new ArrayList<>();

       // UserDAO userDAO = new UserDAO();
        CategorieDAO categorieDAO = new CategorieDAO();
        Produit c = new Produit();
 String requete = "select * from produit p inner join categorie c on p.categorie_id=c.id where c.nom=? and valider=1" ;
        try {
      PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1,categorie);
            ResultSet resultat = ps.executeQuery();
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

    
}}
