import java.util.*;

public class A5_integer_methods {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;

        System.out.println(Integer.max(x, y));  // Expected output: 20 (maximum of 10 and 20)
        System.out.println(Integer.min(x, y));  // Expected output: 10 (minimum of 10 and 20)
        System.out.println(Integer.sum(x, y));  // Expected output: 30 (sum of 10 and 20)
        System.out.println(Integer.compare(x, y));  // Expected output: -1 (because 10 < 20)
        System.out.println(Integer.compare(y, x));  // Expected output: 1 (because 20 > 10)
        System.out.println(Integer.parseInt("100"));  // Expected output: 100 (converts the string "100" to integer)
        System.out.println(Integer.toString(x));  // Expected output: "10" (integer 10 converted to string)
        System.out.println(Integer.valueOf("100"));  // Expected output: 100 (converts string to integer object)
        System.out.println(Integer.toHexString(x));  // Expected output: "a" (10 in hexadecimal)
        System.out.println(Integer.toBinaryString(x));  // Expected output: "1010" (10 in binary)
        System.out.println(Integer.toOctalString(x));  // Expected output: "12" (10 in octal)
        System.out.println(Integer.bitCount(x));  // Expected output: 2 (number of 1-bits in the binary representation of 10)
        System.out.println(Integer.reverse(x));  // Expected output: reversed bits of 10 in binary
        System.out.println(Integer.highestOneBit(x));  // Expected output: 8 (highest one bit of 10 is 8)
        System.out.println(Integer.lowestOneBit(x));  // Expected output: 2 (lowest one bit of 10 is 2)

        int negative = -10;
        System.out.println(Integer.signum(negative));  // Expected output: -1 (sign of negative number is -1)
        System.out.println(Integer.signum(x));  // Expected output: 1 (sign of positive number is 1)
        
        try {
            int result = Integer.divideUnsigned(x, 0); // Will throw an ArithmeticException due to division by zero
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage()); // Expected output: / by zero
        }

        System.out.println(Integer.toUnsignedString(x)); // Expected output: "10" (unsigned string representation of 10)
    }
}
