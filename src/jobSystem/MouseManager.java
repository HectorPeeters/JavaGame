package jobSystem;

import assets.Images;
import game.Camera;
import math.Vector2i;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
import world.Tile;
import world.World;

public class MouseManager {

    public static boolean dragging = false;
    public static Vector2i startPos;
    public static Vector2i endPos;

    public static void updateMouseEvents(GameContainer gc, StateBasedGame s, int delta) {
        Input input = gc.getInput();
        Vector2i mousePos = new Vector2i((int) (input.getMouseX() / Tile.getTileSize()), (int) (input.getMouseY() / Tile.getTileSize()));
        if (!dragging && input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            dragging = true;
            startPos = mousePos.add(Camera.position.getInverted());
        }
        if (dragging)
            endPos = mousePos.add(Camera.position.getInverted()).add(1);
        if (dragging && !input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            dragging = false;
            for (int x = startPos.x; x < endPos.x; x++)
                for (int y = startPos.y; y < endPos.y; y++) {
                    if (x < 0 || x >= World.WORLD_WIDTH || y < 0 || y >= World.WORLD_HEIGHT)
                        continue;
                    JobManager.addJob(JobWindow.getSelectedJob(new Vector2i(x, y)));
                }
            startPos = null;
            endPos = null;
        }
    }

    public static void render(GameContainer gc, StateBasedGame s, Graphics g) {
        if (startPos != null && endPos != null && dragging) {
            for (int x = startPos.x; x < endPos.x; x++) {
                for (int y = startPos.y; y < endPos.y; y++) {
                    Images.drawImage("select", x, y);
                }
            }
        }
    }

}
