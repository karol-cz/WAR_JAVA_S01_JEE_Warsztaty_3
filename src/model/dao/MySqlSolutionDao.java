package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.entity.Solution;
import model.utils.Utils;

public class MySqlSolutionDao implements SolutionDao {

	private static final String LOAD_ALL_QUERY = "SELECT * FROM solution";
	private static final String LOAD_ALL_WITH_LIMIT_QUERY = "SELECT * FROM solution ORDER BY created LIMIT ?";
	private static final String LOAD_BY_ID_QUERY = "SELECT * FROM solution WHERE id = ?";
	private static final String DELETE_BY_ID_QUERY = "DELETE FROM solution WHERE id = ?";
	private static final String SAVE_TO_DB_QUERY = "INSERT INTO solution(created, updated, description, exercise_id, users_id)"
			+ "VALUES(?, ?, ?, ?, ?)";
	private static final String LOAD_BY_USER_ID_QUERY = "SELECT * FROM solution WHERE users_id = ?";
	private static final String LOAD_BY_EXERCISE_ID_QUERY = "SELECT * FROM solution WHERE exercise_id = ?";
	private static final String UPDATE_SOLUTION_QUERY = "UPDATE solution SET created = ?, updated = ?, description = ?, exercise_id = ?, users_id = ? WHERE id = ?";
	private static final String UPDATE_TASK_STATUS_QUERY = "INSERT INTO solution (created, updated, exercise_id, users_id) VALUES(?, ?, ?, ?)";
	
	private final String jdbcUrl;
	private final String user;
	private final String password;

