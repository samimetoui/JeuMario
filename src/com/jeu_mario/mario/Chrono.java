/*
 * Classe : Chrono
 * Auteur: Sami Metoui samimetoui@gmail.com
 * License: GPL 3 (http://www.gnu.org/licenses/gpl.html)
 */

package com.jeu_mario.mario;

/**
 *
 * @author metousia
 */
public class Chrono implements Runnable{
   
    private final int PAUSE = 3;
    
    @Override
    public void run() {
        while (true) {
            Main.scene.repaint();
            
            try {
                Thread.sleep(PAUSE);
            }catch(InterruptedException e) {}
        }
    }
    
}
