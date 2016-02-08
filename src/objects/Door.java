package objects;

import math.Vector2i;
import objects.templates.WorldObject;
import world.World;

public abstract class Door extends WorldObject {

    public Door(String NS, String EW, Direction direction, int destoryTime) {
        super(getCorrectSprite(NS, EW, direction), true, false, destoryTime);

    }

    private static String getCorrectSprite(String NS, String EW, Direction direction) {
        if (direction.equals(Direction.NORTH) || direction.equals(Direction.SOUTH))
            return NS;
        return EW;
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
