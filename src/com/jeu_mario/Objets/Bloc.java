/*
 * Classe : Bloc
 * Auteur: Sami Metoui samimetoui@gmail.com
 * License: GPL 3 (http://www.gnu.org/licenses/gpl.html)
 */

package com.jeu_mario.Objets;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author metousia
 */
public class Bloc extends Objet {

    public Bloc(int x, int y) {
        super(30, 30, x, y);
        super.icoObjet = new ImageIcon(getClass().getResource("/images/bloc.png"));
        super.imgObjet = this.icoObjet.getImage();
    }
 
}
