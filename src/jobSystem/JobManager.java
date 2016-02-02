package jobSystem;

import assets.Images;
import entities.Worker;
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
        if (job.checkRequirements()) {
            jobs.add(job);
        }
    }

    public static void update(GameContainer gc, StateBasedGame s, int delta) {
        if (!jobs.isEmpty()) {
            for (Worker worker : workers) {
                if (worker.currentJob == null) {
                    Job current = jobs.get(0);
                    if (current.checkRequirements()&& current.executePosition != null) {
                        if(!current.inProgress) {
                            worker.currentJob = current;
                            current.inProgress = true;
                        }
                    }
                    else
                        jobs.remove(0);
                }
            }
        }
        updateWorkers(gc, s, delta);
    }

    private static void updateWorkers(GameContainer gc, StateBasedGame s, int delta) {
        for (Worker worker : workers)
            worker.update(gc, s, delta);
    }

    public static void render(GameContainer gc, StateBasedGame s, Graphics g) {
        for (Worker worker : workers)
            worker.render(gc, s, g);
        for(Job job : jobs)
            Images.getImage("hourglas").draw(job.targetPosition.x * Tile.TILE_SIZE, job.targetPosition.y * Tile.TILE_SIZE);
    }

    private static void removeJob(Job job) {
        jobs.remove(job);
    }

    public static void executeJob(Job job) {
        job.execute();
        removeJob(job);
    }

}
