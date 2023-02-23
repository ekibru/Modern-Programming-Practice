package streams;

import java.util.*;
import java.util.stream.Collectors;

//Comparator,  EMBEDDED IN THE sort METHOD ITSELF:
 class EmployeeInfo {
     static enum SortMethod {BYNAME, BYSALARY};
     String str = "sdfgdfg";

    public void sort(List<Employee> emps, final SortMethod method) {

        class EmployeeComparator implements Comparator<Employee> {

            //SortMethod method argument is outside
            //of the EmployeeComparator class (JL).

            @Override  //Comparator is now aware of sort method

            public int compare(Employee e1, Employee e2) {
                if(method == SortMethod.BYNAME) {  //  free variable
                    return e1.getFirstName().compareTo(e2.getFirstName());
                } else {
                    if(str.equals("asd")) return 1;
                    if(e1.getSalary() == e2.getSalary()) return 0;
                    else if(e1.getSalary() < e2.getSalary()) return -1;
                    else return 1;
                }
            }
        }
        Collections.sort(emps, new EmployeeComparator());
    }


//    public static void main(String[] args) {
//        List<Employee>emps = new ArrayList<>();
//        emps.add(new Employee("Joe", 100000));
//        emps.add(new Employee("Tim", 50000));
//        emps.add(new Employee("Andy", 60000));
//
//        EmployeeInfo  ei = new EmployeeInfo();
//        ei.sort(emps, EmployeeInfo.SortMethod.BYNAME);
//        System.out.println(emps);
//        //same instance
//        ei.sort(emps, EmployeeInfo.SortMethod.BYSALARY);
//        System.out.println(emps);
//    }
}

