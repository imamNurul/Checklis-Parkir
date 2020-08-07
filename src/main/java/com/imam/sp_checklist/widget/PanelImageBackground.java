/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imam.sp_checklist.widget;

/**
 *
 * @author Bonjolz
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author echo
 */
public class PanelImageBackground extends JPanel {

    private final Image image;

    public PanelImageBackground() {
        image = new ImageIcon(getClass().getResource("/com/imam/sp_checklist/image/walpaper.jpg")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D gd = (Graphics2D) g.create();

        gd.drawImage(image, 0, 0, getWidth(), getHeight(), null);

        gd.dispose();
    }
}


