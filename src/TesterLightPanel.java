import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: zmajidzada
 * Date: 09-Apr-2010
 * Time: 12:32:50
 * To change this template use File | Settings | File Templates.
 */
public class TesterLightPanel {

    public static void main(String args[])
    {

           JTabbedPane tab=new JTabbedPane();
        tab.addTab("Lights",new LightPanel());
        JFrame frame=new JFrame("Frame");
        frame.add(tab);

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setVisible(true);
      
    }
}
