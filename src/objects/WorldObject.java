package objects;

import assets.Images;
import org.newdawn.slick.Image;

public abstract class WorldObject {

	public Image image;
	public boolean walkable;

	public WorldObject(String name, boolean walkable) {
		image = Images.getImage(name);
		this.walkable = walkable;
	}

}
