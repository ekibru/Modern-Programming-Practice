package assignment3;

public class Package {
    private final String description;
    private final double weight;
    private final String zone;

    private final Customer customer;
    public String getDescription() {
        return description;
    }

    public double getWeight() {
        return weight;
    }

    public String getZone() {
        return zone;
    }

    public Customer getCustomer(){
        return this.customer;
    }

    public Package(String description, double weight, String zone,Customer customer) {
        this.description = description;
        this.weight = weight;
        this.zone = zone;
        this.customer = customer;
    }
}
