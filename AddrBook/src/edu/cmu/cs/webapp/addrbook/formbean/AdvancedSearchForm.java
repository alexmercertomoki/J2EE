package edu.cmu.cs.webapp.addrbook.formbean;

import java.util.Collections;
import java.util.List;

import org.mybeans.form.FormBean;

public class AdvancedSearchForm extends FormBean {
    private String lastName       = "";
    private String firstName      = "";
    private String anyPhone       = "";
    private String email          = "";
    private String additional     = "";
    private String address        = "";
    private String city           = "";
    private String state          = "";
    private String country        = "";
    private String zip            = "";
    private String receivedCards  = "";
    private String sentCards      = "";
    
    public String getAdditional()        { return additional;     }
    public String getAddress()           { return address;        }
    public String getAnyPhone()          { return anyPhone;       }
    public String getCity()              { return city;           }
    public String getCountry()           { return country;        }
    public String getEmail()             { return email;          }
    public String getFirstName()         { return firstName;      }
    public String getLastName()          { return lastName;       }
    public String getReceivedCards()     { return receivedCards;  }
    public String getSentCards()         { return sentCards;      }
    public String getState()             { return state;          }
    public String getZip()               { return zip;            }
    
    public void setAdditional(String s)     { additional     = s.trim(); }
    public void setAddress(String s)        { address        = s.trim(); }
    public void setAnyPhone(String s)       { anyPhone       = s.trim(); }
    public void setCity(String s)           { city           = s.trim(); }
    public void setCountry(String s)        { country        = s.trim(); }
    public void setEmail(String s)          { email          = s.trim(); }
    public void setFirstName(String s)      { firstName      = s.trim(); }
    public void setLastName(String s)       { lastName       = s.trim(); }
    public void setReceivedCards(String s)  { receivedCards  = s.trim(); }
    public void setSentCards(String s)      { sentCards      = s.trim(); }
    public void setState(String s)          { state          = s.trim(); }
    public void setZip(String s)            { zip            = s.trim(); }
    
    public List<String> getValidationErrors() {
    	return Collections.emptyList();
    }
}
