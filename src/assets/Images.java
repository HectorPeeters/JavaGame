package assets;

import game.Camera;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import util.Strings;
import world.Tile;

import java.util.HashMap;

public class Images {

    private static HashMap<String, Image> images = new HashMap<>();

    public static Image getImage(String name) {
        String path = Strings.imagePath + name + ".png";
        if (images.containsKey(name))
            return images.get(name);
        else
            try {
                Image image = new Image(path, false, Image.FILTER_NEAREST);
                images.put(name, image);
                return image;
            } catch (SlickException e) {
                e.printStackTrace();
            }

        System.err.println("Image " + name + " not found");
        System.exit(-1);
        return null;
    }

    public static void drawImage(String name, int x, int y) {
        drawImage(getImage(name), x, y);
    }

    public static void drawImage(Image image, int x, int y) {
        float absX = (x + Camera.position.x) * Tile.getTileSize();
        float absY = (y + Camera.position.y) * Tile.getTileSize();
        /*boolean clip = absX < 0 || absX >= Window.getWidth() || absY < 0 || absY >= Window.getHeight();
            if (!clip) {*/
        image.draw(absX, absY, (float) (Tile.getTileSize() / image.getWidth()));
        //}
    }
}
