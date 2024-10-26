1.
Problem Statement



Ashok and Ragu are students studying in a school. Ashok is interested in calculating the geometric mean of a list of students marks. Ragu has decided to help Ashok by creating a program using ArrayList.



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

import java.util.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        ArrayList<Double> list = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            double itm = sc.nextDouble();
            list.add(itm);
        }
        
        double prod = 1.0f;
        for(double l : list){
            prod = prod*l;
        }
        double res = Math.pow(prod,(1.0/n));
        System.out.printf("Geometric mean of the list: %.2f",res);
        sc.close();
    }
}