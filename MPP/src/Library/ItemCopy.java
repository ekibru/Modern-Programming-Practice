package Library;

public class ItemCopy implements IItemCopy{
    private String copyId;
    private boolean available;

    private IItem item;
    @Override
    public boolean checkAvailability() {
        return available;
    }

    @Override
    public void setAvailabilty(boolean b) {
        this.available = b;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public ItemCopy(String copyId, boolean available,IItem item) {
        this.copyId = copyId;
        this.available = available;
        this.item = item;
    }
}
