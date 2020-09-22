/// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Omar Alshikh (omar99)
package spacecolonies;

import java.io.FileNotFoundException;
import bsh.ParseException;

/**
 * main class that brings everything together
 * 
 * @author omaralshikh
 * @version 11/11/2019
 *
 */
public class ProjectRunner {

    /**
     * main constructor
     * 
     * @param args
     *            arguments to be taken
     * @throws SpaceColonyDataException
     *             throws an exception when data is wrong
     * @throws ParseException
     *             parse exception
     * @throws FileNotFoundException
     *             when file is not located
     */
    public static void main(String[] args)
        throws FileNotFoundException,
        ParseException,
        SpaceColonyDataException {
        // inputs that take the file names
        String input1;
        String input2;
        // two files
        if (args.length < 2) {
            input1 = "inputAllAccept.txt";
            input2 = "planets.txt";
        }
        else {
            input1 = args[0];
            input2 = args[1];
        }

        @SuppressWarnings("unused")
        // call on colony reader class to read the files
        ColonyReader reader;
        reader = new ColonyReader(input1, input2);

    } // end main

} // end class
