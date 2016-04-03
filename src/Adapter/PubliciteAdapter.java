/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Adapter;

import DAO.ProduitDAO;
import DAO.PubliciteDAO;
import Entity.Produit;
import Entity.Publicite;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dridi
 */
public class PubliciteAdapter  extends AbstractTableModel {

    String[] headers = {"Id", "Sujet","Image"};
    List<Publicite> publicite = new ArrayList<>();
    PubliciteDAO publicteDAO;

    public PubliciteAdapter() {
        publicteDAO = new PubliciteDAO();
        publicite = publicteDAO.findAll();
    }

    @Override
    public int getRowCount() {
        return publicite.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public String getColumnName(int i) {
        return headers[i];
    }

    @Override
    public Object getValueAt(int rowIndex, int colmunIndex) {
        switch (colmunIndex) {
            case 0:
                return publicite.get(rowIndex).getId();
            case 1:
                return publicite.get(rowIndex).getSujet();
              case 2:
ImageIcon image = new ImageIcon(new ImageIcon(("D://Evenement.png")).getImage()
             .getScaledInstance(150, 120, Image.SCALE_SMOOTH) );   
        return image;
            default:
                return null;
        }
    }

}

   
