package model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.entity.User;

public class MySqlUserDao implements UserDao {

	private static final String FIND_ALL_USERS = "SELECT * FROM users";
	private static final String INSERT_USER_QUERY = "INSERT INTO users( name, surname, email, password, person_group_id) VALUES (?,?,?,?,?)";
	private static final String UPDATE_USER_QUERY = "UPDATE users SET name = ?, surname = ?, email = ?, password = ?, person_group_id = ? WHERE id = ?";
	private static final String FIND_USER_BY_ID_QUERY = "SELECT * FROM users WHERE id = ?";
	private static final String DELETE_USER_BY_ID_QUERY = "DELETE FROM users WHERE id = ?";
	private static final String FIND_USER_BY_GROUP_QUERY = "SELECT * FROM users WHERE person_group_id = ?";

	private final String jdbcUrl;
	private final String password;
	private final String user;

	public MySqlUserDao(String jdbcUrl, String password, String user) {
		this.jdbcUrl = jdbcUrl;
		this.password = password;
		this.user = user;
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
	public User insert(User user) {
		try (Connection connection = createConnection();
				PreparedStatement insertStm = connection.prepareStatement(INSERT_USER_QUERY,
						PreparedStatement.RETURN_GENERATED_KEYS)) {
			insertStm.setString(1, user.getName());
			insertStm.setString(2, user.getSurname());
			insertStm.setString(3, user.getEmail());
			insertStm.setString(4, user.getPassword());
			insertStm.setInt(5, user.getPerson_group_id());

			int result = insertStm.executeUpdate();
			if (result != 1) {
				throw new RuntimeException("Execute updated returned " + result);
			}
			try (ResultSet generatedKeys = insertStm.getGeneratedKeys()) {
				if (generatedKeys.first()) {
					user.setId(generatedKeys.getInt(1));
					return user;
				} else {
					throw new RuntimeException("Generated key was not found");
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<User> findAll() {
		try (Connection connection = createConnection();
				PreparedStatement findAllUsersStm = connection.prepareStatement(FIND_ALL_USERS);) {
			List<User> allUsers = new ArrayList<User>();
			findAllUsersStm.executeQuery();
			try (ResultSet resultFindAllUsersStm = findAllUsersStm.executeQuery()) {
				while (resultFindAllUsersStm.next()) {

					User user = new User();
					user.setId(resultFindAllUsersStm.getInt(1));
					user.setName(resultFindAllUsersStm.getString(2));
					user.setSurname(resultFindAllUsersStm.getString(3));
					user.setEmail(resultFindAllUsersStm.getString(4));
					user.setPassword(resultFindAllUsersStm.getString(5));
					user.setPerson_group_id(resultFindAllUsersStm.getInt(6));

					allUsers.add(user);
				}
				return allUsers;
			}
		} catch (SQLException e) {
			System.out.println("findAll-Users nie działa poprawnie" + e.getMessage());
		}
		return null;
	}

	// dla solution insert zwraca solution z ustawionym id, i find by id tez
	// zwracac solution

	// update zmienia wszystko oprócz id by me
	// find by id w nastepnym dao
	// zaczad od obiektu solutionn, local day time- skonwerotwa, usera jako
	// obiekt i skozystac
	// z tego dao tylko w urytkowniku napisac find by id (ma zwracac usera)
	// find by id do userDao

	@Override
	public void update(int id, String name, String surname, String email, String password, int person_group_id) {
		try (Connection connection = createConnection();
				PreparedStatement updateStm = connection.prepareStatement(UPDATE_USER_QUERY)) {
			updateStm.setString(1, name);
			updateStm.setString(2, surname);
			updateStm.setString(3, email);
			updateStm.setString(4, password);
			updateStm.setInt(5, person_group_id);
			updateStm.setInt(6, id);
			updateStm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Cos poszło nie tak przy updatowaniu Usera o id " + id + e.getMessage());
		}
	}

	@Override
	public User findById(int id) {
		try (Connection connection = createConnection();
				PreparedStatement findUserByIdStm = connection.prepareStatement(FIND_USER_BY_ID_QUERY);) {
			findUserByIdStm.setInt(1, id);
			findUserByIdStm.executeQuery();
			try (ResultSet resultUserById = findUserByIdStm.executeQuery()) {
				resultUserById.next();

				User user = new User();
				user.setId(resultUserById.getInt(1));
				user.setName(resultUserById.getString(2));
				user.setSurname(resultUserById.getString(3));
				user.setEmail(resultUserById.getString(4));
				user.setPassword(resultUserById.getString(5));
				user.setPerson_group_id(resultUserById.getInt(6));
				return user;
			}
		} catch (SQLException e) {
			System.out.println("findById()-Users nie działa poprawnie" + e.getMessage());
			return null;
		}
	}

	@Override
	public void deleteById(int id) {
		try (Connection connection = createConnection();
				PreparedStatement deleteStm = connection.prepareStatement(DELETE_USER_BY_ID_QUERY)) {
			deleteStm.setInt(1, id);
			deleteStm.executeUpdate();
			System.out.println("Usunięto Użytkownika o id: " + id);
		} catch (SQLException e) {
			System.out.println("Cos poszło nie tak przy usuwaniu Usera o id " + id + e.getMessage());
		}
	}

	@Override
	public List<User> loadAllByGrupId(int person_group_id) {
		try (Connection connection = createConnection();
				PreparedStatement loadAllUsersByGroupStm = connection.prepareStatement(FIND_USER_BY_GROUP_QUERY)) {
			List<User> allUsers = new ArrayList<User>();
			loadAllUsersByGroupStm.setInt(1, person_group_id);
			loadAllUsersByGroupStm.executeQuery();
			try (ResultSet resultloadAllByGroupStm = loadAllUsersByGroupStm.executeQuery()) {
				while (resultloadAllByGroupStm.next()) {
					User user = new User();
					user.setId(resultloadAllByGroupStm.getInt(1));
					user.setName(resultloadAllByGroupStm.getString(2));
					user.setSurname(resultloadAllByGroupStm.getString(3));
					user.setEmail(resultloadAllByGroupStm.getString(4));
					user.setPassword(resultloadAllByGroupStm.getString(5));
					user.setPerson_group_id(resultloadAllByGroupStm.getInt(6));
					allUsers.add(user);
				}
				return allUsers;
			}
		} catch (SQLException e) {
			System.out.println("findAll-Users by group nie działa poprawnie" + e.getMessage());
		}
		return null;
	}


}