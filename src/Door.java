/**
 * Created by IntelliJ IDEA.
 * User: zmajidzada
 * Date: 26-Mar-2010
 * Time: 10:19:59
 * To change this template use File | Settings | File Templates.
 */
public class Door implements Sensor  {

    protected String name;
    private boolean lock;
    private boolean open;
    private SensorObserver observer;
    private boolean isArmed;
	private boolean isTriggered;
    public Door(String name) {
        this.name = name;
        lock = true;
        open = false;
          	isTriggered=false;
    	isArmed=false;

    }

    public void lockDoor() {
        lock = true;
        open=false;
    }

    public void unlockDoor() {

        lock = false;
    }

    public boolean isLocked() {

        return lock;
    }

    public void openDoor() {
        open = true;

    }
    public void addSensorObserver(SensorObserver observer)
    {
        this.observer=observer;
        isArmed = true;

    }
    public void removeSensorObserver()
    {
           isArmed=false;
    }
    public void isTriggered()
    {
        observer.sensorTriggered("Sensor Name " + name + " has been triggered");
    }

    public boolean isArmed() {
        return isArmed;
    }
    
    public void closeDoor() {
        open = false;
    }

    public String getName() {
        return name;
    }

    public String toString()
   {
       String message="";
       String message2="";
       String message3= "";
       if(lock){
        message="Locked";
       }
       if(!lock){
           message="Unlocked";
       }
       if(open){
           message2="Open";
       }
       if(!open){
           message2="Closed";
       }
       if (isArmed) {
           message3= "Alarm is On";
       }
       if (!isArmed) {
           message3 = "Alarm is Off";
       }
         return "This "+name+" is "+message+" -- "+message2 + " and " + message3;

        //return "" + name + lock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Door)) return false;

        Door door = (Door) o;

        if (name != null ? !name.equals(door.name) : door.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
