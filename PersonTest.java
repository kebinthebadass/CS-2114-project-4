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
 * @author omaralshikh
 * @version 11/11/2019
 */
public class PersonTest extends TestCase {

    private Person person;


    /**
     * set up method
     * 
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {

        person = new Person("omar", 2, 1, 3, "mars");
    }


    /**
     * tests name of the person
     */
    public void testGetName() {
        assertEquals("omar", person.getName());
    }


    /**
     * tests the skills of person
     */
    public void testGetSkills() {
        assertEquals("A:2 M:1 T:3", person.getSkills().toString());
    }


    /**
     * tests if the wanted planet is correct
     */
    public void testGetPlanetName() {
        assertEquals("mars", person.getPlanetName());
    }


    /**
     * tests toString method and to see if the output is correct when there is
     * and there isn't a preference
     */
    public void testToString() {
        assertEquals("omar A:2 M:1 T:3 Wants: mars", person.toString());
        Person p;
        p = new Person("omar", 2, 1, 3, "");
        assertEquals("No-Planet omar A:2 M:1 T:3", p.toString());

    }


    /**
     * equals method test
     */
    public void testEquals() {

        Object obj = new Object();

        Person p1 = null;
        Person p2;
        Person p3;
        Person p4;
        Person p5;
        p2 = new Person("omar", 2, 1, 3, "mars");
        p3 = new Person("omar", 3, 4, 2, "moon");
        p4 = new Person("omar", 2, 1, 3, "mercury");
        p5 = new Person("Jack", 2, 1, 3, "mars");

        assertFalse(person.equals(p1));
        assertTrue(person.equals(person));
        assertFalse(person.equals(obj));
        assertTrue(person.equals(p2));
        assertFalse(person.equals(p3));
        assertFalse(person.equals(p4));
        assertFalse(person.equals(p5));

    }

}
