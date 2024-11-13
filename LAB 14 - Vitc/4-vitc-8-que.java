1.
Single File Programming Question
Problem Statement



Create a Java program to check whether a given set of side lengths forms a valid triangle.



The program takes three integers as input, representing the lengths of the sides, and uses the isValidTriangle method to determine if its a valid triangle. 



It also handles the IllegalArgumentException when side lengths are non-positive.

Input format :
The input consists of three lines, each containing a single integer representing the length of each side of a triangle.

Output format :
The program prints one of the following outputs:

If the side lengths can form a valid triangle according to the triangle inequality theorem, it prints, "It's a valid triangle."
If the side lengths do not form a valid triangle, it prints "It's not a valid triangle."
If any of the side lengths are non-positive (<= 0), it throws an IllegalArgumentException and prints "IllegalArgumentException: Side lengths must be positive."


Refer to the sample output for formatting specifications.

Code constraints :
The program accepts only integers as input for the side lengths.

Side lengths must be positive integers (side1 > 0, side2 > 0, side3 > 0) to form a valid triangle.

Sample test cases :
Input 1 :
3
4
5
Output 1 :
It's a valid triangle.
Input 2 :
1
1
3
Output 2 :
It's not a valid triangle.
Input 3 :
4
-5
6
Output 3 :
IllegalArgumentException: Side lengths must be positive.
Whitelist
Set 1:
IllegalArgumentException
Set 2:
try
catch

import java.util.*;

class Main {
    
    public static String isValid(int a,int b,int c){
        if(a<=0 || b<=0 || c<=0){
            throw new IllegalArgumentException("Side lengths must be positive.");
        }
        if(a+b>c && b+c>a && c+a>b){
            return "It's a valid triangle.";
        } else {
            return "It's not a valid triangle.";
        }
    }
    
    public static void main(String[] args){
        
        try {
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            String Result = isValid(a,b,c);
            System.out.println(Result);
        } catch (IllegalArgumentException e){
            System.out.println("IllegalArgumentException: "+e.getMessage());
        }
    }
    
}

2.
Problem Statement



Jane is working on a Java program that involves the use of the postfix and prefix increment operators.  She wants to make sure that her program can handle cases where the operand is not an integer by throwing NumberFormatException and providing an appropriate error message to the user.



Write a program to help her.

Input format :
The input consists of an integer.

Output format :
The first line of output consists of the value of the postfix increment.

The second line of output consists of the value of the prefix increment.

If invalid input is given, throw the error message: "Invalid input! Please enter an integer."



Refer to the sample output for formatting specifications.

Sample test cases :
Input 1 :
5
Output 1 :
Postfix increment: 5
Prefix increment: 7
Input 2 :
6.3
Output 2 :
Invalid input! Please enter an integer.
Input 3 :
Q
Output 3 :
Invalid input! Please enter an integer.
Input 4 :
@
Output 4 :
Invalid input! Please enter an integer.

Whitelist
Set 1:
try
catch
Set 2:
NumberFormatException

// You are using Java
import java.util.*;

class Main {
    public static void main(String[] args){
     
            try {
                Scanner sc = new Scanner(System.in);
                // int n = sc.nextInt();   -> wrong
                // if(!sc.hasNextInt()){   -> correct
                //     throw new NumberFormatException();
                // }
                String ip = sc.nextLine();
                int n = Integer.parseInt(ip);
                int postInt = n++;
                int preInt = ++n;
                System.out.println("Postfix increment: "+postInt);
                System.out.println("Prefix increment: "+preInt);
            } catch(NumberFormatException e) {
                System.out.println("Invalid input! Please enter an integer.");
            }
  
    }
}

3.
Problem Statement



Arun is tasked with creating a program that allows a user to input the size of an array and then input the elements of the array. Find and display the element at the given index. The program should handle the possibility of an invalid array index input and report any errors.



Use try-catch blocks to handle potential exceptions: If the user enters an index that is out of bounds (greater or less than the array size), catch and handle the ArrayIndexOutOfBoundsException.



Assist Arun in implementing this program.

