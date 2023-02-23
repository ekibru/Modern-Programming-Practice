package Library;

import java.util.Date;

public class Loan {


    private IItemCopy itemCopy;
    private Date checkOutDate;
    private Date returnDate;

    public Loan(IItemCopy itemCopy, Date checkOutDate, Date returnDate) {
        this.itemCopy = itemCopy;
        this.checkOutDate = checkOutDate;
        this.returnDate = returnDate;
    }

    public IItemCopy getItemCopy() {
        return itemCopy;
    }

    public void setItemCopy(IItemCopy itemCopy) {
        this.itemCopy = itemCopy;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
