package jobSystem.jobs;

import jobSystem.Job;
import math.Vector2i;
import resources.ResourceManager;
import world.Tile;
import world.World;

public class RemoveJob extends Job {

    public RemoveJob(Vector2i targetPosition) {
        super(targetPosition, getRemoveTime(targetPosition));
    }

    public static int getRemoveTime(Vector2i targetPosition) {
        if (World.getTile(targetPosition.x, targetPosition.y).worldObject != null)
            return World.getTile(targetPosition.x, targetPosition.y).worldObject.destroyTime;
        return 0;
    }

    @Override
    public boolean checkRequirements() {
        return World.getTile(targetPosition.x, targetPosition.y) != null && World.getTile(targetPosition.x, targetPosition.y).worldObject != null;
    }

    @Override
    public void onCreated() {

    }

    @Override
    public void execute() {
        Tile tile = World.getTile(targetPosition.x, targetPosition.y);
        for (String s : tile.worldObject.getResources())
            ResourceManager.addResource(s, 1);
        tile.worldObject = null;
    }

}
