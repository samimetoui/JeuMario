/*
 * Classe : Piece
 * Auteur: Sami Metoui samimetoui@gmail.com
 * License: GPL 3 (http://www.gnu.org/licenses/gpl.html)
 */

package com.jeu_mario.Objets;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author metouisa
 */
public class Piece extends Objet implements Runnable{
 
 private int compteur;
 private final int PAUSE = 15; //temps d'attente entre 2 tours de boucle
 
 //*****CONSTRUCTEUR*****//
 public Piece(int x, int y) {
  super(30,30, x,y);
  
  super.icoObjet = new ImageIcon(getClass().getResource("/images/piece1.png"));
  super.imgObjet = super.icoObjet.getImage();
 }
 
 //*****METHODES*****//
 public Image bouge() {
  String str;
  ImageIcon ico;
  Image img;
  
  this.compteur++;
  if (this.compteur / 100 == 0) {
   str = "/images/piece1.png";
  } else {
   str = "/images/piece2.png";
  }
  if(this.compteur == 200) {
   this.compteur = 0;
  }
  
  //Affiche l'image de la pièce
  ico = new ImageIcon(getClass().getResource(str));
  img = ico.getImage();
  return img;
 }

 @Override
 public void run() {
  try { Thread.sleep(20); }
  catch (InterruptedException e) {}
  
  while(true) {
   
   this.bouge();
   try { Thread.sleep(PAUSE); }
   catch (InterruptedException e) {}
  }
  
 }
 
}
