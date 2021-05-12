/* CS 1101 Intro to Computer Science 
*Instructor: Logan 
*PracticeLab4
*Modified and Submitted by: Janeth Meraz
*/

import java.util.Scanner;

public class PracticeLab4{
    public static void main(String []args){
        //initialize the scanner
        Scanner scnr = new Scanner(System.in);
        
        //the rest of your code goes here
        //reading a string- words or letters
        System.out.println("Write a string:");
        String aString = scnr.nextLine();
        System.out.println(aString);
        
        //reading an int- whole numbers
        System.out.println("Write an integer:");
        int anInt = scnr.nextInt();
        System.out.println(anInt);
        
        //reading a double- decimal numbers
        System.out.println("Write a double:");
        double aDouble = scnr.nextDouble();
        System.out.println(aDouble);
    }   
}