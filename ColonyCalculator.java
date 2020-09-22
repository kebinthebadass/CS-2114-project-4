/// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Omar Alshikh (omar99)
package spacecolonies;

import java.util.Arrays;
import list.AList;

/**
 * class that handles where a person belongs
 * 
 * @author omaralshikh
 * @version 11/11/19
 */
public class ColonyCalculator {
    /**
     * how many planets there are
     */
    public static final int NUM_PLANETS = 3;
    /**
     * minimum required skill level
     */
    public static final int MIN_SKILL_LEVEL = 1;
    /**
     * Max skill level required
     */
    public static final int MAX_SKILL_LEVEL = 5;
    private ArrayQueue<Person> applicantQueue;
    private AList<Person> rejectBus;
    private static Planet[] planets = new Planet[NUM_PLANETS + 1];


    /**
     * constructor
     * 
     * @param person
     *            person from the queue
     * @param planets
     *            planet array
     */
    public ColonyCalculator(ArrayQueue<Person> person, Planet[] planets) {
        if (person == null) {
            throw new IllegalArgumentException();
        }
        applicantQueue = person;
        ColonyCalculator.planets = planets;
        rejectBus = new AList<Person>();
    }


    /**
     * getter method for the queue
     * 
     * @return applicant in the queue
     */
    public ArrayQueue<Person> getQueue() {
        return applicantQueue;

    }


    /**
     * getter method for the planets
     * 
     * @return the planets given
     */
    public static Planet[] getPlanets() {
        return planets;
    }


    /**
     * method that dictates whether a person is elligible to enter the planets
     * he/she desires, and if not decide whether they are eligible to enter
     * another planet
     * 
     * @param nextPerson
     *            person to be scanned
     * @return null if not eligible
     */
    public Planet getPlanetForPerson(Person nextPerson) {
        if (!applicantQueue.isEmpty() && nextPerson != null) {

            int preference = getPlanetIndex(nextPerson.getPlanetName());

            if (getPreferredPlanet(nextPerson, preference) != null) {
                return getPreferredPlanet(nextPerson, preference);
            }

            // if they don't have preference
            else {

                if (getMostAvailabilePlanet(nextPerson) != null) {
                    return getMostAvailabilePlanet(nextPerson);
                } // end if
            } // end else

        } // end first if

        return null;

    }


    /**
     * helper method
     * planet thats picked by person by checking if the person is eligible and
     * whether the planet wanted is available
     * 
     * @param psn
     *            person to be checked
     * @param num
     *            number of planet
     * @return planet desired, if not return null
     */
    private Planet getPreferredPlanet(Person psn, int num) {
        Planet planet = this.planetByNumber(num);
        if (planet != null && !planet.isFull() && planet.getSkills().isBelow(psn
            .getSkills())) {

            return planet;
        }

        return null;

    }


    // planet with most space
    /**
     * helper method that checks to see where there is the most space so it can
     * send the person to it with no preference for planet selection planet with
     * most space
     * 
     * @param psn
     *            person checked
     * @return planet allowed
     */
    private Planet getMostAvailabilePlanet(Person psn) {

        Planet[] planet;

        planet = new Planet[planets.length];
        for (int i = 1; i < planet.length; i++) {
            planet[i] = planets[i];
        }
        Arrays.sort(planet, 1, planets.length);
        for (int j = NUM_PLANETS; j > 0; j--) {
            if (!planet[j].isFull() && planet[j].getSkills().isBelow(psn
                .getSkills())) {
                return planet[j];
            }
        }

        return null;

    }


    /**
     * checks whether to accept person
     * 
     * @return true if accepted, false if otherwise
     */
    public boolean accept() {
        Person p;
        if (!applicantQueue.isEmpty()) {
            p = applicantQueue.getFront();
            Planet planet = getPlanetForPerson(p);
            if (planet != null) {
                planet.addPerson(p);
                applicantQueue.dequeue();
                return true;
            }

        }
        return false;
    }


    /**
     * rejects person and send the person on the bus back to school
     */
    public void reject() {

        rejectBus.add(applicantQueue.dequeue());
    }


    /**
     * makes sure that the planet number is between 1 and 3
     * 
     * @param num
     *            number of planet
     * @return number of planet
     */
    public Planet planetByNumber(int num) {

        if (num >= 1 && num <= 3) {
            return planets[num];
        }

        return null;

    }


    /**
     * gets the iondex of the planet
     * 
     * @param planet
     *            string name of planet
     * @return index number
     */
    public int getPlanetIndex(String planet) {
        for (int i = 1; i <= 3; i++) {
            if (planets[i].getName().equals(planet)) {
                return i;
            }
        }

        return 0;

    }

}
