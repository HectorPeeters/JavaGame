package jobSystem;

import math.Vector2i;
import world.World;

public class RemoveJob extends Job{

	public RemoveJob(Vector2i targetPosition) {
		super(targetPosition);
	}

	public boolean checkRequirements() {
		return World.getTile(targetPosition.x, targetPosition.y).worldObject!= null;
	}

	public void onCreated() {
		
	}

	public void execute() {
		World.getTile(targetPosition.x, targetPosition.y).worldObject = null;
	}
	
}
