package model.dao;

import java.util.List;

import model.entity.User;

public interface UserDao {
	
	public User insert(User user);
	public void update(int id, String name, String surname, String email, String password, int person_group_id);
	public List<User> findAll();
	public User findById(int id);
	public void deleteById(int id);
	public List<User> loadAllByGrupId(int person_group_id);
}
