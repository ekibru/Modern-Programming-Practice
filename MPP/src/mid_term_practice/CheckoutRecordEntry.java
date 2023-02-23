package mid_term_practice;

import java.time.LocalDate;

public class CheckoutRecordEntry {

    private final LocalDate checkoutDate;
    private final LocalDate dueDate;
    private LendingItem lendingItem = new LendingItem();

    private final ItemType itemType;

    public CheckoutRecordEntry(LendingItem lendingItem,LocalDate checkoutDate, LocalDate dueDate, ItemType itemType) {
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.lendingItem = lendingItem;
        this.itemType = itemType;

    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }


    public LocalDate getDueDate() {
        return dueDate;
    }



    public LendingItem getLendingItem() {
        return lendingItem;
    }



    public ItemType getLendingItemType() {
        return itemType;
    }

}
