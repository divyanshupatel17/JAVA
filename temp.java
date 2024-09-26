class Book {
    private String title;
    private String author;
    private double price;
    private int copies;

    // Constructor to initialize the book details
    public Book(String title, String author, double price, int copies) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.copies = copies;
    }

    // Getter for price
    public double getPrice() {
        return price;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Copies: " + copies);
    }

    // Static method to find the total value of all books
    public static double findTotalValue(Book[] books) {
        double totalValue = 0;
        for (Book book : books) {
            totalValue += book.price * book.copies; // Total value = price * copies
        }
        return totalValue;
    }

    // Static method to find the book with the maximum price
    public static Book findMaxPriceBook(Book[] books) {
        Book maxPriceBook = books[0];
        for (int i = 1; i < books.length; i++) {
            if (books[i].getPrice() > maxPriceBook.getPrice()) {
                maxPriceBook = books[i];
            }
        }
        return maxPriceBook;
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating an array of books
        Book[] books = new Book[3];
        books[0] = new Book("Book A", "Author A", 25.99, 10);
        books[1] = new Book("Book B", "Author B", 35.50, 5);
        books[2] = new Book("Book C", "Author C", 29.75, 3);

        // Display details of all books
        System.out.println("Details of all books:");
        for (Book book : books) {
            book.displayDetails();
            System.out.println(); // New line for better formatting
        }

        // Find and display the total value of all books
        double totalValue = Book.findTotalValue(books);
        System.out.println("Total value of all books (price * copies): $" + totalValue);

        // Find the book with the maximum price and display its details
        Book maxPriceBook = Book.findMaxPriceBook(books);
        System.out.println("\nBook with the maximum price: ");
        maxPriceBook.displayDetails();
    }
}



import java.util.ArrayList;
import java.util.List;

// Abstract class for common book properties
abstract class Book {
    protected String title;
    protected String author;
    protected double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public abstract String getDetails();
}

// Class for physical books
class PhysicalBook extends Book {
    private boolean isBorrowed;

    public PhysicalBook(String title, String author, double price) {
        super(title, author, price);
        this.isBorrowed = false; // Initially not borrowed
    }

    public String getDetails() {
        return "Physical Book: " + title + " by " + author + " Price: $" + price;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}

// Interface for borrowing behavior
interface Borrowable {
    void borrow();
    void returnBook();
}

// Abstract class for common member properties
abstract class Member {
    protected String name;
    protected int maxBooks;

    public Member(String name, int maxBooks) {
        this.name = name;
        this.maxBooks = maxBooks;
    }

    public abstract void borrowBook(PhysicalBook book);
    public abstract void returnBook(PhysicalBook book);
}

// Class for students
class Student extends Member implements Borrowable {
    private List<PhysicalBook> borrowedBooks;

    public Student(String name) {
        super(name, 3); // Max 3 books for students
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(PhysicalBook book) {
        if (borrowedBooks.size() < maxBooks && !book.isBorrowed()) {
            borrowedBooks.add(book);
            book.setBorrowed(true);
            System.out.println(name + " borrowed: " + book.getDetails());
        } else {
            System.out.println(name + " cannot borrow more books or the book is already borrowed.");
        }
    }

    public void returnBook(PhysicalBook book) {
        if (borrowedBooks.remove(book)) {
            book.setBorrowed(false);
            System.out.println(name + " returned: " + book.getDetails());
        } else {
            System.out.println("This book was not borrowed by " + name);
        }
    }
}

// Class for faculty
class Faculty extends Member implements Borrowable {
    private List<PhysicalBook> borrowedBooks;

    public Faculty(String name) {
        super(name, 5); // Max 5 books for faculty
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(PhysicalBook book) {
        if (borrowedBooks.size() < maxBooks && !book.isBorrowed()) {
            borrowedBooks.add(book);
            book.setBorrowed(true);
            System.out.println(name + " borrowed: " + book.getDetails());
        } else {
            System.out.println(name + " cannot borrow more books or the book is already borrowed.");
        }
    }

    public void returnBook(PhysicalBook book) {
        if (borrowedBooks.remove(book)) {
            book.setBorrowed(false);
            System.out.println(name + " returned: " + book.getDetails());
        } else {
            System.out.println("This book was not borrowed by " + name);
        }
    }
}

// Main class to demonstrate the library system
public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create some books
        PhysicalBook book1 = new PhysicalBook("Effective Java", "Joshua Bloch", 45.00);
        PhysicalBook book2 = new PhysicalBook("Clean Code", "Robert C. Martin", 40.00);
        PhysicalBook book3 = new PhysicalBook("Design Patterns", "Erich Gamma", 50.00);

        // Create members
        Student student1 = new Student("Alice");
        Faculty faculty1 = new Faculty("Dr. Smith");

        // Borrowing books
        student1.borrowBook(book1);
        faculty1.borrowBook(book2);
        student1.borrowBook(book3); // Should fail because max limit is reached
        faculty1.returnBook(book2);
        faculty1.borrowBook(book3);

        // Displaying borrowed books
        System.out.println("\nBooks borrowed by " + student1.name + ":");
        student1.borrowedBooks.forEach(b -> System.out.println(b.getDetails()));

        System.out.println("\nBooks borrowed by " + faculty1.name + ":");
        faculty1.borrowedBooks.forEach(b -> System.out.println(b.getDetails()));
        
        // Garbage collection suggestion (not directly implemented)
        System.gc(); // Suggesting garbage collection
    }
}