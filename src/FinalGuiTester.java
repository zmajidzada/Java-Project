import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: zmajidzada
 * Date: 08-Apr-2010
 * Time: 21:15:41
 * To change this template use File | Settings | File Templates.
 */
public class FinalGuiTester {
                                               
    public static void main(String args[])
    {
        House house = new House();
        JTabbedPane tab=new JTabbedPane();
        tab.addTab("Shopping List",new KitchenShoppingPanel());
        tab.addTab("Door",new DoorPanel(house));
        tab.addTab("Light",new LightPanel());
        tab.addTab("Alarm", new AlarmPanel(house));

        JFrame frame=new JFrame("MY Frame");
        frame.add(tab);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setVisible(true);
    }
}
