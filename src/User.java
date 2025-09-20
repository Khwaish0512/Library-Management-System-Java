import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String name;
    private String email;
    private String password;
    private List<Book> borrowedBooks = new ArrayList<>();

    //Constructor
    public User(int userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // getters and setters
    public int getUserId() {
        return userId;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() { return password;}
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Methods
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "User { " +
                "ID=" + userId +
                ", Name='" + name + '\'' +
                ", Email='" + email + '\'' +
                ", BorrowedBooks=" + borrowedBooks.size() +
                " }";
    }
}
