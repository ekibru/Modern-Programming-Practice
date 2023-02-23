package assignment1;

import Library.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Department {
    private String Name;

    public String getName() {
        return Name;
    }

    public int[] getArr() {
        return arr;
    }

    public List<Person> getMembers() {
        return Members;
    }

    int[] arr = new int [] {1,2,3,4};
    private final List<Person> Members;

    public Department(String name){
        this.Name = name;
        Members = new ArrayList<>();
    }

    public void addPerson(Person p){
        Members.add(p);
    }
    public double getTotalSalary(){
        double sum = 0.0;
        //////Functional Way
        sum = Members.stream().filter(m-> m instanceof Faculty || m instanceof Staff)
                .mapToDouble(Person::getSalary).reduce(0, Double::sum);


        /////// Imperative way

//            for (Person p : Members) {
//                if (p instanceof Faculty) {
//                    sum += ((Faculty) p).getSalary();
//                } else if (p instanceof Staff) {
//                    sum += ((Staff) p).getSalary();
//                }
//            }
//        sum = 0.0;
//            for(Person p:Members){
//                sum+= p.getSalary();
//            }

        return sum;
    }

    public void showAllMembers(){
        ////Functional Way
        Members.stream().forEach(Person::print);

        ////Imperative Way
//        for(Person p: Members){
//            p.print();
//        }
    }

    public Person findFacultyByName(String name)
    {
        ///Functional way
        Optional<Person> optionalPerson = Members.stream().filter(m->m instanceof  Faculty && m.getName().equalsIgnoreCase(name)).findFirst();
        return optionalPerson.orElse(null);//return optionalPerson.orElseGet(null);
        ////Imperative way
//        for(Person p : Members)
//        {
//            if(p instanceof Faculty && p.getName().equalsIgnoreCase(name))
//                return p;
//        }
//        return null;
    }

    public void unitsPerFaculty(){
        ////Functional Programming
        ///Imperative Way
        System.out.println("-------- instanceof way -------");
        for(Person f: Members)
        {
            if(f instanceof Faculty)
            {
                System.out.println("Name: "+ f.getName() + " totalUnits: "+f.getTotalUnits());
            }
        }

        System.out.println("-------- getClass().getSimpleName() way -------");
        for(Person f: Members)
        {
            if(f.getClass().getSimpleName().equals("Faculty"))
            {
                System.out.println("Name: "+ f.getName() + " totalUnits: "+f.getTotalUnits());
            }
        }

    }
}
