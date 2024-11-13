1.

Problem Statement



Define an interface Growing which declares the method isGrowing().



Create a class GrowingNumber which implements the interface. Override the method isGrowing() to check if the given number is a growing number or not. A growing number is a number where each digit is larger than the digit to its left.  For example, 369 is a growing number but 362 is not.



Create another class GrowingString which also implements the same interface. Override the method isGrowing() to check whether the given string is growing string or not. If on moving from left to right, each character in the string comes after the previous character in alphabetical order. For example, ANT is a growing string whereas APPLE is not. 



Write a Java program to check whether the given number is a growing number or not and whether the given string is a growing string or not.

Input format :
The input consists of a number followed by a string separated by space.

Output format :
The first line of output prints whether the given number is a growing number or not.

The second line prints whether the given string is a growing string or not.



Refer to the sample output for formatting specifications.

Code constraints :
The input string consists of uppercase characters.

Sample test cases :
Input 1 :
369 ANT
Output 1 :
Growing number
Growing string
Input 2 :
369 APPLE
Output 2 :
Growing number
Not growing string
Input 3 :
362 APPLE
Output 3 :
Not growing number
Not growing string
Input 4 :
362 ANT
Output 4 :
Not growing number
Growing string


Whitelist
Set 1:
interface
Growing
isGrowing
import java.util.Scanner;

interface Growing {
    String isGrowing();
}

class GrowingNumber implements Growing {
    private int number;

    GrowingNumber(int number) {
        this.number = number;
    }

    @Override
    public String isGrowing() {
        String numStr = String.valueOf(number);
        for (int i = 1; i < numStr.length(); i++) {
            if (numStr.charAt(i) <= numStr.charAt(i - 1)) {
                return "Not growing number";
            }
        }
        return "Growing number";
    }
}

class GrowingString implements Growing {
    private String str;

    GrowingString(String str) {
        this.str = str;
    }

    @Override
    public String isGrowing() {
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) <= str.charAt(i - 1)) {
                return "Not growing string";
            }
        }
        return "Growing string";
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        String str = scanner.next();

        GrowingNumber growingNumber = new GrowingNumber(number);
        GrowingString growingString = new GrowingString(str);

        System.out.println(growingNumber.isGrowing());
        System.out.println(growingString.isGrowing());

        scanner.close();
    }
}


2.

Oviya is fascinated by automorphic numbers and wants to create a program to determine whether a given number is an automorphic number or not.



An automorphic number is a number whose square ends with the same digits as the number itself. For example, 25 = (25)2 = 625 



Oviya has defined two interfaces, NumberInput for taking user input and AutomorphicChecker for checking if a given number is automorphic. The class AutomorphicNumber implements both interfaces.



Help her to complete the task.

Input format :
The input consists of a single integer n.

Output format :
If the input number is an automorphic number, print "n is an automorphic number".

Otherwise, print "n is not an automorphic number".



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ n ≤ 500

Sample test cases :
Input 1 :
25
Output 1 :
25 is an automorphic number
Input 2 :
7
Output 2 :
7 is not an automorphic number
Note :  Whitelist
Set 1:
interface
NumberInput
AutomorphicChecker

import java.util.Scanner;

interface NumberInput {
    int getInput();
}

interface AutomorphicChecker {
    boolean isAutomorphic(int number);
}

class AutomorphicNumber implements NumberInput, AutomorphicChecker {
    @Override
    public int getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public boolean isAutomorphic(int number) {
        int square = number * number;
        String numberStr = String.valueOf(number);
        String squareStr = String.valueOf(square);
        return squareStr.endsWith(numberStr);
    }
}

class Main {
    public static void main(String[] args) {
        AutomorphicNumber automorphicNumber = new AutomorphicNumber();
        int n = automorphicNumber.getInput();
        
        if (automorphicNumber.isAutomorphic(n)) {
            System.out.println(n + " is an automorphic number");
        } else {
            System.out.println(n + " is not an automorphic number");
        }
    }
}


