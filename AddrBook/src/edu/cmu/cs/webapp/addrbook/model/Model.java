package edu.cmu.cs.webapp.addrbook.model;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;


public class Model {
	private LogDAO    logDAO;
	private EntryDAO  entryDAO;
	private UserDAO   userDAO;

	private boolean requireSSL;

	public Model(ServletConfig config) throws ServletException {
        requireSSL     = new Boolean(config.getInitParameter("requireSSL"));       

		String jdbcDriver = config.getInitParameter("jdbcDriverName");
	    String jdbcURL    = config.getInitParameter("jdbcURL");
	    
	    try {
		    ConnectionPool pool = new ConnectionPool(jdbcDriver, jdbcURL);
	
	    	userDAO  = new UserDAO(pool);
	    	entryDAO = new EntryDAO(pool);
	    	logDAO   = new LogDAO(pool);
	    } catch (DAOException e) {
	    	throw new ServletException(e);
	    }
	}
	
	public EntryDAO  getEntryDAO()       { return entryDAO;       }
	public LogDAO    getLogDAO()         { return logDAO;         }
	public boolean   getRequireSSL()     { return requireSSL;     }
	public UserDAO   getUserDAO()        { return userDAO;        }
}
