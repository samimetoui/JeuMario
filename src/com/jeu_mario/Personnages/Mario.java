/*
 * Classe : Mario
 * Auteur: Sami Metoui samimetoui@gmail.com
 * License: GPL 3 (http://www.gnu.org/licenses/gpl.html)
 */

package com.jeu_mario.Personnages;

import com.jeu_mario.Audio.Audio;
import com.jeu_mario.Objets.Objet;
import com.jeu_mario.Objets.Piece;
import com.jeu_mario.mario.Main;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author metousia
 */
public class Mario extends Personnage {

 private Image imgMario;
 private ImageIcon icoMario;

 private boolean saut; //vrai si Mario saute
 private int compteurSaut; //durée et hauteur du saut
 private int compteurMort;

//*****CONSTRUCTEUR*****//
 public Mario(int x, int y) {
  super(x, y, 28, 50);
  this.icoMario = new ImageIcon(getClass().getResource("/images/marioMarcheDroite.png"));
  this.imgMario = this.icoMario.getImage();
  
  this.saut = false;
  this.compteurSaut = 0;
  this.compteurMort = 0;
 }

 //*****GETTERS*****//
 public Image getImgMario() {
  return imgMario;
 }

 public boolean isSaut() {
  return saut;
 }

 //*****SETTERS******//
 public void setSaut(boolean saut) {
  this.saut = saut;
 }

 //*****METHODES*****//
 @Override
 public Image marche(String nom, int frequence) {
  String str;
  ImageIcon ico;

  Image img;
  if (this.marche == false || Main.scene.getxPos() <= 0 || Main.scene.getxPos() > 4430) {
   if (this.versDroite == true) {
    str = "/images/" + nom + "ArretDroite.png";
   } else {
    str = "/images/" + nom + "ArretGauche.png";
   }
  } else {
   this.compteur++;
   if (this.compteur / frequence == 0) {
    if (this.versDroite == true) {
     str = "/images/" + nom + "ArretDroite.png";
    } else {
     str = "/images/" + nom + "ArretGauche.png";
    }
   } else {
    if (this.versDroite == true) {
     str = "/images/" + nom + "MarcheDroite.png";
    } else {
     str = "/images/" + nom + "MarcheGauche.png";
    }
   }
   if (this.compteur == 2 * frequence) {
    this.compteur = 0;
   }

  }
  ico = new ImageIcon(getClass().getResource(str));
  img = ico.getImage();
  return img;

 }

 public Image saute() {

  ImageIcon ico;
  Image img;
  String str;

  this.compteurSaut++;

  //Montée du saut
  if (this.compteurSaut <= 40) {
   if (this.getY() > Main.scene.getHauteurPlafond()) {
    this.setY(this.getY() - 4);
   } else {
    this.compteurSaut = 41;
   }
   if (this.isVersDroite() == true) {
    str = "/images/marioSautDroite.png";
   } else {
    str = "/images/marioSautGauche.png";
   }

   //Retombée du saut
  } else if (this.getY() + this.getHauteur() < Main.scene.getySol()) {
   this.setY(this.getY() + 1);
   if (this.isVersDroite() == true) {
    str = "/images/marioSautDroite.png";
   } else {
    str = "/images/marioSautGauche.png";
   }
   //Saut terminé
  } else {
   if (this.isVersDroite() == true) {
    str = "/images/marioArretDroite.png";
   } else {
    str = "/images/marioArretGauche.png";
   }
   this.saut = false;
   this.compteurSaut = 0;
  }
  //Affiche l'image Mario
  ico = new ImageIcon(getClass().getResource(str));
  img = ico.getImage();
  return img;
 }

 public void contact(Objet objet) {
  //contact horizontal
  if ((super.contactAvant(objet) == true && this.isVersDroite() == true)
          || (super.contactArriere(objet) == true && this.isVersDroite() == false)) {
   Main.scene.setDx(0);
   this.setMarche(false);
  }

  //contact avec objet en dessous
  if (super.contactDessous(objet) == true && this.saut == true) { //Mario saute sur un objet
   Main.scene.setySol(objet.getY());
  } else if (super.contactDessous(objet) == false) { //Mario tombe sur le sol initial
   Main.scene.setySol(293); //Altitude du sol initial
   if (this.saut == false) {
    this.setY(243);
   } //Altitude initiale de Mario
  }

  //contact avec objet au-dessus
  if (super.contactDessus(objet) == true) {
   Main.scene.setHauteurPlafond(objet.getY() + objet.getHauteur()); //Le plafond devient le dessous de l'objet
  } else if (super.contactDessus(objet) == false && this.saut == false) {
   Main.scene.setHauteurPlafond(0); //altitude du plafond initial (ciel)
  }
 }

 public boolean contactPiece(Piece piece) {
  if (this.contactArriere(piece) == true || this.contactAvant(piece) == true || this.contactDessous(piece)
          || this.contactDessus(piece) == true) {
   return true;
  } else {
   return false;
  }
 }

 public void contact(Personnage personnage) {
  //contact horizontal
  if (super.contactAvant(personnage) == true || super.contactArriere(personnage) == true) {
   this.setMarche(false);
   this.setVivant(false);
  } else if (super.contactDessous(personnage) == true) {
   personnage.setMarche(false);
   personnage.setVivant(false);
  }
 }
 
 public Image meurt() {
  String str;
  ImageIcon ico;
  Image img;  
  
  str = "/images/boom.png";
  if(this.compteurMort == 0) {
   Audio.playSound("/audio/boum.wav");
  }
  if(this.compteurMort == 100) {
   Audio.playSound("/audio/partiePerdue.wav");
  }
  this.compteurMort++;
  if(this.compteurMort > 100) {
   str = "/images/marioMeurt.png";
   this.setY(this.getY()-1);
  }
  ico = new ImageIcon(getClass().getResource(str));
  img = ico.getImage();
  return img;
 }
}
