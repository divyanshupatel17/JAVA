1..
Problem Statement



Riya is a teacher who is passionate about assessing her students fairly. She is developing a program to calculate the grades of her students based on their test scores. 



Implement a program that models the grade calculation of a student. 



Follow the class hierarchy and details provided below:

Person Class:
Create a class named Person with protected instance variables firstName, lastName, and idNumber.
Create a constructor in the Person class that takes three parameters (firstName, lastName, and idNumber) and initializes the instance variables.
Implement a method named printPerson in the Person class that prints the name and ID of the person.
  Student Class:
Create a class named Student that extends the Person class.
Add a private instance variable testScores, which is an array of integers representing the test scores of the student.
Create a constructor in the Student class that takes four parameters (firstName, lastName, id, and testScores) and calls the constructor of the superclass using the super keyword.
Implement a method named calculate() in the Student class that calculates and returns the grade based on the average of the test scores. 
The grading scale is as follows:
						



Main Class:
In the Main class, use a Scanner to take input for the firstName, lastName, id, and the number of test scores (numScores).
Take input for the test scores and create an object of the Student class using the provided input values.
Invoke the printPerson method on the Student object to print the name and ID of the student.
Invoke the calculate method on the Student object to calculate and print the grade.
Input format :
The first line of input consists of a string representing the first name.

The second line consists of a string representing the last name.

The third line consists of an integer representing the id.

The fourth line consists of the number of test scores.

The fifth line consists of an integer array of test scores, separated by a single space.

Output format :
The output displays the name, ID and grade of the student in separate lines.



Refer to the sample output for formatting specifications.

Code constraints :
0 ≤ test scores ≤ 100

Sample test cases :
Input 1 :
Shruthi
Ramesh
50
5
70 80 90 87 99
Output 1 :
Name: Shruthi Ramesh
ID: 50
Grade: E
Input 2 :
Monica
Geller
51
7
36 35 40 45 49 47 41
Output 2 :
Name: Monica Geller
ID: 51
Grade: D

import java.util.Scanner;

class Person {
    protected String firstName;
    protected String lastName;
    protected int idNumber;

    public Person(String firstName, String lastName, int idNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
    }

    public void printPerson() {
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("ID: " + idNumber);
    }
}

class Student extends Person {
    private int[] testScores;

    public Student(String firstName, String lastName, int idNumber, int[] testScores) {
        super(firstName, lastName, idNumber);
        this.testScores = testScores;
    }

    public char calculate() {
        int sum = 0;
        for (int score : testScores) {
            sum += score;
        }
        int average = sum / testScores.length;

        if (average >= 90) {
            return 'O';
        } else if (average >= 80) {
            return 'E';
        } else if (average >= 70) {
            return 'A';
        } else if (average >= 55) {
            return 'P';
        } else if (average >= 40) {
            return 'D';
        } else {
            return 'T';
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        int id = scanner.nextInt();
        int numScores = scanner.nextInt();
        int[] testScores = new int[numScores];

        for (int i = 0; i < numScores; i++) {
            testScores[i] = scanner.nextInt();
        }

        Student student = new Student(firstName, lastName, id, testScores);

        student.printPerson();
        System.out.println("Grade: " + student.calculate());

        scanner.close();
    }
}


2.
Problem Statement



Bob has been tasked with creating a program to calculate and display the circumference and area of the circle.



The program should allow Bob to input the radius of a circle as both an integer and a double and compute both the circumference and area of the circle using separate overloaded methods:

calculateCircumference- To calculate the circumference using the formula 2 * 3.14 * radius
calculateArea- To calculate the area 3.14 * radius * radius


Write a program to help Bob.

Input format :
The first line of input consists of an integer m, representing the radius of the circle as a whole number.

The second line consists of a double value n, representing the radius of the circle as a decimal number.

Output format :
The first line of output displays two space-separated double values, rounded to two decimal places, representing the circumference of the circle with the integer radius and the double radius, respectively.

The second line displays two space-separated double values, rounded to two decimal places, representing the area of the circle with the integer radius and the double radius, respectively.



Refer to the sample output for formatting specifications.

Code constraints :
In this scenario, the test cases fall under the following constraints:

1 ≤ m ≤ 100

1.00 ≤ n ≤ 100.00

Sample test cases :
Input 1 :
5
3.5
Output 1 :
31.40 21.98
78.50 38.47
Input 2 :
1
1.00
Output 2 :
6.28 6.28
3.14 3.14
Input 3 :
100
100.00
Output 3 :
628.00 628.00
31400.00 31400.00

import java.util.Scanner;

class CircleCalculator {

    public static double calculateCircumference(int radius) {
        return 2 * 3.14 * radius;
    }

    public static double calculateCircumference(double radius) {
        return 2 * 3.14 * radius;
    }

    public static double calculateArea(int radius) {
        return 3.14 * radius * radius;
    }

    public static double calculateArea(double radius) {
        return 3.14 * radius * radius;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        double n = scanner.nextDouble();
        System.out.printf("%.2f %.2f\n", calculateCircumference(m), calculateCircumference(n));
        System.out.printf("%.2f %.2f\n", calculateArea(m), calculateArea(n));
        scanner.close();
    }
}

