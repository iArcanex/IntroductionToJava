package Project1;

import javax.swing.*;
import java.awt.*;

/**Poem Project
 *CSci 1130-91
 */

public class Poem extends JApplet {

    public void paint(Graphics g) {

        super.paint(g);
        Image img=getImage(getCodeBase(), "garden.jpg");
        g.drawImage(img, 0, 0, this);
        g.setColor(Color.GREEN);
        g.drawString("An old silent pond...", 10, 15);
        g.setColor(Color.WHITE);
        g.drawString("A frog jumps into the pond,", 10, 30);
        g.setColor(Color.GREEN);
        g.drawString("splash! Silence again.", 10, 45);
        g.drawString("", 10, 60);
        g.setColor(Color.ORANGE);
        g.drawString("Autumn moonlight▬", 10, 75);
        g.setColor(Color.WHITE);
        g.drawString("a worm digs silently", 10, 90);
        g.setColor(Color.RED);
        g.drawString("into the chestnut.", 10, 105);
        g.drawString("", 10, 120);
        g.setColor(Color.MAGENTA);
        g.drawString("In the twilight rain", 10, 135);
        g.setColor(Color.WHITE);
        g.drawString("these brilliant-hued hibiscus▬", 10, 150);
        g.setColor(Color.MAGENTA);
        g.drawString("A lovely sunset.", 10, 165);
        g.drawString("", 10, 180);
        g.setColor(Color.CYAN);
        g.drawString("▬ Matsuo Basho", 10, 190);

    }

}
