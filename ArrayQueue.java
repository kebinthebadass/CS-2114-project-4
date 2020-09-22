/// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Omar Alshikh (omar99)
package spacecolonies;

import queue.EmptyQueueException;
import queue.QueueInterface;

/**
 * class for the queue of people
 * 
 * @author omaralshikh
 * @param <T>
 *            type of arrayQueue
 * @version 11/11/2019
 */
public class ArrayQueue<T> implements QueueInterface<T> {

    private T[] queue;
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * max capacity allowed
     */
    public static final int MAX_CAPACITY = 100;
    private int enqueueIndex;
    private int dequeueIndex;
    private int size;


    /**
     * constructor
     * adds 1 to default capacity but only holds 10 elements
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue() {

        queue = (T[])new Object[DEFAULT_CAPACITY + 1];
        dequeueIndex = 0;
        enqueueIndex = getLength() - 1;
        size = 0;

    }


    /**
     * getter method for length of queue
     * 
     * @return queue length
     */
    public int getLength() {
        return queue.length;
    }


    /**
     * getter method for size
     * 
     * @return size of queue
     */
    public int getSize() {
        return size;
    }


    /**
     * when queue is empty
     * 
     * @return size is 0
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * when queue is full
     * 
     * @return expands queue
     */
    private boolean isFull() {
        return (dequeueIndex == ((enqueueIndex + 2) % queue.length));
    }


    /**
     * adds people to queue
     */
    @Override
    public void enqueue(T newEntry) {
        ensureCapacity();
        enqueueIndex = incrementIndex(enqueueIndex);
        queue[enqueueIndex] = newEntry;
        size++;
    }


    /**
     * used when queue is full
     * doubles size of queue once its full
     */
    private void ensureCapacity() {
        if (isFull()) {

            T[] oldQueue = queue;
            int oldSize = oldQueue.length;
            int newSize = 2 * oldSize - 1;
            if (newSize > MAX_CAPACITY) {
                throw new IllegalStateException();
            }

            @SuppressWarnings("unchecked")
            T[] tempQueue = (T[])new Object[newSize];
            queue = tempQueue;

            for (int index = 0; index < oldSize - 1; index++) {
                queue[index] = oldQueue[dequeueIndex];
                dequeueIndex = (dequeueIndex + 1) % oldSize;
            } // end for loop
            dequeueIndex = 0;
            enqueueIndex = oldSize - 2;

        }

    }


    /**
     * removes one item at a time
     * 
     * @return front of queue after it removes an item
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        else {
            T front = queue[dequeueIndex];
            queue[dequeueIndex] = null;
            dequeueIndex = (dequeueIndex + 1) % queue.length;
            size--;
            return front;
        }

    }


    /**
     * getter method for front of queue
     * 
     * @return front of queue
     */
    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        else {
            return queue[dequeueIndex];

        }
    }


    /**
     * clears the queue
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear() {

        queue = (T[])new Object[DEFAULT_CAPACITY + 1];
        dequeueIndex = 0;
        enqueueIndex = getLength() - 1;
        size = 0;

    }


    /**
     * increments the index
     * 
     * @return adds into the queue
     */
    private int incrementIndex(int index) {

        return ((index + 1) % queue.length);

    }


    /**
     * to Array method that copys the queue
     * 
     * @return the copy
     */
    public Object[] toArray() {

        if (isEmpty()) {
            throw new EmptyQueueException();
        } // end if
        else {
            @SuppressWarnings("unchecked")
            T[] copy = (T[])new Object[this.size];
            for (int i = 0; i < this.size; i++) {
                copy[i] = this.queue[(dequeueIndex + i) % queue.length];
            } // end for loop

            return copy;
        } // end else
    }


    /**
     * to String method
     * 
     * @return toString text
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        // when queue is empty use [] as the text
        if (isEmpty()) {
            result.append("[]");
            return result.toString();
        }
        // if not empty surround the text with brackets and use a coma
        else {
            result.append("[");
            for (int i = 0; i < this.size; i++) {

                result.append(queue[(dequeueIndex + i) % queue.length]
                    .toString());
                if (i < this.size - 1) {
                    result.append(", ");

                }
            }
            result.append("]");

        }

        return result.toString();

    }


    /**
     * equals method
     * 
     * 
     * @param obj
     *            to be compared with
     * @return false when all fails
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } // end if
        if (obj == null) {
            return false;
        } // end if

        if (this.getClass() == obj.getClass()) {

            @SuppressWarnings("unchecked")
            ArrayQueue<T> other = (ArrayQueue<T>)obj;
            if (other.size != this.size) {
                return false;
            }
            else {

                for (int i = 0; i < this.size; i++) {

                    T myElement = queue[(dequeueIndex + i) % queue.length];

                    T otherElement = other.queue[(other.dequeueIndex + i)
                        % other.queue.length];

                    if (!myElement.equals(otherElement)) {

                        return false;
                    }

                }
                return true;
            }
        }

        return false;

    }

} // end class
