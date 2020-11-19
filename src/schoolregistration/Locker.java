/*
 contains information about the student's locker
 */
package schoolregistration;

import java.util.ArrayList;


public class Locker {

    private int number;
    private int[] combo;

    /**
     *Array list of unused lockers in the school
     */
    static public ArrayList<Integer> unusedLockers = new ArrayList<Integer>();
    
    /**
     *  gets and removes number from unused locker array list
     * @return
     */
    public int getNewNumber() {
        int num;
        num=unusedLockers.get(0);
        unusedLockers.remove(0);
        return num;
    }

    /**
     * Constructor
     */
    public Locker() {
        number = 0;
        combo = new int[3];
    }

    /**
     * overload constructor
     * @param number
     * @param combo
     */
    public Locker(int number, int[] combo) {
        this.number = number;
        this.combo = combo;
    }

    /**
     *
     * @return
     */
    public String getCombo() {
        String word = "";

        for (int i = 0; i < combo.length; i++) {
            if (i < combo.length - 1) {
                word = word + combo[i] + "-";
            } else {
                word = word + combo[i];
            }
        }
        return word;
    }

    /**
     *
     * @return
     */
    public int getNumber() {
        return number;
    }

    /**
     *
     * @param combo
     */
    public void setCombo(int[] combo) {
        this.combo = combo;
    }

    /**
     *
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String comboString="";
        for (int i = 0; i < combo.length; i++) {
            comboString=comboString+combo[i]+",";
        }
        
        return "\nLocker #: " + number + " Combo: " + comboString;
    }



    
    
}
