/**
 * Created by IntelliJ IDEA.
 * User: zmajidzada
 * Date: 07-Apr-2010
 * Time: 18:31:16
 * To change this template use File | Settings | File Templates.
 */
public interface Sensor {

    void addSensorObserver(SensorObserver s);
    void removeSensorObserver();
    void isTriggered();
}
