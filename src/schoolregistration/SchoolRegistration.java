/*
Main Method Class
//advanced for loop
        //(personalInfo class, (x)temp variable, (list)
 */
package schoolregistration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import static schoolregistration.Locker.unusedLockers;

//
public class SchoolRegistration {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Main Method, runs initial methods and calls main menu.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        fillArrayList();
        ArrayList<Student> list = new ArrayList<>();
        createStudents(list);

        mainMenu(list);

    }

    /**
     * Prompts for user choice of action and calls appropriate method
     *
     * @param list
     * @throws IOException
     */
    public static void mainMenu(ArrayList<Student> list) throws IOException {
        int choice;
        System.out.println("--------------------");
        System.out.println("Main Menu\n");
        System.out.println("1. Display Students");
        System.out.println("2. Add Student");
        System.out.println("3. Remove Student");
        System.out.println("4. Update Student");
        System.out.println("5. Search Student");
        System.out.println("0. To exit");

        OUTER:
        do {
            System.out.print("Enter Selection: ");
            choice = Integer.parseInt(input.readLine());
            System.out.println(" ");
            switch (choice) {
                case 1:
                    displayAll(list);
                    break OUTER;
                case 2:
                    addStudent(list);
                    break OUTER;
                case 3:
                    removeStudent(list);
                    break OUTER;
                case 4:
                    updateStudentMenu(list);
                    break OUTER;
                case 5:
                    searchStudent(list);
                    break OUTER;
                default:
                    break OUTER;
            }
        } while (choice < 0 || choice > 5);

    }

    /**
     * Asks what object needs updating, and calls appropriate method
     *
     * @param list
     * @throws IOException
     */
    public static void updateStudentMenu(ArrayList<Student> list) throws IOException {
        int choice, person;

        int i = 1;
        System.out.println(" ");
        for (Student x : list) {
            System.out.println(i + ". " + x);
            i++;
        }
        System.out.print("Enter Student: ");
        person = Integer.parseInt(input.readLine());
        person = person - 1;

        System.out.println("--------------------");
        System.out.println("Update Menu\n");
        System.out.println("1. Personal Information");
        System.out.println("2. Emergency Information");
        System.out.println("3. Time Table");
        System.out.println("4. Marks");
        System.out.println("5. Graduation Requirements");

        OUTER:
        do {
            System.out.print("Enter Selection: ");
            choice = Integer.parseInt(input.readLine());
            System.out.println(" ");
            System.out.println("-------------------");
            switch (choice) {
                case 1:
                    System.out.println(list.get(person).displayPersonalInfo());
                    System.out.println("Enter to keep current info");
                    updatePersonalInfo(list, person);
                    break OUTER;
                case 2:
                    System.out.println(list.get(person).displayEmergencyInfo());
                    updateEmergencyInfo(list, person);
                    break OUTER;
                case 3:
                    System.out.println(list.get(person).displayTimeTable());
                    updateTimeTable(list, person);
                    break OUTER;
                case 4:
                    System.out.println(list.get(person).displayMarks());
                    updateMarks(list, person);
                    break OUTER;
                case 5:
                    System.out.println(list.get(person).displayGradReq());
                    updateGradRequirements(list, person);
                    break OUTER;
                default:
                    break;
            }
        } while (choice < 1 || choice > 5);

        mainMenu(list);
    }

    /**
     * Prompts for student information and calls appropriate methods
     *
     * @param list
     * @throws IOException
     */
    public static void addStudent(ArrayList<Student> list) throws IOException {
        int grade, choice;

        list.add(new Student());
        System.out.println("Enter Grade: ");
        grade = Integer.parseInt(input.readLine());
        list.get(list.size() - 1).getGrade();
        list.get(list.size() - 1).generateStudentID();

        updatePersonalInfo(list, list.size() - 1);

        System.out.print("\nEnter 1 to add more information, 2 to return to main menu: ");
        choice = Integer.parseInt(input.readLine());
        if (choice == 1) {
            updateEmergencyInfo(list, list.size() - 1);
            generateLocker(list, list.size() - 1);
            System.out.println(list.get(list.size() - 1).getLocker());
            generateTimeTable(list, list.size() - 1);

            System.out.println("Student Added!");
            mainMenu(list);
        } else {
            mainMenu(list);
        }
    }

    /**
     * Prompts for information and changes gradRequirements object accordingly
     *
     * @param list
     * @param i
     * @throws IOException
     */
    public static void updateGradRequirements(ArrayList<Student> list, int i) throws IOException {
        int newHours, hours, change, group, newCredits, credits;
        int[] groupArray;

        System.out.println("\nGraduation Requirements");
        System.out.println("1. Add Service Hours");
        System.out.println("2. Update Groups");
        System.out.println("3. Add Completed Compulsory Credits");
        System.out.println("Enter selection: ");
        change = Integer.parseInt(input.readLine());

        hours = list.get(i).getGradReq().getCommunityHours();
        groupArray = list.get(i).getGradReq().getGroups();
        credits = list.get(i).getGradReq().getCompulsory();
        switch (change) {
            case 1:
                System.out.print("Enter Additional Hours: ");
                newHours = Integer.parseInt(input.readLine());
                hours = hours + newHours;
                list.get(i).getGradReq().setCommunityHours(hours);
                break;
            case 2:
                System.out.print("Enter Group Completed: ");
                group = Integer.parseInt(input.readLine());
                group = group - 1;
                groupArray[group] = 1;
                list.get(i).getGradReq().setGroups(groupArray);
                break;
            default:
                System.out.print("Enter Additional Credits: ");
                newCredits = Integer.parseInt(input.readLine());
                credits = credits + newCredits;
                list.get(i).getGradReq().setCompulsory(credits);
                break;
        }

        mainMenu(list);
    }

    /**
     * Prompts for information and changes marks object accordingly
     *
     * @param list
     * @param i
     * @throws IOException
     */
    public static void updateMarks(ArrayList<Student> list, int i) throws IOException {
        int change, newMark, oldMark;

        System.out.println("\nMarks");
        System.out.println("1. Add Mark");
        System.out.println("2. Remove Mark");
        System.out.println("Enter selection: ");
        change = Integer.parseInt(input.readLine());

        ArrayList<Integer> grades = list.get(i).getMarks().getGrades();
        if (change == 1) {
            System.out.print("Enter New Mark: ");
            newMark = Integer.parseInt(input.readLine());
            grades.add(newMark);
        } else {
            System.out.print("Enter Mark to be removed: ");
            oldMark = Integer.parseInt(input.readLine());
            for (int j = 0; j < grades.size(); j++) {
                if (grades.get(j) == oldMark) {
                    grades.remove(j);
                }
            }
        }
        list.get(i).getMarks().setGrades(grades);
        mainMenu(list);
    }

    /**
     * Prompts for information and changes timeTable object accordingly
     *
     * @param list
     * @param i
     * @throws IOException
     */
    public static void updateTimeTable(ArrayList<Student> list, int i) throws IOException {
        String change, newClassName;

        System.out.println("\nUpdate Time Table");
        System.out.print("Enter Name of Class Being Changed: ");
        change = input.readLine();
        System.out.print("Enter New Name of Class: ");
        newClassName = input.readLine();

        list.get(i).updateTimeTable(change, newClassName);
        mainMenu(list);
    }

    /**
     * Fills array list of locker numbers
     */
    public static void fillArrayList() {
        for (int i = 0; i < 100; i++) {
            unusedLockers.add(i);
        }
    }

    /**
     * Prompts for choice and displays chosen information
     *
     * @param list
     * @throws IOException
     */
    public static void displayAll(ArrayList<Student> list) throws IOException {
        int i = 1, choice, person;
        System.out.println(" ");
        for (Student x : list) {
            System.out.println(i + ". " + x);
            i++;
        }
        System.out.print("Enter Student: ");
        person = Integer.parseInt(input.readLine());
        person = person - 1;

        System.out.println("Grade: " + list.get(person).getGrade());
        System.out.println("Student ID: " + list.get(person).getSudentID());
        System.out.println(" ");
        System.out.println("Display");
        System.out.println("1. Personal Information");
        System.out.println("2. Emergency Information");
        System.out.println("3. Time Table");
        System.out.println("4. Marks");
        System.out.println("5. Graduation Requirements");
        do {
            OUTER:
            do {
                System.out.print("Enter Selection (0 exit): ");
                choice = Integer.parseInt(input.readLine());
                switch (choice) {
                    case 1:
                        System.out.println(list.get(person).displayPersonalInfo());
                        break OUTER;
                    case 2:
                        System.out.println(list.get(person).displayEmergencyInfo());
                        break OUTER;
                    case 3:
                        System.out.println(list.get(person).displayTimeTable());
                        break OUTER;
                    case 4:
                        System.out.println(list.get(person).displayMarks());
                        System.out.print("Average: ");
                        System.out.println(list.get(person).getMarks().calculateAverage());
                        break OUTER;
                    case 5:
                        System.out.println(list.get(person).displayGradReq());
                        break OUTER;
                    default:
                        break;
                }
            } while (choice < 0 || choice > 5);
        } while (choice != 0);
        mainMenu(list);
    }

    /**
     * Displays all students and prompts for choice, and removes choice
     *
     * @param list
     * @throws IOException
     */
    public static void removeStudent(ArrayList<Student> list) throws IOException {
        int choice = 0, i = 1;

        do {
            System.out.println(" ");
            for (Student x : list) {
                System.out.println(i + ". " + x);
                i++;
            }
            System.out.println("Who would you like to remove: ");
            choice = Integer.parseInt(input.readLine());
        } while (choice < 1 || choice > list.size());
        list.remove(choice - 1);

        mainMenu(list);
    }

    /**
     * Prompts for information and changes personalInfo object accordingly
     *
     * @param list
     * @param i
     * @throws IOException
     */
    public static void updatePersonalInfo(ArrayList<Student> list, int i) throws IOException {
        String firstName, lastName, street, city, phone, postalCode, province;

        System.out.println("\nPersonal Information");
        System.out.print("Enter First Name: ");
        firstName = input.readLine();
        System.out.print("Enter Last Name: ");
        lastName = input.readLine();
        System.out.print("Enter Street: ");
        street = input.readLine();
        System.out.print("Enter City: ");
        city = input.readLine();
        System.out.print("Enter Province: ");
        province = input.readLine();
        System.out.print("Enter Phone: ");
        phone = input.readLine();
        System.out.print("Enter Postal Code: ");
        postalCode = input.readLine();

        list.get(i).setPersonalInfo(firstName, lastName, street, city, province, phone, postalCode);
    }

    /**
     * Prompts for information and changes emergencyInfo object accordingly
     *
     * @param list
     * @param i
     * @throws IOException
     */
    public static void updateEmergencyInfo(ArrayList<Student> list, int i) throws IOException {
        String contact1Name, contact2Name, email1, email2, address1, address2, phone1, phone2;

        System.out.println("\nEmergency Contact Information");
        System.out.print("Enter Contact 1 Full Name: ");
        contact1Name = input.readLine();
        System.out.print("Enter Contact 1 Email: ");
        email1 = input.readLine();
        System.out.print("Enter Contact 1 Address: ");
        address1 = input.readLine();
        System.out.print("Enter Contact 1 Phone: ");
        phone1 = input.readLine();
        System.out.println("");

        System.out.print("Enter Contact 2 Full Name: ");
        contact2Name = input.readLine();
        System.out.print("Enter Contact 2 Email: ");
        email2 = input.readLine();
        System.out.print("Enter Contact 2 Address: ");
        address2 = input.readLine();
        System.out.print("Enter Contact 2 Phone: ");
        phone2 = input.readLine();

        list.get(i).setEmergencyInfo(contact1Name, contact2Name, email1, email2, address1, address2, phone1, phone2);
    }

    /**
     * Creates locker combo and calls method to get the locker number
     *
     * @param list
     * @param i
     * @throws IOException
     */
    public static void generateLocker(ArrayList<Student> list, int i) throws IOException {
        int number;
        int[] combo = new int[3];
        Random rand = new Random();

        number = list.get(i).getNewNumber();
        //number = 234;
        for (int j = 0; j < combo.length; j++) {//randomize 3 combo numbers
            combo[j] = rand.nextInt(30) + 1;
        }

        list.get(i).setLocker(number, combo);

    }

    /**
     * prompts for classes and calls methods to assign appropriate teachers and
     * rooms
     *
     * @param list
     * @param i
     * @throws IOException
     */
    public static void generateTimeTable(ArrayList<Student> list, int i) throws IOException {
        int[] classNum = new int[8];
        int[] time = new int[8];
        String[] className = new String[8];
        String name;

        System.out.println("\nCourse Selection");

        for (int j = 0; j < className.length; j++) {

            System.out.print("Enter Class #" + (j + 1) + ": ");
            name = input.readLine();

            while (name.length() < 12) {
                name = name + " ";
            }
            className[j] = name;
        }
        list.get(i).setTimeTable(className);

        System.out.println(list.get(i).displayTimeTable());

    }

    /**
     * Allows to search student in multiple ways
     *
     * @param list
     * @throws IOException
     */
    public static void searchStudent(ArrayList<Student> list) throws IOException {
        String search;
        int choice, person = 0;

        System.out.println("Search By: ");
        System.out.println("1. First Name");
        System.out.println("2. Last Name");
        System.out.println("3. Street");
        System.out.println("4. Phone Number");
        System.out.println("5. Student ID");
        do {
            System.out.print("Enter Selection: ");
            choice = Integer.parseInt(input.readLine());
        } while (choice < 1 || choice > 5);

        switch (choice) {
            case 1:
                System.out.print("Enter First Name: ");
                search = input.readLine();
                for (int i = 0; i < list.size(); i++) {
                    if ((list.get(i).getPersonalInfo().getFirstName()).equals(search)) {
                        System.out.println(list.get(i).toString());

                    }
                }
                System.out.println("Enter Selection: ");
                person = Integer.parseInt(input.readLine());
                break;
            case 2:
                System.out.print("Enter Last Name: ");
                search = input.readLine();
                for (int i = 0; i < list.size(); i++) {
                    if ((list.get(i).getPersonalInfo().getLastName()).equals(search)) {
                        System.out.println(list.get(i).toString());
                    }
                }
                System.out.println("Enter Selection: ");
                person = Integer.parseInt(input.readLine());
                break;
            case 3:
                System.out.print("Enter Street: ");
                search = input.readLine();
                for (int i = 0; i < list.size(); i++) {
                    if ((list.get(i).getPersonalInfo().getStreet()).equals(search)) {
                        System.out.println(list.get(i).toString());
                    }
                }
                System.out.println("Enter Selection: ");
                person = Integer.parseInt(input.readLine());
                break;
            case 4:
                System.out.print("Enter Phone Number: ");
                search = input.readLine();
                for (int i = 0; i < list.size(); i++) {
                    if ((list.get(i).getPersonalInfo().getPhone()).equals(search)) {
                        System.out.println(list.get(i).toString());
                    }
                }
                System.out.println("Enter Selection: ");
                person = Integer.parseInt(input.readLine());
                break;
            case 5:
                System.out.print("Enter Student ID: ");
                search = input.readLine();
                for (int i = 0; i < list.size(); i++) {
                    if ((list.get(i).getSudentID().equals(search))) {
                        System.out.println(list.get(i).toString());
                    }
                }
                System.out.println("Enter Selection: ");
                person = Integer.parseInt(input.readLine());
                break;
        }

        System.out.println(" ");
        System.out.println("Display");
        System.out.println("1. Personal Information");
        System.out.println("2. Emergency Information");
        System.out.println("3. Time Table");
        System.out.println("4. Marks");
        System.out.println("5. Graduation Requirements");
        do {
            OUTER:
            do {
                System.out.print("Enter Selection (0 exit): ");
                choice = Integer.parseInt(input.readLine());
                switch (choice) {
                    case 1:
                        System.out.println(list.get(person).displayPersonalInfo());
                        break OUTER;
                    case 2:
                        System.out.println(list.get(person).displayEmergencyInfo());
                        break OUTER;
                    case 3:
                        System.out.println(list.get(person).displayTimeTable());
                        break OUTER;
                    case 4:
                        System.out.println(list.get(person).displayMarks());
                        break OUTER;
                    case 5:
                        System.out.println(list.get(person).displayGradReq());
                        break OUTER;
                    default:
                        break;
                }
            } while (choice < 0 || choice > 5);
        } while (choice != 0);
        mainMenu(list);
    }

    /**
     * Creates students for program testing
     *
     * @param list
     * @throws IOException
     */
    public static void createStudents(ArrayList<Student> list) throws IOException {
        String[] classes1 = {"Math        ", "Science     ", "Music       ", "Buisness    ", "Computer Science", "Gym         ", "English     ", "Religion    "};
        int[] groups1 = {0, 1, 0};
        ArrayList<Integer> marks1 = new ArrayList<>();
        marks1.add(87);
        marks1.add(47);
        marks1.add(77);
        marks1.add(97);
        list.add(new Student(10, new PersonalInfo("Chessy", "Xie", "Sleepy St.", "Richmond Hill", "Ontario", "9052345432", "L38 8T9"),
                new Locker(), new TimeTable(classes1),
                new EmergencyInfo("Jeff", "Carol", "jeff@gmail.com", "carol@gmail.com", "24 dsdf", "15 aplle St.", "2345678", "12345678"),
                new GradRequirements(groups1, 2, 10),
                new Marks(marks1)));

        String[] classes2 = {"Geography   ", "religion    ", "science     ", "Marketing   ", "Gym         ", "Careers     ", "Business    ", "English     "};
        int[] groups2 = {0, 0, 0};
        ArrayList<Integer> marks2 = new ArrayList<>();
        marks2.add(37);
        marks2.add(44);
        marks2.add(94);
        marks2.add(78);
        list.add(new Student(11, new PersonalInfo("Tyler", "Ling", "pengine St.", "Geen Hill", "Ontario", "927360475", "W88 8W9"),
                new Locker(), new TimeTable(classes2),
                new EmergencyInfo("Manny", "Devin", "Manny@gmail.com", "Devin@gmail.com", "83 Pinapple", "83 chinchin dr.", "2973072234", "9863541867"),
                new GradRequirements(groups2, 7, 16),
                new Marks(marks2)));

        String[] classes3 = {"English     ", "Geo         ", "Religion    ", "Science     ", "Marketing   ", "Gym         ", "Careers     ", "Business    "};
        int[] groups3 = {0, 1, 0};
        ArrayList<Integer> marks3 = new ArrayList<>();
        marks3.add(67);
        marks3.add(67);
        marks3.add(91);
        marks3.add(84);
        list.add(new Student(9, new PersonalInfo("Jason", "Ink", "killer ave.", "Richmond Hill", "Ontario", "8763942657", "K98 8S9"),
                new Locker(), new TimeTable(classes3),
                new EmergencyInfo("Winler", "Osuas", "Winler@gmail.com", "Osuas@gmail.com", "792 Rose dr.", "12 Purlin st.", "5657789287", "8822347678"),
                new GradRequirements(groups3, 2, 10),
                new Marks(marks3)));

        String[] classes4 = {"Business    ", "English     ", "Geo         ", "Relgion     ", "Science     ", "Marketing   ", "Math        ", "Careers     "};
        int[] groups4 = {0, 1, 0};
        ArrayList<Integer> marks4 = new ArrayList<>();
        marks4.add(67);
        marks4.add(89);
        marks4.add(85);
        marks4.add(90);
        list.add(new Student(12, new PersonalInfo("Flora", "Scarlet", "Ever Dr.", "Richmond Hill", "Ontario", "8983456665", "R28 9D9"),
                new Locker(), new TimeTable(classes4),
                new EmergencyInfo("Donald", "Ferlando", "Donald@gmail.com", "Ferlando@gmail.com", "40 Lake rd.", "5 dusty dr.", "7871211650", "9863541867"),
                new GradRequirements(groups4, 2, 10),
                new Marks(marks4)));

        String[] classes5 = {"Carrers     ", "Buiness     ", "English     ", "Geography   ", "relgion     ", "Physics   ", "Marketing   ", "Math        "};
        int[] groups5 = {0, 1, 0};
        ArrayList<Integer> marks5 = new ArrayList<>();
        marks5.add(78);
        marks5.add(90);
        marks5.add(94);
        marks5.add(73);
        list.add(new Student(12, new PersonalInfo("Currly", "Leonardo", "pipeser Dr.", "Geen Hill", "Ontario", "6667872986", "Q98 7J3"),
                new Locker(), new TimeTable(classes5),
                new EmergencyInfo("Cinshu", "popin", "Chishu@gmail.com", "popin@gmail.com", "75 Blurk St.", "873 Liliey dr.", "3873764546", "6711123349"),
                new GradRequirements(groups5, 2, 10),
                new Marks(marks5)));

        for (int i = 0; i < list.size(); i++) {
            generateLocker(list, i);
            list.get(i).generateStudentID();
            list.get(i).getTimeTable().matchTeacherAndNumber();
        }

    }
}
