package assignment1;

public abstract class Person implements IPerson{
    private String name;
    private String phone;
    private int age;

    public Person(String name, String phone, int age) {
        this.name = name;
        this.phone = phone;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


//
//    public abstract int getTotalUnits();
//    public abstract double getSalary();
//    public abstract void addCourse(Course c);


    @Override
    public void myAbstract() {
        System.out.println("from myAbstract");
    }

    public void print() {
        System.out.println("Name: "+ name+" Phone: "+ phone+ " Age: "+ age+ " type: "+ getClass().getSimpleName());

    }
}
