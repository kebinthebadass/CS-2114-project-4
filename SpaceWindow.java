/// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Omar Alshikh (omar99)
package spacecolonies;

import CS2114.Window;
import java.awt.Color;
import CS2114.Button;
import CS2114.CircleShape;
import CS2114.WindowSide;
import list.AList;
import CS2114.Shape;
import CS2114.TextShape;

/**
 * GUI class/ front end for cutomer to see/use
 * 
 * @author omaralshikh
 * @version 11/11/2019
 */
public class SpaceWindow {
    // variables
    private Window window;
    private ColonyCalculator colonyCalculator;
    private Button accept;
    private Button reject;
    private CircleShape circle;
    private AList<CircleShape> personCircles;
    private Shape fillShape;
    private Shape shape;
    private TextShape personText;
    private TextShape planetText;
    private TextShape planetText2;
    private TextShape planetText3;

    public static final int QUEUE_STARTX = 50; // The horizontal position which
                                               // starts your queue

    public static final int QUEUE_STARTY = 80; // The vertical position which
                                               // starts your queue

    public static final int CIRCLE_SIZE = 40; // To use to size each Person
                                              // circle.

    public static final int PLANET_HEIGHT = 20;
    /**
     * X and Y position for planet text
     */
    public static final int TEXT_POSITION1 = 140;
    public static final int TEXT_POSITION2 = 260;
    public static final int TEXT_POSITION3 = 380;
    public static final int Y_TEXT = 260;
    public static final int GUI_MID = 150; // middle of window

    private int ShapeX = 150;
    private int shapeSize = 60;

    private int ShapeY = 250;
    private AList<Shape> soManyShapes;
    private AList<TextShape> text;


    /**
     * constructor for window
     * 
     * @param colony
     *            parameter that takes colonyCalculator class
     */
    public SpaceWindow(ColonyCalculator colony) {

        // create window
        window = new Window();
        // window title up top
        window.setTitle("Space Colony Placement");
        // create buttons

        accept = new Button("Accept");

        window.addButton(accept, WindowSide.SOUTH);
        accept.onClick(this, "clickedAccept");
        reject = new Button("Reject");
        window.addButton(reject, WindowSide.SOUTH);
        reject.onClick(this, "clickedReject");
        // initialize variable
        personCircles = new AList<CircleShape>();

        colonyCalculator = colony;

        soManyShapes = new AList<Shape>();
        text = new AList<TextShape>();
        int numberOfShapes = 3;

        // creates squares that show up on window
        for (int i = 0; i < numberOfShapes; i++) {

            shape = new Shape(ShapeX, ShapeY - shapeSize, shapeSize, shapeSize);

            int caseNum = i % 3;
            switch (caseNum) {
                case 0:
                    shape.setForegroundColor(new Color(173, 147, 189));
                    shape.setBackgroundColor(new Color(173, 147, 189));
                    break;
                case 1:
                    shape.setForegroundColor(new Color(102, 176, 174));
                    shape.setBackgroundColor(new Color(102, 176, 174));
                    break;
                case 2:
                    shape.setForegroundColor(new Color(112, 148, 180));
                    shape.setBackgroundColor(new Color(112, 148, 180));
                    break;
                default:
                    shape.setForegroundColor(new Color(165, 209, 232));
                    shape.setBackgroundColor(new Color(165, 209, 232));
                    break;

            }
            soManyShapes.add(fillShape);
            soManyShapes.add(shape);

            ShapeX = ShapeX + shapeSize + 60;
        }

        for (int j = 0; j < soManyShapes.getLength(); j += 2) {
            window.addShape(soManyShapes.getEntry(j + 1));

        }
        // create and add the texts onto the window
        personText = new TextShape(10, 10, "");

        planetText = new TextShape(TEXT_POSITION1, Y_TEXT, "");

        planetText2 = new TextShape(TEXT_POSITION2, Y_TEXT, "");

        planetText3 = new TextShape(TEXT_POSITION3, Y_TEXT, "");

        text.add(personText);
        text.add(planetText);
        text.add(planetText2);
        text.add(planetText3);

        for (int k = 0; k < text.getLength(); k++) {
            window.addShape(text.getEntry(k));
        }

        updateText();
        updateQueue();
        updateButtons();
        updatePlanet();

    }


    /**
     * updates the queue of people after each button is clicked
     * updates the screen by removing all shapes and re-adding them after
     */
    private void updateQueue() {

        if (!colonyCalculator.getQueue().isEmpty()) {
            Object[] ppl = colonyCalculator.getQueue().toArray();
            Person person = null;
            int x = QUEUE_STARTX;

            for (int i = 0; i < personCircles.getLength(); i++) {
                window.removeShape(personCircles.getEntry(i));

            }
            personCircles.clear();
            updateText();
            // creates the queue of circles
            for (int i = 0; i < ppl.length; i++) {
                person = (Person)ppl[i];

                if (person.getPlanetName().equals(ColonyCalculator
                    .getPlanets()[1].getName())) {
                    circle = new CircleShape(x, QUEUE_STARTY, CIRCLE_SIZE);
                    circle.setForegroundColor(new Color(173, 147, 189));
                    circle.setBackgroundColor(new Color(173, 147, 189));
                    x = x + 45;
                    personCircles.add(circle);

                }
                else if (person.getPlanetName().equals(ColonyCalculator
                    .getPlanets()[2].getName())) {
                    circle = new CircleShape(x, QUEUE_STARTY, CIRCLE_SIZE);
                    circle.setForegroundColor(new Color(102, 176, 174));
                    circle.setBackgroundColor(new Color(102, 176, 174));
                    x = x + 45;
                    personCircles.add(circle);

                }
                else if (person.getPlanetName().equals(ColonyCalculator
                    .getPlanets()[3].getName())) {
                    circle = new CircleShape(x, QUEUE_STARTY, CIRCLE_SIZE);
                    circle.setForegroundColor(new Color(112, 148, 180));
                    circle.setBackgroundColor(new Color(112, 148, 180));
                    x = x + 45;
                    personCircles.add(circle);

                }
                else {

                    circle = new CircleShape(x, QUEUE_STARTY, CIRCLE_SIZE);
                    circle.setForegroundColor(new Color(165, 209, 232));
                    circle.setBackgroundColor(new Color(165, 209, 232));
                    x = x + 45;
                    personCircles.add(circle);

                }

            } // end for loop
            for (int j = 0; j < personCircles.getLength(); j++) {
                window.addShape(personCircles.getEntry(j));

            } // end for loop

        } // end first if

    }


