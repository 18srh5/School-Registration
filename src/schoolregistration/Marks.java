/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolregistration;
import java.util.ArrayList;


public class Marks {
    private ArrayList<Integer> grades;
    
    /**
     * constructor
     */
    public Marks() {
       grades=new ArrayList<Integer>();
       
    }

    /**
     * overload constructor
     * @param grades
     */
    public Marks(ArrayList<Integer> grades) {
        this.grades = grades;
    }

    /**
     *  
     * @return
     */
    public ArrayList<Integer> getGrades() {
        return grades;
    }

    /**
     *
     * @param grades
     */
    public void setGrades(ArrayList<Integer> grades) {
        this.grades = grades;
    }
    
    /**
     * calculates the average of all the grades
     * @return
     */
    public double calculateAverage() {
        int total=0;
        double average;
        
        for (int i = 0; i < grades.size(); i++) {
            total=total+grades.get(i);
        }
        average=total/grades.size();
        return average;
    }

    /**
     * returns all the grades as a string
     * @return
     */
    @Override
    public String toString() {
        String marks="\nMarks: ";
        for (int i = 0; i < grades.size(); i++) {
            marks=marks+grades.get(i)+", ";
        }
        
        return marks;
        
    }
    
    
    
    
    
}
