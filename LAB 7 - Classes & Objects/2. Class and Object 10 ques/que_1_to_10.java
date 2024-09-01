/*
1. Problem Statement
Riya is working on a new feature for her application that requires counting the number of digits in a user-provided number. She decides to implement this using object-oriented programming principles. 
Assist Riya by creating a class named DigitsOpr. This class should have a method getNum() to get the number input from the main class and a method countDigits() to count the actual number of digits in the given input.

Input format :
The input consists of an integer n.

Output format :
The output prints the total number of digits in the given integer.

Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ n ≤ 1012

Sample test cases :
Input 1 :
12345
Output 1 :
5
Input 2 :
22
Output 2 :
2
*/

import java.util.*;

class DigitsOpr {
    int num;
    public void getNum(){
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        sc.close();
    }
    public int countDigits(){
        int count = 0;
        int temp = num;
        while(temp>0){
            int d = temp%10;
            count++;
            temp /= 10;
        }
        return count;
    }
}

class Main {
    public static void main(String[] args){
        DigitsOpr obj = new DigitsOpr();
        obj.getNum();
        int res = obj.countDigits();
        System.out.println(res);
    }
}

/*
2. Problem Statement



Lisa wants to create a program that can take the lengths of three sides of a triangle a, b and c as input and calculate the area of the triangle if the provided sides can form a valid triangle.



Your task is to create a Triangle class that allows her to calculate this area. The triangle is considered valid if (a+b>c) and (a+c>b) and (b+c>a).



Note:

Area of the triangle = √s*(s−a)*(s−b)*(s−c) where s is the semi-perimeter of the triangle, calculated as s= (a+b+c)/2.0. √ is calculated using the Math.sqrt function.

Input format :
The input consists of three space-separated integers a, b and c representing the lengths of the sides of a triangle.

Output format :
If the sides cannot form a valid triangle, the output displays "Invalid Triangle".

Otherwise, the output displays "Area of the triangle: " followed by a double value representing the area of the triangle, rounded off to one decimal place.



Refer to the sample output for formatting specifications.

Code constraints :
In this scenario, the test cases will fall under the following constraints.

1 ≤ a, b, c ≤ 100

Sample test cases :
Input 1 :
1 2 3
Output 1 :
Invalid Triangle
Input 2 :
100 100 100
Output 2 :
Area of the triangle: 4330.1
Input 3 :
3 4 5
Output 3 :
Area of the triangle: 6.0
 */

import java.util.*;

class Triangle {
    double a,b,c;
    public void getData(){
        Scanner sc = new Scanner(System.in);
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();
    }
    public boolean checkValid(){
        if(a+b>c && b+c>c && a+c>b){
            return true;
        }
        return false;
    }
    public void area(){
        double s = (a+b+c) / 2;
    
        if(checkValid()){
            double res = Math.sqrt(s*(s-a)*(s-b)*(s-c));
            System.out.format("Area of the triangle: %.1f",res);
        } else {
            System.out.println("Invalid Triangle");
        }
    }
}

class Main {
     public static void main(String[] args){
         Triangle obj = new Triangle();
         obj.getData();
         obj.area();
     }
}

/**
 3. Problem Statement



Shakthi wants to develop a program to check the type of alphabet. He wants to implement a CharacterChecker class and a method checkAlphabetType() to determine if a given character is a vowel, consonant or not an alphabet.



Can you help Shakthi by creating the program?

Input format :
The input consists of a single character.

Output format :
The output prints the result indicating whether the character is a vowel, consonant or not an alphabet.



Refer to the sample output for the exact text and format.

Code constraints :
The input is a valid ASCII character.

Sample test cases :
Input 1 :
j
Output 1 :
j: consonant
Input 2 :
E
Output 2 :
E: vowel
Input 3 :
5
Output 3 :
5: not an alphabet
 */

import java.util.*;  

class CharacterChecker {  
    public void checkAlphabetType(char a) {  
        // Check if the character is an alphabet  
        if ((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z')) {  
            // Check if the alphabet is a vowel  
            if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' ||  
                a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U') {  
                System.out.printf("%c: vowel\n", a);  
            } else {  
                // If it's not a vowel, it must be a consonant  
                System.out.printf("%c: consonant\n", a);  
            }  
        } else {  
            // If it's not an alphabet  
            System.out.printf("%c: not an alphabet\n", a);  
        }  
    }  
}  