    /**
     * updates the planet and fills the planet once an applicant is accepted
     */
    private void updatePlanet() {
        AList<Shape> update = new AList<Shape>();
        // colors to match the planet the applicant wants
        Color colors[] = { new Color(127, 96, 147), new Color(58, 124, 122),
            new Color(49, 86, 119) };
        // loop to fill a planet
        for (int i = 1, j = 0; i <= 3 && j < soManyShapes.getLength(); i++, j +=
            2) {
            Shape shape = soManyShapes.getEntry(j + 1);

            double frac = (double)ColonyCalculator.getPlanets()[i]
                .getPopulationSize() / ColonyCalculator.getPlanets()[i]
                    .getCapacity();

            int y = shape.getY() + shape.getHeight() - (int)(frac * shape
                .getHeight());
            Shape updateShape = new Shape(shape.getX(), y, shapeSize,
                (int)(shapeSize * frac), colors[i - 1]);
            update.add(updateShape);
            window.addShape(updateShape);
            window.addShape(shape);

        }

    }


    /**
     * updates the text on the screen
     */
    private void updateText() {
        TextShape skills1, skills2, skills3;
        ;
        skills1 = new TextShape(TEXT_POSITION1, Y_TEXT + 20, "");
        skills2 = new TextShape(TEXT_POSITION2, Y_TEXT + 20, "");
        skills3 = new TextShape(TEXT_POSITION3, Y_TEXT + 20, "");

        text.add(skills1);
        text.add(skills2);
        text.add(skills3);

        Person personNext = colonyCalculator.getQueue().getFront();
        Planet[] Planets = ColonyCalculator.getPlanets();

        if (personNext != null) {

            personText.setText(personNext.toString());
            personText.setBackgroundColor(Color.WHITE);

        }
        // showcases the name of the planet, capacity and skill level needed for
        // each applicant
        if (Planets != null) {
            planetText.setText(Planets[1].getName() + " " + Planets[1]
                .getPopulationSize() + "/" + Planets[1].getCapacity());
            skills1.setText(Planets[1].getSkills().toString());
            planetText.setBackgroundColor(Color.WHITE);
            skills1.setBackgroundColor(Color.WHITE);

            planetText2.setText(Planets[2].getName() + " " + Planets[2]
                .getPopulationSize() + "/" + Planets[2].getCapacity());
            skills2.setText(Planets[2].getSkills().toString());
            planetText2.setBackgroundColor(Color.WHITE);
            skills2.setBackgroundColor(Color.WHITE);

            planetText3.setText(Planets[3].getName() + " " + Planets[3]
                .getPopulationSize() + "/" + Planets[3].getCapacity());
            skills3.setText(Planets[3].getSkills().toString());
            planetText3.setBackgroundColor(Color.WHITE);
            skills3.setBackgroundColor(Color.WHITE);

        }

        for (int k = 0; k < text.getLength(); k++) {
            window.addShape(text.getEntry(k));
        }
    }


    /**
     * updates the buttons on the screen
     */
    private void updateButtons() {

        if (colonyCalculator.getPlanetForPerson(colonyCalculator.getQueue()
            .getFront()) != null) {

            accept.enable();
        }
        else {
            accept.disable();

        }
        // reject button is always enabled no matter what
        reject.enable();

    }


    /**
     * brings all update method together.
     * disables buttons and removes all shapes with a message once all
     * applicants have been processed
     */
    private void update() {
        if (colonyCalculator.getQueue().isEmpty()) {

            accept.disable();
            reject.disable();
            personCircles.clear();
            window.removeAllShapes();
            TextShape newShape = new TextShape(GUI_MID, GUI_MID,
                "All Applicants Processed - Good Work!");
            newShape.setBackgroundColor(Color.WHITE);
            window.addShape(newShape);

        }
        else {

            window.removeAllShapes();
            updateQueue();
            updateText();
            updateButtons();
            updatePlanet();

        }

    }


    /**
     * method that handles the button click for accept
     * 
     * @param button
     *            button clicked
     */
    public void clickedAccept(Button button) {
        if (!colonyCalculator.getQueue().isEmpty()) {
            if (colonyCalculator.accept()) {
                update();

            }

            else {
                button.disable();
            }
        }
    }


    /**
     * handles the reject button
     * 
     * @param button
     *            button that is clicked
     */
    public void clickedReject(Button button) {
        if (!personCircles.isEmpty()) {
            colonyCalculator.reject();
            window.removeAllShapes();
            update();
        }

    }

} // end class
