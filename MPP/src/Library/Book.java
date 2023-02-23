package Library;

import java.util.ArrayList;
import java.util.List;

public class Book extends AItem{
    private String ISBN;
    List<String> authorList;

    public Book(String ISBN,String title,int limit) {
        super(title,limit);
        this.ISBN = ISBN;
        this.authorList = new ArrayList<>();
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public boolean checkAvailability() {
        for (IItemCopy ic :itemCopies)
            if(ic.checkAvailability())
                return true;
        return false;
    }
}
