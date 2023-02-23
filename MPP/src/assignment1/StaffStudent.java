package assignment1;

import java.util.Date;

public class StaffStudent extends Staff{

    private Student student;

    public Student getStudent() {
        return student;
    }

    private Date firstCourseRegisterDate;
    public StaffStudent(String name, String phone, int age, double salary,double gpa) {
        super(name, phone, age, salary);
        student = new Student(name,phone,age,gpa);
    }

    @Override
    public void addCourse(Course c) {
        if(firstCourseRegisterDate == null) {
            firstCourseRegisterDate = new Date();
            System.out.println("The first course for "+student.getName()+" registered at: " + firstCourseRegisterDate);
        }
        student.addCourse(c);
    }
}
