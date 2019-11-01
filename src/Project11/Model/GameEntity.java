package Project11.Model;

import javax.swing.*;
import java.awt.*;

/**Final Project
 * CSci 1130-91
 */

public class GameEntity extends JPanel {

    int locX, locY, width, height;
    GameMap gm;

    public GameEntity(int x, int y, int w, int h) {

        locX = x;
        locY = y;
        height = h;
        width = w;
        gm = new GameMap();

    }

    // Method to move the entity, but it first calls verifyMove()
    // to ensure that the Entity cannot pass through walls
    public void moveEntity(GameMap m, Dimension d, int x, int y) {

        if (verifyMove(m, d, (x + locX), (y + locY))) {

            locX += x;
            locY += y;

        }

    }

    // This method looks at three different boolean values that must ALL be true
    // in order for the entity to move. It looks at both x and y  to verify their
    // values relative to the entity/tiles, especially if the entity is in an array of 0 or not.
    public boolean verifyMove(GameMap m, Dimension d, int x, int y) {

            boolean validateX = (x + width) <= d.getWidth() && x >= 0;
            //System.out.println("Validate X: " + validateX);
            //System.out.println("Validate X-Coord: " + x);
            //System.out.println("Validate Width: " + width);
            //System.out.println("Validate d.getW: " + d.getWidth());
            boolean validateY = (y + height) <= d.getHeight() && y >= 0;
            //System.out.println("Validate Y: " + validateY);
            //System.out.println("Validate Y-Coord: " + y);
            //System.out.println("Validate Height: " + height);
            //System.out.println("Validate d.getH: " + d.getHeight());

            return validateX && validateY && collisionValidation(x, y);

    }

    public boolean collisionValidation(int x, int y) {

        // Looks at the map array and the associated x/y values with their
        // relative shifts. If the array does not equal 0 or 2, then it will return false.
        int [][] map = gm.getMap();

        int rowValue = (y / gm.getTILE_WIDTH());

        if(map[rowValue][ x/gm.getTILE_HEIGHT()] == 2) {

            locX += x;
            locY += y;

            winnerwinnerChickenDinner();

        }

        return map[rowValue][ x/gm.getTILE_HEIGHT()]==0;
    }

    public void winnerwinnerChickenDinner() {

        // Display JOptionPane that will exit the applet.
        String[] options = {"Okay..."};

        int winner = JOptionPane.showOptionDialog(null, "Nice job! You got to the end! GAME OVER!", "YOU WON!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (winner == 0) {

            System.exit(0);

        }

    }


    // Getters to obtain variable data
    public int getLocX() {
        return locX;
    }

    public int getLocY() {
        return locY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


}
