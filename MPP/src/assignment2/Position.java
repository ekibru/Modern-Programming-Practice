package assignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Position implements ICommon,Cloneable {
    private final String title;
    private final String description;

    private  Department department;
    public  Position superior;


    private  List<Position> inferiors;

    private  Employee employee;

    public Position(String title,String description,Employee emp,boolean ismanager,Position superior,Department department){
        this.title = title;
        this.description = description;
        inferiors = new ArrayList<>();
        this.superior = superior;
        this.employee = emp;
        this.department = department;

    }

    public void print(){
//        System.out.println("-----Position Title: "+title + " , & Description: "+description);
        employee.print();

    }

    public void print(String indent){
//        System.out.println("-----Position Title: "+title + " , & Description: "+description);
        employee.print(indent);
    }

    public Department getDepartment() {
        return department;
    }

    public Position getSuperior(){
        return this.superior;
    }
    @Override
    public double getSalary() {
//        double salarySum = employee.getSalary();
//        for(Position p : inferiors)
//        {
//            salarySum+=p.getEmployee().getSalary();
//        }
//        return salarySum;
        return employee.getSalary();
    }



    public void printDownLine(){
        print();
        for(Position p:inferiors)
        {
            p.printDownLine("  ");

        }
    }

    public void printDownLine(String indent){
        print(indent);
        for(Position p:inferiors)
        {


            p.printDownLine("  " + indent);

        }
    }

    public Employee getEmployee()
    {
        return this.employee;
    }

    public void addInferiors(Position ...p){
        inferiors.addAll(Arrays.asList(p));
    }


    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof Position))
            return false;

        Position p = (Position) obj;

        if(inferiors.size() == p.inferiors.size())
        {
            for(int i = 0; i <inferiors.size();i++)
                if(!inferiors.get(i).equals(p.inferiors.get(i)))
                    return false;
        }

        if(title.equals(p.title))
            if(description.equals(p.description))
                if (department.equals(p.department))
                    if(superior.equals(p.superior))
                        return employee.equals(p.employee);
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "\tTitle: "+title+
                "\n\tDescription: "+description+
                "\n\tDepartment: "+department.toString()+
                "\n\tEmployee: "+employee;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Position clone = null;
        try{
            clone = (Position) super.clone();
            clone.department = new Department(department.getName(), department.getLocation());
            clone.superior = (Position) superior.clone();
            clone.inferiors = new ArrayList<>(inferiors);
            clone.employee = (Employee) employee.clone();
        }catch (CloneNotSupportedException cns){
            System.out.println(cns.toString());
        }
        return clone;

    }
}
