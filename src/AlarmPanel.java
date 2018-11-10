import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by IntelliJ IDEA.
 * User: zmajidzada
 * Date: 09-Apr-2010
 * Time: 15:05:46
 * To change this template use File | Settings | File Templates.
 */
public class AlarmPanel extends JPanel {

    private House house;

    private JButton activate, deActivate, trigger;
    private JCheckBox frontDoor, kitchenDoor;
    private JLabel frontDoorStatus, kitchenDoorStatus;
    private JPanel buttons, boxes, labels;

    private boolean fDoorControl, kDoorControl;

    private DoorObserver doorObserver;

    public AlarmPanel(House house) {

        this.house=house;
        doorObserver = new DoorObserver();
        activate = new JButton("Activate");
        deActivate = new JButton("De-Activate");
        trigger = new JButton("Trigger");

        frontDoor = new JCheckBox("Front Door");
        kitchenDoor = new JCheckBox("Kitchen Door");

        frontDoorStatus = new JLabel("Front Door Status:");
        kitchenDoorStatus = new JLabel("Kitchen Door Status");

        buttons = new JPanel();
        boxes = new JPanel();
        labels = new JPanel();

        buttons.setLayout(new FlowLayout());
        buttons.add(activate);
        buttons.add(deActivate);
        buttons.add(trigger);

        activate.addActionListener(new Activate());
        deActivate.addActionListener(new Activate());
        trigger.addActionListener(new Activate());
        frontDoor.addActionListener(new Activate());
        kitchenDoor.addActionListener(new Activate());


        boxes.setLayout(new FlowLayout());
        boxes.add(frontDoor);
        boxes.add(kitchenDoor);

        setLayout(new GridLayout(2,1, 5, 5));
        labels.add(frontDoorStatus);
        labels.add(kitchenDoorStatus);

        setLayout(new GridLayout(3, 3, 5, 5));
        add(boxes);
        add(buttons);
        add(labels);

    }
     class Activate implements ActionListener {
         public void actionPerformed(ActionEvent evt) {
             Object source = evt.getSource();

             if (source==frontDoor) {
                 if (frontDoor.isSelected()) {
                    fDoorControl = true;

                 }
                 else {
                     fDoorControl = false;
                 }
             }
             else if (source==kitchenDoor) {
                 if (kitchenDoor.isSelected()) {
                     kDoorControl = true;
                 }
                 else {
                     kDoorControl = false;
                 }
             }
            else if (source==activate) {
                if (fDoorControl) {
                    house.activateAlarm(doorObserver, "Front Door");

                }
                if (kDoorControl) {
                    house.activateAlarm(doorObserver, "Kitchen Door");
                }
                updateStatus();
            }
            else if (source==deActivate) {
                if (fDoorControl) {
                    house.removeSensorObserver("Front Door");
                }
                if (kDoorControl) {
                    house.removeSensorObserver("Kitchen Door");
                }
             updateStatus();
             }
             else if (source==trigger) {
                 if (fDoorControl) {
                     house.checkAlarm("Front Door");
                 }
                 if (kDoorControl) {
                     house.checkAlarm("Kitchen Door");
                 }
             }

         }

         }

    private void updateStatus() {
        frontDoorStatus.setText(house.updateStatus("Front Door"));
        kitchenDoorStatus.setText(house.updateStatus("Kitchen Door"));
    }
     }
