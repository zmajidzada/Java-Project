/**
 * Created by IntelliJ IDEA.
 * User: zmajidzada
 * Date: 26-Mar-2010
 * Time: 11:12:59
 * To change this template use File | Settings | File Templates.
 */
public class Garage extends Door {

    private boolean open;

    public Garage(String name) {
        super(name);
        open = !isLocked();

    }

     public void unlockDoor() {
        super.unlockDoor();
         openDoor();
    }

    public String toString() {
        return super.toString();
    }


}
