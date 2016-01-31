package world;

import assets.Images;
import org.newdawn.slick.Image;

public enum TileType {

    GRASS("grass_tile"), STONE("stone_tile");

    public Image image;

    TileType(String name) {
        image = Images.getImage(name);
    }

}