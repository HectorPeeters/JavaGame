package world;

import game.Window;
import org.newdawn.slick.Color;
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
        currentTile.tileType.image.draw(x * TILE_SIZE, y * TILE_SIZE, new Color(1, 1, 1, currentTile.brightness));
    }

    public static void renderObject(GameContainer gc, int x, int y) {
        Tile currentTile = getTile(x, y);
        if (currentTile.worldObject != null)
            currentTile.worldObject.image.draw(x * TILE_SIZE, y * TILE_SIZE);
    }

    public static boolean isTileType(int x, int y, TileType tileType) {
        if (x < 0 || x >= World.WORLD_WIDTH || y < 0 || y >= World.WORLD_HEIGHT)
            return false;
        return getTile(x, y).tileType.equals(tileType);
    }

    public static boolean isWalkable(int x, int y) {
        if (x >= WORLD_WIDTH || x < 0 || y >= WORLD_HEIGHT || y < 0 ) return false;
        return getTile(x, y).isWalkable();
    }

    public static boolean isSolid(int x, int y) {
        if (x >= WORLD_WIDTH || x < 0 || y >= WORLD_HEIGHT || y < 0 ) return false;
        if(getTile(x, y).worldObject != null)
            return getTile(x, y).worldObject.isSolid;
        return false;
    }

    public static Tile getTile(int x, int y) {
        if (x >= WORLD_WIDTH || x < 0 || y >= WORLD_HEIGHT || y < 0 ) return null;
        return tiles[x + y * WORLD_WIDTH];
    }

    public static int getWorldObjectAmount() {
        int amount = 0;
        for (int x = 0; x < WORLD_WIDTH; x++)
            for (int y = 0; y < WORLD_HEIGHT; y++)
                if(getTile(x, y).worldObject != null) amount ++;
        return  amount;
    }
}