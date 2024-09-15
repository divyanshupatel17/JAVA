1.
Problem Statement



Rex is tasked with implementing a class that contains a method named nthFibonacci. This method should calculate and return the Nth Fibonacci number. 



Help Rex to complete the method.



Company Tags: Infosys

Input format :
The input consists of a single integer N, to calculate the Nth Fibonacci number.

Output format :
The output prints a long value, representing the Nth Fibonacci number.



﻿Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ N ≤ 50

Sample test cases :
Input 1 :
1
Output 1 :
1
Input 2 :
8
Output 2 :
21
Input 3 :
11
Output 3 :
89

// You are using Java
import java.util.*;

class A {
    public int nthFibonacci(int n){
        if(n<=0){
            return 0;
        } else if(n==1){
            return 1;
        } 
        int num1 = 0, num2 = 1;
        int nthfibnum = 0;
        for(int i=2 ; i<=n ; i++){
            nthfibnum = num1+num2;
            num1 = num2;
            num2 = nthfibnum;
        }
        return nthfibnum;
    }
}

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        A obj = new A();
        int res = obj.nthFibonacci(n);
    
        System.out.println(res);
        sc.close();
    }
}

2.
Problem Statement:



Monica is a software developer working on a project that requires converting numbers between different numeral systems. She needs to implement a function that converts a number from one base to another. 



Monica decides to write a program that includes a parameterized method named convertBase, which takes a number, its current base, and the target base as inputs and returns the number in the target base.

Input format :
The first line of input consists of a String, representing the number in its current base.

The second line of input consists of an integer n, representing the base of the input number.

The third line of input consists of an integer m, representing the base to which the number should be converted.

Output format :
The output displays a String representing the number in the target base.

If the base is less than 2 and greater than 32 it displays "Invalid base.".

If the input string contains characters that are not valid digits it displays "Invalid input."



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ n,m ≤ 40

Sample test cases :
Input 1 :
1101011101
2
10
Output 1 :
861
Input 2 :
1101011101
2
16
Output 2 :
35d
Input 3 :
XYZ
16
10
Output 3 :
Invalid input.
Input 4 :
1234
10
39
Output 4 :
Invalid base.

import java.util.Scanner;

public class BaseConverter {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input the number in the current base
        String number = scanner.nextLine();
        
        // Input the base of the input number
        int currentBase = scanner.nextInt();
        
        // Input the target base
        int targetBase = scanner.nextInt();
        
        // Call the convertBase function and display the result
        System.out.println(convertBase(number, currentBase, targetBase));
        
        scanner.close();
    }

    public static String convertBase(String number, int currentBase, int targetBase) {
        // Validate base ranges
        if (currentBase < 2 || currentBase > 32 || targetBase < 2 || targetBase > 32) {
            return "Invalid base.";
        }
        
        // Validate the input number for the current base
        try {
            // Convert number from currentBase to decimal (base 10)
            int decimalValue = Integer.parseInt(number, currentBase);
            
            // Convert decimal value to the target base
            return Integer.toString(decimalValue, targetBase).toLowerCase(); // Output in lowercase for hexadecimal (base 16) like 35d
        } catch (NumberFormatException e) {
            return "Invalid input."; // Handles invalid input characters for the base
        }
    }
}

3.

Problem Statement



Joel, a mathematics enthusiast, is fascinated by special types of numbers called Disarium numbers. A Disarium number is a number where the sum of its digits, each raised to the power of its position in the number, equals the number itself. 



Joel wants to write a program to check if a given number is a Disarium number. The program should include a parameterized method named isDisarium that takes an integer as input and returns a boolean indicating whether the number is a Disarium number or not.

Input format :
The input consists of an integer n, representing the number to be checked.

Output format :
The output displays "X (is a/is not a) Disarium number." where X is the input number indicating whether it is a Disarium number or not.



Refer to the sample output for format specification

Code constraints :
1 ≤ n ≤ 106

Sample test cases :
Input 1 :
89
Output 1 :
89 is a Disarium number.
Input 2 :
28
Output 2 :
28 is not a Disarium number.

import java.util.*;

class main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        if(isDisarium(num)){
            System.out.println(num+" is a Disarium number.");
        } else {
            System.out.println(num+" is not a Disarium number.");
        }
    }
    
    public static boolean isDisarium(int num){
        int sum = 0;
        int copy = num;
        int length = Integer.toString(num).length();
        
        while(copy>0){
            int d = copy%10;
            sum += Math.pow(d,length--);
            copy/=10;
        }
        
        return sum==num;
    }
}

