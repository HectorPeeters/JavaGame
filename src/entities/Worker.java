package entities;

import entities.pathfinding.Pathfinder;
import jobSystem.Job;
import jobSystem.JobManager;
import math.Vector2i;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

public class Worker extends Entity {

    public Job currentJob;

    private List<Vector2i> pathToTarget = new ArrayList<>();

    public float speed = 0.25f;

    public Worker(Vector2i position) {
        super(position, "guy");
    }

    public void update(GameContainer gc, StateBasedGame s, int delta) {
        updatePathfinding(delta);
    }

    private int totDelta = 0;

    private void updatePathfinding(int delta) {
        if (totDelta >= speed * 100) {
            if (currentJob != null) {
                if (pathToTarget.isEmpty()) {
                    pathToTarget = Pathfinder.findPath(this, currentJob.executePosition);
                    if (pathToTarget.isEmpty())
                        executeJob();
                } else {
                    position = pathToTarget.get(pathToTarget.size() - 1);
                    pathToTarget.remove(pathToTarget.size() - 1);
                    if (position.equals(currentJob.executePosition)) {
                        executeJob();
                    }
                }
            }
            totDelta = 0;
        }
        totDelta += delta;
    }

    private void executeJob() {
        pathToTarget.clear();
        JobManager.executeJob(currentJob);
        currentJob = null;
    }
}