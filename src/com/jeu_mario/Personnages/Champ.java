/*
 * Classe : Champ
 * Auteur: Sami Metoui samimetoui@gmail.com
 * License: GPL 3 (http://www.gnu.org/licenses/gpl.html)
 */

package com.jeu_mario.Personnages;

import com.jeu_mario.Objets.Objet;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author metouisa
 */
public class Champ extends Personnage implements Runnable {

 private Image imgChamp;
 private ImageIcon icoChamp;

 private final int PAUSE = 15; //temps d'attente entre 2 tours de boucle
 private int dxChamp; //pas de déplacement de champignon

 
 //*****CONSTRUCTEUR*****//
 public Champ(int x, int y) {
  super(x, y, 27, 30);
  super.setVersDroite(true);
  super.setMarche(true);
  this.dxChamp = 1;

  this.icoChamp = new ImageIcon(getClass().getResource("/images/champArretDroite.png"));
  this.imgChamp = this.icoChamp.getImage();

  Thread chronoChamp = new Thread(this);
  chronoChamp.start();
 }

 //*****GETTERS*****//
 public Image getImgChamp() {
  return imgChamp;
 }

 //*****SETTERS*****//
 
 
 //*****METHODES*****//
 public void bouge() {
  if (super.isVersDroite() == true) {
   this.dxChamp = 1;
  } else {
   this.dxChamp = -1;
  }
  super.setX(super.getX() + this.dxChamp);
 }

 @Override
 public void run() {
  try {
   Thread.sleep(20);
  } catch (InterruptedException e) {
  }

  while (true) {
   if(this.isVivant() == true) {
   this.bouge();
   }
   try {
    Thread.sleep(PAUSE);
   } catch (InterruptedException e) {
   }
  }
 }
 
  public void contact(Objet objet) {
  //contact horizontal
  if (super.contactAvant(objet) == true && this.isVersDroite() == true) {
   super.setVersDroite(false);
   this.dxChamp = -1;
  } else if(super.contactArriere(objet) == true && this.isVersDroite() == false) {
   super.setVersDroite(true);
   this.dxChamp = 1;
  }

 }
  
  public void contact(Personnage personnage) {
  //contact horizontal
  if (super.contactAvant(personnage) == true && this.isVersDroite() == true) {
   super.setVersDroite(false);
   this.dxChamp = -1;
  } else if(super.contactArriere(personnage) == true && this.isVersDroite() == false) {
   super.setVersDroite(true);
   this.dxChamp = 1;
  }
 }
  
  public Image meurt() {
   String str;
   ImageIcon ico;
   Image img;

   if(this.isVersDroite() == true) { str = "/images/champEcraseDroite.png"; }
   else { str = "/images/champEcraseGauche.png"; }
   ico = new ImageIcon(getClass().getResource(str));
   img = ico.getImage();
   return img;
  }

}
