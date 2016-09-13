package util;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Hiberbateʵ�ù�����
 * @author: baogy
 * @date: 2008-2-17
 */


public class HibernateUtil {
	static Logger logger = Logger.getLogger(HibernateUtil.class);
	
	private static final SessionFactory sessionFactory;

	/**
	 * ��ʼ��sessionFactory
	 */
	static {
		try {
			// ��hibernate.cfg.xml����SessionFactory 
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
		} catch (Throwable ex) {
			logger.fatal("���ܴ���SessionFactory����Ϊ" + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * ȡ��Session
	 * @return
	 */
	public static Session getSession(){
		Session session=null;
		
		try{
			session=sessionFactory.openSession();
		}
		catch(HibernateException e){
			e.printStackTrace();
			logger.fatal("���ܵõ�Session����Ϊ" + e.getMessage());
		}
		
		return session;
	}

	/**
	 * �ر�Session
	 * @param session
	 */
	public static void closeSession(Session session){
		try{
			session.close();
		}
		catch(HibernateException e){
			e.printStackTrace();
			logger.fatal("���ܹر�Session����Ϊ" + e.getMessage());
		}
	}
}