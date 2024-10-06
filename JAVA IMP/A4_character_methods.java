import java.util.*;

public class A4_character_methods {
    public static void main(String[] args) {
        char ch = 'A';
        
        System.out.println(Character.isLetter(ch));  // Expected output: true (because 'A' is a letter)
        System.out.println(Character.isDigit(ch));   // Expected output: false (because 'A' is not a digit)
        System.out.println(Character.isLowerCase(ch)); // Expected output: false (because 'A' is uppercase)
        System.out.println(Character.isUpperCase(ch)); // Expected output: true (because 'A' is uppercase)
        System.out.println(Character.toLowerCase(ch)); // Expected output: 'a' (converts 'A' to lowercase)
        System.out.println(Character.toUpperCase('a')); // Expected output: 'A' (converts 'a' to uppercase)
        System.out.println(Character.isWhitespace(' ')); // Expected output: true (space is considered whitespace)
        System.out.println(Character.isLetterOrDigit('1')); // Expected output: true (because '1' is a digit)
        System.out.println(Character.isJavaIdentifierStart('A')); // Expected output: true (can start a Java identifier)
        System.out.println(Character.isJavaIdentifierPart('1')); // Expected output: true (can be part of a Java identifier)
        System.out.println(Character.isSpaceChar(' '));  // Expected output: true (space is a space character)
        System.out.println(Character.getNumericValue('7')); // Expected output: 7 (numeric value of character '7')
        System.out.println(Character.forDigit(10, 16)); // Expected output: 'a' (digit 10 in base 16 is 'a')
        System.out.println(Character.compare('a', 'b')); // Expected output: -1 (because 'a' < 'b')
        System.out.println(Character.toString('A')); // Expected output: "A" (character converted to string)
        
        char[] charArray = {'H', 'e', 'l', 'l', 'o'};
        System.out.println(Arrays.toString(charArray));  // Expected output: "[H, e, l, l, o]" (prints array as string)
    }
}
