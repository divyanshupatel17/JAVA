import java.util.Arrays;

public class A7_ComprehensiveJavaTypeConversions {
    public static void main(String[] args) {
        // 1. int conversions
        int intValue = 100;
        System.out.println("--- Int Conversions ---");
        
        double intToDouble = intValue; // Automatic conversion
        System.out.println("int to double: " + intToDouble);
        // Expected output: int to double: 100.0
        
        long intToLong = intValue; // Automatic conversion
        System.out.println("int to long: " + intToLong);
        // Expected output: int to long: 100
        
        float intToFloat = intValue; // Automatic conversion
        System.out.println("int to float: " + intToFloat);
        // Expected output: int to float: 100.0
        
        String intToString = Integer.toString(intValue);
        System.out.println("int to String: " + intToString);
        // Expected output: int to String: 100
        
        Integer intToInteger = Integer.valueOf(intValue);
        System.out.println("int to Integer: " + intToInteger);
        // Expected output: int to Integer: 100
        
        char intToChar = (char) intValue;
        System.out.println("int to char: " + intToChar);
        // Expected output: int to char: d

        // 2. double conversions
        double doubleValue = 123.45;
        System.out.println("\n--- Double Conversions ---");
        
        int doubleToInt = (int) doubleValue;
        System.out.println("double to int: " + doubleToInt);
        // Expected output: double to int: 123
        
        long doubleToLong = (long) doubleValue;
        System.out.println("double to long: " + doubleToLong);
        // Expected output: double to long: 123
        
        float doubleToFloat = (float) doubleValue;
        System.out.println("double to float: " + doubleToFloat);
        // Expected output: double to float: 123.45
        
        String doubleToString = Double.toString(doubleValue);
        System.out.println("double to String: " + doubleToString);
        // Expected output: double to String: 123.45
        
        Double doubleToDoubleObject = Double.valueOf(doubleValue);
        System.out.println("double to Double: " + doubleToDoubleObject);
        // Expected output: double to Double: 123.45

        // 3. long conversions
        long longValue = 1000000000000L;
        System.out.println("\n--- Long Conversions ---");
        
        int longToInt = (int) longValue;
        System.out.println("long to int: " + longToInt);
        // Expected output: long to int: -727379968 (due to overflow)
        
        double longToDouble = longValue; // Automatic conversion
        System.out.println("long to double: " + longToDouble);
        // Expected output: long to double: 1000000000000.0
        
        float longToFloat = longValue; // Automatic conversion
        System.out.println("long to float: " + longToFloat);
        // Expected output: long to float: 1.0E12
        
        String longToString = Long.toString(longValue);
        System.out.println("long to String: " + longToString);
        // Expected output: long to String: 1000000000000
        
        Long longToLongObject = Long.valueOf(longValue);
        System.out.println("long to Long: " + longToLongObject);
        // Expected output: long to Long: 1000000000000

        // 4. float conversions
        float floatValue = 12.34F;
        System.out.println("\n--- Float Conversions ---");
        
        int floatToInt = (int) floatValue;
        System.out.println("float to int: " + floatToInt);
        // Expected output: float to int: 12
        
        long floatToLong = (long) floatValue;
        System.out.println("float to long: " + floatToLong);
        // Expected output: float to long: 12
        
        double floatToDouble = floatValue; // Automatic conversion
        System.out.println("float to double: " + floatToDouble);
        // Expected output: float to double: 12.34
        
        String floatToString = Float.toString(floatValue);
        System.out.println("float to String: " + floatToString);
        // Expected output: float to String: 12.34
        
        Float floatToFloatObject = Float.valueOf(floatValue);
        System.out.println("float to Float: " + floatToFloatObject);
        // Expected output: float to Float: 12.34

        // 5. String conversions
        String stringValue = "123";
        System.out.println("\n--- String Conversions ---");
        
        int stringToInt = Integer.parseInt(stringValue);
        System.out.println("String to int: " + stringToInt);
        // Expected output: String to int: 123
        
        double stringToDouble = Double.parseDouble(stringValue);
        System.out.println("String to double: " + stringToDouble);
        // Expected output: String to double: 123.0
        
        long stringToLong = Long.parseLong(stringValue);
        System.out.println("String to long: " + stringToLong);
        // Expected output: String to long: 123
        
        float stringToFloat = Float.parseFloat(stringValue);
        System.out.println("String to float: " + stringToFloat);
        // Expected output: String to float: 123.0
        
        char[] stringToCharArray = stringValue.toCharArray();
        System.out.println("String to char array: " + Arrays.toString(stringToCharArray));
        // Expected output: String to char array: [1, 2, 3]

        // 6. char conversions
        char charValue = 'A';
        System.out.println("\n--- Char Conversions ---");
        
        String charToString = Character.toString(charValue);
        System.out.println("char to String: " + charToString);
        // Expected output: char to String: A
        
        int charToInt = (int) charValue;
        System.out.println("char to int: " + charToInt);
        // Expected output: char to int: 65
        
        Character charToCharObject = Character.valueOf(charValue);
        System.out.println("char to Character: " + charToCharObject);
        // Expected output: char to Character: A

        // 7. Wrapper class conversions
        Integer integerObject = 50;
        System.out.println("\n--- Wrapper Class Conversions ---");
        
        int integerToInt = integerObject.intValue();
        System.out.println("Integer to int: " + integerToInt);
        // Expected output: Integer to int: 50
        
        String integerToString = integerObject.toString();
        System.out.println("Integer to String: " + integerToString);
        // Expected output: Integer to String: 50
        
        double integerToDouble = integerObject.doubleValue();
        System.out.println("Integer to double: " + integerToDouble);
        // Expected output: Integer to double: 50.0
        
        long integerToLong = integerObject.longValue();
        System.out.println("Integer to long: " + integerToLong);
        // Expected output: Integer to long: 50

        // 8. Boolean conversions
        boolean booleanValue = true;
        System.out.println("\n--- Boolean Conversions ---");
        
        String booleanToString = Boolean.toString(booleanValue);
        System.out.println("boolean to String: " + booleanToString);
        // Expected output: boolean to String: true
        
        Boolean booleanToBooleanObject = Boolean.valueOf(booleanValue);
        System.out.println("boolean to Boolean: " + booleanToBooleanObject);
        // Expected output: boolean to Boolean: true

        // 9. Array conversions
        int[] intArray = {1, 2, 3, 4, 5};
        System.out.println("\n--- Array Conversions ---");
        
        String intArrayToString = Arrays.toString(intArray);
        System.out.println("int array to String: " + intArrayToString);
        // Expected output: int array to String: [1, 2, 3, 4, 5]
        
        // 10. String to byte array and back
        String stringForBytes = "Hello";
        byte[] stringToByteArray = stringForBytes.getBytes();
        System.out.println("String to byte array: " + Arrays.toString(stringToByteArray));
        // Expected output: String to byte array: [72, 101, 108, 108, 111]
        
        String byteArrayToString = new String(stringToByteArray);
        System.out.println("byte array to String: " + byteArrayToString);
        // Expected output: byte array to String: Hello
    }
}