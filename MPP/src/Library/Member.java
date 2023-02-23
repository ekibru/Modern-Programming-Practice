package Library;

import java.util.ArrayList;
import java.util.List;

public class Member implements IMember{
    protected String id;
    protected String name;
    protected String address;
    protected String phone;
    private final List<Loan> loans;
    private final List<Reservation> reservations;

    public Member(String id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        loans = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void reserve(Reservation reservation) {
        reservations.add(reservation);
    }

    @Override
    public void borrow(Loan loan) {
        loans.add(loan);
        loan.getItemCopy().setAvailabilty(false);
    }

    @Override
    public void returnItem(Loan loan) {
        loans.remove(loan);
    }

}
