/*
 * Classe : Clavier
 * Auteur: Sami Metoui samimetoui@gmail.com
 * License: GPL 3 (http://www.gnu.org/licenses/gpl.html)
 */

package com.jeu_mario.mario;

import com.jeu_mario.Audio.Audio;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author metousia
 */
public class Clavier implements KeyListener {

 @Override
 public void keyTyped(KeyEvent ke) {
//        throw new UnsupportedOperationException("Not supported yet.");
//To change body of generated methods, choose Tools | Templates.
 }

 @Override
 public void keyPressed(KeyEvent ke) {
  
  if(Main.scene.mario.isVivant() == true) {

  if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
   if (Main.scene.getxPos() == -1) {
    Main.scene.setxPos(0);
    Main.scene.setxFond1(-50);
    Main.scene.setxFond2(750);
   }
   Main.scene.setDx(1);
   Main.scene.mario.setMarche(true);
   Main.scene.mario.setVersDroite(true);
  } else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
   
   if(Main.scene.getxPos() == 4431) {
    Main.scene.setxPos(4430);
    Main.scene.setxFond1(-50);
    Main.scene.setxFond2(750);
   }
   Main.scene.setDx(-1);
   Main.scene.mario.setMarche(true);
   Main.scene.mario.setVersDroite(false);
  }
  //mario saute
  if (ke.getKeyCode() == KeyEvent.VK_SPACE) {
   Main.scene.mario.setSaut(true);
   Audio.playSound("/audio/saut.wav");
  }
 }
//        throw new UnsupportedOperationException("Not supported yet.");
//To change body of generated methods, choose Tools | Templates.
 }

 @Override
 public void keyReleased(KeyEvent ke) {
  Main.scene.setDx(0);
  Main.scene.mario.setMarche(false);
//        throw new UnsupportedOperationException("Not supported yet.");
//To change body of generated methods, choose Tools | Templates.
 }

}
