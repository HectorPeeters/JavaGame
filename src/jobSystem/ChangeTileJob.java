package jobSystem;

import math.Vector2i;
import world.TileType;
import world.World;

public class ChangeTileJob extends Job{

	private TileType tileType;
	
	public ChangeTileJob(Vector2i targetPosition, TileType tileType) {
		super(targetPosition);
		this.tileType = tileType;
	}

	public boolean checkRequirements() {
		return World.isWalkable(executePosition.x, executePosition.y) && World.getTile(executePosition.x, executePosition.y).tileType != tileType;
	}

	public void onCreated() {
		
	}

	public void execute() {
		World.getTile(executePosition.x, executePosition.y).tileType = tileType;
	}

}
