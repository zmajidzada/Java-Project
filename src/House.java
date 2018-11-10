/**
 * Created by IntelliJ IDEA.
 * User: zmajidzada
 * Date: 26-Mar-2010
 * Time: 10:18:55
 * To change this template use File | Settings | File Templates.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;

public class House {


    private ArrayList doors = new ArrayList();
    private ArrayList<Light> lights = new ArrayList<Light>();
    private Garage garage;
    SensorObserver observer;

    public House() {
        doors.add(new Door("Main Door"));
        doors.add(new Door("Kitchen Door"));
        doors.add(new Door("Bathroom Door"));
        doors.add(new Door("Front Door"));
        doors.add(new Garage("Garage Door"));
        doors.add(new Door("All Doors"));

        lights.add(new Light());


    }

    public ArrayList getDoors() {
        return doors;
    }

    public void switchOnLights() {
        for (int i = 0; i < lights.size(); i++) {
            Light light = lights.get(i);
            light.switchOn();
        }
    }

    public void switchOfLights() {
        for (int i = 0; i < lights.size(); i++) {
            Light light = lights.get(i);
            light.switchOff();
        }

    }

    public void lockAllDoors() {

        for (int i = 0; i < doors.size(); i++) {
            Door d = (Door) doors.get(i);
            d.lockDoor();

        }
    }

    public void unlockAllDoors() {

        for (int i = 0; i < doors.size(); i++) {
            Door d = (Door) doors.get(i);
            d.unlockDoor();
        }
    }

    public void activateAlarm(SensorObserver observer, String name)
    {
        this.observer=observer;

        Door door=findDoor(name);

        door.addSensorObserver(observer);
    }
     public void removeSensorObserver(String name)
    {
        Door door=findDoor(name);

        door.removeSensorObserver();
    }
    public void testAlarm(String name) {
        Door door = findDoor(name);
        door.isTriggered();
    }
   

    public void checkAlarm(String name) {
        Door door = findDoor(name);
        if (door.isArmed()) {
            door.isTriggered();
        }
    }

    public void lockDoor() {
        Door d1 = new Door("door is locked");
        d1.lockDoor();

    }

    public void unlockDoor() {

        Door d2 = new Door("door is unlocked");
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < doors.size(); i++) {
            result += doors.get(i) + "\n";
        }


        return result;

    }

    public Door findDoor(String doorName) {

        for (int i = 0; i < doors.size(); i++) {

            Door door = (Door) doors.get(i);
            if(door.getName().equals(doorName)) {

                return (Door) doors.get(i);
            }
        }

        return null;
    }
    
    public String updateStatus(String name) {
        Door door = findDoor(name);
        return (door.toString());
    }
}