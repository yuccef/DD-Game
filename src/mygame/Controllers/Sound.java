package src.mygame.Controllers;

import javax.sound.sampled.*;
import java.net.URL;

public class Sound {

    private Clip clip;
    private URL soundFileUrl[];

    public Sound() {
        soundFileUrl = new URL[3]; // Assuming you have 3 sound files
        soundFileUrl[0] = getClass().getResource("click-sound.wav");
        soundFileUrl[1] = getClass().getResource("sound-win.wav");
        soundFileUrl[2] = getClass().getResource("walk-sound.wav");
    }

    public void setSoundFile(int i) {
        try {
            if (soundFileUrl[i] != null) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFileUrl[i]);
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
            } else {
                System.out.println("Error: soundFileUrl[" + i + "] is null");
            }
        } catch (Exception e) {
            System.out.println("Error while reading the audio file");
            e.printStackTrace();
        }
    }

    public void playSound(int i) {
        setSoundFile(i);
        if (clip != null) {
            clip.start();
            System.out.println("Sound started");
        } else {
            System.out.println("Clip is null. Sound not started.");
        }
    }

    public void stopSound() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }


    public long getClipDuration() {
        if (clip != null) {
            return clip.getMicrosecondLength() / 1000;
        }
        return 0;
    }
}
