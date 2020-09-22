/// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Omar Alshikh (omar99)
package spacecolonies;

/**
 * class that holds the applicant information like skills,name,and preference
 * 
 * @author omaralshikh
 * @version 11/11/2019
 */
public class Person {
    private String name;
    private Skills skills;
    private String planetPrefrence;


    /**
     * constructor that takes 5 parameters
     * 
     * @param name
     *            name of person
     * @param agri
     *            agriculture skill level
     * @param medi
     *            Medicine skill level
     * @param tech
     *            Technology skill level
     * @param planet
     *            planet that the person wants
     */
    public Person(String name, int agri, int medi, int tech, String planet) {
        // Initializing the param
        this.name = name;
        skills = new Skills(agri, medi, tech);
        planetPrefrence = planet;

    }


    /**
     * getter method for name of person
     * 
     * @return name of person
     */
    public String getName() {
        return name;
    }


    /**
     * getter method for skills
     * 
     * @return skills of person
     */
    public Skills getSkills() {
        return skills;

    }


    /**
     * getter method for planet name
     * 
     * @return preference of person
     */
    public String getPlanetName() {
        return planetPrefrence;
    }


    /**
     * toString method that outputs skills and planet pref
     * 
     * @return text that goes onto the window
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (planetPrefrence.length() > 0) {
            result.append("");
            result.append(name);
            result.append(" A:");
            result.append(skills.getAgriculture());
            result.append(" M:");
            result.append(skills.getMedicine());
            result.append(" T:");
            result.append(skills.getTechnology());
            result.append(" Wants: ");
            result.append(planetPrefrence);
        }
        else {
            result.append("No-Planet ");
            result.append("");
            result.append(name);
            result.append(" A:");
            result.append(skills.getAgriculture());
            result.append(" M:");
            result.append(skills.getMedicine());
            result.append(" T:");
            result.append(skills.getTechnology());
        }

        return result.toString();
    }


    /**
     * equals method
     * two people are equals if they have the same name, skills and planet
     * preference
     * 
     * @param obj
     *            object to compare with
     * @return false if any of the above is false
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } // end if
        if (obj == null) {
            return false;
        } // end if

        if (this.getClass() == obj.getClass()) {
            // type cast
            Person pObj = (Person)obj;

            if (!this.name.equals(pObj.name)) {
                return false;
            }
            if (!this.skills.equals(pObj.skills)) {
                return false;
            }

            return (this.planetPrefrence.equals(pObj.planetPrefrence));  

        }
        return false;

    } // end equals method

} // end class
