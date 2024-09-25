1.
Problem Statement



Mary is managing a business and wants to analyze its profitability. She has a regular business model and a seasonal one. Mary is using a program that calculates and compares the profit margins of both models based on revenue and costs.



The program defines a base class BusinessUtility with a method calculateMargin for calculating the profit margin and a derived class SeasonalBusinessUtility that overrides the margin calculation method to include an additional seasonal adjustment.

.

Note: margin = (revenue − cost)/revenue * 100, seasonal margin = (margin + 10)

Input format :
The first line of input consists of a double value r, representing the revenue.

The second line consists of a double value c, representing the cost.

Output format :
The output should display the regular margin and seasonal margin of the company's business.

If the regular margin is less than 10, print "Business is not profitable.". If it is 10 or greater, print "Business is profitable."

Round off both margins to two decimal places.



Refer to the sample output for formatting specifications.

Code constraints :
In this scenario, the test cases fall under the following constraints:

1.0 ≤ r ≤ 1000.0

1.0 ≤ c ≤ 1000.0

Sample test cases :
Input 1 :
1000.0
800.0
Output 1 :
Regular Margin: 20.00%
Seasonal Margin: 30.00%
Business is profitable.
Input 2 :
1000.0
950.0
Output 2 :
Regular Margin: 5.00%
Seasonal Margin: 15.00%
Business is not profitable.

import java.util.Scanner;

class BusinessUtility {
    protected double revenue;
    protected double cost;

    public BusinessUtility(double revenue, double cost) {
        this.revenue = revenue;
        this.cost = cost;
    }

    public double calculateMargin() {
        return ((revenue - cost) / revenue) * 100;
    }
}

class SeasonalBusinessUtility extends BusinessUtility {

    public SeasonalBusinessUtility(double revenue, double cost) {
        super(revenue, cost);
    }

    @Override
    public double calculateMargin() {
        double regularMargin = super.calculateMargin();
        return regularMargin + 10;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double revenue = sc.nextDouble();
        double cost = sc.nextDouble();

        BusinessUtility regularBusiness = new BusinessUtility(revenue, cost);
        SeasonalBusinessUtility seasonalBusiness = new SeasonalBusinessUtility(revenue, cost);

        double regularMargin = regularBusiness.calculateMargin();
        double seasonalMargin = seasonalBusiness.calculateMargin();

        System.out.printf("Regular Margin: %.2f%%\n", regularMargin);
        System.out.printf("Seasonal Margin: %.2f%%\n", seasonalMargin);

        if (regularMargin < 10.0) {
            System.out.println("Business is not profitable.");
        } else {
            System.out.println("Business is profitable.");
        }

        sc.close();
    }
}


2.

Problem Statement



Shreya is a student who needs to calculate her exam percentage. Her regular percentage is calculated using the formula (obtained marks / total marks) * 100. However, as a scholarship student, she receives an additional 5% bonus on her calculated percentage. 



Write a program that uses an overridden method calculatePercentage to compute both her regular and scholarship percentages.

Input format :
The first line of input consists of an integer n, which represents the total marks in the exam.

The second line consists of an integer m, which represents the marks obtained by the student.

Output format :
The first line of output displays a double value, representing the percentage of marks obtained by the regular student, rounded to two decimal places.

The second line displays a double value, representing the percentage of marks obtained by the scholarship student, rounded to two decimal places.



Refer to the sample output for formatting specifications.

Code constraints :
0 ≤ n ≤ 1200

m < n

Sample test cases :
Input 1 :
500
450
Output 1 :
Student Percentage: 90.00%
Scholarship Student Percentage: 95.00%
Input 2 :
600
300
Output 2 :
Student Percentage: 50.00%
Scholarship Student Percentage: 55.00%

import java.util.Scanner;

class Student {
    private int totalMarks;
    private int obtainedMarks;

    public Student(int totalMarks, int obtainedMarks) {
        this.totalMarks = totalMarks;
        this.obtainedMarks = obtainedMarks;
    }

