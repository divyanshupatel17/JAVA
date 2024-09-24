1.
Problem Statement



Define a class FuelEfficiency with private double distance and fuelConsumed. Implement a public method setFuelDetails(double dist, double fuel) to set these values and a public method calculateEfficiency() to return the fuel efficiency in km/l. 



Create an object of FuelEfficiency, set the details, and calculate the efficiency.

Input format :
The input consists of two space-separated double values, representing the distance travelled in kilometres and fuel consumed in litres.

Output format :
The output prints the fuel efficiency in kilometres per litre (km/l) rounded off to two decimal places.



Refer to the sample output for formatting specifications.

Code constraints :
1.0 ≤ distance travelled ≤ 1000.0

1.0 ≤ fuel consumed ≤ 500.0

Sample test cases :
Input 1 :
150.45 30.1
Output 1 :
5.00 km/l
Input 2 :
249.75 16.8
Output 2 :
14.87 km/l
import java.util.Scanner;

class FuelEfficiency {
    private double distance;
    private double fuelConsumed;

    public void setFuelDetails(double dist, double fuel) {
        distance = dist;
        fuelConsumed = fuel;
    }

    public double calculateEfficiency() {
        return distance / fuelConsumed;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double distance = scanner.nextDouble();
        double fuelConsumed = scanner.nextDouble();
        
        FuelEfficiency fuelEfficiency = new FuelEfficiency();
        fuelEfficiency.setFuelDetails(distance, fuelConsumed);
        
        double efficiency = fuelEfficiency.calculateEfficiency();
        System.out.printf("%.2f km/l\n", efficiency);
    }
}


2.
Problem Statement



In an Ed-tech company, Reshma needs to manage employee salaries to find the average salary of employees who earn more than a specified threshold. She seeks your assistance in finding the average salary.



Create an Employee class with methods to set and retrieve salary details. Use an array of Employee objects to input details for multiple employees, calculate, and print the average salary of those earning above the given threshold.

Input format :
The first line of input contains an integer n, representing the number of employees.

The next n lines each contain:

A string representing the name of the employee.
A double value representing the salary of the employee.
The last line contains a double value, representing the salary threshold.



Note: Use scanner.nextLine() to consume the newline character after reading the number of employees and salary inputs.

Output format :
The output prints the average salary of employees whose salary is greater than the threshold, rounded off to two decimal places.

If no employees earn more than the threshold, print "No employees earn more than the given threshold."



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ n ≤ 10

Sample test cases :
Input 1 :
2
Arun 
21500.56
Ashok 
1980.67
10000.45
Output 1 :
21500.56
Input 2 :
4
Alice
12750.5
Bob
21089.2
David
43189.2
Charles
23500.7
13758.4
Output 2 :
29259.70
Input 3 :
2
Anna
5000.0
Paul
6000.0
9500.0
Output 3 :
No employees earn more than the given threshold.
import java.util.Scanner;

class Employee {
    private String name;
    private double salary;

    public void setEmployeeDetails(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine(); // To consume the newline after the integer input

        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            employees[i] = new Employee();
            String name = scanner.nextLine();
            double salary = scanner.nextDouble();
            scanner.nextLine(); // To consume the newline after the double input
            employees[i].setEmployeeDetails(name, salary);
        }

        double threshold = scanner.nextDouble();
        double totalSalary = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (employees[i].getSalary() > threshold) {
                totalSalary += employees[i].getSalary();
                count++;
            }
        }

        if (count > 0) {
            double averageSalary = totalSalary / count;
            System.out.printf("%.2f\n", averageSalary);
        } else {
            System.out.println("No employees earn more than the given threshold.");
        }
    }
}


3.
Problem Statement



Scientists are working on stabilizing the energy levels between two parallel universes. Develop a ParallelUniverse class with private variables to store energy levels and public methods to set these levels and calculate the energy transferred and the updated energy levels of both universes. 



Ensure the use of appropriate access specifiers.



Note:

Energy transfer = √(universe1 energy * universe2 energy) * 0.1. Use sqrt() from Math library.

Updated universe1 energy = universe1 energy - energy transfer

Updated universe2 energy = universe2 energy + energy transfer

Input format :
The input consists of two space-separated double values, representing the energy levels of the two universes.

Output format :
The output prints the energy transferred and the updated energy levels of both universes, each rounded off to two decimal places.



Refer to the sample output for formatting specifications.

Code constraints :
1.0 ≤ energy level ≤ 120.0

Sample test cases :
Input 1 :
15.7 28.3
Output 1 :
Energy Transferred: 2.11
Universe 1 Energy: 13.59
Universe 2 Energy: 30.41
Input 2 :
45.8 93.1
Output 2 :
Energy Transferred: 6.53
Universe 1 Energy: 39.27
Universe 2 Energy: 99.63

import java.util.Scanner;
import java.lang.Math;

class ParallelUniverse {
    private double universe1Energy;
    private double universe2Energy;

    // Method to set energy levels of both universes
    public void setEnergyLevels(double energy1, double energy2) {
        this.universe1Energy = energy1;
        this.universe2Energy = energy2;
    }

    // Method to calculate and return the energy transfer value
    public double calculateEnergyTransfer() {
        return Math.sqrt(universe1Energy * universe2Energy) * 0.1;
    }

    // Method to update and display the energy levels of both universes
    public void updateEnergyLevels(double energyTransfer) {
        this.universe1Energy -= energyTransfer;
        this.universe2Energy += energyTransfer;
    }

    // Method to print the energy transferred and updated energy levels
    public void printEnergyDetails(double energyTransfer) {
        System.out.printf("Energy Transferred: %.2f\n", energyTransfer);
        System.out.printf("Universe 1 Energy: %.2f\n", universe1Energy);
        System.out.printf("Universe 2 Energy: %.2f\n", universe2Energy);
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading energy levels of both universes
        double energy1 = scanner.nextDouble();
        double energy2 = scanner.nextDouble();

        // Creating an instance of ParallelUniverse
        ParallelUniverse parallelUniverse = new ParallelUniverse();
        parallelUniverse.setEnergyLevels(energy1, energy2);

        // Calculating energy transfer
        double energyTransfer = parallelUniverse.calculateEnergyTransfer();

        // Updating and printing the energy levels
        parallelUniverse.updateEnergyLevels(energyTransfer);
        parallelUniverse.printEnergyDetails(energyTransfer);
    }
}
