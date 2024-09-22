1.
Problem Statement



Arun is working on a project to convert seconds to a time format. He wants to create a program that accepts a time duration in seconds and converts it into hours, minutes, and seconds. 



Help him write a class SecondsToTime with a constructor that gets input in seconds and converts it into hh:mm:ss format.

Input format :
The input consists of a single integer, representing the time duration in seconds.

Output format :
The output prints the converted time in the format 'hh:mm:ss' where hh represents hours, mm represents minutes, and ss represents seconds.



Refer to the sample output for formatting specifications.

Code constraints :
time in seconds > 0

Sample test cases :
Input 1 :
3665
Output 1 :
01:01:05
Input 2 :
7200
Output 2 :
02:00:00
Input 3 :
60
Output 3 :
00:01:00
import java.util.*;

class SecondsToTime {
    int s;
    public SecondsToTime(int s){
        this.s = s;
    }
    
    public void convert(){
        
        int hr = s / 3600;
        int min = (s%3600) / 60;
        int sec= s%60;
        
        System.out.format("%02d:%02d:%02d",hr,min,sec);
    }
}

class main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int sec = sc.nextInt();
        
        SecondsToTime obj = new SecondsToTime(sec);
        obj.convert();
    }
}

2.
Problem Statement



﻿Parker, a software developer, is working on creating a Retirement Fund Calculator program. He needs to write a static method calculateRetirementFund() that calculates the amount of money that will be in a retirement fund after a certain number of years, given an initial investment and a fixed annual interest rate, using loop constructs.



Help Parker to implement the program.



Example



Input:

20570.8

0.05

2

Output:

22679.31

Explanation:

Initial investment = 20,570.8

annual interest rate = 5% 

years = 2 years



Calculate the interest for each year in a loop using the formula: initial investment = initial investment + initial investment * annual interest rate



For 2 years,

Year 1: 20570.8 + 20570.8 * 0.05 = 21599.34

Year 2: 21599.34 + 21599.34 * 0.05 = 22679.31



So, the final value after 2 years is 22,679.31.

Input format :
The first line of input consists of a double value, representing the initial amount of money invested in the retirement fund.

The second line consists of a double value, representing the fixed annual interest rate (e.g., 0.05 for 5%).

The third line consists of an integer, representing the number of years for which the investment will grow.

Output format :
The output displays a double value, representing the retirement fund after the given years, rounded off to two decimal places.

﻿

Refer to the sample output for formatting specifications.

Code constraints :
In this scenario, the test cases will fall under the following constraints:

1000.0 ≤ initial amount ≤ 1000000.0

0.00 ≤ annual rate ≤ 0.10

1 ≤ years ≤ 30

Sample test cases :
Input 1 :
10000.5
0.05
1
Output 1 :
10500.53
Input 2 :
5575.7
0.08
3
Output 2 :
7023.78
Input 3 :
20570.8
0.05
2
Output 3 :
22679.31
import java.util.*;

class main{
    public static double calculateRetirementFund(double i,double a,double y){
        for(int j=0 ; j<y ; j++){
            i = i+(i*a);
        }
        return i;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double initial = sc.nextDouble();
        double fixedAnnualInterestRate = sc.nextDouble();
        double years = sc.nextDouble();
        double res = calculateRetirementFund(initial,fixedAnnualInterestRate,years);
        System.out.format("%.2f",res);
    }
}

3.
Problem Statement



Raj is planning to estimate the construction cost of his new house. Develop a simple program that takes inputs for the square footage, number of bedrooms, and cost per square foot. 



Utilize a class House with a constructor and methods, using this keyword for attribute assignments. The program should calculate and display the estimated construction cost for the given number of bedrooms.  



The estimated construction cost is calculated by multiplying the number of bedrooms by the square footage of the home and then multiplying that result by the cost per square foot.

Input format :
The first line of input consists of the square footage of the house as a double value.

The second line consists of the number of bedrooms as an integer.

The third line consists of the cost per square foot as a double value.

Output format :
The output displays "Estimated Construction Cost: Rs. " followed by a double value, rounded to two decimal places, representing the estimated construction cost.



Refer to the sample output for formatting specifications.

Code constraints :
100.0 ≤ square footage ≤ 10000.0

1 ≤ number of bedrooms ≤ 10

50.0 ≤ cost per square foot ≤ 200.0

Sample test cases :
Input 1 :
150.0
3
120.0
Output 1 :
Estimated Construction Cost: Rs. 54000.00
Input 2 :
2105.70
3
120.50
Output 2 :
Estimated Construction Cost: Rs. 761210.55
Input 3 :
5000.0
5
198.75
Output 3 :
Estimated Construction Cost: Rs. 4968750.00

import java.util.*;

class House{
    double s;
    int b;
    double c;
    public House(double s,int b,double c){
        this.s = s;
        this.b = b;
        this.c = c;
    }
    void display(){
        System.out.format("Estimated Construction Cost: Rs. %.2f",s*b*c);
    }
}    

