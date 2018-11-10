/**
 * Created by IntelliJ IDEA.
 * User: zmajidzada
 * Date: 26-Mar-2010
 * Time: 10:12:03
 * To change this template use File | Settings | File Templates.
 */


public class Light implements Switchable {


    private boolean lightOn;


    public Light() {
        lightOn = false;
    }

    public void switchOn() {
        lightOn = true;

    }

    public void switchOff() {
        lightOn = false;

    }
    public boolean isOn(){
        return lightOn;
    }
    public String toString()
    {
       if(lightOn)

           return "On";

          else return "Off";
    }

}
