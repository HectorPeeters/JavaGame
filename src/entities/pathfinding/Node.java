package entities.pathfinding;

import math.Vector2i;

public class Node {

    public Vector2i position;
    public Node parent;
    public double fCost, gCost, hCost;

    public Node(Vector2i tile, Node parent, double gCost, double hCost) {
        this.position = tile;
        this.parent = parent;
        this.gCost = gCost;
        this.hCost = hCost;
        this.fCost = this.gCost + this.hCost;
    }

}
