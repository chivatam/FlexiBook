/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/


import java.util.*;

// line 62 "model.ump"
// line 165 "model.ump"
public class Account
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Account Attributes
  private String username;
  private String password;

  //Account Associations
  private List<LogIn> login;
  private List<LogOut> logout;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Account(String aUsername, String aPassword)
  {
    username = aUsername;
    password = aPassword;
    login = new ArrayList<LogIn>();
    logout = new ArrayList<LogOut>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setUsername(String aUsername)
  {
    boolean wasSet = false;
    username = aUsername;
    wasSet = true;
    return wasSet;
  }

  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    return wasSet;
  }

  public String getUsername()
  {
    return username;
  }

  public String getPassword()
  {
    return password;
  }
  /* Code from template association_GetMany */
  public LogIn getLogin(int index)
  {
    LogIn aLogin = login.get(index);
    return aLogin;
  }

  public List<LogIn> getLogin()
  {
    List<LogIn> newLogin = Collections.unmodifiableList(login);
    return newLogin;
  }

  public int numberOfLogin()
  {
    int number = login.size();
    return number;
  }

  public boolean hasLogin()
  {
    boolean has = login.size() > 0;
    return has;
  }

  public int indexOfLogin(LogIn aLogin)
  {
    int index = login.indexOf(aLogin);
    return index;
  }
  /* Code from template association_GetMany */
  public LogOut getLogout(int index)
  {
    LogOut aLogout = logout.get(index);
    return aLogout;
  }

  public List<LogOut> getLogout()
  {
    List<LogOut> newLogout = Collections.unmodifiableList(logout);
    return newLogout;
  }

  public int numberOfLogout()
  {
    int number = logout.size();
    return number;
  }

  public boolean hasLogout()
  {
    boolean has = logout.size() > 0;
    return has;
  }

  public int indexOfLogout(LogOut aLogout)
  {
    int index = logout.indexOf(aLogout);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfLogin()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public LogIn addLogin()
  {
    return new LogIn(this);
  }

  public boolean addLogin(LogIn aLogin)
  {
    boolean wasAdded = false;
    if (login.contains(aLogin)) { return false; }
    Account existingAccount = aLogin.getAccount();
    boolean isNewAccount = existingAccount != null && !this.equals(existingAccount);
    if (isNewAccount)
    {
      aLogin.setAccount(this);
    }
    else
    {
      login.add(aLogin);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeLogin(LogIn aLogin)
  {
    boolean wasRemoved = false;
    //Unable to remove aLogin, as it must always have a account
    if (!this.equals(aLogin.getAccount()))
    {
      login.remove(aLogin);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addLoginAt(LogIn aLogin, int index)
  {  
    boolean wasAdded = false;
    if(addLogin(aLogin))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLogin()) { index = numberOfLogin() - 1; }
      login.remove(aLogin);
      login.add(index, aLogin);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveLoginAt(LogIn aLogin, int index)
  {
    boolean wasAdded = false;
    if(login.contains(aLogin))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLogin()) { index = numberOfLogin() - 1; }
      login.remove(aLogin);
      login.add(index, aLogin);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addLoginAt(aLogin, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfLogout()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public LogOut addLogout()
  {
    return new LogOut(this);
  }

  public boolean addLogout(LogOut aLogout)
  {
    boolean wasAdded = false;
    if (logout.contains(aLogout)) { return false; }
    Account existingAccount = aLogout.getAccount();
    boolean isNewAccount = existingAccount != null && !this.equals(existingAccount);
    if (isNewAccount)
    {
      aLogout.setAccount(this);
    }
    else
    {
      logout.add(aLogout);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeLogout(LogOut aLogout)
  {
    boolean wasRemoved = false;
    //Unable to remove aLogout, as it must always have a account
    if (!this.equals(aLogout.getAccount()))
    {
      logout.remove(aLogout);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addLogoutAt(LogOut aLogout, int index)
  {  
    boolean wasAdded = false;
    if(addLogout(aLogout))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLogout()) { index = numberOfLogout() - 1; }
      logout.remove(aLogout);
      logout.add(index, aLogout);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveLogoutAt(LogOut aLogout, int index)
  {
    boolean wasAdded = false;
    if(logout.contains(aLogout))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLogout()) { index = numberOfLogout() - 1; }
      logout.remove(aLogout);
      logout.add(index, aLogout);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addLogoutAt(aLogout, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=login.size(); i > 0; i--)
    {
      LogIn aLogin = login.get(i - 1);
      aLogin.delete();
    }
    for(int i=logout.size(); i > 0; i--)
    {
      LogOut aLogout = logout.get(i - 1);
      aLogout.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "username" + ":" + getUsername()+ "," +
            "password" + ":" + getPassword()+ "]";
  }
}