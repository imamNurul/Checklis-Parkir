/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist;

import com.imam.sp_checklist.manager.SpringManager;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.beans.PropertyChangeEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Sista
 */
public class Main{

    
    public static void main(String[] args) {
        // TODO code application logic here
        
        ProgressBar pb = new ProgressBar();
        pb.setVisible(true);
        
        for(int i=0;i<=100;i++){
            try {
                pb.getProgressBar().setValue(i);
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                SpringManager.getInstance();
            }
        }
        pb.dispose();
      
            
            SwingUtilities.invokeLater(() -> {
                try {
                    UIManager.setLookAndFeel(
                            new com.jtattoo.plaf.mcwin.McWinLookAndFeel());
                    
                    Login login = new Login();
                    // Menu_Utama tampilan = new Menu_Utama();
                    Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
                    int lebar=(screen.width-login.getSize().width)/2;
                    int tinggi=(screen.height-login.getSize().height)/2;
                    // tampilan.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    login.setLocation(lebar,tinggi);
                    login.setResizable(false);
                    login.setVisible(true);
                    // tampilan.login();
                    
                    
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
        });
         
        

        

    }

    
}
