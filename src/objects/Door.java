package objects;

import math.Vector2i;
import world.World;

public class Door extends WorldObject {

    public Door(Direction direction) {
        super(getCorrectSprite(direction), true, false);
    }

    private static String getCorrectSprite(Direction direction) {
        if (direction.equals(Direction.NORTH) || direction.equals(Direction.SOUTH))
            return "doorNS";
        return "doorWE";
    }

    public String[] getResources() {
        return new String[] {"Tree", "Stone"};
    }

    public static Direction getDirection(Vector2i pos) {
        if (!World.isWalkable(pos.x, pos.y - 1))
            return Direction.NORTH;
        if (!World.isWalkable(pos.x + 1, pos.y))
            return Direction.EAST;
        if (!World.isWalkable(pos.x, pos.y - 1))
            return Direction.SOUTH;
        if (!World.isWalkable(pos.x - 1, pos.y))
            return Direction.WEST;
        return Direction.NORTH;
    }

}
