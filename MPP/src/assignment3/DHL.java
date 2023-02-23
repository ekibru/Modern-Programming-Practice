package assignment3;

public class DHL extends ACourier implements ICourier{

    public DHL(String name){
        super(name);
    }
    @Override
    public double getRate(Package p) {
        return p.getWeight() * 3.5;
    }

}
