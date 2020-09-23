/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/



// line 22 "model.ump"
// line 81 "model.ump"
public class ServiceCombo
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ServiceCombo Attributes
  private int noOfServices;
  private int comboCost;
  private int comboDuration;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ServiceCombo(int aNoOfServices, int aComboCost, int aComboDuration)
  {
    noOfServices = aNoOfServices;
    comboCost = aComboCost;
    comboDuration = aComboDuration;
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

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "noOfServices" + ":" + getNoOfServices()+ "," +
            "comboCost" + ":" + getComboCost()+ "," +
            "comboDuration" + ":" + getComboDuration()+ "]";
  }
}