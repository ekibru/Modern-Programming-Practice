package assignment3;

import java.util.List;

public class FedEx extends ACourier implements ICourier{

    List<Zone> zones;

    public FedEx(String name,List<Zone> zones) {
        super(name);
        this.zones = zones;
    }


    @Override
    public double getRate(Package p) {
//        System.out.println("FedEx:GetRategetZoneRate(zone) "+getZoneRate(zone));
        double totalDiscount = p.getWeight() * getZoneRate(p.getZone())* ((p.getCustomer().getLevel().getDiscount())/100);
        return p.getWeight() * getZoneRate(p.getZone()) - totalDiscount;
    }

    private double getZoneRate(String state)
    {
        for(Zone z:zones)
        {
            if(z.checkState(state))
                return z.getCost();
        }
        return 0.43;
    }
}
