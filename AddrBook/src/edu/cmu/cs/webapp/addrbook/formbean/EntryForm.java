package edu.cmu.cs.webapp.addrbook.formbean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EntryForm extends IdForm {
    private String additional     = "";
    private String address        = "";
    private String birthday       = "";
    private String cellPhone      = "";
    private String city           = "";
    private String country        = "";
    private String digest         = "";
    private String email          = "";
    private String fax            = "";
    private String firstNames     = "";
    private String homePhone      = "";
    private String lastName       = "";
    private String receivedCards  = "";
    private String sentCards      = "";
    private String spouseBirthday = "";
    private String spouseCell     = "";
    private String spouseEmail    = "";
    private String spouseFirst    = "";
    private String spouseLast     = "";
    private String spouseWork     = "";
    private String state          = "";
    private String workPhone      = "";
    private String zip            = "";
    
    private java.sql.Date birthdayDate       = null;
    private java.sql.Date spouseBirthdayDate = null;
 
    public String getAdditional()        { return additional;     }
    public String getAddress()           { return address;        }
    public String getBirthday()          { return birthday;       }
    public String getCellPhone()         { return cellPhone;      }
    public String getCity()              { return city;           }
    public String getCountry()           { return country;        }
    public String getDigest()            { return digest;         }
    public String getEmail()             { return email;          }
    public String getFax()               { return fax;            }
    public String getFirstNames()        { return firstNames;     }
    public String getHomePhone()         { return homePhone;      }
    public String getLastName()          { return lastName;       }
    public String getReceivedCards()     { return receivedCards;  }
    public String getSentCards()         { return sentCards;      }
    public String getSpouseBirthday()    { return spouseBirthday; }
    public String getSpouseCell()        { return spouseCell;     }
    public String getSpouseEmail()       { return spouseEmail;    }
    public String getSpouseFirst()       { return spouseFirst;    }
    public String getSpouseLast()        { return spouseLast;     }
    public String getSpouseWork()        { return spouseWork;     }
    public String getState()             { return state;          }
    public String getWorkPhone()         { return workPhone;      }
    public String getZip()               { return zip;            }
    
    public java.sql.Date getBirthdayAsDate()       { return birthdayDate;       }
    public java.sql.Date getSpouseBirthdayAsDate() { return spouseBirthdayDate; }

    public void setAdditional(String s)     { additional     = trimAndConvert(s,"<>\""); }
    public void setAddress(String s)        { address        = trimAndConvert(s,"<>\""); }
    public void setBirthday(String s)       { birthday       = trimAndConvert(s,"<>\""); }
    public void setCellPhone(String s)      { cellPhone      = trimAndConvert(s,"<>\""); }
    public void setCity(String s)           { city           = trimAndConvert(s,"<>\""); }
    public void setCountry(String s)        { country        = trimAndConvert(s,"<>\""); }
    public void setDigest(String s)         { digest         = trimAndConvert(s,"<>\""); }
    public void setEmail(String s)          { email          = trimAndConvert(s,"<>\""); }
    public void setFax(String s)            { fax            = trimAndConvert(s,"<>\""); }
    public void setFirstNames(String s)     { firstNames     = trimAndConvert(s,"<>\""); }
    public void setHomePhone(String s)      { homePhone      = trimAndConvert(s,"<>\""); }
    public void setLastName(String s)       { lastName       = trimAndConvert(s,"<>\""); }
    public void setReceivedCards(String s)  { receivedCards  = trimAndConvert(s,"<>\""); }
    public void setSentCards(String s)      { sentCards      = trimAndConvert(s,"<>\""); }
    public void setSpouseBirthday(String s) { spouseBirthday = trimAndConvert(s,"<>\""); }
    public void setSpouseCell(String s)     { spouseCell     = trimAndConvert(s,"<>\""); }
    public void setSpouseEmail(String s)    { spouseEmail    = trimAndConvert(s,"<>\""); }
    public void setSpouseFirst(String s)    { spouseFirst    = trimAndConvert(s,"<>\""); }
    public void setSpouseLast(String s)     { spouseLast     = trimAndConvert(s,"<>\""); }
    public void setSpouseWork(String s)     { spouseWork     = trimAndConvert(s,"<>\""); }
    public void setState(String s)          { state          = trimAndConvert(s,"<>\""); }
    public void setWorkPhone(String s)      { workPhone      = trimAndConvert(s,"<>\""); }
    public void setZip(String s)            { zip            = trimAndConvert(s,"<>\""); }

	public List<String> getValidationErrors() {
		List<String> errors = super.getValidationErrors();
		
		if (lastName.length() == 0) {
			errors.add("Last Name field is required");
		}
		
		if (firstNames.length() == 0) {
			errors.add("First Names field is required");
		}
		
		if (spouseLast.length() > 0 && spouseFirst.length() == 0) {
			errors.add("Spouse's First Name is required (if Spouse's Last Name is not empty)");
		}

		if (spouseFirst.length() > 0 && spouseLast.length() == 0) {
			errors.add("Spouse's Last Name is required (if Spouse's First Name is not empty)");
		}

		if (getIdNum() > 0 && digest.length() == 0) {
			errors.add("Digest is missing");
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
		
		try {
			if (birthday.length() > 0) {
				Date d = sdf.parse(birthday);
				birthdayDate = new java.sql.Date(d.getTime());
			}
		} catch (ParseException e) {
			errors.add("Birthday has invalid format (use mm/dd/yyyy)");
		}
		
		try {
			if (spouseBirthday.length() > 0) {
				Date d = sdf.parse(spouseBirthday);
				spouseBirthdayDate = new java.sql.Date(d.getTime());
			}
		} catch (ParseException e) {
			errors.add("Spouse Birthday has invalid format (use mm/dd/yyyy)");
		}
		
		return errors;
	}
}
