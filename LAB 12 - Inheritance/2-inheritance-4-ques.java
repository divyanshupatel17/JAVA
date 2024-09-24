1.
Problem Statement



Arun wants to calculate the age gap between the grandfather and the son and determine the father's age after 5 years. 



Your task is to assist him in developing a program using three classes: GrandFather, Father, and Son, where GrandFather stores the grandfather's age, Father extends GrandFather to include the father's age and calculates his age after 5 years, and Son extends Father to include the son's age and calculate the age difference between the grandfather and the son.

Input format :
The input consists of three integers representing the ages of the grandfather, father, and son.

Output format :
The output prints the age difference between the grandfather and the son, and the father's age after 5 years.



Refer to the sample output for formatting specifications.

Code constraints :
50 ≤ Grandfather's age ≤ 120

30 ≤ Father's age ≤ 90

1 ≤ Son's age ≤ 60

Sample test cases :
Input 1 :
50
30
3
Output 1 :
Grandfather and son's age gap: 47 years
Father's Age: 35 years
Input 2 :
80
45
25
Output 2 :
Grandfather and son's age gap: 55 years
Father's Age: 50 years
Input 3 :
120
90
60
Output 3 :
Grandfather and son's age gap: 60 years
Father's Age: 95 years

import java.util.Scanner;

class GrandFather {
    protected int grandfatherAge;

    public GrandFather(int age) {
        this.grandfatherAge = age;
    }

    public int getGrandfatherAge() {
        return grandfatherAge;
    }
}

class Father extends GrandFather {
    protected int fatherAge;

    public Father(int grandfatherAge, int fatherAge) {
        super(grandfatherAge);
        this.fatherAge = fatherAge;
    }

    public int calculateFathersAgeAfterFiveYears() {
        return fatherAge + 5;
    }
}

class Son extends Father {
    protected int sonAge;

    public Son(int grandfatherAge, int fatherAge, int sonAge) {
        super(grandfatherAge, fatherAge);
        this.sonAge = sonAge;
    }

    public int calculateAgeGap() {
        return grandfatherAge - sonAge;
    }
}
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input ages
        int grandfatherAge = scanner.nextInt();
        int fatherAge = scanner.nextInt();
        int sonAge = scanner.nextInt();

        Son son = new Son(grandfatherAge, fatherAge, sonAge);

        // Calculate the age gap and father's age after 5 years
        int ageGap = son.calculateAgeGap();
        int fathersAgeAfterFiveYears = son.calculateFathersAgeAfterFiveYears();

        // Output the results
        System.out.println("Grandfather and son's age gap: " + ageGap + " years");
        System.out.println("Father's Age: " + fathersAgeAfterFiveYears + " years");
    }
}

2.
Problem Statement



A new airline, Boeing747, needs to calculate its total revenue based on ticket cost and seat availability. 



Implement a program using three classes: Airline, Indigo, and Boeing747, where Airline has a cost attribute, Indigo extends Airline with seatAvailability, and Boeing747 extends Indigo with a method calculateTotalRevenue to calculate the total revenue.



Note: Total revenue = ticket cost * seat availability

Input format :
The first line of input consists of a double value, representing the flight s ticket cost.

The second line consists of an integer, representing seat availability.

Output format :
The output prints the ticket cost, seat availability and the total revenue.



Refer to the sample output for the exact text and format.

Code constraints :
1000.0 ≤ ticket price ≤ 50,000.0

10 ≤ seat availability ≤ 300

Sample test cases :
Input 1 :
1000.0
100
Output 1 :
Ticket Cost: Rs. 1000.0
Seat Availability: 100 seats
Total Revenue: Rs. 100000.0
Input 2 :
22000.0
300
Output 2 :
Ticket Cost: Rs. 22000.0
Seat Availability: 300 seats
Total Revenue: Rs. 6600000.0
Input 3 :
50000.00
30
Output 3 :
Ticket Cost: Rs. 50000.0
Seat Availability: 30 seats
Total Revenue: Rs. 1500000.0

import java.util.Scanner;

class Airline {
    protected double ticketCost;

    public Airline(double ticketCost) {
        this.ticketCost = ticketCost;
    }
}

class Indigo extends Airline {
    protected int seatAvailability;

    public Indigo(double ticketCost, int seatAvailability) {
        super(ticketCost);
        this.seatAvailability = seatAvailability;
    }
}

class Boeing747 extends Indigo {
    public Boeing747(double ticketCost, int seatAvailability) {
        super(ticketCost, seatAvailability);
    }

    public double calculateTotalRevenue() {
        return ticketCost * seatAvailability;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input ticket cost and seat availability
        double ticketCost = scanner.nextDouble();
        int seatAvailability = scanner.nextInt();

        // Create a Boeing747 object
        Boeing747 boeing747 = new Boeing747(ticketCost, seatAvailability);

        // Calculate total revenue
        double totalRevenue = boeing747.calculateTotalRevenue();

        // Output the results
        System.out.printf("Ticket Cost: Rs. %.1f\n", boeing747.ticketCost);
        System.out.printf("Seat Availability: %d seats\n", boeing747.seatAvailability);
        System.out.printf("Total Revenue: Rs. %.1f\n", totalRevenue);
    }
}


