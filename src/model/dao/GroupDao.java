package model.dao;

import java.util.List;

import model.entity.Group;

public interface GroupDao {
	public List<Group> loadAll();
	public Group loadById(int id);
	public void delete(int id);
	public void saveToDB(Group group);
	void update(int id, String name);
}
