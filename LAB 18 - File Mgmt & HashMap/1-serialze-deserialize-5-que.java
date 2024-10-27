1.

Problem Statement



Ivy wants to create a program that takes her age as input, serializes the information into a file, and then modifies the age by adding 5 years during the serialization process. Later, she wants to deserialize the file to retrieve and display the modified age.



Create a program that will serialize the age information into a file named person.ser. During serialization, Ivys age will be modified by adding 5 years. The program will read the object from the file, retrieve the modified age and display the modified age after deserialization.



Assist Ivy in completing this program.

Input format :
The input consists of an integer N, representing the age entered by Ivy.

Output format :
The output displays the modified age after deserialization.

If an invalid age is entered, print "Exception is caught: Invalid input for age."



Refer to the sample output for formatting specifications.

Code constraints :
In this scenario, the test cases fall under the following constraints:

1 ≤ N ≤ 100

Sample test cases :
Input 1 :
20
Output 1 :
25
Input 2 :
42
Output 2 :
47
Input 3 :
Ten
Output 3 :
Exception is caught: Invalid input for age.
Note :

import java.io.*;
import java.util.*;

// Person class that implements Serializable to enable serialization
class Person implements Serializable {
    private int age;
    
    // Constructor to initialize age
    public Person(int age) {
        this.age = age;
    }
    
    // Getter for age
    public int getAge() {
        return age;
    }
    
    // Method to modify age
    public void modifyAge() {
        this.age += 5;
    }
}

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        
        try {
            // Read age input and validate
            int age = Integer.parseInt(sc.nextLine());
            if(age < 1 || age > 100) {
                throw new IllegalArgumentException("Invalid input for age.");
            }
            
            // Create Person object and modify age
            Person person = new Person(age);
            person.modifyAge();
            
            // Serialize to file
            FileOutputStream fileOut = new FileOutputStream("person.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(person);
            out.close();
            fileOut.close();
            
            // Deserialize from file
            FileInputStream fileIn = new FileInputStream("person.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Person deserializedPerson = (Person) in.readObject();
            in.close();
            fileIn.close();
            
            // Display modified age
            System.out.println(deserializedPerson.getAge());
            
        } catch (NumberFormatException e) {
            System.out.println("Exception is caught: Invalid input for age.");
        } catch (IllegalArgumentException e) {
            System.out.println("Exception is caught: " + e.getMessage());
        }
    }
}


2.

Problem Statement



James is working on a program to classify age groups using custom serialization and deserialization techniques. He wants to save and load age-related information using a serialization mechanism. 



Design a program to create a Person object with the given age, and serialize the Person object to a file named person.ser, deserialize the Person object from the file, and display the age group classification after deserialization.



Note:

"Kid", if the age is between 0 and 12 (both inclusive).
"Teen", if the age is between 13 and 19 (both inclusive).
"Adult", if the age is 20 or above.
Input format :
The input consists of an integer value N, representing the age entered by James.

Output format :
The output displays the age group classification ("Kid," "Teen," or "Adult") after deserialization.



Refer to the sample output for formatting specifications.

Code constraints :
In this scenario, the test cases fall under the following constraints:

1 ≤ N ≤ 100

Sample test cases :
Input 1 :
2
Output 1 :
Kid
Input 2 :
14
Output 2 :
Teen
Input 3 :
100
Output 3 :
Adult
Note :

import java.io.*;
import java.util.*;

class Person implements Serializable {
    // private static final long serialVersionUID = 1L; // Add a serialVersionUID
    private int age;
    
    public Person(int age){
        this.age = age;
    }
    
    public int getAge(){
        return age;
    } 
}

class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int age = sc.nextInt();
            sc.close();
            
            // Serialize the object
            Person per = new Person(age);
            FileOutputStream fileOutput = new FileOutputStream("person.ser");
            ObjectOutputStream outFile = new ObjectOutputStream(fileOutput);
            outFile.writeObject(per);
            outFile.close();
            fileOutput.close();
            
            // Deserialize the object
            FileInputStream fileInput = new FileInputStream("person.ser");
            ObjectInputStream inFile = new ObjectInputStream(fileInput);
            Person desPerson = (Person) inFile.readObject();
            inFile.close();
            fileInput.close();
            
            // Determine the age group
            String res;
            int resAge = desPerson.getAge();
            if (resAge >= 0 && resAge <= 12) {
                res = "Kid";
            } else if (resAge >= 13 && resAge <= 19) {
                res = "Teen";
            } else {
                res = "Adult";
            }
            
            System.out.println(res);
            
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}



