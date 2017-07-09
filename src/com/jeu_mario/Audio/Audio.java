/*
 * Classe : Audio
 * Auteur: Sami Metoui samimetoui@gmail.com
 * License: GPL 3 (http://www.gnu.org/licenses/gpl.html)
 */

package com.jeu_mario.Audio;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


/**
 *
 * @author metouisa
 */
public class Audio {
 //*****VARIABLES*****//
 private Clip clip;
 
 //*****CONSTRUCTEUR*****//

 public Audio(String son) {
  
  try {
   AudioInputStream audio = AudioSystem.getAudioInputStream(getClass().getResource(son));
   clip = AudioSystem.getClip();
   clip.open(audio);
  } catch (Exception e) {}
 }
 
 //*****GETTERS*****//

 public Clip getClip() {
  return clip;
 }
 
 
 //*****METHODES*****//
 
 void play(){clip.start();}
 void stop(){clip.stop();}
 
 public static void playSound(String son) {
  Audio s = new Audio(son);
  s.play();
 }
 
}
