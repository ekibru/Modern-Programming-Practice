package assignment1;

public class Course {
   private String number;
   private String title;
   private int units;

   public Course(String number, String title, int units) {
      this.number = number;
      this.title = title;
      this.units = units;

      
      
   }

   public String getNumber() {
      return number;
   }

   public void setNumber(String number) {
      this.number = number;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public int getUnits() {
      return units;
   }

   public void setUnits(int units) {
      this.units = units;
   }
}
