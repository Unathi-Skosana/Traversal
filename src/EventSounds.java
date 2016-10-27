/**
 * This class that handles event sounds for the game
 * traversal game, mantains synchrocity and prevents clips from
 * stopping abruptly by using a synchronized method.
 */

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class EventSounds { 
  
  /**
   * synchronized methods, suspends the excution
   * of other sounds until the first thread is 
   * done.class 
   */

  private static synchronized void render(String filename) {
    new Thread(new Runnable() {
      public void run() {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                EventSounds.class.getResourceAsStream("resources/sounds/" + filename));
              clip.open(inputStream);
              clip.start();
              Thread.sleep(clip.getMicrosecondLength() / 1000); 
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
      }
    }).start();
  }

  /**
   * plays the rendered sound in a synchronized
   * manner.
   */
  
  private static void playEventSound(String filename) {
    new Thread(new Runnable() {
      public void run() {
        EventSounds.render(filename);
      }
    }).start();
  }

  /**
   * self-explanatory methods follow
   * further documentation is omitted. 
   */

  public static void wonGameSound() {
    playEventSound("success.wav");
  }

  public static void moveSound() {
    playEventSound("move.wav");
  }

  public static void collectKeySound() {
    playEventSound("collect.wav");
  }

  public static void wallSound() {
    playEventSound("wall.wav");
  }

  public static void lostGameSound() {
    playEventSound("failure.wav");
  }

}
