package world;

import math.Vector2i;
import objects.Stone;
import objects.ores.DiamondOre;
import objects.ores.IronOre;
import objects.plants.Bush;
import objects.plants.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorldGenerator {

    private static final int ITERATIONS = 5;
    private static Random random = new Random();
    private static List<TileType> tilesToUse = new ArrayList<>();

    public static void addTileType(TileType tileType) {
        tilesToUse.add(tileType);
    }

    public static void generateWorld() {
        generateRandomTiles();
        for (int i = 0; i < ITERATIONS; i++)
            generateUsingRules();
        placeAccesories();
    }

    public static void placeAccesories() {
        for (int y = 0; y < World.WORLD_HEIGHT; y++) {
            for (int x = 0; x < World.WORLD_WIDTH; x++) {
                Tile current = World.getTile(x, y);
                if (current.tileType.equals(TileType.STONE))
                    current.worldObject = new Stone();
                if (current.tileType.equals(TileType.GRASS) && random.nextInt(30) == 1)
                    current.worldObject = new Tree();
                if (current.tileType.equals(TileType.GRASS) && random.nextInt(50) == 1)
                    current.worldObject = new Bush();
                if (current.tileType.equals(TileType.STONE) && random.nextInt(40) == 1)
                    current.worldObject = new IronOre();
                if (current.tileType.equals(TileType.STONE) && random.nextInt(100) == 1)
                    current.worldObject = new DiamondOre();
            }
        }
    }

    public static void generateUsingRules() {
        for (int x = 0; x < World.WORLD_WIDTH; x++)
            for (int y = 0; y < World.WORLD_HEIGHT; y++) {
                Tile tile = World.getTile(x, y);
                if (tile.tileType.equals(TileType.STONE)) {
                    if (getSurroundingTileAmount(new Vector2i(x, y), TileType.STONE) < 4)
                        tile.tileType = TileType.GRASS;

                } else if (tile.tileType.equals(TileType.GRASS)) {

                    if (getSurroundingTileAmount(new Vector2i(x, y), TileType.STONE) >= 5)
                        tile.tileType = TileType.STONE;
                }
            }
    }

    private static int getSurroundingTileAmount(Vector2i pos, TileType tileType) {
        int x = pos.x;
        int y = pos.y;
        int amount = 0;
        if (checkTile(x, y + 1, tileType))
            amount++;
        if (checkTile(x + 1, y + 1, tileType))
            amount++;
        if (checkTile(x + 1, y, tileType))
            amount++;
        if (checkTile(x + 1, y - 1, tileType))
            amount++;
        if (checkTile(x, y - 1, tileType))
            amount++;
        if (checkTile(x - 1, y - 1, tileType))
            amount++;
        if (checkTile(x - 1, y, tileType))
            amount++;
        if (checkTile(x - 1, y + 1, tileType))
            amount++;
        return amount;
    }

    private static boolean checkTile(int x, int y, TileType tileType) {
        return World.isTileType(x, y, tileType);
    }

    private static void generateRandomTiles() {
        for (int i = 0; i < World.WORLD_WIDTH * World.WORLD_HEIGHT; i++)
            World.tiles[i].tileType = tilesToUse.get(random.nextInt(tilesToUse.size()));
    }
}
