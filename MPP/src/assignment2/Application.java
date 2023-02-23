package assignment2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    static SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
    public static void main(String[] args) throws ParseException {
        Company company = new Company("Batta Tech holding LCC");

        Department Sales = new Department("Sales","NYC");
        Department Marketing = new Department("Marketing","NYC");
        Department Management = new Department("Management","NYC");


        Employee Lyle = new Employee(6,"Lyle","y","Yaman",formatter.parse("12-dec-1990"),1234567801,3000);

        Employee Ron = new Employee(1,"Ron","b","Batta", formatter.parse("12-dec-1990"),123456789,1000);
        Employee Peter = new Employee(2,"Peter","s","Mugh",formatter.parse("12-dec-1990"),123456788,2000);
        Employee Stan  = new Employee(3,"Stan ","Abu","Yaman",formatter.parse("12-dec-1990"),123456780,3000);

        Employee Bill = new Employee(4,"Bill","r","Batta",formatter.parse("12-dec-1990"),1234567891,1000);
        Employee Dan = new Employee(5,"Dan","t","Mugh",formatter.parse("12-dec-1990"),1234567881,2000);

        Employee Tom = new Employee(7,"Tom","r","Batta",formatter.parse("12-dec-1990"),1234567892,1000);
        Employee Sue = new Employee(8,"Sue","t","Mugh",formatter.parse("12-dec-1990"),1234567882,2000);
        Employee Mark = new Employee(9,"Mark","y","Yaman",formatter.parse("12-dec-1990"),1234567802,3000);

        Employee Gary = new Employee(10,"Gary","t","Mugh",formatter.parse("12-dec-1990"),1234567883,2000);
        Employee Anne = new Employee(11,"Anne","y","Yaman",formatter.parse("12-dec-1990"),1234567804,3000);


        company.addDepartment(Management);
        company.addDepartment(Sales);
        company.addDepartment(Marketing);



        Position LylePosition = new Position("CEO","The Top Hierarchy",Lyle,true,null,Management);

        Position AnnePosition = new Position("AnnePosition","The AnnePosition position",Anne,true,LylePosition,Marketing);
        Position GaryPosition = new Position("GaryPosition","The GaryPosition position",Gary,false,AnnePosition,Marketing);

        Position RonPosition = new Position("RonPosition","The RonPosition position",Ron,true,LylePosition,Sales);
        Position PeterPosition = new Position("PeterPosition","The PeterPosition position",Peter,false,RonPosition,Sales);
        Position StanPosition = new Position("StanPosition","The StanPosition position",Stan,false,RonPosition,Sales);
        Position BillPosition = new Position("BillPosition","The BillPosition position",Bill,false,PeterPosition,Sales);
        Position DanPosition = new Position("DanPosition","The DanPosition position",Dan,false,PeterPosition,Sales);
        Position TomPosition = new Position("TomPosition","The TomPosition position",Tom,false,StanPosition,Sales);
        Position SuePosition = new Position("SuePosition","The SuePosition position",Sue,false,StanPosition,Sales);
        Position MarkPosition = new Position("MarkPosition","The MarkPosition position",Mark,false,StanPosition,Sales);

        RonPosition.addInferiors(PeterPosition,StanPosition);
        PeterPosition.addInferiors(BillPosition,DanPosition);
        StanPosition.addInferiors(TomPosition);
        StanPosition.addInferiors(SuePosition);
        StanPosition.addInferiors(MarkPosition);
        LylePosition.addInferiors(AnnePosition);
        LylePosition.addInferiors(RonPosition);
        AnnePosition.addInferiors(GaryPosition);


        Sales.addPosition(RonPosition);
        Sales.addPosition(PeterPosition);
        Sales.addPosition(StanPosition);
        Sales.addPosition(BillPosition);
        Sales.addPosition(DanPosition);
        Sales.addPosition(TomPosition);
        Sales.addPosition(SuePosition);
        Sales.addPosition(MarkPosition);

        Marketing.addPosition(AnnePosition);
        Marketing.addPosition(GaryPosition);

        Management.addPosition(LylePosition);




        company.print();
        System.out.printf("$%,.2f",company.getSalary());
        System.out.println();
        System.out.println("------------------------------------------------------------------");
        System.out.println("Company::getTopExecutive(): ");

        System.out.println(company.getTopExecutive());
        company.printReportingHierarchy();

        System.out.println("------------- Lab 7 output ---------------");
        Employee Ron1 = new Employee(1,"Ron","b","Batta", formatter.parse("12-dec-1990"),123456789,1000);

        System.out.println("Call Employee:equals(): Ron Vs. Peter => "+Ron.equals(Peter));
        System.out.println("Call Employee:equals(): Ron Vs. Ron1 (the same details but different object) => "+Ron.equals(Ron1));

        System.out.println();
        Position AnnePosition1 = new Position("AnnePosition","The AnnePosition position",Anne,true,LylePosition,Marketing);

        System.out.println("Call Position:equals(): AnnePosition Vs. GaryPosition => "+AnnePosition.equals(GaryPosition));
        System.out.println("Call Position:equals(): AnnePosition Vs. AnnePosition1 (the same details but different object) => "+AnnePosition.equals(AnnePosition1));

        System.out.println();

        System.out.println("Call Employee:toString(): on Ron");
        System.out.println(Ron.toString());

        System.out.println();
        System.out.println("Call Position:toString(): on AnnePosition");
        System.out.println(AnnePosition.toString());



    }
}
