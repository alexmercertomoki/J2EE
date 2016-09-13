package main;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import domain.Admin;
import domain.Company;
import domain.Employee;
import domain.User;

public class Main{
	
	public static void main(String[] args){
//		searchAdmin();
//		insertAdmin();
		insertUser();
//		insertEmp();
//		updateUser();
//		loadEmp();
//		loadEmpInnerJoin();
//		loadEmpLeftJoin();
//		loadEmpRightJoin();
//		loadProcTab();
		//loadAllEmp();
		
		//updateEmp();
		
		//deleteEmp();
//  Provided id of the wrong type. Expected: 
//		class java.lang.Long, 
//		got class java.lang.Integer
		
	}
	
	// �����ݿ����һ��Employee����
	private static void insertAdmin(){
		Session session=HibernateUtil.getSession();
		Transaction ts=session.beginTransaction();

		Admin admin = new Admin();
		admin.setUsername("admin");
		admin.setPassword("123");
		
		session.save(admin);
		
		Admin admin2 = (Admin)session.load(Admin.class, new Long(1));
		admin2.setPassword("4444");
		
		session.update(admin2);
		session.flush();
        
		ts.commit();
        HibernateUtil.closeSession(session);
	}
	
	// �����ݿ����һ��Employee����
	private static void searchAdmin(){
		Session session=HibernateUtil.getSession();
		Transaction ts=session.beginTransaction();

		List<Admin> list = (List<Admin>)session.createQuery("from Admin").list();
//		List<Admin> list = (List<Admin>)session.createQuery("select a from Admin a").list();
		for(Admin e : list){
			System.out.println(e);
		}
		ts.commit();
        HibernateUtil.closeSession(session);
	}
	
	
	// �����ݿ����һ��Employee����
	private static void insertUser(){
		Session session=HibernateUtil.getSession();
		Transaction ts=session.beginTransaction();
		// ����
//		User user=new User();		
//		user.setName("admin");
//		user.setAge(30);
//		
//		session.save(user);
//		session.flush();
        
		ts.commit();
        HibernateUtil.closeSession(session);
	}
	
	
	// �����ݿ����һ��Employee����
	private static void updateUser(){
		Session session=HibernateUtil.getSession();
		Transaction ts=session.beginTransaction();

		User user = (User)session.load(User.class, 1L);
		user.setAge(50);
		
		session.update(user);
		
		session.flush();
        
		ts.commit();
        HibernateUtil.closeSession(session);
	}
	
	//	 ɾ��һ��User����
	private static void deleteUser(){
		Session session=HibernateUtil.getSession();
		Transaction ts=session.beginTransaction();

		// ��һ�ַ�ʽ
		User user = (User)session.load(User.class, 1L);
		if(user!=null){
			session.delete(user);		
		}
		
		// �ڶ��ַ�ʽ
//		User user2 = new User();
//		user2.setId(1L);
//		session.delete(user2);
		
		session.flush();
        
		ts.commit();
        HibernateUtil.closeSession(session);
	}
	
	
	/**
	 * HQL��������
	 *
	 */
	private static void loadUser(){
		Session session=HibernateUtil.getSession();
		Transaction ts=session.beginTransaction();

		// from User
		// select * from ssh_user
		
		// select * from ssh_user where id='2'
		// from User where id='2'
		
		
		List<User> list = (List<User>)session.createQuery("from User");
		for(User user : list){
			System.out.println(user);
		}
		ts.commit();
        HibernateUtil.closeSession(session);
	}
	
	// �����ݿ����һ��Employee����
	private static void insertEmp(){
		Session session=HibernateUtil.getSession();
		Transaction ts=session.beginTransaction();

		Company company=new Company("MicroSoft");		
		Employee andy=new Employee("Andy",28,"��");
		andy.setCompany(company);
		
		Employee bill=new Employee("bill",38,"Ů");
		bill.setCompany(company);
		
		session.save(andy);
		session.save(bill);
		session.save(company);
		session.flush();
        
		ts.commit();
        HibernateUtil.closeSession(session);
	}
	
