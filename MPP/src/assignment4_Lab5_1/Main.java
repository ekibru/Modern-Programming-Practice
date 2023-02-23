package assignment4_Lab5_1;

import java.time.LocalDateTime;

public class Main {
    static AEmployee salaried = new Salaried(2500, "Bara");
    static AEmployee hourly = new Hourly("Batta", 32, 40);
    static AEmployee commissioned = new Commissioned("iam commissioned", 3000, 0.07);

    public static void main(String[] args) {

        Order order1 = new Order(1, LocalDateTime.of(2022,2,1,0,0),1500);
        Order order2 = new Order(2, LocalDateTime.of(2022,3,1,0,0),1500);
        Order order3 = new Order(3, LocalDateTime.of(2022,2,1,0,0),1500);
        Order order4 = new Order(4, LocalDateTime.of(2022,1,1,0,0),1500);

        commissioned.addOrder(order1);
        commissioned.addOrder(order2);
        commissioned.addOrder(order3);
        commissioned.addOrder(order4);

        salaried.addPaycheck(salaried.calcCompensation(1, 2021));
        salaried.addPaycheck(salaried.calcCompensation(2, 2021));
        salaried.addPaycheck(salaried.calcCompensation(3, 2021));
        salaried.print();

        System.out.println("\n------------------\t------------------\t------------------\t------------------");
        hourly.addPaycheck(hourly.calcCompensation(1, 2021));
        hourly.addPaycheck(hourly.calcCompensation(2, 2021));
        hourly.addPaycheck(hourly.calcCompensation(3, 2021));
        hourly.print();

        System.out.println("\n--------------\t------------------\t------------------\t------------------");
        commissioned.addPaycheck(commissioned.calcCompensation(1, 2022));
        commissioned.addPaycheck(commissioned.calcCompensation(2, 2022));
        commissioned.addPaycheck(commissioned.calcCompensation(3, 2022));
        commissioned.print();

    }
}
