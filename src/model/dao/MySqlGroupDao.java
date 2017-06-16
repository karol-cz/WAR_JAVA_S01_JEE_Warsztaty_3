package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Group;

public class MySqlGroupDao implements GroupDao {

	private static final String LOAD_ALL_GROUPS_QUERY = "SELECT * FROM user_group";
	private static final String LOAD_BY_ID_QUERY = "SELECT * FROM user_group WHERE id = ?";
	private static final String DELETE_BY_ID_QUERY = "DELETE FROM user_group WHERE ID = ?";
	private static final String SAVE_TO_DB_QUERY = "INSERT INTO user_group(name) VALUES(?)";
	private static final String UPDATE_GROUP_QUERY = "UPDATE user_group SET name = ? WHERE id = ?"; 
	
	private final String jdbcUrl;
	private final String user;
	private final String password;

	public MySqlGroupDao(String jdbcUrl, String user, String password) {
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
	public List<Group> loadAll() {
		try (Connection connection = createConnection();
				PreparedStatement loadAllStm = connection.prepareStatement(LOAD_ALL_GROUPS_QUERY);) {
			loadAllStm.executeQuery();
			List<Group> resultList = new ArrayList<Group>();
			try (ResultSet resultloadAllStm = loadAllStm.executeQuery()) {
				while (resultloadAllStm.next()) {
					Group group = new Group();
					group.setId(resultloadAllStm.getInt(1));
					group.setName(resultloadAllStm.getString(2));

					resultList.add(group);
				}
				return resultList;
			}

		} catch (SQLException e) {
			System.out.println("Załadowanie całej tabeli: user_group nie powiodło się");
			return null;
		}
	}

	@Override
	public Group loadById(int id) {
		try (Connection connectioon = createConnection();
				PreparedStatement loadByIdStm = connectioon.prepareStatement(LOAD_BY_ID_QUERY);) {
			loadByIdStm.setInt(1, id);
			loadByIdStm.executeQuery();
			try (ResultSet resultLoadByIdStm = loadByIdStm.executeQuery()) {
				resultLoadByIdStm.next();
				Group group = new Group();
				group.setId(resultLoadByIdStm.getInt(1));
				group.setName(resultLoadByIdStm.getString(2));

				return group;
			}
		} catch (SQLException e) {
			System.out.println("Załadowanie grupy o id: " + id + "nie powiodło się");
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
			System.out.println("Usunięcie grupy o id: " + id + "nie powiodło się");
		}
	}

	@Override
	public void saveToDB(Group group) {
		try (Connection connection = createConnection();
				PreparedStatement saveToDbStm = connection.prepareStatement(SAVE_TO_DB_QUERY);) {
			//saveToDbStm.setInt(1, group.getId());
			saveToDbStm.setString(1, group.getName());

			saveToDbStm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Dodanie grupy o id: " + group.getId() + "nie powiodło się");
			e.printStackTrace();
		} 
	}

	@Override
	public void update(int id, String name) {
		try (Connection connection = createConnection();
				PreparedStatement updateStm = connection.prepareStatement(UPDATE_GROUP_QUERY)) {
			updateStm.setString(1, name);
			updateStm.setInt(2, id);
			updateStm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Cos poszło nie tak przy updatowaniu grupy o id " + id + e.getMessage());
		}
		
	}
}
