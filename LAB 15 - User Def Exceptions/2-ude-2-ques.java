1.
Problem Statement



Queency wants to write a program to validate the email address and display suitable exceptions if there is a mistake.



Create 3 custom exception classes as below

DotException
AtTheRateException
DomainException


A typical email address should have a " . " or "@" character, and the domain name should be valid. Valid domain names for practice are 'in', 'com', 'net', or 'biz'.



Display an Invalid Dot usage, Invalid @ usage, or Invalid Domain message based on the email ID.



Get the email address from the user, validate the email by checking the above-mentioned criteria, and print the validity status of the input email address.

Input format :
The input consists of a string representing the email to be validated.

Output format :
If the email is valid, print "Valid email address".

If there is a dot exception, print "DotException: Invalid Dot usage", followed by "Invalid email address".

If there is a rate exception, print "AtTheRateException: Invalid @ usage", followed by "Invalid email address".

If there is a domain exception, print "DomainException: Invalid Domain", followed by "Invalid email address".



Refer to the sample output for the formatting specifications.

Sample test cases :
Input 1 :
sample@gmail.com
Output 1 :
Valid email address
Input 2 :
sample@gmail.com.
Output 2 :
DotException: Invalid Dot usage
Invalid email address
Input 3 :
sample@g@mail.com
Output 3 :
AtTheRateException: Invalid @ usage
Invalid email address
Input 4 :
sample@gmail.con
Output 4 :
DomainException: Invalid Domain
Invalid email address
Note :
Whitelist
Set 1:
DomainException
DotException
AtTheRateException
Exception


import java.util.Scanner;

// Custom exceptions
class DotException extends Exception {
    public DotException(String message) {
        super(message);
    }
}

class AtTheRateException extends Exception {
    public AtTheRateException(String message) {
        super(message);
    }
}

class DomainException extends Exception {
    public DomainException(String message) {
        super(message);
    }
}

class EmailValidator {
    // Method to validate the email
    public void validateEmail(String email) throws DotException, AtTheRateException, DomainException {
        // Check for "@" usage
        if (email.indexOf('@') == -1 || email.indexOf('@') != email.lastIndexOf('@')) {
            throw new AtTheRateException("AtTheRateException: Invalid @ usage");
        }

        // Check for "." usage
        if (email.indexOf('.') == -1 || email.endsWith(".")) {
            throw new DotException("DotException: Invalid Dot usage");
        }

        // Check for valid domain
        String[] parts = email.split("@");
        if (parts.length < 2) {
            throw new DomainException("DomainException: Invalid Domain");
        }

        String domainPart = parts[1];
        String domain = domainPart.substring(domainPart.lastIndexOf('.') + 1);
        if (!domain.equals("in") && !domain.equals("com") && !domain.equals("net") && !domain.equals("biz")) {
            throw new DomainException("DomainException: Invalid Domain");
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();

        EmailValidator validator = new EmailValidator();
        try {
            validator.validateEmail(email);
            System.out.println("Valid email address");
        } catch (DotException | AtTheRateException | DomainException e) {
            System.out.println(e.getMessage());
            System.out.println("Invalid email address");
        }

        scanner.close();
    }
}

2.
Problem Statement



Hemanth is designing a banking system for XYZ Bank. The system should allow customers to perform deposit, withdrawal, and balance inquiry operations. Implement exception handling for scenarios involving invalid transaction amounts or insufficient funds.



Create two custom exception classes, InvalidAmountException and InsufficientFundsException, both extending the Exception class.
Throw an InvalidAmountException with a message if the deposit amount is less than or equal to zero.
Throw an InsufficientFundsException if the withdrawal amount is greater than the available balance.
Deduct the withdrawal amount from the balance if the withdrawal is successful.


Assist Hemanth in designing the program.

Input format :
The first line of input consists of a double value B, representing the initial balance.

The second line consists of a double value D, representing the deposit amount.

The third line consists of a double value W, representing the withdrawal amount.

Output format :
If the withdrawal is successful, print the amount withdrawn and the current balance, rounded off to one decimal place.

If an InvalidAmountException occurs, print "Error: [D] is not valid".

If an InsufficientFundsException occurs, print "Error: Insufficient funds".



Refer to the sample output for formatting specifications.

Sample test cases :
Input 1 :
1050.1
270.2
150.3
Output 1 :
Amount Withdrawn: 150.3
Current Balance: 1170.0
Input 2 :
1500.4
0.0
100.3
Output 2 :
Error: 0.0 is not valid
Input 3 :
10075.7
50000.5
750750.9
Output 3 :
Error: Insufficient funds
Input 4 :
750.2
-456.8
196.5
Output 4 :
Error: -456.8 is not valid
Note :  Whitelist
Set 1:
InvalidAmountException
InsufficientFundsException
try
catch

import java.util.Scanner;

// Custom exception for invalid deposit amounts
class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

// Custom exception for insufficient funds
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Bank class to handle deposits, withdrawals, and balance inquiries
class Bank {
    private double balance;

    public Bank(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Error: " + amount + " is not valid");
        }
        balance += amount;
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Error: Insufficient funds");
        }
        balance -= amount;
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }
}

// Main class to run the banking system
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read initial balance, deposit amount, and withdrawal amount
        double initialBalance = scanner.nextDouble();
        double depositAmount = scanner.nextDouble();
        double withdrawalAmount = scanner.nextDouble();

        Bank bank = new Bank(initialBalance);

        try {
            // Perform deposit
            bank.deposit(depositAmount);

            // Perform withdrawal
            bank.withdraw(withdrawalAmount);

            // Print successful withdrawal message
            System.out.printf("Amount Withdrawn: %.1f%n", withdrawalAmount);
            System.out.printf("Current Balance: %.1f%n", bank.getBalance());
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}


