/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/



// line 39 "model.ump"
// line 91 "model.ump"
public class Appointment
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Appointment Attributes
  private int appointmentDuration;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Appointment(int aAppointmentDuration)
  {
    appointmentDuration = aAppointmentDuration;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAppointmentDuration(int aAppointmentDuration)
  {
    boolean wasSet = false;
    appointmentDuration = aAppointmentDuration;
    wasSet = true;
    return wasSet;
  }

  public int getAppointmentDuration()
  {
    return appointmentDuration;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "appointmentDuration" + ":" + getAppointmentDuration()+ "]";
  }
}