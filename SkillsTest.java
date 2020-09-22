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
 * test class
 * 
 * @author omaralshikh
 * @version 11/11/2019
 */
public class SkillsTest extends TestCase {
    private Skills skill;


    /**
     * set up method
     * 
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        skill = new Skills(2, 1, 3);
    }


    /**
     * tests the skill level for agriculture
     */
    public void testGetAgriculture() {
        assertEquals(2, skill.getAgriculture());

    }


    /**
     * tests the skill level for medicine
     */
    public void testGetMedicine() {
        assertEquals(1, skill.getMedicine());

    }


    /**
     * tests the skill level for technology
     */
    public void testGetTechnology() {
        assertEquals(3, skill.getTechnology());

    }


    /**
     * tests is below method
     * 1) first is false 2) when first is true and second is false 3) first
     * two are true and third is false
     * 4) when all true
     */
    public void testIsBelow() {

        Skills skill2;
        Skills skill3;
        Skills skill4;
        Skills skill5;
        skill2 = new Skills(1, 3, 3);
        skill3 = new Skills(2, 3, 1);
        skill4 = new Skills(2, 1, 1);
        skill5 = new Skills(2, 1, 3);

        assertFalse(skill.isBelow(skill2));
        assertFalse(skill.isBelow(skill3));
        assertFalse(skill.isBelow(skill4));
        assertTrue(skill.isBelow(skill5));
        assertFalse(skill2.isBelow(skill4));

    }


    /**
     * toString test
     */
    public void testToString() {

        assertEquals("A:2 M:1 T:3", skill.toString());

    }


    /**
     * equals test
     */
    public void testEquals() {
        Object obj = new Object();
        Skills st = null;
        Skills st2;
        Skills st3;
        Skills st4;
        Skills st5;
        st2 = new Skills(2, 1, 3);
        st3 = new Skills(3, 2, 1);
        st4 = new Skills(2, 2, 1);
        st5 = new Skills(2, 1, 2);
        assertFalse(skill.equals(st));
        assertTrue(skill.equals(skill));
        assertFalse(skill.equals(obj));
        // skill is (2,1,3)
        assertTrue(skill.equals(st2));
        assertFalse(skill.equals(st3));
        assertFalse(skill.equals(st4));
        assertFalse(skill.equals(st5));

    }

}
