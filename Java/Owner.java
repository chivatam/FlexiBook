/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/


import java.util.*;
import java.sql.Time;

// line 21 "model.ump"
// line 129 "model.ump"
public class Owner extends Account
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Owner Associations
  private BusinessInfo business;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Owner(String aUsername, String aPassword, BusinessInfo aBusiness)
  {
    super(aUsername, aPassword);
    if (aBusiness == null || aBusiness.getOwner() != null)
    {
      throw new RuntimeException("Unable to create Owner due to aBusiness. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    business = aBusiness;
  }

  public Owner(String aUsername, String aPassword, String aBusinessNameForBusiness, String aEmailAddressForBusiness, String aPhoneNoForBusiness, Time aOpeningTimeForBusiness, Time aClosingTimeForBusiness, ServiceList aServicesForBusiness, Calendar aScheduleForBusiness)
  {
    super(aUsername, aPassword);
    business = new BusinessInfo(aBusinessNameForBusiness, aEmailAddressForBusiness, aPhoneNoForBusiness, aOpeningTimeForBusiness, aClosingTimeForBusiness, aServicesForBusiness, this, aScheduleForBusiness);
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public BusinessInfo getBusiness()
  {
    return business;
  }

  public void delete()
  {
    BusinessInfo existingBusiness = business;
    business = null;
    if (existingBusiness != null)
    {
      existingBusiness.delete();
    }
    super.delete();
  }

}