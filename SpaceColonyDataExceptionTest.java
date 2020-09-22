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
 * test for super call
 * 
 * @author omaralshikh
 * @version 11/11/2019
 */
public class SpaceColonyDataExceptionTest extends TestCase {

    private SpaceColonyDataException space;


    /**
     * set up method
     * 
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        String str;

        str = "test";
        space = new SpaceColonyDataException(str); 
    }


    /**
     * tests the super call
     */
    public void testSpaceColonyDataException() {

        assertNotNull(space);

    }

}
