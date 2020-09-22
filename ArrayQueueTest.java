/// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Omar Alshikh (omar99)
package spacecolonies;

import org.junit.Before;
import queue.EmptyQueueException;
import student.TestCase;

/**
 * test class for arrayQueue
 * 
 * @author omaralshikh
 * @version 11/11/2019
 */
public class ArrayQueueTest extends TestCase {
    private ArrayQueue<String> array;
    private Person psn;
    private Person psn2;
    private Person psn3;


    /**
     * set up method
     * makes 3 different people
     * 
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        array = new ArrayQueue<String>();

        psn = new Person("omar", 2, 1, 3, "mars");
        psn2 = new Person("omar", 2, 1, 3, "");
        psn3 = new Person("om", 2, 2, 2, "moon");
    }


    /**
     * tests the length of the queue
     */
    public void testGetLength() {
        assertEquals(11, array.getLength());

    }


    /**
     * tests the size of the queue
     */
    public void testGetSize() {
        assertEquals(0, array.getSize());
        array.enqueue("red");
        assertEquals(1, array.getSize());
    }


    /**
     * tests when the queue is empty
     */
    public void testIsEmpty() {
        assertTrue(array.isEmpty());
        array.enqueue("red");
        assertFalse(array.isEmpty());
    }


    /**
     * tests when a person is enqueued into the queue
     */
    public void testEnqueue() {
        String message = "hello";
        String m2 = "hey";
        String m3 = "hi";

        array.enqueue(message);
        assertEquals(1, array.getSize());
        assertEquals(array.dequeue(), message);
        assertEquals(0, array.getSize());
        for (int i = 1; i < array.getLength(); i++) {
            array.enqueue(m2);
        }
        assertEquals(10, array.getSize());
        array.enqueue(m3);
        assertEquals(21, array.getLength());

        assertEquals(11, array.getSize());

        for (int i = 1; i < 70; i++) {
            array.enqueue(m3);

        }

        assertEquals(81, array.getLength());

        Exception thrown = null;
        try {
            // call method here that will throw the exception
            array.enqueue(m2);
        }
        catch (Exception exception) {
            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof IllegalStateException);

    }


    /**
     * dequeue test
     */
    public void testDequeue() {

        String message = "hello";
        array.enqueue(message);
        assertEquals(1, array.getSize());

        assertEquals(array.dequeue(), message);
        assertEquals(0, array.getSize());

        Exception thrown = null;
        try {
            // call method here that will throw the exception
            array.dequeue();
        }
        catch (Exception exception) {
            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof EmptyQueueException);

    }


    /**
     * tests the front of the queue
     */
    public void testGetFront() {
        Exception thrown = null;
        try {
            // call method here that will throw the exception
            array.getFront();
        }
        catch (Exception exception) {
            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof EmptyQueueException);
        assertEquals(0, array.getSize());

        array.enqueue("msg");
        assertEquals(1, array.getSize());
        assertEquals("msg", array.getFront());

    }


    /**
     * clear test
     */
    public void testClear() {
        array.enqueue("msg");
        array.clear();
        assertEquals(0, array.getSize());

    }


    /**
     * to Array test
     */
    public void testToArray() {
        Exception thrown = null;
        try {
            // call method here that will throw the exception
            array.toArray();
        }
        catch (Exception exception) {
            thrown = exception;
        }

        // checks whether an Exception was actually thrown
        assertNotNull(thrown);

        // checks whether the right type of Exception was thrown
        assertTrue(thrown instanceof EmptyQueueException);

        array.enqueue("space");
        array.enqueue("earth");
        Object[] stk = array.toArray();
        assertEquals(stk[0], "space");
        assertEquals(stk[1], "earth");

    }


    /**
     * to String test
     */
    public void testToString() {
        ArrayQueue<Person> ar;
        ar = new ArrayQueue<Person>();
        assertEquals("[]", array.toString());
        ar.enqueue(psn);
        ar.enqueue(psn2);
        assertEquals(
            "[omar A:2 M:1 T:3 Wants: mars, No-Planet omar A:2 M:1 T:3]", ar
                .toString());

    }


    /**
     * equals test
     */
    public void testEquals() {
        Object obj = new Object();
        ArrayQueue<String> a1 = null;
        ArrayQueue<Person> a2;
        ArrayQueue<Person> a3;
        ArrayQueue<Person> a4;
        ArrayQueue<Person> a5;

        a2 = new ArrayQueue<Person>();
        a3 = new ArrayQueue<Person>();
        a4 = new ArrayQueue<Person>();
        a5 = new ArrayQueue<Person>();

        assertFalse(array.equals(a1));
        assertTrue(array.equals(array));
        assertFalse(array.equals(obj));
        a2.enqueue(psn);
        a2.enqueue(psn2);
        a3.enqueue(psn);
        assertFalse(a2.equals(a3));
        a4.enqueue(psn);
        a4.enqueue(psn2);
        assertEquals(a2, a4);
        a5.enqueue(psn2);
        a5.enqueue(psn3);
        assertFalse(a4.equals(a5));

    }

}
