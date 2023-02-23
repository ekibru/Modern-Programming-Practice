package Library;

import java.util.ArrayList;
import java.util.List;

public abstract class AItem implements IItem{
    protected String title;
    protected List<IItemCopy> itemCopies;
    protected int limit;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public AItem(String title, int limit) {
        this.title = title;
        this.limit = limit;
        itemCopies = new ArrayList<>();
    }

    public void addItemCopy(IItemCopy itemCopy)
    {
        itemCopies.add(itemCopy);
    }
}
