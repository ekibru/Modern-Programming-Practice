package assignment4_Lab5_1;

public class Paycheck {
    private final double grossPay;
    private final double fica;
    private final double state;
    private final double local;
    private final double medicare;
    private final double socialSecurity;
    private final DateRange PayPeriod;

    public Paycheck(double grossPay, double fica, double state, double local, double medicare, double socialSecurity, DateRange payPeriod) {
        this.grossPay = grossPay;
        this.fica = fica;
        this.state = state;
        this.local = local;
        this.medicare = medicare;
        this.socialSecurity = socialSecurity;
        PayPeriod = payPeriod;
    }

    public void print(){
        System.out.format("\n\tPay Period: "+PayPeriod.toString()+
                "\n\t\t  Gross Pay: %,.2f"+
                "\n\t\t  FICA: %,.2f"+
                "\n\t\t  State: %,.2f"+
                "\n\t\t  Local: %,.2f"+
                "\n\t\t  Medicare: %,.2f"+
                "\n\t\t  Social Security: %,.2f"+
                "\n\t\t  Net Pay: %,.2f",grossPay,fica,state,local,medicare,socialSecurity,getNetPay());
    }

    public double getNetPay(){
        return grossPay - fica -state - local - medicare - socialSecurity;
    }
}
