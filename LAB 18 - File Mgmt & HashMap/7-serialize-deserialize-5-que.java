1.

Problem Statement



Ivy wants to create a program that takes her age as input, serializes the information into a file, and then modifies the age by adding 5 years during the serialization process. Later, she wants to deserialize the file to retrieve and display the modified age.



Create a program that will serialize the age information into a file named person.ser. During serialization, Ivy's age will be modified by adding 5 years. The program will read the object from the file, retrieve the modified age and display the modified age after deserialization.



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
Note :'

import java.util.*;
import java.io.*;

class Person implements Serializable {
    private int age;
    public Person(int age){
        this.age = age;
    }
    public void setAge(){
        age += 5;
    }
    public int getAge(){
        return age;
    }
}

class Main {
    public static void main(String[] args){
        try {    
            Scanner sc = new Scanner(System.in);
            int age = sc.nextInt();
            
            if(age < 1 || age >100){
                System.out.println("Exception is caught: Invalid input for age.");
                return ;
            }
            
            Person person = new Person(age);
            person.setAge();
            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"));
                oos.writeObject(person);
                oos.close();
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"));
                Person res = (Person) ois.readObject();
                System.out.println(res.getAge());
                ois.close();
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        } catch(Exception e){
                System.out.println("Exception is caught: Invalid input for age.");
            
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
import java.util.Scanner;

class Person implements Serializable {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    // Method to determine the age group
    public String getAgeGroup() {
        if (age >= 0 && age <= 12) {
            return "Kid";
        } else if (age >= 13 && age <= 19) {
            return "Teen";
        } else {
            return "Adult";
        }
    }
}

class AgeClassification {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int age;
        try {
            age = sc.nextInt();
            if (age < 1 || age > 100) {
                System.out.println("Invalid age. Please enter an age between 1 and 100.");
                return;
            }

            // Create a Person object
            Person person = new Person(age);

            // Serialize the Person object
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
                oos.writeObject(person);
            } catch (IOException e) {
                System.out.println("Error during serialization: " + e.getMessage());
            }

            // Deserialize the Person object
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))) {
                Person deserializedPerson = (Person) ois.readObject();
                // Display the age group classification
                System.out.println(deserializedPerson.getAgeGroup());
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error during deserialization: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid integer for age.");
        } finally {
            sc.close(); // Close the scanner
        }
    }
}

3.

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


import java.io.*;
import java.util.Scanner;

class SavingsData implements Serializable {
    private float salary;
    private float savings;

    public SavingsData(float salary, float savings) {
        this.salary = salary;
        this.savings = savings;
    }

    public String getSavingsCategory() {
        if (salary <= 0 || savings < 0) {
            return "Invalid input";
        }
        
        float savingsPercentage = (savings / salary) * 100;

        if (savingsPercentage >= 1 && savingsPercentage < 10) {
            return "Poor savings";
        } else if (savingsPercentage >= 10 && savingsPercentage < 20) {
            return "Good savings";
        } else if (savingsPercentage >= 20) {
            return "High Savings";
        } else {
            return "Invalid input";
        }
    }
}

class ExpenseTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read inputs
        float salary = sc.nextFloat();
        float savings = sc.nextFloat();

        // Create SavingsData object
        SavingsData savingsData = new SavingsData(salary, savings);

        // Serialize the SavingsData object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("savings.ser"))) {
            oos.writeObject(savingsData);
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }

        // Deserialize the SavingsData object
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("savings.ser"))) {
            SavingsData deserializedData = (SavingsData) ois.readObject();
            // Display the savings category
            System.out.println(deserializedData.getSavingsCategory());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        } finally {
            sc.close(); // Close the scanner
        }
    }
}



4.

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
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
class Main {
    private static final String FILE_NAME = "bankAccount.ser";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);

        // Input
        double initialBalance = scanner.nextDouble();
        double depositAmount = scanner.nextDouble();
        double withdrawalAmount = scanner.nextDouble();

        // Create BankAccount object
        BankAccount account = new BankAccount(initialBalance);
        account.deposit(depositAmount);
        account.withdraw(withdrawalAmount);

        // Serialize
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(account);
        }

        // Deserialize
        BankAccount deserializedAccount;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            deserializedAccount = (BankAccount) in.readObject();
        }

        // Output
        System.out.printf("%.2f", deserializedAccount.getBalance());

        scanner.close();
    }
}

// import java.io.*;
// import java.util.Scanner;

// class BankAccount implements Serializable {
//     private double balance;

//     public BankAccount(double balance) {
//         this.balance = balance;
//     }

//     public void deposit(double amount) {
//         balance += amount;
//     }

//     public void withdraw(double amount) {
//         balance -= amount;
//     }

//     public double getBalance() {
//         return balance;
//     }
// }

// class Main {
//     private static final String FILE_NAME = "bankAccount.ser";

//     public static void main(String[] args) throws IOException, ClassNotFoundException {
//         Scanner scanner = new Scanner(System.in);

//         // Check if serialized file exists
//         File file = new File(FILE_NAME);
//         BankAccount account;

//         if (file.exists()) {
//             // Deserialize existing account
//             try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
//                 account = (BankAccount) in.readObject();
//             }
//         } else {
//             // Create new account
//             account = new BankAccount(scanner.nextDouble());
//         }

//         // Perform transactions
//         account.deposit(scanner.nextDouble());
//         account.withdraw(scanner.nextDouble());

//         // Serialize updated account
//         try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
//             out.writeObject(account);
//         }

//         // Display final balance
//         System.out.printf("%.2f", account.getBalance());

//         scanner.close();
//     }
// }

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
    private double weight;
    private double currentBMI;
    private double targetBMI;
    private double targetWeight;

    public HealthRecord(double weight, double currentBMI, double targetBMI) {
        this.weight = weight;
        this.currentBMI = currentBMI;
        this.targetBMI = targetBMI;
        calculateTargetWeight();
    }

    private void calculateTargetWeight() {
        targetWeight = (targetBMI * weight) / currentBMI;
    }

    public double getTargetWeight() {
        return targetWeight;
    }
}
class Main {
    private static final String FILE_NAME = "health_data.ser";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);

        // Input
        double weight = scanner.nextDouble();
        double currentBMI = scanner.nextDouble();
        double targetBMI = scanner.nextDouble();

        // Create HealthRecord object
        HealthRecord record = new HealthRecord(weight, currentBMI, targetBMI);

        // Serialize
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(record);
        }

        // Deserialize
        HealthRecord deserializedRecord;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            deserializedRecord = (HealthRecord) in.readObject();
        }

        // Output
        System.out.printf("%.2f", deserializedRecord.getTargetWeight());

        scanner.close();
    }
}


