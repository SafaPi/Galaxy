
package DAO;

import Entity.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import technique.DataSource;


public class CommentaireDAO  {
    private Connection connection;
    public CommentaireDAO() {
        connection = DataSource.getInstance().getConnection();
    }

       public void addCommentaire(Commentaire com) {
        try {
            String req = "insert into Commentaire (corps,dateCom) values (?,?)";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setString(1, com.getCorps());
            ps.setDate(2,com.getDateComm());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public List<Commentaire> findComByProduit(int id) {
          List<Commentaire> listCom=new ArrayList<>();
        
        UserDAO userDAO=new UserDAO();
        String requete = "select * from commentaire where produit_id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Commentaire com=new Commentaire();
                com.setId(resultat.getInt(1));
                com.setCorps(resultat.getString("corps"));
                com.setProduit(new ProduitDAO().findProduitById(resultat.getInt("produit_id")));
                com.setUser(new UserDAO().findUserById(resultat.getInt("user_id")));
                listCom.add(com);
                
            }
            return listCom;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du com " + ex.getMessage());
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
      
      
     
    
      
    
}
