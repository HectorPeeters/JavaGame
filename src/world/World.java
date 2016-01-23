package world;

import org.newdawn.slick.GameContainer;

import graphics.Window;
import objects.WoodenWall;

public class World {

	public static final int TILE_SIZE = Tile.TILE_SIZE;
	public static final int WORLD_WIDTH = Window.getWidth() / TILE_SIZE;
	public static final int WORLD_HEIGHT = Window.getHeight() / TILE_SIZE;

	public static Tile[] tiles = new Tile[WORLD_WIDTH * WORLD_HEIGHT];

	public static void init() {
		WorldGenerator.addTileType(TileType.GRASS);
		WorldGenerator.addTileType(TileType.STONE);
		for (int x = 0; x < WORLD_WIDTH; x++) {
			for (int y = 0; y < WORLD_HEIGHT; y++) {
				tiles[x + y * WORLD_WIDTH] = new Tile(WorldGenerator.getTile(x, y));
			}
		}
		
		getTile(5, 5).worldObject = new WoodenWall();
	}

	public static void render(GameContainer gc) {
		renderGround();
		renderObjects();
	}

	private static void renderObjects() {
		for (int x = 0; x < WORLD_WIDTH; x++) {
			for (int y = 0; y < WORLD_HEIGHT; y++) {
				Tile currentTile = getTile(x, y);
				if (currentTile.worldObject != null)
					currentTile.worldObject.image.draw(x * TILE_SIZE, y * TILE_SIZE);
			}
		}
	}

	private static void renderGround() {
		for (int x = 0; x < WORLD_WIDTH; x++) {
			for (int y = 0; y < WORLD_HEIGHT; y++) {
				getTile(x, y).tileType.image.draw(x * TILE_SIZE, y * TILE_SIZE);
			}
		}
	}

	public static boolean isWalkable(int x, int y) {
		if (x >= WORLD_WIDTH || x < 0 || y >= WORLD_HEIGHT || y < 0)
			return false;
		if (getTile(x, y).worldObject == null)
			return true;
		return getTile(x, y).worldObject.walkable;
	}

	public static Tile getTile(int x, int y) {
		return tiles[x + y * WORLD_WIDTH];
	}

}
