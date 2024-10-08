1.
  Problem Statement



Alex is building a simple encryption tool to secure his messages. He needs a program that will help him encrypt text using a Caesar cipher. The program should prompt him to enter an integer key and a message. The key determines how many positions each letter in the message is shifted in the alphabet. 



Write a class Cipher to handle user input and encryption of the message based on the provided key.

Input format :
The first line of input consists of an integer value representing the encryption key.

The second line consists of the message to be encrypted.

Output format :
The output prints the encrypted message, with letters shifted according to the key. Non-letter characters remain unchanged.



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ encryption key ≤ 100

The input string contains alphabetical characters (uppercase and lowercase) and special characters.

Sample test cases :
Input 1 :
3
Hello, World!
Output 1 :
Encrypted text: Khoor, Zruog!
Input 2 :
10
A simple cipher.
Output 2 :
Encrypted text: K cswzvo mszrob.


import java.util.*;

class Cipher {
    private int key;
    private String msg;
    
    public Cipher(int key,String msg){
        this.key = key%26;
        this.msg = msg;
    }
    
    public void encrypt(){
        StringBuilder encrypted = new StringBuilder(100);
        
        for(int i=0 ; i<msg.length() ; i++){
            char c = msg.charAt(i);
            
            if(c>='A' && c<='Z'){
                char item = (char) ((c-'A' + key)%26 + 'A');
                encrypted.append(item);
            }
            else if(c>='a' && c<='z'){
                char item = (char) ((c-'a' + key)%26 + 'a');
                encrypted.append(item);
            }
            else {
                encrypted.append(c);
            }
        }
        
        System .out.println("Encrypted text: "+encrypted);
    }
    /*
    public void encrypt() {
    StringBuilder encrypted = new StringBuilder();

    for (char c : msg.toCharArray()) {
        if (Character.isLetter(c)) {
            char base = Character.isUpperCase(c) ? 'A' : 'a';
            char item = (char) ((c - base + key) % 26 + base);
            encrypted.append(item);
        } else {
            encrypted.append(c);
        }
    }

    System.out.println("Encrypted text: " + encrypted);
    */
}

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int key = sc.nextInt();
        sc.nextLine();
        
        String msg = sc.nextLine();
        
        Cipher obj = new Cipher(key,msg);
        obj.encrypt();
    }
}

  2.

  Problem Statement



John is managing his stock portfolio and wants to evaluate the performance of a particular stock. He needs to calculate the total value and profit or loss of the stock based on its current price, purchase price and quantity. 



The total value of the stock is calculated by multiplying the current price of the stock by the quantity held. The profit or loss is determined by subtracting the purchase price from the current price and then multiplying the result by the quantity of the stock.



Implement a class Stock to help John input the stock details and compute the required values using classes and objects.

Input format :
The first line of input consists of a string value, representing the stock symbol.

The second line consists of a double value, representing the purchase price.

The third line consists of a double value, representing the current price.

The fourth line consists of an integer value, representing the quantity of the stock.

Output format :
The first line of output prints "Total Portfolio Value: X" where X is a double value, rounded off to two decimal places.

The second line prints "Total Profit/Loss: Y" where Y is a double value, rounded off to two decimal places.



Refer to the sample output for formatting specifications.

Code constraints :
1.0 ≤ purchase, current price ≤ 1000.0

Sample test cases :
Input 1 :
INTC
50.5
38.2
10
Output 1 :
Total Portfolio Value: 382.00
Total Profit/Loss: -123.00
Input 2 :
NVDA
600.0
620.0
7
Output 2 :
Total Portfolio Value: 4340.00
Total Profit/Loss: 140.00
import java.util.*;

class Stock {
    String stockSymbol;
    double purchasePrice;
    double currentPrice;
    int quantity;
    
    void display(){
        double res1 = currentPrice*quantity ;
        System.out.format("Total Portfolio Value: %.2f\n",res1);
        
        double res2 = (currentPrice-purchasePrice)*quantity ;
        System.out.format("Total Profit/Loss: %.2f",res2);
        
    }
}

class main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stock obj = new Stock();
        obj.stockSymbol = sc.nextLine();
        obj.purchasePrice = sc.nextDouble();
        obj.currentPrice = sc.nextDouble();
        obj.quantity = sc.nextInt();
        
        obj.display();
    }
}