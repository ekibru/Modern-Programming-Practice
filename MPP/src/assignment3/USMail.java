package assignment3;

public class USMail extends ACourier implements ICourier{
    public USMail(String name) {
        super(name);
    }

//    If the weight is less than 3 pound, then the cost is $1.00.
//    If the weight is larger than 3 pounds, then the cost is $0.55 per pound.

    @Override
    public double getRate(Package p) {
//        System.out.println("USMail:GetRate "+weight * 0.55);
        double totalDiscount = 0;
        if(p.getWeight() <= 3)
        {
             totalDiscount = p.getWeight() * ((p.getCustomer().getLevel().getDiscount())/100);
            return p.getWeight() - totalDiscount;
        }
        totalDiscount = p.getWeight() * 0.55*((p.getCustomer().getLevel().getDiscount())/100);
        return p.getWeight() * 0.55 - totalDiscount ;
    }
}
