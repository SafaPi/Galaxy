/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;


import Entity.EvaluationProduit;
import Entity.Produit;
import Entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import technique.DataSource;

/**
 *
 * @author SafaPC
 */
public class EvaluationDAO {
     Connection connection;
    private PreparedStatement statement;

    public EvaluationDAO() {
                connection = DataSource.getInstance().getConnection();

    }
    public void Evaluer(EvaluationProduit evaluation,Produit produit,User user){
          try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           try {

            String req = "insert into evaluationproduit (rating,Produit_id,User_id) values (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(req);
            
           ps.setInt(1, evaluation.getRating());
            ps.setInt(2, produit.getId());
         ps.setInt(3, user.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
 System.out.println("erreur lors de linsertion");
            ex.printStackTrace();
        }
    }
}
