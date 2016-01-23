package world;

import objects.WorldObject;

public class Tile {
	
	public static final int TILE_SIZE = 16;
	
	public TileType tileType;
	public WorldObject worldObject;
	
	public Tile(TileType tileType) {
		this.tileType = tileType;
	}
	
	public void setWorldObject(WorldObject worldObject) {
		this.worldObject = worldObject;
	}
	
}
