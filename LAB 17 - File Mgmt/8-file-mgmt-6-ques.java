1.
Problem Statement



Ram is working on a project where he needs to evaluate the performance of students based on their scores. He wants to calculate the average score and total scores of the students.



Create a file named student.txt to store these scores, read the scores from the file and calculate the total and the average score. The results are formatted and written to a new file called performance.txt. Finally, print the contents of the file performance.txt.



Help Ram to finish the project.

Input format :
The first line of input consists of an integer N, representing the number of students.

The second line consists of N space-separated integers, representing the score of each student.

Output format :
The first line of output prints "Total Score: " followed by an integer representing the total score of all students.

The second line prints "Average: " followed by a double value representing the average score, formatted to one decimal place.



Refer to the sample output for formatting specifications.

Code constraints :
In this scenario, the test cases fall under the following constraints:

1 ≤ N ≤ 10

1 ≤ score ≤100

Sample test cases :
Input 1 :
3
85 90 78
Output 1 :
Total Score: 253
Average: 84.3
Input 2 :
5
70 80 90 60 75
Output 2 :
Total Score: 375
Average: 75.0
Note :

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String file1 = "student.txt";
        String file2 = "performance.txt";
        int n = sc.nextInt();

        // Write scores to file1
        BufferedWriter writer = new BufferedWriter(new FileWriter(file1));
        for (int i = 0; i < n; i++) {
            int item = sc.nextInt();
            writer.write(item + "\n");
        }
        writer.close();

        int sum = 0;
        // Read scores from file1 and calculate sum
        BufferedReader reader = new BufferedReader(new FileReader(file1));
        String line;
        while ((line = reader.readLine()) != null) {
            sum += Integer.parseInt(line);
        }
        reader.close();

        double avg = (double) sum / n;

        // Write sum and average to file2
        writer = new BufferedWriter(new FileWriter(file2));
        writer.write(sum + "\n");
        writer.write(String.valueOf(avg));
        writer.close();

        // Read and display results from file2
        reader = new BufferedReader(new FileReader(file2));
        System.out.printf("Total Score: %d%n", Integer.parseInt(reader.readLine()));
        System.out.printf("Average: %.1f%n", Double.parseDouble(reader.readLine()));
        reader.close();

        sc.close();
    }
}


2.

Problem Statement



Amelia is working on a program that evaluates the strength of passwords based on specified criteria. She needs assistance in creating a program to automate this process. 



Evaluation is based on the length of the password.

If the length of the password is ≤ 3, classify it as Weak.
If the length is between 4 and 7 characters (both inclusive), classify it as Medium.
If the length is 8 characters or more, classify it as Strong.


Create a file named password.txt, the entered password is written to a file password.txt. The program then reads the stored password from password.txt to determine the password strength based on its length. 



The evaluated password strength is written to a new file named evaluation.txt and displayed.

Input format :
The input consists of a string, representing the entered password.

Output format :
The output displays the evaluated strength.



Refer to the sample output for the formatting specifications.

Code constraints :
The string contains lowercase, uppercase, numbers, and special characters with at most 15 characters.

Sample test cases :
Input 1 :
Sample@pass
Output 1 :
Strong
Input 2 :
pass
Output 2 :
Medium
Input 3 :
Av@
Output 3 :
Weak
Note :

import java.util.*;
import java.io.*;

class Main {
 public static void main(String[] args) throws IOException {
     Scanner sc = new Scanner(System.in);
     String pswd = sc.nextLine();
     
     String file1 = "password.txt";
     String file2 = "evaluation.txt";
     
     BufferedWriter writer = new BufferedWriter(new FileWriter(file1));
     writer.write(pswd);
     writer.close();
     
     BufferedReader reader = new BufferedReader(new FileReader(file1));
     String line = reader.readLine();
     reader.close();
     
     int len = line.length();
     String res;
     if(len < 4){
         res = "Weak";
     } else if (len < 8){
         res = "Medium";
     } else {
         res = "Strong";
     }
     
     writer = new BufferedWriter(new FileWriter(file2));
     writer.write(res);
     writer.close();
     
     reader = new BufferedReader(new FileReader(file2));
     String output = reader.readLine();
     reader.close();
     System.out.print(output);
     sc.close();
     
 }   
}

