package Project11;

import Project11.Controller.GameController;
import Project11.Model.GameEntity;
import Project11.Model.GameMap;
import Project11.View.GameMenu;
import Project11.View.GameView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**Final Project
 * CSci 1130-91
 */

public class GameApplet extends JApplet implements ActionListener {

    GameView gameView;
    GameMap gameMap;
    GameEntity gameEntity;
    GameMenu gameMenu;
    GameController gameController;

    GridLayout buttonsGL;

    JPanel buttonsP;
    JLabel controlsL;
    JButton playB, aboutB;

    private int constraintW, constraintH;
    final int ENTITY_X = 0, ENTITY_Y = 200, ENTITY_W = 20, ENTITY_H = 20;

    public void init() {

        buttonSetup();

        constraintW = getWidth();
        constraintH = getHeight();

        gameEntity = new GameEntity(ENTITY_X, ENTITY_Y, ENTITY_W, ENTITY_H);
        gameMap = new GameMap();

        gameView = new GameView(gameEntity, gameMap);
        gameController = new GameController(gameEntity, gameView, constraintW, constraintH);

        gameMenu = new GameMenu();
        add(gameMenu, BorderLayout.CENTER);


    }

    public void buttonSetup() {

        // Buttons Panel
        buttonsP = new JPanel();
        buttonsGL = new GridLayout(1, 2);
        buttonsP.setLayout(buttonsGL);

        // Instantiating Components
        playB = new JButton("Play!");
        aboutB = new JButton("About");

        controlsL = new JLabel("CONTROLS ▬ W/UP: GO UP, D/DOWN: GO DOWN, A/LEFT: GO LEFT, D/RIGHT: GO RIGHT, ESC - Exit", SwingConstants.CENTER);

        playB.addActionListener(this);
        aboutB.addActionListener(this);

        // Adding Components
        buttonsP.add(playB);
        buttonsP.add(aboutB);

        add(buttonsP, BorderLayout.SOUTH);


    }

    public void changePanels() {

        // Removes gameMenu Panel
        remove(gameMenu);

        // Adjust buttonsP to portray controls
        buttonsP.remove(playB);
        buttonsP.remove(aboutB);
        buttonsP.add(controlsL);

        // Adds gameView to the equation
        add(gameView, BorderLayout.CENTER);
        gameView.requestFocus();

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == playB) {

            changePanels();

            revalidate();
            repaint();
        }

        if (e.getSource() == aboutB) {

            JOptionPane.showMessageDialog(this, "This is an example of a simple Maze Game" +
                    "\nmade by using Arrays, Swing and AWT.", "About", JOptionPane.INFORMATION_MESSAGE);

        }

    }
}
