1. Banking System Flowchart

                 +-------------------+
                 | AccountOperations |
                 |   (Interface)     |
                 +-------------------+
                        /|\
                         |
          +-------------------------------+
          |        BankAccount            |
          |  (Abstract Class)             |
          +-------------------------------+
                         |
       +-------------------------------------+
       |                                     |
+-------------------+               +-------------------+
|  SavingsAccount   |               |  CurrentAccount   |
+-------------------+               +-------------------+
            |                                   |
+-------------------------------+    +---------------------------+
| FixedDepositAccount (Final)  |    |   Overdraft Management    |
+-------------------------------+    +---------------------------+

import java.util.*;

// Interface representing basic account operations
interface AccountOperations {
    void deposit(float amount); // abstract method for deposit
    void withdraw(float amount); // abstract method for withdraw
    void displayBalance(); // abstract method to display balance
}

// Abstract class representing a bank account
abstract class BankAccount implements AccountOperations {
    private final int accountNumber; // final variable - unique for every account
    protected float balance; // protected so that subclasses can access
    private static int accountCounter = 1000; // static variable to auto-generate account numbers

    // Constructor for initializing the balance
    public BankAccount(float initialBalance) {
        this.balance = initialBalance;
        this.accountNumber = ++accountCounter; // auto-increment account number
    }

    // Concrete method to get account number
    public int getAccountNumber() {
        return accountNumber;
    }

    // Abstract method to calculate interest, implemented by subclasses
    public abstract float calculateInterest();

    // Static method to show total accounts created
    public static void showTotalAccounts() {
        System.out.println("Total Accounts Created: " + accountCounter);
    }

    // Using the 'this' keyword to show balance information
    public void showAccountInfo() {
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Balance: " + this.balance);
    }

    // Overloaded method for withdrawing, demonstrating polymorphism (method overloading)
    public void withdraw(float amount, boolean isATM) {
        if (isATM) {
            System.out.println("ATM Withdrawal processing...");
        }
        withdraw(amount); // calls original withdraw method
    }
}

// Subclass representing a savings account
class SavingsAccount extends BankAccount {
    private final float interestRate;

    // Parameterized constructor
    public SavingsAccount(float initialBalance, float interestRate) {
        super(initialBalance); // calling superclass constructor using 'super'
        this.interestRate = interestRate;
    }

    // Implementing abstract method from parent class
    @Override
    public float calculateInterest() {
        return balance * (interestRate / 100);
    }

    // Overriding withdraw method from interface (method overriding)
    @Override
    public void withdraw(float amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful! New Balance: " + balance);
        }
    }

    // Overriding deposit method from interface
    @Override
    public void deposit(float amount) {
        balance += amount;
        System.out.println("Deposit successful! New Balance: " + balance);
    }

    @Override
    public void displayBalance() {
        System.out.println("Savings Account Balance: " + balance);
    }
}

// Subclass representing a current account
class CurrentAccount extends BankAccount {
    private float overdraftLimit;

    // Constructor
    public CurrentAccount(float initialBalance, float overdraftLimit) {
        super(initialBalance); // calling superclass constructor
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public float calculateInterest() {
        return 0; // No interest for current accounts
    }

    @Override
    public void withdraw(float amount) {
        if (amount > (balance + overdraftLimit)) {
            System.out.println("Overdraft limit exceeded!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful! New Balance: " + balance);
        }
    }

    @Override
    public void deposit(float amount) {
        balance += amount;
        System.out.println("Deposit successful! New Balance: " + balance);
    }

    @Override
    public void displayBalance() {
        System.out.println("Current Account Balance: " + balance);
    }
}

// Subclass representing a fixed deposit account (final class cannot be inherited)
final class FixedDepositAccount extends BankAccount {
    private final float interestRate;
    private final int depositTerm;

    // Constructor
    public FixedDepositAccount(float initialBalance, float interestRate, int depositTerm) {
        super(initialBalance);
        this.interestRate = interestRate;
        this.depositTerm = depositTerm;
    }

    // Overriding abstract method from BankAccount
    @Override
    public float calculateInterest() {
        return balance * (interestRate / 100) * depositTerm;
    }

    // Preventing withdrawal from Fixed Deposit
    @Override
    public void withdraw(float amount) {
        System.out.println("Withdrawal not allowed from Fixed Deposit Account until maturity!");
    }

    @Override
    public void deposit(float amount) {
        System.out.println("Deposit not allowed in Fixed Deposit Account after initial deposit.");
    }

    @Override
    public void displayBalance() {
        System.out.println("Fixed Deposit Account Balance: " + balance);
    }
}

// Class representing the bank with an array of objects (customers)
class Bank {
    private final List<BankAccount> accounts = new ArrayList<>();

    // Method to add accounts to the bank
    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    // Method to display account information for all customers
    public void displayAllAccounts() {
        for (BankAccount account : accounts) {
            account.showAccountInfo();
            account.displayBalance();
            System.out.println("Interest: " + account.calculateInterest());
            System.out.println("--------------------------");
        }
    }
}

// Main class to simulate the banking system
public class BankingSystem {
    public static void main(String[] args) {
        // Array of objects
        Bank bank = new Bank();

        // Creating accounts using parameterized constructors
        SavingsAccount savings1 = new SavingsAccount(1000, 3.5f);
        CurrentAccount current1 = new CurrentAccount(2000, 500);
        FixedDepositAccount fd1 = new FixedDepositAccount(5000, 5.5f, 2);

        // Adding accounts to the bank
        bank.addAccount(savings1);
        bank.addAccount(current1);
        bank.addAccount(fd1);

        // Showing account information and balances
        bank.displayAllAccounts();

        // Static method call
        BankAccount.showTotalAccounts();

        // Demonstrating garbage collection
        fd1 = null;
        System.gc(); // Requesting garbage collection
    }

    // Override finalize method to see when garbage collection happens
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Garbage collection performed!");
    }
}

2.
        +---------------+
        |     Book      |
        | (Abstract Class) |
        +---------------+
              /|\
               |
   +-------------------------+
   |                         |
+-------------------+  +----------------+
| PhysicalBook      |  | ElectronicBook |
+-------------------+  +----------------+
          |                      |
  +-------------------+    +---------------------+
  | Borrow Behavior   |    | Download Feature    |
  +-------------------+    +---------------------+


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

3. Library Management System

            +----------------+
            |   Borrowable   |
            |   (Interface)  |
            +----------------+
                   /|\
                    |
          +-----------------------+
          |        Member         |
          | (Abstract Class)      |
          +-----------------------+
                   /|\
                    |
       +-------------------------+
       |                         |
+-------------------+     +----------------+
|    Student        |     |    Faculty     |
+-------------------+     +----------------+
              |
  +-----------------------+
  | Borrow/Return Books   |
  +-----------------------+


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