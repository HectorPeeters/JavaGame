package world;

import graphics.Window;
import org.newdawn.slick.GameContainer;

public class World {

    private static final int TILE_SIZE = Tile.TILE_SIZE;
    public static final int WORLD_WIDTH = Window.getWidth() / TILE_SIZE;
    public static final int WORLD_HEIGHT = Window.getHeight() / TILE_SIZE;

    public static Tile[] tiles = new Tile[WORLD_WIDTH * WORLD_HEIGHT];

    public static void init() {
        for (int i = 0; i < WORLD_WIDTH * WORLD_HEIGHT; i ++) tiles[i] = new Tile(TileType.GRASS);
        WorldGenerator.addTileType(TileType.GRASS);
        WorldGenerator.addTileType(TileType.STONE);
        WorldGenerator.generateWorld();
    }

    public static void renderTile(GameContainer gc, int x, int y) {
        Tile currentTile = getTile(x, y);
        currentTile.tileType.image.draw(x * TILE_SIZE, y * TILE_SIZE);
    }

    public static void renderObject(GameContainer gc, int x, int y) {
        Tile currentTile = getTile(x, y);
        if (currentTile.worldObject != null)
            currentTile.worldObject.image.draw(x * TILE_SIZE, y * TILE_SIZE);
    }


    public static void render(GameContainer gc) {
        for (int x = 0; x < WORLD_WIDTH; x++)
            for (int y = 0; y < WORLD_HEIGHT; y++)
                renderTile(gc, x, y);
    }

    public static boolean isWalkable(int x, int y) {
        if (x >= WORLD_WIDTH || x < 0 || y >= WORLD_HEIGHT || y < 0 ) return false;
        return getTile(x, y).isWalkable();
    }

    public static Tile getTile(int x, int y) {
        return tiles[x + y * WORLD_WIDTH];
    }

}
