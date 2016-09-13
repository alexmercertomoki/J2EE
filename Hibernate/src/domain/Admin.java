package domain;

/**
 * ��������Ա��
 * @author baogy
 *
 * @since 2008-12-8 ����09:06:22
 * @version 1.00
 */
public class Admin{
	
	private long id;
	
	private String username;
	
	private String password;
	
	public Admin(){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}