1.

Problem Statement



Ashok is an HR manager for a growing company. He is tasked with managing the employee information.



Using a HashMap, he must input employee names and their respective salaries. The system then calculates and presents the average salary, aiding in budgeting and resource allocation decisions.



Help him complete this task.

Input format :
The input consists of a string representing the employee name followed by an integer representing the employees salary, in separate lines.

The input is terminated by entering "done".

Output format :
The output prints a double value, representing the average salary of the employees, rounded off to two decimal places.



Refer to the sample output for formatting specifications.

Code constraints :
The given test cases fall under the following constraints:

length of the string < 20

10000 ≤ salary ≤ 100000

Sample test cases :
Input 1 :
Tony
55000
Albert
60000
done
Output 1 :
57500.00
Input 2 :
Alice
25000
Bob
35000
Mark
65500
done
Output 2 :
41833.33
Note :

import java.util.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        HashMap<String,Integer> map = new HashMap<>();
        
        String name;
        int salary, totalSalary = 0;
        while(true){
            name = sc.nextLine();
            if(name.equals("done")) break;
            salary = Integer.parseInt(sc.nextLine());
            map.put(name,salary);
        }
        
        for(int s : map.values()){
            totalSalary += s;
        }
        System.out.printf("%.2f",(double)totalSalary/(double)map.size());
    }
}

// // 1. Iterate over values
// for (int s : map.values()) {
//     System.out.println("Salary: " + s);
// }

// // 2. Iterate over keys
// for (String name : map.keySet()) {
//     System.out.println("Employee Name: " + name);
// }

// // 3. Iterate over entries (both keys and values)
// for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
//     System.out.println("Employee Name: " + entry.getKey() + ", Salary: " + entry.getValue());
// }


2.

Problem Statement



Tony is an e-learning platform administrator, he oversees the user ratings for various online courses offered in the platform. 



To enhance user experience, you should assist him in utilizing a HashMap to store course ratings given by learners. Regularly, he analyzes this data to identify the highest and lowest-rated courses, enabling targeted improvements and ensuring the quality of the educational content. This process assists in maintaining a competitive and engaging online learning environment for the users.

Input format :
The input consists of a string representing the course name followed by a double value representing the courses rating, in separate lines.

The input is terminated by entering "done".

Output format :
The first line of output prints the string "Highest Rated Course: " followed by the highest-rated course.

The second line prints the string "Lowest Rated Course: " followed by the lowest-rated courses.



Refer to the sample output for formatting specifications.

Code constraints :
The given test cases fall under the following constraints:

1 ≤ Length of the String ≤ 25

0.0 ≤ rating ≤ 5.0

Sample test cases :
Input 1 :
DSA
4.0
OOPS
4.2
C
3.2
done
Output 1 :
Highest Rated Course: OOPS
Lowest Rated Course: C
Input 2 :
Accounting & Finance
3.7
Art & Design
4.2
Architecture
3.9
done
Output 2 :
Highest Rated Course: Art & Design
Lowest Rated Course: Accounting & Finance
Note :

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        HashMap<String, Double> courseRatings = new HashMap<>();
        
        String courseName;
        double rating;

        while (true) {
            courseName = sc.nextLine();
            if (courseName.equals("done")) break;
            
            rating = Double.parseDouble(sc.nextLine());
            courseRatings.put(courseName, rating);
        }

        String highestRatedCourse = "";
        String lowestRatedCourse = "";
        double maxRating = Double.MIN_VALUE;
        double minRating = Double.MAX_VALUE;

        for (Map.Entry<String, Double> entry : courseRatings.entrySet()) {
            String course = entry.getKey();
            double courseRating = entry.getValue();
            
            if (courseRating > maxRating) {
                maxRating = courseRating;
                highestRatedCourse = course;
            }
            
            if (courseRating < minRating) {
                minRating = courseRating;
                lowestRatedCourse = course;
            }
        }

        System.out.println("Highest Rated Course: " + highestRatedCourse);
        System.out.println("Lowest Rated Course: " + lowestRatedCourse);
        
        sc.close();
    }
}
