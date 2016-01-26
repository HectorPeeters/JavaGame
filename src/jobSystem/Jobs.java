package jobSystem;

import math.Vector2i;
import objects.Door;
import objects.WoodenWall;
import world.TileType;

public class Jobs {
	
	public enum JobType {
		WALK, REMOVE, BUILD_WOODEN_WALL, BUILD_DOOR, PLACE_GRASS, PLACE_STONE
	}
	
	public static Job getJob(JobType job, Vector2i mousePos) {
		switch (job) {
		case WALK:
			return new WalkJob(mousePos);
		case REMOVE:
			return new RemoveJob(mousePos);
		case BUILD_WOODEN_WALL:
			return new BuildJob(mousePos, new WoodenWall());
		case BUILD_DOOR:
			return new BuildJob(mousePos, new Door(Door.getDirection(mousePos)));
		case PLACE_GRASS:
			return new ChangeTileJob(mousePos, TileType.GRASS);
		case PLACE_STONE:
			return new ChangeTileJob(mousePos, TileType.STONE);
		default:
			return null;
		}
	}
}
