1.
Problem Statement



Imagine you are building a calculator application that allows users to enter two numbers and get their sum. You want to handle the case where the user enters a non-numeric input by displaying an error message and prompting them to enter valid numbers.



Write a Java program to calculate the sum of two numbers using the addition operator and handle the exceptions.

Input format :
The input consists of two numbers separated by a space.

Output format :
The output prints the sum of the given numbers if the input is valid.

If non-numeric input is given, the output displays an error message, "Invalid input. Please enter valid numbers."



Refer to the sample output for the exact text.

Sample test cases :
Input 1 :
10 20
Output 1 :
The sum is 30
Input 2 :
25 five
Output 2 :
Invalid input. Please enter valid numbers.
Note :

Whitelist
Set 1:
Exception
import java.util.Scanner;

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

class Calculator {
    public static double parseInput(String input) throws InvalidInputException {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Invalid input. Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            double num1 = parseInput(sc.next());
            double num2 = parseInput(sc.next());
            System.out.format("The sum is %d" , ((int)num1 + (int)num2));
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }
}

2.
Problem Statement



Ashok wants to write a program to catch a custom exception for the given input.



He needs your help to complete the program using the given conditions:

The input should be less than 7. If the number is less than 7, print the same number.
If the input is greater than or equal to 7, it should catch the illegal argument exception and print "Input must be less than 7".
If the input is 0, then it should catch the arithmetic exception and print "Cannot divide by zero".


Assist Ashok in completing the program.

Input format :
The input consists of an integer N.

Output format :
If the input is equal to 0, a custom exception is thrown with the message "Caught a custom exception: Cannot divide by zero".

If the input is less than 7, the program prints the value of the input.

If the input is greater than or equal to 7, a custom exception is thrown with the message "Caught a custom exception: Input must be less than 7".



Refer to the sample output for formatting specifications.

Code constraints :
The test cases will fall under the following constraints:

0 ≤ N ≤ 107

Sample test cases :
Input 1 :
5
Output 1 :
5
Input 2 :
8
Output 2 :
Caught a custom exception: Input must be less than 7
Input 3 :
0
Output 3 :
Caught a custom exception: Cannot divide by zero
Input 4 :
7
Output 4 :
Caught a custom exception: Input must be less than 7
Note :Whitelist
Set 1:
try
catch
throw
import java.util.*;

class CustomException extends Exception {
    public CustomException(String message){
        super(message);
    }
}

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n  = sc.nextInt();
        
        try {
            if(n==0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            else if (n>=7){
                throw new CustomException("Input must be less than 7");
            } else {
                System.out.println(n);
            }
        } catch(ArithmeticException | CustomException e){
            System.out.println("Caught a custom exception: "+e.getMessage());
        }
    }
}

3.
Problem Statement



In a user registration system, there is a requirement to implement a username validation module. Users attempting to register must adhere to specific criteria for their usernames to be considered valid. 



Your task is to develop a program that takes user input for a desired username and validates it according to the following rules:

The username must not contain any spaces.
The username must be at least 5 characters long.


Implement a custom exception, InvalidUsernameException, to handle cases where the entered username does not meet the specified criteria.

Input format :
The input consists of a string S, representing the desired username.

Output format :
If the username is valid, print "Username is valid: [S]".

If the username is invalid:

If the username is short, print "Invalid Username: Username must be at least 5 characters long"
If the username contains spaces, print "Invalid Username: Username cannot contain spaces"


Refer to the sample output for formatting specifications.

Code constraints :
length of username ≤ 100

Sample test cases :
Input 1 :
John
Output 1 :
Invalid Username: Username must be at least 5 characters long
Input 2 :
Jane Doe
Output 2 :
Invalid Username: Username cannot contain spaces
Input 3 :
Alice
Output 3 :
Username is valid: Alice
Note :
Whitelist
Set 1:
try
catch
extends
Exception
Set 2:
InvalidUsernameException
import java.util.*;

class InvalidUsernameException extends Exception {
    public InvalidUsernameException(String name){
        super("Invalid Username: "+name);
    }
}

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        try {
            String name = sc.nextLine();
            if(name.length() < 5) throw new InvalidUsernameException("Username must be at least 5 characters long");
            else if(name.indexOf(" ") != -1) throw new InvalidUsernameException("Username cannot contain spaces");
            else System.out.println("Username is valid: "+name);
        } catch(InvalidUsernameException e){
            System.out.println(e.getMessage());
        }
        
    }
}

4.
Problem Statement



Suppose you are building a program that calculates the average grade of a student based on their exam scores.



You want to use the ternary operator to determine whether the student has passed or failed the exam based on their average grade. If the average grade is greater than or equal to 60, the result is a pass. Otherwise, the result is a failure.



However, you want to handle the case where the user enters an invalid input for the exam scores by displaying an error message and prompting them to enter valid input.

Input format :
The input consists of the marks of two subjects separated by a space.

Output format :
The output prints the average grade of the student along with the result.

If invalid input is given, the output prints the error message "Invalid input. Please enter valid exam scores."



