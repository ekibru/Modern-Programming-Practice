package mid_term_practice;

public class Book extends LendingItem{
	private final String isbn;
	private final String title;
	private final String authorFirstName;
	private final String authorLastName;

    public Book(String isbn, String title, String authorFirstName, String authorLastName) {
        this.isbn = isbn;
        this.title = title;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof  Book && ( (Book) obj).isbn.equals(this.isbn);
    }
}
