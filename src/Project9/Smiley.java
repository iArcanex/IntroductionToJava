package Project9;

import javax.swing.*;
import java.awt.*;

/**Smileys 2 Project
 * CSci 1130-91
 */

public class Smiley extends JPanel {

    private int locX, locY, size;
    private Color faceColor, eyeColor, mouthColor;
    private boolean isSmiling, hasEyebrows;

    public Smiley(int x, int y, int s, Color cF, Color cE, Color cM) {

        locX = x;
        locY = y;
        size = s;
        faceColor = cF;
        eyeColor = cE;
        mouthColor = cM;

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Head
        g2d.setColor(faceColor);
        g2d.fillOval(locX, locY, size, size);

        // Left Eye
        g2d.setColor(eyeColor);
        g2d.fillOval(locX + (size/4), locY + (size/3), size/10, size/10);

        // Right Eye
        g2d.setColor(eyeColor);
        g2d.fillOval(locX + (size/2) + (size/6), locY + (size/3), size/10, size/10);

        if(isSmiling) {

            // Smile
            g2d.setColor(mouthColor);
            g2d.fillArc(locX + (size / 4), locY + (size / 3), size / 2, size / 2, 0, -180);

        }

        else {

            // Frown
            g2d.setColor(mouthColor);
            g2d.fillArc(locX + (size / 4), locY + (size / 2), size / 2, size / 2, 180, -180);

        }

        if(hasEyebrows) {

            g2d.fillRect(locX + (size/4) - (size/22), locY + (size/3) - (size/7), size/6, size/10);
            g2d.fillRect(locX + (size/2) + (size/6) - (size/22), locY + (size/3) - (size/7), size/6, size/10);

        }

        else {

        }

    }

    // Changes smile or frown depending on boolean value
    public void changeMouth(boolean b) {

        if(b) {

            isSmiling = true;

        }

        else {

            isSmiling = false;

        }


    }

    // Paints/removes eyebrows depending on boolean value
    public void paintEyebrows(boolean b) {

        if(b) {

            hasEyebrows = true;

        }

        else {

            hasEyebrows = false;

        }

    }

    // Method to change eye color
    public void eyeColor(Color c) {

        eyeColor = c;

    }

    // Randomizer for coloring the face
    public Color randomRGB() {

        int red=(int)(Math.random()*256);
        int green=(int)(Math.random()*256);
        int blue=(int)(Math.random()*256);

        Color random = new Color(red, green, blue);

        faceColor = random;

        return faceColor;

    }

}
