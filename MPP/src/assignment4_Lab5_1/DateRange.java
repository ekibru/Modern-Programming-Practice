package assignment4_Lab5_1;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateRange {
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public DateRange(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean isInRange(LocalDateTime date)
    {
//        LocalDateTime dateConvert = date.toInstant()
//                .atZone(ZoneId.systemDefault())
//                .toLocalDateTime();
        return date.compareTo(startDate) >= 0 && date.compareTo(endDate) <= 0;
    }

    @Override
    public String toString(){
        return "From: "+startDate.toString() +" to "+ endDate.toString();
    }

    public static Date getFirstDayOfMonth(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    public static Date getLastDayOfMonth(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

}
