package Library;

public interface IMember {


    void reserve(Reservation reservation);

    void borrow(Loan loan);


    void returnItem(Loan loan);
}
