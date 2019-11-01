package Project11.Controller;

import Project11.Model.GameEntity;
import Project11.Model.GameMap;
import Project11.View.GameView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**Final Project
 * CSci 1130-91
 */

public class GameController extends JPanel implements KeyListener {

    GameMap map;
    GameEntity player;
    GameView view;

    Dimension pSize;

    public GameController(GameEntity p, GameView f, int w, int h) {

        player = p;
        view = f;

        // Establishing Bounds via Dimension
        Dimension size = new Dimension(w, h);
        pSize = size;
        setPreferredSize(size);

        // Focus ensures inputs are received
        view.setFocusable(true);
        view.addKeyListener(this);

    }


    @Override
    public void keyTyped(KeyEvent e) {

        // If ESC is pressed, game process is terminated.
        if (e.getKeyChar() == 27) {
            System.exit(0);
        }

    }

    @Override
    public void keyPressed(KeyEvent keyE) {

        // Defining dimension for validation and bounds
        Dimension d =  pSize;
        char key = (char)keyE.getKeyCode();
        view.requestFocus();

        // Char characters execute event here
        switch(key) {

            case ('W'):

                System.out.println("Key Press: W"); // For debugging
                player.moveEntity(map, d,0,-20);
                view.revalidate();
                view.repaint();
                break;

            case 'S':

                System.out.println("Key Press: S"); // For debugging
                player.moveEntity(map, d ,0,20);
                view.revalidate();
                view.repaint();
                break;

            case 'A':

                System.out.println("Key Press: A"); // For debugging
                player.moveEntity(map, d, -20,0);
                view.revalidate();
                view.repaint();
                break;

            case 'D':

                System.out.println("Key Press: D"); // For debugging
                player.moveEntity(map, d, 20,0);
                view.revalidate();
                view.repaint();
                break;

        } // Switch Ends

        // Other orthodox inputs execute here

        if (keyE.getKeyCode() == KeyEvent.VK_UP) {

            System.out.println("Key Press: Up"); // For debugging
            player.moveEntity(map, d,0,-20);
            view.revalidate();
            view.repaint();

        }

        if (keyE.getKeyCode() == KeyEvent.VK_DOWN) {

            System.out.println("Key Press: Down"); // For debugging
            player.moveEntity(map, d, 0,20);
            view.revalidate();
            view.repaint();

        }

        if (keyE.getKeyCode() == KeyEvent.VK_LEFT) {

            System.out.println("Key Press: Left <"); // For debugging
            player.moveEntity(map, d, -20,0);
            view.revalidate();
            view.repaint();

        }

        if (keyE.getKeyCode() == KeyEvent.VK_RIGHT) {

            System.out.println("Key Press: Right >"); // For debugging
            player.moveEntity(map, d, 20,0);
            view.revalidate();
            view.repaint();

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        // TODO

    }
}
