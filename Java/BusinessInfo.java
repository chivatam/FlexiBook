/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/



// line 29 "model.ump"
// line 86 "model.ump"
public class BusinessInfo
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //BusinessInfo Attributes
  private String businessName;
  private String businessAddress;
  private String emailAddress;
  private String phoneNo;
  private int openingTime;
  private int closingTime;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public BusinessInfo(String aBusinessName, String aBusinessAddress, String aEmailAddress, String aPhoneNo, int aOpeningTime, int aClosingTime)
  {
    businessName = aBusinessName;
    businessAddress = aBusinessAddress;
    emailAddress = aEmailAddress;
    phoneNo = aPhoneNo;
    openingTime = aOpeningTime;
    closingTime = aClosingTime;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setBusinessName(String aBusinessName)
  {
    boolean wasSet = false;
    businessName = aBusinessName;
    wasSet = true;
    return wasSet;
  }

  public boolean setBusinessAddress(String aBusinessAddress)
  {
    boolean wasSet = false;
    businessAddress = aBusinessAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setEmailAddress(String aEmailAddress)
  {
    boolean wasSet = false;
    emailAddress = aEmailAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setPhoneNo(String aPhoneNo)
  {
    boolean wasSet = false;
    phoneNo = aPhoneNo;
    wasSet = true;
    return wasSet;
  }

  public boolean setOpeningTime(int aOpeningTime)
  {
    boolean wasSet = false;
    openingTime = aOpeningTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setClosingTime(int aClosingTime)
  {
    boolean wasSet = false;
    closingTime = aClosingTime;
    wasSet = true;
    return wasSet;
  }

  public String getBusinessName()
  {
    return businessName;
  }

  public String getBusinessAddress()
  {
    return businessAddress;
  }

  public String getEmailAddress()
  {
    return emailAddress;
  }

  public String getPhoneNo()
  {
    return phoneNo;
  }

  public int getOpeningTime()
  {
    return openingTime;
  }

  public int getClosingTime()
  {
    return closingTime;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "businessName" + ":" + getBusinessName()+ "," +
            "businessAddress" + ":" + getBusinessAddress()+ "," +
            "emailAddress" + ":" + getEmailAddress()+ "," +
            "phoneNo" + ":" + getPhoneNo()+ "," +
            "openingTime" + ":" + getOpeningTime()+ "," +
            "closingTime" + ":" + getClosingTime()+ "]";
  }
}