3.

Problem Statement



Sam is managing his bank account and wants to perform various transactions using a program. He wants to deposit and withdraw funds and then save the account details using serialization. Upon restarting the program, he wants to be able to load the serialized data and continue with his banking transactions.



Write a program to assist Sam in managing his bank account, create a BankAccount class, and Serialize the BankAccount object to a file named bankAccount.ser after the transactions. Deserialize the BankAccount object from the file when the program restarts.



Display the final balance after the transactions in a formatted manner with two decimal places.

Input format :
The first line of input consists of a double value B, representing the initial balance.

The second line consists of a double value D, representing the deposit amount.

The third line consists of a double value W, representing the withdrawal amount.

Output format :
The output displays the final balance after the transactions, with two decimal places.



Refer to the sample output for the formatting specifications.

Code constraints :
In this scenario, the test cases fall under the following constraints:

1.0 ≤ B ≤ 50000.0

1.0 ≤ D ≤ 50000.0

1.0 ≤ W ≤ 5000.0

Sample test cases :
Input 1 :
1000.7
500.5
100.6
Output 1 :
1400.60
Input 2 :
10000.5
450.7
120.2
Output 2 :
10331.00
Note :

import java.io.*;
import java.util.*;

class BankAccount implements Serializable {
    private double B;
    public BankAccount(double B){
        this.B = B;
    }
    public void deposit(double D){
        B += D;
    }
    public void withdrawal(double W){
        B -= W;
    }
    public double getBalance(){
        return B;
    }
}

