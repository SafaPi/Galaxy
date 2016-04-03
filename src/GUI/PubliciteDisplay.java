/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Adapter.ProduitAdapter;
import Adapter.PubliciteAdapter;
import DAO.ProduitDAO;
import DAO.PubliciteDAO;
import Entity.Produit;
import Entity.Publicite;
import Entity.User;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dridi
 */
public class PubliciteDisplay extends javax.swing.JFrame {

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
    PubliciteAdapter tablepub = new PubliciteAdapter();

    public PubliciteDisplay() {
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
        AfficheImages();

        //  model=(AbstractTableModel)pubtable.getModel();
        PubliciteDAO pubDAO = new PubliciteDAO();
        List<Publicite> pubs = new ArrayList<>();
        pubs = pubDAO.findAll();

    }

    private void AfficheImages() {
        pnl_pub.removeAll();
        pnl_detail.removeAll();
        User user1 = new User();
        User user2 = new User();
        user1.setId(1);
        user2.setId(2);
        repaint();

        Image img, sub;
        ImageIcon icon;
        String imagePath;

        ArrayList itemImage = new ArrayList();
        ArrayList type = new ArrayList();
        ArrayList sujet = new ArrayList();
        ArrayList nom = new ArrayList();
        ArrayList Lieu = new ArrayList();
        ArrayList Date = new ArrayList();

        PubliciteDAO pubDAO = new PubliciteDAO();
        List<Publicite> pubs = new ArrayList<>();
        pubs = pubDAO.findAll();

        for (Publicite p : pubs) {

            itemImage.add(p.getNom());
            type.add(p.getType());
            sujet.add(p.getSujet());
            nom.add(p.getNom());
            Lieu.add(p.getLieu());
            Date.add(p.getDate());

        }

        JButton[] buttons = new JButton[pubs.size()];
        JTextArea[] lbpub = new JTextArea[pubs.size()];

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

            buttons[i] = new JButton("ok", icon);
            lbpub[i] = new JTextArea("type :" + type.get(i)
                    + "\n\n" + "Description : " + sujet.get(i)
                    + "\n\n" + "Date : " + Date.get(i)
                    + "\n\n" + "Lieu : " + Lieu.get(i));
            buttons[i].setVerticalTextPosition(AbstractButton.BOTTOM);
            buttons[i].setHorizontalTextPosition(AbstractButton.CENTER);

            buttons[i].setBorder(javax.swing.BorderFactory.createEtchedBorder());
            buttons[i].setFont(new java.awt.Font("Wide Latin", 2, 15));
            buttons[i].setForeground(new java.awt.Color(149, 33, 32));
            lbpub[i].setBorder(javax.swing.BorderFactory.createEtchedBorder());
            lbpub[i].setFont(new java.awt.Font("Arial", 2, 13));
            lbpub[i].setEditable(false);
            lbpub[i].setForeground(new java.awt.Color(0, 0, 29));
             int idpub=pubs.get(i).getId();
            buttons[i].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if(user1.getId()==1){
                        PubliciteUpdate mdf = new PubliciteUpdate(idpub);
                        mdf.setVisible(true);
                        
                    }
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
        pDetail = new javax.swing.JPanel();
        pnl_pub = new javax.swing.JPanel();
        pnl_detail = new javax.swing.JPanel();
        jScrollBar1 = new javax.swing.JScrollBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pDetail.setBackground(new java.awt.Color(255, 255, 255));

        pnl_pub.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_detail.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollBar1.setForeground(new java.awt.Color(0, 0, 102));
        pnl_detail.add(jScrollBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, -1, 380));
        jScrollBar1.getAccessibleContext().setAccessibleParent(this);

        javax.swing.GroupLayout pDetailLayout = new javax.swing.GroupLayout(pDetail);
        pDetail.setLayout(pDetailLayout);
        pDetailLayout.setHorizontalGroup(
            pDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDetailLayout.createSequentialGroup()
                .addComponent(pnl_pub, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_detail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pDetailLayout.setVerticalGroup(
            pDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_pub, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
            .addComponent(pnl_detail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pContainerLayout = new javax.swing.GroupLayout(pContainer);
        pContainer.setLayout(pContainerLayout);
        pContainerLayout.setHorizontalGroup(
            pContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pContainerLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pContainerLayout.setVerticalGroup(
            pContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        AfficheImages();  // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(PubliciteDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PubliciteDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PubliciteDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PubliciteDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PubliciteDisplay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JPanel pContainer;
    private javax.swing.JPanel pDetail;
    private javax.swing.JPanel pnl_detail;
    private javax.swing.JPanel pnl_pub;
    // End of variables declaration//GEN-END:variables

}
