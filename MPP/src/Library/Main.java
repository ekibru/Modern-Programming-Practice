package Library;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Library library = new Library("MIU Library");
        Member bara = new Member("1","Bara Batta","NY, NYC","9178323297");

        IItem book1 = new Book("123456","TM 1",3);
        IItem book2 = new Book("123457","TM 2",4);
        IItem book3 = new Book("123458","TM 3",7);
        IItem book4 = new Book("123459","TM 4",1);

        IItem magazine = new Magazine("New York Times",50,32);

        IItemCopy bookCopy = new ItemCopy("1",true,book1);
        IItemCopy bookCopy2 = new ItemCopy("2",true,book1);
        IItemCopy bookCopy3 = new ItemCopy("3",true,book1);

        book1.addItemCopy(bookCopy);
        book1.addItemCopy(bookCopy2);
        book1.addItemCopy(bookCopy3);


        Loan newLoan = new Loan(bookCopy,new Date(),null);
        bara.borrow(newLoan);
        System.out.println(book1.checkAvailability());
        System.out.println(bookCopy.checkAvailability());

    }
}
