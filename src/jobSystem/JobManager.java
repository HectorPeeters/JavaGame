package jobSystem;

import assets.Images;
import entities.Worker;
import entities.pathfinding.Pathfinder;
import math.Vector2i;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;
import world.Tile;

import java.util.ArrayList;
import java.util.Stack;

public class JobManager {

    public static Stack<Job> jobs = new Stack<>();
    public static ArrayList<Worker> workers = new ArrayList<>();

    public static void addWorker(Worker worker) {
        workers.add(worker);
    }

    public static void addJob(Job job) {
        if (job.checkRequirements())
            if (!isJobAtPosition(job.targetPosition.x, job.targetPosition.y))
                jobs.add(job);
    }

    private static boolean isJobAtPosition(int x, int y) {
        for (Job job : jobs)
            if (job.targetPosition.x == x && job.targetPosition.y == y)
                return true;
        return false;
    }

    public static void update(GameContainer gc, StateBasedGame s, int delta) {
        if (!jobs.isEmpty()) {
            for (Worker worker : workers) {
                if (worker.currentJob == null) {
                    Job current = getClosestJob(worker.position);
                    if (current.checkRequirements()) {
                        if (current.executePosition != null) {
                            worker.setJob(current, Pathfinder.findPath(worker, current.executePosition));
                        } else {
                            jobs.remove(current);
                            jobs.add(current);
                        }
                    }
                }
            }
        }
        updateWorkers(gc, s, delta);
    }

    public static void moveJovBack(Job job) {
        JobManager.jobs.remove(job);
        JobManager.jobs.add(job);
    }

    private static Job getClosestJob(Vector2i pos) {
        Job closest = jobs.get(0);
        for (Job job : jobs) {
            job.executePosition = Job.getExecutePosition(job.targetPosition);
            if (job.executePosition != null && pos != null && closest.executePosition != null && job.checkRequirements())
                if (pos.distance(job.executePosition) < pos.distance(closest.executePosition))
                    closest = job;
        }
        return closest;
    }

    private static void updateWorkers(GameContainer gc, StateBasedGame s, int delta) {
        for (Worker worker : workers)
            worker.update(gc, s, delta);
    }

    public static void render(GameContainer gc, StateBasedGame s, Graphics g) {
        for (Worker worker : workers) {
            worker.render(gc, s, g);
            if (worker.currentJob != null) {
                Vector2i progressPos = worker.currentJob.targetPosition;
                Images.drawImage("inProgress", progressPos.x, progressPos.y);
            }
        }
        for (Job job : jobs)
            Images.drawImage("hourglas", job.targetPosition.x, job.targetPosition.y);
    }

    public static void removeJob(Job job) {
        jobs.remove(job);
    }

    public static void executeJob(Job job) {
        job.execute();
        removeJob(job);
    }

}
