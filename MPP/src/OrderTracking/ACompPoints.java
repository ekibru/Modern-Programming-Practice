package OrderTracking;

public abstract class ACompPoints implements ICompPoints {
    protected double points;
    @Override
    public  double getPoints(){
        return this.points;
    };
}
