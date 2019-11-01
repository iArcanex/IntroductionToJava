package Project11.View;

import javax.swing.*;
import java.awt.*;

/**Final Project
 * CSci 1130-91
 */

public class GameMenu extends JPanel {

    BorderLayout border;
    BoxLayout mainBL, titleBL;

    JPanel menuP, titleP;
    JLabel titleL, imageL;

    ImageIcon imageI;

    Font titleFont;

    public GameMenu() {

        // Getting layouts set
        border = new BorderLayout();
        setLayout(border);

        // Menu Panel
        menuP = new JPanel();
        mainBL = new BoxLayout(menuP, BoxLayout.Y_AXIS);
        menuP.setLayout(mainBL);

        // Defining Font
        titleFont = new Font("Helvetica", Font.BOLD, 44);

        // Calling methods to setup JPanel
        titleSetup();


        add(menuP, BorderLayout.CENTER);

    }

    public void titleSetup() {

        // Title Panel
        titleP = new JPanel();
        titleBL = new BoxLayout(titleP, BoxLayout.Y_AXIS);
        titleP.setLayout(titleBL);

        // Instantiating Labels
        titleL = new JLabel("A Basic Maze Game");
        titleL.setFont(titleFont);
        titleL.setAlignmentX(Component.CENTER_ALIGNMENT);

        imageI = new ImageIcon(this.getClass().getResource("maze.png"));
        imageL = new JLabel(imageI);
        imageL.setAlignmentX(Component.CENTER_ALIGNMENT);


        // Adding Components

        Dimension spacer = new Dimension(0, 30);

        titleP.add(titleL);
        titleP.add(Box.createRigidArea(spacer));
        titleP.add(imageL);
        titleP.add(Box.createRigidArea(spacer));

        add(titleP, BorderLayout.CENTER);
        menuP.add(titleP);

    }
}
