package entities;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import jobSystem.Job;
import jobSystem.JobManager;
import math.Vector2i;

public class Worker extends Entity {

	public Job currentJob;

	private List<Vector2i> pathToTarget = new ArrayList<>();

	public float speed = 0.0001f;

	public Worker(Vector2i position) {
		super(position, "guy");
	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) {
		updateJob(gc, s, delta);
	}

	private int totDelta = 0;

	private void updateJob(GameContainer gc, StateBasedGame s, int delta) {
		if (totDelta >= speed * 100) {
			if (currentJob != null)
				if (currentJob.executePosition != null)
					if (pathToTarget.isEmpty()) {
						if (currentJob.executeTime <= 0) {
							if (!tryExecuteJob()) {
								JobManager.moveJovBack(currentJob);
								currentJob = null;
							}
						} else
							currentJob.executeTime -= delta;
					} else {
						position = pathToTarget.get(pathToTarget.size() - 1);
						pathToTarget.remove(pathToTarget.size() - 1);
					}
			totDelta = 0;
		}
		totDelta += delta;
	}

	private boolean tryExecuteJob() {
		if (position.equals(currentJob.executePosition)) {
			executeJob();
			return true;
		}
		return false;
	}

	public void setJob(Job job, List<Vector2i> path) {
		currentJob = job;
		pathToTarget = path;
	}

	private void executeJob() {
		pathToTarget.clear();
		JobManager.executeJob(currentJob);
		currentJob = null;
	}
}