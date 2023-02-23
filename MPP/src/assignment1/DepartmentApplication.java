package assignment1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * This is a skeleton class that you can use for guidance in starting the lab.
 *
 * You should update any comments,
 * variable names, etc to follow the class coding conventions.
 */

public class DepartmentApplication {
    public static void main(String[] args) throws IOException
    {
        Department dept = new Department("ComputerScience");

        //  The following commented out code will help you
        //  create the objects that you need.


        //  CHANGE the code below so that instead of addFaculty,
        //  addStudent, and  addStaff, we have ONLY ONE method,
        //  addPerson (this replaces the other three methods).


         // Create faculty objects
         Faculty frankMoore = new Faculty("Frank Moore","472-5921",43,10000);
         Faculty samHoward = new Faculty("Sam Howard","472-7222",55,9500);
         Faculty johnDoodle = new Faculty("John Doodle","472-6190",39,8600);

         dept.addPerson (frankMoore);
         dept.addPerson(samHoward);
         dept.addPerson(johnDoodle);


         // Create student objects
         Person johnDoe = new Student("John Doe","472-1121",22,4.0);
         Person maryJones = new Student("Mary Jones","472-7322",32,3.80);
         Person leeJohnson = new Student("Lee Johnson","472-6009",19,3.65);


        List<Student> students = new ArrayList<>();
        students.add(new Student("John Doe","472-1121",22,4.0));
        students.add(new Student("Mary Jones","472-7322",32,3.80));
        students.add(new Student("Lee Johnson","472-6009",19,3.65));

        Stream.concat(students.stream().flatMap(stu->stu.getCourses().stream()).collect(Collectors.groupingBy(Course::getTitle,Collectors.toList()))
                        .keySet().stream()
        ,students.stream().collect(Collectors.groupingBy(Student::getSalary,Collectors.counting())).keySet().stream());


        dept.addPerson (johnDoe);
         dept.addPerson(maryJones);
         dept.addPerson(leeJohnson);


         // Create staff objects
         Person frankGore = new Staff("Frank Gore","472-3321",33,4050);
         Person adamDavis = new Staff("Adam Davis","472-7552",50,5500);
         Person davidHeck = new Staff("David Heck","472-8890",29,3600);
         dept.addPerson (frankGore);
         dept.addPerson(adamDavis);
         dept.addPerson(davidHeck);


        // Create StaffStudent objects
        Person bara1 = new StaffStudent("Bara Batta","917-8323297",43,4000.0,4.0);
        Person bara2 = new StaffStudent("Mike Paloo","618-4525",33,3000.0,3.5);
        Person bara3 = new StaffStudent("tina nigyuen","416-6009",55,3000.0,3.65);

        dept.addPerson (bara1);
        dept.addPerson(bara2);
        dept.addPerson(bara3);



        // Create course objects

         /* The below is giving a faculty reference as the last argument.  This is a Mistake since it is one directional.
           The  ‘1’  next to the Faculty class in the class diagram is Not implemented in the Course class.
           It is there only to show us that a course is taught by only one faculty.
         However, this mistake below does show us How we could implement the code IF it was two-directional!  */

        Course cs201 = new Course("cs201","programming",4);
        Course cs360 = new Course("cs360","database",3);
        Course cs404 = new Course("cs404","compiler",4);
        Course cs240 = new Course("cs240","datastructure",2);
        Course cs301 = new Course("cs301","Software engg",3);
        Course cs450 = new Course("cs450","Advanced architecture",5);

        //////add courses for faculty
        frankMoore.addCourse(cs450);
        samHoward.addCourse(cs360);
        samHoward.addCourse(cs301);
        johnDoodle.addCourse(cs201);
        johnDoodle.addCourse(cs404);
        johnDoodle.addCourse(cs240);

        //add courses for students
         johnDoe.addCourse(cs201);
         johnDoe.addCourse(cs360);
         johnDoe.addCourse(cs404);
         johnDoe.addCourse(cs301);

        maryJones.addCourse(cs201);
        maryJones.addCourse(cs404);
        maryJones.addCourse(cs450);

        leeJohnson.addCourse(cs201);
        leeJohnson.addCourse(cs360);
        leeJohnson.addCourse(cs240);
        leeJohnson.addCourse(cs450);


        bara1.addCourse(cs404);
        bara1.addCourse(cs201);
        bara1.addCourse(cs450);

        bara2.addCourse(cs201);
        bara2.addCourse(cs240);
        bara2.addCourse(cs301);

        bara3.addCourse(cs450);
        bara3.addCourse(cs240);


        /*
         * The above course objects will go inside either
         * a faculty object, or a student object.  Not all of the course
         *  objects go into the same object.
         *
         *  You would have code that looks something like :
         *  frankMoore.addCourse(cs450);
         *
         *  The addCourse method would have to be written in
         *  the faculty class.  Something similar would be done
         *  for students.
         */

        /********************************************************/


        double totsalary = 0;

        System.out.println("------------- Lab 7 myStatic & myDefault ----------------");
        System.out.print("Calling IPerson:myStatic(): ");
        IPerson.myStatic();
        System.out.print("Calling IPerson:myDefault(): ");
        bara1.myDefault();
        System.out.print("Calling IPerson:myAbstract(): ");
        bara1.myAbstract();
        //////Enum
        myImmutableClass ic = new myImmutableClass(myImmutableClass.SIZES.MEDIUM);
        ic.checkSize();
        while(true)
        {
            putText("Enter first letter of ");
            putText("getTotalSalary, showAllMembers, unitsPerFaculty, facultyMemberStudents or quit : ");
            int choice = getChar();
            switch(choice)
            {
                case 'g':
                    totsalary=dept.getTotalSalary();
                    putText("Total sum of all salaries is:");
                    putText(String.valueOf(totsalary)+"\n");
                    break;
                case 's':
                    dept.showAllMembers();
                    break;
                case 'u':
                    dept.unitsPerFaculty();
                    break;
                case 'f':
                    System.out.println("Please Enter the faculty member name ");
                    String facultyMemberName = getString();
                    Faculty facultyMember =(Faculty)  dept.findFacultyByName(facultyMemberName);
                    printStudents(facultyMember,dept);
                    break;
                case 'q': return;
                default:
                    putText("Invalid entry\n");
            }  // end switch
        }  // end while
    }  // end main()

