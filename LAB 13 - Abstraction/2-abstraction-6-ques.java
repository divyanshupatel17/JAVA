Problem Statement



Rock is developing a real-time multiplayer game where players can communicate with each other through an in-game messaging system. The game features a messaging system with an abstract class Message and a subclass Email for sending in-game emails.



Develop a program to help Rock that solicits user input, capturing information such as sender and recipient addresses, subject, and body of a message. Subsequently, the program presents the collected details back to the user.

Input format :
The first line of input consists of a string, representing the sender's email address.

The second line consists of a string, representing the recipient's email address.

The third line consists of a string, representing the subject of the mail.

The fourth line consists of a string, representing the body of the mail.

Output format :
The output displays the information about the mail in the following format:

"Email Format

From: [sender]

To: [recipient]

Subject: [subject]

Body: [body]

Email sent!"



Refer to the sample output for formatting specifications.

Code constraints :
The maximum length of the string is 1000.

Sample test cases :
Input 1 :
JohnDoe
JaneSmith
Greetings
Hello Jane, how are you?
Output 1 :
Email Format
From: JohnDoe
To: JaneSmith
Subject: Greetings
Body: Hello Jane, how are you?
Email sent!
Input 2 :
Organizer
Players
Game Tomorrow
Friendly reminder about our Game tomorrow at 2 PM!
Output 2 :
Email Format
From: Organizer
To: Players
Subject: Game Tomorrow
Body: Friendly reminder about our Game tomorrow at 2 PM!
Email sent!

abstract class Message {
    String sender;
    String recipient;
    String subject;
    String body;

    Message(String sender, String recipient, String subject, String body) {
        this.sender = sender;
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
    }

    abstract void displayMessage();
}

class Email extends Message {
    Email(String sender, String recipient, String subject, String body) {
        super(sender, recipient, subject, body);
    }

    @Override
    void displayMessage() {
        System.out.println("Email Format");
        System.out.println("From: " + sender);
        System.out.println("To: " + recipient);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
        System.out.println("Email sent!");
    }
}

class MessagingSystem {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        String sender = scanner.nextLine();
        String recipient = scanner.nextLine();
        String subject = scanner.nextLine();
        String body = scanner.nextLine();

        Email email = new Email(sender, recipient, subject, body);
        email.displayMessage();
    }
}




2.

Problem Statement



In an educational institution, the administration streamlines the process of calculating students' CGPA. They want to create a program that takes into account the credit points and grade points for each subject, allowing students to easily calculate their CGPA.



The program consists of an abstract class GradeCalculator with an abstract method calculateGradePoints(), and a class Subject representing each academic subject. 



Students can input the number of subjects, along with their respective credit scores and grade points. The program then calculates the CGPA based on the total credit scores and grade points.



Note: To calculate the CGPA, calculate the grade points for the subject by multiplying credits by grade points. Divide the total grade points by the total credits.

Input format :
The first line of input consists of an integer N, representing the number of subjects.

The next N lines consist of two space-separated values representing credit score(an integer) and grade points(a double).

Output format :
The output displays a double value, representing the CGPA of the student, rounded off to two decimal places.



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ N ≤ 10

1 ≤ credit score ≤ 10

1.0 ≤ grade points ≤ 10.0

Sample test cases :
Input 1 :
3
3 8.5
2 7.0
4 9.0
Output 1 :
CGPA: 8.39
Input 2 :
4
3 7.5
2 8.0
4 9.5
1 6.0
Output 2 :
CGPA: 8.25
'
import java.util.Scanner;

abstract class GradeCalculator {
    abstract double calculateGradePoints(int credit, double gradePoint);
}

class Subject extends GradeCalculator {
    int credit;
    double gradePoint;

    Subject(int credit, double gradePoint) {
        this.credit = credit;
        this.gradePoint = gradePoint;
    }

    @Override
    double calculateGradePoints(int credit, double gradePoint) {
        return credit * gradePoint;
    }

    double getCredit() {
        return credit;
    }
}
class CGPACalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(); // Number of subjects
        double totalGradePoints = 0;
        int totalCredits = 0;

        for (int i = 0; i < n; i++) {
            int credit = scanner.nextInt();  // Credit score
            double gradePoint = scanner.nextDouble(); // Grade points
            Subject subject = new Subject(credit, gradePoint);
            totalGradePoints += subject.calculateGradePoints(credit, gradePoint);
            totalCredits += subject.getCredit();
        }

        double cgpa = totalGradePoints / totalCredits; // Calculate CGPA
        System.out.printf("CGPA: %.2f%n", cgpa); // Output CGPA rounded to 2 decimal places
    }
}

3.
Problem Statement



