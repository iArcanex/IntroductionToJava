package Project4;

import javax.swing.*;
import java.awt.*;

/**Distances Project
 * CSci 1130-91
 */

public class Distances extends JApplet {

    // Instanced Variables

    int p1_X, p1_Y, p2_X, p2_Y, p3_X, p3_Y, p4_X, p4_Y;
    double distance_L1, distance_L2;
    String p1_locX, p1_locY, p2_locX, p2_locY, p3_locX, p3_locY, p4_locX, p4_locY;
    Graphics2D g2d;

    public void init() {

        getUserInputs();
        convertUserInputs();
        getContentPane().setBackground(Color.WHITE);

    }

    public void paint(Graphics g){

        super.paint(g);

        // Casting Graphics + Antialiasing
        g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        // Lines are drawn and strings are painted from these two methods
        drawLines(p1_X, p1_Y, p2_X, p2_Y, p3_X, p3_Y, p4_X, p4_Y);
        drawStrings();




    }

    public void drawLines(int p1_X, int p1_Y, int p2_X, int p2_Y, int p3_X, int p3_Y, int p4_X, int p4_Y) {

        // Draws Line One
        g2d.setColor(Color.RED);
        g2d.drawLine(p1_X, p1_Y, p2_X, p2_Y);

        // Draws Line Two
        g2d.setColor(Color.BLUE);
        g2d.drawLine(p3_X, p3_Y, p4_X, p4_Y);

    }
    
    public void drawStrings() {

        // Draws Point One Line One String
        g2d.setColor(Color.RED);
        g2d.drawString("Point 1 Line 1" + " " +"(" + p1_locX + "," + p1_locY + ")", p1_X + 10, p1_Y + -1);

        // Draws Point Two Line One String
        g2d.setColor(Color.RED);
        g2d.drawString("Point 2 Line 1" + " " +"(" + p2_locX + "," + p2_locY + ")", p2_X + 10, p2_Y + -1);

        // Draws Point Three Line Two String
        g2d.setColor(Color.BLUE);
        g2d.drawString("Point 3 Line 2" + " " +"(" + p3_locX + "," + p3_locY + ")", p3_X + 10, p3_Y + -1);

        // Draws Point Four Line Two String
        g2d.setColor(Color.BLUE);
        g2d.drawString("Point 4 Line 2" + " " +"(" + p4_locX + "," + p4_locY + ")", p4_X + 10, p4_Y + -1);

        // Calls method that calculates distances and paints the information to the applet
        measureDistances();
        
    }

    public boolean measureDistances() {

        // Distance Equation for Line One
        distance_L1 = Math.abs(Math.sqrt( Math.pow(p2_X-p1_X, 2) + Math.pow(p2_Y-p1_Y, 2)));

        // Distance Equation for Line Two
        distance_L2 = Math.abs(Math.sqrt( Math.pow(p4_X-p3_X, 2) + Math.pow(p4_Y-p3_Y, 2)));

        // Calculation of the Difference between both lines
        double difference = Math.abs(distance_L2-distance_L1);

        // Boolean with If or Else Statements
        boolean result = distance_L1 > distance_L2;

        if(result) {

            // If activates when true
            g2d.setColor(Color.RED);
            g2d.drawString("Line One's Distance:" + " " + distance_L1, 10, 600);
            g2d.setColor(Color.BLUE);
            g2d.drawString("Line Two's Distance:" + " " + distance_L2, 10, 615);
            g2d.setColor(Color.BLACK);
            g2d.drawString("Line One is longer and has a distance greater than line two by:" + " " + difference, 10, 630);

        }

        else {

            // Else activates when false
            g2d.setColor(Color.RED);
            g2d.drawString("Line One's Distance:" + " " + distance_L1, 10, 600);
            g2d.setColor(Color.BLUE);
            g2d.drawString("Line Two's Distance:" + " " + distance_L2, 10, 615);
            g2d.setColor(Color.BLACK);
            g2d.drawString("Line Two is longer and has a distance greater than line one by:" + " " + difference, 10,630);

        }

        return result;
    }

    public void getUserInputs() {

        // Line One Points
        p1_locX = JOptionPane.showInputDialog(this, "Line One - Point One - Input x coordinate:");
        p1_locY = JOptionPane.showInputDialog(this, "Line One - Point One - Input y coordinate:");
        p2_locX = JOptionPane.showInputDialog(this, "Line One - Point Two - Input x coordinate:");
        p2_locY = JOptionPane.showInputDialog(this, "Line One - Point Two - Input y coordinate:");

        // Line Two Points
        p3_locX = JOptionPane.showInputDialog(this, "Line Two - Point Three - Input x coordinate:");
        p3_locY = JOptionPane.showInputDialog(this, "Line Two - Point Three - Input y coordinate:");
        p4_locX = JOptionPane.showInputDialog(this, "Line Two - Point Four - Input x coordinate:");
        p4_locY = JOptionPane.showInputDialog(this, "Line Two - Point Four - Input y coordinate:");
    }
    
    public void convertUserInputs() {

        // Line One - Point One
        p1_X = Integer.parseInt(p1_locX);
        p1_Y = Integer.parseInt(p1_locY);

        // Line One - Point Two
        p2_X = Integer.parseInt(p2_locX);
        p2_Y = Integer.parseInt(p2_locY);

        // Line Two - Point One
        p3_X = Integer.parseInt(p3_locX);
        p3_Y = Integer.parseInt(p3_locY);

        // Line Two - Point Two
        p4_X = Integer.parseInt(p4_locX);
        p4_Y = Integer.parseInt(p4_locY);

    }

}
