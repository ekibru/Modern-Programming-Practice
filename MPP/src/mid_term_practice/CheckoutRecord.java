package mid_term_practice;

import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord {
    private final List<CheckoutRecordEntry> checkoutRecordEntryList = new ArrayList<>();

    public List<CheckoutRecordEntry> getCheckoutRecordEntryList() {
        return checkoutRecordEntryList;
    }

    public void addCheckoutEntry(CheckoutRecordEntry entry) {
        this.checkoutRecordEntryList.add(entry);
    }
}
