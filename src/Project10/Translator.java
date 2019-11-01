package Project10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**Translator Project
 * CSci 1130-91
 */

public class Translator extends JApplet implements ActionListener {



    String[]  englishS = {"Sun", "Moon", "Stars", "Earth", "Shadow", "Fire", "Water", "Cat",
                          "Dog", "Deer", "Wolf", "Dragon", "Phoenix", "Love", "Sorrow", "Rock"},
              latinS   = {"Solis", "Luna", "Stellae", "Terra", "Umbra", "Ignis", "Aqua", "Felis",
                          "Canis", "Cervus", "Lupus", "Draco", "Phoenix", "Amare", "Dolorem", "Petram"};
    Image[] imageS;

    String translatedS;
    JButton translateB;
    JTextField englishTF;
    JPanel titleP, imageP, inputP;
    JLabel titleL, englishL, latinL, imgL, translatedL;
    GridLayout inputGL;

    Image currentImage;
    ImageIcon imgIcon;

    public void init() {

        setLayout(new BorderLayout());

        titleSetup();
        imageSetup();
        imagePanelSetup();
        inputSetup();


    }

    public void titleSetup() {

        // Title Panel
        titleP = new JPanel(new FlowLayout());

        // Components
        titleL = new JLabel("Translator: Type a word!");

        // Adding Components
        titleP.add(titleL);

        add(titleP, BorderLayout.NORTH);


    }

    public void imageSetup() {

        imageS = new Image[englishS.length];

        // Traversal
        for(int i = 0; i < englishS.length; i++) {

            imageS[i] = getImage(getCodeBase(), englishS[i] + ".jpg");

        }

        currentImage = getImage(getCodeBase(), "Welcome.jpg");

    }

    public void imagePanelSetup() {

        // Image Panel
        imageP = new JPanel(new FlowLayout());

        // Components
        imgL = new JLabel();
        imgL.setHorizontalAlignment(SwingConstants.CENTER);

        imgIcon = new ImageIcon();
        imgIcon.setImage(currentImage);
        imgL.setIcon(imgIcon);


        // Add
        imageP.add(imgL);

        add(imageP, BorderLayout.CENTER);


    }

    public void inputSetup() {

        // Input Panel
        inputP = new JPanel();
        inputGL = new GridLayout(1,5, 20, 0);
        inputP.setLayout(inputGL);

        // Components
        englishL = new JLabel("English:");
        englishTF = new JTextField(30);

        translateB = new JButton("Translate To");
        translateB.addActionListener(this);

        latinL = new JLabel("Latin:");
        translatedL = new JLabel(translatedS);

        // Add
        inputP.add(englishL);
        inputP.add(englishTF);
        inputP.add(translateB);
        inputP.add(latinL);
        inputP.add(translatedL);

        add(inputP, BorderLayout.SOUTH);

    }

    public int searchEnglish(String word) {

        int index = -1;
        boolean found = false;

        for(int i = 0; i < englishS.length && !found; i++) {

            if(word.equalsIgnoreCase(englishS[i])) {

                index = i;
                found = true;

            }

        }

        return index;

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String englishT = englishTF.getText();

        if (e.getSource() == translateB) {

            System.out.println("Input String: " + englishT); // For Debugging
            int translatedIndex = searchEnglish(englishT);

            if(translatedIndex > -1 && translatedIndex < latinS.length) {

                translatedS = latinS[translatedIndex];
                translatedL.setText(translatedS);
                System.out.println("Translated String: " + translatedS); // For Debugging

                currentImage = imageS[translatedIndex];
                imgIcon.setImage(currentImage);

                repaint();

            }

            else {

                translatedL.setText("Not Found");

                currentImage = getImage(getCodeBase(), "Error.jpg");
                imgIcon.setImage(currentImage);

                repaint();

            }


        }

    }
}
