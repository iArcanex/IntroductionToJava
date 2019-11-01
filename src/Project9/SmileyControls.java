package Project9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**Smileys 2 Project
 * CSci 1130-91
 */

public class SmileyControls extends JPanel implements ActionListener, ItemListener {

    Smiley smiley;

    GridLayout controlGL, colorFGL, colorEGL, mouthGL, eyebrowsGL;

    JPanel controlP, colorFP, colorEP, mouthP, eyebrowsP;
    JLabel faceCL, eyeCL, mouthL, eyebrowsL;
    JButton randomCB;
    JRadioButton redRB, blueRB, greenRB, smilingRB, frowningRB, ebYRB, ebNRB;

    ButtonGroup colorBTG, mouthBTG, eyebrowsBTG;

    public SmileyControls(Smiley s) {

        smiley = s;
        controlSetup();

    }

    public void controlSetup() {

       // Control Panel
        controlP = new JPanel();
        controlGL = new GridLayout(4,1);
        controlP.setLayout(controlGL);

       // Face Color Panel
        colorFP = new JPanel();
        colorFGL = new GridLayout(1, 2);
        colorFP.setLayout(colorFGL);

        faceCL = new JLabel("Face Color:");
        randomCB = new JButton("Randomize!");

        randomCB.addActionListener(this);

       // Eye Color Panel
        colorEP = new JPanel();
        colorEGL = new GridLayout(1, 4);
        colorEP.setLayout(colorEGL);

        eyeCL = new JLabel("Select Eye Color:       ");
        redRB = new JRadioButton("RED");
        blueRB = new JRadioButton("BLUE");
        greenRB = new JRadioButton("GREEN");

        redRB.addItemListener(this);
        blueRB.addItemListener(this);
        greenRB.addItemListener(this);

        colorBTG = new ButtonGroup();

        colorBTG.add(redRB);
        colorBTG.add(blueRB);
        colorBTG.add(greenRB);


       // Mouth Panel
        mouthP = new JPanel();
        mouthGL = new GridLayout(1, 3);
        mouthP.setLayout(mouthGL);

        mouthL = new JLabel("Mouth is:");
        smilingRB = new JRadioButton("Smiling");
        frowningRB = new JRadioButton("Frowning");

        smilingRB.addItemListener(this);
        frowningRB.addItemListener(this);

        mouthBTG = new ButtonGroup();

        mouthBTG.add(smilingRB);
        mouthBTG.add(frowningRB);


       // Eyebrows Panel
        eyebrowsP = new JPanel();
        eyebrowsGL = new GridLayout(1, 3);
        eyebrowsP.setLayout(eyebrowsGL);
        
        eyebrowsL = new JLabel("Eyebrows?:");
        ebYRB = new JRadioButton("Yes");
        ebNRB = new JRadioButton("No");

        ebYRB.addItemListener(this);
        ebNRB.addItemListener(this);

        eyebrowsBTG = new ButtonGroup();

        eyebrowsBTG.add(ebYRB);
        eyebrowsBTG.add(ebNRB);

      // Adding Panels + Components

        // Face Color Panel
        colorFP.add(faceCL);
        colorFP.add(randomCB);

        // Eye Color Panel
        colorEP.add(eyeCL);
        colorEP.add(redRB);
        colorEP.add(blueRB);
        colorEP.add(greenRB);

        // Mouth Panel
        mouthP.add(mouthL);
        mouthP.add(smilingRB);
        mouthP.add(frowningRB);
        smilingRB.setSelected(true);
        
        // Eyebrows Panel
        eyebrowsP.add(eyebrowsL);
        eyebrowsP.add(ebYRB);
        eyebrowsP.add(ebNRB);
        ebNRB.setSelected(true);

        // Control Panel
        controlP.add(colorFP);
        controlP.add(colorEP);
        controlP.add(mouthP);
        controlP.add(eyebrowsP);

        add(controlP, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if (source == randomCB) {

            smiley.randomRGB();
            smiley.repaint();

        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if (e.getSource() == redRB) {

            smiley.eyeColor(Color.RED);
            smiley.repaint();

        }

        if (e.getSource() == blueRB) {

            smiley.eyeColor(Color.BLUE);
            smiley.repaint();

        }

        if (e.getSource() == greenRB) {

            smiley.eyeColor(Color.GREEN);
            smiley.repaint();

        }

        if (e.getSource() == smilingRB) {

            smiley.changeMouth(true);
            smiley.repaint();

        }

        if (e.getSource() == frowningRB) {

            smiley.changeMouth(false);
            smiley.repaint();

        }

        if (e.getSource() == ebYRB) {

            smiley.paintEyebrows(true);
            smiley.repaint();

        }

        if (e.getSource() == ebNRB) {

            smiley.paintEyebrows(false);
            smiley.repaint();

        }

    }
}
