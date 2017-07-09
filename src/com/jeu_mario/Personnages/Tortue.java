/*
 * Classe : Mario
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
public class Tortue extends Personnage implements Runnable {

 private Image imgTortue;
 private ImageIcon icoTortue;

 private final int PAUSE = 15; //temps d'attente entre 2 tours de boucle
 private int dxTortue; //pas de déplacement de la torute

 public Tortue(int x, int y) {
  super(x, y, 27, 30);
  super.setVersDroite(true);
  super.setMarche(true);
  this.dxTortue = 1;

  this.icoTortue = new ImageIcon(getClass().getResource("/images/tortueArretGauche.png"));
  this.imgTortue = this.icoTortue.getImage();

  Thread chronoTortue = new Thread(this);
  chronoTortue.start();
 }

 //*****GETTERS*****//
 public Image getImgTortue() {
  return imgTortue;
 }

 //*****SETTERS*****//
 //*****METHODES*****//
 public void bouge() {
  if (super.isVersDroite() == true) {
   this.dxTortue = 1;
  } else {
   this.dxTortue = -1;
  }
  super.setX(super.getX() + this.dxTortue);
 }

 @Override
 public void run() {
  try {
   Thread.sleep(20);
  } catch (InterruptedException e) {
  }

  while (true) {
   if (this.isVivant() == true) {
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
   this.dxTortue = -1;
  } else if (super.contactArriere(objet) == true && this.isVersDroite() == false) {
   super.setVersDroite(true);
   this.dxTortue = 1;
  }
 }

 public void contact(Personnage personnage) {
  //contact horizontal
  if (super.contactAvant(personnage) == true && this.isVersDroite() == true) {
   super.setVersDroite(false);
   this.dxTortue = -1;
  } else if (super.contactArriere(personnage) == true && this.isVersDroite() == false) {
   super.setVersDroite(true);
   this.dxTortue = 1;
  }
 }

 public Image meurt() {
  String str;
  ImageIcon ico;
  Image img;

  str = "/images/tortueFermee.png";
  ico = new ImageIcon(getClass().getResource(str));
  img = ico.getImage();
  return img;
 }
}
