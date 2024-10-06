import java.util.*;

public class A1_string_methods {
    public static void main(String[] args) {
        // Creating a Scanner object to take user input (though not used here)
        Scanner sc = new Scanner(System.in);
        sc.close();

        // StringBuilder to perform mutable string operations
        StringBuilder sb = new StringBuilder(10);
        sb.append("Divyanshu"); // Appends "Divyanshu" to StringBuilder
        sb.append(" Patel");    // Appends " Patel" to StringBuilder
        sb.insert(0, "I'm ");   // Inserts "I'm " at the beginning
        System.out.println(sb.delete(9, 13));  // Deletes "Patel", expected output: "I'm Divyanshu"

        // String object for performing immutable string operations
        String st = "   AbcDb   "; // A string with leading and trailing spaces
        System.out.println(st.toUpperCase());  // Converts to uppercase: "   ABCDB   "
        System.out.println(st.toLowerCase());  // Converts to lowercase: "   abcdb   "
        System.out.println(st.concat("@gmail.com")); // Concatenates with another string: "   AbcDb   @gmail.com"
        System.out.println(st.replace("b", "x"));  // Replaces 'b' with 'x': "   AxcDx   "
        System.out.println(st.trim());  // Removes leading and trailing spaces: "AbcDb"
        System.out.println(Arrays.toString(st.toCharArray())); // Converts to char array: "[ ,  ,  , A, b, c, D, b,  ,  ,  ]"

        // Additional String functions
        System.out.println(st.charAt(2));  // Returns the char at index 2: ' ' (space)
        System.out.println(st.indexOf("a"));  // Index of first occurrence of 'a': -1 (since 'a' is lowercase)
        System.out.println(st.lastIndexOf("a")); 
        System.out.println(st.indexOf("z"));  // Index of 'z', which is not present: -1
        System.out.println(st.length());  // Length of the string, including spaces: 10
        System.out.println(st.toString());  // Returns the string itself: "   AbcDb   "
        System.out.println(st.substring(2));  // Substring from index 2: " AbcDb   "
        System.out.println(st.substring(2, 3));  // Substring from index 2 to 3: " " (space)
        System.out.println(st.contains("c"));  // Checks if 'c' is present: true
        System.out.println(st.endsWith("d"));  // Checks if it ends with 'd': false (ends with spaces)
        System.out.println(st.startsWith("a"));  // Checks if it starts with 'a': false (starts with spaces)
        System.out.println(st.isEmpty());  // Checks if the string is empty: false

        // Additional String methods
        String exampleStr = "madam"; // Example string for additional methods

        // String reverse using StringBuilder
        StringBuilder rev = new StringBuilder(exampleStr);
        System.out.println(rev.reverse().toString());  // Reverses the string: "madam" (palindrome)

        // String equals to compare content
        System.out.println(exampleStr.equals("madam"));  // Returns true as both strings are identical

        // String equalsIgnoreCase to compare ignoring case
        System.out.println(exampleStr.equalsIgnoreCase("MADAM"));  // Returns true ignoring case differences

        // Compare two strings lexicographically
        System.out.println(exampleStr.compareTo("apple"));  // Compares lexicographically, returns positive (m > a)

        // Check if string is blank (since Java 11)
        System.out.println("  ".isBlank());  // Returns true for strings containing only whitespace

        // Check if string is empty
        System.out.println("".isEmpty());  // Returns true for an empty string

        // Convert integer to string
        int num = 123;
        System.out.println(String.valueOf(num));  // Converts int to string: "123"

        // Reverse string manually (without StringBuilder)
        System.out.println(reverseString(exampleStr));  // Custom function to reverse a string: "madam"

        // Exception handling with try-catch-finally block
        int x = 10; // Define a variable `x`
        try {
            int a = x / 0; // This will cause an ArithmeticException (division by zero)
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace when an exception occurs
        } finally {
            System.out.println("always printed"); // This block always executes
        }
    }

    // Custom method to reverse a string manually
    public static String reverseString(String input) {
        char[] charArray = input.toCharArray(); // Convert string to char array
        int left = 0, right = input.length() - 1;

        // Swap characters from both ends
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }

        return new String(charArray); // Convert char array back to string
    }
}
