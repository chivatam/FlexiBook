/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/


import java.util.*;
import java.sql.Time;

// line 74 "model.ump"
// line 177 "model.ump"
public class ServiceList
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ServiceList Attributes
  private List listOfServices;
  private List listOfServiceCombo;

  //ServiceList Associations
  private BusinessInfo businessInfo;
  private List<ServiceCombo> serviceCombos;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ServiceList(List aListOfServices, List aListOfServiceCombo, BusinessInfo aBusinessInfo)
  {
    listOfServices = aListOfServices;
    listOfServiceCombo = aListOfServiceCombo;
    if (aBusinessInfo == null || aBusinessInfo.getServices() != null)
    {
      throw new RuntimeException("Unable to create ServiceList due to aBusinessInfo. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    businessInfo = aBusinessInfo;
    serviceCombos = new ArrayList<ServiceCombo>();
  }

  public ServiceList(List aListOfServices, List aListOfServiceCombo, String aBusinessNameForBusinessInfo, String aEmailAddressForBusinessInfo, String aPhoneNoForBusinessInfo, Time aOpeningTimeForBusinessInfo, Time aClosingTimeForBusinessInfo, Owner aOwnerForBusinessInfo, Calendar aScheduleForBusinessInfo)
  {
    listOfServices = aListOfServices;
    listOfServiceCombo = aListOfServiceCombo;
    businessInfo = new BusinessInfo(aBusinessNameForBusinessInfo, aEmailAddressForBusinessInfo, aPhoneNoForBusinessInfo, aOpeningTimeForBusinessInfo, aClosingTimeForBusinessInfo, this, aOwnerForBusinessInfo, aScheduleForBusinessInfo);
    serviceCombos = new ArrayList<ServiceCombo>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setListOfServices(List aListOfServices)
  {
    boolean wasSet = false;
    listOfServices = aListOfServices;
    wasSet = true;
    return wasSet;
  }

  public boolean setListOfServiceCombo(List aListOfServiceCombo)
  {
    boolean wasSet = false;
    listOfServiceCombo = aListOfServiceCombo;
    wasSet = true;
    return wasSet;
  }

  public List getListOfServices()
  {
    return listOfServices;
  }

  public List getListOfServiceCombo()
  {
    return listOfServiceCombo;
  }
  /* Code from template association_GetOne */
  public BusinessInfo getBusinessInfo()
  {
    return businessInfo;
  }
  /* Code from template association_GetMany */
  public ServiceCombo getServiceCombo(int index)
  {
    ServiceCombo aServiceCombo = serviceCombos.get(index);
    return aServiceCombo;
  }

  public List<ServiceCombo> getServiceCombos()
  {
    List<ServiceCombo> newServiceCombos = Collections.unmodifiableList(serviceCombos);
    return newServiceCombos;
  }

  public int numberOfServiceCombos()
  {
    int number = serviceCombos.size();
    return number;
  }

  public boolean hasServiceCombos()
  {
    boolean has = serviceCombos.size() > 0;
    return has;
  }

  public int indexOfServiceCombo(ServiceCombo aServiceCombo)
  {
    int index = serviceCombos.indexOf(aServiceCombo);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfServiceCombos()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public ServiceCombo addServiceCombo(int aNoOfServices, int aComboCost, int aComboDuration, String aComboDescription)
  {
    return new ServiceCombo(aNoOfServices, aComboCost, aComboDuration, aComboDescription, this);
  }

  public boolean addServiceCombo(ServiceCombo aServiceCombo)
  {
    boolean wasAdded = false;
    if (serviceCombos.contains(aServiceCombo)) { return false; }
    ServiceList existingServiceList = aServiceCombo.getServiceList();
    boolean isNewServiceList = existingServiceList != null && !this.equals(existingServiceList);
    if (isNewServiceList)
    {
      aServiceCombo.setServiceList(this);
    }
    else
    {
      serviceCombos.add(aServiceCombo);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeServiceCombo(ServiceCombo aServiceCombo)
  {
    boolean wasRemoved = false;
    //Unable to remove aServiceCombo, as it must always have a serviceList
    if (!this.equals(aServiceCombo.getServiceList()))
    {
      serviceCombos.remove(aServiceCombo);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addServiceComboAt(ServiceCombo aServiceCombo, int index)
  {  
    boolean wasAdded = false;
    if(addServiceCombo(aServiceCombo))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfServiceCombos()) { index = numberOfServiceCombos() - 1; }
      serviceCombos.remove(aServiceCombo);
      serviceCombos.add(index, aServiceCombo);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveServiceComboAt(ServiceCombo aServiceCombo, int index)
  {
    boolean wasAdded = false;
    if(serviceCombos.contains(aServiceCombo))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfServiceCombos()) { index = numberOfServiceCombos() - 1; }
      serviceCombos.remove(aServiceCombo);
      serviceCombos.add(index, aServiceCombo);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addServiceComboAt(aServiceCombo, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    BusinessInfo existingBusinessInfo = businessInfo;
    businessInfo = null;
    if (existingBusinessInfo != null)
    {
      existingBusinessInfo.delete();
    }
    while (serviceCombos.size() > 0)
    {
      ServiceCombo aServiceCombo = serviceCombos.get(serviceCombos.size() - 1);
      aServiceCombo.delete();
      serviceCombos.remove(aServiceCombo);
    }
    
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "listOfServices" + "=" + (getListOfServices() != null ? !getListOfServices().equals(this)  ? getListOfServices().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "listOfServiceCombo" + "=" + (getListOfServiceCombo() != null ? !getListOfServiceCombo().equals(this)  ? getListOfServiceCombo().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "businessInfo = "+(getBusinessInfo()!=null?Integer.toHexString(System.identityHashCode(getBusinessInfo())):"null");
  }
}