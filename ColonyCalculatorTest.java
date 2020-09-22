/// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Omar Alshikh (omar99)
package spacecolonies;

import org.junit.Before;
import student.TestCase;

/**
 * test class for colonyCalculator
 * 
 * @author omaralshikh
 * @version 11/11/19
 */
public class ColonyCalculatorTest extends TestCase {
    private ColonyCalculator colony;
    private ArrayQueue<Person> person;
    private Planet[] planet;


    /**
     * set up method for the test class
     * creates 3 planets to be tested with and give them indexes from 1 to 3
     * 
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        person = new ArrayQueue<Person>();
        Planet planet1 = new Planet("moon", 2, 2, 2, 1);
        Planet planet2 = new Planet("mars", 2, 2, 2, 1);
        Planet planet3 = new Planet("mercury", 4, 4, 4, 1);
        planet = new Planet[4];
        planet[1] = planet1;
        planet[2] = planet2;
        planet[3] = planet3;
        colony = new ColonyCalculator(person, planet);

    }


    /**
     * test method for getQueue
     */
    public void testGetQueue() {

        assertEquals(person, colony.getQueue());

    }


    /**
     * test method for getPlantes
     */
    public void testGetPlanets() {

        assertEquals("moon", ColonyCalculator.getPlanets()[1].getName());
    }


    /**
     * test method for whether a person is eligible
     */
    public void testGetPlanetForPerson() {
        ArrayQueue<Person> emptyPerson;
        emptyPerson = new ArrayQueue<Person>();
        ColonyCalculator colonyEmpt;
        // create new empty colony
        colonyEmpt = new ColonyCalculator(emptyPerson, planet);

        Person omar;
        omar = new Person("omar", 3, 3, 3, "moon");
        person.enqueue(omar);
        assertEquals("moon", colony.getPlanetForPerson(omar).getName());

        Person notPerson = null;
        person.enqueue(notPerson);
        assertEquals(null, colony.getPlanetForPerson(notPerson));
        // try w colony empty
        Person notPerson2 = null;
        assertEquals(null, colonyEmpt.getPlanetForPerson(notPerson2));

        Person jack;
        jack = new Person("jack", 4, 4, 4, "");
        person.enqueue(jack);
        assertEquals(1, colony.getPlanetForPerson(jack).getAvailability());
        Person notEligible;
        notEligible = new Person("mak", 3, 3, 3, "mars");
        person.enqueue(notEligible);
        assertFalse(colony.getPlanetForPerson(notEligible).isFull());

        Person notEligible2;
        notEligible2 = new Person("om", 2, 2, 2, "mercury");
        person.enqueue(notEligible2);
        assertFalse(planet[3].getSkills().isBelow(notEligible2.getSkills()));
        assertEquals("mars", colony.getPlanetForPerson(notEligible2).getName());

        ArrayQueue<Person> p3 = null;
        Exception thrown = null;
        try {
            // call method here that will throw the exception

            colony = new ColonyCalculator(p3, planet);
        }
        catch (Exception exception) {
            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof IllegalArgumentException);

    }


    /**
     * tests whether a person can be accepted or not
     */
    public void testAccept() {

        Person psn;
        psn = new Person("omar", 3, 3, 3, "moon");
        person.enqueue(psn);
        assertEquals(true, colony.accept());
        Person psn2;
        psn2 = new Person("omar", 1, 1, 1, "moon");
        person.enqueue(psn2);

        assertEquals(false, colony.accept());

        ArrayQueue<Person> empty;
        empty = new ArrayQueue<Person>();
        ColonyCalculator colonyy;
        colonyy = new ColonyCalculator(empty, planet);

        assertFalse(colonyy.accept());

    }


    /**
     * test method for when a person is rejected
     */
    public void testReject() {

        Person psn;
        psn = new Person("omar", 1, 1, 1, "moon");
        colony.getQueue().enqueue(psn);

        colony.reject();
        assertEquals(0, colony.getQueue().getSize());

    }


    /**
     * tests whether the planets are in the correct indexes
     */
    public void testPlanetByNumber() {
        assertEquals(
            "moon, population 0 (cap: 1), Requires: A >= 2, M >= 2, T >= 2",
            colony.planetByNumber(1).toString());
        assertEquals(
            "mars, population 0 (cap: 1), Requires: A >= 2, M >= 2, T >= 2",
            colony.planetByNumber(2).toString());
        assertEquals(
            "mercury, population 0 (cap: 1), Requires: A >= 4, M >= 4, T >= 4",
            colony.planetByNumber(3).toString());
        assertEquals(null, colony.planetByNumber(0));
        assertEquals(null, colony.planetByNumber(4));

    }

}
