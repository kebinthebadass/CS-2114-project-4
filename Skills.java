/// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
/// do.
// -- Omar Alshikh (omar99)
package spacecolonies;

/**
 * skills class that acquires the skills in numbers
 * 
 * @author omaralshikh
 * @version 11/11/2019
 */
public class Skills {
    // Initialize skill names
    private int agriculture;
    private int medicine;
    private int technology;


    /**
     * constructor that takes 3 skill param
     * 
     * @param ag
     *            agriculture
     * @param med
     *            Medicine
     * @param tech
     *            Technology
     */
    public Skills(int ag, int med, int tech) {

        agriculture = ag;
        medicine = med;
        technology = tech;

    }


    /**
     * getter method for agriculture skill level
     * 
     * @return skill level in agriculture
     */
    public int getAgriculture() {
        return agriculture;
    }


    /**
     * getter method for medicine skill level
     * 
     * @return skill level in medicine
     */
    public int getMedicine() {
        return medicine;
    }


    /**
     * getter method for technology skill level
     * 
     * @return skill level in technology
     */
    public int getTechnology() {
        return technology;
    }


    /**
     * checking if skills are below whats required
     * 
     * @param other
     *            skill to be compared to
     * @return returns true when the skill provided is less than or equal to
     *         other skill
     */
    public boolean isBelow(Skills other) {

        return (this.agriculture <= other.agriculture
            && this.medicine <= other.medicine
            && this.technology <= other.technology);

    }


    /**
     * ToString method
     * 
     * @return outputs skill levels in numbers for each category
     */
    public String toString() {

        StringBuilder output = new StringBuilder();
        output.append("A:");
        output.append(agriculture);
        output.append(" M:");
        output.append(medicine);
        output.append(" T:");
        output.append(technology);
        return output.toString();

    }


    /**
     * two people skill level are equals if they have the same skills
     * 
     * @param obj
     *            object to be compared with
     * @return returns false if above is not true
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } // end if
        if (obj == null) {
            return false;
        } // end if

        if (this.getClass() == obj.getClass()) {
            Skills skObj = (Skills)obj;
            if (this.agriculture != skObj.agriculture) {
                return false;
            }
            if (this.medicine != skObj.medicine) {
                return false;
            }

            return this.technology == skObj.technology;
        }
        return false;

    }

} // end class
