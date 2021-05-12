/* CS 1101 Intro to Computer Science 
*Instructor: Logan Chadderdon 
*Loops
*Modified and Submitted by: Janeth Meraz
*/

import java.util.Scanner;

public class Loops{
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to: \nA) Print a song \nB) Print a list of numbers \nIf you don't want to continue anymore, enter -1 ");
        String response = scanner.next();
        String userResponse = response.toLowerCase();
        
        while (userResponse.equals("a") || userResponse.equals("b")){
            switch (userResponse){
                case "a":
                    System.out.print("What kind of beverage? ");
                    String beverage = scanner.next();
                    System.out.print("How many iterations? ");
                    int iteration = scanner.nextInt();
                    songMethod(beverage, iteration);
                    break;
                case "b":
                    System.out.print("What number? ");
                    int userNumber = scanner.nextInt();
                    numList(userNumber);
                    break;
            }
            System.out.println("Do you want to: \nA) Print a song \nB) Print a list of numbers \nIf you don't want to continue anymore, enter -1 ");
            response = scanner.next();
            userResponse = response.toLowerCase();
        }
        System.exit(-1); 
    }
    
    public static void songMethod(String beverage, int iteration){
        for (int i = iteration; i >= 1; i--){
            
            System.out.println(i + " bottles of " + beverage + " on the wall, " + i + " bottles of " + beverage);
            i--;
            System.out.println("Take one down, pass it around, " + i + " bottles of " + beverage + " on the wall. ");
            i++;
        }
    }
    
    public static void numList(int number){
        for (int k = 0; k < 3; k++){
            for (int i = 0; i <= number; i++){
                for (int j = 0; j < 3; j++){
                System.out.print(i); 
                } 
            }
            System.out.println();
        }
    }
}
