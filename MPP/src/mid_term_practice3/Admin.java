package mid_term_practice3;

public class Admin {
    private final Department [] departments;
    public Admin(Department [] dept) {
        this.departments = dept;
    }
    //implement
        public String hourlyCompanyMessage(){
        StringBuilder str = new StringBuilder();
        try {
            for (Department d : departments) {
                str.append(format(d.getName(),d.nextMessage())).append("\n");
            }
        }catch (EmptyQueueException e) {
            System.out.println(e);
        }
        return str.toString();
        }
       String format(String name, String message)
       {
           return name+": "+message;
       }
}
