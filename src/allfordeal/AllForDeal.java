/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package allfordeal;

import DAO.CommandeDAO;
import technique.DataSource;

/**
 *
 * @author Dridi
 */
public class AllForDeal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DataSource dt=DataSource.getInstance();
        CommandeDAO c=new CommandeDAO();
        System.out.println(c.findAll());
    }
    
}
