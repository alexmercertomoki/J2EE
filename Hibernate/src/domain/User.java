package domain;

/**
 * ��������Ա��
 * @author baogy
 *
 * @since 2008-12-8 ����09:06:22
 * @version 1.00
 */
public class User{
	// �û�ID
	private long id;
	
	// ����
	private String name;
	
	// ����
	private int age;
	
	public User(){
		
	}
	
	public String toString(){
		return "�û� ����="+name+" ����="+age;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}