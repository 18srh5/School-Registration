/*

 */
package schoolregistration;

public class TimeTable {
    private int[] classNum; 
    private String [] className, teacher;

    /**
     *Constructor
     */
    public TimeTable() {
        classNum=new int[8];
        teacher=new String [8];
        className=new String [8];
                
    }

    /**
     *overload constructor
     * @param className
     */
    public TimeTable(String[] className) {
        this.className = className;
        this.classNum=new int[8];
        this. teacher=new String [8];
    }

    /**
     *matches the teacher and classroom number for the subject
     */
    public void matchTeacherAndNumber(){
        for (int i = 0; i < className.length; i++) {
            
            
            if(className[i].equalsIgnoreCase("Science     ")){
                teacher[i]="Ms. Chan    ";
                classNum[i]=226;
            }
            else if(className[i].equalsIgnoreCase("Math        ")){
                teacher[i]="Mr. Azar    ";
                classNum[i]=217;
            }
            else if(className[i].equalsIgnoreCase("English     ")){
                teacher[i]="Mr. Woods   ";
                classNum[i]=2006;
            }
            else if(className[i].equalsIgnoreCase("Buisness    ")){
                teacher[i]="Ms. Kwong   ";
                classNum[i]=221;
            }
            else if(className[i].equalsIgnoreCase("Computer Science")){
                teacher[i]="Mr. Ganuelas    ";
                classNum[i]=214;
            }
            else if(className[i].equalsIgnoreCase("Religion    ")){
                teacher[i]="Ms. DeLuca  ";
                classNum[i]=1106;
            }
            else if(className[i].equalsIgnoreCase("Music       ")){
                teacher[i]="Mr. Ng      ";
                classNum[i]=108;
            }
            else{
                teacher[i]="Suprise     ";
                classNum[i]=100;
            }
            
        }
        
    }

    /**
     *
     * @return
     */
    public String[] getClassName() {
        return className;
    }
    
    /**
     *puts all class names into one string
     * @return
     */
    public String displayClassName(){
        String classNamesString="";
        
        for (int i = 0; i < className.length; i++) {
         classNamesString=classNamesString+className[i]+" ";   
        }
        classNamesString=classNamesString.toUpperCase();
        return classNamesString;
    }

    /**
     *
     * @return
     */
    public int[] getClassNum() {
        return classNum;
    }

    /**
     * puts all classroom numbers into a single string
     * @return
     */
    public String displayClassNum(){
        String classNumsAll="";
        
        for (int i = 0; i < classNum.length; i++) {
         classNumsAll=classNumsAll+classNum[i]+"         ";   
        }
        
        return classNumsAll;
    }
    
    /**
     *
     * @return
     */
    public String[] getTeacher() {
        return teacher;
    }
    
    /**
     *puts all teacher names into single string
     * @return
     */
    public String displayTeacher(){
        String teachersAll="";
        
        for (int i = 0; i < teacher.length; i++) {
          teachersAll= teachersAll+teacher[i]+" ";   
        }
        
        return  teachersAll;
    }
    
    /**
     *
     * @param className
     */
    public void setClassName(String[] className) {
        this.className = className;
    }

    /**
     *
     * @param classNum
     */
    public void setClassNum(int[] classNum) {
        this.classNum = classNum;
    }

    /**
     *
     * @param teacher
     */
    public void setTeacher(String[] teacher) {
        this.teacher = teacher;
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
