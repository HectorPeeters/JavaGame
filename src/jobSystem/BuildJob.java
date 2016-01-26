package jobSystem;

import math.Vector2i;
import objects.WorldObject;
import world.World;

public class BuildJob extends Job {

	public WorldObject worldObject;

	public BuildJob(Vector2i targetPosition, WorldObject worldObject) {
		super(targetPosition);
		this.worldObject = worldObject;
	}

	public boolean checkRequirements() {
		return World.getTile(targetPosition.x, targetPosition.y).worldObject == null;
	}

	public void onCreated() {

	}

	public void execute() {
		World.getTile(targetPosition.x, targetPosition.y).worldObject = worldObject;
	}

}
