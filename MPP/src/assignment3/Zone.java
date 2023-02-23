package assignment3;

import java.util.ArrayList;
import java.util.List;

public class Zone {
    private  int id;
    private String name;
    private final List<String> states;
    int countryId;
    private final double cost;

    public Zone(int id,String name,double cost)
    {
        this.id = id;
        this.name = name;
        this.states = new ArrayList<>();
        this.countryId = 1;
        this.cost = cost;
    }

    public  void addState(String state){
        if(!states.contains(state))
            states.add(state);

    }

    public double getCost(){
        return this.cost;
    }

    public boolean checkState(String state)
    {
        return states.contains(state);
    }

}
