/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/


import java.util.*;

// line 12 "model.ump"
// line 124 "model.ump"
public class Service
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Service Attributes
  private String serviceCost;
  private String serviceName;
  private String serviceDuration;
  private String serviceDowntime;
  private String serviceDescription;

  //Service Associations
  private List<ServiceCombo> serviceCombos;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Service(String aServiceCost, String aServiceName, String aServiceDuration, String aServiceDowntime, String aServiceDescription)
  {
    serviceCost = aServiceCost;
    serviceName = aServiceName;
    serviceDuration = aServiceDuration;
    serviceDowntime = aServiceDowntime;
    serviceDescription = aServiceDescription;
    serviceCombos = new ArrayList<ServiceCombo>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setServiceCost(String aServiceCost)
  {
    boolean wasSet = false;
    serviceCost = aServiceCost;
    wasSet = true;
    return wasSet;
  }

  public boolean setServiceName(String aServiceName)
  {
    boolean wasSet = false;
    serviceName = aServiceName;
    wasSet = true;
    return wasSet;
  }

  public boolean setServiceDuration(String aServiceDuration)
  {
    boolean wasSet = false;
    serviceDuration = aServiceDuration;
    wasSet = true;
    return wasSet;
  }

  public boolean setServiceDowntime(String aServiceDowntime)
  {
    boolean wasSet = false;
    serviceDowntime = aServiceDowntime;
    wasSet = true;
    return wasSet;
  }

  public boolean setServiceDescription(String aServiceDescription)
  {
    boolean wasSet = false;
    serviceDescription = aServiceDescription;
    wasSet = true;
    return wasSet;
  }

  public String getServiceCost()
  {
    return serviceCost;
  }

  public String getServiceName()
  {
    return serviceName;
  }

  public String getServiceDuration()
  {
    return serviceDuration;
  }

  public String getServiceDowntime()
  {
    return serviceDowntime;
  }

  public String getServiceDescription()
  {
    return serviceDescription;
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
  /* Code from template association_AddManyToManyMethod */
  public boolean addServiceCombo(ServiceCombo aServiceCombo)
  {
    boolean wasAdded = false;
    if (serviceCombos.contains(aServiceCombo)) { return false; }
    serviceCombos.add(aServiceCombo);
    if (aServiceCombo.indexOfService(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aServiceCombo.addService(this);
      if (!wasAdded)
      {
        serviceCombos.remove(aServiceCombo);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeServiceCombo(ServiceCombo aServiceCombo)
  {
    boolean wasRemoved = false;
    if (!serviceCombos.contains(aServiceCombo))
    {
      return wasRemoved;
    }

    int oldIndex = serviceCombos.indexOf(aServiceCombo);
    serviceCombos.remove(oldIndex);
    if (aServiceCombo.indexOfService(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aServiceCombo.removeService(this);
      if (!wasRemoved)
      {
        serviceCombos.add(oldIndex,aServiceCombo);
      }
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
    ArrayList<ServiceCombo> copyOfServiceCombos = new ArrayList<ServiceCombo>(serviceCombos);
    serviceCombos.clear();
    for(ServiceCombo aServiceCombo : copyOfServiceCombos)
    {
      aServiceCombo.removeService(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "serviceCost" + ":" + getServiceCost()+ "," +
            "serviceName" + ":" + getServiceName()+ "," +
            "serviceDuration" + ":" + getServiceDuration()+ "," +
            "serviceDowntime" + ":" + getServiceDowntime()+ "," +
            "serviceDescription" + ":" + getServiceDescription()+ "]";
  }
}