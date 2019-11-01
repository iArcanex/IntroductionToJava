package Project6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**TrafficLight Project
 * CSci 1130-91
 */

public class TrafficLight extends JApplet implements ActionListener {

    // Instance Variables
    JLabel titleL;
    JButton goB, slowB, stopB;
    JPanel titleP, buttonP;
    BorderLayout border;
    Color lightGo, lightSlow, lightStop, trafficB, trafficF;
    Graphics2D g2d;

    public void init() {

        // Set Colors
        lightStop = new Color(168,0,0);
        lightSlow = new Color(168,154,0);
        lightGo = new Color(0,140,11);
        trafficB = new Color(59,61,66);
        trafficF = new Color(91,95,102);

        border = new BorderLayout();
        setLayout(border);
        configureGUI();
        registerListeners();
        addTrafficLight();

    }

    public void paint (Graphics g) {

        super.paint(g);

        // Casting Graphics to g2d
        g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        paintTrafficLight();

    }

    public void paintTrafficLight() {

        // Traffic light

        g2d.setColor(trafficB);
        g2d.fillRect(getWidth()/2-100,getHeight()/2-250,200,500);
        g2d.fillRoundRect(getWidth()/2-1000, getHeight()/2-200,2000,20,10,10);
        g2d.fillRoundRect(getWidth()/2+90, getHeight()/2+200,100,20,10,10);
        g2d.fillRoundRect(getWidth()/2+170, getHeight()/2-200,20,420,10,10);

        g2d.setColor(trafficF);
        g2d.fillRect(getWidth()/2-100,getHeight()/2-240,200,500);

        g2d.setStroke(new BasicStroke(10));

        // Green Light

        g2d.setColor(lightGo);
        g2d.fillOval(getWidth()/2-78,getHeight()/2+(78), 156,156);

        g2d.setColor(new Color(59,61,66));
        g2d.drawArc(getWidth()/2-80,getHeight()/2+(80),160,160,0,180);

        // Yellow Light

        g2d.setColor(lightSlow);
        g2d.fillOval(getWidth()/2-78,getHeight()/2+(78-176), 156,156);

        g2d.setColor(new Color(59,61,66));
        g2d.drawArc(getWidth()/2-80,getHeight()/2+(80-176),160,160,0,180);

        // Red Light

        g2d.setColor(lightStop);
        g2d.fillOval(getWidth()/2-78,getHeight()/2+(78-350), 156,156);

        g2d.setColor(new Color(59,61,66));
        g2d.drawArc(getWidth()/2-80,getHeight()/2+(80-350),160,160,0,180);

    }

    public void configureGUI() {

        // Setting up the JPanels
        titleP = new JPanel();
        buttonP = new JPanel();

        titleP.setLayout(new FlowLayout());
        buttonP.setLayout(new FlowLayout());

        // Defining variables
        titleL = new JLabel("<html>TRAFFIC LIGHT CONTROL STATION<br/>Please press a button to change the lights.</html>", SwingConstants.CENTER);
        goB = new JButton("Go! [GREEN]");
        slowB = new JButton("Slow down! [YELLOW]");
        stopB = new JButton("Stop! [RED]");


    }

    public void addTrafficLight() {

        add(titleP, BorderLayout.NORTH);
        add(buttonP, BorderLayout.SOUTH);

        titleP.add(titleL);

        buttonP.add(goB);
        buttonP.add(slowB);
        buttonP.add(stopB);

    }

    public void registerListeners() {

        goB.addActionListener(this);
        slowB.addActionListener(this);
        stopB.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == goB) {

            lightStop = new Color(168,0,0);
            lightSlow = new Color(168,154,0);
            lightGo = Color.GREEN;
            repaint();

        }

        if (e.getSource() == slowB) {

            lightStop = new Color(168,0,0);
            lightGo = new Color(0,140,11);
            lightSlow = Color.YELLOW;
            repaint();

        }

        if (e.getSource() == stopB) {

            lightSlow = new Color(168,154,0);
            lightGo = new Color(0,140,11);
            lightStop = Color.RED;
            repaint();

        }

    }

}
