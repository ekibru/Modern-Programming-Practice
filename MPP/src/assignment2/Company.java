package assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Company implements ICommon {
    private String name;
    private List<Department> departments;

    public Company(String name)
    {
        this.name = name;
        departments = new ArrayList<>();
    }
    public void addDepartment(Department dept){
        departments.add(dept);
    }
    @Override
    public void print(){
        System.out.println("-Company Name: "+name);
        for (Department d : departments)
            d.print();

    }

    @Override
    public double getSalary() {
        double salarySum = 0;
        for(Department d: departments)
        {
            salarySum+=d.getSalary();
        }
        System.out.println("------------------------------------------------------------------");
        System.out.print("Company::getSalary(): ");
        System.out.printf("$%,.2f",salarySum);

        return  salarySum;
    }

    public void printReportingHierarchy(){
        System.out.println("------------------------------------------------------------------");
        System.out.println("Company::printReportingHierarchy()");
        Position currentHead = getTopExecutive();

        currentHead.printDownLine();
//        String indent = "  ";

//        for(Department d : departments) {

//
//            if(d.getDepartmentHead().equals(currentHead))
//            {
//                currentHead.getDepartment().printReportingHierarchy("");
//                indent = indent + "  ";
//                System.out.println(indent+"Department: "+d.getName()+" department Head: "+d.getDepartmentHead().getEmployee().getName());
//                d.printReportingHierarchy(indent,d.getDepartmentHead());
//            }else if(d.getDepartmentHead().superior.equals(currentHead))
//            {
//                currentHead = topExecutive;
//                indent = indent + "  ";
//                System.out.println(indent+"Department: "+d.getName()+" department Head: "+d.getDepartmentHead().getEmployee().getName());
//                d.printReportingHierarchy(indent,d.getDepartmentHead());
//            }

//        }
    }

    public Position getTopExecutive(){
        for(Department d : departments)
        {
            Position DH = d.getDepartmentHead();
//           System.out.println(d.getName()+" Dept. Head "+DH.getEmployee().getName());
            if(!Objects.isNull(d.getDepartmentHead()) && Objects.isNull(d.getDepartmentHead().superior))
            {
//                System.out.println("------------------------------------------------------------------");

//                System.out.println("Company::getTopExecutive(): "+ d.getDepartmentHead().getEmployee().getName());
//                System.out.println(d.getEmployee().getName());
                return d.getDepartmentHead();
            }
        }

        return null;
    }
}
