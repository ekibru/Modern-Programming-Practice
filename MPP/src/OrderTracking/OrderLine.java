package OrderTracking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderLine {
    protected int quantity;
    protected double price;
    protected String status;
    protected Date shipDate;
    protected double points;
    protected List<IProduct> products;

    public OrderLine(int quantity) {
        this.quantity = quantity;
        products = new ArrayList<>();
    }

    private Order order;

    public double computePrice(){
        return 0.0;
    }

    public double computePoints(){
        return 0.0;
    }

    public void addProduct(IProduct p){
        products.add(p);
    }
}