Jessica is tasked with designing a fantasy game character system. The system includes an abstract class named GameCharacter with two abstract methods: attack() and defend(). 



Two subclasses, Warrior and Wizard, extend the GameCharacter class. 



The program prompts the player to choose a character class (1. Warrior, 2. Wizard) and input their character's strength or magic power. The dynamic calculations involve tripling the strength (strength * 3) for the Warrior's attack and doubling the magic power(power * 2) for the Wizard's attack.



Jessica needs your help in completing the program. Help her finish it.

Input format :
The first line of input consists of an integer, representing the choice of the character - 1 for Warrior and 2 for Wizard.

If the choice is 1, the second line consists of an integer N, representing the strength.

If the choice is 2, the second line consists of an integer M, representing the magic power.

Output format :
If the choice is 1, the output displays the actions of a warrior in the following format:

"Warrior Actions:

Attack: Powerful sword slash for [result] damage!

Defend: Raises shield, defence boosted by [N]!"



If the choice is 2, the output displays the actions of a wizard in the following format:

"Wizard Actions:

Attack: Casts spell, deals [result] magical damage!

Defend: Creates magical barrier, defence boosted by [M]!"



If any other choice is given, print "Invalid choice".



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ M, N ≤ 106

Sample test cases :
Input 1 :
1
68
Output 1 :
Warrior Actions:
Attack: Powerful sword slash for 204 damage!
Defend: Raises shield, defence boosted by 68!
Input 2 :
2
998
Output 2 :
Wizard Actions:
Attack: Casts spell, deals 1996 magical damage!
Defend: Creates magical barrier, defence boosted by 998!
Input 3 :
3
76
Output 3 :
Invalid choice

import java.util.Scanner;

abstract class GameCharacter {
    abstract void attack();
    abstract void defend();
}

class Warrior extends GameCharacter {
    private int strength;

    Warrior(int strength) {
        this.strength = strength;
    }

    @Override
    void attack() {
        int damage = strength * 3;
        System.out.println("Warrior Actions:");
        System.out.println("Attack: Powerful sword slash for " + damage + " damage!");
    }

    @Override
    void defend() {
        System.out.println("Defend: Raises shield, defence boosted by " + strength + "!");
    }
}

class Wizard extends GameCharacter {
    private int magicPower;

    Wizard(int magicPower) {
        this.magicPower = magicPower;
    }

    @Override
    void attack() {
        int magicalDamage = magicPower * 2;
        System.out.println("Wizard Actions:");
        System.out.println("Attack: Casts spell, deals " + magicalDamage + " magical damage!");
    }

    @Override
    void defend() {
        System.out.println("Defend: Creates magical barrier, defence boosted by " + magicPower + "!");
    }
}
class FantasyGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice == 1) {
            int strength = scanner.nextInt();
            Warrior warrior = new Warrior(strength);
            warrior.attack();
            warrior.defend();
        } else if (choice == 2) {
            int magicPower = scanner.nextInt();
            Wizard wizard = new Wizard(magicPower);
            wizard.attack();
            wizard.defend();
        } else {
            System.out.println("Invalid choice");
        }

        scanner.close();
    }
}



4.

Problem Statement



Imagine Maria is developing a game, where it involves collecting resources on each planet, and the availability of resources is modelled using a geometric progression. 



Create an abstract class Series with an abstract method nextTerm(). Implement a subclass called GeometricSeries that calculates the next term in a geometric progression for the resource collection on planets. Allow players to input the initial resource level, resource growth ratio, and the number of planets they plan to explore. 



Display the predicted resource levels on each planet.

Input format :
The first line of input consists of a single positive integer, representing the initial resource level.

The second line consists of a single positive integer, representing the growth ratio.

The third line consists of a single positive integer, representing the number of planets.

Output format :
The output displays the resource levels of each planet, separated by space.



Refer to the sample output for formatting specifications.

Code constraints :
In this scenario, the test cases fall under the following constraints:

1 ≤ resource ≤ 10

1 ≤ growth rate ≤ 10

1 ≤ number of planets ≤ 8

Sample test cases :
Input 1 :
2
3
5
Output 1 :
2 6 18 54 162 
Input 2 :
5
3
6
Output 2 :
5 15 45 135 405 1215 
Input 3 :
2
9
8
Output 3 :
2 18 162 1458 13122 118098 1062882 9565938   


// Header Snippet  

import java.util.Scanner;
abstract class Series { 
    
// Fill your code here ... 

    abstract int nextTerm();
}

class GeometricSeries extends Series {
    private int firstTerm;
    private int commonRatio;
    private int numberOfTerms;
    private int currentTerm;

