/*
 * Classe : Score
 * Auteur: Sami Metoui samimetoui@gmail.com
 * License: GPL 3 (http://www.gnu.org/licenses/gpl.html)
 */

package com.jeu_mario.Affichage;

/**
 *
 * @author metouisa
 */
public class Score {

 //VARIABLES
 private final int NBR_TOTAL_PIECES = 10;
 private int nbrePieces;

 //CONSTRUCTEUR
 public Score() {
  this.nbrePieces = 0;
 }

 //GETTERS
 public int getNBR_TOTAL_PIECES() {
  return NBR_TOTAL_PIECES;
 }

 public int getNbrePieces() {
  return nbrePieces;
 }

 //SETTERS
 public void setNbrePieces(int nbrePieces) {
  this.nbrePieces = nbrePieces;
 }

}
