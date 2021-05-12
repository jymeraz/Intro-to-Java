/* CS 1101 Intro to Computer Science 
*Instructor: Logan 
*AverageHeight
*Modified and Submitted by: Janeth Meraz
*/

import java.util.Scanner;

public class Example{
    public static void main(String []args){
        //initialize the scanner
        Scanner scnr = new Scanner(System.in);
        
        System.out.print("What is your name? ");
        String name = scnr.nextLine();
        //System.out.println("Hi " + name);
        System.out.print("What is your student ID? ");
        int studentId = scnr.nextInt();
        
        System.out.print("Are you excited for CS1? ");
        boolean isExcited = scnr.nextBoolean();
        if (isExcited) {
            System.out.println("Yay, you're cool!!!");
        } else if (age < 8) {
            System.out.println("Ok...I guess that makes sense.");
        } else {
            System.out.println("Boo ;(");
        }
    }   
}