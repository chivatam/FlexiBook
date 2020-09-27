/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/


import java.util.*;

// line 26 "model.ump"
// line 134 "model.ump"
public class ServiceCombo
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ServiceCombo Attributes
  private int noOfServices;
  private int comboCost;
  private int comboDuration;
  private String comboDescription;

  //ServiceCombo Associations
  private ServiceList serviceList;
  private List<Service> services;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ServiceCombo(int aNoOfServices, int aComboCost, int aComboDuration, String aComboDescription, ServiceList aServiceList)
  {
    noOfServices = aNoOfServices;
    comboCost = aComboCost;
    comboDuration = aComboDuration;
    comboDescription = aComboDescription;
    boolean didAddServiceList = setServiceList(aServiceList);
    if (!didAddServiceList)
    {
      throw new RuntimeException("Unable to create serviceCombo due to serviceList. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    services = new ArrayList<Service>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNoOfServices(int aNoOfServices)
  {
    boolean wasSet = false;
    noOfServices = aNoOfServices;
    wasSet = true;
    return wasSet;
  }

  public boolean setComboCost(int aComboCost)
  {
    boolean wasSet = false;
    comboCost = aComboCost;
    wasSet = true;
    return wasSet;
  }

  public boolean setComboDuration(int aComboDuration)
  {
    boolean wasSet = false;
    comboDuration = aComboDuration;
    wasSet = true;
    return wasSet;
  }

  public boolean setComboDescription(String aComboDescription)
  {
    boolean wasSet = false;
    comboDescription = aComboDescription;
    wasSet = true;
    return wasSet;
  }

  public int getNoOfServices()
  {
    return noOfServices;
  }

  public int getComboCost()
  {
    return comboCost;
  }

  public int getComboDuration()
  {
    return comboDuration;
  }

  public String getComboDescription()
  {
    return comboDescription;
  }
  /* Code from template association_GetOne */
  public ServiceList getServiceList()
  {
    return serviceList;
  }
  /* Code from template association_GetMany */
  public Service getService(int index)
  {
    Service aService = services.get(index);
    return aService;
  }

  public List<Service> getServices()
  {
    List<Service> newServices = Collections.unmodifiableList(services);
    return newServices;
  }

  public int numberOfServices()
  {
    int number = services.size();
    return number;
  }

  public boolean hasServices()
  {
    boolean has = services.size() > 0;
    return has;
  }

  public int indexOfService(Service aService)
  {
    int index = services.indexOf(aService);
    return index;
  }
  /* Code from template association_SetOneToMany */
  public boolean setServiceList(ServiceList aServiceList)
  {
    boolean wasSet = false;
    if (aServiceList == null)
    {
      return wasSet;
    }

    ServiceList existingServiceList = serviceList;
    serviceList = aServiceList;
    if (existingServiceList != null && !existingServiceList.equals(aServiceList))
    {
      existingServiceList.removeServiceCombo(this);
    }
    serviceList.addServiceCombo(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfServices()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addService(Service aService)
  {
    boolean wasAdded = false;
    if (services.contains(aService)) { return false; }
    services.add(aService);
    if (aService.indexOfServiceCombo(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aService.addServiceCombo(this);
      if (!wasAdded)
      {
        services.remove(aService);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeService(Service aService)
  {
    boolean wasRemoved = false;
    if (!services.contains(aService))
    {
      return wasRemoved;
    }

    int oldIndex = services.indexOf(aService);
    services.remove(oldIndex);
    if (aService.indexOfServiceCombo(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aService.removeServiceCombo(this);
      if (!wasRemoved)
      {
        services.add(oldIndex,aService);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addServiceAt(Service aService, int index)
  {  
    boolean wasAdded = false;
    if(addService(aService))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfServices()) { index = numberOfServices() - 1; }
      services.remove(aService);
      services.add(index, aService);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveServiceAt(Service aService, int index)
  {
    boolean wasAdded = false;
    if(services.contains(aService))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfServices()) { index = numberOfServices() - 1; }
      services.remove(aService);
      services.add(index, aService);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addServiceAt(aService, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ServiceList placeholderServiceList = serviceList;
    this.serviceList = null;
    if(placeholderServiceList != null)
    {
      placeholderServiceList.removeServiceCombo(this);
    }
    while (services.size() > 0)
    {
      Service aService = services.get(services.size() - 1);
      aService.delete();
      services.remove(aService);
    }
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "noOfServices" + ":" + getNoOfServices()+ "," +
            "comboCost" + ":" + getComboCost()+ "," +
            "comboDuration" + ":" + getComboDuration()+ "," +
            "comboDescription" + ":" + getComboDescription()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "serviceList = "+(getServiceList()!=null?Integer.toHexString(System.identityHashCode(getServiceList())):"null");
  }
}