Input format :
The first line of input consists of an integer N, representing the number of elements in the array.

The second line consists of N space-separated integers, representing the array elements.

The third line consists of an integer M, representing the index(0-indexed).

Output format :
The output prints the element at the specified index.

If an exception occurs, print the error message "Error: Array index out of bounds".



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ N ≤ 10

1 ≤ array elements ≤ 100

Sample test cases :
Input 1 :
5
12 23 45 56 89
4
Output 1 :
Element at index 4: 89
Input 2 :
3
45 85 67
0
Output 2 :
Element at index 0: 45
Input 3 :
6
41 56 94 73 61 54
9
Output 3 :
Error: Array index out of bounds
Input 4 :
6
34 78 52 98 61 79
-5
Output 4 :
Error: Array index out of bounds
Note : 

Whitelist
Set 1:
try
catch
ArrayIndexOutOfBoundsException

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }
        
        try {
            int idx = sc.nextInt();
            if(idx >= n || idx < 0) {
                throw new ArrayIndexOutOfBoundsException("Error: Array index out of bounds");
            } else {
                System.out.print("Element at index "+idx+": "+arr[idx]);
            }    
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        
        sc.close();
        
    }
}

4.
Problem Statement:



Samantha is a software developer tasked with creating a Java program to perform arithmetic operations on two operands, including the modulus operator. 



She is concerned about the possibility of the second operand being zero, which would cause an exception in the program. To ensure that her program can handle such cases and provide the appropriate error message to the user, she decides to implement exception handling in her code. 



She also wants to make sure that the program can handle cases where the input operands are not integers, and provide an appropriate error message to the user. 



Samantha wants to create a robust program that can perform the modulus operation on valid input and handle any errors that may arise. Help her with the program.



Note: Use NumberFormatException and ArithmeticException

Input format :
The input consists of two operands.

Output format :
The output prints the result of the modulo.

If invalid inputs are given, print the appropriate exceptions.



Refer to the sample output for formatting specifications.

Sample test cases :
Input 1 :
7
3
Output 1 :
Result: 1
Input 2 :
60
0
Output 2 :
Cannot divide by zero. Please enter a non-zero second operand.
Input 3 :
5
five
Output 3 :
Invalid input! Please enter integers.
Note :


image
Whitelist
Set 1:
try
catch
NumberFormatException
ArithmeticException


import java.util.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        try {
            String a = sc.nextLine();
            String b = sc.nextLine();
            
            int x = Integer.parseInt(a);
            int y = Integer.parseInt(b);
            
            System.out.println("Result: "+x%y);
            
        } catch(ArithmeticException  e){
            System.out.println("Cannot divide by zero. Please enter a non-zero second operand.");
        } catch(NumberFormatException e){
            System.out.println("Invalid input! Please enter integers.");
        }
        
    }
}

5.
Problem Statement



Sara is assigned to develop a program for basic arithmetic operations. The program should accept two numeric inputs and an operation symbol (+, -, *, /) to perform the corresponding operation. 



Utilize a multi-catch block to address the following scenarios:

If the numeric inputs are not valid doubles, catch NumberFormatException and print "Invalid number format: " followed by the built-in exception message.
If there is an attempt to divide by zero, catch ArithmeticException and print "Arithmetic exception: Cannot divide by zero.".
If the operation symbol is not a valid character, catch StringIndexOutOfBoundsException and print "Invalid operation input: Invalid operation: [symbol]".
Perform the specified operation and print the result with one decimal place.


Help Sara to complete the program.

Input format :
The input consists of two double values, representing the numeric inputs.

The third line of input consists of the operation symbol.

Output format :
If the input is valid the output prints "Result: " followed by a double value, representing the result of the operation.

If the input is a string, the output prints "Invalid number format: For input string: " followed by the entered string.

If the user tries to divide the double value by 0, the output prints "Arithmetic exception: Cannot divide by zero."

If the operation is invalid, the output prints "Invalid operation input: Invalid operation: " followed by the operation.



Refer to the sample output for formatting specifications.