    private static void printStudents(Faculty facultyMember,Department dept) {
        for(Course c :  facultyMember.getCourses())
        {
            System.out.println("-------- "+c.getTitle()+" --------");
            for(Person p : dept.getMembers())
            {
                if(p instanceof  Student)
                {
                    for(Course sc : ((Student) p).getCourses())
                    {
                        if(c.getNumber().equals(sc.getNumber()))
                            System.out.println("-- " + p.getName());
                    }
                }else  if(p instanceof  StaffStudent)
                {
                    for(Course sc : ((StaffStudent) p).getStudent().getCourses())
                    {
                        if(c.getNumber().equals(sc.getNumber()))
                            System.out.println("-- " + p.getName());
                    }
                }
            }
        }
    }

    // -------------------------------------------------------------
    public static void putText(String s) //writes string s to the screen
    {
        System.out.println(s);
    }
    // -------------------------------------------------------------
    public static String getString() throws IOException  //reads a string from the keyboard input
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    // -------------------------------------------------------------
    public static char getChar() throws IOException //reads a character from the keyboard input
    {
        String s = getString();
        return s.charAt(0);
    }

    //-------------------------------------------------------------
    public static int getInt() throws IOException // reads an integers from the keyboard input
    {
        String s = getString();
        return Integer.parseInt(s);
    }


// -------------------------------------------------------------
}  // end class