    GeometricSeries(int firstTerm, int commonRatio, int numberOfTerms) {
        this.firstTerm = firstTerm;
        this.commonRatio = commonRatio;
        this.numberOfTerms = numberOfTerms;
        this.currentTerm = firstTerm;
    }

    int nextTerm() {
        int term = currentTerm;
        currentTerm *= commonRatio;
        return term;
    }
}


// Footer Snippet 

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstTerm = scanner.nextInt();
        int commonRatio = scanner.nextInt();
        int numberOfTerms = scanner.nextInt();
        GeometricSeries geometricSeries = new GeometricSeries(firstTerm, commonRatio, numberOfTerms);
        for (int i = 0; i < numberOfTerms; i++) {
            System.out.print(geometricSeries.nextTerm() + " ");
        }

        scanner.close();
    }
}

5.
Problem Statement



Imagine Maria is developing a game, where it involves collecting resources on each planet, and the availability of resources is modelled using a geometric progression. 



Create an abstract class Series with an abstract method nextTerm(). Implement a subclass called GeometricSeries that calculates the next term in a geometric progression for the resource collection on planets. Allow players to input the initial resource level, resource growth ratio, and the number of planets they plan to explore. 



Display the predicted resource levels on each planet.

Input format :
The first line of input consists of an integer, representing the initial resource level.

The second line consists of an integer, representing the growth ratio.

The third line consists of an integer, representing the number of planets.

Output format :
The output displays the predicted resource levels of each planet, separated by space.



Refer to the sample output for formatting specifications.

Code constraints :
In this scenario, the test cases fall under the following constraints:

1 ≤ resource ≤ 10

1 ≤ growth ratio ≤ 10

1 ≤ number of planets ≤ 8

Sample test cases :
Input 1 :
2
3
5
Output 1 :
2 6 18 54 162 
Input 2 :
5
2
3
Output 2 :
5 10 20 

import java.util.Scanner;

abstract class Series {
    abstract int nextTerm();
}

class GeometricSeries extends Series {
    int resource;
    int growthRatio;
    int count;

    GeometricSeries(int resource, int growthRatio, int count) {
        this.resource = resource;
        this.growthRatio = growthRatio;
        this.count = count;
    }

    int nextTerm() {
        return resource * growthRatio;
    }

    void displayResources() {
        for (int i = 0; i < count; i++) {
            System.out.print(resource + " ");
            resource = nextTerm();
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initialResource = scanner.nextInt();
        int growthRatio = scanner.nextInt();
        int numberOfPlanets = scanner.nextInt();
        
        GeometricSeries series = new GeometricSeries(initialResource, growthRatio, numberOfPlanets);
        series.displayResources();
    }
}


6.
Problem Statement



Create an abstract class Shape with the following methods:

abstract void rectangleArea();
abstract void squareArea();
abstract void circleArea();


Create a class Area that extends Shape and calculates and prints all the areas. Then create a Main class, get the inputs, and pass them to the methods.



Formula:

Rectangle Area: Area = length * breadth
Square Area: Area = side * side
Circle Area: Area = π * radius2
For the π value, use Math.PI from the math package.

Input format :
The first line of input consists of two space-separated integers, representing the length and breadth of the rectangle.

The second line consists of an integer, representing the side of the square.

The third line consists of an integer, representing the radius of the circle.

Output format :
The first line of output prints the integer, representing the area of a rectangle.

The second line prints the integer, representing the area of a square.

The third line prints a double value, the area of the circle, rounded off to two decimal places.



Refer to the sample output for formatting specifications.

Code constraints :
The given test cases fall under the following constraints:

1 ≤ length and breadth ≤ 100

1 ≤ side ≤ 100

1 ≤ radius ≤ 100

Sample test cases :
Input 1 :
10 20
4
5
Output 1 :
200
16
78.54
Input 2 :
15 9
12
8
Output 2 :
135
144
201.06

import java.util.Scanner;

abstract class Shape {
    abstract void rectangleArea(int length, int breadth);
    abstract void squareArea(int side);
    abstract void circleArea(int radius);
}

class Area extends Shape {
    void rectangleArea(int length, int breadth) {
        int area = length * breadth;
        System.out.println(area);
    }

    void squareArea(int side) {
        int area = side * side;
        System.out.println(area);
    }

    void circleArea(int radius) {
        double area = Math.PI * radius * radius;
        System.out.printf("%.2f\n", area);
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int breadth = scanner.nextInt();
        int side = scanner.nextInt();
        int radius = scanner.nextInt();
        
        Area areaCalculator = new Area();
        areaCalculator.rectangleArea(length, breadth);
        areaCalculator.squareArea(side);
        areaCalculator.circleArea(radius);
    }
}

