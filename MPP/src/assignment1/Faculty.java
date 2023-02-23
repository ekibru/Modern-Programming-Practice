package assignment1;

import java.util.ArrayList;

public class Faculty extends Person{
    private double Salary;
    private final ArrayList<Course> Courses;
    public Faculty(String name,String phone,int age,double salary)
    {
        super(name,phone,age);
        this.Salary = salary;
        this.Courses = new ArrayList<>();
    }

    public void addCourse(Course course){
        Courses.add(course);
    }

    public ArrayList<Course> getCourses() {
        return Courses;
    }

    @Override
    public int getTotalUnits(){
        int totalUnits = 0;
        for(Course c : Courses)
        {
            totalUnits+= c.getUnits();
        }
        return totalUnits;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        this.Salary = salary;
    }
}
