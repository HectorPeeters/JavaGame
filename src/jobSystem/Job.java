package jobSystem;

import math.Vector2i;
import world.World;

public abstract class Job {

    //tile of block
    public Vector2i targetPosition;
    //tile of player
    public Vector2i executePosition;

    public boolean inProgress = false;

    public Job(Vector2i targetPosition) {
        this.targetPosition = targetPosition;
        this.executePosition = getExecutePosition(targetPosition);
    }

    public abstract boolean checkRequirements();

    public abstract void onCreated();

    public abstract void execute();

    private static Vector2i getExecutePosition(Vector2i pos) {
        if (World.isWalkable(pos.x, pos.y - 1))
            return new Vector2i(pos.x, pos.y - 1);
        if (World.isWalkable(pos.x + 1, pos.y))
            return new Vector2i(pos.x + 1, pos.y);
        if (World.isWalkable(pos.x, pos.y + 1))
            return new Vector2i(pos.x, pos.y + 1);
        if (World.isWalkable(pos.x - 1, pos.y))
            return new Vector2i(pos.x - 1, pos.y);
        return null;
    }

}
