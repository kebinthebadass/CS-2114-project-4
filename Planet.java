/// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Omar Alshikh (omar99)
package spacecolonies;

/**
 * class for the planets info
 * 
 * @author omaralshikh
 * @version 11/11/19
 */
public class Planet implements Comparable<Planet> {

    private String name;
    private Skills minSkills;
    private Person[] population;
    private int populationSize;
    private final int capacity;


    /**
     * constructor
     * 
     * @param planetName
     *            name of the planet
     * @param planetAgri
     *            skill level of agriculture
     * @param planetMedi
     *            planet skill level of medication
     * @param planetTech
     *            planet skill level of technology
     * @param planetCap
     *            planets capacity
     */
    public Planet(
        String planetName,
        int planetAgri,
        int planetMedi,
        int planetTech,
        int planetCap) {

        name = planetName;
        minSkills = new Skills(planetAgri, planetMedi, planetTech);
        capacity = planetCap;
        population = new Person[capacity];
        populationSize = 0;
    }


    /**
     * setter method for planet name
     * 
     * @param name
     *            name of planet
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * getter method for name of planet
     * 
     * @return name of planet
     */
    public String getName() {
        return name;
    }


    /**
     * getter method for skill level of planet
     * 
     * @return minimum required skills
     */
    public Skills getSkills() {
        return minSkills;
    }


    /**
     * getter method for population of planet
     * 
     * @return population
     */
    public Person[] getPopulation() {
        return population;
    }


    /**
     * getter method for population size
     * 
     * @return population size
     */
    public int getPopulationSize() {
        return populationSize;
    }


    /**
     * getter method for capacity of planet
     * 
     * @return capacity of planet
     */
    public int getCapacity() {
        return capacity;
    }


    /**
     * getter method for spaces left in planet
     * 
     * @return capacity - population size
     */
    public int getAvailability() {
        return (getCapacity() - getPopulationSize());
    }


    /**
     * checks whether a planet is full
     * 
     * @return when size is equal to capacity
     */
    public boolean isFull() {
        return getPopulationSize() == capacity;

    }


    /**
     * adds a person to planet when planet is not full and person is qualified
     * based on skills
     * 
     * @param newbie
     *            person to be added
     * 
     * @return true if added
     */
    public boolean addPerson(Person newbie) {
        if (!isFull() && isQualified(newbie)) {
            population[populationSize] = newbie;
            populationSize++;
            return true;

        }
        return false;

    }


    /**
     * checks to see if applicant is eligible to enter planet
     * 
     * @param applicant
     *            person to be considered
     * 
     * @return must meet min skills levels
     */
    public boolean isQualified(Person applicant) {
        return minSkills.isBelow(applicant.getSkills());

    }


    /**
     * toString method that takes care of the output on the window
     * 
     * @return planet name, skill level, and capacity
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("");
        result.append(name);
        result.append(",");
        result.append(" population ");
        result.append(getPopulationSize());
        result.append(" (cap: ");
        result.append(getCapacity());
        result.append(")");
        result.append(", Requires: ");
        result.append("A >= ");
        result.append(minSkills.getAgriculture());
        result.append(", M >= ");
        result.append(minSkills.getMedicine());
        result.append(", T >= ");
        result.append(minSkills.getTechnology());
        return result.toString();

    }


    /**
     * equals method
     * two object are equal when their name is equal
     * two object are equal when their skills are equal
     * two object are equal when their capacity are equal
     * two object are equal when their population size are equal
     * 
     * @param obj
     *            to be compared with
     * @return false if all fails
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } // end if
        if (obj == null) {
            return false;
        } // end if
        if (this.getClass() == obj.getClass()) {
            Planet pObj = (Planet)obj;
            if (!this.name.equals(pObj.name)) {
                return false;
            }
            if (!this.minSkills.equals(pObj.minSkills)) {
                return false;
            }

            if (this.capacity != pObj.capacity) {
                return false;
            }

            return this.populationSize == pObj.populationSize;

        }
        return false;
    }


    /**
     * compare method
     * compared tow planets based on availability
     * 
     * @param other
     *            planet to be compared with
     * @return 1 if this planet has more space and -1 if not and 0 if equal
     */
    @Override
    public int compareTo(Planet other) {
        if (this.getAvailability() > other.getAvailability()) {
            return 1;
        }
        else if (this.getAvailability() < other.getAvailability()) {
            return -1;
        }

        return 0;
    }

}
