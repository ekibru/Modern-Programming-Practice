package Library;

public class Magazine extends AItem{
    private int issue;
    public Magazine(String title, int limit,int issue) {
        super(title, limit);
        this.issue = issue;
    }

    @Override
    public boolean checkAvailability() {
        return false;
    }
}
