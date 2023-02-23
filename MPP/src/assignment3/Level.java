package assignment3;

public class Level {
    private final String title;
    private final double discount;

    public Level(String title,double discount)
    {
        this.title = title;
        this.discount = discount;
    }

    public double getDiscount(){
        return discount;
    }

    public String getTitle(){
        return title;
    }

}
