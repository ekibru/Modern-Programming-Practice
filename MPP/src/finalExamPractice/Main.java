package finalExamPractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee("Bara","Bata", 40000,"IT"));
        emps.add((Employee) emps.get(0).clone());

    }
}