Sample test cases :
Input 1 :
5.3
2.6
+
Output 1 :
Result: 7.9
Input 2 :
abc
3.2
*
Output 2 :
Invalid number format: For input string: "abc"
Input 3 :
10.7
0
/
Output 3 :
Arithmetic exception: Cannot divide by zero.
Input 4 :
7.8
4.4
@
Output 4 :
Invalid operation input: Invalid operation: @
Note :

Set 1:
catch
try
NumberFormatException
StringIndexOutOfBoundsException
ArithmeticException

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            // Reading the first and second numbers
            String firstInput = sc.nextLine();
            String secondInput = sc.nextLine();
            
            // Converting inputs to double
            double num1 = Double.parseDouble(firstInput);
            double num2 = Double.parseDouble(secondInput);
            
            // Reading the operation symbol
            char operation = sc.nextLine().charAt(0);
            
            // Performing the operation based on the symbol
            double result = 0;
            switch (operation) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    // Check for division by zero
                    if (num2 == 0) {
                        throw new ArithmeticException();
                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new StringIndexOutOfBoundsException(String.valueOf(operation));
            }
            
            // Printing the result formatted to one decimal place
            System.out.printf("Result: %.1f%n", result);
        
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic exception: Cannot divide by zero.");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Invalid operation input: Invalid operation: " + e.getMessage());
        }
        
        sc.close();
    }
}



6.
Problem Statement



Ashok wants to determine if a given integer is an Armstrong number. He requires your help in implementing a multi-catch block to handle potential issues during user input or calculation.



Create a method isArmstrongNumber that takes an integer input and returns true if it is an Armstrong number, and false otherwise. Throw an IllegalArgumentException if the input is negative.
In the main method, input an integer.
Utilize a multi-catch block to handle the following scenarios:
If the input is negative, catch IllegalArgumentException and print "Error: Input number must be non-negative"
If the input is not a valid integer, catch inputMismatchException and print "Error: Input must be a valid integer."
Finally, print the result.


Assist Ashok in this task.

Input format :
The input consists of an integer N.

Output format :
If N is an Armstrong number, print "N is Armstrong number."

If it is not an Armstrong number, print "N is not Armstrong number."

If N < 0, print "Error: Input number must be non-negative"

If N is other than an integer value, print "Error: Input must be a valid integer."



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ valid input value ≤ 104

Sample test cases :
Input 1 :
153
Output 1 :
153 is Armstrong number.
Input 2 :
745
Output 2 :
745 is not Armstrong number.
Input 3 :
-9
Output 3 :
Error: Input number must be non-negative
Input 4 :
@34
Output 4 :
Error: Input must be a valid integer.
Note :

Whitelist
Set 1:
catch
try

import java.util.*;

class Main {
    public static boolean isArmstrong(int num){
        int digits = String.valueOf(num).length();
        int original = num;
        int sum = 0;
        while(num != 0){
            int d = num%10;
            sum += Math.pow(d,digits);
            num /= 10;
        }
        return sum == original;
    }
    
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        try {
            int num = sc.nextInt();
            if(num<0){
                throw new IllegalArgumentException();
            }
            
            if(isArmstrong(num)){
                System.out.println(num+ " is Armstrong number.");
            } else {
                System.out.println(num+ " is not Armstrong number.");
            }
        } catch(InputMismatchException e){
            System.out.println("Error: Input must be a valid integer.");
        } catch(IllegalArgumentException e){
            System.out.println("Error: Input number must be non-negative");
        }
    
    }
}

7.
Problem Statement



Sampad wants to implement a program that takes input for a student's name and grade, validates the input, and then displays the grade for the given student.



The grade should be an integer value.
The program should validate the grade using the validateGrade() method. The method should throw an IllegalArgumentException if the grade is less than 0 or greater than 100.
If the input is invalid due to a non-integer grade, catch the NumberFormatException and print the built-in exception message.
If the input is invalid due to an out-of-range grade, catch the IllegalArgumentException and print the built-in exception message.
Catch the exceptions using the multi-catch block.


Assist Sampad to implement this program.

Input format :
The first line of input consists of a string, representing the student's name.

