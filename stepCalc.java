/* 
 *  Author:     Michael Ressler
 *  Date:       5-24-2019
 *  Program:    Inspired by the Multiplicative Persistence Challenge, the program takes in a number
 *              and calculates the multiplicative persistence of that number. The world record
 *              multiplicative persistence for the smallest number discovered so far is 11.
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
        String string = "";
		String strNum = string + a;
        int strLength = strNum.length();
        int result = 1;

        if(strLength != 1) {

            for (int i = 0; i < strLength; ++i) {

                int digit = Math.abs(Character.getNumericValue(strNum.charAt(i)));
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