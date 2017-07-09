/*
 * Classe : Main
 * Auteur: Sami Metoui samimetoui@gmail.com
 * License: GPL 3 (http://www.gnu.org/licenses/gpl.html)
 */

package com.jeu_mario.mario;

import javax.swing.JFrame;

/**
 *
 * @author metousia
 */

public class Main {

    public static Scene scene;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
     
        JFrame fenetre = new JFrame("Jeu style Mario");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(700,360);
        fenetre.setLocationRelativeTo(null);
        fenetre.setResizable(false);
        fenetre.setAlwaysOnTop(true);
        
        //Instance de scene
        scene = new Scene();
        
        fenetre.setContentPane(scene); //Associe la scene 
        fenetre.setVisible(true);
        
    }
    
}
