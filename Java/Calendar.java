/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/



// line 44 "model.ump"
// line 96 "model.ump"
public class Calendar
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Calendar Attributes
  private String timeSlot;
  private boolean isAvailable;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Calendar(String aTimeSlot, boolean aIsAvailable)
  {
    timeSlot = aTimeSlot;
    isAvailable = aIsAvailable;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTimeSlot(String aTimeSlot)
  {
    boolean wasSet = false;
    timeSlot = aTimeSlot;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsAvailable(boolean aIsAvailable)
  {
    boolean wasSet = false;
    isAvailable = aIsAvailable;
    wasSet = true;
    return wasSet;
  }

  public String getTimeSlot()
  {
    return timeSlot;
  }

  public boolean getIsAvailable()
  {
    return isAvailable;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "timeSlot" + ":" + getTimeSlot()+ "," +
            "isAvailable" + ":" + getIsAvailable()+ "]";
  }
}