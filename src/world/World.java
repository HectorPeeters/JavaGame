package world;

import assets.Images;
import org.newdawn.slick.GameContainer;

public class World {

    public static final int WORLD_WIDTH = 50;
    public static final int WORLD_HEIGHT = 50;

    public static Tile[] tiles = new Tile[WORLD_WIDTH * WORLD_HEIGHT];

    public static void init() {
        for (int i = 0; i < WORLD_WIDTH * WORLD_HEIGHT; i++)
            tiles[i] = new Tile(TileType.GRASS);
        WorldGenerator.addTileType(TileType.GRASS);
        WorldGenerator.addTileType(TileType.STONE);
        WorldGenerator.generateWorld();
    }

    public static void renderTile(GameContainer gc, int x, int y) {
        Tile currentTile = getTile(x, y);
        Images.drawImage(currentTile.tileType.image, x, y);
    }

    public static void renderObject(GameContainer gc, int x, int y) {
        Tile currentTile = getTile(x, y);
        if (currentTile.worldObject != null)
            Images.drawImage(currentTile.worldObject.image, x, y);
    }

    public static boolean isTileType(int x, int y, TileType tileType) {
        return !(x < 0 || x >= World.WORLD_WIDTH || y < 0 || y >= World.WORLD_HEIGHT) && getTile(x, y).tileType.equals(tileType);
    }

    public static boolean isWalkable(int x, int y) {
        return !(x >= WORLD_WIDTH || x < 0 || y >= WORLD_HEIGHT || y < 0) && getTile(x, y).isWalkable();
    }

    public static boolean isSolid(int x, int y) {
        return !(x >= WORLD_WIDTH || x < 0 || y >= WORLD_HEIGHT || y < 0) && getTile(x, y).worldObject != null && getTile(x, y).worldObject.isSolid;
    }

    public static Tile getTile(int x, int y) {
        if (x >= WORLD_WIDTH || x < 0 || y >= WORLD_HEIGHT || y < 0)
            return null;
        return tiles[x + y * WORLD_WIDTH];
    }

    public static int getWorldObjectAmount() {
        int amount = 0;
        for (int x = 0; x < WORLD_WIDTH; x++)
            for (int y = 0; y < WORLD_HEIGHT; y++)
                if (getTile(x, y).worldObject != null)
                    amount++;
        return amount;
    }
}