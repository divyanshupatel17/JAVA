1.
Problem Statement



Vimal is a network engineer tasked with managing a large companys IP address allocations. To optimize the network, he needs to determine the number of possible subnets based on a given IP address and subnet mask. 



Vimal decides to write a program that calculates the number of subnets using a parameterized method named calculateSubnets, which takes the IP address and subnet mask as input.

Input format :
The first line of input consists of a String, representing the IP address (e.g., in the format A.B.C.D).

The second line of input consists of a String, representing the subnet mask, which is in CIDR notation (e.g., /24)

Output format :
The output displays "Number of Subnets: " followed by an integer representing the number of subnets that can be created from the given subnet mask.



Refer to the sample output for the formatting specifications.

Code constraints :
In this scenario, the test cases fall under the following constraints:

The IP address and subnet mask are provided in valid formats.

For the subnet mask, is provided in the CIDR notation ("/N").

The IP address and subnet mask should be in the valid range (0-255).

Sample test cases :
Input 1 :
192.168.1.0
/24
Output 1 :
Number of Subnets: 256
Input 2 :
10.0.0.0
/8
Output 2 :
Number of Subnets: 16777216
Input 3 :
172.16.0.0
/16
Output 3 :
Number of Subnets: 65536

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read the IP address (not used for this calculation)
        String ip = sc.nextLine();
        
        // Read the subnet mask in CIDR format
        String subnet = sc.nextLine();
        
        // Calculate and print the number of subnets
        System.out.println("Number of Subnets: " + calculateSubnets(ip, subnet));
        
        sc.close();
    }
    
    // Method to calculate the number of subnets based on the CIDR subnet mask
    public static int calculateSubnets(String ip, String subnet) {
        // Extract the subnet prefix length (remove the '/' and convert to an integer)
        int cidr = Integer.parseInt(subnet.substring(1));
        
        // Calculate the number of subnets: 2^(32 - CIDR)
        int availableHostBits = 32 - cidr;
        int numberOfSubnets = (int) Math.pow(2, availableHostBits);
        
        return numberOfSubnets;
    }
}

2.

Problem Statement



Viraj is learning about permutations and wants to develop a program that can generate all possible permutations of a given string. The goal is to rearrange the characters of the string in every possible way and print each unique permutation.



Help Viraj to include a parameterized method named generatePermutations to accomplish this task.

Input format :
The input consists of a string, representing Virajs input.

Output format :
The first line of output displays "Permutations of the string:"

The next line displays all unique permutations of the string, each on a new line.



Refer to the sample output for the formatting specifications.

Code constraints :
The string contains both uppercase and lowercase characters with at most 8 characters.

Sample test cases :
Input 1 :
abc
Output 1 :
Permutations of the string:
abc
acb
bac
bca
cab
cba
Input 2 :
ab12
Output 2 :
Permutations of the string:
ab12
ab21
a1b2
a12b
a2b1
a21b
ba12
ba21
b1a2
b12a
b2a1
b21a
1ab2
1a2b
1ba2
1b2a
12ab
12ba
2ab1
2a1b
2ba1
2b1a
21ab
21ba

// approach 1
import java.util.*;

class StringPermutations {
    public static void main(String[] args) {
        // Scanner to take input from the user
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();  // Read the input string
        scanner.close();  // Close the scanner to avoid resource leak

        // Print message indicating we're displaying permutations
        System.out.println("Permutations of the string:");
        
        // Call the method to generate and print all permutations
        generatePermutations(input);
    }

    // Method to initiate the recursive generation of permutations
    public static void generatePermutations(String str) {
        // Start with an empty prefix and the full string as remaining
        generatePermutationsHelper("", str);
    }

    // Recursive helper method to generate permutations
    private static void generatePermutationsHelper(String prefix, String remaining) {
        int n = remaining.length();  // Get the length of the remaining string
        // If no characters are left, we have a complete permutation
        if (n == 0) {
            System.out.println(prefix);  // Print the generated permutation
        } else {
            // Loop through each character in the remaining string
            for (int i = 0; i < n; i++) {
                // Recursive call to generate permutations with the current character
                // added to the prefix and the rest of the characters as remaining
                generatePermutationsHelper(
                    prefix + remaining.charAt(i),  // Add current character to prefix
                    remaining.substring(0, i) + remaining.substring(i + 1, n)  // Exclude the current character
                );
            }
        }
    }
}
