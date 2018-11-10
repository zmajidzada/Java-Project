import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: zmajidzada
 * Date: 09-Apr-2010
 * Time: 15:07:01
 * To change this template use File | Settings | File Templates.
 */
public class DoorObserver implements SensorObserver {
    public void sensorTriggered(String message) {
        JOptionPane.showMessageDialog(null, "" + message, "WARNING!!!", JOptionPane.WARNING_MESSAGE);
    }
}