class Main {
    public static void main(String[] args){
        try {    
            Scanner sc = new Scanner(System.in);
            
            double B = sc.nextDouble();
            double D = sc.nextDouble();
            double W = sc.nextDouble();
            
            BankAccount obj = new BankAccount(B);
            obj.deposit(D);
            obj.withdrawal(W);
            
            FileOutputStream fileOut = new FileOutputStream("bankAccount.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
            
            FileInputStream fileIn = new FileInputStream("bankAccount.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            BankAccount res = (BankAccount) in.readObject();
            in.close();
            fileIn.close();
            
            System.out.printf("%.2f",res.getBalance());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

4,

Problem Statement



Alice is managing her expenses and wants to create a simple program to track her savings she wants to categorise her savings as "Poor savings," "Good savings," or "High savings" using a serialization mechanism. 



Design a program to create an object of the SavingsData class with the provided salary and savings data. Serialize the created object to a file named savings.ser. Deserialize the SavingsData object from the savings.ser file. Display the category determined by the program after deserialization.



Note:

"Poor savings", if the savings percentage is between 1% (inclusive) and 10%.
"Good savings", if the savings percentage is between 10% (inclusive) and 20%.
"High savings", if the savings percentage is greater than or equal to 20%.
"Invalid input", if none of the above conditions are met.
Input format :
The first line of input consists of a float value d, representing the monthly salary.

The second line consists of a float value d1, representing the savings amount.

Output format :
The output displays the savings category("Poor savings", "Good savings", "High savings") after deserialization.



Refer to the sample output for the formatting specifications.

Code constraints :
In this scenario, the test cases fall under the following constraints:

1.0 ≤ d ≤ 10000.0

1.0 ≤ d1 ≤ 3000.0

Sample test cases :
Input 1 :
5000.0
300.0
Output 1 :
Poor savings
Input 2 :
8000.0
1200.0
Output 2 :
Good savings
Input 3 :
10000.0
2500.0
Output 3 :
High Savings
Input 4 :
2000.0
1.0
Output 4 :
Invalid input
Note :

import java.util.*;
import java.io.*;

class SavingsData implements Serializable {
    private double ms;
    private double sa;
    public SavingsData(double ms,double sa){
        this.ms = ms;
        this.sa = sa;
    }
    
    String cat = null;
    void findCat(){
        double per = (sa*100.0f)/ms;
        if(per >= 1 && per < 10){
            cat = "Poor savings";
        } else if(per >= 10 && per < 20){
            cat = "Good savings";
        } else if(per >= 20){
            cat = "High Savings";
        } else {
            cat = "Invalid input";
        }
    }
    public String getCat(){
        return cat;
    }
}

class Main {
    public static void main(String[] args){
        try {    
            Scanner sc = new Scanner(System.in);
            
            double ms = sc.nextDouble();
            double sa = sc.nextDouble();
            SavingsData obj = new SavingsData(ms,sa);
            
            FileOutputStream fOut = new FileOutputStream("savings.ser");
            ObjectOutputStream out = new ObjectOutputStream(fOut);
            out.writeObject(obj);
            out.close();
            fOut.close();
            
            FileInputStream fIn = new FileInputStream("savings.ser");
            ObjectInputStream in = new ObjectInputStream(fIn);
            SavingsData res = (SavingsData) in.readObject();
            in.close();
            fIn.close();
            
            res.findCat();
            System.out.println(res.getCat());
            
                
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

5.

Problem Statement



Melvin is focused on maintaining a healthy lifestyle and wants to create a program to track his health records, specifically his weight, BMI (Body Mass Index), and a target BMI he aims to achieve. He wants a program that calculates the weight he needs to reach his target BMI and allows for easy serialization and deserialization of health data.



Design a program to create an object of the HealthRecord class with the provided weight, current BMI, and target BMI. Calculate the weight required to reach the target BMI using the formula. Serialize the HealthRecord object to a file named health_data.ser. Deserialize the HealthRecord object from the health_data.ser file.



Display the calculated weight required to reach the target BMI after deserialization.



Note: Weight to reach target BMI=( target BMI * weight) / current BMI

Input format :
The first line of input consists of a double value d, representing the weight.

The second line consists of a double value b, representing the current BMI.

The third line consists of a double value t, representing the target BMI.

Output format :
The output displays the calculated weight required to reach the target BMI, formatted to two decimal places.



Refer to the sample output for the formatting specifications.

Code constraints :
In this scenario, the test cases fall under the following constraints:

1.0 ≤ d ≤ 100.0

1.0 ≤ b ≤ 50.0

1.0 ≤ t ≤ 50.0

Sample test cases :
Input 1 :
70.5 
22.5 
24.0
Output 1 :
75.20

Input 2 :
60.0
22.0
20.0
Output 2 :
54.55

Note :

import java.io.*;
import java.util.*;

class HealthRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    private double weight;
    private double currentBMI;
    private double targetBMI;

    public HealthRecord(double weight, double currentBMI, double targetBMI) {
        this.weight = weight;
        this.currentBMI = currentBMI;
        this.targetBMI = targetBMI;
    }

    public double calculateTargetWeight() {
        return (targetBMI * weight) / currentBMI;
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            
            // Taking input values
            double weight = sc.nextDouble();
            double currentBMI = sc.nextDouble();
            double targetBMI = sc.nextDouble();
            sc.close();
            
            // Creating HealthRecord object
            HealthRecord record = new HealthRecord(weight, currentBMI, targetBMI);
            
            // Serializing the HealthRecord object to health_data.ser
            FileOutputStream fileOutput = new FileOutputStream("health_data.ser");
            ObjectOutputStream outFile = new ObjectOutputStream(fileOutput);
            outFile.writeObject(record);
            outFile.close();
            fileOutput.close();
            
            // Deserializing the HealthRecord object from health_data.ser
            FileInputStream fileInput = new FileInputStream("health_data.ser");
            ObjectInputStream inFile = new ObjectInputStream(fileInput);
            HealthRecord deserializedRecord = (HealthRecord) inFile.readObject();
            inFile.close();
            fileInput.close();
            
            // Calculating the weight required to reach the target BMI
            double targetWeight = deserializedRecord.calculateTargetWeight();
            
            // Printing the result formatted to two decimal places
            System.out.printf("%.2f%n", targetWeight);
            
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}



