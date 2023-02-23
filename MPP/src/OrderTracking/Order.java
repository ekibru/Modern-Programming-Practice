package OrderTracking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private String orderNumber;
    private boolean prePaid;
    private double orderPrice;
    private Date orderDate;

    private final ICustomer customer;
    private String status;

    List<OrderLine> orderLines;

    public Order(String orderNumber, boolean prePaid, double orderPrice, Date orderDate, ICustomer customer, String status) {
        this.orderNumber = orderNumber;
        this.prePaid = prePaid;
        this.orderPrice = orderPrice;
        this.orderDate = orderDate;
        this.customer = customer;
        this.status = status;
        orderLines = new ArrayList<>();
    }

    public void addOrderLind(OrderLine orderLine)
    {
        this.orderLines.add(orderLine);
        this.orderPrice += orderLine.price;
        customer.addPoints(orderLine.points);
    }
    public String getOrderNumber() {
        return orderNumber;
    }

    public boolean isPrePaid() {
        return prePaid;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    public ICustomer getCustomer() {
        return customer;
    }


    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setPrePaid(boolean prePaid) {
        this.prePaid = prePaid;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
