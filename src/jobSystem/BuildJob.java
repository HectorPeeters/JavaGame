package jobSystem;

import math.Vector2i;
import objects.WorldObject;
import resources.ResourceManager;
import world.World;

import javax.annotation.Resource;
import java.util.Map;

public class BuildJob extends Job {

    private final WorldObject worldObject;

    public BuildJob(Vector2i targetPosition, WorldObject worldObject) {
        super(targetPosition);
        this.worldObject = worldObject;
    }

    public boolean checkRequirements() {
        if(World.getTile(targetPosition.x, targetPosition.y).worldObject != null) return false;
        for(String s : worldObject.getResources()) {
            if (!ResourceManager.contains(s)) {
                return false;
            }
        }
        return true;
    }

    public void onCreated() {

    }

    public void execute() {
        for(String s : worldObject.getResources())
            ResourceManager.addResource(s, -1);
        World.getTile(targetPosition.x, targetPosition.y).setWorldObject(worldObject);
    }

}
