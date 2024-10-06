1.
Problem Statement



Jack is learning programming and wants to practice programs. The goal is to create a program that takes an input string and outputs the reversed version of that string. 



Jack should utilize the following built-in Java packages: java.util.Scanner for reading input and java.lang.StringBuilder for efficiently reversing the string.



Help Jack by writing a program that fulfils these requirements.

Input format :
The input consists of a string S.

Output format :
The output prints the reversed string S.



Refer to the sample output for formatting specifications.

Code constraints :
The string S will contain only printable ASCII characters, including spaces.

Sample test cases :
Input 1 :
hello world
Output 1 :
dlrow olleh
Input 2 :
Java Programming
Output 2 :
gnimmargorP avaJ
Note :
import java.util.Scanner;
import java.lang.StringBuilder;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();
        StringBuilder rev = new StringBuilder(str);
        
        System.out.println(rev.reverse().toString());
    }
}

2.
Problem Statement



Alex is working on a text processing tool and needs to reverse each word in a given sentence while maintaining the original word order. 



Help Alex by writing a program that takes a sentence as input and outputs the sentence with each word reversed. Use java.lang.StringBuilder to achieve this.

Input format :
The input consists of a string.

Output format :
The output prints the modified string after reversing each word in the input.



Refer to the sample output for formatting specifications.

Code constraints :
The maximum length of the string is 100.

Sample test cases :
Input 1 :
Java Programming
Output 1 :
avaJ gnimmargorP
Input 2 :
Laptop
Output 2 :
potpaL
Note :

import java.util.Scanner;
import java.lang.StringBuilder;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String[] arr = sc.nextLine().split(" ");
        for(String str : arr){
            StringBuilder rev = new StringBuilder(str);
            System.out.print(rev.reverse().toString() + " ");
        }
    }
}

3.
Problem Statement



Julia is building a text analysis tool and needs to verify if a given string is a palindrome, ignoring case sensitivity. 



Help Julia by writing a program that takes a string as input and checks if it reads the same forwards and backwards, using java.lang.StringBuilder for string manipulation.

Input format :
The input consists of a string.

Output format :
The output prints true if the string is a palindrome and false otherwise.



Refer to the sample output for formatting specifications.

Code constraints :
The maximum length of the string is 50.

Sample test cases :
Input 1 :
madam
Output 1 :
true
Input 2 :
Malayalam
Output 2 :
true
Input 3 :
cat
Output 3 :
false

import java.util.Scanner;
import java.lang.StringBuilder;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine().trim().toLowerCase();
        StringBuilder rev = new StringBuilder(str);
        System.out.format("%s",(str.equals(rev.reverse().toString())) ? "true" : "false");
    }
}

4.

Problem Statement



Lisa needs a tool to insert a given substring into a specific position of a text. She wants to create a program using java.lang.StringBuilder to achieve this. The program should take the original text, substring, and insertion position as input and output the modified text.



Can you assist Lisa in this?

Input format :
The first line of input consists of the original text string.

The second line consists of the substring to insert.

The third line consists of the position (0-based index) where the substring should be inserted.

Output format :
The output prints the modified text string after inserting the substring at the specified position. If the position is greater than the original text length, print "Invalid position."



Refer to the sample output for formatting specifications.

Code constraints :
The input string consists of printable ASCII characters.

Sample test cases :
Input 1 :
HelloWorld
Java
5
Output 1 :
HelloJavaWorld
Input 2 :
OpenAI
GPT
3
Output 2 :
OpeGPTnAI
Input 3 :
Java
World
8
Output 3 :
Invalid position.

import java.util.*;
import java.lang.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String st1 = sc.nextLine();
        String st2 = sc.nextLine();
        int n = sc.nextInt();
        if(n > st1.length()) {
            System.out.println("Invalid position.");
            return;
        }
        StringBuilder str1 = new StringBuilder(st1);
        StringBuilder str2 = new StringBuilder(st2);
        str1.insert(n,str2);
        System.out.println(str1.toString());
    }
}


5.
Problem Statement



Alex needs to clean up user inputs by removing all non-alphanumeric characters while preserving the remaining characters in their original order. Write a program using java.lang.StringBuilder to accomplish this task. 

Input format :
The input consists of a single line containing a string with alphanumeric and non-alphanumeric characters.