4.
Problem Statement:



Henry is tasked with creating a currency converter program that allows users to convert between three different currencies: USD (United States Dollar), EUR (Euro), and GBP (British Pound). 



Design a program to convert USD to either EUR or GBP. Implement a method named convert to handle currency conversion rates.



Note:

The initial conversion rates are USD to EUR: 0.88 and USD to GBP: 0.75.

Input format :
The first line of input consists of a string S, representing the desired currency ("EUR" or "GBP").

The second line consists of a double amount X, representing the amount in USD to be converted.

Output format :
If the desired currency is EUR, the output prints "X EUR" where X is the converted amount in euro rounded off to two decimal places.

Otherwise the output prints, "X GBP" where X is the converted amount in British Pounds rounded off to two decimal places.



Refer to the sample output for formatting specifications.

Code constraints :
1.0 ≤ X ≤ 10000.0

Sample test cases :
Input 1 :
EUR
100.7
Output 1 :
88.62 EUR
Input 2 :
GBP
45.8
Output 2 :
34.35 GBP
import java.util.*;

class main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String desired = sc.nextLine();
        double amtUSD = sc.nextDouble();
        convert(desired,amtUSD);
        sc.close();
    }
    
    public static void convert(String desired,double amtUSD){
        switch(desired){
            case "EUR" : {
                System.out.format("%.2f EUR",0.88*amtUSD); break;
            }
            case "GBP" : {
                System.out.format("%.2f GBP",0.75*amtUSD); break;
            }
        }
    }
}

5.
Problem Statement:



Mandy is developing a tool to identify and display the unique characters in a given string. The tool should filter out any repeated characters, ensuring that each character appears only once in the output. 



The implementation should include a parameterized method named uniqueChars that takes a string as input and returns a string containing only the unique characters.

Input format :
The input consists of a String, representing the text from which unique characters are to be extracted.

Output format :
The output displays "Unique Characters: " followed by a String representing the unique characters found in the input, in the order of their first appearance.



Refer to the sample output for formatting specifications.

Code constraints :
The string contains uppercase,lowercase, and numbers with at most 40 characters.

Sample test cases :
Input 1 :
hello
Output 1 :
Unique Characters: helo
Input 2 :
aAaaaad
Output 2 :
Unique Characters: aAd
Input 3 :
122one
Output 3 :
Unique Characters: 12one

import java.util.*;

class main {
    public static String uniqueChars(String input){
        StringBuilder unique = new StringBuilder();
        for(int i=0 ; i<input.length() ; i++){
            char currentChar = input.charAt(i);
            
            if(unique.toString().indexOf(currentChar) == -1){
                unique.append(currentChar);
            }
        }
        return "Unique Characters: "+unique.toString();
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(uniqueChars(str));
    }
}

6.
Problem Statement



Naveen is tasked with developing a program that can find Armstrong numbers in a specified range. Help him create a method findArmstrongNumbersInRange that allows users to input a range, and it should then identify and display the Armstrong numbers within that range.



An Armstrong number is a special kind of number in math. It is a number that equals the sum of its digits, each raised to a power. 



Company Tags: CTS

Input format :
The input consists of two space-separated integers, representing the start and end of the range respectively.

Output format :
The output prints the Armstrong numbers found within the specified range, one per line.



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ starting range, ending range ≤ 105

Sample test cases :
Input 1 :
100 200
Output 1 :
153
Input 2 :
145 420
Output 2 :
153
370
371
407

import java.util.*;

class main {
    public static boolean isArmstrong(int num){
        int digits = String.valueOf(num).length();
        // int digits = (int) Math.log10(num) +1;
        int sum = 0,temp = num;
        while(temp!=0){
            int d = temp%10;
            sum+=Math.pow(d,digits);
            temp/=10;
        }
        return sum==num;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        for(int i=start ; i<=end ; i++){
            if(isArmstrong(i)){
                System.out.println(i);
            }
        }
    }
}

7.
Problem Statement



Alice, a math enthusiast, wanted to explore the program by calculating the sum of digits of factorials of various numbers. Alice was curious about how the sum of digits changes with different input numbers. She started with small numbers and gradually increased them. 



Write a method calculateFactorial to find the factorial of the given input and a method calculateSumOfDigits to find the sum of digits of the factorial.



