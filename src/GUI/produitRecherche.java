/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Adapter.ProduitAdapter;
import DAO.ProduitDAO;
import Entity.Categorie;
import Entity.Produit;
import static com.sun.org.apache.bcel.internal.generic.Type.NULL;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.net.URL;
import static java.sql.JDBCType.NULL;
import static java.sql.Types.NULL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import static jdk.nashorn.internal.parser.TokenType.NOT;

/**
 *
 * @author Dridi
 */
public class produitRecherche extends javax.swing.JFrame {

    private static final int IMG_WIDTH = 120;
    private static final int IMG_HEIGHT = 120;
    private final static int button_width = 145;        // button width
    private final static int button_height = 140;        // button height
    private final static int horizontalGap = 10;         // horizontal gap in button
    private final static int verticalGap = 10;         // verticle gap in button
    private final static int numberOfColumns = 1;          // number of colums in the button panel
    private final static int fontSize = 13;         // font size of button name
    private final static int fontType = Font.BOLD;  // font type
    private final static String fontName = "Wide latin";    // font name
    private final static Color fontColor = new Color(149, 33, 32);  // font colot
    /**
     * Creates new form PubliciteDisplay
     */

    AbstractTableModel model;
    int id;
    ProduitAdapter tablepub = new ProduitAdapter();
Produit p = new Produit();
        //String b=p.getCategorie_id().getNom();
    public produitRecherche(String c) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

        } catch (Exception ex) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        initComponents();
          ProduitDAO pubDAO = new ProduitDAO();
        List<Produit> pubs = new ArrayList<>();
       // pubs = pubDAO.findProdByCategorie();
        pnl_pub.removeAll();
      pnl_detail.removeAll();
       

        Image img, sub;
        ImageIcon icon;
        String imagePath;
        ArrayList itemImage = new ArrayList();
        ArrayList categorie = new ArrayList();
        ArrayList nom = new ArrayList();
        ArrayList description = new ArrayList();
        ArrayList prix = new ArrayList();
        ArrayList qantite = new ArrayList();
        ArrayList promotion = new ArrayList();
        ArrayList marque = new ArrayList();
        ArrayList nbPointBase = new ArrayList();
        ProduitDAO prodDao = new ProduitDAO();
        List<Produit> prod = new ArrayList<>();
       prod = prodDao.findProdByCategorie(c);

//String c = jTextField1.getText();
      //prod = prodDao.findProdByCategorie(c);

        for (Produit p : prod) {
            itemImage.add(p.getNom());
            categorie.add(p.getCategorie_id().getNom());
            description.add(p.getDescription());
            nom.add(p.getNom());
            prix.add(p.getPrix());
            marque.add(p.getMarque());
            qantite.add(p.getQantite());
            nbPointBase.add(p.getNbPointBase());
            promotion.add(p.getPromotion());

           repaint();
            } 
        
JScrollPane panelPane = new JScrollPane();
panelPane.scrollRectToVisible(panelPane.getBounds());

        JButton[] buttons = new JButton[prod.size()];
        JTextArea[] lbpub = new JTextArea[prod.size()];

        for (int i = 0; i < buttons.length; i++) {

            imagePath = "/com/images/" + itemImage.get(i) + ".png";
            System.out.println(imagePath);

            URL url = getClass().getResource(imagePath);
//                System.out.println(imagePath +"   Get Res : " +getClass().getResource(imagePath));

            if (url != null) {
                img = Toolkit.getDefaultToolkit().getImage(url);
                sub = img.getScaledInstance(button_width - 8, button_height - 30, Image.SCALE_FAST);
                icon = new ImageIcon(sub);
            } else {
                icon = new ImageIcon();
            }

           buttons[i] = new JButton("", icon);
            lbpub[i] = new JTextArea("nom :" + nom.get(i)
                    + "\n\n" + "Description : " + description.get(i)
                    + "\n\n" + "categorie : " + categorie.get(i)

                    + "\n\n" + "prix : " + prix.get(i)
            + "\n\n" + "marque : " + marque.get(i)
              + "\n\n" + "quantite : " + qantite.get(i)
              + "\n\n" + "promotion : " + promotion.get(i)
              + "\n\n" + "NbPoint : " + nbPointBase.get(i));
            buttons[i].setVerticalTextPosition(AbstractButton.BOTTOM);
            buttons[i].setHorizontalTextPosition(AbstractButton.CENTER);

            buttons[i].setBorder(javax.swing.BorderFactory.createEtchedBorder());
            buttons[i].setFont(new java.awt.Font("Wide Latin", 2, 15));
            buttons[i].setForeground(new java.awt.Color(149, 33, 32));
            lbpub[i].setBorder(javax.swing.BorderFactory.createEtchedBorder());
            lbpub[i].setFont(new java.awt.Font("Arial", 2, 13));
            lbpub[i].setEditable(false);
            lbpub[i].setForeground(new java.awt.Color(0, 0, 29));
             int idpub=prod.get(i).getId();
            this.getContentPane().add(jScrollBar1, BorderLayout.CENTER);

            buttons[i].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                   // if(user1.getId()==1){
                        Evaluation mdf = new Evaluation(idpub);
                        mdf.setVisible(true);
                     dispose();   
                   // }
                }
            });

        }
        int b = 0;
        int vGap = verticalGap;
        int hGap = horizontalGap;
        int bLength = buttons.length;
        int bRows = bLength / numberOfColumns + 1;
        L1:
        for (int j = 0; j < bRows; j++) {
            vGap = 10;
            for (int k = 0; k < numberOfColumns; k++) {
                pnl_detail.add(lbpub[b], new org.netbeans.lib.awtextra.AbsoluteConstraints(vGap, hGap, this.getWidth() - button_width, button_height));

                repaint();
                pnl_pub.add(buttons[b], new org.netbeans.lib.awtextra.AbsoluteConstraints(vGap, hGap, button_width, button_height));

                repaint();
                vGap += button_width + verticalGap;
                b++;
                if (b >= bLength) {
                    break L1;
                }
            }
            hGap += button_height + horizontalGap;
        }
        pack();
initComponents();

    }

    private void AfficheImages() {
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pContainer = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pnl_pub = new javax.swing.JPanel();
        pnl_detail = new javax.swing.JPanel();
        jScrollBar1 = new javax.swing.JScrollBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnl_pub.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_pub.setMaximumSize(new java.awt.Dimension(21474, 21474));
        pnl_pub.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_detail.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollBar1.setForeground(new java.awt.Color(0, 0, 102));
        pnl_detail.add(jScrollBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, -1, 380));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(pnl_pub, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_detail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_pub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_detail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout pContainerLayout = new javax.swing.GroupLayout(pContainer);
        pContainer.setLayout(pContainerLayout);
        pContainerLayout.setHorizontalGroup(
            pContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );
        pContainerLayout.setVerticalGroup(
            pContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
     
      //  AfficheImages();  // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(produitRecherche.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(produitRecherche.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(produitRecherche.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(produitRecherche.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              
            //   new ProduitBlob1().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pContainer;
    private javax.swing.JPanel pnl_detail;
    private javax.swing.JPanel pnl_pub;
    // End of variables declaration//GEN-END:variables

}
