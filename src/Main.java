import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // Create Library object
        Library library = new Library();

        // Create some books
        Book b1 = new Book(9546584839L, "The Alchemist", "Paulo Coelho", true);
        Book b2 = new Book(8548475784L, "Atomic Habits", "James Clear", true);
        Book b3 = new Book(8475748857L, "A Thousand Splendid Suns", "Khalid Hosseini", true);

        // Add books to the library
        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        // register users
        library.registerUser(new User(1234, "Khwaish", "khwaish0403@gmail.com", "khwaish"));
        library.registerUser(new User(5678, "Pawan", "pawan7696@gmail.com", "pawan"));

        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        User loggedIn = library.login(email, pass);

        if (loggedIn != null) {
            int choice;
            do {
                System.out.println("\n--- Menu ---");
                System.out.println("1. Show All Books");
                System.out.println("2. Borrow Book");
                System.out.println("3. Return Book");
                System.out.println("4. Logout");
                System.out.println("Enter choice: ");
                choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        library.showAllBooks();
                        break;
                    case 2:
                        System.out.print("Enter book title to borrow: ");
                        String borrowTitle = sc.nextLine();
                        Book bookToBorrow = library.searchBook(borrowTitle);
                        if (bookToBorrow != null) {
                            library.issueBook(loggedIn, bookToBorrow);
                        } else {
                            System.out.println("Book not found: " + borrowTitle);
                        }
                        break;
                    case 3:
                        System.out.print("Enter book title to return: ");
                        String returnTitle = sc.nextLine();
                        Book bookToReturn = library.searchBook(returnTitle);
                        if (bookToReturn != null) {
                            library.returnBook(loggedIn, bookToReturn);
                        } else {
                            System.out.println("Book not found: " + returnTitle);
                        }
                        break;
                    case 4:
                        System.out.println("Logged out.");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } while (choice !=4);
        }
    }
}