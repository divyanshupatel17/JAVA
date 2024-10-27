1.
Problem Statement



Raghu, who is working as a developer in the IT field, began his career as a fresher. Currently, he has been assigned a task to implement a program that performs operations like sorting, searching and reversing a list of strings using collection algorithms. 



Help Raghu in completing this task.

Input format :
The first line of input consists of an integer N, representing the number of strings.

The second line consists of N strings separated by space.

The third line consists of a string, that is to be searched.

Output format :
The first line of output prints the sorted list of strings.

The second line prints the result of searching for the specific element in the sorted list with its index number (index starts from 0).

The third line prints the reversed sorted list.



Refer to the sample output for the exact text and format.

Code constraints :
1 ≤ N ≤ 10

Sample test cases :
Input 1 :
4
C# Java XML R
R
Output 1 :
Sorted List: [C#, Java, R, XML]
R is in the list at index 2
List after Reversing: [XML, R, Java, C#]
Input 2 :
3
Java CPP Python
python
Output 2 :
Sorted List: [CPP, Java, Python]
python is not in the list
List after Reversing: [Python, Java, CPP]
Note :

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        sc.nextLine();
        
        List<String> strings = new ArrayList<>();
        String[] input = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            strings.add(input[i]);
        }
        
        String searchStr = sc.nextLine();
        
        Collections.sort(strings);
        System.out.println("Sorted List: " + strings);
        
        int index = strings.indexOf(searchStr);
        if (index != -1) {
            System.out.println(searchStr + " is in the list at index " + index);
        } else {
            System.out.println(searchStr + " is not in the list");
        }
        
        Collections.reverse(strings);
        System.out.println("List after Reversing: " + strings);
        
        sc.close();
    }
}


2.

Problem Statement



Mesa, a store manager, needs a program to manage inventory items. Define a class ItemType with private attributes for name, deposit, and cost per day. Create an ArrayList in the Main class to store ItemType objects, allowing input and display.



Note: Use "%-20s%-20s%-20s" for formatting output in tabular format, display double values with 1 decimal place.

Input format :
The first line of input is an integer n representing the number of items.

For each of the n items, there are three lines:

The name of the item (a string)
The deposit amount (a double)
The cost per day (a double)
Output format :
The output displays a formatted table with columns for name, deposit and cost per day.



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ n ≤ 100

Sample test cases :
Input 1 :
3
Laptop
10000.0
250.0
Light
1000.0
50.0
Fan
1000.0
100.0
Output 1 :
Name                Deposit             Cost Per Day        
Laptop              10000.0             250.0               
Light               1000.0              50.0                
Fan                 1000.0              100.0               
Input 2 :
5
Headphones
300.0
15.0
Mouse
100.0
5.0
Desk
800.0
40.0
Printer
1500.0
70.0
Speakers
1200.0
60.0
Output 2 :
Name                Deposit             Cost Per Day        
Headphones          300.0               15.0                
Mouse               100.0               5.0                 
Desk                800.0               40.0                
Printer             1500.0              70.0                
Speakers            1200.0              60.0                
Note :

import java.util.*;

class ItemType {
    private String name;
    private double deposit;
    private double costPerDay;
    
    public ItemType(String name,double deposit,double costPerDay){
        this.name = name;
        this.deposit = deposit;
        this.costPerDay = costPerDay;
    }
    
    public String getName(){
        return name;
    }
    public double getDeposit(){
        return deposit;
    }
    public double getCostPerDay(){
        return costPerDay;
    }
}

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        
        ArrayList<ItemType> list = new ArrayList<>();
        
        for(int i=0 ; i<n ; i++){
            String name = sc.nextLine();
            double deposit = sc.nextDouble();
            double costPerDay = sc.nextDouble();
            if(i<n-1) sc.nextLine();
            list.add(new ItemType(name,deposit,costPerDay));
        }
        
        System.out.printf("%-20s%-20s%-20s%n","Name","Deposit","Cost Per Day");
        for(ItemType item : list){
            System.out.printf("%-20s%-20.1f%-20.1f%n",item.getName(),item.getDeposit(),item.getCostPerDay());
        }
    }
}

