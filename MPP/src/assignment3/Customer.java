package assignment3;

public class Customer {
    private final String name;
    private final Level discountLevel;

    public Customer(String name,Level level)
    {
        this.name = name;
        this.discountLevel = level;
    }

    public String getName(){
        return name;
    }

    public Level getLevel(){
        return  discountLevel;
    }
}
