package jobSystem;

import math.Vector2i;
import world.World;

public class WalkJob extends Job{

	public WalkJob(Vector2i targetPosition) {
		super(targetPosition);
	}

	public boolean checkRequirements() {
		return World.isWalkable(executePosition.x, executePosition.y);
	}

	public void onCreated() {
		
	}

	public void execute() {
		
	}

}
