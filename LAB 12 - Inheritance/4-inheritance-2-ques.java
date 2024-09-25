1.
Problem Statement



A painter needs to determine the cost to paint different shapes based on their surface area. 



Write a program that calculates the area of a sphere and the cost to paint it using three classes: Shape, Area, and Cost. The Shape class should set the shape type and radius, the Area class should extend Shape to calculate the area, and the Cost class should extend Area to calculate the total painting cost.



Formula:

Area of sphere = 4 * pi * r2 , where pi = 3.14
Total painting cost = cost per square meter * area of sphere
Input format :
The input consists of a string representing the shape type, a double value representing the radius, and another double value representing the cost per square meter.

Output format :
If the shape type is 'Sphere', the output prints the area of the sphere and the total painting cost, in separate lines. Round off to two decimal places.

For any other shape types, print "Invalid type".



Refer to the sample output for formatting specifications.

Code constraints :
1.0 ≤ radius ≤ 50.0

1.0 ≤ cost ≤ 10.0

Sample test cases :
Input 1 :
Sphere
3.4
5.8
Output 1 :
Area of Sphere is: 145.19
Cost to paint the shape is: 842.12
Input 2 :
Sphere
50.0
10.0
Output 2 :
Area of Sphere is: 31400.00
Cost to paint the shape is: 314000.00
Input 3 :
Triangle
3.4
2.3
Output 3 :
Invalid type
Input 4 :
sphere
34.6
4.9
Output 4 :
Invalid type


class Shape {
    String shapeType;
    double radius;

    Shape(String shapeType, double radius) {
        this.shapeType = shapeType;
        this.radius = radius;
    }
}

class Area extends Shape {
    Area(String shapeType, double radius) {
        super(shapeType, radius);
    }

    double calculateArea() {
        if (shapeType.equalsIgnoreCase("Sphere")) {
            return 4 * 3.14 * radius * radius;
        }
        return -1;
    }
}

class Cost extends Area {
    double costPerSquareMeter;

    Cost(String shapeType, double radius, double costPerSquareMeter) {
        super(shapeType, radius);
        this.costPerSquareMeter = costPerSquareMeter;
    }

    double calculateTotalCost() {
        double area = calculateArea();
        if (area != -1) {
            return area * costPerSquareMeter;
        }
        return -1;
    }
}

class PainterCostCalculator {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        String shapeType = scanner.nextLine();
        double radius = scanner.nextDouble();
        double costPerSquareMeter = scanner.nextDouble();
        
        Cost cost = new Cost(shapeType, radius, costPerSquareMeter);
        double area = cost.calculateArea();
        double totalCost = cost.calculateTotalCost();
        
        if (area != -1 && totalCost != -1) {
            System.out.printf("Area of Sphere is: %.2f\n", area);
            System.out.printf("Cost to paint the shape is: %.2f\n", totalCost);
        } else {
            System.out.println("Invalid type");
        }
    }
}



2.
Problem Statement



Raj is a software developer tasked with creating a train ticket pricing system for a local railway company using method overriding. The system needs to consider different pricing rules for regular passengers and senior citizens. Senior citizens, aged 60 and above, are eligible for a 10% discount on the regular ticket price.



The calculatePrice method in the SeniorCitizenTicket class overrides the same method in the Ticket class to provide a different implementation for senior citizens.



Formula:

regular price = distance * 0.05

senior discounted price = regular price * 0.9



Example



Input:

120 65

Output:

Senior Citizen Ticket Price: 5.4

Explanation:

Since the passenger's age is 65, which is greater than 60, the person is a senior citizen. The regular ticket price is calculated as 120 * 0.05 = 6.0. The discounted price is then calculated as 90% of the regular price, i.e., 6.0 * 0.9 = 5.4

Input format :
The input consists of two space-separated integers, representing the distance and age respectively.

Output format :
The output prints a double value, representing the ticket price by specifying whether it is a regular or senior citizen ticket.

Round off the price to one decimal place.



Refer to the sample output for the exact text.

Code constraints :
1 ≤ distance ≤ 300

30 ≤ age ≤ 100

Sample test cases :
Input 1 :
120 65
Output 1 :
Senior Citizen Ticket Price: 5.4
Input 2 :
50 30
Output 2 :
Regular Passenger Ticket Price: 2.5
Input 3 :
300 100
Output 3 :
Senior Citizen Ticket Price: 13.5


class Ticket {
    double distance;

    Ticket(double distance) {
        this.distance = distance;
    }

    double calculatePrice() {
        return distance * 0.05;
    }
}

class SeniorCitizenTicket extends Ticket {
    SeniorCitizenTicket(double distance) {
        super(distance);
    }

    @Override
    double calculatePrice() {
        double regularPrice = super.calculatePrice();
        return regularPrice * 0.9; // Apply 10% discount
    }
}

class TrainTicketPricing {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        int distance = scanner.nextInt();
        int age = scanner.nextInt();
        
        if (age >= 60) {
            SeniorCitizenTicket seniorTicket = new SeniorCitizenTicket(distance);
            double price = seniorTicket.calculatePrice();
            System.out.printf("Senior Citizen Ticket Price: %.1f\n", price);
        } else {
            Ticket regularTicket = new Ticket(distance);
            double price = regularTicket.calculatePrice();
            System.out.printf("Regular Passenger Ticket Price: %.1f\n", price);
        }
    }
}

