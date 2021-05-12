/* CS 1101 Intro to Computer Science 
*Instructor: Logan 
*AverageHeight
*Modified and Submitted by: Janeth Meraz
*/

import java.util.Scanner;

public class AverageHeight{
    public static void main(String []args){
        //initialize the scanner
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("What is your name?");
        String nameUser = scnr.nextLine();
        //System.out.println(aString);
        
        System.out.println("What is your height? Input the number of feet and inches separately with no units.");
        System.out.println("Input the number of feet");
        int feetUser = scnr.nextInt();
        System.out.println("Input the remaining inches");
        int inchesUser = scnr.nextInt();
        
        int inchesConverted = feetUser * 12;
        int totalInches = inchesConverted + inchesUser;
        
        System.out.print("Hi " + nameUser);
        System.out.print(", you are in total " + totalInches);
        System.out.println(" inches tall.");
        
        System.out.println("Input someone else's height in inches with no units:");
        int inchesFriend = scnr.nextInt();
        
        float averageInches = (totalInches + inchesFriend) / 2;
        
        System.out.printf("The average height of both of you is: %.2f %n inches", averageInches);
        System.out.print("\n");
    }   
}