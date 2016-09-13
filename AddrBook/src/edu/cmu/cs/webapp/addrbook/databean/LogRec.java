package edu.cmu.cs.webapp.addrbook.databean;

import java.util.Date;

import org.genericdao.PrimaryKey;

@PrimaryKey("recNo")
public class LogRec {
	private int    recNo;
	private Date   time;
	private String ipAddr;
	private String text;
	private String userName;
	
	public String getIpAddr()         { return ipAddr;   }
	public int    getRecNo()          { return recNo;    }
	public String getText()           { return text;     }
	public Date   getTime()           { return time;     }
	public String getUserName()       { return userName; }
	
	public void setIpAddr(String x)   { ipAddr   = x; }
	public void setRecNo(int i)       { recNo    = i; }
	public void setText(String x)     { text     = x; } 
	public void setTime(Date d)       { time     = d; }
	public void setUserName(String x) { userName = x; }
}
