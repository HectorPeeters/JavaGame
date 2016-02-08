package rendering;

import jobSystem.JobManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;
import world.Tile;
import world.World;

public class Renderer {

    public void render(GameContainer gc, StateBasedGame s, Graphics g) {
        for (int y = 0; y < World.WORLD_HEIGHT; y++)
            for (int x = 0; x < World.WORLD_WIDTH; x++) {
                Tile current = World.getTile(x, y);
                if (current.brightness != 0)
                    if (current.worldObject == null)
                        World.renderTile(gc, x, y);
                    else if (current.worldObject.isSolid)
                        World.renderObject(gc, x, y);
                    else {
                        World.renderTile(gc, x, y);
                        World.renderObject(gc, x, y);
                    }
            }
        JobManager.render(gc, s, g);
    }

    public void update(GameContainer gc, StateBasedGame s, int delta) {
        updateWorldLight();
    }

    public void updateWorldLight() {
        for (int y = 0; y < World.WORLD_HEIGHT; y++)
            for (int x = 0; x < World.WORLD_WIDTH; x++) {
                Tile current = World.getTile(x, y);
                boolean dark = true;
                if (!World.isSolid(x, y + 1))
                    dark = false;
                if (!World.isSolid(x, y - 1))
                    dark = false;
                if (!World.isSolid(x + 1, y))
                    dark = false;
                if (!World.isSolid(x - 1, y))
                    dark = false;
                if (dark)
                    current.brightness = 0f;
                else
                    current.brightness = 1f;
            }
    }
}