class main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double sq = sc.nextDouble();
        int bedroom = sc.nextInt();
        double cost = sc.nextDouble();
        House obj = new House(sq,bedroom,cost);
    
        obj.display();
    }
}

Problem Statement



Roshni is tasked with developing a program for concatenating two arrays provided by the user. To accomplish this, she wants to create a class named ArrayConcatenator. The class includes a constructor to concatenate the elements of the input arrays. She wants to print the elements of the resulting array.



Help Roshni to complete the program.

Input format :
The first line of input consists of an integer N, representing the number of elements of the first array.

The second line consists of N space-separated integers representing the first array elements.

The third line consists of an integer M, representing the number of elements of the second array.

The fourth line consists of M space-separated integers, representing the second array elements.

Output format :
The output prints the concatenated array of elements separated by space.



Refer to the sample output for the formatting specifications.

Code constraints :
In this scenario, the test cases fall under the following constraints

1 ≤ N, M ≤ 10

1 ≤ array elements ≤ 100

Sample test cases :
Input 1 :
5
7 8 5 6 9
3
1 4 3
Output 1 :
7 8 5 6 9 1 4 3 
Input 2 :
4
78 56 93 14
1
56
Output 2 :
78 56 93 14 56 

// You are using Java
import java.util.*;

class ArrayConcatenator {
    int n;
    int m;
    
    ArrayConcatenator(int n1,int[] arr,int m1,int[] arr2){
        this.n = n1;
        this.m = m1;
        int[] res = new int[n+m];
        for(int i=0 ; i<n ; i++){
            res[i] = arr[i];
        }
        for(int j=0 ; j<m ; j++){
            res[n+j] = arr2[j];
        }
        
        for(int i=0 ; i<n+m ; i++){
            System.out.print(res[i] + " ");
        }
    }
}

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }
        
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for(int i=0 ; i<m ; i++){
            arr2[i] = sc.nextInt();
        }
        
        ArrayConcatenator obj = new ArrayConcatenator(n,arr,m,arr2);
        
    }
}

5.
Problem Statement



One day, a creative architect received an unusual request from a client. The client needed a software program to calculate the area of rectangle-shaped garden plots. The client had the idea of using rectangular plots with various widths and heights to create unique gardens. 



Write a program using a class Rectangle and a constructor to calculate the area of the rectangle.

Input format :
The input consists of two space-separated double values, representing the width and height, respectively.

Output format :
The output prints the area of the rectangle, rounded off to two decimal places.



Refer to the sample output for formatting specifications.

Code constraints :
In this scenario, the test cases fall under the following constraints:

1.0 ≤ width, height ≤ 100.0

Sample test cases :
Input 1 :
4.4 5.3
Output 1 :
23.32
Input 2 :
12.5 9.8
Output 2 :
122.50

import java.util.*;

class Rectangle {
    float a;
    float b;
    Rectangle(float a,float b){
        this.a = a;
        this.b = b;
    }
    void DisplayArea(){
        float res;
        res = a*b;
        System.out.format("%.2f" , res);
    }
}

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        float a = sc.nextFloat();
        
        float b = sc.nextFloat();
        
        Rectangle obj = new Rectangle(a,b);
        obj.DisplayArea();
        
    }
}

6.
Problem Statement



Eric operates a taxi service and charges passengers based on the distance travelled and the waiting time. The total fare is calculated using a base fare, cost per mile, and cost per minute of wait time. 



Write a program to calculate the total fare using a static method calculateFare.



Formula: Total Fare = base fare + (distance * cost per mile) + (waiting time * cost per minute)



Take these as Erics standard fee and cost structure:

Base fare = 3.50

Cost per mile = 2.50

Cost per minute = 0.20

Input format :
The first line of input consists of the distance travelled in miles (a double value)

The second line consists of the waiting time in minutes (a non-negative integer)

Output format :
The output prints "Total Fare: ", followed by a double value, representing the total fare, rounded to two decimal places.



Refer to the sample output formatting specifications.

Code constraints :
0.0 ≤ distance travelled ≤ 50.0

1 ≤ waiting time ≤ 60

Sample test cases :
Input 1 :
7.3
6
Output 1 :
Total Fare: 22.95
Input 2 :
13.25
5
Output 2 :
Total Fare: 37.63

import java.util.*;

class calculateFare {
    double d;
    int i;
    double baseFare = 3.50;
    double costPerMile = 2.50;
    double costPerMin = 0.20;
    calculateFare(double d, int i){
        this.d = d;
        this.i = i;
    }
    void display(){
        double totalFare = baseFare + (d*costPerMile) + (i*costPerMin);
        System.out.format("Total Fare: %.2f",totalFare);
        
    }
}

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double d = sc.nextDouble();
        int i = sc.nextInt();
        
        calculateFare obj = new calculateFare(d,i);
        obj.display();
    }
}