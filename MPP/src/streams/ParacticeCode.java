package streams;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

    public class ParacticeCode {
        public static void main(String[] args) {
            // initialize array of Employees
            Employee[] employees = {
                    new Employee("Jason", "Red", 5000, "IT"),
                    new Employee("Ashley", "Green", 7600, "IT"),
                    new Employee("Matthew", "Indigo", 3587.5, "Sales"),
                    new Employee("James", "Indigo", 4700.77, "Marketing"),
                    new Employee("Luke", "Indigo", 6200, "IT"),
                    new Employee("Jason", "Blue", 3200, "Sales"),
                    new Employee("Wendy", "Brown", 4236.4, "Marketing")};

            // get List view of the Employees
            List<Employee> list = Arrays.asList(employees);


            // display all Employees
            System.out.println("Complete Employee list:");
            list.stream().forEach(System.out::println);   //A method reference.

            // Predicate (boolean-valued function) that returns true for salaries
            //in the range $4000-$6000
            Predicate<Employee> fourToSixThousand =
                    e -> (e.getSalary() >= 4000 && e.getSalary() <= 6000);


            System.out.printf("%nEmployees earining 4000 - 6000 in ascending order");
            list.stream()
                    .filter(fourToSixThousand)
                    .sorted(Comparator.comparing(Employee::getSalary))
                    .forEach(System.out::println);

            // Display Employees with salaries in the range $4000-$6000
            // sorted into ascending order by salary
            System.out.printf(
                    "%nEmployees earning $4000-$6000 per month sorted by salary:%n");

            list.stream()
                    .filter(fourToSixThousand)
                    .sorted(Comparator.comparing(Employee::getSalary))
                    .forEach(System.out::println);

            // Display first Employee with salary in the range $4000-$6000
            System.out.printf("%nFirst employee who earns $4000-$6000:%n%s%n",
                    list.stream()
                            .filter(fourToSixThousand)
                            .findFirst()
                            .get());

           Optional<Employee> opEmp = list.stream()
                    .filter((e)-> e.getSalary() > 4000 && e.getSalary() < 6000)
                    .sorted(Comparator.comparing(Employee::getSalary))
                    .findFirst();

           System.out.println(opEmp.orElse(list.get(0)));


           Function<Employee,String> employeeFirstName = Employee::getLastName;

            // Functions for getting first and last names from an Employee
            Function<Employee, String> byFirstName = Employee::getFirstName;
            Function<Employee, String> byLastName = Employee::getLastName;

            // Comparator for comparing Employees by first name then last name
            Comparator<Employee> lastThenFirst =
                    Comparator.comparing(byLastName).thenComparing(byFirstName);

            // sort employees by last name, then first name
            System.out.printf(
                    "%nEmployees in ascending order by last name then first:%n");
            list.stream()
                    .sorted(lastThenFirst)
                    .forEach(System.out::println);

            // sort employees in descending order by last name, then first name
            System.out.printf(
                    "%nEmployees in descending order by last name then first:%n");
            list.stream()
                    .sorted(lastThenFirst.reversed())
                    .forEach(System.out::println);

            // display unique employee last names sorted
            System.out.printf("%nUnique employee last names:%n");
            list.stream()
                    .map(Employee::getLastName)
                    .distinct()
                    .sorted()
                    .forEach(System.out::println);

            // display only first and last names
            System.out.printf(
                    "%nEmployee names in order by last name then first name:%n");
            list.stream()
                    .sorted(lastThenFirst)
                    .map(Employee::getName)
                    .forEach(System.out::println);

            // group Employees by department
            System.out.printf("%nEmployees by department:%n");
            Map<String, List<Employee>> groupedByDepartment =
                    list.stream()
                            .collect(Collectors.groupingBy(Employee::getDepartment));

            groupedByDepartment.forEach(
                    (department, employeesInDepartment) ->
                    {
                        System.out.println(department);
                        employeesInDepartment.forEach(
                                employee -> System.out.printf("   %s%n", employee));
                    }
            );

            // count number of Employees in each department
            System.out.printf("%nCount of Employees by department:%n");

            Map<String,Long> employeeCountEachDepartment = list.stream().collect(Collectors.groupingBy(Employee::getDepartment,TreeMap::new,Collectors.counting()));

            employeeCountEachDepartment.forEach((d,n)-> System.out.printf("the department %s has %d Employees%n",d,n));

            Map<String, Long> employeeCountByDepartment =
                    list.stream()
                            .collect(Collectors.groupingBy(Employee::getDepartment,
                                    TreeMap::new, Collectors.counting()));

            employeeCountByDepartment.forEach(
                    (department, count) -> System.out.printf(
                            "%s has %d employee(s)%n", department, count));


            System.out.println("Q7.Level3 a- Print out each department and the average salary for the department.");

           Map<String,Double> avergeSalary =  list.stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment,TreeMap::new,Collectors.averagingDouble(Employee::getSalary)));
            avergeSalary.forEach((department,averageSalary) -> System.out.printf("%n%s Average Salary is %f",department,averageSalary));

            System.out.println("Q7.Level3 b- Print out each department and the average salary for the department.");

            Map<String, Optional<Employee>> departmentMaxSalary = list.stream().
                    collect(Collectors.groupingBy(Employee::getDepartment,TreeMap::new,Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))));

            departmentMaxSalary.forEach((d,e)-> System.out.printf("%ndepartment %s has max salary of %,.2f %n",d,e.get().getSalary()));

            System.out.println("Q7.Level3 b- Print out each department and all of the employees who work at that department");

            Map<String,List<Employee>> departmentAndEmployee = list.stream().collect(Collectors.groupingBy(Employee::getDepartment,TreeMap::new,Collectors.toList()));

            departmentAndEmployee.forEach((d,e)->
                {
                    System.out.println("- "+d);
                    e.forEach(emp -> System.out.println("\t"+emp));
                });




        }
    }
