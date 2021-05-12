/* CS 1301 Intro to Computer Science 
*Instructor: Logan 
*Homework2
*Modified and Submitted by: Janeth Meraz
*/

import java.util.Scanner;

public class Homework2{
    public static void main(String []args){
        //initialize the scanner
        Scanner scnr = new Scanner(System.in);
        
        //Scan and save user's name and ID
        System.out.print("What is your name? ");
        String name = scnr.nextLine();
        System.out.print("What is your student ID? ");
        int studentId = scnr.nextInt();
        
        //3 open-ended questions
        System.out.print("What is the charge associated with an electron? ");
        String electronCharge = scnr.nextLine();
        System.out.print("Who discovered that the square root of 2 is irrational? ");
        String irrationalNum = scnr.nextLine();
        System.out.print("What is the genus and species of people today? ");
        String genusSpecies = scnr.nextLine();
        
        //2 multiple-choice questions
        System.out.print("What year were pringles made? ");
        System.out.print("A) 1824 \n B) 1968 \n C) 1924 \n D) 1999 ");
        String pringlesYear = scnr.next();
        System.out.print("What year were pringles made? ");
        System.out.print("A) 1824 \n B) 1968 \n C) 1924 \n D) 1999 ");
        String pringlesYear = scnr.next();
        
        //1 question with more than one correct answer
        System.out.print("Is light considered an atom, particle, element, charge, or a wave? ");
        String lightDebate = scnr.nextLine();
        
        //1 numeric question with range of correct answers
        //acceptable answer 700-635
        System.out.print("What is the wavelength of the color red in nm? ");
        String redWave = scnr.nextInt();
        
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