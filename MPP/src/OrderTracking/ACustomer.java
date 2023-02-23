package OrderTracking;

import java.util.List;

public abstract class ACustomer implements ICustomer{
   protected String name;
   protected String address;
   protected String phone;
   protected double points;
   protected String creditRating;

   protected List<Order> orders;

    public abstract String getCreditRating();

   public ACustomer(String name, String address, String phone, double points, String creditRating) {
      this.name = name;
      this.address = address;
      this.phone = phone;
      this.points = points;
      this.creditRating = creditRating;
   }


}
