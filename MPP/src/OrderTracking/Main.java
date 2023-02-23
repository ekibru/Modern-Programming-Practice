package OrderTracking;

import java.util.Date;

public class Main {


    public static void main(String[] args) {
        ICustomer personal = new PersonalCustomer("Bara","NY,NYC","9178323297",0.0,"very Good","4321 4321 4321 4321");
        ICustomer corporate = new CorporateCustomer("Batta","NY,NYC","9178323297",0.0,"very Good");

        IProduct product1 = new Product("hair Dryer","123ss",34.69,new OtherPoints());
        IProduct product2 = new Product("Dell Laptop","123ss",350.0,new ComputerPoints());
        IProduct product3 = new Product("Movie 2022","123ss",15.99,new Audio_VideoPoints());
        IProduct product4 = new Product("Pressure Measurement Device","123ss",79.8,new HealthPoints());


        OrderLine orderLine = new OrderLine(2);
        orderLine.addProduct(product1);
        orderLine.addProduct(product3);

        Order newOrder = new Order("1",false,30,new Date(),personal,"placed");

        newOrder.addOrderLind(orderLine);

        personal.addOrder(newOrder);

        System.out.println(personal.getPoints());
    }

}
