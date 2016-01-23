package entities;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import math.Vector2i;
import world.World;

public class Cow extends Entity {

	private Random random = new Random();

	public Cow(Vector2i position) {
		super(position, "cow");
	}

	public void update(GameContainer gc, StateBasedGame s, int delta) {
		if (random.nextInt(500) == 1) {
			Vector2i newPos = position.add(new Vector2i(random.nextInt(3) - 1, random.nextInt(3) - 1));
			if (World.isWalkable(newPos.x, newPos.y))
				position = newPos;
		}
	}

}
