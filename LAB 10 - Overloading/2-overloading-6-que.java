1.
Problem Statement



Preethi is working on a project to automate sales tax calculations for items in a store. She wants to create a program that takes the price of an item and the sales tax rate as input and calculates the final price of the item after applying the sales tax. 



Write a program that handles both integer and double inputs using an overloaded method named calculateFinalPrice and print the final price of the item. 



Formula used: Final price = price + ((price * sales tax rate) / 100)

Input format :
The first two lines of input consist of two integers a and b, representing the price of the item and the sales tax rate.

The third and fourth lines consist of two double values m and n, representing the price of the item and the sales tax rate.

Output format :
The first line of output prints an integer, representing the final price of the item after applying the sales tax for integer inputs (a and b).

The second line prints a double value, representing the final price of the item after applying the sales tax for double-value inputs (m and n), rounded to two decimal places.



Refer to the sample output for formatting specifications.

Code constraints :
100 ≤ a ≤ 1000

1 ≤ b ≤ 20

100.0 ≤ m ≤ 1000.0

1.0 ≤ n ≤ 20

Sample test cases :
Input 1 :
100
10
100.0
5.0
Output 1 :
110
105.00
Input 2 :
200
15
205.0
8.5
Output 2 :
230
222.43

import java.util.Scanner;

public class SalesTaxCalculator {

    // Method to calculate final price for integer inputs
    public static int calculateFinalPrice(int price, int taxRate) {
        return price + (price * taxRate) / 100;
    }

    // Method to calculate final price for double inputs
    public static double calculateFinalPrice(double price, double taxRate) {
        return price + (price * taxRate) / 100;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input for integer price and tax rate
        int a = scanner.nextInt();  // price
        int b = scanner.nextInt();  // sales tax rate
        
        // Input for double price and tax rate
        double m = scanner.nextDouble();  // price
        double n = scanner.nextDouble();  // sales tax rate
        
        // Calculate final prices
        int finalPriceInt = calculateFinalPrice(a, b);
        double finalPriceDouble = calculateFinalPrice(m, n);
        
        // Output the results
        System.out.println(finalPriceInt);
        System.out.printf("%.2f%n", finalPriceDouble);
        
        scanner.close();
    }
}

2.
Problem Statement



Hari is working on a Java program for his homework to calculate the sum of two and three integers. 



Write a program that allows Hari to input two integers and three integers separately. Use overloaded methods called sum to calculate and display the sum for each case.

Input format :
The first line of input consists of two space-separated integers m and n.

The second line consists of three space-separated integers a, b and c.

Output format :
The first line of output prints "Sum of two integers: " followed by the sum of m and n.

The second line prints "Sum of three integers: " followed by the sum of a, b and c.



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ input integers ≤ 1000

Sample test cases :
Input 1 :
12 34 
56 78 63
Output 1 :
Sum of two integers: 46
Sum of three integers: 197
Input 2 :
523 178 
481 989 124
Output 2 :
Sum of two integers: 701
Sum of three integers: 1594

import java.util.Scanner;

public class SumCalculator {

    public static int sum(int m, int n) {
        return m + n;
    }

    public static int sum(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int sumOfTwo = sum(m, n);
        int sumOfThree = sum(a, b, c);

        System.out.println("Sum of two integers: " + sumOfTwo);
        System.out.println("Sum of three integers: " + sumOfThree);

        scanner.close();
    }
}


3.
Problem Statement



Hagrid needs a program capable of performing two calculations: square roots and cube roots. 

When he inputs an integer value, the program calculates the square root and displays the result. 
Likewise, if he enters a double, he anticipates the program to compute the cube root and display the outcome. 


Create a program that enables Hagrid to input a number and then see the result of the respective root calculation. Use method overloading with the name calculateRoot() for this and also sqrt() and cbrt() functions from the Java library.

Input format :
The input consists of either an integer n or a double value d, representing the numerical value entered by Hagrid.

Output format :
If the input is an integer, the output displays the square root of n rounded to one decimal place.

If the input is a double value, the output displays the cube root of d rounded to one decimal place.



Refer to the sample output for the formatting specifications.

Sample test cases :
Input 1 :
4
Output 1 :
2.0
Input 2 :
27.0
Output 2 :
3.0
Input 3 :
1000
Output 3 :
31.6
Input 4 :
1000.00
Output 4 :
10.0

// You are using Java
import java.util.Scanner;

class RootCalculator {

    public static double calculateRoot(int n) {
        return Math.sqrt(n);
    }

    public static double calculateRoot(double d) {
        return Math.cbrt(d);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            double result = calculateRoot(n);
            System.out.printf("%.1f%n", result);
        } else if (scanner.hasNextDouble()) {
            double d = scanner.nextDouble();
            double result = calculateRoot(d);
            System.out.printf("%.1f%n", result);
        }
        scanner.close();
    }
}

4.
Problem Statement



Sharon, a software developer, is working on a project to automate velocity calculations for various objects. 



She wants to create a class named VelocityCalculator with overloaded methods calculateVelocity to calculate the velocity. One method will accept distance in meters and time in seconds as integers, while another will accept distance and time as doubles.



Help her in completing the project.



Formula: Velocity = distance/time

Input format :
The first line of input consists of an integer, representing the distance in meters (for the integer method).

The second line consists of an integer, representing the time in seconds (for the integer method).

The third line consists of a double value, representing the distance in meters (for the double method).

The fourth line consists of a double value, representing the time in seconds (for the double method).

Output format :
The first line of output prints the calculated velocity for the integer inputs.

The second line prints the calculated velocity for double inputs, rounded off to two decimal places.



