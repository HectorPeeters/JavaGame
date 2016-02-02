package assets;

import java.util.HashMap;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import util.Strings;

public class Images {

	private static HashMap<String, Image> images = new HashMap<>();

	public static Image getImage(String name) {
		String path = Strings.imagePath + name + ".png";
		if (images.containsKey(name)) {
			return images.get(name);
		} else
			try {
				Image image = new Image(path, false, Image.FILTER_NEAREST);
				images.put(name, image);
				return image;
			} catch (SlickException e) {
				e.printStackTrace();
			}

		System.err.println("Image " + name + " not found");
		System.exit(-1);
		return null;
	}

}
