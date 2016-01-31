package jobSystem;

import math.Vector2i;
import resources.ResourceManager;
import world.Tile;
import world.World;

public class RemoveJob extends Job {

    public RemoveJob(Vector2i targetPosition) {
        super(targetPosition);
    }

    public boolean checkRequirements() {
        return World.getTile(targetPosition.x, targetPosition.y).worldObject != null;
    }

    public void onCreated() {

    }

    public void execute() {
        Tile tile = World.getTile(targetPosition.x, targetPosition.y);
        for(String s : tile.worldObject.getResources())
            ResourceManager.addResource(s, 1);
        tile.worldObject = null;
    }

}