Refer to the sample output for the exact text.

Code constraints :
In this scenario, the test cases fall under the following constraints:

1 ≤ distance ≤ 104

1 ≤ time ≤ 104

Sample test cases :
Input 1 :
100
10
100.5
10.2
Output 1 :
Velocity with integer inputs: 10 m/s
Velocity with double inputs: 9.85 m/s
Input 2 :
500
30
300.5
25.2
Output 2 :
Velocity with integer inputs: 16 m/s
Velocity with double inputs: 11.92 m/s
Input 3 :
10000
3600
876.5
3600.7
Output 3 :
Velocity with integer inputs: 2 m/s
Velocity with double inputs: 0.24 m/s

import java.util.Scanner;
import java.util.Scanner;
class VelocityCalculator {
    public int calculateVelocity(int distance, int time) {
        return distance / time;
    }

    public double calculateVelocity(double distance, double time) {
        return distance / time;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int distanceInt = scanner.nextInt();
        int timeInt = scanner.nextInt();
        double distanceDouble = scanner.nextDouble();
        double timeDouble = scanner.nextDouble();

        VelocityCalculator calculator = new VelocityCalculator();

        int velocityInt = calculator.calculateVelocity(distanceInt, timeInt);
        double velocityDouble = calculator.calculateVelocity(distanceDouble, timeDouble);

        System.out.println("Velocity with integer inputs: " + velocityInt + " m/s");
        System.out.printf("Velocity with double inputs: %.2f m/s\n", velocityDouble);
    }
}

5.
Problem Statement



Rubia wants to develop a program that calculates a person's age in days based on their age in years. Write a program that has two overloaded methods convertToDays() to handle integer and double value inputs and convert the ages to days to help Rubia. 



The program should accept user input for age in years, perform the calculations by multiplying the integer age by 365 and multiplying the double value age by 365.25, and display both results as integers.

Input format :
The first line of input consists of an integer m, representing a person's age in years as a whole number.

The second line consists of a double value n, representing a person s age in years as a decimal number.

Output format :
The first line of output displays "m years is approximately X days." where m is the integer age and X is its approximate equivalent in days as an integer.

The second line displays "n years is approximately Y days." where n is the double value age and Y is its approximate equivalent in days as an integer.



Refer to the sample output for formatting specifications.

Code constraints :
In this scenario, the test cases fall under the following constraints:

1 ≤ m ≤ 100

1.0 ≤ n ≤ 100.0

Sample test cases :
Input 1 :
30
30.5
Output 1 :
30 years is approximately 10950 days.
30.5 years is approximately 11140 days.
Input 2 :
1
1.0
Output 2 :
1 years is approximately 365 days.
1.0 years is approximately 365 days.
Input 3 :
100
100.0
Output 3 :
100 years is approximately 36500 days.
100.0 years is approximately 36525 days.

import java.util.Scanner;
class AgeCalculator {

    public static int convertToDays(int age) {
        return age * 365;
    }

    public static int convertToDays(double age) {
        return (int) (age * 365.25);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ageInt = scanner.nextInt();
        double ageDouble = scanner.nextDouble();

        int daysInt = convertToDays(ageInt);
        int daysDouble = convertToDays(ageDouble);

        System.out.println(ageInt + " years is approximately " + daysInt + " days.");
        System.out.println(ageDouble + " years is approximately " + daysDouble + " days.");

        scanner.close();
    }
}

6.
Problem Statement



You are tasked with designing a Travel class featuring overloaded calculateTime methods, enabling users to calculate travel time based on either the distance and speed they plan to travel or the number of stops they intend to make and the average duration of each stop. 



Calculate the time taken for both approaches and display the results.



For distance and speed input, time = distance/speed.

For number of stops and average duration, time = stops * (avg duration / 60.0)

Input format :
The first line of input consists of a double-point number representing the distance.

The second line consists of a double-point number representing the speed.

The third line consists of an integer representing the number of stops.

The fourth line consists of a double-point number representing the average stop duration.

Output format :
The first line of output displays a double-point number representing the travel time by distance and speed, rounded to one decimal place.

The second line displays a double-point number representing the travel time by number of stops and average stop duration, rounded to one decimal place.



﻿Refer to the sample output for the formatting specifications.

Code constraints :
In this scenario, the test cases fall under the following constraints:

1.0 ≤ distance ≤ 1000.0

0.0 ≤ speed ≤ 1000.0

1 ≤ number of stops ≤ 100

1.0 ≤ average stop duration ≤ 3600.0

Sample test cases :
Input 1 :
50.0
10.0
1
30.0
Output 1 :
5.0
0.5
Input 2 :
100.0
100.0
100
100.0
Output 2 :
1.0
166.7
Input 3 :
900.0
400.0
1
45.0
Output 3 :
2.3
0.8
import java.util.Scanner;
class Travel {

    // Method to calculate travel time based on distance and speed
    public static double calculateTime(double distance, double speed) {
        if (speed == 0) return 0.0;  // Handle speed 0 case
        return distance / speed;
    }

    // Method to calculate travel time based on number of stops and average stop duration
    public static double calculateTime(int stops, double avgDuration) {
        return stops * (avgDuration / 60.0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double distance = scanner.nextDouble();
        double speed = scanner.nextDouble();
        int stops = scanner.nextInt();
        double avgDuration = scanner.nextDouble();

        double timeByDistance = calculateTime(distance, speed);
        double timeByStops = calculateTime(stops, avgDuration);

        System.out.printf("%.1f%n", timeByDistance);
        System.out.printf("%.1f%n", timeByStops);

        scanner.close();
    }
}


