import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: zmajidzada
 * Date: 08-Apr-2010
 * Time: 19:06:30
 * To change this template use File | Settings | File Templates.
 */
public class KitchenShoppingPanelTester {
    public static void main(String[]args){
        JTabbedPane tab=new JTabbedPane();
        tab.addTab("Shopping List",new KitchenShoppingPanel());
        JFrame frame=new JFrame("Test");
        frame.add(tab);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setVisible(true);

    }
}
