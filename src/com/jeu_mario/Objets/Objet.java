/*
 * Classe : Objet
 * Auteur: Sami Metoui samimetoui@gmail.com
 * License: GPL 3 (http://www.gnu.org/licenses/gpl.html)
 */

package com.jeu_mario.Objets;

import com.jeu_mario.mario.Main;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author metousia
 */
public class Objet {

 protected Image imgObjet;
 protected ImageIcon icoObjet;

 private int largeur, hauteur; //size
 private int x, y; //position

 public Objet(int largeur, int hauteur, int x, int y) {
  this.largeur = largeur;
  this.hauteur = hauteur;
  this.x = x;
  this.y = y;
 }

 //*****GETTERS*****//
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

 public Image getImgObjet() {
  return imgObjet;
 }
 
 

 //*****SETTERS*****//
 public void setLargeur(int largeur) {
  this.largeur = largeur;
 }

 public void setHauteur(int hauteur) {
  this.hauteur = hauteur;
 }

 public void setX(int x) {
  this.x = x;
 }

 public void setY(int y) {
  this.y = y;
 }

//*****METHODES*****//
 public void deplacement() {
  if (Main.scene.getxPos() >= 0) {
   this.x = this.x - Main.scene.getDx();
  }
 }
}
