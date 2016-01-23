package assets;

import java.util.HashMap;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import util.Strings;

public class Sounds {

	public static HashMap<String, Sound> sounds = new HashMap<String, Sound>();

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
