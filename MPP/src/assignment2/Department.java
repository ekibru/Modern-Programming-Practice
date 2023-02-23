package assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department implements ICommon {
    private final String name;
    private final String location;

    private final List<Position> positions;


    public Department(String name, String location) {
        this.name = name;
        this.location = location;
        positions = new ArrayList<>(3);
    }

    @Override
    public void print() {
        System.out.println("--Department Name: " + name + " Location: " + location);

        positions.forEach(Position::print);

    }

    public List<Position> getPositions() {
        return this.positions;
    }

    @Override
    public double getSalary() {
        double salarySum = 0;
        for (Position p : positions) {
            salarySum += p.getSalary();
        }

        return salarySum;
    }

    public void printReportingHierarchy(String indent) {
        Position geptHead = this.getDepartmentHead();
        geptHead.printDownLine(indent);

    }

    public boolean equals(Department d) {
        if (name.equals(d.getName()))
            return true;
        return false;
    }

    public Position getDepartmentHead() {
        for (Position p : this.positions) {

            if (!Objects.isNull(p.getSuperior()) && !p.getSuperior().getDepartment().equals(p.getDepartment())) {
//                System.out.println(p.getEmployee().getName()+" -== superior dept "+p.getSuperior().getDepartment().getName());
                return p;
            } else if (Objects.isNull(p.getSuperior()))
                return p;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void addPosition(Position p) {
        positions.add(p);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Department))
            return false;

        Department d = (Department) obj;

        if (positions.size() == d.getPositions().size()) {
            for (int i = 0; i < positions.size(); i++) {
                if (!positions.get(i).equals(d.getPositions().get(i)))
                    return false;
            }
        }
        if (this.name.equals(d.name))
            if (this.location.equals(d.location))
                    return true;

        return false;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString(){
        return "\tDepartment Name: "+name+
                "\n\tLocation: "+location;
    }
}
