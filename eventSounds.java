import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class eventSounds { 
    private static synchronized void render(String filename) {
        new Thread(new Runnable() {
            public void run() {
                try {
                        Clip clip = AudioSystem.getClip();
                        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                        eventSounds.class.getResourceAsStream("Sounds/"+filename));
                        clip.open(inputStream);
                        clip.start();
                        Thread.sleep(clip.getMicrosecondLength()/1000); 
                } catch (Exception e) {
                        System.err.println(e.getMessage());
                }
            }
        }).start();
    }

    private static void playEventSound(String filename) {
        new Thread(new Runnable() {
            public void run() {
                eventSounds.render(filename);
            }
        }).start();
    }

    public static void moveSound() {  playEventSound("move.wav"); }

    public static void hitWallSound() { playEventSound("hitwall.wav"); }

    public static void collectKeySound() { playEventSound("collect.wav"); }

    public static void failedSound() { playEventSound("lose.wav"); }
}
