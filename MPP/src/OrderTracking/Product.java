package OrderTracking;

public class Product implements IProduct{
    protected String description;
    protected String productNumber;
    protected double price;
    protected ICompPoints points;
    @Override
    public double getPrice() {
        return 0.0;
    }

    public Product(String description, String productNumber, double price, ICompPoints points) {
        this.description = description;
        this.productNumber = productNumber;
        this.price = price;
        this.points = points;
    }
}