Refer to the sample output for the exact text.

Sample test cases :
Input 1 :
90 85
Output 1 :
Your average grade is 87.5. You Passed the exam.
Input 2 :
40 32
Output 2 :
Your average grade is 36.0. You Failed the exam.
Input 3 :
fifty seventy
Output 3 :
Invalid input. Please enter valid exam scores.
Note :
Whitelist
Set 1:
Exception
try
catch
import java.util.Scanner;
class GradeCalculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] scores = scanner.nextLine().split(" ");
            if (scores.length != 2) {
                throw new IllegalArgumentException("Invalid input. Please enter two scores.");
            }
            
            double score1 = Double.parseDouble(scores[0]);
            double score2 = Double.parseDouble(scores[1]);
            double average = (score1 + score2) / 2;
            
            System.out.printf("Your average grade is %.1f. You %s the exam.%n", 
                              average, average >= 60 ? "Passed" : "Failed");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid exam scores.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

5.
Problem Statement



Raghav is tasked with writing a program that allows the user to define the size of an integer array and then input a set of integers. The program should handle the scenario where the user enters more input elements than the specified array size, leading to an ArrayIndexOutOfBoundsException.



Use a try-catch block to handle the situation where the user enters more input elements than the specified array size.
If the user enters more input elements than the array size, throw an ArrayIndexOutOfBoundsException with a custom error message "ArrayIndexOutOfBoundsException: Input elements exceeds array size"
If no exception occurs, print the elements of the array separated by spaces.
Regardless of whether an exception is thrown or not, include a finally block to print "Program executed successfully!".
Input format :
The first line of input consists of a positive integer, N representing the size of an array.

The second line of input consists of N integers separated by space.

Output format :
If the input is valid, the output prints "Array: " followed by N integers representing the entered array and "Program executed successfully!" in a new line.

Otherwise, the output prints "ArrayIndexOutOfBoundsException: Input elements exceeds array size" followed by "Program executed successfully!" in a new line.



Refer to the sample output for formatting specifications.

Code constraints :
In this scenario, the test cases fall under the following constraints:

1 ≤ N ≤ 25

-100 ≤ Array Elements ≤ 100

Sample test cases :
Input 1 :
5
-8 46 73 12 -96
Output 1 :
Array: -8 46 73 12 -96 
Program executed successfully!
Input 2 :
4
-9 8 54 -5 7
Output 2 :
ArrayIndexOutOfBoundsException: Input elements exceeds array size
Program executed successfully!
Note :
Whitelist
Set 1:
catch
try
finally
ArrayIndexOutOfBoundsException
import java.util.Scanner;

class ArrayInputHandler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            int size = scanner.nextInt();
            int[] array = new int[size];
            
            for (int i = 0; i < size; i++) {
                if (!scanner.hasNextInt()) {
                    throw new ArrayIndexOutOfBoundsException("Input elements exceeds array size");
                }
                array[i] = scanner.nextInt();
            }
            
            if (scanner.hasNext()) {
                throw new ArrayIndexOutOfBoundsException("Input elements exceeds array size");
            }
            
            System.out.print("Array: ");
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        } finally {
            System.out.println("Program executed successfully!");
            scanner.close();
        }
    }
}

6.
Problem Statement



Tim is tasked with writing a program that takes an integer input from the user and processes it. If the user enters a negative number, the program should throw a custom exception called NegativeNumberException and provide an appropriate error message. Otherwise, it should double the value of the positive number and display the result.



Use a try-catch block to handle the NegativeNumberException. If the exception is caught, print an error message that includes the exception message.



If no exception occurs, print "Value is Doubled: " followed by the processed result.

Input format :
The input consists of an integer, N.

Output format :
If the input is positive, the output prints "Value is Doubled: " followed by an integer representing the doubled value.

Otherwise, the output prints "Exception occurred: X is negative" where X is an entered integer.



Refer to the sample output for formatting specifications.

Code constraints :
In this scenario, the test cases fall under the following constraints:

-104 ≤ N ≤ 104

Sample test cases :
Input 1 :
7
Output 1 :
Value is Doubled: 14
Input 2 :
-23
Output 2 :
Exception occurred: -23 is negative
Note :
Whitelist
Set 1:
catch
Set 2:
try
Set 3:
NegativeNumberException
import java.util.*;

class NegativeNumberException extends Exception {
    public NegativeNumberException(String msg){
        super(msg);
    }
}

class Main {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        try {
            int n = sc.nextInt();
            if(n<0) throw new NegativeNumberException("Exception occurred: "+n+" is negative");
            
            System.out.println("Value is Doubled: "+n*2);
        } catch(NegativeNumberException e){
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
        
    }
}

7.
Problem Statement



Alice is tasked with creating a program that validates user input for time values (hours, minutes, and seconds). The program should check whether the input values are within the valid range. If any value falls outside the valid range, a custom exception, InvalidHourException, InvalidMinuteException, or InvalidSecondException, should be thrown, indicating which part of the time (hours, minutes, or seconds) is invalid.



