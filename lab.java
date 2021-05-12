/* CS 1101 Intro to Computer Science 
*Instructor: Logan 
*First Lab Assignment 
*Modified and Submitted by: Janeth Meraz
*/

import java.util.Scanner;

public class lab{
    public static void main(String []args){
        
        Scanner scnr = new Scanner(System.in);
        
        System.out.println("Enter the name of the last Computer Science course you have taken");
        String csCourse = scnr.nextLine();
        
        System.out.println("Enter your grade");
        int grade = scnr.nextInt();
        
        if (csCourse.equals("CS1") && grade >= 70){
          System.out.println("You are ready to take CS2");  
        } else {
            System.out.println("CS 1 w/grade of 70 or higher is required before CS2");
        }
        
        
    }   
}