	public MySqlSolutionDao(String jdbcUrl, String user, String password){
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
	public List<Solution> loadAll() {
		List<Solution> resultList = new ArrayList<>();
		try (Connection connection = createConnection();
				PreparedStatement loadAllStm = connection.prepareStatement(LOAD_ALL_QUERY)) {
			loadAllStm.executeQuery();

			try (ResultSet resultLoadAllStm = loadAllStm.executeQuery()) {
				while (resultLoadAllStm.next()) {
					Solution solution = new Solution();
					solution.setId(resultLoadAllStm.getInt(1));
					solution.setCreated(resultLoadAllStm.getDate(2).toLocalDate());
					Date updated = resultLoadAllStm.getDate(3);
					solution.setUpdated(updated == null ? null : updated.toLocalDate());
					solution.setDescription(resultLoadAllStm.getString(4));
					solution.setExercise_id(resultLoadAllStm.getInt(5));
					solution.setUsers_id(resultLoadAllStm.getInt(6));
					resultList.add(solution);
				}
			}
		} catch (SQLException e) {
			System.out.println("Wczytywanie nie powiodlo się");
		}
		return resultList;
	}
	
	@Override
	public List<Solution> loadAll(int numOfRows) {
		List<Solution> resultList = new ArrayList<>();
		try (Connection connection = createConnection();
				PreparedStatement loadAllStm = connection.prepareStatement(LOAD_ALL_WITH_LIMIT_QUERY)) {
			loadAllStm.setInt(1, numOfRows);
			loadAllStm.executeQuery();

			try (ResultSet resultLoadAllStm = loadAllStm.executeQuery()) {
				while (resultLoadAllStm.next()) {
					Solution solution = new Solution();
					solution.setId(resultLoadAllStm.getInt(1));
					solution.setCreated(resultLoadAllStm.getDate(2).toLocalDate());
					Date updated = resultLoadAllStm.getDate(3);
					solution.setUpdated(updated == null ? null : updated.toLocalDate());
					solution.setDescription(resultLoadAllStm.getString(4));
					solution.setExercise_id(resultLoadAllStm.getInt(5));
					solution.setUsers_id(resultLoadAllStm.getInt(6));
					resultList.add(solution);
				}
			}
		} catch (SQLException e) {
			System.out.println("Wczytywanie nie powiodlo się");
		}
		return resultList;
	}

	@Override
	public Solution loadById(int id) {
		Solution solution = new Solution();
		try (Connection connection = createConnection();
				PreparedStatement loadByIdStm = connection.prepareStatement(LOAD_BY_ID_QUERY)) {
			loadByIdStm.setInt(1, id);
			loadByIdStm.executeQuery();

			try (ResultSet resultLoadById = loadByIdStm.executeQuery()) {
				resultLoadById.next();
				solution.setId(resultLoadById.getInt(1));
				solution.setCreated(resultLoadById.getDate(2).toLocalDate());
				solution.setUpdated(resultLoadById.getDate(3).toLocalDate());
				solution.setDescription(resultLoadById.getString(4));
				solution.setExercise_id(resultLoadById.getInt(5));
				solution.setUsers_id(resultLoadById.getInt(6));
			}
		} catch (SQLException e) {
			System.out.println("Wczytanie solution o id: " + id + " nie powiodlło się");
		}
		return solution;
	}

	@Override
	public void delete(int id) {
		try (Connection connection = createConnection();
				PreparedStatement deleteByIdStm = connection.prepareStatement(DELETE_BY_ID_QUERY)) {
			deleteByIdStm.setInt(1, id);
			deleteByIdStm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Usuwanie exercise o id: " + id + " nie powiodło się");
		}
	}

	@Override
	public void saveToDB(Solution solution) {
		try (Connection connection = createConnection();
				PreparedStatement saveToDBStm = connection.prepareStatement(SAVE_TO_DB_QUERY)) {

			saveToDBStm.setString(1, Utils.localDateToString(solution.getCreated()));
			saveToDBStm.setString(2, Utils.localDateToString(solution.getUpdated()));
			saveToDBStm.setString(3, solution.getDescription());
			saveToDBStm.setInt(4, solution.getExercise_id());
			saveToDBStm.setInt(5, solution.getUsers_id());
			saveToDBStm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Zapisanie nowego cwieczenia do bazy nie powiodło się");
		}
	}

	@Override
	public List<Solution> loadAllByUserId(int user_id) {
		List<Solution> resultList = new ArrayList<>();
	
		try (Connection connection = createConnection();
				PreparedStatement loadByUserIdStm = connection.prepareStatement(LOAD_BY_USER_ID_QUERY)) {
			loadByUserIdStm.setInt(1, user_id);
			loadByUserIdStm.executeQuery();

			try (ResultSet resultLoadByUserId = loadByUserIdStm.executeQuery()) {
				while (resultLoadByUserId.next()) {
					Solution solution = new Solution();
					solution.setId(resultLoadByUserId.getInt(1));
					solution.setCreated(Utils.changeDateToLocalDate(resultLoadByUserId.getDate(2)));
					solution.setUpdated(Utils.changeDateToLocalDate(resultLoadByUserId.getDate(3)));
					solution.setDescription(resultLoadByUserId.getString(4));
					solution.setExercise_id(resultLoadByUserId.getInt(5));
					solution.setUsers_id(resultLoadByUserId.getInt(6));
					resultList.add(solution);
				}
			}
		} catch (SQLException e) {
			System.out.println("Wczytanie solution dla uzytkownika o id: " + user_id + " nie powiodlło się");
		}
		return resultList;
	}
	
	@Override
	public List<Solution> loadAllByExerciseId(int exercise_id) {
		List<Solution> resultList = new ArrayList<>();
		try (Connection connection = createConnection();
				PreparedStatement loadByExerciseIdStm = connection.prepareStatement(LOAD_BY_EXERCISE_ID_QUERY)) {
			loadByExerciseIdStm.setInt(1, exercise_id);
			loadByExerciseIdStm.executeQuery();

			try (ResultSet resultLoadByExerciseId = loadByExerciseIdStm.executeQuery()) {
				while (resultLoadByExerciseId.next()) {
					Solution solution = new Solution();
					solution.setId(resultLoadByExerciseId.getInt(1));
					solution.setCreated(resultLoadByExerciseId.getDate(2).toLocalDate());
					solution.setUpdated(resultLoadByExerciseId.getDate(3).toLocalDate());
					solution.setDescription(resultLoadByExerciseId.getString(4));
					solution.setExercise_id(resultLoadByExerciseId.getInt(5));
					solution.setUsers_id(resultLoadByExerciseId.getInt(6));
					resultList.add(solution);
				}
			}
		} catch (SQLException e) {
			System.out.println("Wczytanie solution dla ćwiczenia o id: " + exercise_id + " nie powiodlło się");
		}
		Collections.sort(resultList);
		
		return resultList;
	}
	
	@Override
	public void update(int id, LocalDate created, LocalDate updated, String description, int exercise_id,
			int users_id) {
		try (Connection connection = createConnection();
				PreparedStatement saveToDBStm = connection.prepareStatement(UPDATE_SOLUTION_QUERY)) {
			
			saveToDBStm.setString(1, Utils.localDateToString(created));
			saveToDBStm.setString(2, Utils.localDateToString(updated));
			saveToDBStm.setString(3, description);
			saveToDBStm.setInt(4, exercise_id);
			saveToDBStm.setInt(5, users_id);
			saveToDBStm.setInt(6, id);
			saveToDBStm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Zapisanie nowego rozwiązania do bazy nie powiodło się");
		}
	}
	
	public void updateTaskStatus(int exercise_id, int users_id) {
		try (Connection connection = createConnection();
				PreparedStatement updateTaskStatusStm = connection.prepareStatement(UPDATE_TASK_STATUS_QUERY)) {
			
			updateTaskStatusStm.setString(1, Utils.localDateToString(LocalDate.now()));
			updateTaskStatusStm.setString(2, Utils.localDateToString(LocalDate.now()));
			updateTaskStatusStm.setInt(3, exercise_id);
			updateTaskStatusStm.setInt(4, users_id);
			updateTaskStatusStm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Zmiana statusu zadania nie powiodło się");
		}
	}
	
	

}
