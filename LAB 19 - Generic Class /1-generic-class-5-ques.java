1.

Problem Statement



Helen wants to implement a FizzBuzz program using a generic class named FizzBuzz that takes a number of any numeric type. 



FizzBuzz is a popular programming problem where you need to print numbers from 1 to a given number but replace multiples of 3 with "Fizz", multiples of 5 with "Buzz," and multiples of both 3 and 5 with "FizzBuzz".



Assist Helen in developing the program.

Input format :
The input consists of an integer N, representing the ending range for which FizzBuzz should be applied.

Output format :
The program prints the FizzBuzz sequence from 1 to N in each line.

For each number, it should follow these rules:

If the number is divisible by 3, print "Fizz"
If the number is divisible by 5, print "Buzz"
If the number is divisible by both 3 and 5, print "FizzBuzz"
Otherwise, print the number itself.
Code constraints :
1 ≤ N ≤ 50

Sample test cases :
Input 1 :
28
Output 1 :
1
2
Fizz
4
Buzz
Fizz
7
8
Fizz
Buzz
11
Fizz
13
14
FizzBuzz
16
17
Fizz
19
Buzz
Fizz
22
23
Fizz
Buzz
26
Fizz
28
Input 2 :
7
Output 2 :
1
2
Fizz
4
Buzz
Fizz
7
Note :

import java.util.*;
import java.io.*;

class FizzBuzz<T extends Number> {
    private T end;
    public FizzBuzz(T end){
        this.end = end;
    }
    public void print(){
        for(int i=1 ; i<=end.intValue() ; i++){
            if(i%3==0 && i%5==0){
                System.out.println("FizzBuzz");
            }
            else if(i%3==0){
                System.out.println("Fizz");
            }
            else if(i%5==0){
                System.out.println("Buzz");
            }
            else {
                System.out.println(i);
            }
        }
    }
}

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        FizzBuzz<Integer> obj = new FizzBuzz(n);
        obj.print();
        sc.close();
    }
}

2.

Problem Statement



Rithesh is developing a utility class for sorting arrays of various types. He wants to create a program with a generic class capable of sorting an array of double datatype. The program should provide functionality for sorting the array in increasing order.



Assist Rithesh in developing the program.

Input format :
The first line of input consists of an integer N, representing the number of double values.

The second line consists of N space-separated double values.

Output format :
The output will be a single line displaying the sorted array of doubles in ascending order, formatted as an array string.



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ N ≤ 10

0.00 ≤ double values ≤ 10.00

Sample test cases :
Input 1 :
3
1.39 4.57 0.78
Output 1 :
[0.78, 1.39, 4.57]
Input 2 :
7
0.36 0.82 0.27 0.49 0.41 0.17 0.39
Output 2 :
[0.17, 0.27, 0.36, 0.39, 0.41, 0.49, 0.82]
Note :

import java.util.*;
import java.io.*;

class Sorter<T extends Comparable<T>> {
    public T[] sortArray(T[] arr){
        Arrays.sort(arr);
        return arr;
    }
}

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        sc.nextLine();
        
        Double[] arr = new Double[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextDouble();
        }

        Sorter<Double> obj = new Sorter<>();
        
        Double[] sortedArray = obj.sortArray(arr);

        System.out.println(Arrays.toString(sortedArray));
    }
}

3.

Problem Statement



Catherine is an avid reader with an extensive collection of books. Over time, she has organized her books in a specific order and labeled each with a unique identifier. Lately, she has been rearranging her bookshelves and wants to create an algorithm to efficiently search for a book using its ID in her collection. 



Implement a generic program using binary search to assist Catherine in finding books by their unique IDs.

Input format :
The first line of input consists of an integer n, representing the number of books in Catherine's collection.

The second line consists of n space-separated integers denoting the unique IDs of the books, sorted in ascending order.

Output format :
The output displays the index(0-based) of the book corresponding to a given unique ID or displays a message indicating that the book with the provided ID is not in Catherine's collection.



Refer to the sample output for the formatting specifications.

Code constraints :
1 ≤ n ≤ 100

1 ≤ ID ≤ 100

Sample test cases :
Input 1 :
5
10 20 30 40 50
30
Output 1 :
Element found at index: 2
Input 2 :
5
10 20 30 40 50
90
Output 2 :
Element not found in the array.
Note :

import java.util.*;
import java.io.*;

// extend "Comparable Interface" to use "compareTo"

class BS<T extends Comparable<T>> {
    public int binarySearch(T[] arr,T target){
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = left + (right-left)/2 ;
            if(arr[mid].equals(target)){
                return mid;
            } else if(arr[mid].compareTo(target)<0){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }  
}

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }
        
        int target = sc.nextInt();
        
        BS<Integer> obj = new BS<>();
        int idx = obj.binarySearch(arr,target);
        
        if(idx != -1){
            System.out.println("Element found at index: "+idx);
        } else {
            System.out.println("Element not found in the array.");
        }
        
    }
}

4.

Problem Statement



Sarah is tasked with creating a program that reverses the elements of an array using generics in Java. Can you help her with this?

Input format :
The first line of input consists of an integer n, representing the size of the array.

The second line consists of n integers, representing the elements of the array.

Output format :
The first line of the output displays the original array

The second line displays the reversed integer array.



Refer to the sample output for the formatting specifications.

Code constraints :
1 ≤ n ≤ 100

1 ≤ array elements ≤ 1000

Sample test cases :
Input 1 :
5
1 2 3 4 5
Output 1 :
[1, 2, 3, 4, 5]
[5, 4, 3, 2, 1]
Input 2 :
3
9 8 7
Output 2 :
[9, 8, 7]
[7, 8, 9]
Note :

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Reverser<T> {
    //  Approach 1
    public T[] reverseArray2(T[] array) {
        List<T> list = Arrays.asList(array);
        Collections.reverse(list);
        return array; 
    }
    //  Approach 2
    public T[] reverseArray(T[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            T temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
        return array;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        Integer[] array = new Integer[n];
        
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        
        // Display original array
        System.out.println(Arrays.toString(array));
        
        // Create an instance of Reverser and reverse the array
        Reverser<Integer> reverser = new Reverser<>();
        Integer[] reversedArray = reverser.reverseArray(array);
        
        // Display reversed array
        System.out.println(Arrays.toString(reversedArray));
    }
}



5.

Problem Statement



Sharon is tasked with creating a program to calculate the sum of dimensions of a rectangle. 



Implement a generic class Area to help Sharon accomplish this task. The class should be designed to handle any numeric type that extends from Number.

Input format :
The input consists of two space-separated integers: length and width, representing the dimensions of a rectangle.

Output format :
The output prints an integer value, representing the sum of the length and width of the rectangle.



﻿Refer to the sample output for formatting specifications.

Code constraints :
length, width > 0

Sample test cases :
Input 1 :
5 3
Output 1 :
8
Input 2 :
10 6
Output 2 :
16
Note :

import java.util.Scanner;

class Area<T extends Number> {
    public int sum(T length, T width) {
        return length.intValue() + width.intValue();
    }
}
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int width = sc.nextInt();
        
        Area<Integer> area = new Area<>();
        System.out.println(area.sum(length, width));
    }
}




