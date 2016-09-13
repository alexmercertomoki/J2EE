package domain;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * �������--��˾��
 * @author baogy
 *
 * @since 2008-12-8 ����10:33:18
 * @version 1.00
 */
public class Company{
	
	private long id;
	
	private String name;
	
	private Set<Employee> emps=new LinkedHashSet<Employee>();
	
	public Company(){
		
	}
	
	public Company(String name){
		this.name=name;
	}

	public String toString(){
		return " id="+id+" Name="+name;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMsn() {
		return name;
	}

	public void setMsn(String msn) {
		this.name = msn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Employee> getEmps() {
		return emps;
	}

	public void setEmps(Set<Employee> emps) {
		this.emps = emps;
	}
}