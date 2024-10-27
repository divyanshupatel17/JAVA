1.

Problem Statement



Assist Pranitha in developing a program that takes an integer N as input, representing the number of names to be read. Then read N names and store them in an ArrayList. Finally, input a search string and output the frequency of that string in the list of names.

Input format :
The first line of input consists of an integer N, representing the number of names to be read.

The following N lines consist of N names, as a string.

The last line consists of a string, representing the name to be searched.

Output format :
The output prints a single integer, representing the frequency of the specified name in the given list.

If the specified name is not found, print 0.



Refer to the sample output for formatting specifications.

Code constraints :
2 ≤ N ≤ 10

The maximum length of the input string is 100.

The input strings are case-sensitive.

Sample test cases :
Input 1 :
5
Alice
Bob
Ankit
Alice
Pranitha
Alice
Output 1 :
2
Input 2 :
3
Mitchell
Sofia
Lily
Cameron
Output 2 :
0
Input 3 :
6
Benjamin
Emma
Emma
Benjamin
emma
Daniel
Emma
Output 3 :
2
Note :

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        ArrayList<String> list = new ArrayList<>();
        int n = sc.nextInt(); sc.nextLine();
        
        for(int i=0 ; i<n ; i++){
            list.add(sc.nextLine());
        }
        
        String target = sc.nextLine();
        int freq = 0;
        for(String l : list){
            if(l.equals(target)){
                freq++;
            }
        }
        System.out.print(freq);
        sc.close();
    }
}

2.

Problem Statement



Misha is planning a birthday party and wants to create a list of guests for the party. She decided to use an ArrayList to store the names of the guests who were invited.



She writes a program that takes input for the number of guests and then reads and stores their names in an ArrayList. Finally, the program should display the list of guests invited.

Input format :
The first line of input is an integer N, representing the number of guests Misha wants to invite.

The next N lines each of input consists of a string, representing the name of a guest.

Output format :
The output displays the names of the guests, each on a new line.



Refer to the sample output for the formatting specifications.

Code constraints :
In this scenario, the test cases will fall under the following constraints:

1 ≤ N ≤ 10

The length of each name is between 1 and 50 characters and contains spaces.

Sample test cases :
Input 1 :
1
Sri
Output 1 :
Sri
Input 2 :
5
Alice
Bob
Charlie
David
Eva
Output 2 :
Alice
Bob
Charlie
David
Eva
Input 3 :
10
MS Dhoni
Virat Kohli
Rohit Sharma
Kane Williamson
Steve Smith
Babar Azam
David Warner
Shakib Al Hasan
Jasprit Bumrah
Rashid Khan
Output 3 :
MS Dhoni
Virat Kohli
Rohit Sharma
Kane Williamson
Steve Smith
Babar Azam
David Warner
Shakib Al Hasan
Jasprit Bumrah
Rashid Khan
Note :



import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); sc.nextLine();
        
        ArrayList<String> list = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            list.add(sc.nextLine());
        }
        
        for(String l : list){
            System.out.println(l);
        }
        sc.close();
    }
}


3


Problem Statement



Raman is a computer science teacher who is responsible for registering students for his programming class.



He wants to streamline the registration process using a simple program. The program should allow him to input the names of students and later retrieve a student's name based on the index entered. 



Raman has decided to use an ArrayList to store the names.

Input format :
The first line of input is an integer n, representing the number of students to register.

The next n lines of input consist of the names of each student, one by one.

The last line of input is an integer, representing the index (0-indexed) of the element to retrieve.

Output format :
If the index is valid (within the bounds of the ArrayList), print "Element at index [index]: " followed by the element.

If the index is invalid, print "Invalid index".



Refer to the sample output for formatting specifications.﻿

Code constraints :
2 ≤ n ≤ 10

Sample test cases :
Input 1 :
5
Alice
Bob
Ankit
Alice
Prajit
2
Output 1 :
Element at index 2: Ankit
Input 2 :
2
Alice
Bob
2
Output 2 :
Invalid index
Note :;'

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<String> students = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            students.add(sc.nextLine());
        }
        
        int index = sc.nextInt();
        
        if (index >= 0 && index < students.size()) {
            System.out.println("Element at index " + index + ": " + students.get(index));
        } else {
            System.out.println("Invalid index");
        }
    }
}



4.

Problem Statement



Using ArrayList as a List Interface implementation, input N integers from standard input and add to the list only if they form an increasing sequence. Perform the following operations:



Accept N integers as input 
Add the number to the list only if it forms an increasing sequence; else, ignore it
Print the list
Input format :
The first line of input consists of an integer N, the number of elements.

The second line consists of N space-separated integers, representing the elements.

Output format :
The output prints the list of integers in increasing sequence ignoring out-of-order elements.



Refer to the sample output for the formatting specifications.

Code constraints :
1 ≤ N ≤ 20

1 ≤ elements ≤ 100

Sample test cases :
Input 1 :
7
3 5 9 1 11 7 13
Output 1 :
[3, 5, 9, 11, 13]
Input 2 :
4
11 7 5 1
Output 2 :
[11]
Input 3 :
5
12 37 12 10 39
Output 3 :
[12, 37, 39]
Note :

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        
        if (n > 0) {
            int previous = sc.nextInt();
            list.add(previous);
            
            for (int i = 1; i < n; i++) {
                int current = sc.nextInt();
                if (current > previous) {
                    list.add(current);
                    previous = current;
                }
            }
        }
        
        System.out.println(list);
    }
}



5.

Problem Statement



Ashok and Ragu are students studying in a school. Ashok is interested in calculating the geometric mean of a list of students' marks. Ragu has decided to help Ashok by creating a program using ArrayList.



Write a program that takes input for the number of students, then takes their mark points as input, calculates the geometric mean, and finally prints the result.



Example



Input:

5 

1.0 2.0 3.0 4.0 5.0

Output: 

Geometric mean of the list: 2.61

Explanation:

The geometric mean is calculated as the nth root of the product of all numbers.

Geometric Mean = (1.0 * 2.0 * 3.0 * 4.0 * 5.0)^(1/5) ≈ 2.61.



Note: Use Math.pow() to calculate the power value.

Input format :
The first line of input consists of an integer N, representing the number of students.

The second line consists of N double values, representing the mark points of each student, separated by a space.

Output format :
The output displays a "Geometric mean of the list: " followed by a double value, representing the geometric mean of the list of marks, rounded off to two decimal places.



Refer to the sample output for formatting specifications.

Code constraints :
In this scenario, the test cases will fall under the following constraints:

1 ≤ N ≤ 10

0.0 ≤ marks ≤ 100.0

Sample test cases :
Input 1 :
5 
1.0 2.0 3.0 4.0 5.0
Output 1 :
Geometric mean of the list: 2.61
Input 2 :
3 
4.5 6.7 8.9
Output 2 :
Geometric mean of the list: 6.45
Input 3 :
2
11.2 32.4
Output 3 :
Geometric mean of the list: 19.05
Note :

'
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Double> marks = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            marks.add(sc.nextDouble());
        }

        double product = 1.0;
        for (double mark : marks) {
            product *= mark;
        }

        double geometricMean = Math.pow(product, 1.0 / n);
        System.out.printf("Geometric mean of the list: %.2f%n", geometricMean);
    }
}