    public double calculatePercentage() {
        return (double) obtainedMarks / totalMarks * 100;
    }
}
class ScholarshipStudent extends Student {
    public ScholarshipStudent(int totalMarks, int obtainedMarks) {
        super(totalMarks, obtainedMarks);
    }

    @Override
    public double calculatePercentage() {
        return super.calculatePercentage() + 5;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // total marks
        int m = scanner.nextInt(); // obtained marks

        scanner.close();

        Student regularStudent = new Student(n, m);
        ScholarshipStudent scholarshipStudent = new ScholarshipStudent(n, m);

        System.out.printf("Student Percentage: %.2f%%%n", regularStudent.calculatePercentage());
        System.out.printf("Scholarship Student Percentage: %.2f%%%n", scholarshipStudent.calculatePercentage());
    }
}


3.
Problem Statement



Teena's retail store has implemented a Loyalty Points System to reward customers based on their spending. The program includes two classes: Customer and PremiumCustomer.



For regular customers: Loyalty points = amount spent / 10

For premium customers: Loyalty points = 2 * (amount spent / 10)



Calculate and display the loyal points received by the customers using an overridden method calculateLoyaltyPoints.

Input format :
The first line of input consists of an integer representing the amount spent by the customer.

The second line consists of premium customer status (a string) - "yes" if the customer is a premium customer, "no" if they are not.

Output format :
The output displays the loyalty points earned based on the amount spent.



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ amount ≤ 10,000

Sample test cases :
Input 1 :
50
yes
Output 1 :
10
Input 2 :
40
no
Output 2 :
4
'
import java.util.Scanner;

class Customer {
    protected int amountSpent;

    Customer(int amountSpent) {
        this.amountSpent = amountSpent;
    }

    int calculateLoyaltyPoints() {
        return amountSpent / 10;
    }
}

class PremiumCustomer extends Customer {

    PremiumCustomer(int amountSpent) {
        super(amountSpent);
    }

    @Override
    int calculateLoyaltyPoints() {
        return 2 * super.calculateLoyaltyPoints();
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int amount = sc.nextInt();
        String isPremium = sc.next();

        Customer customer;
        if (isPremium.equals("yes")) {
            customer = new PremiumCustomer(amount);
        } else {
            customer = new Customer(amount);
        }

        int loyaltyPoints = customer.calculateLoyaltyPoints();
        System.out.println(loyaltyPoints);
        
        sc.close();
    }
}

4.

Problem Statement



Rithish is developing a straightforward pizza ordering system. To achieve this, he needs a Pizza class with a constructor for the base price and topping cost, along with a calculatePrice method overriding. He also wants a DiscountedPizza class that inherits from Pizza, applying a 10% discount for more than three toppings.



The program prompts the user for inputs, creates instances of both classes, calculates regular and discounted prices, and displays them formatted appropriately.



Example 1



Input:

9.5

1.25

3

Output: 

Price without discount: Rs.13.25

Price with discount: Rs.13.25

Explanation:

Rithish orders a pizza with a base price of Rs. 9.5, a topping cost of Rs. 1.25, and selects 3 toppings. The price is calculated as 9.5 + (1.25 * 3) = 13.25. The regular and discounted prices are both Rs. 13.25, as no discount has been applied.



Example 2



Input:

11.0

2.0

7

Output: 

Price without discount: Rs.25.00

Price with discount: Rs.22.50

Explanation:

Rithish orders another pizza with a higher base price of Rs. 11.0, a topping cost of Rs. 2.0, and chooses 7 toppings. 

Regular Price: 11.0 + (2.0 * 7) = Rs. 25.00.

Discounted Price: The discounted price is calculated as 90% of the regular price, i.e., 0.9 * 25.00 = Rs.22.50. 

Input format :
The first line of input consists of a double value, representing the base price of the pizza.

The second line consists of a double value, representing the cost per topping.

The third line consists of an integer, representing the number of toppings chosen for the pizza.

