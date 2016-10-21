import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class eventSounds { 
    public static synchronized void render(String filename) {
        new Thread(new Runnable() {
            public void run() {
                try {
                        Clip clip = AudioSystem.getClip();
                        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                        eventSounds.class.getResourceAsStream("sounds/"+filename));
                        clip.open(inputStream);
                        clip.start();
                        Thread.sleep(clip.getMicrosecondLength()/1000); 
                } catch (Exception e) {
                        System.err.println(e.getMessage());
                }
            }
        }).start();
     }
}
