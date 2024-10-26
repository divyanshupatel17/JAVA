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

class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        
        ArrayList<String> list = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            String item = sc.nextLine();
            list.add(item);
        }
        
        String target = sc.nextLine();
        int freq = 0;
        for(String name : list){
            if(name.equals(target)){
                freq++;
            }
        }
        // System.out.println(target);
        System.out.println(freq);
    }
}


2
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

import java.util.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<String> names = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            String item = sc.nextLine();
            names.add(item);
        }
        
        for(String name : names){
            System.out.println(name);
        }
        sc.close();
    }
}