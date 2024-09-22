1.
Problem Statement



Raam is working on a program to analyze and manipulate data in a matrix. He has created a MatrixProcessor class with a static nested class Matrix representing a matrix. 



Raam wants to implement a feature that finds the sum of elements in each column of the matrix. Write a program to help him take input for a matrix and display the sum of elements in each column.

Input format :
The first line of input consists of an integer N, representing the number of rows in the matrix.

The second line consists of an integer M, representing the number of columns in the matrix.

The following N lines consist of M elements. Each line corresponds to a row and contains space-separated integers.

Output format :
The output prints the sum of elements in each column.



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ N, M ≤ 10

1 ≤ array elements ≤ 100

Sample test cases :
Input 1 :
3
4
1 2 3 4
5 6 7 8
9 5 2 5
Output 1 :
15 13 12 17 

import java.util.*;

class MatrixProcessor {
    static class Matrix {
        int[][] mat;
        int r;
        int c;
        
        Matrix(int r,int c){
            this.r = r;
            this.c = c;
            this.mat = new int[r][c];
        }
        
        void input(Scanner sc){
            for(int i=0 ; i<r ; i++){
                for(int j=0 ; j<c; j++){
                    mat[i][j] = sc.nextInt();
                }
            }
        }
        
        void Sum(){
            for(int i=0 ; i<c ; i++){
                int sum=0;
                for(int j=0 ; j<r; j++){
                    sum += mat[j][i];
                }
                System.out.print(sum + " ");
            }
            
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        Matrix obj = new Matrix(r,c);
        obj.input(sc);
        obj.Sum();
    }
}



2.
Problem Statement



Goutham is given the task of developing a program that efficiently shuffles the elements of an array. He wants to create a ArrayRotator class with a constructor that takes an array and the number of positions to rotate. Users input the array size and elements, specify the rotating positions, and print the rearranged sequence.



Assist Goutham in developing the program.

Input format :
The first line of input consists of an integer N, representing the elements of the array.

The second line consists of N space-separated integers representing the array elements.

The third line consists of an integer M, representing the number of positions to rotate.

Output format :
The output prints the rearranged array elements.



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ N ≤ 10

1 ≤ array elements ≤ 100

M < N

Sample test cases :
Input 1 :
7
3 6 9 8 5 2 1
3
Output 1 :
5 2 1 3 6 9 8
Input 2 :
5
63 95 74 65 98
1
Output 2 :
98 63 95 74 65

// Rotate Right by k

import java.util.*;

class ArrayRotator {
    int n;
    int[] arr;
    int k;
    ArrayRotator(int n,int[] arr,int k){
        this.n = n;
        this.arr = new int[n];
        this.k = k;
        for(int i=0 ; i<n ; i++){
            this.arr[i] = arr[i];
        }
    }
    void reverse(int[] arr,int s,int e){
        while(s<e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
    void RR(){
        k = k%n;
        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
    }
    void display(){
        for(int i=0 ; i<n ; i++){
            System.out.print(arr[i] + " ");
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
        int k = sc.nextInt();
        ArrayRotator obj = new ArrayRotator(n,arr,k);
        obj.RR();
        obj.display();
    }
}

3.
Problem Statement



Amy wants to track the interest accrued on her savings account over a specified period. She needs a program that should take inputs for the initial account balance, annual interest rate, and the duration of time in months and calculate the compound interest.



Utilize a SavingsAccount class with a constructor and a method to calculate and display the accrued interest, emphasizing the use of this keyword for attribute assignments.



Note: 

Interest accrued = p * (1+r)n - p where p is the initial account balance, r is the monthly interest rate calculated as (annual interest rate / 12 / 100), n is the duration of time in months. Utilize pow() from Math library.

Input format :
The first line of input consists of a double value number p, representing the initial account balance.

The second line consists of a double value number r, representing the annual interest rate.

The third line consists of an integer n, representing the duration of time in months.

Output format :
The output displays "Interest Accrued: Rs." followed by the calculated interest accrued as a double value, rounded to two decimal places.



Refer to the sample output for formatting specifications.

Code constraints :
In this scenario, the test cases fall under the following constraints:

100.0 ≤ p ≤ 100000.0

1.0 ≤ r ≤ 10.0

1 ≤ n ≤ 24

Sample test cases :
Input 1 :
100.00
1.0
1
Output 1 :
Interest Accrued: Rs.0.08
Input 2 :
10000.00
5.0
6
Output 2 :
Interest Accrued: Rs.252.62
Input 3 :
100000.0
10.0
24
Output 3 :
Interest Accrued: Rs.22039.10

import java.util.*;

class SavingsAccount {
    double p;
    double r;
    int n;
    double res;
    SavingsAccount(double p,double r,int n){
        this.p = p;
        this.r = r;
        this.n = n;
    }
    
    void calculate(){
        res = (p * (Math.pow((1+(r/12/100)),n))) - p ;
    }
    void display(){
        System.out.format("Interest Accrued: Rs.%.2f",res);
    }
}

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double p = sc.nextDouble();
        double r = sc.nextDouble();
        int n = sc.nextInt();
        SavingsAccount obj = new SavingsAccount(p,r,n);
        obj.calculate();
        obj.display();
    }
}