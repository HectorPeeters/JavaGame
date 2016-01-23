package jobSystem;

import math.Vector2i;
import world.World;

public abstract class Job {

	public Vector2i executePosition;
	public Vector2i targetPosition;

	public Job(Vector2i targetPosition) {
		this.targetPosition = targetPosition;
		executePosition = getExecutePostion(targetPosition);
	}

	public abstract boolean checkRequirements();

	public abstract void onCreated();

	public abstract void execute();

	public static Vector2i getExecutePostion(Vector2i pos) {
		if (World.isWalkable(pos.x, pos.y - 1))
			return new Vector2i(pos.x, pos.y - 1);
		if (World.isWalkable(pos.x + 1, pos.y))
			return new Vector2i(pos.x + 1, pos.y);
		if (World.isWalkable(pos.x, pos.y + 1))
			return new Vector2i(pos.x, pos.y + 1);
		if (World.isWalkable(pos.x + 1, pos.y))
			return new Vector2i(pos.x + 1, pos.y);
		return null;
	}

}
