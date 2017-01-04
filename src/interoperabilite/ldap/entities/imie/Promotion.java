package interoperabilite.ldap.entities.imie;

import java.util.ArrayList;

public class Promotion {
	private int id;
	private String years;
	private String name;
	private String ou;
	private ArrayList<User> users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public String getOu() {
		return ou;
	}

	public void setOu(String ou) {
		this.ou = ou;
	}

	public Promotion(int id, String years, String name) {
		super();
		this.id = id;
		this.years = years;
		this.name = name;
		this.users = new ArrayList<User>();
	}

	public Promotion() {
		super();
	}
}
