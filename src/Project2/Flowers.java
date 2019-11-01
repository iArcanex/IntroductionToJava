package Project2;

import javax.swing.*;
import java.awt.*;

/**Flowers Project
 *CSci 1130-91
 */

public class Flowers extends JApplet {

    public void paint(Graphics g) {
        super.paint(g);

        // Casting Graphics + Antialiasing
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        //Image Background
        Image Background = getImage(getCodeBase(), "SpookyForest.jpg");
        g2d.drawImage(Background, 0, 0, this);

        //Colors

            //Shadow Black
            Color ShadowBlack = new Color(0f, 0f, 0f, .5f);

            //Soul Blue + Shadow
            Color SoulBlue = new Color(128, 191, 255);
            Color SoulBlueSW = new Color(51, 153, 255);

            //Pale Green + Shadow
            Color PaleGreen = new Color(102,204,153);
            Color PaleGreenSW = new Color(45,134,89);

            //GhostWhite + Shadow
            Color GhostWhite = new Color(242,242,242);
            Color GhostWhiteSW = new Color(204,204,204);

            //HotPink + Shadow
            Color HotPink = new Color(255,0,128);
            Color HotPinkSW = new Color(204,0,102);

            //DeepBlue + Shadow
            Color DeepBlue = new Color(0,153,255);
            Color DeepBlueSW = new Color(0,107,179);

        //Fonts

            //Title Font
            Font TitleFont = new Font("SansSerif", Font.BOLD, 42);

            //Header Font
            Font HeaderFont = new Font("SansSerif", Font.BOLD, 20);

            //Paragraph Font
            Font ParagraphFont = new Font("SansSerif", Font.BOLD, 12);

        //Title
        g.setColor(ShadowBlack);
        g2d.fillRoundRect(getWidth()/2-500,10,1000,100, 20 ,20);

        g2d.setFont(TitleFont);

        g2d.setColor(SoulBlueSW);
        g2d.drawString("The Forbidden Forest's Flora", getWidth()/2-275, 78);

        g2d.setColor(SoulBlue);
        g2d.drawString("The Forbidden Forest's Flora", getWidth()/2-275, 75);

      //Flowers

       //Soul Bulb

        //Background
        g.setColor(ShadowBlack);
        g2d.fillRoundRect(getWidth()/2-572,115,572,275, 20 ,20);

        //Header
        g2d.setFont(HeaderFont);
        g2d.setColor(SoulBlue);
        g2d.drawString("Soul Bulb", 572/2-15, 145);

        //Paragraph
        g2d.setFont(ParagraphFont);
        g2d.setColor(SoulBlue);
        g2d.drawString("The Soul Bulb, also known as Genus Soulus▬", 572/2+15, 170);
        g2d.drawString("Bulbosus, emits an eery light of blue wavelengths.", 572/2+15, 185);
        g2d.drawString("This light produces a soothing effect to those who", 572/2+15, 200);
        g2d.drawString("do view it, however it does not come without", 572/2+15, 215);
        g2d.drawString("repercussions. Ten seconds into begin entranced", 572/2+15, 230);
        g2d.drawString("by the delicate light does the affected being to", 572/2+15, 245);
        g2d.drawString("feel a need to consume the flower. In doing so,", 572/2+15, 260);
        g2d.drawString("the affected undergo an eternal slumber in order", 572/2+15, 275);
        g2d.drawString("to become a flowerbed for the new sproutlings to", 572/2+15, 290);
        g2d.drawString("come. Scientists have discovered that the bulb of", 572/2+15, 305);
        g2d.drawString("the flower may be removed and used as a tool", 572/2+15, 320);
        g2d.drawString("as an alternative to sedation. Venturing into the", 572/2+15, 335);
        g2d.drawString("forest to procure these bulbs proves to be its", 572/2+15, 350);
        g2d.drawString("own risk. Who dares enter the Forbidden Forest,", 572/2+15, 365);
        g2d.drawString("especially when it's riddled with these flowers?", 572/2+15, 380);

        //Flower
        g2d.setColor(PaleGreenSW);
        g2d.fillRect(572/2-125,300,10,50);
        g2d.setColor(PaleGreen);
        g2d.fillOval(572/2-130,310,20,20);
        g2d.setColor(PaleGreen);
        g2d.fillRoundRect(572/2-145,270,50,50,20,20);
        g2d.setColor(SoulBlueSW);
        g2d.fillOval(572/2-170,200,100,100);
        g2d.setColor(SoulBlue);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawLine(90,150,120,190);
        g2d.drawLine(80,180,110,210);
        g2d.drawLine(50,200,100,230);
        g2d.fillOval(572/2-170,200,90,90);
        g2d.setColor(SoulBlueSW);
        g2d.fillOval(572/2-170,200,70,70);
        g2d.setColor(SoulBlue);
        g2d.fillOval(572/2-165,205,40,40);
        g2d.setColor(PaleGreenSW);
        g2d.fillArc(572/2-190,270,150,100,-10,75);
        g2d.fillArc(572/2-200,270,150,100,-245,75);
        g2d.setColor(PaleGreen);
        g2d.fillArc(572/2-190,270,150,100,-10,10);
        g2d.fillArc(572/2-200,270,150,100,-180,10);


       //Toxic Marshmallows

        //Background
        g.setColor(ShadowBlack);
        g2d.fillRoundRect(getWidth()/2-572,395,572,275, 20 ,20);

        //Header
        g2d.setFont(HeaderFont);
        g2d.setColor(SoulBlue);
        g2d.drawString("Toxic Marshmallows", 572/2-70, 420);

        //Paragraph
        g2d.setFont(ParagraphFont);
        g2d.setColor(SoulBlue);
        g2d.drawString("Throughout the Forbidden Forest, there rest very", 572/2+15, 445);
        g2d.drawString("unique flora, and of all of them, the horrific Toxic", 572/2+15, 460);
        g2d.drawString("Marshmallows take the prize for the most elusive.", 572/2+15, 475);
        g2d.drawString("Only located snug within the corners you least", 572/2+15, 490);
        g2d.drawString("expect, the moment physical contact is initiated,", 572/2+15, 505);
        g2d.drawString("the small white mallows seek blood and cling onto", 572/2+15, 520);
        g2d.drawString("any surface with atom-sized microfibers. They", 572/2+15, 535);
        g2d.drawString("exhibit a surprising grip force for their size", 572/2+15, 550);
        g2d.drawString("and stick onto surfaces like velcro. Meanwhile,", 572/2+15, 565);
        g2d.drawString("digestion occurs where they are attached to,", 572/2+15, 580);
        g2d.drawString("with the duration depending upon the material.", 572/2+15, 595);
        g2d.drawString("Simultaneously, spores are released to replenish", 572/2+15, 610);
        g2d.drawString("the population. Eventually the mallows swell red", 572/2+15, 625);
        g2d.drawString("and vaporize into toxic gas that ensure their prey", 572/2+15, 640);
        g2d.drawString("nourishes their kind. Thus, they are to avoid.", 572/2+15, 655);

        //Flower
        g2d.setColor(GhostWhiteSW);
        g2d.setStroke(new BasicStroke(5));
        g2d.drawArc(572/2-175,490,50,50,80,180);
        g2d.drawArc(572/2-105,540,50,50,0,270);
        g2d.drawArc(572/2-145,590,50,50,-45,270);
        g2d.setColor(GhostWhite);
        g2d.fillRoundRect(572/2-115,520,50,40,20,20);
        g2d.setColor(GhostWhiteSW);
        g2d.fillRoundRect(572/2-115,540,50,40,20,20);
        g2d.setColor(GhostWhite);
        g2d.fillRoundRect(572/2-165, 510,50,40,20,20);
        g2d.setColor(GhostWhiteSW);
        g2d.fillRoundRect(572/2-165, 530,50,40,20,20);
        g2d.setColor(GhostWhite);
        g2d.fillRoundRect(572/2-145, 560,50,40,20,20);
        g2d.setColor(GhostWhiteSW);
        g2d.fillRoundRect(572/2-145, 580,50,40,20,20);

       //Pick-Me-Not

        //Background
        g.setColor(ShadowBlack);
        g2d.fillRoundRect(getWidth()/2+5,115,572,275, 20 ,20);

        //Header
        g2d.setFont(HeaderFont);
        g2d.setColor(SoulBlue);
        g2d.drawString("Pick-Me-Not", 858-15, 145);

        //Paragraph
        g2d.setFont(ParagraphFont);
        g2d.setColor(SoulBlue);
        g2d.drawString("The epitome of envy and lust, the Pick-Me-Not saps", 858+15, 170);
        g2d.drawString("the life of those unfortunate who've picked her.", 858+15, 185);
        g2d.drawString("Bearing immense beauty, those who take a peek", 858+15, 200);
        g2d.drawString("upon her exquisite form naturally wish to pick", 858+15, 215);
        g2d.drawString("her, but as their fingers curl around her pink", 858+15, 230);
        g2d.drawString("stem, thorns of hate pierce the unlucky and", 858+15, 245);
        g2d.drawString("the flower wraps its stems onto her host.", 858+15, 260);
        g2d.drawString("The flower then grows exponentially leading to", 858+15, 275);
        g2d.drawString("growing its rosy buds upon the paralyzed trekker.", 858+15, 290);
        g2d.drawString("Slowly turning into a rose-ridden dryad, the", 858+15, 305);
        g2d.drawString("picker becomes the picked and loses all rationality.", 858+15, 320);
        g2d.drawString("The Rose Dryad then wanders throughout the forest", 858+15, 335);
        g2d.drawString("tracking prey and leaving behind the seeds of", 858+15, 350);
        g2d.drawString("despair. Rose Dryads are said to be immortal,", 858+15, 365);
        g2d.drawString("yet would you risk your mind for such a gift?", 858+15, 380);

        //Flower
        g2d.setStroke(new BasicStroke(2));

        //Petals
        g2d.setColor(HotPinkSW);
        g2d.setColor(HotPink);
        g2d.fillOval(690,195,80,80);
        g2d.fillOval(705,210,50,50);
        g2d.setColor(HotPinkSW);
        g2d.fillOval(710,215,40,40);
        g2d.drawOval(705,210,50,50);
        g2d.setColor(HotPinkSW);
        g2d.fillOval(700,205,60,60);
        g2d.setColor(HotPink);
        g2d.fillOval(710,215,40,40);
        g2d.setColor(HotPinkSW);
        g2d.fillOval(700,205,60,60);
        Polygon Petals = new Polygon();
        Petals.addPoint(720,220);
        Petals.addPoint(700,220);
        Petals.addPoint(680,170);
        Petals.addPoint(720,220);
        g2d.fillPolygon(Petals);
        Polygon Petals2 = new Polygon();
        Petals2.addPoint(760,270);
        Petals2.addPoint(750,270);
        Petals2.addPoint(730,220);
        Petals2.addPoint(780,280);
        g2d.fillPolygon(Petals2);

        //Stem
        g2d.setColor(HotPinkSW);
        g2d.fillRect(858-130,235,5,100);
        g2d.setColor(HotPink);
        g2d.drawRect(858-130,235,5,100);
        g2d.setColor(HotPinkSW);
        g2d.fillOval(725,230,10,10);
        g2d.setColor(HotPink);
        g2d.drawOval(725,230,10,10);


        //Pointy End
        Polygon End = new Polygon();
        End.addPoint(729,336);
        End.addPoint(732,336);
        End.addPoint(730,345);
        g2d.drawPolygon(End);
        g2d.setColor(HotPinkSW);
        g2d.fillPolygon(End);


       //Millennial Mushroom

        //Background
        g.setColor(ShadowBlack);
        g2d.fillRoundRect(getWidth()/2+5,395,572,275, 20 ,20);

        //Header
        g2d.setFont(HeaderFont);
        g2d.setColor(SoulBlue);
        g2d.drawString("Millennial Mushroom", 858-70, 420);

        //Paragraph
        g2d.setFont(ParagraphFont);
        g2d.setColor(SoulBlue);
        g2d.drawString("Underneath the Forbidden Forest lies catacombs of", 858+15, 445);
        g2d.drawString("old. Eras past and only the Millennial Mushrooms", 858+15, 460);
        g2d.drawString("remain. Such a historic mushroom has seen the", 858+15, 475);
        g2d.drawString("birth of this mysterious forest. Yet it's pale", 858+15, 490);
        g2d.drawString("blue shade, isn't what shows its sorrow. Spores", 858+15, 505);
        g2d.drawString("are constantly released from the Mushroom in the", 858+15, 520);
        g2d.drawString("effort of reproduction, however life is not so", 858+15, 535);
        g2d.drawString("generous. The Millennial Mushrooms are found", 858+15, 550);
        g2d.drawString("sparsely underneath the forest, as reasoning", 858+15, 565);
        g2d.drawString("suggests only few mushrooms grow every millennia", 858+15, 580);
        g2d.drawString("where only less than 1% of their spores may survive.", 858+15, 595);
        g2d.drawString("Interestingly enough, the mushroom shows signs of", 858+15, 610);
        g2d.drawString("sentience as noises of bickering and movement are", 858+15, 625);
        g2d.drawString("present when the mushrooms make themselves", 858+15, 640);
        g2d.drawString("aware. What mysteries could they have foretold?", 858+15, 655);

        //Flower
        g2d.setColor(DeepBlueSW);
        g2d.fillRect(719,495,25,110);
        g2d.fillOval(719,510,35,20);
        g2d.fillOval(708,515,15,15);
        g2d.fillOval(709,540,45,50);
        g2d.setColor(DeepBlue);
        g2d.fillArc(670,450,125,100,0,180);
        g2d.setColor(DeepBlueSW);
        g2d.fillRoundRect(670,499,125,10,20,20);
        g2d.setColor(DeepBlue);
        g2d.fillRoundRect(670,495,125,10,20,20);
        g2d.drawLine(725,555,725,575);
        g2d.drawLine(739,555,739,575);



    }

}
