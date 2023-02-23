package mid_term_practice;

public class CD extends LendingItem{
    private String productId;
    private String title;
    private String company;

    public CD(String id, String title, String company) {
        this.productId = id;
        this.title = title;
        this.company = company;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof  CD && ((CD)obj).productId.equals(productId) && ((CD)obj).title.equals(this.title);
    }
}
