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
