/// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Omar Alshikh (omar99)
package spacecolonies;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import bsh.ParseException;

/**
 * class that reads the files
 * 
 * @author omaralshikh
 * @version 11/11/2019
 */
public class ColonyReader {

    private Planet[] planets;
    private ArrayQueue<Person> queue;


    /**
     * constructor that takes applicant file name and planet file name
     * 
     * @param applicantFileName
     *            file for people
     * @param planetFileName
     *            file for planets
     * @throws FileNotFoundException
     *             file can not be located
     * @throws ParseException
     *             parse exception
     * @throws SpaceColonyDataException
     *             data is wrong
     */
    public ColonyReader(String applicantFileName, String planetFileName)
        throws FileNotFoundException,
        ParseException,
        SpaceColonyDataException {
        planets = readPlanetFile(planetFileName);
        queue = readQueueFile(applicantFileName);
        // make a new colony and call on space window
        ColonyCalculator colony = new ColonyCalculator(queue, planets);
        new SpaceWindow(colony);
    }


    /**
     * reads the planet file
     * 
     * @param fileName
     *            file to be read
     * @return list of planets inside the file
     * @throws FileNotFoundException
     *             when file is not located
     * @throws ParseException
     *             parse exception
     * @throws SpaceColonyDataException
     *             data exception error
     */
    private Planet[] readPlanetFile(String fileName)
        throws FileNotFoundException,
        ParseException,
        SpaceColonyDataException {
        Planet[] planetList = new Planet[4];
        // scanner used to scan file
        @SuppressWarnings("resource")
        Scanner file = new Scanner(new File(fileName));

        int count = 0;
        while (file.hasNextLine()) {
            // splits file contents
            String[] result = file.nextLine().split(", *");
            if (result.length != 5) {
                throw new ParseException();
            }
            // makes string an integer
            int agri = Integer.valueOf(result[1]);
            int medi = Integer.valueOf(result[2]);
            int tech = Integer.valueOf(result[3]);
            int planetCap = Integer.valueOf(result[4]);

            if (!isInSkillRange(agri, medi, tech)) {
                throw new SpaceColonyDataException("skill is not in range ");
            }
            Planet planet = new Planet(result[0], agri, medi, tech, planetCap);
            count++;
            if (count > 3) {
                throw new SpaceColonyDataException("more than 3 planets");
            }
            planetList[count] = planet;

        }
        if (count < 3) {
            throw new SpaceColonyDataException("less than 3 planets");
        }
        // close file

        file.close();
        return planetList;

    }


    /**
     * reads the queue file
     * 
     * @param fileName
     *            file to be read
     * @return people inside the queue
     * @throws FileNotFoundException
     *             file is not located
     * @throws SpaceColonyDataException
     *             data error
     * @throws ParseException
     *             parse error
     */
    private ArrayQueue<Person> readQueueFile(String fileName)
        throws FileNotFoundException,
        SpaceColonyDataException,
        ParseException {
        ArrayQueue<Person> person;
        person = new ArrayQueue<Person>();
        @SuppressWarnings("resource")
        Scanner file = new Scanner(new File(fileName));

        while (file.hasNextLine()) {
            String[] queueResult = file.nextLine().split(", *");
            if (queueResult.length > 5 || queueResult.length < 4) {
                throw new ParseException();
            }
            // string to integer
            int agri = Integer.valueOf(queueResult[1]);
            int medi = Integer.valueOf(queueResult[2]);
            int tech = Integer.valueOf(queueResult[3]);

            if (!isInSkillRange(agri, medi, tech)) {
                throw new SpaceColonyDataException("skill not in range");
            }

            Person p = null;
            if (queueResult.length == 4) {
                p = new Person(queueResult[0], agri, medi, tech, "");
            }
            else {
                p = new Person(queueResult[0], agri, medi, tech,
                    queueResult[4]);
            }
            person.enqueue(p);
        }
        // close file
        file.close();
        return person;

    }


    /**
     * check to see if skill is in range
     * 
     * @param num1
     *            skill number
     * @param num2
     *            skill number
     * @param num3
     *            skill number
     * @return whether a persons skill is in range of the requirements
     */
    private boolean isInSkillRange(int num1, int num2, int num3) {
        // uses colonyCalculator static values

        return num1 >= ColonyCalculator.MIN_SKILL_LEVEL
            && num1 <= ColonyCalculator.MAX_SKILL_LEVEL
            && num2 >= ColonyCalculator.MIN_SKILL_LEVEL
            && num2 <= ColonyCalculator.MAX_SKILL_LEVEL
            && num3 >= ColonyCalculator.MIN_SKILL_LEVEL
            && num3 <= ColonyCalculator.MAX_SKILL_LEVEL;
    }

}
