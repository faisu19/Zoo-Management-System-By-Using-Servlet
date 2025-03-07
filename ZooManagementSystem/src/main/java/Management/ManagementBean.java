package Management;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ManagementBean implements Serializable
{
   private String email;
   private String password;

	public ManagementBean() {}

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
}
