/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package technique;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Maher
 */
public class DataSource {

    private String url;
    private String login;
    private Connection connection;
    private Properties properties;
    private static DataSource instance;

    private DataSource() {
        try {
            properties = new Properties();
            properties.load(new FileInputStream(new File("configuration.properties")));
            url = properties.getProperty("url");
            login = properties.getProperty("login");
            connection = DriverManager.getConnection(url, login,"");
        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }
}
