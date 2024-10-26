1,.
Problem Statement



Raman is a computer science teacher who is responsible for registering students for his programming class.



He wants to streamline the registration process using a simple program. The program should allow him to input the names of students and later retrieve a students name based on the index entered. 



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
Note :

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<String> names = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String item = sc.nextLine();
            names.add(item);
        }
        
        int idx = sc.nextInt();
        
        if (idx >= 0 && idx < n) {
            String res = names.get(idx);
            System.out.println("Element at index " + idx + ": " + res);
        } else {
            System.out.println("Invalid index");
        }
        
        sc.close();
    }
}


2.

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

import java.util.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        int last = Integer.MIN_VALUE;
        for(int i=0 ; i<n ; i++){
            int item = sc.nextInt();
            if(item > last){
                list.add(item);
                last = item;
            }
        }
        
        System.out.print(list);
    }
}