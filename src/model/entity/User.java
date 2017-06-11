package model.entity;

public class User {
	private Integer id;
	private String name;
	private String surname;
	private String email;
	private String password;
	private int person_group_id;
	
	public User(Integer id, String name, String surname, String email, String password, int person_group_id) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.setPerson_group_id(person_group_id);
	}
	
	public User(String name, String surname, String email, String password, int person_group_id) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.setPerson_group_id(person_group_id);
	}
	
	
	public User() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPerson_group_id() {
		return person_group_id;
	}

	public void setPerson_group_id(int person_group_id) {
		this.person_group_id = person_group_id;
	}
	
	public String toString() {
		//return String.format("User: "+id+ " "+name+" "+ surname+" "+ email+" "+ password);
		return String.format("User: %2d %12s %15s %25s %17s",id, name, surname, email, password);
	}
}