Output format :
The first line of output prints the price without discount, rounded off to two decimal places.

The second line prints the price with the discount, rounded off to two decimal places.



Refer to the sample output for formatting specifications.

Code constraints :
The base price and the cost per topping should be greater than zero.

1 ≤ number of toppings ≤ 10

Sample test cases :
Input 1 :
9.5
1.25
3
Output 1 :
Price without discount: Rs.13.25
Price with discount: Rs.13.25
Input 2 :
11.0
2.0
7
Output 2 :
Price without discount: Rs.25.00
Price with discount: Rs.22.50

import java.util.Scanner;

// 1 TC falied

class Pizza {
    protected double basePrice;
    protected double toppingCost;
    protected int numberOfToppings;

    Pizza(double basePrice, double toppingCost, int numberOfToppings) {
        this.basePrice = basePrice;
        this.toppingCost = toppingCost;
        this.numberOfToppings = numberOfToppings;
    }

    double calculatePrice() {
        return basePrice + (toppingCost * numberOfToppings);
    }
}

class DiscountedPizza extends Pizza {

    DiscountedPizza(double basePrice, double toppingCost, int numberOfToppings) {
        super(basePrice, toppingCost, numberOfToppings);
    }

    @Override
    double calculatePrice() {
        double regularPrice = super.calculatePrice();
        if (numberOfToppings > 3) {
            return Math.round(regularPrice * 0.9 * 100.0) / 100.0;  // Apply 10% discount and round
        }
        return regularPrice;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double basePrice = sc.nextDouble();
        double toppingCost = sc.nextDouble();
        int numberOfToppings = sc.nextInt();

        Pizza regularPizza = new Pizza(basePrice, toppingCost, numberOfToppings);
        DiscountedPizza discountedPizza = new DiscountedPizza(basePrice, toppingCost, numberOfToppings);

        double regularPrice = Math.round(regularPizza.calculatePrice() * 100.0) / 100.0;
        double discountedPrice = Math.round(discountedPizza.calculatePrice() * 100.0) / 100.0;

        System.out.printf("Price without discount: Rs.%.2f\n", regularPrice);
        System.out.printf("Price with discount: Rs.%.2f\n", discountedPrice);

        sc.close();
    }
}



5.
Problem Statement



Arsh wants to developing a program for an Employee Management System with two classes: Employee and Manager. 



The Employee class holds attributes for name, employee ID, and basic salary, featuring methods for salary calculation and details display. The Manager class, a subclass of Employee, extends functionality by introducing department and bonus attributes and overrides the calculateSalary() and displayDetails() methods. 



The program should input and display employee details and the total salary using the formula (basic salary + bonus).

Input format :
The first line of input consists of a string, representing the employee name.

The second line consists of an integer, representing the employee ID.

The third line consists of a double value, representing the basic salary.

The fourth line consists of a string, representing the department, it contains lowercase and uppercase letters with spaces.

The fifth line consists of a double value, representing the bonus.

Output format :
The output prints the ID, name, basic salary, department, bonus and total salary of the employee. Round off total salary to two decimal places.



Refer to the sample output for the exact text and format.

Code constraints :
1000.00 ≤ basic salary ≤ 10,00,000.00

100.00 ≤ bonus ≤ 10,00,000.00

Sample test cases :
Input 1 :
Paran
1001
50000.45
Sales force
10000.37
Output 1 :
Employee ID: 1001
Name: Paran
Basic Salary: 50000.45
Department: Sales force
Bonus: 10000.37
Total Salary: 60000.82
Input 2 :
Sharon
1501
21089.75
Data Analysis
9550.15
Output 2 :
Employee ID: 1501
Name: Sharon
Basic Salary: 21089.75
Department: Data Analysis
Bonus: 9550.15
Total Salary: 30639.90
Input 3 :
John
3005
250000.70
Computer Science
102000.35
Output 3 :
Employee ID: 3005
Name: John
Basic Salary: 250000.7
Department: Computer Science
Bonus: 102000.35
Total Salary: 352001.05

