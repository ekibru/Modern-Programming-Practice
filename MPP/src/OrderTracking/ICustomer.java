package OrderTracking;

public interface ICustomer {
    String getCreditRating();
    public abstract void resetPoints();
    public abstract double getPoints();
    public abstract void addPoints(double points);
    public abstract void addOrder(Order order);

}
