package domain;

/**
 * ��������Ա��
 * @author baogy
 *
 * @since 2008-12-8 ����09:06:22
 * @version 1.00
 */
public class Employee{
	// ��ԱID
	private long id;
	
	// ����
	private String name;
	
	// ����
	private int age;
	
	// �Ա�
	private String sex;
	
	// ��Ա���ڵĹ�˾
	private Company company;
	
	public Employee(){
		
	}
	
	public Employee(String name,int age,String sex){
		this.name=name;
		this.age=age;
		this.sex=sex;
	}
	
	public String toString(){
		return "��Ա ����="+name+" ����="+age+" �Ա�="+sex+" ID="+id+" ��˾="+company;
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


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}