3.

Problem Statement



Nick is developing a program to convert speed units from kilometers per hour (km/h) to meters per second (m/s). However, he needs assistance in creating a structured and user-friendly program.



Create a file named data.txt to enter the speed in km/h as given in the input. The program reads the speed from data.txt and then converts the speed from km/h to m/s using the formula. The converted speed is written to a new file named converted.txt and then displayed.



Formula: speed in meters per second = speed in km per hour * 5.0 / 18.0.

Input format :
The input consists of a double value D, representing the speed in kilometers per hour (km/h).

Output format :
The output prints a double value followed by "m/s" representing the converted speed in meters per second (m/s) with two decimal places.



Refer to the sample output for formatting specifications.

Code constraints :
1.0 ≤ D ≤ 360.0

Sample test cases :
Input 1 :
180.0
Output 1 :
50.00 m/s
Input 2 :
58.0
Output 2 :
16.11 m/s
Input 3 :
360.0
Output 3 :
100.00 m/s
Note :

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        double ip = sc.nextDouble();
        String file1 = "data.txt";
        String file2 = "converted.txt";
    
        BufferedWriter writer = new BufferedWriter(new FileWriter(file1));
        writer.write(String.valueOf(ip));
        writer.close();
        
        BufferedReader reader = new BufferedReader(new FileReader(file1));
        double speed = Double.parseDouble(reader.readLine());
        reader.close();
        
        speed = speed*5.0;
        speed = speed/18.0;
        
        writer = new BufferedWriter(new FileWriter(file2));
        writer.write(String.valueOf(speed));
        writer.close();
        
        reader = new BufferedReader(new FileReader(file2));
        double res = Double.parseDouble(reader.readLine());
        reader.close();
        
        System.out.printf("%.2f m/s",res);
        sc.close();
    }
}


4.

Problem Statement



Mr. Styles is working on a sentiment analysis program to understand the sentiments conveyed in various sentences. 



He needs your assistance in developing a program that analyzes the sentiment of a given sentence and classifies it as positive, negative, or neutral.

positive keywords = happy, good, excellent, positive.
negative keywords = sad, bad, terrible, negative.
Anything else is Neutral.


Create a file named input.txt, the input is written into the file input.txt. The program then reads the sentence from input.txt and sentiment analysis is performed based on predefined positive and negative keywords. 



The classified sentiment (positive, negative, or neutral) is written to a new file named output.txt and displayed.

Input format :
The input consists of a string, representing the entered statement.

Output format :
The output displays the evaluated sentiment.



Refer to the sample output for formatting specifications.

Code constraints :
The string contains lowercase, uppercase, and spaces with at most 40 characters.

Sample test cases :
Input 1 :
I am feeling happy today.
Output 1 :
Positive
Input 2 :
The movie was terrible.
Output 2 :
Negative
Input 3 :
The movie was not great.
Output 3 :
Neutral
Note :

import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        String sentence = reader.readLine();
        reader.close();

        String sentiment = "Neutral";
        String lowerCaseSentence = sentence.toLowerCase();

        if (lowerCaseSentence.contains("happy") || lowerCaseSentence.contains("good") || lowerCaseSentence.contains("excellent") || lowerCaseSentence.contains("positive")) {
            sentiment = "Positive";
        } else if (lowerCaseSentence.contains("sad") || lowerCaseSentence.contains("bad") || lowerCaseSentence.contains("terrible") || lowerCaseSentence.contains("negative")) {
            sentiment = "Negative";
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        writer.write(sentiment);
        writer.close();

        System.out.println(sentiment);
    }
}

5.

Problem Statement



Ella is managing her expenses and wants to calculate the final prices after applying a 10% tax to her purchases. She has a list of item prices that she wants to process.



Create a file named prices.txt and write the entered item prices to this file. Then, the program should read from prices.txt, apply a 10% tax to each item, write the taxed amounts to a file named tax.txt, and display the taxed amounts.

