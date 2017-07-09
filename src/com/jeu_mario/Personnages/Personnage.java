/*
 * Classe : Personnage
 * Auteur: Sami Metoui samimetoui@gmail.com
 * License: GPL 3 (http://www.gnu.org/licenses/gpl.html)
 */

package com.jeu_mario.Personnages;

import com.jeu_mario.Objets.Objet;
import com.jeu_mario.mario.Main;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author metousia
 */
public class Personnage {

 private int largeur, hauteur; //dimensions
 private int x, y; //position
 protected boolean marche; //vrai qd personnage marche
 protected boolean versDroite; // vrai quand tourné vers droite
 public int compteur; //compteur de pas
 protected boolean vivant; //vrai si le personnage est vivant

 public Personnage(int x, int y, int largeur, int hauteur) {
  this.x = x;
  this.y = y;
  this.largeur = largeur;
  this.hauteur = hauteur;
  this.compteur = 0;
  this.marche = false;
  this.versDroite = true;
  this.vivant = true;
 }

 //***** GETTERS *****//
 public int getLargeur() {
  return largeur;
 }

 public int getHauteur() {
  return hauteur;
 }

 public int getX() {
  return x;
 }

 public int getY() {
  return y;
 }

 public boolean isMarche() {
  return marche;
 }

 public boolean isVersDroite() {
  return versDroite;
 }

 public int getCompteur() {
  return compteur;
 }

 public boolean isVivant() {
  return vivant;
 }

 //***** SETTERS *****//
 public void setX(int x) {
  this.x = x;
 }

 public void setY(int y) {
  this.y = y;
 }

 public void setMarche(boolean marche) {
  this.marche = marche;
 }

 public void setVersDroite(boolean versDroite) {
  this.versDroite = versDroite;
 }

 public void setCompteur(int compteur) {
  this.compteur = compteur;
 }

 public void setVivant(boolean vivant) {
  this.vivant = vivant;
 }

 //*****METHODES*****//
 public Image marche(String nom, int frequence) {
  String str;
  ImageIcon ico;

  Image img;
  if (this.marche == false) {
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

 public void deplacement() {
  if (Main.scene.getxPos() >= 0) {
   this.x = this.x - Main.scene.getDx();
  }
 }

 protected boolean contactAvant(Objet objet) {
  if (this.x + this.largeur < objet.getX() || this.x + this.largeur > objet.getX() + 5
          || this.y + this.hauteur <= objet.getY() || this.y >= objet.getY() + objet.getHauteur()) {
   return false;
  } else {
   return true;
  }
 }

 protected boolean contactArriere(Objet objet) {
  if (this.x > objet.getX() + objet.getLargeur() || this.x + this.largeur < objet.getX() + objet.getLargeur() - 5
          || this.y + this.hauteur <= objet.getY() || this.y >= objet.getY() + objet.getHauteur()) {
   return false;
  } else {
   return true;
  }
 }

 protected boolean contactDessous(Objet objet) {
  if (this.x + this.largeur < objet.getX() + 5 || this.x > objet.getX() + objet.getLargeur() - 5
          || this.y + this.hauteur < objet.getY() || this.y + this.hauteur > objet.getY() + 5) {
   return false;
  } else {
   return true;
  }
 }

 protected boolean contactDessus(Objet objet) {
  if (this.x + this.largeur < objet.getX() + 5 || this.x > objet.getX() + objet.getLargeur() - 5
          || this.y < objet.getY() + objet.getHauteur() || this.y > objet.getY() + objet.getHauteur() + 5) {
   return false;
  } else {
   return true;
  }
 }

 public boolean proche(Objet objet) {
  if ((this.x > objet.getX() - 10 && this.x < objet.getX() + objet.getLargeur() + 10)
          || (this.x + this.largeur > objet.getX() - 10 && this.x + this.largeur < objet.getX() + objet.getLargeur() + 10)) {
   return true;
  } else {
   return false;
  }
 }

 protected boolean contactAvant(Personnage personnage) {
  if (this.x + this.largeur < personnage.getX() || this.x + this.largeur > personnage.getX() + 5
          || this.y + this.hauteur <= personnage.getY() || this.y >= personnage.getY() + personnage.getHauteur()) {
   return false;
  } else {
   return true;
  }
 }

 protected boolean contactArriere(Personnage personnage) {
  if (this.x > personnage.getX() + personnage.getLargeur() || this.x + this.largeur < personnage.getX() + personnage.getLargeur() - 5
          || this.y + this.hauteur <= personnage.getY() || this.y >= personnage.getY() + personnage.getHauteur()) {
   return false;
  } else {
   return true;
  }
 }
 
 protected boolean contactDessous(Personnage personnage) {
  if (this.x + this.largeur < personnage.getX() + 5 || this.x > personnage.getX() + personnage.getLargeur() - 5
          || this.y + this.hauteur < personnage.getY() || this.y + this.hauteur > personnage.getY() + 5) {
   return false;
  } else {
   return true;
  }
 }

 public boolean proche(Personnage personnage) {
  if ((this.x > personnage.getX() - 10 && this.x < personnage.getX() + personnage.getLargeur() + 10)
          || (this.x + this.largeur > personnage.getX() - 10 && this.x + this.largeur < personnage.getX() + personnage.getLargeur() + 10)) {
   return true;
  } else {
   return false;
  }
 }
}
