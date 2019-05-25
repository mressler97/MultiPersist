/* 
 *  Author:     Michael Ressler
 *  Date:       5-24-2019
 *  Program:    Finds the multiplicative persistence of a user-given number
*/

import java.util.Scanner;

class stepCalc {

	public static void main(String args[]) {

        int count = 0;
        long n = 0;

        System.out.println("Enter an integer and see how far you can get --> ");
        
        try
        { 
            Scanner in = new Scanner(System.in);
            n = in.nextLong();  

            System.out.println("You entered the integer " + n);

            multiply(n, count);
        
            System.out.println("Done!");
            in.close();
        } 
        catch(java.util.InputMismatchException x) { 
            System.out.println("Error, invalid entry!"); 
        } 
    }

    public static void multiply(long a, int count) {
        long result = 1;
        String s =  String.format ("%d", a);
        int strLength = s.length();

        if(strLength != 1) {

            for (int i = 0; i < s.length(); ++i) {

                int digit = Math.abs(Character.getNumericValue(s.charAt(i)));
                result *= digit;
            }
            count += 1;

            System.out.println();
            System.out.println("Sub number: " + result);
            multiply(result, count);

        } else {
            System.out.println();
            System.out.println("Total Steps: " + count);
        }
    }
}