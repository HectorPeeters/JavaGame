package assets;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import util.Strings;

import java.util.HashMap;

public class Sounds {

    private static HashMap<String, Sound> sounds = new HashMap<>();

    public static Sound getSound(String name) {
        String path = Strings.audioPath + name + ".wav";
        if (sounds.containsKey(name)) {
            return sounds.get(name);
        } else {
            try {
                Sound audio = new Sound(path);
                sounds.put(name, audio);
                return audio;
            } catch (SlickException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
