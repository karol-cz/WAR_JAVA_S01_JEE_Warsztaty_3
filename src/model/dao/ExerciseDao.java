package model.dao;

import java.util.List;

import model.entity.Exercise;

public interface ExerciseDao {
	
	public List<Exercise> loadAll();
	public Exercise loadById(int id);
	public void delete(int id);
	public void saveToDB(Exercise exercise);
	void update(int id, String title, String description);
	public List<Exercise> loadExWithoutSol(int user_id);
	public List<Integer> loadExIDWithoutSol(int user_id);
}
