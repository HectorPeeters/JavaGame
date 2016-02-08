package jobSystem.jobs;

import jobSystem.Job;
import math.Vector2i;
import world.World;

public class WalkJob extends Job {

    public WalkJob(Vector2i targetPosition) {
        super(targetPosition, 0);
    }

    @Override
    public boolean checkRequirements() {
        return World.isWalkable(targetPosition.x, targetPosition.y);
    }

    @Override
    public void onCreated() {
        executePosition = targetPosition;
    }

    @Override
    public void execute() {
    }

}
