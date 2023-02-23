package assignment1;

public class Staff extends Person{
    private double Salary;
    public Staff(String name, String phone, int age, double salary) {
        super(name, phone, age);
        Salary = salary;
    }

    public double getSalary() {
        return Salary;
    }

    @Override
    public void addCourse(Course c) {
        return;
    }

    public void setSalary(double salary) {
        this.Salary = salary;
    }

    public int getTotalUnits(){
        return 2;
    }
}
