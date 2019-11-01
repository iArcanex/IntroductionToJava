package Project7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**PizzaOrder Project
 * CSci 1130-91
 */

public class PizzaOrder extends JApplet implements ActionListener, ItemListener {

    BorderLayout border;
    BoxLayout customizerBox, sizeBox, toppingsBox, receiptBox;
    GridLayout sizeRBGGL, toppingsGL, orderButtonsGL;

    JPanel titleP, customizerP, sizeP, sizeRBP, toppingsP, toppingsCBP,
            receiptP, orderP, orderButtonsP;
    JLabel titleL, sTitleL, pizzaImgL, tTitleL, receiptTitleL;
    JTextArea receiptTA;
    JRadioButton sSmallRB, sMediumRB, sLargeRB;
    JCheckBox tOnionCB, tMushroomCB, tPepperoniCB, tPepperCB;
    JButton orderB, clearB;
    JScrollPane scrollPane;
    ButtonGroup sizeRBG;

    String receiptText, receiptTitleS, selectedSize, selectedToppings, tOnionString, tMushroomString,
            tPepperoniString, tPepperString, totalS;
    Font titleF, appletF;

    boolean onionFlag, mushroomFlag, pepperoniFlag, pepperFlag, smallFlag, mediumFlag, largeFlag;
    double totalPrice, taxRate;
    int sizePrice, totalToppings, toppingsPrice;

    public void init() {

        // Setting up applet border
        border = new BorderLayout();
        setLayout(border);

        // Setting up Label Fonts
        titleF = new Font("SansSerif", Font.PLAIN, 25);
        appletF = new Font("SansSerif", Font.BOLD, 18);

        // Setting up TextArea strings
        receiptText = "";
        receiptTitleS = "+===========================+" +
                        "\n   PIZZA BUYER EXTREME   \n" +
                        "+===========================+" +
                        "\nAwaiting your input. \nPress order when complete." +
                        "\n+===========================+";
        selectedSize = "";
        selectedToppings = "";
        tOnionString = "";
        tMushroomString = "";
        tPepperoniString = "";
        tPepperString = "";
        totalS = "";

        // Setting up Prices/Nums
        totalToppings = 0;
        toppingsPrice = 0;
        sizePrice = 0;
        taxRate = 0.080; // 8.0%

        // Setting up applet Panels
        setUpTitle();
        setUpCustomizer();
        setUpReceipt();
        setUpOrder();

    }

    public void setUpTitle() {

        titleP = new JPanel(new FlowLayout());
        titleP.setBackground(Color.RED);

        // Labels
        Image pizzaIMG = getImage(getCodeBase(),"pizza.gif");
        ImageIcon pizzaIMGIco = new ImageIcon(pizzaIMG);
        pizzaImgL = new JLabel(pizzaIMGIco);
        titleL = new JLabel("<html><b>Pizza Buyer Extreme - MKII</b><html>");
        titleL.setFont(titleF);

        // Adding Components
        titleP.add(pizzaImgL);
        titleP.add(titleL);

        add(titleP, BorderLayout.NORTH);

    }

    public void setUpCustomizer() {

      // Customizer Panel
        customizerP = new JPanel();
        customizerBox = new BoxLayout(customizerP, BoxLayout.Y_AXIS);
        customizerP.setLayout(customizerBox);
        customizerP.setBackground(Color.WHITE);

      // Size Panel
        sizeP = new JPanel();
        sizeBox = new BoxLayout(sizeP, BoxLayout.Y_AXIS);
        sizeP.setLayout(sizeBox);
        sizeP.setBackground(Color.WHITE);

        sizeRBP = new JPanel();
        sizeRBGGL = new GridLayout(1,3);
        sizeRBP.setLayout(sizeRBGGL);

        // Labels
        sTitleL = new JLabel("PLEASE PICK ANY SIZE:");
        sTitleL.setFont(appletF);

        // Radio Buttons
        sizeRBG = new ButtonGroup();
        sSmallRB = new JRadioButton("Small - $5");
        sMediumRB = new JRadioButton("Medium - $6");
        sLargeRB = new JRadioButton("Large - $7");

      // Toppings Panel
        toppingsP = new JPanel();
        toppingsBox = new BoxLayout(toppingsP, BoxLayout.Y_AXIS);
        toppingsP.setLayout(toppingsBox);
        toppingsP.setBackground(Color.WHITE);

        toppingsCBP = new JPanel();
        toppingsGL = new GridLayout(2,2);
        toppingsCBP.setLayout(toppingsGL);

        // Labels
        tTitleL = new JLabel("   Choose a Topping! Toppings are: $1 each   ");
        tTitleL.setFont(appletF);

        // CheckBoxes
        tOnionCB = new JCheckBox("Onions");
        tMushroomCB = new JCheckBox("Mushrooms");
        tPepperoniCB = new JCheckBox("Pepperoni");
        tPepperCB = new JCheckBox("Pepper");


      // Adding Components

         // Size Panel

            sTitleL.setAlignmentX(Component.CENTER_ALIGNMENT);

            customizerP.add(sizeP);
            sizeP.add(sTitleL);
            sizeP.add(sizeRBP);

            // Radio Buttons
            sSmallRB.addItemListener(this);
            sMediumRB.addItemListener(this);
            sLargeRB.addItemListener(this);

            sizeRBG.add(sSmallRB);
            sizeRBG.add(sMediumRB);
            sizeRBG.add(sLargeRB);

            sizeRBP.add(sSmallRB);
            sizeRBP.add(sMediumRB);
            sizeRBP.add(sLargeRB);

         // Toppings Panel

            tTitleL.setAlignmentX(Component.CENTER_ALIGNMENT);

            customizerP.add(toppingsP);
            toppingsP.add(tTitleL);
            toppingsP.add(toppingsCBP);

            // Check Boxes
            tOnionCB.addItemListener(this);
            tMushroomCB.addItemListener(this);
            tPepperoniCB.addItemListener(this);
            tPepperCB.addItemListener(this);

            toppingsCBP.add(tOnionCB);
            toppingsCBP.add(tMushroomCB);
            toppingsCBP.add(tPepperoniCB);
            toppingsCBP.add(tPepperCB);

        add(customizerP, BorderLayout.WEST);

    }

