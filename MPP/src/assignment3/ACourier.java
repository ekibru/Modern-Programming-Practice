package assignment3;

public abstract class ACourier {
    private String name;

    public ACourier(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
