package world;

import assets.Images;
import org.newdawn.slick.Image;

public enum TileType {
	
	GRASS("grass"), STONE("stone"), WATER("water");
	
	public Image image;
	
	TileType(String name) {
		image = Images.getImage(name);
	}

}