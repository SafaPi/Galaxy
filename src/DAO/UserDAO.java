/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.*;
import Util.Password;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import technique.DataSource;

/**
 *
 * @author Dridi
 */
public class UserDAO {

    private Connection connection;

    public UserDAO() {
        connection = DataSource.getInstance().getConnection();
    }

    public User findUserById(int id) {
        User user = new User();
        String requete = "select * from user where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                user.setId(resultat.getInt(1));

            }
            return user;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche de l'utilisateur " + ex.getMessage());
            return null;
        }

    }

    public boolean insert(User t) {
        String req
                = "insert into user (username,email,salt,password) values( ?,? ,?,?)";
        try {

            PreparedStatement pst = connection.prepareStatement(req);
            pst.setString(1, t.getUsername());

            pst.setString(2, t.getEmail());

            String password = t.getPassword();
            pst.setString(4, Password.hashPassword(password));
            pst.setString(3, Password.saltPass.substring(7));

            int executeUpdate = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;

    }

    public boolean login(String login, String password, User user) {
        String codeCrypter = Password.hashPasswordWithSalt(password, "$2y$13$"+user.getSalt());
        System.out.println(user.getPassword());
        System.out.println(codeCrypter);

        return user.getPassword().equals(codeCrypter);
    }

    public User getUserByUserName(String userName) {
        User user = new User();
        String req = "select * from user where username=?";
        try {
            PreparedStatement pst = connection.prepareStatement(req);
            pst.setString(1, userName);
            ResultSet resultat = pst.executeQuery();

            while (resultat.next()) {

                //   user.setDateNaiss( resultat.getDate("dateNaiss"));   Problem :/
                user.setEmail(resultat.getString("email"));

                user.setId(resultat.getInt("id"));

                user.setPassword(resultat.getString("password"));

                user.setSalt(resultat.getString("salt"));

            }
            return user;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
    }
}
