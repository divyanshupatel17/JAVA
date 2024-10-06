public class A3_BaseConversionDemo {

    public static void main(String[] args) {
        // Example number in different bases
        String binaryNumber = "1101";  // Binary (Base 2)
        String hexNumber = "FF";       // Hexadecimal (Base 16)
        String octalNumber = "15";     // Octal (Base 8)
        String decimalNumber = "255";  // Decimal (Base 10)
        
        // 1. Integer.parseInt(String s, int radix)
        // Convert binary number to decimal
        int decimalFromBinary = Integer.parseInt(binaryNumber, 2);
        System.out.println("Binary to Decimal: " + decimalFromBinary);  // Expected Output: 13
        
        // Convert hexadecimal number to decimal
        int decimalFromHex = Integer.parseInt(hexNumber, 16);
        System.out.println("Hexadecimal to Decimal: " + decimalFromHex);  // Expected Output: 255
        
        // Convert octal number to decimal
        int decimalFromOctal = Integer.parseInt(octalNumber, 8);
        System.out.println("Octal to Decimal: " + decimalFromOctal);  // Expected Output: 13

        // 2. Integer.toString(int i, int radix)
        // Convert decimal to binary string
        String binaryFromDecimal = Integer.toString(decimalFromHex, 2);
        System.out.println("Decimal to Binary: " + binaryFromDecimal);  // Expected Output: 11111111 (255 in binary)
        
        // Convert decimal to hexadecimal string
        String hexFromDecimal = Integer.toString(decimalFromHex, 16);
        System.out.println("Decimal to Hexadecimal: " + hexFromDecimal);  // Expected Output: ff (255 in hexadecimal)

        // Convert decimal to octal string
        String octalFromDecimal = Integer.toString(decimalFromHex, 8);
        System.out.println("Decimal to Octal: " + octalFromDecimal);  // Expected Output: 377 (255 in octal)
        
        // 3. Integer.toHexString(int i)
        // Direct conversion to hexadecimal
        String hexString = Integer.toHexString(decimalFromHex);
        System.out.println("Using toHexString: " + hexString);  // Expected Output: ff

        // 4. Integer.toBinaryString(int i)
        // Direct conversion to binary
        String binaryString = Integer.toBinaryString(decimalFromHex);
        System.out.println("Using toBinaryString: " + binaryString);  // Expected Output: 11111111

        // 5. Integer.toOctalString(int i)
        // Direct conversion to octal
        String octalString = Integer.toOctalString(decimalFromHex);
        System.out.println("Using toOctalString: " + octalString);  // Expected Output: 377

        // 6. Integer.valueOf(String s, int radix)
        // This returns an Integer object instead of a primitive int
        Integer integerValue = Integer.valueOf(binaryNumber, 2);
        System.out.println("Binary to Integer Object: " + integerValue);  // Expected Output: 13
    }
}
