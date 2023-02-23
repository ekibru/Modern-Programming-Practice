package OrderTracking;

import java.util.ArrayList;

public class CorporateCustomer extends ACustomer{

    protected double creditLimit;

    public CorporateCustomer(String name, String address, String phone, double points, String creditRating) {
        super(name, address, phone, points, creditRating);
        this.orders = new ArrayList<>();

    }

    @Override
    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    @Override
    public String getCreditRating() {
        return null;
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
        this.points +=points;
    }

    public void generateMonthlyBill(){

    }



}