Company Tags: Infosys, Capgemini

Input format :
The input consists of an integer number N.

Output format :
The first line of output prints a long value, representing the factorial of N.

The second line prints an integer, representing the sum of digits of the factorial.



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ N ≤ 20

Sample test cases :
Input 1 :
5
Output 1 :
Factorial of 5 : 120
Sum of digits of the factorial: 3
Input 2 :
8
Output 2 :
Factorial of 8 : 40320
Sum of digits of the factorial: 9
Input 3 :
12
Output 3 :
Factorial of 12 : 479001600
Sum of digits of the factorial: 27

import java.util.*;

class main {
    public static int calculateFactorial(int num){
        int res = 1;
        while(num>0){
            res*=num;
            num--;
        }
        return res;
    } 
    public static int calculateSumOfDigits(int fac){
        int sum = 0;
        while(fac>0){
            int d = fac%10;
            sum += d;
            fac /= 10;
        }
        return sum;
    } 
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int fac = calculateFactorial(num); 
        System.out.println("Factorial of " +num+ " : "+fac);
        System.out.println("Sum of digits of the factorial: "+calculateSumOfDigits(fac));
    } 
}

8.
Problem Statement



Sam is tasked with writing a method calculateLCM, that takes an array of integers as input and calculates the least common multiple (LCM) of the integers in the array. He wants to implement this method to find and return the LCM of the integers in the input array.



Help Sam to implement this method.

Input format :
The first line of input consists of an integer N, representing the number of elements.

The second line consists of N space-separated integers, representing the array elements.

Output format :
The output prints an integer representing the LCM of the integers in the input array.



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ N ≤ 10

1 ≤ array elements ≤ 250

Sample test cases :
Input 1 :
2
2 3
Output 1 :
6
Input 2 :
5
3 5 6 1 4 
Output 2 :
60

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(calculateLCM(n, arr));
        sc.close();
    }

    // Method to calculate the Greatest Common Divisor (GCD) of two numbers
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    /*public static int gcd(int dividend, int divisor) {
        int remainder;
        while (divisor != 0) {
            remainder = dividend % divisor; // Calculate the remainder
            dividend = divisor;            // Update dividend to the previous divisor
            divisor = remainder;           // Update divisor to the remainder
        }
        return dividend; // The GCD is now stored in dividend
    }*/


    // Method to calculate the Least Common Multiple (LCM) of two numbers
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    // Method to calculate the LCM of an array of numbers
    public static int calculateLCM(int n, int[] arr) {
        int result = arr[0];
        for (int i = 1; i < n; i++) {
            result = lcm(result, arr[i]);
        }
        return result;
    }
}

9.
Problem Statement



Lucas is a math teacher, and he is working on a project to calculate harmonic sums to teach his students. He needs your help to create a program with a method calculateHarmonicSum that can calculate the harmonic sum up to a specified number N.



Assist Lucas in solving this mathematical challenge.



The harmonic sum is defined as:



Company Tags: Wipro

Input format :
The input consists of a single integer N, representing the number up to which the harmonic sum should be calculated.

Output format :
The output prints a double value, representing the calculated harmonic sum, rounded off to two decimal places.



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ N ≤ 500

Sample test cases :
Input 1 :
5
Output 1 :
2.28
Input 2 :
88
Output 2 :
5.06
Input 3 :
100
Output 3 :
5.19
import java.util.*;

class main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.format("%.2f",calculateHarmonicSum(num));
    }
    
    public static double calculateHarmonicSum(int num){
        double sum = 0;
        for(int i=1;i<=num;i++){
            sum += (1.0/i);
        }
        return sum;
    }
}

10.
Problem Statement



Rohit is tasked with creating a program to find the maximum digit within an integer. The program should be able to take any positive integer as input and determine the highest numerical digit present in that integer. 



Help Rohit to write a method maxDigit that calculates the highest digit present in the given number.

Input format :
The input consists of a single integer N, the number for which you want to find the maximum digit.

Output format :
The output prints the maximum digit found in the input number.



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ N ≤ 1010

Sample test cases :
Input 1 :
12345
Output 1 :
5
Input 2 :
4958
Output 2 :
9

import java.util.*;

class main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(maxDigit(n));
    }
    
    public static int maxDigit(int n){
        int max = 0;
        while(n>0){
            int d = n%10;
            if(d>max) max = d;
            n /= 10;
        }
        return max;
    }
}




















