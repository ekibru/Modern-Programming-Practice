package streams;
// Program 4: ProcessingEmployees.java
// Processing streams of Employee objects.
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessingEmployees
{
   public static void main(String[] args)
   {
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

      // display all Employee mplete Employee list:");
      list.stream().forEach(System.out::println);   //A method reference.

      // To test Collectors.joining
      // Convert elements to strings and concatenate them, separated by commas
      String joined = list.stream()
              .map(Object::toString)  //  this DOES go to the overridden method  toString  inside Employee!!  Yes!!

                                     //  joining method needs Strings coming in.  

              //.map(Employee::toString)  //  this also DOES work!!  Yes!!
              .collect(Collectors.joining(", "));

      System.out.println("\n\n" + joined);

      System.out.println("------ Q2.a.1 -----");
      long count = list.stream().filter(employee -> employee.getLastName().startsWith("B")).count();
      System.out.println("The count of Employees their last name starts with 'b': "+count);

      list.stream().filter(e->e.getLastName().startsWith("b")).count();

      System.out.println("\n------ Q2.a.2 -----");
      list.stream().filter(employee -> employee.getLastName().startsWith("B")).sorted(Comparator.comparing(Employee::getLastName)).forEach(System.out::println);

      System.out.println("\n------ Q2.a.3 with changing the state -----");
      list.stream().filter(employee -> employee.getLastName().startsWith("B")).peek(e -> {e.setFirstName(e.getFirstName().toUpperCase());e.setLastName(e.getLastName().toUpperCase());
              })
              .forEach(System.out::println);

      System.out.println("\n------ Q2.a.3 without changing the state -----");
      list.stream().filter(employee -> employee.getLastName().startsWith("B")).map(e->new Employee(e.getFirstName().toUpperCase(),e.getLastName().toUpperCase(),e.getSalary(),e.getDepartment()))
              .forEach(System.out::println);

      System.out.println("\n------ Q2.a.4  -----");
      list.stream().map(e -> e.getLastName().startsWith("B") ?new Employee(e.getFirstName(),e.getLastName().toUpperCase(),e.getSalary(),e.getDepartment()):e).forEach(System.out::println);

      System.out.println("\n------ Q2.a.4.1  -----");
      System.out.println(list.stream().map(Employee::toString).collect(Collectors.joining(" -- JOINING -- ")));

      System.out.println("\n------ Q2.a.4.2  -----");
      System.out.println(list.stream().map(Employee::toString).collect(Collectors.joining(" ---\n--- ")));

      System.out.println("\n------ Q2.a.5  -----");
      list.stream().filter(e->e.getLastName().startsWith("I")).map(e->e.getLastName().toUpperCase()).distinct().forEach(System.out::println);

      System.out.println("\n------ Q2.a.6  -----");
      double totalSalary = list.stream().collect(Collectors.averagingDouble(Employee::getSalary));
      System.out.printf("Average Salary : %,.2f \n",totalSalary);

      System.out.println("\n------ Q2.a.7  -----");
      System.out.println(list.stream().mapToDouble(Employee::getSalary).reduce(0, Double::sum));

      System.out.println("\n------ Q2.a.8  -----");
      list.stream().map(Employee::getFirstName).collect(Collectors.toList()).forEach(System.out::println);

      System.out.println("\n------ Q2.a.9  -----");

      Stream<Integer> stream = Stream.iterate(0,(i)->i+2);
      stream.limit(20).forEach(System.out::println);

      Optional<Employee> optional = list.stream().findAny();
      System.out.println("findAny():  "+optional);

      Optional<Employee> optional2 = list.stream().findFirst();

      Employee opEmp = Optional.of(list.get(0)).orElse(list.get(1));///this is the meaning of orElse
      Employee opEmp2 = Optional.of(list.get(0)).orElseGet(Employee::new);///this is the meaning of orElseGet  /// orElseGet(() -> list.get(1)

      System.out.println("findFirst(): "+optional2);

      System.out.println("the value of optional "+ optional2.orElseGet(Employee::new));//optional2.orElseGet(Employee::new) // orElseGet(()->list.get(0))


   } // end main

} // end class ProcessingEmployees


