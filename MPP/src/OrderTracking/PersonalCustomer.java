package OrderTracking;

import java.util.ArrayList;

public class PersonalCustomer extends ACustomer{
    protected String creditCardNumber;

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public PersonalCustomer(String name, String address, String phone, double points, String creditRating, String creditCardNumber) {
        super(name, address, phone, points, creditRating);
        this.creditCardNumber = creditCardNumber;
        this.orders = new ArrayList<>();
    }


    @Override
    public String getCreditRating() {
        return null;
    }

    @Override
    public void addOrder(Order order) {
        this.orders.add(order);
    }

    @Override
    public void resetPoints() {
        this.points = 0.0;
    }

    @Override
    public double getPoints() {
        return this.points;
    }

    @Override
    public void addPoints(double points) {
        this.points+= points;
    }
}