    public void setUpReceipt() {

      // Receipt Panel
        receiptP = new JPanel();
        receiptP.setBackground(Color.WHITE);
        receiptBox = new BoxLayout(receiptP, BoxLayout.Y_AXIS);
        receiptP.setLayout(receiptBox);

        // Labels
        receiptTitleL = new JLabel("HERE IS YOUR RECEIPT:");
        receiptTitleL.setFont(appletF);

        // Text Area
        receiptTA = new JTextArea(receiptText + receiptTitleS + selectedSize + selectedToppings +
                tOnionString + tMushroomString + tPepperoniString + tPepperString + totalS);
        receiptTA.setLineWrap(true);
        receiptTA.setWrapStyleWord(true);

        scrollPane = new JScrollPane(receiptTA);

      // Adding Components

        receiptTitleL.setAlignmentX(Component.CENTER_ALIGNMENT);

        receiptP.add(receiptTitleL);
        receiptP.add(scrollPane);

        add(receiptP, BorderLayout.CENTER);
    }

    public void setUpOrder() {

      // Order Panel
        orderP = new JPanel(new FlowLayout());
        orderP.setBackground(Color.RED);

      // Order Buttons Panel
        orderButtonsP = new JPanel();
        orderButtonsGL = new GridLayout(1,2);
        orderButtonsP.setLayout(orderButtonsGL);


      // Buttons
        orderB = new JButton("ORDER");
        clearB = new JButton("CLEAR");

        orderB.addActionListener(this);
        clearB.addActionListener(this);

      // Adding Components
        orderP.add(orderB);
        orderP.add(clearB);

        add(orderP, BorderLayout.SOUTH);

    }

