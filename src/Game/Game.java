package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import entities.Worker;
import jobSystem.JobManager;
import jobSystem.JobWindow;
import jobSystem.MouseManager;
import math.Vector2i;
import rendering.Renderer;
import world.World;

public class Game {

	public Renderer renderer = new Renderer();
	private Debug debug = new Debug();

	public void init(GameContainer gc, StateBasedGame s) {
		World.init();
		JobManager.addWorker(new Worker(new Vector2i(0, 1)));
		JobWindow.openJobWindow();
	}

	public void render(GameContainer gc, StateBasedGame s, Graphics g) {
		renderer.render(gc, s, g);
		MouseManager.render(gc, s, g);
		debug.renderDebug(gc, s, g);
	}

	public void update(GameContainer gc, StateBasedGame s, int delta) {
		MouseManager.updateMouseEvents(gc, s, delta);
		JobManager.update(gc, s, delta);
		renderer.update(gc, s, delta);
		debug.updateDebug(gc, s, delta);
		if (gc.getInput().isKeyPressed(Input.KEY_G))
			World.init();
	}
}