class MAIN {  
    public static void main(String[] args) {  
        Scanner sc = new Scanner(System.in);  
        char a = sc.nextLine().charAt(0); // Read the single character input  
        CharacterChecker obj = new CharacterChecker();  
        obj.checkAlphabetType(a);  
        sc.close();  
    }  
}

/**
 4. Problem Statement
Ravi is creating a registration system for an event. He needs to write a program that collects the participant's name, age and gender and then prints these details in a specific format with uppercase characters. 

Assist Ravi in creating the program using a class named Participant and use the necessary methods and objects.

Input format :
The input consists of the name, age and gender of a participant.

Output format :
The output prints the details of the participant in the format: "NAME - Age - GENDER". Convert name and gender to uppercase.

Refer to the sample output for formatting specifications.

Code constraints :
The name and gender will be non-empty strings.

Sample test cases :
Input 1 :
Bob
28
Male
Output 1 :
BOB - 28 - MALE
Input 2 :
Shreen
21
Female
Output 2 :
SHREEN - 21 - FEMALE
 */
import java.util.Scanner;

class Participant {
    private String name;
    private int age;
    private String gender;

    // Method to collect participant details
    public void getDetails() {
        Scanner sc = new Scanner(System.in);

        // Get the participant's name
        this.name = sc.nextLine();
        
        // Get the participant's age
        this.age = sc.nextInt();
        sc.nextLine();  // Consume the leftover newline character

        // Get the participant's gender
        this.gender = sc.nextLine();
        
        sc.close();
    }

    // Method to print the participant details in the required format
    public void printDetails() {
        // Convert name and gender to uppercase and print the details
        System.out.println(this.name.toUpperCase() + " - " + this.age + " - " + this.gender.toUpperCase());
    }
}

public class Main {
    public static void main(String[] args) {
        Participant participant = new Participant();
        
        // Get the participant details
        participant.getDetails();
        
        // Print the participant details in the required format
        participant.printDetails();
    }
}

/**
 5.Problem Statement



Alex is working on a number classification project. He needs to write a program that reads a list of integers, classifies them into even and odd numbers and then prints the list.



Help Alex as he wants to use a class and objects to implement this program. The class should be named NumberClassifier.

Input format :
The first line of input consists of an integer n, representing the number of elements in the list.

The second line consists of n space-separated integers, representing the list elements.

Output format :
The first line of output prints "Even numbers:".

The second line prints the even numbers from the given list, separated by a space.

The third line prints "Odd numbers:".

The fourth line prints the odd numbers from the given list, separated by a space.



Refer to the sample output for formatting specifications.

Code constraints :
In this scenario, the test cases fall under the following constraints:

1 ≤ n ≤ 10

1 ≤ element ≤ 1000

Sample test cases :
Input 1 :
5
9 2 11 4 8
Output 1 :
Even numbers:
2 4 8 
Odd numbers:
9 11 
Input 2 :
10
6 2 4 3 7 13 11 10 15 22
Output 2 :
Even numbers:
6 2 4 10 22 
Odd numbers:
3 7 13 11 15 
 */
import java.util.ArrayList;
import java.util.Scanner;

class NumberClassifier {
    private ArrayList<Integer> evenNumbers;
    private ArrayList<Integer> oddNumbers;

    // Constructor to initialize lists
    public NumberClassifier() {
        evenNumbers = new ArrayList<>();
        oddNumbers = new ArrayList<>();
    }

    // Method to classify numbers into even and odd
    public void classifyNumbers(int[] numbers) {
        for (int number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            } else {
                oddNumbers.add(number);
            }
        }
    }

    // Method to print the classified numbers
    public void printNumbers() {
        System.out.println("Even numbers:");
        for (int num : evenNumbers) {
            System.out.print(num + " ");
        }
        System.out.println();  // Move to the next line

        System.out.println("Odd numbers:");
        for (int num : oddNumbers) {
            System.out.print(num + " ");
        }
        System.out.println();  // Move to the next line
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of elements
        int n = sc.nextInt();
        
        // Create an array to hold the numbers
        int[] numbers = new int[n];
        
        // Read the numbers
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        // Create an object of NumberClassifier
        NumberClassifier classifier = new NumberClassifier();
        
        // Classify the numbers
        classifier.classifyNumbers(numbers);
        
        // Print the results
        classifier.printNumbers();
        
        sc.close();
    }
}

