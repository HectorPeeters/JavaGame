package assets;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import util.Strings;
import world.Tile;

import java.util.HashMap;

public class SpriteSheets {

    public static HashMap<String, SpriteSheet> spriteSheets = new HashMap<String, SpriteSheet>();

    public static SpriteSheet getSpriteSheet(String name) {
        String path = Strings.spriteSheetPath + name + ".png";
        if (spriteSheets.containsKey(name)) {
            return spriteSheets.get(name);
        } else {
            try {
                SpriteSheet spriteSheet = new SpriteSheet(path, Tile.TILE_SIZE, Tile.TILE_SIZE);
                spriteSheets.put(name, spriteSheet);
                return spriteSheet;
            } catch (SlickException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
