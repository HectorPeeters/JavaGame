package jobSystem.jobs;

import jobSystem.Job;
import math.Vector2i;
import objects.templates.WorldObject;
import resources.ResourceManager;
import world.World;

public class BuildJob extends Job {

    private final WorldObject worldObject;

    public BuildJob(Vector2i targetPosition, WorldObject worldObject) {
        super(targetPosition, worldObject.destroyTime);
        this.worldObject = worldObject;
    }

    @Override
    public boolean checkRequirements() {
        if (World.getTile(targetPosition.x, targetPosition.y).worldObject != null)
            return false;
        for (String s : worldObject.getResources())
            if (!ResourceManager.contains(s))
                return false;
        return true;
    }

    @Override
    public void onCreated() {

    }

    @Override
    public void execute() {
        for (String s : worldObject.getResources())
            ResourceManager.addResource(s, -1);
        World.getTile(targetPosition.x, targetPosition.y).setWorldObject(worldObject);
    }

}
