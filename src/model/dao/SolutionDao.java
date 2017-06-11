package model.dao;

import java.time.LocalDate;
import java.util.List;

import model.entity.Exercise;
import model.entity.Solution;

public interface SolutionDao {
	
	public List<Solution> loadAll();
	public List<Solution> loadAll(int numOfRows);
	public Solution loadById(int id);
	public void delete(int id);
	public void saveToDB(Solution solution);
	public List<Solution> loadAllByUserId(int user_id);
	public List<Solution> loadAllByExerciseId(int user_id);
	void update(int id, LocalDate created, LocalDate updated, String description, int exercise_id, int users_id);
	public void updateTaskStatus(int exercise_id, int users_id);
}
