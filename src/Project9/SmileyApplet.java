package Project9;

import javax.swing.*;
import java.awt.*;

/**Smileys 2 Project
 * CSci 1130-91
 */

public class SmileyApplet extends JApplet {

    BorderLayout border;
    JLabel titleL;
    JPanel titleP, centerP, smileyControlA, smileyControlB, smileyControlC;
    Smiley smileyA, smileyB, smileyC;
    SmileyControls controlA, controlB, controlC;

    public void init() {

        border = new BorderLayout();
        setLayout(border);
        titleSetup();
        centerSetup();

    }

    public void titleSetup() {

        titleP = new JPanel(new FlowLayout());
        titleL = new JLabel("Customize the THREE STOOGES!");

        titleP.add(titleL);
        add(titleP, BorderLayout.NORTH);
    }

    public void centerSetup() {

        centerP = new JPanel(new FlowLayout());

        // Setting up smiley and control JPanels
        smileyControlA = new JPanel(new BorderLayout());
        smileyControlA.setBorder(BorderFactory.createLineBorder(Color.black));

        smileyControlB = new JPanel(new BorderLayout());
        smileyControlB.setBorder(BorderFactory.createLineBorder(Color.black));

        smileyControlC = new JPanel(new BorderLayout());
        smileyControlC.setBorder(BorderFactory.createLineBorder(Color.black));

        // Instantiating objects
        smileySetup();
        controlSetup();

        smileyA.setPreferredSize(new Dimension(100, 150));
        smileyB.setPreferredSize(new Dimension(100, 150));
        smileyC.setPreferredSize(new Dimension(100, 150));

        // Adding Components
        smileyControlA.add(smileyA, BorderLayout.CENTER);
        smileyControlA.add(controlA, BorderLayout.SOUTH);

        smileyControlB.add(smileyB, BorderLayout.CENTER);
        smileyControlB.add(controlB, BorderLayout.SOUTH);

        smileyControlC.add(smileyC, BorderLayout.CENTER);
        smileyControlC.add(controlC, BorderLayout.SOUTH);

        centerP.add(smileyControlA);
        centerP.add(smileyControlB);
        centerP.add(smileyControlC);

        add(centerP, BorderLayout.CENTER);

    }

    public void smileySetup() {

        smileyA = new Smiley(170, 10, 130, Color.YELLOW, Color.BLACK, Color.BLACK);
        smileyB = new Smiley(170, 10, 130, Color.YELLOW, Color.BLACK, Color.BLACK);
        smileyC = new Smiley(170, 10, 130, Color.YELLOW, Color.BLACK, Color.BLACK);

    }

    public void controlSetup() {

        controlA = new SmileyControls(smileyA);
        controlB = new SmileyControls(smileyB);
        controlC = new SmileyControls(smileyC);
    }



}
