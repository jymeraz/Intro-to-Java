/* CS 1101 Intro to Computer Science 
*Instructor: Logan 
*First Lab Assignment 
*Modified and Submitted by: Janeth Meraz
*/

import java.util.Scanner;

public class PracticeLab5{
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        
        int grade;
        String letterGrade;
        
        System.out.print("What is your letter grade? ");
        letterGrade = scanner.nextLine();
        
        switch(letterGrade){
            case "A": 
                grade = 100;
                break;
            case "B":
                grade = 90;
                break;
            case "C":
                grade = 80;
                break;
            case "D":
                grade = 70;
                break;
            default:
                grade = 69;
                break;
        }
        
        System.out.println("You got a " + grade);
    }   
}