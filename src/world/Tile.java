package world;

import game.Camera;
import objects.templates.WorldObject;

public class Tile {

    public static float TILE_SIZE = 15;

    public TileType tileType;
    public WorldObject worldObject;
    public float brightness = 1f;

    public Tile(TileType tileType) {
        this.tileType = tileType;
    }

    public void setWorldObject(WorldObject worldObject) {
        this.worldObject = worldObject;
    }

    public boolean isWalkable() {
        return worldObject == null || worldObject.isWalkable;
    }

    @Override
    public String toString() {
        return tileType.toString();
    }

    public static float getTileSize() {
        return TILE_SIZE + Camera.zoom;
    }

}
