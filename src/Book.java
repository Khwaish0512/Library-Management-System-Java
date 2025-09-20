public class Book {
    private String title;
    private String authorName;
    private long isbn;
    boolean isAvailable;

    // Constructor
    public Book(long isbn, String title, String authorName, boolean isAvailable) {
        this.isbn = isbn;
        this.title = title;
        this.authorName = authorName;
        this.isAvailable = isAvailable;
    }

    // Getters
    public long getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setters
    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    // For printing book info
    @Override
    public String toString() {
        return "Book{" +
                "ISBN=" + isbn +
                ", Title='" + title + '\'' +
                ", Author='" + authorName + '\'' +
                ", Available=" + isAvailable +
                '}' ;
    }
}
