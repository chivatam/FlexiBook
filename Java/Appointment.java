/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/


import java.util.*;

// line 48 "model.ump"
// line 149 "model.ump"
public class Appointment
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Appointment Attributes
  private int appointmentDuration;

  //Appointment Associations
  private Customer customer;
  private List<TimeSlot> timeSlots;
  private ServiceCombo services;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Appointment(int aAppointmentDuration, Customer aCustomer, ServiceCombo aServices)
  {
    appointmentDuration = aAppointmentDuration;
    boolean didAddCustomer = setCustomer(aCustomer);
    if (!didAddCustomer)
    {
      throw new RuntimeException("Unable to create booking due to customer. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    timeSlots = new ArrayList<TimeSlot>();
    if (!setServices(aServices))
    {
      throw new RuntimeException("Unable to create Appointment due to aServices. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
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
  /* Code from template association_GetOne */
  public Customer getCustomer()
  {
    return customer;
  }
  /* Code from template association_GetMany */
  public TimeSlot getTimeSlot(int index)
  {
    TimeSlot aTimeSlot = timeSlots.get(index);
    return aTimeSlot;
  }

  public List<TimeSlot> getTimeSlots()
  {
    List<TimeSlot> newTimeSlots = Collections.unmodifiableList(timeSlots);
    return newTimeSlots;
  }

  public int numberOfTimeSlots()
  {
    int number = timeSlots.size();
    return number;
  }

  public boolean hasTimeSlots()
  {
    boolean has = timeSlots.size() > 0;
    return has;
  }

  public int indexOfTimeSlot(TimeSlot aTimeSlot)
  {
    int index = timeSlots.indexOf(aTimeSlot);
    return index;
  }
  /* Code from template association_GetOne */
  public ServiceCombo getServices()
  {
    return services;
  }
  /* Code from template association_SetOneToMany */
  public boolean setCustomer(Customer aCustomer)
  {
    boolean wasSet = false;
    if (aCustomer == null)
    {
      return wasSet;
    }

    Customer existingCustomer = customer;
    customer = aCustomer;
    if (existingCustomer != null && !existingCustomer.equals(aCustomer))
    {
      existingCustomer.removeBooking(this);
    }
    customer.addBooking(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTimeSlots()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addTimeSlot(TimeSlot aTimeSlot)
  {
    boolean wasAdded = false;
    if (timeSlots.contains(aTimeSlot)) { return false; }
    timeSlots.add(aTimeSlot);
    if (aTimeSlot.indexOfAppointment(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTimeSlot.addAppointment(this);
      if (!wasAdded)
      {
        timeSlots.remove(aTimeSlot);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeTimeSlot(TimeSlot aTimeSlot)
  {
    boolean wasRemoved = false;
    if (!timeSlots.contains(aTimeSlot))
    {
      return wasRemoved;
    }

    int oldIndex = timeSlots.indexOf(aTimeSlot);
    timeSlots.remove(oldIndex);
    if (aTimeSlot.indexOfAppointment(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTimeSlot.removeAppointment(this);
      if (!wasRemoved)
      {
        timeSlots.add(oldIndex,aTimeSlot);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTimeSlotAt(TimeSlot aTimeSlot, int index)
  {  
    boolean wasAdded = false;
    if(addTimeSlot(aTimeSlot))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTimeSlots()) { index = numberOfTimeSlots() - 1; }
      timeSlots.remove(aTimeSlot);
      timeSlots.add(index, aTimeSlot);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTimeSlotAt(TimeSlot aTimeSlot, int index)
  {
    boolean wasAdded = false;
    if(timeSlots.contains(aTimeSlot))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTimeSlots()) { index = numberOfTimeSlots() - 1; }
      timeSlots.remove(aTimeSlot);
      timeSlots.add(index, aTimeSlot);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTimeSlotAt(aTimeSlot, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetUnidirectionalOne */
  public boolean setServices(ServiceCombo aNewServices)
  {
    boolean wasSet = false;
    if (aNewServices != null)
    {
      services = aNewServices;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    Customer placeholderCustomer = customer;
    this.customer = null;
    if(placeholderCustomer != null)
    {
      placeholderCustomer.removeBooking(this);
    }
    ArrayList<TimeSlot> copyOfTimeSlots = new ArrayList<TimeSlot>(timeSlots);
    timeSlots.clear();
    for(TimeSlot aTimeSlot : copyOfTimeSlots)
    {
      aTimeSlot.removeAppointment(this);
    }
    services = null;
  }


  public String toString()
  {
    return super.toString() + "["+
            "appointmentDuration" + ":" + getAppointmentDuration()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "customer = "+(getCustomer()!=null?Integer.toHexString(System.identityHashCode(getCustomer())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "services = "+(getServices()!=null?Integer.toHexString(System.identityHashCode(getServices())):"null");
  }
}