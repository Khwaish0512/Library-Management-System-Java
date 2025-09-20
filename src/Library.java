import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    // Constructor
    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added:" + book.getTitle());
    }

    // Show all books
    public void showAllBooks() {
        if(books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }

    //Search book by title
    public Book searchBook(String title) {
        for(Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b ;
            }
        }
        System.out.println("Book not found with title: " + title);
        return null;
    }

    // Register a new user
    public void registerUser(User user) {
        users.add(user);
        System.out.println("User registered: " + user.getName());
    }

    public User login(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Login successful. Welcome " + user.getName() + "!");
                return user;
            }
        }
        System.out.println("Invalid email or password. ");
        return null;
    }

    //Issue a book to a user
    public void issueBook(User user, Book book) {
        if(!book.isAvailable()) {
            System.out.println("Book is not available:" + book.getTitle());
            return;
        }
        book.setAvailable(false);
        user.borrowBook(book);
        System.out.println("Book issued: " + book.getTitle() + " to " + user.getName());
    }

    //Return a book from user
    public void returnBook(User user, Book book) {
        if (user.getBorrowedBooks().contains(book)) {
            book.setAvailable(true);
            user.returnBook(book);
            System.out.println("Book returned: " + book.getTitle() + " from " + user.getName());
        } else {
            System.out.println(user.getName() + " did not borrow " + book.getTitle());
        }
    }
}

