package assignment2;

import java.util.Date;
import java.util.Objects;

public class Employee implements ICommon,Cloneable {
    private final int employeeId;
    private final String firstName;

    private final String middleInitial;
    private final String lastName;
    private  Date birthdate;
    private final int SSN;
    private final double salary;
    public Employee(int employeeId, String firstName, String middleInitial, String lastName, Date birthdate, int SSN, double salary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.SSN = SSN;
        this.salary = salary;
    }
    public void print(){
//        System.out.println("ID: " + employeeId + ", Name: " + firstName + " " + middleInitial + " " + lastName + " , Birthdate: " + birthdate);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ID: ").append(employeeId).append(", Name: ").append(firstName).append(" ").append(middleInitial).append(" ").append(lastName).append(" , Birthdate: " ).append(birthdate);
        System.out.println(stringBuilder);
    }
    public void print(String indent){
//        System.out.println("ID: " + employeeId + ", Name: " + firstName + " " + middleInitial + " " + lastName + " , Birthdate: " + birthdate);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ID: ").append(employeeId).append(", Name: ").append(firstName).append(" ").append(middleInitial).append(" ").append(lastName).append(" , Birthdate: " ).append(birthdate);
        System.out.println(indent+stringBuilder);
    }

    public String getName(){
        return firstName+" "+middleInitial+" "+lastName;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object e){
        if(e == null)
            return false;
        if(!(e instanceof Employee))
            return false;
        if(this.hashCode() == e.hashCode())
            return true;
        Employee castedE = (Employee) e;

        if(this.employeeId == castedE.employeeId)
            if(this.SSN == castedE.SSN)
                if (this.firstName.equals(castedE.firstName))
                    if(this.middleInitial.equals(castedE.middleInitial))
                        if (this.lastName.equals(castedE.lastName))
                            if (this.birthdate.compareTo(castedE.birthdate) == 0)
                                return this.salary == castedE.salary;
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(employeeId,firstName,middleInitial,lastName,SSN,salary,birthdate);
    }

    @Override
    public String toString(){
        return "\tEmpID: "+employeeId+
                "\n\tName: "+firstName+" "+middleInitial+ " "+lastName+
                "\n\tBirthdate: "+birthdate+
                "\n\tSSN: "+SSN+
                "\n\tSalary: "+salary;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Employee clone = null;
        try{
             clone = (Employee) super.clone();
             clone.birthdate = new Date(String.valueOf(birthdate));

        }catch (CloneNotSupportedException cns) {
            System.out.println(cns.toString());
        }
        return clone;
    }
}
