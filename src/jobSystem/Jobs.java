package jobSystem;

import jobSystem.jobs.BuildJob;
import jobSystem.jobs.ChangeTileJob;
import jobSystem.jobs.RemoveJob;
import jobSystem.jobs.WalkJob;
import math.Vector2i;
import objects.*;
import objects.plants.Tree;
import world.TileType;

public class Jobs {

    public enum JobType {
        MOVE, REMOVE, BUILD_WOOD, BUILD_FLOOR, PLACE_GRASS, BUILD_STONE, BUILD_IRON_WALL, BUILD_WOODEN_DOOR, BUILD_IRON_DOOR
    }

    public static Job getJob(JobType job, Vector2i mousePos) {
        switch (job) {
            case MOVE:
                return new WalkJob(mousePos);
            case REMOVE:
                return new RemoveJob(mousePos);
            case BUILD_WOOD:
                return new BuildJob(mousePos, new Tree());
            case BUILD_FLOOR:
                return new ChangeTileJob(mousePos, TileType.FLOOR);
            case PLACE_GRASS:
                return new ChangeTileJob(mousePos, TileType.GRASS);
            case BUILD_STONE:
                return new BuildJob(mousePos, new Stone());
            case BUILD_IRON_WALL:
                return new BuildJob(mousePos, new IronWall());
            case BUILD_WOODEN_DOOR:
                return new BuildJob(mousePos, new WoodenDoor(Door.getDirection(mousePos)));
            case BUILD_IRON_DOOR:
                return new BuildJob(mousePos, new IronDoor(Door.getDirection(mousePos)));
            default:
                return null;
        }
    }
}
