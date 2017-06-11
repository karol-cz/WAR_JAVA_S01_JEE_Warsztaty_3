package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Exercise;

public class MySqlExerciseDao implements ExerciseDao{

	private static final String LOAD_ALL_QUERY = "SELECT * FROM exercise";
	private static final String LOAD_BY_ID_QUERY = "SELECT * FROM exercise WHERE id = ?";
	private static final String DELETE_BY_ID_QUERY = "DELETE FROM exercise WHERE ID = ?";
	private static final String SAVE_TO_DB_QUERY = "INSERT INTO exercise(title, description) VALUES(?, ?)";
	private static final String UPDATE_EXERCISE_QUERY = "UPDATE exercise SET title = ?, description = ? WHERE id = ?";
	private static final String LOAD_EX_WITHOUT_SOL_QUERY = "SELECT * FROM exercise WHERE id NOT IN (SELECT exercise_id FROM solution WHERE users_id = ?);";
	private static final String LOAD_EX_ID_WITHOUT_SOL_QUERY = "SELECT id FROM exercise WHERE id NOT IN (SELECT exercise_id FROM solution WHERE users_id = ?);";
	
	private final String jdbcUrl;
	private final String user;
	private final String password;

	public MySqlExerciseDao(String jdbcUrl, String user, String password) {
		this.jdbcUrl = jdbcUrl;
		this.user = user;
		this.password = password;
	}

	private Connection createConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Problem w funkcji createConnection() --> MySqlSolutionDao");
			e.printStackTrace();
		}
		return DriverManager.getConnection(jdbcUrl, user, password);
	}

	@Override
	public List<Exercise> loadAll() {
		try (Connection connection = createConnection();
				PreparedStatement loadAllStm = connection.prepareStatement(LOAD_ALL_QUERY);) {
			loadAllStm.executeQuery();
			List<Exercise> resultList = new ArrayList<Exercise>();
			try (ResultSet resultloadAllStm = loadAllStm.executeQuery()) {
				while (resultloadAllStm.next()) {
					Exercise exercise = new Exercise();
					exercise.setId(resultloadAllStm.getInt(1));
					exercise.setTitle(resultloadAllStm.getString(2));
					exercise.setDescription(resultloadAllStm.getString(3));
					
					resultList.add(exercise);
				}
				return resultList;
			}

		} catch (SQLException e) {
			System.out.println("Załadowanie całej listy elementów: exercise nie powiodło się");
			return null;
		}
	}

	@Override
	public Exercise loadById(int id) {
		try (Connection connectioon = createConnection();
				PreparedStatement loadByIdStm = connectioon.prepareStatement(LOAD_BY_ID_QUERY);) {
			loadByIdStm.setInt(1, id);
			loadByIdStm.executeQuery();
			try (ResultSet resultLoadByIdStm = loadByIdStm.executeQuery()) {
				resultLoadByIdStm.next();
				Exercise exercise = new Exercise();
				exercise.setId(resultLoadByIdStm.getInt(1));
				exercise.setTitle(resultLoadByIdStm.getString(2));
				exercise.setDescription(resultLoadByIdStm.getString(3));

				return exercise;
			}
		} catch (SQLException e) {
			System.out.println("Załadowanie exercise o id: " + id + "nie powiodło się");
			return null;
		}
	}

	@Override
	public void delete(int id) {
		try (Connection connection = createConnection();
				PreparedStatement deleteByIdStm = connection.prepareStatement(DELETE_BY_ID_QUERY);) {
			deleteByIdStm.setInt(1, id);
			deleteByIdStm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Usunięcie exercise o id: " + id + "nie powiodło się");
		}
	}

	@Override
	public void saveToDB(Exercise exercise) {
		try (Connection connection = createConnection();
				PreparedStatement saveToDbStm = connection.prepareStatement(SAVE_TO_DB_QUERY);) {
			saveToDbStm.setString(1, exercise.getTitle());
			saveToDbStm.setString(2, exercise.getDescription());

			saveToDbStm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Dodanie grupy o id: " + exercise.getId() + "nie powiodło się");
			e.printStackTrace();
		} 
	}
	
	@Override
	public void update(int id, String title, String description) {
		try (Connection connection = createConnection();
				PreparedStatement updateStm = connection.prepareStatement(UPDATE_EXERCISE_QUERY)) {
			updateStm.setString(1, title);
			updateStm.setString(2, description);
			updateStm.setInt(3, id);
			updateStm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Cos poszło nie tak przy updatowaniu zadania o id " + id + e.getMessage());
		}
	}
	
	@Override
	public List<Exercise> loadExWithoutSol(int user_id) {
		try (Connection connection = createConnection();
				PreparedStatement loadExWithoutSolStm = connection.prepareStatement(LOAD_EX_WITHOUT_SOL_QUERY)) {
			loadExWithoutSolStm.setInt(1, user_id);
			loadExWithoutSolStm.executeQuery();
			List<Exercise> resultList = new ArrayList<Exercise>();
			try (ResultSet resultloadAllExWithoutSolStm = loadExWithoutSolStm.executeQuery()) {
				while (resultloadAllExWithoutSolStm.next()) {
					Exercise exercise = new Exercise();
					exercise.setId(resultloadAllExWithoutSolStm.getInt(1));
					exercise.setTitle(resultloadAllExWithoutSolStm.getString(2));
					exercise.setDescription(resultloadAllExWithoutSolStm.getString(3));
					
					resultList.add(exercise);
				}
				return resultList;
			}

		} catch (SQLException e) {
			System.out.println("Załadowanie całej listy elementów: exercise bez rozwiązań nie powiodło się");
			return null;
		}
	}
	
	@Override
	public List<Integer> loadExIDWithoutSol(int user_id) {
		try (Connection connection = createConnection();
				PreparedStatement loadExWithoutSolStm = connection.prepareStatement(LOAD_EX_ID_WITHOUT_SOL_QUERY)) {
			loadExWithoutSolStm.setInt(1, user_id);
			loadExWithoutSolStm.executeQuery();
			List<Integer> resultList = new ArrayList<>();
			try (ResultSet resultloadAllExWithoutSolStm = loadExWithoutSolStm.executeQuery()) {
				while (resultloadAllExWithoutSolStm.next()) {
					resultList.add(resultloadAllExWithoutSolStm.getInt(1));
				}
				return resultList;
			}

		} catch (SQLException e) {
			System.out.println("Załadowanie całej listy id elementów: exercise bez rozwiązań nie powiodło się");
			return null;
		}
	}



}