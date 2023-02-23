package FinalkExamPracticeApril;

import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {

	@SuppressWarnings("serial")
	public static void main(String[] args) {
		List<String> ssns = Arrays.asList("234121244", 
				                          "113145657",
				                          "342892138",
				                          "999234124",
				                          "523421589",
				                          "234112355",
				                          "553667742",
				                          "212341557",
				                          "115513151");
				
		HashMap<String, Employee> h = new HashMap<String, Employee>() {
			{
				put("523421589", new Employee("Tom Hank", 88000, "523421589"));
				put("234121244", new Employee("Bob Hank", 78000, "234121244"));
				put("212341557", new Employee("Hank Hank", 110000, "212341557"));
				put("999234124",new Employee("Ephraim Hank", 66000, "999234124"));
				put("432346624",new Employee("Dogface Hank", 54000, "432346624"));
				put("115513151",new Employee("Jonas Hank", 76000, "115513151"));
				put("113145657",new Employee("Rick Hank", 92000, "113145657"));
				put("678316579",new Employee("Yonas Hank", 82000, "678316579"));
				put("342892138",new Employee("Ibu Hank", 100000, "342892138"));
				
			}
		};
											
//		List<Employee> report = EmployeeAdmin.prepareEmpReport(h,  ssns);
//		//Expected output: [(212341557: Hank, 110000), (342892138: Ibu, 100000), (113145657: Rick, 92000), (523421589: Tom, 88000)]
//		System.out.println(report);
//
//		List<String> report2 = EmployeeAdmin.prepareSsnReport(h,  ssns);
//		//Expected output: [432346624, 678316579]
//		System.out.println(report2);

		//My own work
		Predicate<Employee> condition = employee -> employee.getSalary() > 90000;
		for(Employee e : h.values()){
			if(condition.test(e))
				System.out.println("yes , tested  "+e.getName());
		}

		h.values().stream().filter(condition).map(Employee::getName).forEach(s -> System.out.println("from stream: "+s));

		///Supplier
		Supplier<Integer> employeeSupplier = ()-> new Random().nextInt(1000);
		employeeSupplier.get();

		Function<Employee,String> getFirstName = employee->{return employee.getName().substring(0,employee.getName().indexOf(' '));};
		Function<Employee,String> getLastName = employee -> employee.getName().substring(employee.getName().indexOf(' ')+1);

		Function<String,String> toUpperCase = String::toUpperCase;

		System.out.println(getFirstName.andThen(toUpperCase).apply(h.get("115513151")));

		"hello".concat(" jh");

		BiFunction<String,Employee,String> concatSSN = (firstName,emp) -> toUpperCase.apply(firstName).concat(emp.getSsn());

		System.out.println(concatSSN.apply(getFirstName.apply(h.get("115513151")),h.get("115513151")));

		UnaryOperator<Employee> empU = employee -> employee;
		empU.apply(h.get("115513151"));
		IntUnaryOperator intBy5 = i->i + 5;
		intBy5.applyAsInt(5);
									
    }

}