/**
 6. Problem Statement



Laura is learning about Pythagorean triples in her math class. She wants to create a program to determine whether a set of three integers forms a Pythagorean triple. Implement a program using the Pythagorean class to input the sides of a triangle and determine if it is a Pythagorean triple or not. 

Input format :
The input consists of three space-separated integers a, b and c representing the sides of a triangle.

Output format :
The output prints "Pythagorean triple" or "Not a Pythagorean triple" based on the inputs.



Refer to the sample output for formatting specifications.

Code constraints :
In this scenario, the test cases fall under the following constraints:

1 ≤ a, b, c ≤ 100

Sample test cases :
Input 1 :
3 4 5
Output 1 :
Pythagorean triple
Input 2 :
1 100 95
Output 2 :
Not a Pythagorean triple
Input 3 :
8 15 17
Output 3 :
Pythagorean triple
 */

import java.util.Scanner;

class Pythagorean {
    
    public static boolean isPythagoreanTriple(int a, int b, int c) {
        // Sort the numbers to ensure that c is the largest
        int[] sides = {a, b, c};
        java.util.Arrays.sort(sides);
        
        return (sides[0] * sides[0]) + (sides[1] * sides[1]) == (sides[2] * sides[2]);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        if (Pythagorean.isPythagoreanTriple(a, b, c)) {
            System.out.println("Pythagorean triple");
        } else {
            System.out.println("Not a Pythagorean triple");
        }
        
        sc.close();
    }
}

/**
 7. Problem Statement



Emily is planning a road trip to a country that uses kilometres per hour (km/h) for speed limits, but she's more familiar with miles per hour (mph). 



T﻿o help her with her trip, she wants to create a SpeedConverter class that holds the choice ('1' for mph to km/h conversion, '2' for km/h to mph conversion) and speed as attributes. The program should convert speeds from miles per hour to km per hour and vice versa.



Note: mph to km/h = speed * 1.60934, km/h to mph = speed / 1.60934 

Input format :
The first line of input consists of an integer representing the choice ('1' for mph to km/h conversion, '2' for km/h to mph conversion).

The second line consists of a double value, representing the speed value.

Output format :
The output displays a double value, representing the converted speed, rounded off to two decimal places.

The output displays "Invalid choice" if the choice is neither 1 nor 2.



Refer to the sample output for formatting specifications.

Code constraints :
1.0 ≤ speed ≤ 250.0

Sample test cases :
Input 1 :
1
60.5
Output 1 :
97.37
Input 2 :
2
200.9
Output 2 :
124.83
Input 3 :
0
131.5
Output 3 :
Invalid choice
 */

import java.util.Scanner;

class SpeedConverter {
    private int choice;  // '1' for mph to km/h, '2' for km/h to mph
    private double speed;

    // Method to get the input details
    public void getDetails() {
        Scanner sc = new Scanner(System.in);

        // Read the conversion choice
        this.choice = sc.nextInt();
        
        // Read the speed value
        this.speed = sc.nextDouble();

        sc.close();
    }

    // Method to convert the speed based on the choice
    public void convertSpeed() {
        if (choice == 1) {
            // Convert mph to km/h
            double convertedSpeed = speed * 1.60934;
            System.out.printf("%.2f\n", convertedSpeed);
        } else if (choice == 2) {
            // Convert km/h to mph
            double convertedSpeed = speed / 1.60934;
            System.out.printf("%.2f\n", convertedSpeed);
        } else {
            // Invalid choice
            System.out.println("Invalid choice");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SpeedConverter converter = new SpeedConverter();
        
        // Get input details
        converter.getDetails();
        
        // Convert and print the result
        converter.convertSpeed();
    }
}

/**
 8. Problem Statement



Arun wants to design a program using a class that calculates and prints both the area and perimeter of a rectangle. 



Define a class named Rectangle to encapsulate the properties and behaviour related to a rectangle. Include two integer variables length and breadth to represent the dimensions of the rectangle. Calculate and print the area and perimeter of the rectangle. 



Help Arun to design the program.

Input format :
The input consists of two space-separated integers, representing the length and breadth of a rectangle.

Output format :
The first line of output prints the area of the rectangle.

The second line prints the perimeter of the rectangle.



Refer to the sample output for the exact text.

Code constraints :
1 ≤ length, breadth ≤ 105

Sample test cases :
Input 1 :
21 53
Output 1 :
Area: 1113
Perimeter: 148
Input 2 :
15 9
Output 2 :
Area: 135
Perimeter: 48
 */
import java.util.Scanner;

class Rectangle {
    private int length;
    private int breadth;

    // Constructor to initialize length and breadth
    public Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    // Method to calculate and return the area of the rectangle
    public int calculateArea() {
        return length * breadth;
    }

