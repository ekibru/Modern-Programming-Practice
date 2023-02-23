package assignment3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    static Scanner scanner = new Scanner(System.in);
    static List<ICourier> couriers = new ArrayList<>();

    static List<Package> packages = new ArrayList<>();

    static List<Zone> zoneList = new ArrayList<>();

    public static void main(String[] args) {



        Zone zone1 = new Zone(1,"Zone 1",0.35);
        Zone zone2 = new Zone(2,"Zone 2",0.30);
        Zone zone3 = new Zone(3,"Zone 3",0.55);
        Zone zone4 = new Zone(4,"Zone 4",0.43);

        zone1.addState("IA");
        zone1.addState("MT");
        zone1.addState("OR");
        zone1.addState("CA");

        zone2.addState("TX");
        zone2.addState("UT");

        zone3.addState("FL");
        zone3.addState("MA");
        zone3.addState("OH");

        zoneList.add(zone1);
        zoneList.add(zone2);
        zoneList.add(zone3);
        zoneList.add(zone4);

        /*create levels for discounts , and customers */

        Level student = new Level("Student",10);
        Level senior = new Level("Senior",15);

        Customer someStudent = new Customer("Bara Batta",student);

        /* just for debug */
        packages.add(new Package("Book",2,"IA",someStudent));
        packages.add(new Package("Phone",4,"MA",someStudent));
        packages.add(new Package("Boots",6,"NY",someStudent));

        couriers.add(new UPS("UPS"));
        couriers.add(new USMail("USMail"));
        couriers.add(new FedEx("FedEx",zoneList));
        couriers.add(new DHL("DHL"));
        printTheLowestRate(packages);

        /* just for debug */


        while(true){
            System.out.println("Please Enter Number of Packages");
            int numberOfPackages = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            for(int i = 0;i < numberOfPackages;i++)
            {
                System.out.println("Please Enter Package#"+(i+1)+" DESCRIPTION");

                    String description = scanner.nextLine();
                System.out.println("Please Enter Package#"+(i+1)+" WEIGHT");

                    double weight = scanner.nextDouble();
                    scanner.nextLine();
                System.out.println("Please Enter Package#"+(i+1)+" ZONE");

                    String zone = scanner.nextLine();

                packages.add(new Package(description,weight,zone,someStudent));
            }

            printTheLowestRate(packages);
        }
    }

    public static void printTheLowestRate(List<Package> packages){
        for (Package p : packages)
        {
            double lowest = Double.MAX_VALUE;
            ICourier courierLowest = couriers.get(0);
            for(ICourier courier : couriers)
            {
                double rate = courier.getRate(p);
//                System.out.println("The Rate = " + rate);
                if(rate < lowest)
                {
                    lowest = rate;
                    courierLowest = courier;
                }
            }

            System.out.print(p.getDescription() +"   " );
            System.out.printf("%,.2f",lowest);
            System.out.println( "     " +courierLowest.getName());

        }
    }
}
