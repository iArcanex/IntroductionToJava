package Project5;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**LazyDayz Project
 * CSci 1130-91
 */

public class LazyDayz extends JApplet {

    // Instanced Variables
    Image activityIMG;
    int temp, month, optionW;
    boolean flagA, flagB, isSnowing, isWindy, isRaining, isCloudy, isSunny, isWinter, isSpring, isSummer, isFall;
    Calendar currentTime;
    String tempS, season, tempRange, messageW, titleW, option1, option2, optionC, activityName, activityString;
    Color activityColor;
    Graphics2D g2d;

    public void init() {

        // Retrieves current MONTH based on the device executed from
        // Change the month to an exact value here to automatically 
        // adjust how the getTemp() method retrieves information
        currentTime = Calendar.getInstance();

        // set month = ? for Manual Input and DEBUGGING
        currentTime.get(Calendar.MONTH);
        //month = 0; //Winter
        //month = 2; //Spring
        //month = 5; //Summer
        //month = 8; //Fall
        System.out.println("Month: " + month); // For Debugging

        // Defining variables for the Weather Conditions object
        // These will always stay the same, but are easy to
        // change in the future if necessary.
        titleW = "How's the Weather?";
        optionC = "Cancel";

        // Calls method to begin the decision chain
        lazyChoozer();
        
        getContentPane().setBackground(Color.WHITE);
    }

    public void paint(Graphics g) {

        super.paint(g);

        // Casting Graphics + Antialiasing
        g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        // Establishing Font
        g2d.setFont(new Font("SansSerif", Font.BOLD, 18));

        // Activity will be drawn based on variables collected
        // and defined throughout the decision making
        drawActivity();


    }

    public void lazyChoozer() {

        switch(month) {

            // Winter
            case 11:
            case 0:
            case 1: {

                // Defines variables used in getTemp()
                season = "Winter";
                tempRange = "-10 and 40";

                // Calls method to retrieve temp data
                getTemp();

                // Sets boolean value to true for the season.
                // This will be used later to select activities
                isWinter = true;

                if (temp >= 30 && temp <= 40) {

                    // FlagA turns on for the first temp condition
                    // Used to aid in decisions/activity selection
                    flagA = true;

                    // Variables defined for the wConditions object
                    messageW = "Is it Snowing or is it Sunny?";
                    option1 = "Snowing";
                    option2 = "Sunny";

                    // Calls method to find out what the weather is
                    // for this temp condition
                    getWeather();
                    System.out.println("Winter-FlagA Successful"); //For Debugging



                } // First Winter Temp condition ends here

                else if (temp >= -10 && temp < 30) {

                    // FlagB turns on for the second temp condition
                    // Used to aid in decisions/activity selection
                    flagB = true;

                    // Variables defined for the wConditions object
                    messageW = "Is it Snowing or is it Sunny?";
                    option1 = "Snowing";
                    option2 = "Sunny";

                    // Calls method to find out what the weather is
                    // for this temp condition
                    getWeather();
                    System.out.println("Winter-FlagB Successful");

                } // Second Winter Temp condition ends here

                // Recalls the current method to avoid having the answer circumvented
                else {
                    lazyChoozer();
                }

                break;

            } // Winter cases end here

            // Spring
            case 2:
            case 3:
            case 4: {

                // Defines variables used in getTemp()
                season = "Spring";
                tempRange = "40 and 90";

                // Calls method to retrieve temp data
                getTemp();

                isSpring = true;

                if (temp >= 70 && temp <= 90) {

                    flagA = true;

                    messageW = "Is it Raining or is it Sunny?";
                    option1 = "Raining";
                    option2 = "Sunny";

                    // Calls method to find out what the weather is
                    // for this temp condition
                    getWeather();
                    System.out.println("Spring-FlagA Successful"); //For Debugging



                } // First Spring Temp condition ends here

                else if (temp >= 40 && temp < 70) {

                    flagB = true;

                    messageW = "Is it Windy or is it Sunny?";
                    option1 = "Windy";
                    option2 = "Sunny";

                    // Calls method to find out what the weather is
                    // for this temp condition
                    getWeather();
                    System.out.println("Spring-FlagB Successful");

                } // Second Spring Temp condition ends here

                else {
                    lazyChoozer();
                }

                break;

            } // Spring cases end here

            // Summer
            case 5:
            case 6:
            case 7: {

                // Defines variables used in getTemp()
                season = "Summer";
                tempRange = "70 and 100";

                // Calls method to retrieve temp data
                getTemp();

                isSummer = true;

                if (temp >= 90 && temp <= 100) {

                    flagA = true;

                    messageW = "Is it Raining or is it Sunny?";
                    option1 = "Raining";
                    option2 = "Sunny";

                    // Calls method to find out what the weather is
                    // for this temp condition
                    getWeather();
                    System.out.println("Summer-FlagA Successful"); //For Debugging



                } // First Summer Temp condition ends here

                else if (temp >= 70 && temp < 90) {

                    flagB = true;

                    messageW = "Is it Windy or is it Cloudy?";
                    option1 = "Windy";
                    option2 = "Cloudy";

                    // Calls method to find out what the weather is
                    // for this temp condition
                    getWeather();
                    System.out.println("Summer-FlagB Successful");

                } // Second Summer Temp condition ends here

                else {
                    lazyChoozer();
                }

                break;

            } // Summer cases end here

            // Fall
            case 8:
            case 9:
            case 10: {

                // Defines variables used in getTemp()
                season = "Fall";
                tempRange = "30 and 70";

                // Calls method to retrieve temp data
                getTemp();

                isFall = true;

                if (temp >= 60 && temp <= 70) {

                    flagA = true;

                    messageW = "Is it Raining or is it Sunny?";
                    option1 = "Raining";
                    option2 = "Sunny";

                    // Calls method to find out what the weather is
                    // for this temp condition
                    getWeather();
                    System.out.println("Fall-FlagA Successful"); //For Debugging



                } // First Fall Temp condition ends here

                else if (temp >= 30 && temp < 60) {

                    flagB = true;

                    messageW = "Is it Windy or is it Sunny?";
                    option1 = "Windy";
                    option2 = "Cloudy";

                    // Calls method to find out what the weather is
                    // for this temp condition
                    getWeather();
                    System.out.println("Fall-FlagB Successful");

                } // Second Fall Temp condition ends here

                else {
                    lazyChoozer();
                }

                break;

            } // Fall cases end here

        } // Switch ends here


    }

