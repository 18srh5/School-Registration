/*

 */
package schoolregistration;


public class GradRequirements {

    private int[] groups;
    private int compulsory, communityHours;

    /**
     *Constructor
     */
    public GradRequirements() {
        groups = new int[3];
        compulsory = 0;
        communityHours = 0;
    }

    /**
     *  Overload constructor
     * @param groups
     * @param compulsory
     * @param communityHours
     */
    public GradRequirements(int[] groups, int compulsory, int communityHours) {
        this.groups = groups;
        this.compulsory = compulsory;
        this.communityHours = communityHours;
    }
   
    /**
     *  turns array into a single string
     * @return
     */
    public String displayGroups() {
       String groupString="A B C\n       ";
        for (int i = 0; i < groups.length; i++) {
            groupString=groupString+groups[i]+" ";
        }
        return groupString;
    }

    /**
     *  
     * @return
     */
    public int getCommunityHours() {
        return communityHours;
    }

    /**
     *
     * @return
     */
    public int getCompulsory() {
        return compulsory;
    }

    /**
     *
     * @return
     */
    public int[] getGroups() {
        return groups;
    }

    /**
     *
     * @param communityHours
     */
    public void setCommunityHours(int communityHours) {
        this.communityHours = communityHours;
    }

    /**
     *
     * @param compulsory
     */
    public void setCompulsory(int compulsory) {
        this.compulsory = compulsory;
    }

    /**
     *
     * @param groups
     */
    public void setGroups(int[] groups) {
        this.groups = groups;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    

}