The second line consists of an integer, representing the student's grade.

Output format :
If the input is valid and the grade is within the allowed range, print "Grade for [student name]: [grade]".

If there is an exception related to invalid input, print "Invalid input: " followed by the built-in exception message.

If the grade is outside the allowed range, print "Invalid grade: " followed by the built-in exception message.



Refer to the sample output for formatting specifications.

Code constraints :
length of input string ≤ 10

Sample test cases :
Input 1 :
Alice
85
Output 1 :
Grade for Alice: 85
Input 2 :
Bob
abc
Output 2 :
Invalid input: For input string: "abc"
Input 3 :
Eve
120
Output 3 :
Invalid grade: Invalid grade: 120
Input 4 :
John
-5
Output 4 :
Invalid grade: Invalid grade: -5
Note :

Whitelist
Set 1:
catch

import java.util.*;

class ABC {
    String name;
    String stGrade;
    int grade;
    boolean validateGrade(int grade) throws IllegalArgumentException {
        if(grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Invalid grade: "+grade);
        } else {
            return true;
        }
    }
    
    void input(){
        Scanner sc = new Scanner(System.in);
        
        try {
            name = sc.nextLine();
            stGrade = sc.nextLine();
            grade = Integer.parseInt(stGrade);
            if(validateGrade(grade)){
                System.out.println("Grade for "+name+ ": "+grade);
            } 
        } catch(NumberFormatException e){
            System.out.println("Invalid input: "+e.getMessage());
        } catch(IllegalArgumentException e){
            System.out.println("Invalid grade: "+e.getMessage());
        }
    }
}

class Main {
    public static void main(String[] args){
        ABC obj = new ABC();
        obj.input();
        
    }
}


8.
Problem Statement



Rohit is tasked with creating a program that solves a quadratic equation of the form ax2 + bx + c. The program should accept user input for the coefficients a, b and c, and throw an exception if the discriminant is negative.



Implement a method solveQuadraticEquation that takes the coefficients as parameters and calculates the roots of the quadratic equation.
Throw an IllegalArgumentException with the message "Error: Discriminant is negative. The equation has no real roots." if the discriminant is negative.
In the main method, catch and handle any IllegalArgumentException thrown by the solveQuadraticEquation method.


Assist Rohit in this task.

Input format :
The input consists of three space-separated double values, representing the coefficients of a, b, and c respectively.

Output format :
The first line of output prints a double value, representing the root 1, rounded off to one decimal place.

The second line prints a double value, representing the root 2, rounded off to one decimal place.

If the discriminant is negative, print "Error: Discriminant is negative. The equation has no real roots."



Refer to the sample output for formatting specifications.

Code constraints :
-50.0 ≤ a, b, c ≤ 50.0

Sample test cases :
Input 1 :
1.2 -3.2 2.1
Output 1 :
Root 1: 1.5
Root 2: 1.2
Input 2 :
1.5 2.6 3.9
Output 2 :
Error: Discriminant is negative. The equation has no real roots.
Input 3 :
7.1 6.4 -1.1
Output 3 :
Root 1: 0.1
Root 2: -1.0
Note :

Whitelist
Set 1:
try
catch

import java.util.Scanner;

class QuadraticEquationSolver {
    
    // Method to solve the quadratic equation
    static void solveQuadraticEquation(double a, double b, double c) {
        // Calculate the discriminant
        double discriminant = (b * b) - (4 * a * c);
        
        // Check if the discriminant is negative
        if (discriminant < 0) {
            throw new IllegalArgumentException("Error: Discriminant is negative. The equation has no real roots.");
        } else {
            // Calculate the two roots
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            
            // Print the roots rounded to one decimal place
            System.out.printf("Root 1: %.1f\n", root1);
            System.out.printf("Root 2: %.1f\n", root2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the coefficients a, b, and c
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        try {
            // Call the solveQuadraticEquation method
            solveQuadraticEquation(a, b, c);
        } catch (IllegalArgumentException e) {
            // Catch and print the exception message
            System.out.println(e.getMessage());
        }
    }
}