Input format :
The first line of input consists of an integer N, representing the number of items Ella wants to process.

The second line consists of N space-separated double values, representing the price of an item.

Output format :
The output displays a double value, representing the taxed amounts, each with two decimal places, separated by a space.



Refer to the sample output for formatting specifications.

Code constraints :
In this scenario, the test cases fall under the following constraints:

1 ≤ N ≤ 10

Sample test cases :
Input 1 :
1
140.5
Output 1 :
154.55 
Input 2 :
4
12.2 58.6 63.4 78.1
Output 2 :
13.42 64.46 69.74 85.91 
Note :

Whitelist
Set 1:
prices.txt
Set 2:
tax.txt

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        // Write prices to prices .txt
        PrintWriter priceWriter = new PrintWriter("prices.txt");
        for (int i = 0; i < n; i++) {
            double price = sc.nextDouble();
            priceWriter.print(price + " ");
        }
        priceWriter.close();
        
        // Read from prices .txt and write taxed amounts to tax .txt
        Scanner fileScanner = new Scanner(new File("prices.txt"));
        PrintWriter taxWriter = new PrintWriter("tax.txt");
        
        // Store taxed amounts for display
        double[] taxedAmounts = new double[n];
        int index = 0;
        
        while (fileScanner.hasNextDouble()) {
            double price = fileScanner.nextDouble();
            double taxedPrice = price + (price * 0.10);
            taxedPrice = Math.round(taxedPrice * 100.0) / 100.0;
            taxedAmounts[index++] = taxedPrice;
            taxWriter.print(taxedPrice + " ");
        }
        
        fileScanner.close();
        taxWriter.close();
        
        // Display taxed amounts
        for (double amount : taxedAmounts) {
            System.out.printf("%.2f ", amount);
        }
        System.out.println();
    }
}


6.

Problem Statement



Alice is concerned about the security of her confidential messages and wants to implement a simple encryption and decryption program. 



Implement a simple encryption algorithm that increments the ASCII value of each character in the message. Implement a corresponding decryption algorithm that decrements the ASCII value of each character.



Create a program that takes user input for a confidential message, encrypts the message using a basic encryption algorithm, writes the encrypted message to a file named encrypted_data.txt, and then reads the encrypted data from the file to decrypt it. The decrypted message is then displayed to ensure the correctness of the encryption and decryption process.



Assist Alice in this task.

Input format :
The input consists of a string, representing a confidential message entered by the user.

Output format :
The first line of output displays the encrypted message after applying the encryption algorithm.

The second line displays the decrypted message after reading the encrypted data from the file and applying the decryption algorithm.



Refer to the sample output for formatting specifications.

Code constraints :
The string contains lowercase, uppercase and numbers with at most 50 characters.

Sample test cases :
Input 1 :
Hello
Output 1 :
Encrypted Message: Ifmmp
Decrypted Message: Hello
Input 2 :
12345
Output 2 :
Encrypted Message: 23456
Decrypted Message: 12345
Note :

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();
        
        // Encrypt message
        String encrypted = encrypt(message);
        System.out.println("Encrypted Message: " + encrypted);
        
        // Write to file
        PrintWriter writer = new PrintWriter("encrypted_data.txt");
        writer.println(encrypted);
        writer.close();
        
        // Read from file and decrypt
        Scanner fileReader = new Scanner(new File("encrypted_data.txt"));
        String encryptedFromFile = fileReader.nextLine();
        String decrypted = decrypt(encryptedFromFile);
        System.out.println("Decrypted Message: " + decrypted);
        fileReader.close();
    }
    
    static String encrypt(String text) {
        StringBuilder result = new StringBuilder();
        for(char c : text.toCharArray()) {
            result.append((char)(c + 1));
        }
        return result.toString();
    }
    
    static String decrypt(String text) {
        StringBuilder result = new StringBuilder();
        for(char c : text.toCharArray()) {
            result.append((char)(c - 1));
        }
        return result.toString();
    }
}
