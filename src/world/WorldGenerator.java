package world;

import objects.Stone;
import objects.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorldGenerator {

    private static final int ITERATIONS = 2;
    private static Random random = new Random();
    private static List<TileType> tilesToUse = new ArrayList<>();

    public static void addTileType(TileType tileType) {
        tilesToUse.add(tileType);
    }

    public static void generateWorld() {
        generateRandomTiles();
        for(int i = 0; i < ITERATIONS; i ++)
            generateUsingRules();

        for(int y = 0; y < World.WORLD_HEIGHT; y ++) {
            for(int x = 0; x < World.WORLD_WIDTH; x ++) {
                Tile current = World.getTile(x, y);
                if(current.tileType.equals(TileType.STONE)) current.worldObject = new Stone();
                if(current.tileType.equals(TileType.GRASS) && random.nextInt(30) == 1) current.worldObject = new Tree();
            }
        }

    }

    public static void generateUsingRules() {
        for (int x = 0; x < World.WORLD_WIDTH; x++) {
            for (int y = 0; y < World.WORLD_HEIGHT; y++) {
                Tile tile = World.getTile(x, y);
                if (tile.tileType.equals(TileType.STONE)) {
                    int amount = 0;
                    if (checkTile(x, y + 1, TileType.STONE)) amount++;
                    if (checkTile(x + 1, y + 1, TileType.STONE)) amount++;
                    if (checkTile(x + 1, y, TileType.STONE)) amount++;
                    if (checkTile(x + 1, y - 1, TileType.STONE)) amount++;
                    if (checkTile(x, y - 1, TileType.STONE)) amount++;
                    if (checkTile(x - 1, y - 1, TileType.STONE)) amount++;
                    if (checkTile(x - 1, y, TileType.STONE)) amount++;
                    if (checkTile(x - 1, y + 1, TileType.STONE)) amount++;
                    if (amount < 4) tile.tileType = TileType.GRASS;

                } else if (tile.tileType.equals(TileType.GRASS)) {
                    int amount = 0;
                    if (checkTile(x, y + 1, TileType.STONE)) amount++;
                    if (checkTile(x + 1, y + 1, TileType.STONE)) amount++;
                    if (checkTile(x + 1, y, TileType.STONE)) amount++;
                    if (checkTile(x + 1, y - 1, TileType.STONE)) amount++;
                    if (checkTile(x, y - 1, TileType.STONE)) amount++;
                    if (checkTile(x - 1, y - 1, TileType.STONE)) amount++;
                    if (checkTile(x - 1, y, TileType.STONE)) amount++;
                    if (checkTile(x - 1, y + 1, TileType.STONE)) amount++;
                    if (amount >= 5) tile.tileType = TileType.STONE;
                }
            }
        }
    }

    private static boolean checkTile(int x, int y, TileType tileType) {
        if (x < 0 || x >= World.WORLD_WIDTH || y < 0 || y >= World.WORLD_HEIGHT)
            return false;
        return World.getTile(x, y).tileType.equals(tileType);
    }

    private static void generateRandomTiles() {
        for (int i = 0; i < World.WORLD_WIDTH * World.WORLD_HEIGHT; i++) {
            World.tiles[i].tileType = tilesToUse.get(random.nextInt(tilesToUse.size()));
        }
    }
}