    public int getTemp() {

        // Temperature is captured as a String
        tempS = JOptionPane.showInputDialog(this, "It is currently" + " " + season + ". " + "Please input a temperature between" + " " + tempRange + " " + "degrees Fahrenheit. (If your value does not match the expected parameters, you will be asked again.)");

        // Looking for a solution regarding special
        // values had me look up try and catch
        // statements in the Java Docs

        // This catches any Number Format Exceptions
        // That includes any unexpected values and
        // calls to the getTemp() method again.
        try {

            // When pressing cancel on the JOptionPane, null is
            // the provided result, if that is the case, the
            // if/else statements are there to exit the applet instead of calling getTemp again.
            if(tempS == null) {
                System.exit(0);
            }

            else {
                Integer.parseInt(tempS);
            }
        }

        // When an unworkable value is found, catch() will call getTemp() again
        catch(NumberFormatException e) {

            JOptionPane.showMessageDialog(this, "You've entered a value that is not considered acceptable. Please enter an integer.");
            getTemp();

        }

        // Temperature is converted from a String to an int
        temp = Integer.parseInt(tempS);

        return temp;

    }

    public void getWeather() {

        // FlagA - The first temperature condition
        // This if statement will cycle through based
        // on data received earlier and define the correct
        // weather that was selected in OptionDialog
        if(flagA) {

            Object[] wConditions = {option1, option2, optionC};

            optionW = JOptionPane.showOptionDialog(null, messageW, titleW, JOptionPane.YES_OPTION, JOptionPane.NO_OPTION, null, wConditions, wConditions[2]);

          // Winter
            if (optionW == JOptionPane.YES_OPTION && isWinter) {

                activityName = "flagA_isSnowing_isWinter.jpg";
                activityString = "Go outside and have a snowball fight!";
                activityColor = Color.CYAN;
                isSnowing = true;
                System.out.println("isSnowing");

            }

            else if (optionW == JOptionPane.NO_OPTION && isWinter) {

                activityName = "flagA_isSunny_isWinter.jpg";
                activityString = "Grab a sled and race someone down a hill!";
                activityColor = Color.CYAN;
                isSunny = true;
                System.out.println("isSunny");

            }

          // Spring
            if (optionW == JOptionPane.YES_OPTION && isSpring) {

                activityName = "flagA_isRaining_isSpring.jpg";
                activityString = "Splash some puddles around!";
                activityColor = Color.GREEN;
                isRaining = true;
                System.out.println("isRaining");

            }

            else if (optionW == JOptionPane.NO_OPTION && isSpring) {

                activityName = "flagA_isSunny_isSpring.jpg";
                activityString = "Go have a Picnic and don't forget the basket!";
                activityColor = Color.GREEN;
                isSunny = true;
                System.out.println("isSunny");

            }

          // Summer
            if (optionW == JOptionPane.YES_OPTION && isSummer) {

                activityName = "flagA_isRaining_isSummer.jpg";
                activityString = "Go outside and catch some fish!";
                activityColor = Color.RED;
                isRaining = true;
                System.out.println("isRaining");

            }

            else if (optionW == JOptionPane.NO_OPTION && isSummer) {

                activityName = "flagA_isSunny_isSummer.jpg";
                activityString = "Have a barbecue cook out. Invite everyone over!";
                activityColor = Color.RED;
                isSunny = true;
                System.out.println("isSunny");

            }

          // Fall
            if (optionW == JOptionPane.YES_OPTION && isFall) {

                activityName = "flagA_isRaining_isFall.jpg";
                activityString = "Grab some snacks and read a book.";
                activityColor = Color.ORANGE;
                isRaining = true;
                System.out.println("isRaining");

            }

            else if (optionW == JOptionPane.NO_OPTION && isFall) {

                activityName = "flagA_isSunny_isFall.jpg";
                activityString = "Go outside and break your biking record.";
                activityColor = Color.ORANGE;
                isSunny = true;
                System.out.println("isSunny");

            }

          // Cancel button terminates the applet

            else if (optionW == JOptionPane.CANCEL_OPTION) {

                System.exit(0);

            }
            
        }

        // FlagB - The second temperature condition
        // This if statement will cycle through based
        // on data received earlier and define the correct
        // weather that was selected in OptionDialog
        // alongside variables used in drawActivity()
        else if (flagB) {

            Object[] wConditions = {option1, option2, optionC};

            optionW = JOptionPane.showOptionDialog(null, messageW, titleW, JOptionPane.YES_OPTION, JOptionPane.NO_OPTION, null, wConditions, wConditions[2]);

          // Winter
            if (optionW == JOptionPane.YES_OPTION && isWinter) {

                activityName = "flagB_isSnowing_isWinter.jpg";
                activityString = "Make some snow angels!";
                activityColor = Color.CYAN;
                isSnowing = true;
                System.out.println("isSnowing");

            }

            else if (optionW == JOptionPane.NO_OPTION && isWinter) {

                activityName = "flagB_isSunny_isWinter.jpg";
                activityString = "Build an Igloo! It's fun with a friend.";
                activityColor = Color.CYAN;
                isSunny = true;
                System.out.println("isSunny");

            }

          // Spring
            if (optionW == JOptionPane.YES_OPTION && isSpring) {

                activityName = "flagB_isWindy_isSpring.jpg";
                activityString = "Ride you kite along the sky. The bigger the better!";
                activityColor = Color.GREEN;
                isWindy = true;
                System.out.println("isWindy");

            }

            else if (optionW == JOptionPane.NO_OPTION && isSpring) {

                activityName = "flagB_isSunny_isSpring.jpg";
                activityString = "Do some gardening and plants some seeds!";
                activityColor = Color.GREEN;
                isSunny = true;
                System.out.println("isSunny");

            }

          // Summer
            if (optionW == JOptionPane.YES_OPTION && isSummer) {

                activityName = "flagB_isWindy_isSummer.jpg";
                activityString = "Go paragliding with a boat, it's fun!";
                activityColor = Color.RED;
                isWindy = true;
                System.out.println("isWindy");

            }

            else if (optionW == JOptionPane.NO_OPTION && isSummer) {

                activityName = "flagB_isCloudy_isSummer.jpg";
                activityString = "Pick up some seashells alongside the beach's shore!";
                activityColor = Color.RED;
                isCloudy = true;
                System.out.println("isCloudy");

            }

          // Fall
            if (optionW == JOptionPane.YES_OPTION && isFall) {

                activityName = "flagB_isWindy_isFall.jpg";
                activityString = "Harvest some pumpkins and carve them as a bonus!";
                activityColor = Color.ORANGE;
                isWindy = true;
                System.out.println("isWindy");

            }

            else if (optionW == JOptionPane.NO_OPTION && isFall) {

                activityName = "flagB_isCloudy_isFall.jpg";
                activityString = "Gather and jump within a pile of leaves.";
                activityColor = Color.ORANGE;
                isCloudy = true;
                System.out.println("isCloudy");

            }


          // Cancel button terminates the applet

            else if (optionW == JOptionPane.CANCEL_OPTION) {

                System.exit(0);

            }
            
        }

    }

    public void drawActivity() {

        // This method automatically draws an activity when called upon
        // based on the flags, boolean, and string variables defined

        // To summarize how the boolean variables work in this class:
        // A flag triggers depending on if temp conditions 1 or 2 are
        // input from getTemp(), then the weather conditions are asked
        // which will then set them to true, which will allow drawActivity()
        // to draw the correct activity depending on pre-provided variables.

        activityIMG = getImage(getCodeBase(), activityName);
        g2d.drawImage(activityIMG, (getWidth()-400)/2, (getHeight()-400)/2, this);
        g2d.setColor(activityColor);
        g2d.drawString(activityString,(getWidth()/2)-200,600);

    }

}