3.
Problem Statement



Dinesh, a dedicated fitness enthusiast, decides to track his daily running sessions using a fitness app. He uses the app to record his running duration and speed. Write a program that takes his running duration and speed as input and calculates the calories burned during the run.



Refer to the below class diagram:





Note: met value = 7.0; calories burned = met value*(duration/60)*3.5*(speed/3.0)

Input format :
The first line of input consists of a double value d, representing the running duration.

The second line consists of a double value s, representing the speed.

Output format :
The output prints a double value, representing the total calories burned, rounded off to two decimal places.



Refer to the sample output for formatting specifications.

Code constraints :
1.0 ≤ d ≤ 120.0

1.0 ≤ s ≤ 50.0

Sample test cases :
Input 1 :
45.3
6.5
Output 1 :
40.08
Input 2 :
30.5
4.3
Output 2 :
17.85

import java.util.Scanner;

class Exercise {
    private double duration; // Duration in minutes

    // Constructor to initialize duration
    public Exercise(double duration) {
        this.duration = duration;
    }

    // Getter method for duration
    public double getDuration() {
        return duration;
    }
}

class Cardio extends Exercise {
    public Cardio(double duration) {
        super(duration); 
    }
}

class Running extends Cardio {
    private double speed; // Speed in km/h

    // Constructor to initialize duration and speed
    public Running(double duration, double speed) {
        super(duration); 
        this.speed = speed;
    }

    // Method to calculate calories burned
    public double calculateCaloriesBurned() {
        double metValue = 7.0; // Metabolic Equivalent of Task for running
        return metValue * (getDuration() / 60) * 3.5 * (speed / 3.0);
    }
}
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for running duration and speed
        double duration = scanner.nextDouble(); // Duration in minutes
        double speed = scanner.nextDouble(); // Speed in km/h

       
        Running running = new Running(duration, speed);

        // Calculating calories burned
        double caloriesBurned = running.calculateCaloriesBurned();

        // Output result rounded to two decimal places
        System.out.printf("%.2f\n", caloriesBurned);
    }
}

4
Problem Statement



Sharon, a software developer, is working on a library system program. 



She has created a class hierarchy for different types of books: 

class Book (with title and author attributes), 
class Fiction (which extends the Book class and includes an attribute called "genre" for which string "Fantasy" is passed as a default value through the constructor), 
class Fantasy (which extends the Fiction class and includes an attribute called daysLate).


Now, she needs to calculate the late fees for borrowed fantasy books. The late fee is determined by multiplying the number of days a book is late by 0.50.



Write a program that takes input for a borrowed fantasy book's title, author, and days late. The program should then calculate and display the late fee.

Input format :
The first line of input consists of a string, representing the title of the book.

The second line consists of a string, representing the author of the book.

The third line consists of an integer, representing the number of days the book is late.

Output format :
The output prints a double value, representing the late fee for the book.



Refer to the sample output for formatting specifications.

Code constraints :
The length of the book title and author's name will be at most 120 characters.

Sample test cases :
Input 1 :
Harry Potter and the Philosopher's Stone
J.K. Rowling
1
Output 1 :
0.5
Input 2 :
The Chronicles of Narnia: The Lion, the Witch and the Wardrobe
C.S. Lewis
5
Output 2 :
2.5
Input 3 :
A Song of Ice and Fire: A Dance with Dragons
George R.R. Martin
20
Output 3 :
10.0

import java.util.Scanner;

class Book {
    private String title;
    private String author;

    // Constructor to initialize title and author
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getter methods for title and author
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

class Fiction extends Book {
    private String genre;

    // Constructor to initialize title, author, and default genre
    public Fiction(String title, String author) {
        super(title, author);
        this.genre = "Fantasy"; // Default genre
    }

    // Getter for genre
    public String getGenre() {
        return genre;
    }
}

class Fantasy extends Fiction {
    private int daysLate;

    // Constructor to initialize title, author, and days late
    public Fantasy(String title, String author, int daysLate) {
        super(title, author);
        this.daysLate = daysLate;
    }

    // Method to calculate late fee
    public double calculateLateFee() {
        return daysLate * 0.50;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String title = scanner.nextLine();
        String author = scanner.nextLine(); // Author name
        int daysLate = scanner.nextInt(); // Days the book is late

        
        Fantasy fantasyBook = new Fantasy(title, author, daysLate);

        // Calculating late fee
        double lateFee = fantasyBook.calculateLateFee();

        // Output the late fee
        System.out.printf("%.1f\n", lateFee);
    }
}

