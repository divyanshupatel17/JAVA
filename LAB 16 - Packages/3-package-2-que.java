1.
Problem Statement



Ashok needs to implement a program using the java.lang package to process a given string. The goal is to create a program that extracts and displays a new string containing only the unique characters from the provided input string. 



Ashok should efficiently use the java.lang.StringBuilder class and display the output. Help him to complete the program.

Input format :
The input consists of a string.

Output format :
The output prints the modified string containing the unique characters from the provided input string.



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ Length of String ≤ 50

Sample test cases :
Input 1 :
ProgramMing
Output 1 :
ProgamMin
Input 2 :
Playing is fun
Output 2 :
Playing sfu
Note :

import java.util.*;
import java.lang.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        StringBuilder res = new StringBuilder();
        for(int i=0 ; i<st.length() ; i++){
            char c = st.charAt(i);
            if(res.indexOf(String.valueOf(c)) == -1){
                res.append(c);
            }
            
        }
        System.out.println(res.toString());
    }
}

2.

Problem Statement



Sharon is given the task of creating a program that makes use of packages to effectively manage a dynamic list of elements. 



To achieve this, she must use the ArrayList class from the java.util package. This class provides a dynamic array implementation, allowing her to easily add elements in a flexible manner.



She wants to create an Array, and add two initial elements 'Apple' and 'Banana'. Input a new element using the scanner class and add it to the Array. Finally, the contents of the list will be displayed to showcase both the original elements and the newly added ones.



Help Sharon to complete the program.

Input format :
The input consists of a string, representing the new element to be added to the list.

Output format :
The first line of output prints "Original Array: " followed by two strings separated by spaces.

The second line prints the "Array after adding a new element: " followed by three strings separated by space.



Refer to the sample output for formatting specifications.

Sample test cases :
Input 1 :
Orange
Output 1 :
Original Array: Apple Banana 
Array after adding a new element: Apple Banana Orange 
Input 2 :
Grape
Output 2 :
Original Array: Apple Banana 
Array after adding a new element: Apple Banana Grape 
Note :



import java.util.*;
import java.lang.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();
        String ab = "Apple Banana";
        
        System.out.println("Original Array: "+ab+" ");
        System.out.println("Array after adding a new element: "+ab.concat(" ").concat(str));
    }
}