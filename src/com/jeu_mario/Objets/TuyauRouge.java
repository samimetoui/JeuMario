/*
 * Classe : TuyauRouge
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
public class TuyauRouge extends Objet {
    


    public TuyauRouge(int x, int y) {
        super(43, 65, x, y);
        super.icoObjet = new ImageIcon(getClass().getResource("/images/tuyauRouge.png"));
        super.imgObjet = this.icoObjet.getImage();
    }
    
}
