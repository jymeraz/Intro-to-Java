/* CS 1101 Intro to Computer Science 
*Instructor: Logan 
*RollerCoaster
*Modified and Submitted by: Janeth Meraz
*/

import java.util.Scanner;

public class RollerCoaster{
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("What is your age?");
        int age = scanner.nextInt();
        
        boolean goodHealth = true
        
        if ( age >= 65) {
            System.out.print("Are you in good health?");
            goodHealth = scanner.nextBoolean();
        }
        
        if (!goodHealth){
            System.out.print("You cannot ride :(");
        }
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("How old are you?");
//        int userAge = scanner.nextInt();
//        
//        System.out.println("How tall are you (in inches)?");
//        int userHeight = scanner.nextInt();
//        
//        if (userAge > 65){
//            System.out.println("Are you in good health? true/false");
//            boolean userHealth = scanner.nextBoolean();
//            
//            if (!userHealth){
//            System.out.println("You are not able to ride this ride because you are not in good health.");
//            } else {
//                System.out.println("You can ride this ride!");
//            }
//        } else if (userAge < 18 && userHeight < 48){
//            System.out.println("You are not able to ride this ride. You are under 18 years old and you are under 48 inches.");  
//        } else if (userAge < 18 && userHeight >= 48){
//            System.out.println("You are able to ride this ride but only with supervision."); 
//        } else if (userAge > 18 && userHeight < 48){
//            System.out.println("You are able to ride this ride but only if you sign a waiver."); 
//        } else if (userAge > 18 && userHeight > 48){
//            System.out.println("You are able to ride this ride!!"); 
//        }    
    }
}