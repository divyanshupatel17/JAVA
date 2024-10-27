Problem Statement



As a data analyst for a weather forecasting agency, you have a HashMap storing temperature data for various cities. Each city's entry consists of temperature readings. Your task is to find and report the median temperature, providing a more representative measure of the overall temperature patterns over a specific period.



Note: To calculate the median, sort the numbers in ascending order. If the count is odd, the median is the middle number. If the count is even, the median is the average of the two middle numbers.

Input format :
The input consists of a string representing the city name followed by a double value representing the city's temperature, in separate lines.

The input is terminated by entering "done".

Output format :
The output prints a double value, representing the median rounded off to two decimal places.



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ Length of the City''s Name ≤ 25

1.0 ≤ temperature ≤ 90.0

Sample test cases :
Input 1 :
Mumbai
10.2
Pune
11.5
done
Output 1 :
10.85
Input 2 :
Lucknow
12.5
Jaipur
2.5
Kolkata
20.6
done
Output 2 :
12.50
Note :

import java.util.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        HashMap<String,Double> map = new HashMap<>();
        String city;
        double temp;
        while(true){
            city = sc.nextLine();
            if(city.equals("done")) break;
            temp = Double.parseDouble(sc.nextLine());
            map.put(city,temp);
        }
        
        ArrayList<Double> temps = new ArrayList<>(map.values());
        Collections.sort(temps);
        
        double median;
        int size = temps.size();
        if(size%2 == 1){
            median = temps.get(size/2);
        } else {
            median = (temps.get((size/2)-1) + temps.get(size/2))/2.0f;
        }
        
        System.out.printf("%.2f",median);
        sc.close();
    }
}