class Employee {
    String name;
    int employeeId;
    double basicSalary;

    Employee(String name, int employeeId, double basicSalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.basicSalary = basicSalary;
    }

    double calculateSalary() {
        return basicSalary;
    }

    void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Basic Salary: " + basicSalary);
    }
}

class Manager extends Employee {
    String department;
    double bonus;

    Manager(String name, int employeeId, double basicSalary, String department, double bonus) {
        super(name, employeeId, basicSalary);
        this.department = department;
        this.bonus = bonus;
    }

    @Override
    double calculateSalary() {
        return basicSalary + bonus;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Department: " + department);
        System.out.println("Bonus: " + bonus);
        System.out.printf("Total Salary: %.2f\n", calculateSalary());
    }
}

class EmployeeManagement {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        String name = scanner.nextLine();
        int employeeId = scanner.nextInt();
        double basicSalary = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        String department = scanner.nextLine();
        double bonus = scanner.nextDouble();
        
        Manager manager = new Manager(name, employeeId, basicSalary, department, bonus);
        
        manager.displayDetails();
    }
}




6.
Problem Statement



Janani aims to create a versatile palindrome checker capable of handling both numeric values and words. 



The base class, PalindromeChecker, features a parameterized constructor that takes an integer as input. It includes a method, isPalindrome(), which determines whether the given integer is a palindrome. Include a method displayResult() to print the result of the palindrome check for numbers.



The subclass, WordPalindromeChecker, is derived from the base class. This subclass overrides the isPalindrome() method to accommodate word inputs, treating them case-insensitively. The overridden displayResult() method ensures that the outcome of the word palindrome check is appropriately printed.



Create instances of both classes in the main class and display the results.

Input format :
The first line of input consists of an integer.

The second line consists of a string, it contains lowercase and uppercase letters with spaces.

Output format :
If the given integer is a palindrome, the first line of output prints "The number is a palindrome."

Else, print "The number is not a palindrome."

If the given string is a palindrome, the second line of output prints "The word is a palindrome."

Else, print "The word is not a palindrome."



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ input integer ≤ 109

length of string < 50

The strings are case-insensitive.

Sample test cases :
Input 1 :
121
madam
Output 1 :
The number is a palindrome.
The word is a palindrome.
Input 2 :
15651
raar world
Output 2 :
The number is a palindrome.
The word is not a palindrome.
Input 3 :
1563
Malayalam
Output 3 :
The number is not a palindrome.
The word is a palindrome.
Input 4 :
45789
java
Output 4 :
The number is not a palindrome.
The word is not a palindrome.
Input 5 :
1
race
Output 5 :
The number is a palindrome.
The word is not a palindrome.

class PalindromeChecker {
    private int number;

    public PalindromeChecker(int number) {
        this.number = number;
    }

    public boolean isPalindrome() {
        int reversed = 0;
        int original = number;
        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        return original == reversed;
    }

    public void displayResult() {
        if (isPalindrome()) {
            System.out.println("The number is a palindrome.");
        } else {
            System.out.println("The number is not a palindrome.");
        }
    }
}

class WordPalindromeChecker extends PalindromeChecker {
    private String word;

    public WordPalindromeChecker(String word) {
        super(0);
        this.word = word.trim().toLowerCase();
    }

    @Override
    public boolean isPalindrome() {
        int start = 0;
        int end = word.length() - 1;
        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    @Override
    public void displayResult() {
        if (isPalindrome()) {
            System.out.println("The word is a palindrome.");
        } else {
            System.out.println("The word is not a palindrome.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        int number = scanner.nextInt();
        PalindromeChecker numberChecker = new PalindromeChecker(number);
        numberChecker.displayResult();

        scanner.nextLine();
        String word = scanner.nextLine();
        WordPalindromeChecker wordChecker = new WordPalindromeChecker(word);
        wordChecker.displayResult();

        scanner.close();
    }
}
