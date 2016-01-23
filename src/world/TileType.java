package world;

import org.newdawn.slick.Image;

import assets.Images;

public enum TileType {
	
	GRASS("grass"), STONE("stone"), WATER("water");
	
	public Image image;
	
	TileType(String name) {
		image = Images.getImage(name);
	}

}