	// ��ID�ӱ��л�ȡһ������
	private static void loadEmp(){
		Session session=HibernateUtil.getSession();
		Transaction ts=session.beginTransaction();

		// ע�����IDҪ�ڱ��д���
		Employee andy=(Employee)session.load(Employee.class, new Long(1));
		System.out.println(andy);
		
		// ע�����IDҪ�ڱ��д���
		Employee bill=(Employee)session.load(Employee.class, new Long(2));
		System.out.println(bill);
        
		ts.commit();
        HibernateUtil.closeSession(session);
	}
	
	/**
	 * HQL������
	 *
	 */
	private static void loadEmpInnerJoin(){
		Session session=HibernateUtil.getSession();
		Transaction ts=session.beginTransaction();

		List<Employee> emps=(List<Employee>)session.createQuery("select e from Employee e inner join e.company").list();
		for(Employee e : emps){
			System.out.println(e);
		}
		
		ts.commit();
        HibernateUtil.closeSession(session);
	}
	
	/**
	 * HQL��������
	 *
	 */
	private static void loadEmpLeftJoin(){
		Session session=HibernateUtil.getSession();
		Transaction ts=session.beginTransaction();

		List<Employee> emps = (List<Employee>)session.createQuery("select e from Employee e left outer join e.company").list();
		for(Employee e : emps){
			System.out.println(e);
		}
		
		ts.commit();
        HibernateUtil.closeSession(session);
	}
	
	/**
	 * HQL��������
	 *
	 */
	private static void loadEmpRightJoin(){
		Session session=HibernateUtil.getSession();
		Transaction ts=session.beginTransaction();

		List<Employee> emps = (List<Employee>)session.createQuery("select e from Employee e right outer join e.company").list();
		for(Employee e : emps){
			System.out.println(e);
		}
		
		ts.commit();
        HibernateUtil.closeSession(session);
	}
	
	/**
	 * HQL�������ӵ��ô洢����
	 *
	 */
	private static void loadProcTab(){
		Session session=HibernateUtil.getSession();
		Transaction ts=session.beginTransaction();
		
//		// ��ͳ����xml�ļ���ָ��SQL���Ʒ�ʽ����
//		List list = session.getNamedQuery("getUser").list();
//		
//		for(Object obj : list){
//			System.out.println(obj);
//		}
		
//		 ͨ��Hibernate��createSQLQuery��ʵ��
		SQLQuery query = session.createSQLQuery("{Call proc()}");  
		List list =query.list();  
		
		for(Object obj : list){
			System.out.println(obj);
		}
		
		ts.commit();
        HibernateUtil.closeSession(session);
	}
	
	
	
	// �������еĹ�Ա
	private static void loadAllEmp(){
		Session session=HibernateUtil.getSession();

		List<Employee> emps = (List<Employee>)session.createQuery("from Employee").list();
		
		for(Employee emp:emps){
			System.out.println(emp);
		}
        
        HibernateUtil.closeSession(session);
	}
	
	// ����һ������
	private static void updateEmp(){
		Session session=HibernateUtil.getSession();
		Transaction ts=session.beginTransaction();

		// ע�����IDҪ�ڱ��д���
		Employee andy=(Employee)session.load(Employee.class, new Long(1));
		andy.setAge(48);
		
		Company microsoft=new Company("microsoft");
		andy.setCompany(microsoft);
		
		session.save(microsoft);
		session.update(andy);
        
		ts.commit();
        HibernateUtil.closeSession(session);
	}
	
	// ɾ��һ������
	private static void deleteEmp(){
		Session session=HibernateUtil.getSession();
		Transaction ts=session.beginTransaction();
		
		Employee andy=(Employee)session.load(Employee.class, new Long(1));
		session.delete(andy);
        
		ts.commit();
        HibernateUtil.closeSession(session);
	}
}