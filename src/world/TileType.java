package world;

import org.newdawn.slick.Image;

import assets.Images;

public enum TileType {

	GRASS("grass_tile"), STONE("stone_tile");

	public Image image;

	TileType(String name) {
		image = Images.getImage(name);
	}

}