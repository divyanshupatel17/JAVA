1.
Problem Statement



Amy is tasked with creating a program that manages book details by storing them in files. 



The program should allow users to input book details such as title, author, and publisher, and then store this information in a file named sourcefile.txt. Once the details are stored, the program should copy the content from sourcefile.txt to another file named destinationfile.txt and display the copied content to the user.



Your task is to help Amy in writing the program to accomplish her task.

Input format :
The first line of input consists of a string representing the book's title.

The second line consists of a string representing the author's name.

The third line consists of a string representing the publisher's name.

Output format :
If the details are successfully written to the file, the first line of output prints "Content copied to destinationfile.txt successfully!"

The second line prints "Book Details:"

The third line prints "Title: " followed by a string representing the book's title.

The fourth line prints "Author: " followed by a string representing the author's name.

The fifth line prints "Publisher: " followed by a string representing the publisher's name.



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ Length of the String ≤ 50

Sample test cases :
Input 1 :
Java Programming
John Doe
ABC Publications
Output 1 :
Content copied to destinationfile.txt successfully!
Book Details:
Title: Java Programming
Author: John Doe
Publisher: ABC Publications
Input 2 :
Introduction to Algorithms
Thomas H. Cormen
MIT Press
Output 2 :
Content copied to destinationfile.txt successfully!
Book Details:
Title: Introduction to Algorithms
Author: Thomas H. Cormen
Publisher: MIT Press
Note :

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        String author = sc.nextLine();
        String publisher = sc.nextLine();

        String srcFile = "sourcefile.txt";
        String destFile = "destinationfile.txt";

        // 1. Store initial info in sourcefile.txt
        BufferedWriter writer = new BufferedWriter(new FileWriter(srcFile));
        writer.write("Title: " + title + "\n");
        writer.write("Author: " + author + "\n");
        writer.write("Publisher: " + publisher + "\n");
        writer.close();

        // 2. Copy content from sourcefile.txt to destinationfile.txt
        BufferedReader reader = new BufferedReader(new FileReader(srcFile));
        BufferedWriter writer2 = new BufferedWriter(new FileWriter(destFile));
        String line;
        while ((line = reader.readLine()) != null) {
            writer2.write(line);
            writer2.newLine();
        }
        reader.close();
        writer2.close();

        // 3. Display copied content from destinationfile.txt
        System.out.println("Content copied to destinationfile.txt successfully!");
        System.out.println("Book Details:");

        BufferedReader reader2 = new BufferedReader(new FileReader(destFile));
        while ((line = reader2.readLine()) != null) {
            System.out.println(line);
        }
        reader2.close();

        sc.close();
    }
}


2.
Problem Statement



Cindy is working on a text processing program, and she needs your help. The program is designed to replace all vowels in a given text with a specified consonant. 



Create a file named file1.txt and prompt the user to input a text. Write the user''s input into file1.txt. Then, read the content and perform a specific logic (replacing vowels with a consonant provided by the user), and write the modified result into a new file named file2.txt. Lastly, display the modified result obtained from file2.txt. 

Input format :
The first line of input consists of a string, representing the text that needs vowel replacement.

The second line is a single character value, representing the consonant to replace the vowels with.

Output format :
The output displays the string representing the modified text after replacing the vowels with the specified consonant.



Refer to the sample output for the formatting specifications.

Code constraints :
The string contains lowercase and uppercase with at most 80 characters.

Sample test cases :
Input 1 :
Hello World
X
Output 1 :
HXllX WXrld
Input 2 :
Programming is fun
y
Output 2 :
Prygrymmyng ys fyn
Input 3 :
Apple
r
Output 3 :
rpplr
Note :


import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        String file1 = "file1.txt";
        String file2 = "file2.txt";
        
        // Read input text and consonant
        String str = sc.nextLine();
        char letter = sc.next().charAt(0);
        
        // 1. Write user input to file1.txt
        BufferedWriter writer = new BufferedWriter(new FileWriter(file1));
        writer.write(str);
        writer.close(); // Close writer to flush the data to the file
        
        // 2. Read content from file1.txt
        BufferedReader reader = new BufferedReader(new FileReader(file1));
        String line = reader.readLine();
        reader.close(); // Close reader after reading
        
        // 3. Replace vowels with the specified consonant
        line = line.replace("a", String.valueOf(letter));
        line = line.replace("e", String.valueOf(letter));
        line = line.replace("i", String.valueOf(letter));
        line = line.replace("o", String.valueOf(letter));
        line = line.replace("u", String.valueOf(letter));
        
        // Handle uppercase vowels as well
        line = line.replace("A", String.valueOf(letter));
        line = line.replace("E", String.valueOf(letter));
        line = line.replace("I", String.valueOf(letter));
        line = line.replace("O", String.valueOf(letter));
        line = line.replace("U", String.valueOf(letter));
        
        // 4. Write modified content to file2.txt
        BufferedWriter writer2 = new BufferedWriter(new FileWriter(file2));
        writer2.write(line);
        writer2.close(); // Close writer to flush the data to the file
        
        // 5. Read and display content from file2.txt
        BufferedReader reader2 = new BufferedReader(new FileReader(file2));
        System.out.println(reader2.readLine());
        reader2.close(); // Close reader after displaying
        
        sc.close(); // Close scanner
    }
}

