package assignment4_Lab5_1;

public class Hourly extends AEmployee{
    double hourlyWage;
    double hoursPerWeek;

    public Hourly(String name,double hourlyWage,double hoursPerWeek) {
        super(name);
        this.hoursPerWeek = hoursPerWeek;
        this.hourlyWage = hourlyWage;
    }

    @Override
    double calcGrossPay(DateRange dateRange) {
        return hourlyWage * hoursPerWeek * 4;
    }
}
