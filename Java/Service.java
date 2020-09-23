/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/



// line 10 "model.ump"
// line 71 "model.ump"
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

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Service(String aServiceCost, String aServiceName, String aServiceDuration, String aServiceDowntime)
  {
    serviceCost = aServiceCost;
    serviceName = aServiceName;
    serviceDuration = aServiceDuration;
    serviceDowntime = aServiceDowntime;
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

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "serviceCost" + ":" + getServiceCost()+ "," +
            "serviceName" + ":" + getServiceName()+ "," +
            "serviceDuration" + ":" + getServiceDuration()+ "," +
            "serviceDowntime" + ":" + getServiceDowntime()+ "]";
  }
}