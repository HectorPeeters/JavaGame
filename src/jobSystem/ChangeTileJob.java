package jobSystem;

import math.Vector2i;
import world.TileType;
import world.World;

public class ChangeTileJob extends Job {

    private final TileType tileType;

    public ChangeTileJob(Vector2i targetPosition, TileType tileType) {
        super(targetPosition);
        this.tileType = tileType;
    }

    public boolean checkRequirements() {
        return World.isWalkable(targetPosition.x, targetPosition.y) && World.getTile(targetPosition.x, targetPosition.y).tileType != tileType;
    }

    public void onCreated() {

    }

    public void execute() {
        World.getTile(targetPosition.x, targetPosition.y).tileType = tileType;
    }

}
