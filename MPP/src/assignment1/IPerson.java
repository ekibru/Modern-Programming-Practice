package assignment1;

public interface IPerson {
        int getTotalUnits();
        double getSalary();
        void addCourse(Course c);

        static void myStatic(){
            System.out.println("From static method");
        }

        default void myDefault(){
            System.out.println("From default method");
        }

        void myAbstract();

}
