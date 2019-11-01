package Project8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**Elevator Project
 * CSci 1130-91
 */

public class Elevator extends JApplet implements ActionListener, ItemListener {

    int originX, originY, elevatorY, selectedFloor, initialFloor, floorDif, floorLoop;
    final int WINDOW_H = 40, WINDOW_W = 20, V_GAP = 5, H_GAP = 5, NUM_WINDOWS = 10, NUM_FLOORS = 10, ELEVATOR_NUM = 0;

    BorderLayout border;
    JButton moveButton;
    JComboBox floorBox;
    JPanel guiPanel, inputPanel;

    Color elevatorColor, windowsColor, buildingColor;
    Graphics2D g2d;

    public void init() {

        // Setting up applet border
        border = new BorderLayout();
        setLayout(border);

        // Setting up variables
        originX = 35;
        originY = 40;

        elevatorColor = new Color(68, 145, 229);
        buildingColor = new Color(120,120,120);
        windowsColor = new Color(45, 93, 145);

        initialFloor = 1;

        setUpGUI();

    }

    public void paint(Graphics g) {

        super.paint(g);
        g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        drawBuilding();
        drawFloors();
        drawElevator();
    }

    public void setUpGUI() {

        inputPanel = new JPanel();

        floorBox = new JComboBox();

        for (int i = 0; i < NUM_FLOORS; i++) {

            floorBox.addItem(String.valueOf(i + 1));

        }

        floorBox.addItemListener(this);
        inputPanel.add(floorBox);

        moveButton = new JButton("Move Elevator");
        moveButton.addActionListener(this);
        inputPanel.add(moveButton);

        guiPanel = new JPanel(new BorderLayout());
        guiPanel.add(inputPanel, BorderLayout.SOUTH);

        add(guiPanel);

    }

    public void drawFloors() {

        // Draws floors with windows called from drawWindows() based on NUM_FLOORS
        for (floorLoop = 0; floorLoop < NUM_FLOORS; floorLoop++) {

            drawWindows();

        }

    }

    public void drawWindows() {

        // Draws windows on a single floor based on NUM_WINDOWS
        for (int windowLoop = 0; windowLoop < NUM_WINDOWS; windowLoop++) {

            int xShift = (WINDOW_W + H_GAP);
            int yShift = (WINDOW_H + V_GAP);

            int windowX = originX + (windowLoop * xShift);
            int windowY = originY + (floorLoop * yShift);

            g2d.setColor(windowsColor);
            g2d.fillRect(windowX, windowY, WINDOW_W, WINDOW_H);
        }

    }

    public void drawBuilding() {

        // Draws the building
        for (floorLoop = 9; floorLoop < NUM_FLOORS; floorLoop++) {

            int buildingX = originX / 2;
            int buildingY = originY / 2;
            int buildingW = WINDOW_W * (((H_GAP/2) + (H_GAP * V_GAP)/2));
            int buildingH = WINDOW_H * (((H_GAP * V_GAP)/2));

            g2d.setColor(buildingColor);
            g2d.fillRect(buildingX, buildingY, buildingW, buildingH);

        }

    }

    public void drawElevator() {

        for (int elevatorLoop = 0; elevatorLoop <= ELEVATOR_NUM; elevatorLoop++) {

            int xShift = (WINDOW_W + H_GAP);
            int yShift = (WINDOW_H + V_GAP);

            // Elevator Y value based on the difference from windows and building
            elevatorY = 445;

            int windowX = originX + (elevatorLoop * xShift);
            int windowY = elevatorY + ((floorDif) * yShift);

            g2d.setColor(elevatorColor);
            g2d.fillRect(windowX, windowY, WINDOW_W, WINDOW_H);
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        
        if (e.getStateChange() == ItemEvent.SELECTED) {

            // selectedFloor would be considered the next floor
            selectedFloor = Integer.parseInt((String) floorBox.getSelectedItem());
            System.out.println("Selected Floor: " + selectedFloor); // For Debugging
            System.out.println("Initial Floor: " + initialFloor); // For Debugging

            // calculating the difference between the initialFloor and the last floor
            floorDif = (initialFloor - selectedFloor);

            System.out.println("Floor Difference: " + floorDif); // For Debugging

            if (selectedFloor == 1) {

                initialFloor = 1;

            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == moveButton) {

            repaint();

        }
    
    }

}
