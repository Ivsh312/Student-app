package by.liba.student.common;

public class Users {
	private String user;
	private String password;
	private String Role;

	public String getUser() {
		return user;
	}

	public Users(String user, String password, String role) {
		super();
		this.user = user;
		this.password = password;
		Role = role;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

}