    // Method to calculate and return the perimeter of the rectangle
    public int calculatePerimeter() {
        return 2 * (length + breadth);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the length and breadth of the rectangle
        int length = sc.nextInt();
        int breadth = sc.nextInt();

        // Create a Rectangle object
        Rectangle rectangle = new Rectangle(length, breadth);

        // Calculate and print the area
        System.out.println("Area: " + rectangle.calculateArea());

        // Calculate and print the perimeter
        System.out.println("Perimeter: " + rectangle.calculatePerimeter());

        sc.close();
    }
}

/** 
 9. Problem Statement



David is assigned a programming task in his computer science class. 



The task involves creating two classes: a Box class and a Main class. In the Main class, he is required to instantiate an object of the Box class and calculate the volume of the box. 



Help David as he needs your assistance in completing this programming task.

Input format :
The input consists of three space-separated double values, representing the width, height and depth of the box.

Output format :
The output prints a double value, representing the volume of the box, rounded off to two decimal places.



Refer to the sample output for the exact text and format.

Code constraints :
1.1 ≤ width, height, depth ≤ 50.0

Sample test cases :
Input 1 :
7.2 8.3 1.1
Output 1 :
Volume: 65.74
Input 2 :
2.2 1.1 3.2
Output 2 :
Volume: 7.74
 */
import java.util.Scanner;

class Box {
    private double width;
    private double height;
    private double depth;

    // Constructor to initialize the dimensions of the box
    public Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    // Method to calculate the volume of the box
    public double calculateVolume() {
        return width * height * depth;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the width, height, and depth of the box
        double width = sc.nextDouble();
        double height = sc.nextDouble();
        double depth = sc.nextDouble();

        // Create a Box object
        Box box = new Box(width, height, depth);

        // Calculate the volume and print it, rounded to two decimal places
        double volume = box.calculateVolume();
        System.out.printf("Volume: %.2f", volume);

        sc.close();
    }
}

/** 
 10. Problem Statement



Arun wants to create a Java class named Appliance to track the energy consumption of household appliances. Implement methods to input the wattage and daily usage hours, and calculate both daily and monthly energy consumption. Use the main method to create an object of Appliance, gather input from the user, and display the energy consumption, rounded off to 2 decimal places.



Your task is to guide him in the program.



Note: Daily Consumption = (wattage * hours used) / 1000. Assume there are 30 days in a month.

Input format :
The first line of input consists of a double value, representing the wattage.

The second line consists of a double value, representing the hours used per day.

Output format :
The first line of output prints "Daily Consumption: X kWh" where X is a double value, rounded off to two decimal places.

The second line prints "Monthly Consumption: Y kWh" where Y is a double value, rounded off to two decimal places.



Refer to the sample output for formatting specifications.

Code constraints :
In this scenario, the test cases fall under the following constraints:

1.0 ≤ wattage ≤ 5000.0

1.0 ≤ hours ≤ 24.0

Sample test cases :
Input 1 :
1000.50
2.5
Output 1 :
Daily Consumption: 2.50 kWh
Monthly Consumption: 75.04 kWh
Input 2 :
500.75
4.0
Output 2 :
Daily Consumption: 2.00 kWh
Monthly Consumption: 60.09 kWh
 */

import java.util.Scanner;

class Appliance {
    private double wattage;
    private double dailyUsageHours;

    // Method to set the wattage and daily usage hours
    public void setDetails(double wattage, double dailyUsageHours) {
        this.wattage = wattage;
        this.dailyUsageHours = dailyUsageHours;
    }

    // Method to calculate daily energy consumption in kWh
    public double calculateDailyConsumption() {
        return (wattage * dailyUsageHours) / 1000;
    }

    // Method to calculate monthly energy consumption in kWh
    public double calculateMonthlyConsumption() {
        return calculateDailyConsumption() * 30; // Assuming 30 days in a month
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the wattage and daily usage hours
        double wattage = sc.nextDouble();
        double dailyUsageHours = sc.nextDouble();

        // Create an Appliance object and set its details
        Appliance appliance = new Appliance();
        appliance.setDetails(wattage, dailyUsageHours);

        // Calculate daily and monthly consumption
        double dailyConsumption = appliance.calculateDailyConsumption();
        double monthlyConsumption = appliance.calculateMonthlyConsumption();

        // Print the results, rounded to two decimal places
        System.out.printf("Daily Consumption: %.2f kWh%n", dailyConsumption);
        System.out.printf("Monthly Consumption: %.2f kWh%n", monthlyConsumption);

        sc.close();
    }
}
