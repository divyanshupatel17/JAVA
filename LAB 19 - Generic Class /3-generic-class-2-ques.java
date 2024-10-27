1.

Problem Statement



Megna, an avid fitness enthusiast, seeks a program to track her daily workouts. 



The program must allow her to input calorie burn rates. With the ability to specify exercise counts, Megna desires a tool that computes and displays the total calories burned during her workout sessions, aiding her to sum the calories and monitor her fitness progress efficiently. 



Write a program using a generic method named calculateSum to help Megna.

Input format :
The first line of input consists of an integer N, representing the number of workouts.

The second line consists of N space-separated integers, representing the calories burnt during each workout.

Output format :
The output prints an integer, representing the total calories burnt.



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ N ≤ 15

Sample test cases :
Input 1 :
3
1 4 2
Output 1 :
7
Input 2 :
6
11 23 15 26 19 28
Output 2 :
122
Note :

import java.util.*;
import java.io.*;

class Main {
    public static <T extends Number> int calculateCal(ArrayList<T> cal){
        int sum = 0;
        for(T c : cal){
            sum += c.intValue();
        }
        return sum;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> cal = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            cal.add(sc.nextInt());
        }
        
        int total = calculateCal(cal);
        System.out.println(total);
        sc.close();
    }
}

2.

Problem Statement



You are given an array of integers and a target integer. Create a Java program that performs the following operations using a generic class and interface:



Search for the target integer in the array and return the index of its first occurrence.
Count the total number of occurrences of the target integer in the array.
Input format :
The first line of input consists of an integer, representing the number of elements in the Integer array.

The second line consists of space-separated integers representing the elements of the Integer array.

The third line consists of an integer representing the target integer to search for in the array.

Output format :
If the target integer is found in the array, the output prints the following:

The index of the first occurrence of the target integer in the array.
The total number of occurrences of the target integer in the array.
If the target integer is not found in the array: the output prints a message indicating that the target integer was not found.



Refer to the sample outputs for the formatting specifications.

Code constraints :
The array elements must be positive integers.

Sample test cases :
Input 1 :
5
1 2 3 4 5
3
Output 1 :
First occurrence of 3 found at index 2
Total occurrences of 3: 1
Input 2 :
4
10 20 30 40
5
Output 2 :
5 not found in the array.
Input 3 :
6
5 5 5 5 5 5
5
Output 3 :
First occurrence of 5 found at index 0
Total occurrences of 5: 6
Note :

import java.util.Scanner;

interface Searchable<T> {
    int findFirstOccurrence(T[] arr, T target);
    int countOccurrences(T[] arr, T target);
}

class Search<T> implements Searchable<T> {
    @Override
    public int findFirstOccurrence(T[] arr, T target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int countOccurrences(T[] arr, T target) {
        int count = 0;
        for (T item : arr) {
            if (item.equals(target)) {
                count++;
            }
        }
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();
        Search<Integer> search = new Search<>();
        
        int firstIndex = search.findFirstOccurrence(arr, target);
        int totalOccurrences = search.countOccurrences(arr, target);

        if (firstIndex != -1) {
            System.out.println("First occurrence of " + target + " found at index " + firstIndex);
            System.out.println("Total occurrences of " + target + ": " + totalOccurrences);
        } else {
            System.out.println(target + " not found in the array.");
        }
    }
}


