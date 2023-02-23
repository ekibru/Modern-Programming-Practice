package Library;

import java.util.Date;

public class Reservation {
    private IItem item;
    private Date reservationDate;

    public Reservation(IItem item, Date reservationDate) {
        this.item = item;
        this.reservationDate = reservationDate;
    }

    public boolean checkAvailability(IItem item)
    {
        return item.checkAvailability();
    }

}
