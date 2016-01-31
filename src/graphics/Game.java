package graphics;

import assets.Images;
import entities.Worker;
import jobSystem.JobManager;
import jobSystem.JobWindow;
import math.Vector2i;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
import resources.ResourceManager;
import world.TileType;
import world.World;
import world.WorldGenerator;

public class Game {

    private Vector2i mousePos = new Vector2i(0);

    public Renderer renderer = new Renderer();

    public void init(GameContainer gc, StateBasedGame s) {
        World.init();
        JobManager.addWorker(new Worker(new Vector2i(0, 1)));
        JobWindow.openJobWindow();
    }

    public void render(GameContainer gc, StateBasedGame s, Graphics g) {
        renderer.render(gc, s, g);
        Images.getImage("indicator").draw(mousePos.x * 16, mousePos.y * 16);
    }

    public void update(GameContainer gc, StateBasedGame s, int delta) {
        Input input = gc.getInput();
        mousePos = new Vector2i(input.getMouseX() / 16, input.getMouseY() / 16);
        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
            JobManager.addJob(JobWindow.getSelectedJob(mousePos));

        if (input.isKeyPressed(Input.KEY_DOWN))
            for (Worker worker : JobManager.workers)
                worker.speed += 0.1f;

        if (input.isKeyPressed(Input.KEY_UP))
            for (Worker worker : JobManager.workers)
                worker.speed -= 0.1f;
        JobManager.update(gc, s, delta);
    }
}