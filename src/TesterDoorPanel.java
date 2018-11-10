import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: zmajidzada
 * Date: 08-Apr-2010
 * Time: 19:44:28
 * To change this template use File | Settings | File Templates.
 */
public class TesterDoorPanel {


    public static void main(String args[])
    {
        JTabbedPane tabbedPane=new JTabbedPane();
        tabbedPane.addTab("Door",new DoorPanel(new House()));
        JFrame f=new JFrame("Test");
        f.add(tabbedPane);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setSize(800,600);
        f.setVisible(true);
    }


}
