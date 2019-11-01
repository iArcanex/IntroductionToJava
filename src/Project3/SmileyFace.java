package Project3;

import javax.swing.*;
import java.awt.*;

/**SmileyFace Project
 *CSci 1130-91
 */

public class SmileyFace extends JApplet {

    // Instanced Variables
    int min, max, size, locX, locY;
    Graphics2D g2d;

    public void init(){

        min = 50;
        max = 300;
        size = min+(int)(Math.random()*(max-min))+1;
        locX = (int) (Math.random() * (getWidth() - size)) + 1;
        locY = (int) (Math.random() * (getHeight() - size)) + 1;
        getContentPane().setBackground(Color.lightGray);

    }

    public void paint(Graphics g) {

        super.paint(g);

        // Casting Graphics + Antialiasing
        g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        // Call to method which calls all five faces (might be redundant, but I think it looks cleaner + the name)
        releaseTheKrakens();
        
    }

    public void releaseTheKrakens() {

        newFace(min, max);
        drawSmileyFace(locX, locY, size, size, randomRGB(), randomRGB(), randomRGB(), g2d);

        newFace(min, max);
        drawSmileyFace(locX, locY, size, size, randomRGB(), randomRGB(), randomRGB(), g2d);

        newFace(min, max);
        drawSmileyFace(locX, locY, size, size, randomRGB(), randomRGB(), randomRGB(), g2d);

        newFace(min, max);
        drawSmileyFace(locX, locY, size, size, randomRGB(), randomRGB(), randomRGB(), g2d);

        newFace(min, max);
        drawSmileyFace(locX, locY, size, size, randomRGB(), randomRGB(), randomRGB(), g2d);

        return;
    }

    public Color randomRGB() {

        int red=(int)(Math.random()*256);
        int green=(int)(Math.random()*256);
        int blue=(int)(Math.random()*256);

        Color random = new Color(red, green, blue);

        g2d.setColor(random);
        return random;

    }

    public void newFace(int minSize, int maxSize){

        min = minSize;
        max = maxSize;

        size = min+(int)(Math.random()*(max-min))+1;
        locX = (int) (Math.random() * (getWidth() - size)) + 1;
        locY = (int) (Math.random() * (getHeight() - size)) + 1;

    }

    public void drawSmileyFace(int locX, int locY, int h, int w, Color headColor, Color eyeColor, Color smileColor, Graphics2D g2d) {

        // Head
        g2d.setColor(headColor);
        g2d.fillOval(locX, locY, h, w);

        // Left Eye
        g2d.setColor(eyeColor);
        g2d.fillOval(locX+w/4, locY+h/3, h/10, w/10);

        // Right Eye
        g2d.setColor(eyeColor);
        g2d.fillOval(locX+w/(2)+w/6, locY+h/3, h/10, w/10);

        // Smile
        g2d.setColor(smileColor);
        g2d.fillArc(locX+w/4, locY+h/3, h/2, w/2,-180,180);

    }

}
