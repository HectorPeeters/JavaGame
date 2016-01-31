package entities.pathfinding;

import entities.Entity;
import math.Vector2i;
import world.World;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pathfinder {

    private static Comparator<Node> nodeSorter = new Comparator<Node>() {
        public int compare(Node n0, Node n1) {
            if (n1.fCost < n0.fCost)
                return +1;
            if (n1.fCost > n0.fCost)
                return -1;
            return 0;
        }
    };

    public static List<Vector2i> findPath(Entity entity, Vector2i target) {
        return findPath(entity.position, target);
    }

    public static List<Vector2i> findPath(Vector2i start, Vector2i target) {
        if (!World.isWalkable(target.x, target.y))
            return new ArrayList<>();
        List<Node> openList = new ArrayList<>();
        List<Node> closedList = new ArrayList<>();
        Node current = new Node(start, null, 0, start.distance(target));
        openList.add(current);
        while (openList.size() > 0) {
            Collections.sort(openList, nodeSorter);
            current = openList.get(0);
            if (current.position.equals(target)) {
                List<Vector2i> path = new ArrayList<>();
                while (current.parent != null) {
                    path.add(current.position);
                    current = current.parent;
                }
                openList.clear();
                closedList.clear();
                return path;
            }
            openList.remove(current);
            closedList.add(current);
            for (int i = 0; i < 9; i++) {
                if (i == 4 || i == 0 || i == 2 || i == 6 || i == 8)
                    continue;
                int x = current.position.x;
                int y = current.position.y;
                int xi = (i % 3) - 1;
                int yi = (i / 3) - 1;
                if (!World.isWalkable(x + xi, y + yi))
                    continue;
                Vector2i a = new Vector2i(x + xi, y + yi);
                double gCost = current.gCost + current.position.distance(a);
                double hCost = a.distance(target);
                Node node = new Node(a, current, gCost, hCost);
                if (vecInList(closedList, a) && gCost >= node.gCost)
                    continue;
                if (!vecInList(openList, a) || gCost < node.gCost) {
                    openList.add(node);
                }
            }
        }
        closedList.clear();
        return new ArrayList<>();
    }

    private static boolean vecInList(List<Node> list, Vector2i vector) {
        for (Node node : list)
            if (node.position.equals(vector))
                return true;
        return false;
    }

}