    public void printReceipt() {

        if (smallFlag) {

            sizePrice = 5;
            selectedSize = "\nSize: SMALL - $" + sizePrice;


        }

        if (mediumFlag) {

            sizePrice = 6;
            selectedSize = "\nSize: MEDIUM - $" + sizePrice;

        }

        if (largeFlag) {

            sizePrice = 7;
            selectedSize = "\nSize: LARGE - $" + sizePrice;

        }

        if (onionFlag) {

            tOnionString = "\n- Onions ($1.00)";

        }

        if (mushroomFlag) {

            tMushroomString = "\n- Mushrooms ($1.00)";

        }

        if (pepperoniFlag) {

            tPepperoniString = "\n- Pepperoni ($1.00)";

        }

        if (pepperFlag) {

            tPepperString = "\n- Pepper ($1.00)";

        }

        receiptTitleS = "+===========================+" +
                "\n   PIZZA BUYER EXTREME   \n" +
                "+===========================+";

        selectedToppings = "\nTotal Toppings: ";

        totalPrice = (sizePrice + toppingsPrice) + ((sizePrice + toppingsPrice) * taxRate);

        totalS = "\n+===========================+" +
                 "\nSubtotal:\n" + "Size Price: $" + sizePrice +
                 "\nToppings Price: $" + toppingsPrice + "\nTax (8%): $" + ((sizePrice+toppingsPrice)*taxRate) +
                 "\nTotal Price: $" + totalPrice;



        System.out.println("Receipt Printed");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // When order button is pressed, receipt is built
        if (e.getSource() == orderB) {

            printReceipt();
            receiptTA.setText(receiptText + receiptTitleS + selectedSize + selectedToppings + totalToppings +
                    tOnionString + tMushroomString + tPepperoniString + tPepperString + totalS);
            receiptText="";

        }

        // Clears the receipt text area when pressed
        else if (e.getSource() == clearB) {

            receiptText = "";
            receiptTitleS = "+===========================+" +
                            "\n   PIZZA BUYER EXTREME   \n" +
                            "+===========================+" +
                            "\nAwaiting your input. \nPress order when complete." +
                            "\n+===========================+";
            selectedSize = "";
            selectedToppings = "";
            tOnionString = "";
            tMushroomString = "";
            tPepperoniString = "";
            tPepperString = "";
            totalS = "";
            sizePrice = 0;
            sizeRBG.clearSelection();
            tOnionCB.setSelected(false);
            tMushroomCB.setSelected(false);
            tPepperoniCB.setSelected(false);
            tPepperCB.setSelected(false);
            receiptTA.setText(receiptText + receiptTitleS + selectedSize + selectedToppings +
                    tOnionString + tMushroomString + tPepperoniString + tPepperString + totalS);

        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

      // Object used to verify checkbox selection
        Object selected = e.getSource();

      // Sets flag to false for deselected GUI options
        if (e.getStateChange() == ItemEvent.DESELECTED) {

            if (selected == tOnionCB) {
                onionFlag = false;
                tOnionString = "";
                System.out.println("Onion Deselected");
            }

            if (selected == tMushroomCB) {
                mushroomFlag = false;
                tMushroomString = "";
                System.out.println("Mushroom Deselected");
            }

            if (selected == tPepperoniCB) {
                pepperoniFlag = false;
                tPepperoniString = "";
                System.out.println("Pepperoni Deselected");
            }

            if (selected == tPepperCB) {
                pepperFlag = false;
                tPepperString = "";
                System.out.println("Pepper Deselected");
            }

            if (selected == sSmallRB) {
                smallFlag = false;
                System.out.println("Small Deselected");
            }

            if (selected == sMediumRB) {
                mediumFlag = false;
                System.out.println("Medium Deselected");
            }

            if (selected == sLargeRB) {
                largeFlag = false;
                System.out.println("Large Deselected");
            }

        }

      // Size Selection
        if (selected == sSmallRB && sSmallRB.isSelected()) {
            smallFlag = true;
            System.out.println("Small Selected");
        }

        else if (selected == sMediumRB && sMediumRB.isSelected()) {
            mediumFlag = true;
            System.out.println("Medium Selected");
        }

        else if (selected == sLargeRB && sLargeRB.isSelected()) {
            largeFlag = true;
            System.out.println("Large Selected");
        }

      // Toppings Selection
        if (e.getSource()== tOnionCB && tOnionCB.isSelected()) {

            totalToppings++;
            toppingsPrice = toppingsPrice + 1;
            onionFlag = true;
            System.out.println("Toppings Price: " + toppingsPrice);
            System.out.println("Total Toppings: " + totalToppings);

        }

        if (e.getSource() == tOnionCB && !tOnionCB.isSelected()) {

            totalToppings--;
            toppingsPrice = toppingsPrice - 1;
            System.out.println("Toppings Price: " + toppingsPrice);
            System.out.println("Total Toppings: " + totalToppings);
        }

        if (e.getSource()== tMushroomCB && tMushroomCB.isSelected()) {

            totalToppings++;
            toppingsPrice = toppingsPrice + 1;
            mushroomFlag = true;
            System.out.println("Toppings Price: " + toppingsPrice);
            System.out.println("Total Toppings: " + totalToppings);

        }

        if (e.getSource() == tMushroomCB && !tMushroomCB.isSelected()) {

            totalToppings--;
            toppingsPrice = toppingsPrice - 1;
            System.out.println("Toppings Price: " + toppingsPrice);
            System.out.println("Total Toppings: " + totalToppings);
        }

        if (e.getSource()== tPepperoniCB && tPepperoniCB.isSelected()) {

            totalToppings++;
            toppingsPrice = toppingsPrice + 1;
            pepperoniFlag = true;
            System.out.println("Toppings Price: " + toppingsPrice);
            System.out.println("Total Toppings: " + totalToppings);

        }

        if (e.getSource() == tPepperoniCB && !tPepperoniCB.isSelected()){

            totalToppings--;
            toppingsPrice = toppingsPrice - 1;
            System.out.println("Toppings Price: " + toppingsPrice);
            System.out.println("Total Toppings: " + totalToppings);
        }

        if (e.getSource()== tPepperCB && tPepperCB.isSelected()) {

            totalToppings++;
            toppingsPrice = toppingsPrice + 1;
            pepperFlag = true;
            System.out.println("Toppings Price: " + toppingsPrice);
            System.out.println("Total Toppings: " + totalToppings);

        }

        if (e.getSource() == tPepperCB && !tPepperCB.isSelected()){

            totalToppings--;
            toppingsPrice = toppingsPrice - 1;
            System.out.println("Toppings Price: " + toppingsPrice);
            System.out.println("Total Toppings: " + totalToppings);
        }

    }

}
