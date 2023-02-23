package assignment4_Lab5_1;

public class Salaried extends AEmployee{
    public Salaried(double salary,String name) {
        super(name);
        this.salary = salary;
    }

    private double salary;
    @Override
    double calcGrossPay(DateRange dateRange) {
        return salary;
    }
}
