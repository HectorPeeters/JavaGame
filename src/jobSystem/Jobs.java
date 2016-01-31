package jobSystem;

import math.Vector2i;
import objects.Door;
import objects.Stone;
import objects.Tree;

public class Jobs {

    public enum JobType {
        WALK, REMOVE, BUILD_WOOD, BUILD_STONE, BUILD_DOOR
    }

    public static Job getJob(JobType job, Vector2i mousePos) {
        switch (job) {
            case WALK:
                return new WalkJob(mousePos);
            case REMOVE:
                return new RemoveJob(mousePos);
            case BUILD_WOOD:
                return new BuildJob(mousePos, new Tree());
            case BUILD_STONE:
                return new BuildJob(mousePos, new Stone());
            case BUILD_DOOR:
                return new BuildJob(mousePos, new Door(Door.getDirection(mousePos)));
            default:
                return null;
        }
    }
}
