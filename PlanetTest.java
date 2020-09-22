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
 * test class for planet
 * 
 * @author omaralshikh
 * @version 11/11/19
 */
public class PlanetTest extends TestCase {
    private Planet planet;
    private Person person;


    /**
     * set up method
     * 
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() {
        planet = new Planet("Mercury", 3, 2, 1, 100);
        person = new Person("omar", 3, 2, 1, "Mercury");
    }


    /**
     * tests the name set for planet
     */
    public void testSetName() {
        planet.setName("mars");
        assertEquals("mars", planet.getName());
    }


    /**
     * tests the name of the planet
     */
    public void testGetName() {
        assertEquals("Mercury", planet.getName());
    }


    /**
     * tests the skills of planet
     */
    public void testGetSkills() {
        assertEquals("A:3 M:2 T:1", planet.getSkills().toString());
    }


    /**
     * tests population
     */
    public void testGetPopulation() {
        planet.addPerson(person);
        assertEquals(person, planet.getPopulation()[0]);
    }


    /**
     * tests population size
     */
    public void testGetPopulationSize() {
        assertEquals(0, planet.getPopulationSize());
        planet.addPerson(person);
        assertEquals(1, planet.getPopulationSize());

    }


    /**
     * capacity test
     */
    public void testGetCapacity() {
        assertEquals(100, planet.getCapacity());
    }


    /**
     * space test
     */
    public void testGetAvailability() {
        assertEquals(100, planet.getAvailability());
    }


    /**
     * tests when a planet is full
     */
    public void testIsFull() {
        assertFalse(planet.isFull());

    }


    /**
     * tests when a person is added and when a person is not added
     */
    public void testAddPerson() {
        assertEquals(0, planet.getPopulationSize());
        Person p1;
        p1 = new Person("omar", 3, 2, 1, "mars");
        Person p2;
        Planet pfull;
        pfull = new Planet("mars", 1, 1, 1, 1);
        p2 = new Person("jack", 1, 1, 1, "mars");
        for (int i = 0; i < planet.getAvailability(); i++) {
            planet.addPerson(p1);
        }
        pfull.addPerson(p1);
        assertFalse(pfull.addPerson(p2));
        assertEquals(50, planet.getPopulationSize());
        assertFalse(planet.addPerson(p2));
    }


    /**
     * tests whther a person is qualified
     */
    public void testIsQualified() {
        Person p1;
        p1 = new Person("omar", 4, 4, 4, "Mercury");
        assertTrue(planet.isQualified(p1));
        Person p2;
        p2 = new Person("omar", 1, 1, 1, "Mercury");
        assertFalse(planet.isQualified(p2));

    }


    /**
     * toString test
     */
    public void testToString() {
        assertEquals(
            "Mercury, population 0 (cap: 100), Requires: A >= 3, M >= 2, "
                + "T >= 1", planet.toString());

    }


    /**
     * compare test
     */
    public void testCompareTo() {
        Planet p1;
        Planet p2;
        Planet p3;
        p1 = new Planet("Mars", 2, 1, 2, 600);
        p2 = new Planet("Moon", 1, 4, 3, 50);
        p3 = new Planet("Mercury", 3, 2, 1, 100);

        assertTrue(planet.compareTo(p2) > 0);
        assertTrue(planet.compareTo(p1) < 0);
        assertEquals(0, planet.compareTo(p3));

    }


    /**
     * equals method test
     */
    public void testEquals() {
        Object obj = new Object();
        Planet p1;
        Planet p2;
        Planet p3;
        Planet p4 = null;
        Planet p5;
        Planet p6;
        Planet p7;

        p1 = new Planet("Mars", 2, 1, 2, 60);
        p2 = new Planet("Moon", 1, 4, 3, 50);
        p3 = new Planet("Mercury", 3, 2, 1, 100);
        p5 = new Planet("sun", 2, 1, 2, 60);
        p6 = new Planet("Mars", 1, 1, 1, 60);
        p7 = new Planet("Mars", 2, 1, 2, 100);

        assertFalse(planet.equals(p4));
        assertTrue(planet.equals(planet));
        assertFalse(planet.equals(obj));

        assertTrue(planet.equals(p3));
        assertFalse(planet.equals(p2));

        assertFalse(p2.equals(p1));
        // name test
        assertFalse(p1.equals(p5));
        // min skills test
        assertFalse(p1.equals(p6));
        // capacity test
        assertFalse(p1.equals(p7));

        planet.addPerson(person);

        // tests size difference
        assertFalse(p3.equals(planet));

    }

}
