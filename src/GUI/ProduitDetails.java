/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.CategorieDAO;
import DAO.CommentaireDAO;
import DAO.FavorisDAO;
import DAO.ProduitDAO;
import Entity.Categorie;
import Entity.Commentaire;
import Entity.Favoris;
import Entity.Produit;
import Entity.User;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Dridi
 */
public class ProduitDetails extends javax.swing.JFrame {

    /**
     * Creates new form ProduitDetails
     */
    static int id =0;
    private static User user;
    public Produit produit = new Produit();
    Categorie categorie = new Categorie();
    List<Categorie> listes = new ArrayList<>();
    private ImageIcon icon;
     Image img, sub;
    private final static int button_width = 145;        // button width
    private final static int button_height = 140;   
   
    public ProduitDetails(int choice,User user) {
        
        
        this.user=user;
        initComponents();
       
        id=choice;
        ProduitDAO produitdao = new ProduitDAO();
        produit = produitdao.findProduitById(choice);
        lbnom.setText(produit.getNom());
        lbdescription.setText(produit.getDescription());
        lbprix.setText(""+produit.getPrix());
        lbpromotion.setText(""+produit.getPromotion());
        lbquantite.setText(""+produit.getQantite());
        lbnbpoints.setText(""+produit.getNbvente());
        lbimage.setText("");
                String    imagePath = "/com/images/" + produit.getNom() + ".jpg";
       //     ProduitDAO produitdao = new ProduitDAO();
           
            URL url = getClass().getResource(imagePath);
//                System.out.println(imagePath +"   Get Res : " +getClass().getResource(imagePath));

            if (url != null) {
                img = Toolkit.getDefaultToolkit().getImage(url);
                sub = img.getScaledInstance(button_width - 8, button_height - 30, Image.SCALE_FAST);
                icon = new ImageIcon(sub);
            } else {
                icon = new ImageIcon();
            }
        lbimage.setIcon(icon);
loadCom();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbnom = new javax.swing.JLabel();
        lbdescription = new javax.swing.JLabel();
        lbprix = new javax.swing.JLabel();
        lbquantite = new javax.swing.JLabel();
        lbpromotion = new javax.swing.JLabel();
        lbnbpoints = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Promotion = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Panier = new javax.swing.JButton();
        Favoris = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbimage = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        pCommentaire = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        lbnom.setText("jLabel1");

        lbdescription.setText("jLabel1");

        lbprix.setText("jLabel2");

        lbquantite.setText("jLabel3");

        lbpromotion.setText("jLabel4");

        lbnbpoints.setText("jLabel2");

        jLabel1.setText("Nom :");

        jLabel2.setText("Description : ");

        jLabel3.setText("Prix");

        jLabel4.setText("Quantite");

        Promotion.setText("Promotion");

        jLabel5.setText("Nombre de point :");

        Panier.setText("Panier");
        Panier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PanierActionPerformed(evt);
            }
        });

        Favoris.setText("Favoris");
        Favoris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FavorisActionPerformed(evt);
            }
        });

        lbimage.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbimage)
                .addGap(0, 175, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbimage)
                .addContainerGap(132, Short.MAX_VALUE))
        );

        jButton1.setText("retour");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        pCommentaire.setBackground(new java.awt.Color(255, 255, 255));
        pCommentaire.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pCommentaireMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pCommentaireLayout = new javax.swing.GroupLayout(pCommentaire);
        pCommentaire.setLayout(pCommentaireLayout);
        pCommentaireLayout.setHorizontalGroup(
            pCommentaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 407, Short.MAX_VALUE)
        );
        pCommentaireLayout.setVerticalGroup(
            pCommentaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 131, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(107, 107, 107))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(152, 152, 152))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(84, 84, 84))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(128, 128, 128))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(Promotion)
                                        .addGap(122, 122, 122)))
                                .addGap(73, 73, 73))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(Panier)
                                .addGap(67, 67, 67)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbnom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbpromotion)
                                    .addComponent(lbquantite)
                                    .addComponent(lbnbpoints)
                                    .addComponent(lbdescription)
                                    .addComponent(lbprix)
                                    .addComponent(Favoris))
                                .addGap(107, 107, 107))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pCommentaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbnom, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbdescription)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbprix)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbquantite)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbpromotion, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Promotion))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbnbpoints)
                            .addComponent(jLabel5))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panier)
                    .addComponent(Favoris))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addComponent(pCommentaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PanierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PanierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PanierActionPerformed

    private void FavorisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FavorisActionPerformed
   
        FavorisDAO favroisDAO=new FavorisDAO();
        Favoris favrois=new Favoris();
        ProduitDAO produitDAO=new ProduitDAO();
        Produit produit=new Produit();
        produit =produitDAO.findProduitById(id);
        favrois.setId(1);
        favroisDAO.addFavorisProduits(favrois, produit);
        FavorisDisplay f=new FavorisDisplay();
        f.setVisible(true);
        dispose();
            // TODO add your handling code here:
    }//GEN-LAST:event_FavorisActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
        AfficherProduits a=new AfficherProduits(user);
        a.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pCommentaireMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pCommentaireMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pCommentaireMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProduitDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProduitDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProduitDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProduitDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

             
                new ProduitDetails(id,user)
                        .setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Favoris;
    private javax.swing.JButton Panier;
    private javax.swing.JLabel Promotion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbdescription;
    private javax.swing.JLabel lbimage;
    private javax.swing.JLabel lbnbpoints;
    private javax.swing.JLabel lbnom;
    private javax.swing.JLabel lbprix;
    private javax.swing.JLabel lbpromotion;
    private javax.swing.JLabel lbquantite;
    private javax.swing.JPanel pCommentaire;
    // End of variables declaration//GEN-END:variables
private void loadCom(){
    List<Commentaire> listCom=new ArrayList<>();
    Commentaire com=new Commentaire();
    CommentaireDAO comDAO=new CommentaireDAO();
    listCom=comDAO.findComByProduit(id);
     GridLayout gl = new GridLayout();
     gl.setRows(2);
     gl.setColumns(1);
    pCommentaire.setLayout(gl);
    pCommentaire.setPreferredSize(new Dimension(431, 130));
    JLabel[] labelTab=new JLabel[listCom.size()];
    for(int i=0;i<listCom.size();i++){
        System.out.println(listCom.get(i).getCorps());
        labelTab[i]=new JLabel(listCom.get(i).getCorps());
        labelTab[i].addMouseListener(new MouseListener() {

    @Override
    public void mouseClicked(MouseEvent e) {
    String[] action = {"Modifier", "Supprimer"};
    JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
    int rang = jop.showOptionDialog(null, 
      "Veuillez choisir une action !",
      "Gendarmerie nationale !",
      JOptionPane.YES_NO_CANCEL_OPTION,
      JOptionPane.QUESTION_MESSAGE,
      null,
      action,
      action[1]
          
   );
 
      if (rang == 0){
          // modifier commentaire produit 

      }
      if ( rang ==1 ){
          //suppresion commentaire produit 
      }

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        pCommentaire.add(labelTab[i]);
    } 
}
}
