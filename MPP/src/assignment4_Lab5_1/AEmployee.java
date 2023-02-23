package assignment4_Lab5_1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class AEmployee {
    private final UUID empId;
    private final String name;
    private final List<Paycheck> paychecks;

    public AEmployee( String name) {
        this.empId = UUID.randomUUID();
        this.name = name;
        paychecks = new ArrayList<>();
    }

    public void print(){
        System.out.println("EmpID: "+empId+" Name: "+name);
        for (Paycheck pc: paychecks)
            pc.print();
    }
    Paycheck calcCompensation(int month,int year){
        LocalDateTime start = LocalDateTime.of(year,month,1,0,0);
        DateRange payPeriod = new DateRange(start,start.plusMonths(1));
        double grossPay = calcGrossPay(payPeriod);

        double FICA = (grossPay * 0.23);
        double state =  (grossPay * 0.05);
        double local = (grossPay * 0.1);
        double medicare =  (grossPay * 0.03);
        double socialSecurity =  (grossPay * 0.075);

        return new Paycheck(grossPay,FICA,state,local,medicare,socialSecurity,payPeriod);
    }

    public void addPaycheck(Paycheck paycheck)
    {
        this.paychecks.add(paycheck);
    }

    public void addOrder(Order order){}
    abstract double calcGrossPay(DateRange dateRange);

}
