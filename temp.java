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