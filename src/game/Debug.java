package game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import jobSystem.JobManager;
import world.World;

public class Debug {

	private boolean enabled = false;
	private boolean stableFPS = true;
	private int delta;

	public void updateDebug(GameContainer gc, StateBasedGame s, int delta) {
		this.delta = delta;
		if (gc.getInput().isKeyPressed(Input.KEY_D) && gc.getInput().isKeyPressed(Input.KEY_TAB))
			enabled = !enabled;
		if (gc.getInput().isKeyPressed(Input.KEY_F)) {
			stableFPS = !stableFPS;
			gc.setTargetFrameRate(stableFPS ? 60 : 0);
		}
	}

	public void renderDebug(GameContainer gc, StateBasedGame s, Graphics g) {
		int yOffset = 20;
		if (enabled) {
			int y = -yOffset;
			g.drawString("FPS: " + gc.getFPS(), 0, y += yOffset);
			g.drawString("Delta: " + delta, 0, y += yOffset);
			g.drawString("Tile amount: " + World.tiles.length, 0, y += yOffset);
			g.drawString("WorldObject amount: " + World.getWorldObjectAmount(), 0, y += yOffset);
			g.drawString("Worker amount: " + JobManager.workers.size(), 0, y += yOffset);
			g.drawString("Job amount: " + JobManager.jobs.size(), 0, y += yOffset);
		}
	}
}
