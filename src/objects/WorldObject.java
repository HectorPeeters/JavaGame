package objects;

import org.newdawn.slick.Image;

import assets.Images;

public abstract class WorldObject {

	public Image image;
	public boolean isWalkable;
	public boolean isSolid;
	public int destroyTime;

	public WorldObject(String name, boolean isWalkable, boolean isSolid, int destroyTime) {
		image = Images.getImage(name);
		this.isWalkable = isWalkable;
		this.isSolid = isSolid;
		this.destroyTime = destroyTime;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}

	public abstract String[] getResources();

}
