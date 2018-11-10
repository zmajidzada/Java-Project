/**
 * Created by IntelliJ IDEA.
 * User: zmajidzada
 * Date: 29-Mar-2010
 * Time: 12:08:57
 * To change this template use File | Settings | File Templates.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;

public class DoorPanel extends JPanel {

    private JLabel label[];
    private House house;
    private JButton onButton;
    private JButton offButton;


    private JButton lockDoors;
    private JButton unlockDoors;
    private JButton lock;
    private JButton unlock;
    private JButton setAlarmOn;
    private JButton setAlarmOff;
    private JLabel alarmLabel;
    private SensorObserver obs;
    private Garage garage;

    private JButton lockGarage;
    private JButton unlockGarage;
    private JLabel garageLabel;


    private ArrayList<JButton> doorButtons = new ArrayList<JButton>();

    public DoorPanel(House house) {

        this.house=house;

        garage=new Garage("Car Garage");

        JPanel p = new JPanel();
        JPanel doorPanel = createDoorPanel();
        JPanel labelPanel = createLabelPanel();

        p.add(doorPanel);
        p.add(labelPanel);
     ;
        add(p);


    }

  


    private JPanel createDoorPanel() {

        ArrayList<Door> doors = house.getDoors();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(doors.size() + 1, 1));
        JPanel labels = new JPanel(new GridLayout(doors.size() + 1, 1));

        Handler listener = new Handler();
        for (Door door : doors) {
            JPanel dPanel = new JPanel();
            lock = new JButton("Lock");
            unlock = new JButton("UnLock");
            lock.setActionCommand(door.getName());
            unlock.setActionCommand(door.getName());
            lock.addActionListener(listener);
            unlock.addActionListener(listener);
            labels.add(new JLabel(door.getName()));
            dPanel.add(lock);
            dPanel.add(unlock);
            panel.add(dPanel);
        }
        JPanel allPanel = new JPanel();

        lockDoors = new JButton("Lock All");
        lockDoors.addActionListener(new Handler());

        allPanel.add(lockDoors);
        unlockDoors = new JButton("Unlock All");
        unlockDoors.addActionListener(new Handler());
        allPanel.add(unlockDoors);
        panel.add(allPanel);
        //unlockGarageButton = new JButton("Unlock garage");
        //panel.add(unlockGarageButton);
        mainPanel.add(labels, BorderLayout.WEST);
        mainPanel.add(panel, BorderLayout.CENTER);

        return mainPanel;
    }

    private JPanel createLabelPanel() {

        label = new JLabel[6];

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(6,label.length, 0, 15));

        java.util.List doors = house.getDoors();
        for (int i = 0; i <label.length; i++) {
            Door d = (Door) doors.get(i);
            String message = d.isLocked() ? "Locked" : "Open";
            label[i] = new JLabel(message);

            labelPanel.add(label[i]);
        }

        return labelPanel;
    }

    class Handler implements ActionListener {

        public void actionPerformed(ActionEvent e) {


            Object source = e.getSource();
            if (source == lockDoors) {
                for (int i = 0; i < label.length; i++) {
                    house.lockAllDoors();
                    label[i].setText("lock All");
                }


            }
            if (source == unlockDoors) {
                            for (int i = 0; i < label.length; i++) {
                                house.unlockAllDoors();
                                label[i].setText("Unlocked All");
                            }


                        }


            else if (source instanceof JButton) {
                JButton button = (JButton) source;
                String actionCommand = button.getActionCommand();
                //System.out.println("buton with command " + actionCommand + " clicked");

                Door door = house.findDoor(actionCommand);
                int index = house.getDoors().indexOf(door);
                JLabel target = label[index];
                if (button.getText().equals("UnLock")) {
                    house.checkAlarm("Front Door");
                    house.checkAlarm("Kitchen Door");
                    door.unlockDoor();
                    target.setText(door.toString());
                } else {
                    door.lockDoor();
                    target.setText("Lock");
                }
            }

        }


    }

}

