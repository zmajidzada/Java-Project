import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.TimerTask;
import java.util.Timer;

/**
 * Created by IntelliJ IDEA.
 * User: zmajidzada
 * Date: 08-Apr-2010
 * Time: 20:38:47
 * To change this template use File | Settings | File Templates.
 */
public class LightPanel extends JPanel {

    private Light light;
    private DimmableLight dimLight;
    private JButton onButton;
    private JButton offButton;
    private JButton onTimerButton;
    private JButton offTimerButton;
    private JLabel lightStatusLabel;
    private JLabel lightName;
    private Timer timer;
    private JLabel dimmableLightLabel;
    private JButton onDimmableLightButton;
    private JButton offDimableLightButton;
    private JButton brightButton;
    private JButton darkButton;
    private JLabel dimLightStatusLabel;


    public LightPanel() {
        timer = new Timer();
        light = new Light();
        dimLight = new DimmableLight();

        GridBagConstraints c = new GridBagConstraints();

        JPanel panel = new JPanel(new GridBagLayout());
        lightName = new JLabel();
        lightName.setText("Sitting Room Light");
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 0, 0);
        panel.add(lightName, c);

        onButton = new JButton("Turn On Light");
        onButton.addActionListener(new Handler());
        c.gridx = 1;
        c.gridy = 0;
        panel.add(onButton, c);

        offButton = new JButton("Turn Off Light");
        offButton.addActionListener(new Handler());
        c.gridx = 2;
        c.gridy = 0;
        panel.add(offButton, c);
        lightStatusLabel = new JLabel();
        lightStatusLabel.setText(light.toString());
        c.gridx = 3;
        c.gridy = 0;
        panel.add(lightStatusLabel, c);

        onTimerButton = new JButton("On By Timer");
        onTimerButton.addActionListener(new Handler());
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(10, 0, 0, 0);

        panel.add(onTimerButton, c);
        offTimerButton = new JButton("Off By Timer ");
        offTimerButton.addActionListener(new Handler());
        c.gridx = 2;
        c.gridy = 1;
        panel.add(offTimerButton, c);

        dimmableLightLabel=new JLabel("Dimable Light");
        c.gridx=0;
        c.gridy=3;
        panel.add(dimmableLightLabel,c);

        brightButton=new JButton("Bright");
        brightButton.addActionListener(new Handler());
        c.gridx=1;
        c.gridy=3;
        panel.add(brightButton,c);
        darkButton=new JButton("Dark");
        darkButton.addActionListener(new Handler());
        c.gridx=2;
        c.gridy=3;
        panel.add(darkButton,c);

        dimLightStatusLabel=new JLabel();
        c.gridx=3;
        c.gridy=3;
        panel.add(dimLightStatusLabel,c);
        add(panel);

    }

    class Handler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source == onButton) {
                light.switchOn();
                dimLight.switchOn();
                lightStatusLabel.setText(light.toString());
                dimLightStatusLabel.setText(dimLight.toString());
                //onButton.setVisible(true);
                //  offButton.setVisible(false);
            }

            if (source == offButton) {
                light.switchOff();
                lightStatusLabel.setText(light.toString());
                // offButton.setVisible(true);
                //  onButton.setVisible(false);
            }
                
            if (source == onTimerButton) {

                int time = Integer.parseInt(JOptionPane.showInputDialog("", " Enter the Tinme in seconds"));
                timer.schedule(new TimedSwitchOnLight(), time * 1000);
            }
            if (source == offTimerButton) {

                int time = Integer.parseInt(JOptionPane.showInputDialog("", " Enter the Tinme in seconds"));
                timer.schedule(new TimedSwitchOffLight(), time * 1000);
            }
            if(source==brightButton)
            {

                dimLight.upperIntensity();
                dimLightStatusLabel.setText(dimLight.toString());

            }
             if(source==darkButton)
            {

                dimLight.lowIntensity();
                dimLightStatusLabel.setText(dimLight.toString());

            }
        }
    }

    class TimedSwitchOnLight extends TimerTask {
        public void run() {
            light.switchOn();

            lightStatusLabel.setText(light.toString());
        }
    }

    class TimedSwitchOffLight extends TimerTask {
        public void run() {
            light.switchOff();

            lightStatusLabel.setText(light.toString());
        }
    }
}