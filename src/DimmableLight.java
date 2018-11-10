import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: zmajidzada
 * Date: 31-Mar-2010
 * Time: 18:25:45
 * To change this template use File | Settings | File Templates.
 */
public class DimmableLight extends Light {

                    private int MAX=10;
                    private int MIN=0;
                    private int intensity;
    public DimmableLight()
    {
        intensity=1;
    }
    public void lowIntensity()
    {
        if(isOn()){
            intensity =intensity-1;
            if(intensity<MIN)
            {
                intensity=MIN;
                switchOff();
            }
        }
        else
             JOptionPane.showMessageDialog(null,"Please switch Light On");

    }
    public void upperIntensity()
    {
        if(!isOn()){
        switchOn();
        intensity=intensity+1;
        if(intensity>=MAX){
           intensity=MAX;
        }
        }
        else{
         intensity=intensity+1;
        if(intensity>=MAX){
           intensity=MAX;
        }
        }
     }
    public int getIntensity()
    {
        return intensity;
    }
   public String toString()
   {

       return super.toString()+getIntensity();
    }
}
