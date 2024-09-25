1.
Problem Statement



Oviya is fascinated by automorphic numbers and wants to create a program to determine whether a given number is an automorphic number or not.



An automorphic number is a number whose square ends with the same digits as the number itself. For example, 25 = (25)2 = 625 



Oviya has defined two interfaces, NumberInput for taking user input and AutomorphicChecker for checking if a given number is automorphic. The class AutomorphicNumber implements both interfaces.



Help her to complete the task.

Input format :
The input consists of a single integer n.

Output format :
If the input number is an automorphic number, print "n is an automorphic number".

Otherwise, print "n is not an automorphic number".



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ n ≤ 500

Sample test cases :
Input 1 :
25
Output 1 :
25 is an automorphic number
Input 2 :
7
Output 2 :
7 is not an automorphic number
Note :  Whitelist
Set 1:
interface
NumberInput
AutomorphicChecker

import java.util.Scanner;

interface NumberInput {
    int getInput();
}

interface AutomorphicChecker {
    boolean isAutomorphic(int number);
}

class AutomorphicNumber implements NumberInput, AutomorphicChecker {
    @Override
    public int getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public boolean isAutomorphic(int number) {
        int square = number * number;
        String numberStr = String.valueOf(number);
        String squareStr = String.valueOf(square);
        return squareStr.endsWith(numberStr);
    }
}

class Main {
    public static void main(String[] args) {
        AutomorphicNumber automorphicNumber = new AutomorphicNumber();
        int n = automorphicNumber.getInput();
        
        if (automorphicNumber.isAutomorphic(n)) {
            System.out.println(n + " is an automorphic number");
        } else {
            System.out.println(n + " is not an automorphic number");
        }
    }
}


2.
Problem Statement



Alex and Bob are designing a control system for household appliances, and one of the appliances is a washing machine. You want to create a program to help them that models the washing machine as a motor and calculates its electricity consumption based on its capacity.



Define an interface named Motor with the following methods:

void run() 
double consume(double capacity)


Create a class called WashingMachine that implements the Motor interface. 



In the WashingMachine class:

Implement the run() method to print "Washing machine is running."
Implement a consume() method to print "Washing machine is consuming electricity."
Implement the consume(double capacity) method to calculate the electricity consumption (in kWh) of the washing machine based on its capacity. The formula for electricity consumption is (capacity * 0.05).
Input format :
The input consists of a double value representing the capacity of the washing machine in kW.

Output format :
The first line of output prints "Washing machine is running."

The second line prints "Washing machine is consuming electricity."

The third line prints "Electricity consumption: X kWh" where X is a double value, rounded off to two decimal places, representing the electricity consumption.



Refer to the sample output for formatting specifications.

Code constraints :
0.00 ≤ capacity ≤ 10.00

Sample test cases :
Input 1 :
2.5
Output 1 :
Washing machine is running.
Washing machine is consuming electricity.
Electricity consumption: 0.13 kWh
Input 2 :
0.895
Output 2 :
Washing machine is running.
Washing machine is consuming electricity.
Electricity consumption: 0.04 kWh
Note :  Whitelist
Set 1:
interface
Motor
class
WashingMachine

import java.util.Scanner;

interface Motor {
    void run();
    double consume(double capacity);
}

class WashingMachine implements Motor {
    @Override
    public void run() {
        System.out.println("Washing machine is running.");
    }

    @Override
    public double consume(double capacity) {
        System.out.println("Washing machine is consuming electricity.");
        return capacity * 0.05;
    }

    public void displayConsumption(double capacity) {
        double consumption = consume(capacity);
        System.out.printf("Electricity consumption: %.2f kWh%n", consumption);
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double capacity = scanner.nextDouble();
        
        WashingMachine washingMachine = new WashingMachine();
        washingMachine.run();
        washingMachine.displayConsumption(capacity);
        
        scanner.close();
    }
}


3
Problem Statement



Ashok is writing a program that focuses on calculating and displaying the calories burned during a workout for a fitness enthusiast. He has certain specifications as follows.



Implement a class structure with a base class Person and a derived class FitnessEnthusiast that inherits from Person. The program should take user input for the fitness enthusiast's name, workout duration (in minutes), and calorie burn rate (calories burned per minute).



Create a constructor for the FitnessEnthusiast class to initialize the name, workout duration, and calorie burn rate. Utilize the super keyword to invoke the constructor of the superclass. 



Implement a method that calculates the calories burned during the workout using the formula (workout duration * calories burn rate). Display the calculated calories burned.



Help Ashok to complete the program. 

Input format :
The first line of input consists of a string, representing the name.

The second line consists of an integer, representing the workout duration in minutes.

The third line consists of a double value, representing the calorie burn rate.

Output format :
The output prints "Calories Burned: X calories", where X is a double value, representing the calories burned, rounded off to one decimal place.



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ workout duration ≤ 1200

1.00 ≤ calorie burn rate ≤ 50.00

Sample test cases :
Input 1 :
Dinesh
30
9.7
Output 1 :
Calories Burned: 291.0 calories
Input 2 :
Sharon
120
28.14
Output 2 :
Calories Burned: 3376.8 calories
Note : image
Whitelist
Set 1:
class
Person
FitnessEnthusiast
super

'
import java.util.Scanner;

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }
}

class FitnessEnthusiast extends Person {
    int workoutDuration;
    double calorieBurnRate;

    FitnessEnthusiast(String name, int workoutDuration, double calorieBurnRate) {
        super(name);
        this.workoutDuration = workoutDuration;
        this.calorieBurnRate = calorieBurnRate;
    }

    double calculateCaloriesBurned() {
        return workoutDuration * calorieBurnRate;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int workoutDuration = scanner.nextInt();
        double calorieBurnRate = scanner.nextDouble();

        FitnessEnthusiast fitnessEnthusiast = new FitnessEnthusiast(name, workoutDuration, calorieBurnRate);
        double caloriesBurned = fitnessEnthusiast.calculateCaloriesBurned();

        System.out.printf("Calories Burned: %.1f calories%n", caloriesBurned);
        scanner.close();
    }
}
