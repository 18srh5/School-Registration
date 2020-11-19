/*
 */
package schoolregistration;

import java.util.Random;

public class Student {

    private int grade, sudentID;

    private PersonalInfo personalInfo;
    private Locker locker;
    private TimeTable timeTable;
    private EmergencyInfo emergencyInfo;
    private GradRequirements gradReq;
    private Marks marks;

    /**
     * Constructor
     */
    public Student() {
        this.sudentID = 0;
        this.grade = 0;
        this.personalInfo = new PersonalInfo();
        this.locker = new Locker();
        this.timeTable = new TimeTable();
        this.emergencyInfo = new EmergencyInfo();
        this.gradReq = new GradRequirements();
        this.marks = new Marks();
    }

    /**
     * Overload Constructor
     *
     * @param grade
     * @param personalInfo
     * @param locker
     * @param timeTable
     * @param emergencyInfo
     * @param gradReq
     * @param marks
     */
    public Student(int grade, PersonalInfo personalInfo, Locker locker, TimeTable timeTable, EmergencyInfo emergencyInfo, GradRequirements gradReq, Marks marks) {
        this.grade = grade;
        this.personalInfo = personalInfo;
        this.locker = locker;
        this.timeTable = timeTable;
        this.emergencyInfo = emergencyInfo;
        this.gradReq = gradReq;
        this.marks = marks;
    }

    /**
     * Randomizes student id
     *
     * @return String
     */
    public String generateStudentID() {
        int num;
        String id;
        Random rand = new Random();
        num = rand.nextInt(20000) + 10000;
        this.sudentID = num;
        id = "" + num;

        return id;
    }

    /**
     *
     * @return grade
     */
    public int getGrade() {
        return grade;
    }

    /**
     * Changes grade
     *
     * @param grade
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     *
     * @return String
     */
    public String getSudentID() {
        return "" + sudentID;
    }

    /**
     *
     * @return PersonalInfo
     */
    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    /**
     *
     * @return String
     */
    public String getLocker() {
        return locker.toString();
    }

    /**
     *
     * @return TimeTable
     */
    public TimeTable getTimeTable() {
        return timeTable;
    }

    /**
     * Combines variable information into single string
     *
     * @return String
     */
    public String displayTimeTable() {
        return timeTable.displayClassName() + "\n" + timeTable.displayTeacher() + "\n" + timeTable.displayClassNum();
    }

    /**
     * Combines variable information into single string
     *
     * @return String
     */
    public String displayGradReq() {
        return "Groups: " + gradReq.displayGroups() + "\nCompulsory Credits: " + gradReq.getCompulsory() + "\nService Hours: " + gradReq.getCommunityHours();
    }

    /**
     *
     * @return String
     */
    public String displayMarks() {
        return marks.toString();
    }

    /**
     *
     * @return String
     */
    public String displayPersonalInfo() {
        return personalInfo.toString();
    }

    /**
     *
     * @return String
     */
    public String displayEmergencyInfo() {
        return emergencyInfo.toString();
    }

    /**
     *
     * @return EmergencyInfo
     */
    public EmergencyInfo getEmergencyInfo() {
        return emergencyInfo;
    }

    /**
     *
     * @return GradRequirements
     */
    public GradRequirements getGradReq() {
        return gradReq;
    }

    /**
     *
     * @return Marks
     */
    public Marks getMarks() {
        return marks;
    }

    /**
     * Changes student ID
     *
     * @param sudentID
     */
    public void setSudentID(int sudentID) {
        this.sudentID = sudentID;
    }

    /**
     * Checks and Changes personal information
     *
     * @param firstName
     * @param lastName
     * @param street
     * @param city
     * @param province
     * @param phone
     * @param postalCode
     */
    public void setPersonalInfo(String firstName, String lastName, String street, String city, String province, String phone, String postalCode) {
        if (firstName.equals("") || firstName.equals(" ")) {
            firstName = personalInfo.getFirstName();
        }
        if (lastName.equals("") || lastName.equals(" ")) {
            lastName = personalInfo.getLastName();
        }
        if (street.equals("") || street.equals(" ")) {
            street = personalInfo.getStreet();
        }
        if (city.equals("") || city.equals(" ")) {
            city = personalInfo.getCity();
        }
        if (phone.equals("") || phone.equals(" ")) {
            phone = personalInfo.getPhone();
        }
        if (postalCode.equals("") || postalCode.equals(" ")) {
            postalCode = personalInfo.getPostalCode();
        }
        if (province.equals("") || province.equals(" ")) {
            province = personalInfo.getProvince();
        }

        this.personalInfo = new PersonalInfo(firstName, lastName, street, city, province, phone, postalCode);
    }

    /**
     * changes locker information
     *
     * @param number
     * @param combo
     */
    public void setLocker(int number, int[] combo) {
        this.locker = new Locker(number, combo);
    }

    /**
     * Create new timeTable
     *
     * @param className
     */
    public void setTimeTable(String[] className) {

        this.timeTable = new TimeTable(className);
        this.timeTable.matchTeacherAndNumber();
    }

    /**
     * changes timeTable
     *
     * @param oldClassName
     * @param newClassName
     */
    public void updateTimeTable(String oldClassName, String newClassName) {
        String[] className = timeTable.getClassName();

        for (int i = 0; i < className.length; i++) {
            if (className[i].equalsIgnoreCase(oldClassName)) {
                className[i] = newClassName;
            }
        }
        timeTable.setClassName(className);
        this.timeTable.matchTeacherAndNumber();
    }

    /**
     *
     * @param contact1Name
     * @param contact2Name
     * @param email1
     * @param email2
     * @param address1
     * @param address2
     * @param phone1
     * @param phone2
     */
    public void setEmergencyInfo(String contact1Name, String contact2Name, String email1, String email2, String address1, String address2, String phone1, String phone2) {
        if (contact1Name.equals("") || contact1Name.equals(" ")) {
            contact1Name = personalInfo.getFirstName();
        }
        if (contact2Name.equals("") || contact2Name.equals(" ")) {
            contact2Name = personalInfo.getLastName();
        }
        if (email1.equals("") || (email1.equals(" "))) {
            email1 = personalInfo.getStreet();
        }
        if (email2.equals("") || email2.equals(" ")) {
            email2 = personalInfo.getCity();
        }
        if (address1.equals("") || address1.equals(" ")) {
            address1 = personalInfo.getPhone();
        }
        if (address2.equals("") || address2.equals(" ")) {
            address2 = personalInfo.getPostalCode();
        }
        if (phone1.equals("") || phone1.equals(" ")) {
            phone1 = personalInfo.getProvince();
        }
        if (phone2.equals("") || phone2.equals(" ")) {
            phone2 = personalInfo.getProvince();
        }

            this.emergencyInfo = new EmergencyInfo(contact1Name, contact2Name, email1, email2, address1, address2, phone1, phone2);
        }
        /**
         * changes gradReq
         *
         * @param gradReq
         */
    public void setGradReq(GradRequirements gradReq) {
        this.gradReq = gradReq;
    }

    /**
     * changes marks
     *
     * @param marks
     */
    public void setMarks(Marks marks) {
        this.marks = marks;
    }

    /**
     * General information to identify student
     *
     * @return String
     */
    @Override
    public String toString() {
        return "First Name: " + personalInfo.getFirstName() + "     Last Name: " + personalInfo.getLastName();
    }

    /**
     * calls method to create new locker number
     *
     * @return
     */
    public int getNewNumber() {

        return (locker.getNewNumber());

    }

}
