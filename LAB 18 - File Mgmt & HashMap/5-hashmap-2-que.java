1.

Problem Statement



﻿John is organizing a fruit festival, and the quantities of various fruits are stored in a HashMap where fruit names are keys and quantities are values. 



Help him develop a program to find the total quantity of fruits for the festival by summing up the values in the HashMap. 

Input format :
The input consists of fruit quantities in the format 'fruitName:quantity', where fruitName is the name of the fruit(a string), and quantity is a double value representing the quantity.

The input is terminated by entering "done".

Output format :
The output prints a double value, representing the sum of values in the HashMap, rounded off to two decimal places.

If the value is not numeric, print "Invalid input".

If any special characters other than ':' are entered, print "Invalid format".



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ Length of the String ≤ 20

1.0 ≤ quantity ≤ 100.0

Sample test cases :
Input 1 :
Banana:15.2
Orange:56.3
Mango:47.3
done
Output 1 :
118.80
Input 2 :
Papaya:25.8
Muskmelon:34.9
Grapes:98.1
Cherry:34.7
done
Output 2 :
193.50
Input 3 :
Banana:w
Strawberry:s
done
Output 3 :
Invalid input
Input 4 :
Guava-12.6
Kiwi-96.2
Blueberry-85.1
done
Output 4 :
Invalid format
Note :

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        HashMap<String,Double> map = new HashMap<>();
        while(true){
            String input = sc.nextLine();
            if(input.equals("done")) break;
            
            String[] parts = input.split(":");
            
            if(parts.length != 2){
                System.out.println("Invalid format");
                return;
            }
            
            try {
                String s = parts[0];
                double d = Double.parseDouble(parts[1]);
                map.put(s,d);
            } catch(NumberFormatException e){
                System.out.println("Invalid input");
                return ;
            }
        }
        
        double total = 0.0f;
        for(double val : map.values()){
            total += val;
        }
        System.out.printf("%.2f",total);
    }
}


2.

Problem Statement



Bob wants to develop a score-tracking application for a gaming tournament. Each player's score is stored in a HashMap with the player's name as the key and the score as the value. 



Write a program to assist Bob that takes user input to enter player scores, calculates the maximum score from the HashMap, and prints the player with the highest score.

Input format :
The input consists of strings representing player details in the format ''playerName:score''.

The input is terminated by entering "done".

Output format :
The output displays a string, representing the player's name who scored the maximum.

If the value is not numeric, print "Invalid input".

If any special characters other than ':' are given, print "Invalid format".



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ Length of the Player's Name ≤ 20

1 ≤ score ≤ 100

Sample test cases :
Input 1 :
Alice:15
Bob:56
done
Output 1 :
Bob
Input 2 :
Karan:21
Lathika:52
Sandhiya:30
done
Output 2 :
Lathika
Input 3 :
Sachin:Ten
Dhoni:10
done
Output 3 :
Invalid input
Input 4 :
Pandya-15
Gill-3
Krunal:10
done
Output 4 :
Invalid format
Note :

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> scores = new HashMap<>();

        while (true) {
            String input = sc.nextLine();
            if (input.equals("done")) break;

            String[] parts = input.split(":");
            if (parts.length != 2) {
                System.out.println("Invalid format");
                return;
            }

            try {
                String player = parts[0];
                int score = Integer.parseInt(parts[1]);
                scores.put(player, score);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                return;
            }
        }

        // Iterating to find the player with the maximum score
        String topPlayer = null;
        int maxScore = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            if (entry.getValue() > maxScore) {
                maxScore = entry.getValue();
                topPlayer = entry.getKey();
            }
        }

        System.out.println(topPlayer);
        sc.close();
    }
}

