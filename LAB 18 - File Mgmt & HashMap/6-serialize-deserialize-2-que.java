1.

Problem Statement



Fiji, a nature enthusiast, is fascinated by the changing seasons and wants to create a program to track the seasons based on birthdays. He wants a program that takes input in the form of a birthday serializes the data, and then deserializes it to determine the corresponding season.



Design a program to create an object of the Birthday class with the provided month and day. Serialize the created object to a file named birthdays.ser. Deserialize the Birthday object from the birthdays.ser file. Display the corresponding season(s) determined by the program after deserialization.



Note:

"Winter" for months 12, 1, and 2.
"Spring" for months 3, 4, and 5.
"Summer" for months 6, 7, and 8.
"Fall" for months 9, 10, and 11.
"Invalid month" for any month outside the valid range of 1 to 12.
Input format :
The input consists of a string containing the month and day of a birthday, separated by space.

Output format :
The output displays the corresponding season("Winter", "Spring", "Summer", "Fall") after deserialization.



Refer to the sample output for the formatting specifications.

Code constraints :
The string contains numbers separated by space with at most 5 characters.

Sample test cases :
Input 1 :
12 15
Output 1 :
Winter
Input 2 :
4 21
Output 2 :
Spring
Input 3 :
6 5
Output 3 :
Summer
Input 4 :
10 18
Output 4 :
Fall
Input 5 :
13 20
Output 5 :
Invalid month
Note :


//  Header Snippet
import java.io.*;
import java.util.Scanner;

// Fill your code here
class Birthday implements Serializable {
    private int m;   
    private int d;
    public Birthday(int m,int d){
        this.m = m;
        this.d = d;
    }
    public String getSeason(){
        String res = null;
        if(m==12 || m==1 || m==2){
            res = "Winter";
        }
        else if(m==3 || m==4 || m==5){
            res = "Spring";
        }
        else if(m==6 || m==7 || m==8){
            res = "Summer";
        }
        else if(m==9 || m==10 || m==11){
            res = "Fall";
        }
        return res;
    }
}

// Footer Snippet
class BirthdayManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            String[] input = scanner.nextLine().split(" ");
            int month = Integer.parseInt(input[0]);
            if (month < 1 || month > 12) {
                System.out.println("Invalid month");
                return;
            }

            int day = Integer.parseInt(input[1]);

            Birthday[] birthdays = { new Birthday(month, day) };

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("birthdays.ser"))) {
                oos.writeObject(birthdays);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("birthdays.ser"))) {
                Birthday[] loadedBirthdays = (Birthday[]) ois.readObject();

                for (Birthday b : loadedBirthdays) {
                    System.out.println(b.getSeason());
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        } finally {
            scanner.close();
        }
    }
}


2.

Problem Statement



Emily, a dedicated student, is keen on tracking her academic performance in various subjects. She wants to create a program that stores information about her grades and categorizes them based on performance. To achieve this, Emily has implemented a program that uses serialization to store and retrieve grade information.



Design a program to create an object of the Grade class with the provided subject and score. Serialize the created object to a file named grades.ser. Deserialize the Grade object from the grades.ser file. Display the performance category determined by the program after deserialization.



Note:

"Excellent" for scores of 90 or above
"Good" for scores above 70
"Needs Improvement" for scores below 70.
Input format :
The input consists of a string value 's', containing a subject and a score separated by a space.

Output format :
The output displays the performance category after deserialization.



Refer to the sample output for the formatting specifications.

Code constraints :
The string s contains uppercase, lowercase, numbers, and spaces with at most 30 characters.

0 ≤ Score ≤ 100

Sample test cases :
Input 1 :
Math 95
Output 1 :
Excellent
Input 2 :
History 80
Output 2 :
Good
Input 3 :
English 60
Output 3 :
Needs Improvement
Note :

// Header Snippet
import java.io.*;

// Fill your code here
class Grade implements Serializable {
    private String subject;
    private int score;
    public Grade(String subject,int score){
        this.subject = subject;
        this.score = score;
    }
    
    public String getPerformanceCategory(){
        if(score >= 90) return "Excellent";
        if(score >= 70) return "Good";
        else return "Needs Improvement";
    }
}

// Footer Snippet
class AcademicPerformanceTracker {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = reader.readLine();
            String[] inputParts = input.split(" ");
            String subject = inputParts[0];
            int score;

            try {
                score = Integer.parseInt(inputParts[1]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid score format. Please enter a valid integer.");
                return;
            }
            Grade userGrade = new Grade(subject, score);
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("grades.ser"))) {
                oos.writeObject(userGrade);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("grades.ser"))) {
                Grade loadedGrade = (Grade) ois.readObject();
                System.out.println(loadedGrade.getPerformanceCategory());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}