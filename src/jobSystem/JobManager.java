package jobSystem;

import java.util.ArrayList;
import java.util.Stack;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import entities.Worker;

public class JobManager {

	private static Stack<Job> jobs = new Stack<>();
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
					if (jobs.get(0).checkRequirements())
						worker.currentJob = jobs.get(0);
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
	}

	public static void removeJob(Job job) {
		jobs.remove(job);
	}

	public static void executeJob(Job job) {
		job.execute();
		removeJob(job);
	}

}
