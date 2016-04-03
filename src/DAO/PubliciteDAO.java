/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Publicite;
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
 * @author Dridi
 */
public class PubliciteDAO {

    Connection connection;
    DataBufferByte data;
    private PreparedStatement statement;
    private UploadedFile uploadedFile;

    public PubliciteDAO() {
        connection = DataSource.getInstance().getConnection();
    }

    public void addPublicite(Publicite pub) throws FileNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {

            String req = "insert into publicite (type,sujet,image,nom,lieu,date) values (?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req);

            ps.setString(1, pub.getType());
            ps.setString(2, pub.getSujet());
            File ff = new File(pub.getUrl());
            FileInputStream fin = new FileInputStream(ff);
            ps.setBinaryStream(3, fin, (int) ff.length());
            ps.setString(4, pub.getNom());
            ps.setString(5, pub.getLieu());
            ps.setDate(6, pub.getDate());
            //   ps.setInt(8, produit.getUser().getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PubliciteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Publicite findPubById(int id) {

        Publicite pub = new Publicite();
        UserDAO userDAO = new UserDAO();
        String requete = "select * from publicite where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                pub.setId(resultat.getInt("id"));
                pub.setUser(userDAO.findUserById(resultat.getInt("user_id")));
                pub.setType(resultat.getString("type"));
                pub.setSujet(resultat.getString("sujet"));
                pub.setNom(resultat.getString("nom"));
                pub.setLieu(resultat.getString("lieu"));
                pub.setDate(resultat.getDate("date"));

            }
            return pub;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche de la publicité " + ex.getMessage());
            return null;
        }
    }

    public List<Publicite> findAll() {
        List<Publicite> listepubs = new ArrayList<>();
        UserDAO userDAO = new UserDAO();

        String requete = "select * from publicite";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {

                Publicite pub = new Publicite();
                String destinatoin = "C:\\Users\\Dridi\\Documents\\AllForDeal\\src\\com\\images" + System.getProperty("file.separator") + resultat.getString("nom") + ".png";
                File ff = new File(destinatoin);
                //  File ff = new File("C:/" + resultat.getString("type") + ".jpg");

                FileOutputStream fin = new FileOutputStream(ff);
                //    pub.setUrl(destinatoin);
                pub.setId(resultat.getInt("id"));
                pub.setUser(userDAO.findUserById(resultat.getInt(2)));
                pub.setType(resultat.getString(3));
                pub.setSujet(resultat.getString("sujet"));
                Blob blob = resultat.getBlob("image");
                pub.setNom(resultat.getString(6));
                pub.setLieu(resultat.getString(7));
                pub.setDate(resultat.getDate(8));
                //lecture du blob et écriture sur le disque 
                BufferedImage image = ImageIO.read(blob.getBinaryStream());
                FileOutputStream stream = new FileOutputStream(ff);
                ImageIO.write(image, "png", stream);
//                InputStream isImg = resultat.getBinaryStream("image");
//                byte[] buff = new byte[65000];
//                int length=0;
//                while ((length=isImg.read(buff))>0){
//                    fin.write(buff);
//                }
                pub.setImage(blob);

                listepubs.add(pub);

            }
            return listepubs;
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

    public void deletePublicite(int id) {

        String requete = "delete from publicite where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Suppression effectué avec succées");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    public boolean modifier(Publicite pub) {
        try {
            String url = " UPDATE Publicite SET type=?, sujet=? ,nom=?,lieu=? , date=? WHERE id=?";
            PreparedStatement prst = connection.prepareStatement(url);

            prst.setString(1, pub.getType());
            prst.setString(2, pub.getSujet());          
            prst.setString(3, pub.getNom());
            prst.setString(4, pub.getLieu());
            prst.setDate(5, pub.getDate());
            prst.setInt(6, pub.getId());
            

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
            String url = " DELETE FROM publicite WHERE id=" + c + "";
            PreparedStatement ps = connection.prepareStatement(url);

            ps.execute(url);
            System.out.println("publicite supprimé du favoris");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PubliciteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public Publicite AffichagesPublicitesbyNom(String nom) {
        Publicite pub = new Publicite();

        String s = null;
        String requete = "SELECT * FROM Publicite where nom like '%" + nom + "%'";
        UserDAO userDAO = new UserDAO();

        try {
            Statement statement = DataSource.getInstance().getConnection()
                    .createStatement();

            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                pub.setId(resultat.getInt("id"));
                pub.setUser(userDAO.findUserById(resultat.getInt("user")));
                pub.setType((resultat.getString("type")));
                pub.setSujet(resultat.getString("sujet"));
                pub.setNom(resultat.getString("nom"));
                pub.setLieu(resultat.getString("Lieu"));
                pub.setDate(resultat.getDate("date"));

            }
            return pub;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement de detail du pub " + ex.getMessage());
            return null;
        }

    }

    public Publicite findPubliciteByProprtie(String proprtie, Object value) {
        Publicite pub = new Publicite();
        List<Publicite> pubs = new ArrayList<>();
        UserDAO userDAO = new UserDAO();
        String requete = "select * from Publicite where ?=?";
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
                pub.setId(resultat.getInt(1));
                pub.setType(resultat.getString("type"));
                pub.setSujet(resultat.getString("sujet"));
                pub.setNom(resultat.getString("nom"));
                pub.setLieu(resultat.getString("Lieu"));
                pub.setDate(resultat.getDate("date"));

                pubs.add(pub);
            }
            return pub;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche des publicités" + ex.getMessage());
            return null;
        }
    }
}
