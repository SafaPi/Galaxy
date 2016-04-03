/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapter;

import DAO.ProduitDAO;
import Entity.Produit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dridi
 */
public class ProduitAdapter extends AbstractTableModel {

    String[] headers = {"Id", "Categorie", "Nom", "Description", "Prix", "Quantité", "Promotion", "Marque", "Nombre Vente"};
    List<Produit> produits = new ArrayList<>();
    ProduitDAO produitDAO;

    public ProduitAdapter() {
        produitDAO = new ProduitDAO();
        produits = produitDAO.findAll();
    }

    @Override
    public int getRowCount() {
        return produits.size();
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
                return produits.get(rowIndex).getId();
            case 1:
                return produits.get(rowIndex).getCategorie_id().getNom();
            case 2:
                return produits.get(rowIndex).getNom();
            case 3:
                return produits.get(rowIndex).getDescription();
            case 4:
                return produits.get(rowIndex).getPrix();
            case 5:
                return produits.get(rowIndex).getQantite();
            case 6:
                return produits.get(rowIndex).getPromotion();
            case 7:
                return produits.get(rowIndex).getMarque();
            case 8:
                return produits.get(rowIndex).getNbvente();
            case 9:
                return "modifier";
            case 10:
                return "supprimer";
            default:
                return null;
        }
    }

}
