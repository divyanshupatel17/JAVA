1.
Problem Statement



Develop a program that calculates the number of permutations for N elements using the formula N!. The program should accept user input for the value of N and throw an exception for negative values.



Implement a method calculatePermutations that takes N as a parameter and calculates the number of permutations. Throw an IllegalArgumentException with the message "Error: Negative value of N" if the input N is negative. 



In the main method, catch and handle any IllegalArgumentException thrown by the calculatePermutations method.

Input format :
The input consists of an integer N.

Output format :
The output prints the long number representing the number of permutations of the given integer N.

If N is negative, print "Error: Negative value of N"



Refer to the sample output for formatting specifications.

Sample test cases :
Input 1 :
5
Output 1 :
120
Input 2 :
-9
Output 2 :
Error: Negative value of N  Whitelist
Set 1:
IllegalArgumentException
try
catch
throw

class PermutationCalculator {

    public static void main(String[] args) {
        // Example input
        int N = 5;  // Can be modified for testing

        try {
            long result = calculatePermutations(N);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to calculate permutations (N!) and throw exception for negative N
    public static long calculatePermutations(int N) {
        if (N < 0) {
            throw new IllegalArgumentException("Error: Negative value of N");
        }

        return factorial(N);
    }

    // Helper method to calculate factorial (N!)
    public static long factorial(int N) {
        long fact = 1;
        for (int i = 2; i <= N; i++) {
            fact *= i;
        }
        return fact;
    }
}


2.
Problem Statement



Anu is developing a program that represents a book and ensures the validity of its attributes upon creation. The program should handle exceptions for invalid book details and provide informative error messages.



Implement a Book class with the following attributes: title (String), author (String), publicationYear (int).
Create a constructor for the Book class that initializes the book's attributes (title, author, publication year).
Implement private validation methods (validateTitle, validateAuthor, validatePublicationYear) to ensure that the title is not empty, the author is not empty, and the publication year is a positive integer.
Throw IllegalArgumentException with appropriate error messages if validation fails.
Implement a method addBook in the Book class that prints "Book added successfully" to the console.


Help Anu to design the program.

Input format :
The first line of input consists of a string, representing the title of the book.

The second line consists of a string, representing the author of the book.

The third line consists of an integer, representing the publication year of the book.

Output format :
If the book is added, print "Book added successfully"

If the title is an empty string, print "Invalid title: Title should not be empty"

If the author is an empty string, print "Invalid author: Author should not be empty"

If the publication year is not a positive integer, print "Invalid publication year: Publication year should be a positive integer".



Refer to the sample output for formatting specifications.

Code constraints :
length of the input string ≤ 100 characters

Sample test cases :
Input 1 :
The Great Gatsby
F. Scott Fitzgerald
1925
Output 1 :
Book added successfully
Input 2 :

F. Scott Fitzgerald
1925
Output 2 :
Invalid title: Title should not be empty
Input 3 :
Harry Potter and the Sorcerer's Stone
J.K. Rowling
-1997
Output 3 :
Invalid publication year: Publication year should be a positive integer
Input 4 :
Ambedkar: A Life

2022
Output 4 :
Invalid author: Author should not be empty
Note :
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private int publicationYear;

    public Book(String title, String author, int publicationYear) {
        validateTitle(title);
        validateAuthor(author);
        validatePublicationYear(publicationYear);
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    private void validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid title: Title should not be empty");
        }
    }

    private void validateAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid author: Author should not be empty");
        }
    }

    private void validatePublicationYear(int year) {
        if (year <= 0) {
            throw new IllegalArgumentException("Invalid publication year: Publication year should be a positive integer");
        }
    }

    public void addBook() {
        System.out.println("Book added successfully");
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        String author = scanner.nextLine();
        int publicationYear = scanner.nextInt();

        try {
            Book book = new Book(title, author, publicationYear);
            book.addBook();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}

