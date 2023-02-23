package mid_term_practice;

public class LibraryMember {

    private final String memberId;
    private final String firstName;
    private final String lastName;
    private final String phone;

    private CheckoutRecord checkoutRecord;

    public CheckoutRecord getCheckoutRecord() {
        return checkoutRecord;
    }

    public void setCheckoutRecord(CheckoutRecord checkoutRecord) {
        this.checkoutRecord = checkoutRecord;
    }

    public LibraryMember(String memberId, String firstName, String lastName, String phone) {
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        checkoutRecord = new CheckoutRecord();
    }

    public String getMemberId() {
        return memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }
}