If no exceptions occur, print "Correct Time - " followed by the time in the format "hours:minutes:seconds."

Input format :
The first line of input consists of a positive integer, H representing the hours.

The second line of input consists of a positive integer, M representing the minutes.

The third line of input consists of a positive integer, S representing the seconds.

Output format :
If the input is valid, the output prints "Correct Time - HH:MM:SS" where H, M, and S are hours, minutes, and seconds respectively.

If the hour is invalid, the output prints "Exception occurred: InvalidHourException - hour is greater than 24".

If the minute is invalid, the output prints "Exception occurred: InvalidMinuteException - minute is greater than 60".

If the second is invalid, the output prints "Exception occurred: InvalidSecondsException - second is greater than 60".



Refer to the sample output for formatting specifications.

Code constraints :
In this scenario, the test cases fall under the following constraints:

0 ≤ H ≤ 12

0 ≤ M, S ≤ 60

Sample test cases :
Input 1 :
12
30
45
Output 1 :
Correct Time - 12:30:45
Input 2 :
25
15
30
Output 2 :
Exception occurred: InvalidHourException - hour is greater than 24
Input 3 :
22
69
56
Output 3 :
Exception occurred: InvalidMinuteException - minute is greater than 60
Input 4 :
8
56
87
Output 4 :
Exception occurred: InvalidSecondsException - second is greater than 60
Note :

Whitelist
Set 1:
catch
Set 2:
try

import java.util.*;

class InvalidHourException extends Exception {
    public InvalidHourException(String msg){
        super(msg);
    }
}

class InvalidMinuteException extends Exception {
    public InvalidMinuteException(String msg){
        super(msg);
    }
}

class InvalidSecondException extends Exception {
    public InvalidSecondException(String msg){
        super(msg);
    }
}

class Main {
    public static void main(String[] args){
        try {
            Scanner sc = new Scanner(System.in);
            int h = sc.nextInt();
            int m = sc.nextInt();
            int s = sc.nextInt();
            
            if(h < 0 || h > 24) throw new InvalidHourException("Exception occurred: InvalidHourException - hour is greater than 24");
            if(m < 0 || m > 60) throw new InvalidMinuteException("Exception occurred: InvalidMinuteException - minute is greater than 60");
            if(s < 0 || s > 60) throw new InvalidSecondException("Exception occurred: InvalidSecondsException - second is greater than 60");
        
            System.out.format("Correct Time - %02d:%02d:%02d", h, m, s);
        } catch(InvalidHourException e){
            System.out.println(e.getMessage());
        } catch(InvalidMinuteException e){
            System.out.println(e.getMessage());
        } catch(InvalidSecondException e){
            System.out.println(e.getMessage());
        }
    }
}


8.
Problem Statement



Helen is an adventurous explorer on a quest to discover the hidden treasures marked on an ancient enchanted map. To unlock the map's secrets, you need to input two pairs of coordinates (x1, y1) and (x2, y2) as directed by the mystical map.



The enchanted map is guarded by the "Guardian of Arguments," a magical guardian who enforces the map's rules. The correct coordinates reveal the sum of squares leading to the treasure's location. Incorrect inputs warn adventurers.



Prompt the user to enter four integer coordinates separated by spaces in a single line.
Split the input string into an array of arguments and check if exactly four coordinates are provided. If not, throw a custom exception named CheckArgument with the message "Guardian of Arguments awakens!"
If four coordinates are provided, parse them as integers, calculate the sum of the squares of these coordinates, and display the sum of squares as the treasure's secret location.
If an incorrect number of coordinates is provided or if there's an issue with parsing, catch the CheckArgument exception, and display "Be aware!" followed by the exception message.
Use a finally block to close any resources used.
Input format :
The input consists of 4 space-separated integers representing the coordinates (x1, y1) and (x2, y2).

Output format :
If the input is valid, the output prints "Treasure's Secret Location: " followed by an integer representing the location of the treasure.

Otherwise, the output prints "Be aware!

Guardian of Arguments awakens! each in a new line.



Refer to the sample output for formatting specifications.

Code constraints :
In this scenario, the test cases fall under the following constraints:

-98 ≤ x1 y1 x2 y2 ≤ 40

Sample test cases :
Input 1 :
1 -2 -3 4
Output 1 :
Treasure s Secret Location: 30
Input 2 :
25 12 -98
Output 2 :
Be aware!
Guardian of Arguments awakens!
Note :

Whitelist
Set 1:
catch
Set 2:
try

import java.util.*;

class CheckArgument extends Exception {
    public CheckArgument(String msg){
        super(msg);
    }
}

class Main  {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        try {
            String[] arr = sc.nextLine().split(" ");
            if(arr.length != 4) throw new CheckArgument("Guardian of Arguments awakens!");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            int c = Integer.parseInt(arr[2]);
            int d = Integer.parseInt(arr[3]);
            System.out.println("Treasure's Secret Location: "+(a*a + b*b + c*c + d*d));
            
        } catch(CheckArgument e){
            System.out.println("Be aware!\n"+e.getMessage());
        }
    }
}