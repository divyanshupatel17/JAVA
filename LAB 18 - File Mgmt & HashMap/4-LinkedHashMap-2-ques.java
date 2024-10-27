1.

Problem Statement



In a university database, each student is identified by their name and roll number. Create a program to store this information using a LinkedHashMap and allow the user to search for a student by name. If the student is found, display their roll number; otherwise, display the complete list of stored students.

Input format :
The first line of input contains an integer n, representing the number of students.

The next lines contain the name of each student followed by their roll number.

The last line contains a string representing the name of the student to be searched.

Output format :
The first line of output prints the entire HashMap content.

If the search name is found, the second line prints the corresponding roll number; otherwise, print nothing additional.



Refer to the sample output for formatting specifications.

Sample test cases :
Input 1 :
2
Alice
108
Mary
112
Alice
Output 1 :
{Alice=108, Mary=112}
108
Input 2 :
2
Alice
108
Mary
112
Henry
Output 2 :
{Alice=108, Mary=112}
Note :

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt(); -----> if using this -> also use -> sc.nextLine();
        int n = Integer.parseInt(sc.nextLine());
        
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        
        for(int i=0 ; i<n ; i++){
            String name = sc.nextLine();
            int num = Integer.parseInt(sc.nextLine());
            map.put(name,num);
        }
        
        System.out.println(map);
        
        String target = sc.nextLine();
        if(map.containsKey(target)){
            System.out.println(map.get(target));
        }
        /*
        String keyToFind = sc.nextLine();
        if (map.containsKey(keyToFind)) {
            System.out.println("Key found with value: " + map.get(keyToFind));
        }

        int valueToFind = Integer.parseInt(sc.nextLine());
        if (map.containsValue(valueToFind)) {
            System.out.println("Value found: " + valueToFind);
        }

        */
        
        sc.close();
    }
}

2.

Problem Statement



In a college, each student has a unique name associated with their roll number stored in a map. The student records are initially populated with names and roll numbers. After a student's roll number is updated based on a new value provided, the updated records should be printed out to reflect the change.



Specifications:

Use a LinkedHashMap<String, Integer> to store student names and their corresponding roll numbers.
The program should allow for updating the roll number of a specific student and then display the updated records.
Input format :
The first line of input consists of an integer n, representing the number of students.

The next n lines, each containing:

A string representing the student's name.
An integer representing the student''s roll number.
The next line consists of a string representing the name of the student whose roll number needs to be updated.

The last line consists of an integer representing the new roll number for the specified student.

Output format :
The first line of output prints the map with original values.

The second line prints the map with replaced values.



Refer to the sample output for formatting specifications.

Sample test cases :
Input 1 :
2
Alice
108
Mary
112
Alice
104
Output 1 :
{Alice=108, Mary=112}
{Alice=104, Mary=112}
Input 2 :
5
Alice
108
Mary
112
Harry
106
Hermoine
114
Sharon
126
Harry
109
Output 2 :
{Alice=108, Mary=112, Harry=106, Hermoine=114, Sharon=126}
{Alice=108, Mary=112, Harry=109, Hermoine=114, Sharon=126}
Note :

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        for(int i=0 ; i<n ; i++){
            String name = sc.nextLine();
            int num = sc.nextInt(); sc.nextLine();
            map.put(name,num);
        }
        
        System.out.println(map);
        
        String a = sc.nextLine();
        int b = sc.nextInt();
        map.put(a,b);
        
        System.out.println(map);
    }
}