Output format :
The output is a single line containing the cleaned string with all non-alphanumeric characters removed, preserving the order of the remaining characters.



Refer to the sample output for formatting specifications.

Code constraints :
The input string consists of printable ASCII characters.

Sample test cases :
Input 1 :
Hello, World! 123
Output 1 :
HelloWorld123
Input 2 :
@Java_Programming!! 2024
Output 2 :
JavaProgramming2024
Note :

import java.util.Scanner;
import java.lang.StringBuilder;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();
        StringBuilder st = new StringBuilder(str);
        StringBuilder res = new StringBuilder();
        
        for(char c : str.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                res.append(c);
            }
        }
        
        System.out.println(res.toString());
    }
}

6.
Problem Statement



Sophie has been tasked with creating a program using the java.util.Scanner package that counts the number of occurrences of a specific character in a given string. The program should prompt the user to enter a string and then a single character. It should then compute how many times that character appears in the string and display the result.



Your task is to help Sophie in implementing the same.

Input format :
The first line of input contains a string S.

The second line contains a character C.

Output format :
The output prints a single line indicating the number of times the character C appears in the string S in the format: "The character 'C' occurs X times."



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ length of string ≤ 100

The string S will contain only printable ASCII characters, including spaces.

Sample test cases :
Input 1 :
apple
p
Output 1 :
The character 'p' occurs 2 times.
Input 2 :
OpenAI is creating artificial intelligence
a
Output 2 :
The character 'a' occurs 3 times.
Input 3 :
Apple
P
Output 3 :
The character 'P' occurs 0 times.
Note :

import java.util.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char c = sc.next().charAt(0);
        
        int count = 0;
        for(int i=0 ; i<str.length() ; i++){
            char ch = str.charAt(i);
            if(ch == c) count++;
        }
        System.out.println("The character '"+c+"' occurs "+count+" times.");
    }
}

7.
Problem Statement



Rohit is given the task of developing a program that calculates the difference between two dates using java.time class. 



Implement a program to help Rohit that inputs two dates in the format "yyyy-mm-dd", and displays the calculated difference in days.

Input format :
The first line of input consists of the start date as string, in the format 'yyyy-mm-dd'.

The second line of input consists of the end date as string, in the format 'yyyy-mm-dd'.

Output format :
The output prints "X days", where X represents the calculated difference between the given two dates.

Sample test cases :
Input 1 :
2024-12-02
2000-12-02
Output 1 :
8766 days
Input 2 :
1995-08-12
1997-09-01
Output 2 :
751 days
Note :

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
class DateDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input the two dates in "yyyy-mm-dd" format
        LocalDate startDate = LocalDate.parse(sc.nextLine());
        LocalDate endDate = LocalDate.parse(sc.nextLine());
        
        // Calculate the difference in days
        long differenceInDays = ChronoUnit.DAYS.between(startDate, endDate);
        
        // Print the difference with the absolute value to handle date order
        System.out.println(Math.abs(differenceInDays) + " days");
        
        sc.close();
    }
}



8.
Problem Statement



Alex needs to plan a series of events and wants to determine how many complete weeks lie between two important dates. Write a program for him that calculates the number of complete weeks between two given dates, provided in the format yyyy-mm-dd. 



Use java.time class to handle date parsing and calculations accurately.

Input format :
The first line of input consists of the start date as a string, in the format 'yyyy-mm-dd'.

The second line consists of the end date as a string, in the format 'yyyy-mm-dd'.

Output format :
The output prints "X weeks", where X represents the number of complete weeks between the given dates.



Refer to the sample output for formatting specifications.

Sample test cases :
Input 1 :
2020-12-02
2000-12-02
Output 1 :
1043 weeks
Input 2 :
1995-08-12
1997-09-01
Output 2 :
107 weeks
Note :

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
class DateDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input the two dates in "yyyy-mm-dd" format
        LocalDate startDate = LocalDate.parse(sc.nextLine());
        LocalDate endDate = LocalDate.parse(sc.nextLine());
        
        // Calculate the difference in days
        long differenceInDays = ChronoUnit.DAYS.between(startDate, endDate);
        
        // Print the difference with the absolute value to handle date order
        System.out.println((Math.abs(differenceInDays))/7 + " weeks");
        
        sc.close();
    }
}

