package objects;

import org.newdawn.slick.Image;

import assets.Images;

public abstract class WorldObject {

	public Image image;
	public boolean walkable;

	public WorldObject(String name, boolean walkable) {
		image = Images.getImage(name);
		this.walkable = walkable;
	}

}
