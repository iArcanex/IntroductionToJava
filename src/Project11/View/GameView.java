package Project11.View;

import Project11.Model.GameEntity;
import Project11.Model.GameMap;

import javax.swing.*;
import java.awt.*;

/**Final Project
 * CSci 1130-91
 */

public class GameView extends JPanel {

    GameEntity entity;
    GameMap map;

    public GameView(GameEntity e, GameMap m) {

        entity = e;
        map = m;

        setBackground(Color.LIGHT_GRAY);

    }


    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        // Declaring ints with requisite values for our Entity
        int entityX = entity.getLocX();
        int entityY = entity.getLocY();
        int entityW = entity.getWidth();
        int entityH = entity.getHeight();

        Color entityC = new Color(137, 229, 112);

        g.setColor(entityC);
        g.fillRect(entityX, entityY, entityW, entityH);
        drawMaze(g);

    }

    public void drawMaze(Graphics g) {

        // Array Traversal
        // The loop will keep executing the inner loop for the length of the map array (Columns).
        for (int r = 0; r < map.getMap().length; r++) {

            // The loop will keeping running until the length of the map array (Rows).
            for (int c = 0; c < map.getMap()[r].length; c++) {

                int tileX = c * (map.getTILE_WIDTH());
                int tileY = r * (map.getTILE_HEIGHT());
                int tileW = map.getTILE_WIDTH();
                int tileH = map.getTILE_HEIGHT();

                // Finds barriers vs goal point and paints them
                if (map.getMap()[r][c] == 1) {

                    Color barrierC = new Color(70, 72, 73);
                    g.setColor(barrierC);

                    // Paints the barriers
                    g.fillRect(tileX, tileY, tileW, tileH);

                }

                else if (map.getMap()[r][c] == 2) {

                    Color goalC = new Color(189, 249, 172);
                    g.setColor(goalC);

                    // Paints the goals
                    g.fillRect(tileX, tileY, tileW, tileH);

                }

            }


        }

    }


}
