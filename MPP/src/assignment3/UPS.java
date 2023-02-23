package assignment3;

public class UPS extends ACourier implements ICourier{

    public UPS(String name){
        super(name);
    }

    @Override
    public double getRate(Package p) {
//        System.out.println("UPS:GetRate "+weight * 0.45);
        double totalDiscount = p.getWeight() * 0.45 * ((p.getCustomer().getLevel().getDiscount())/100);
        return p.getWeight() * 0.45 - totalDiscount;
    }
}
