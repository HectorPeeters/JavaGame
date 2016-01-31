package jobSystem;

import math.Vector2i;
import world.World;

public class WalkJob extends Job {

    public WalkJob(Vector2i targetPosition) {
        super(targetPosition);
    }

    public boolean checkRequirements() {
        return World.isWalkable(targetPosition.x, targetPosition.y);
    }

    public void onCreated() {
        executePosition = targetPosition;
    }

    public void execute() {

    }

}
