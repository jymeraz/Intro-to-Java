/* CS 1101 Intro to Computer Science 
*Instructor: Logan 
*First Lab Assignment 
*Modified and Submitted by: Janeth Meraz
*/

import java.util.Scanner;

public class Love{
    public static void main(String []args){
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Will you be my date to the La Union corn maze on October 5th?");
        String dateAnswer = scanner.nextLine();
        String mazeName = "La Union Maze";
        String dateOct = "10/05/2019"; 
        String choice = "";
        
        if (dateAnswer.equals("Yes") || dateAnswer.equals("yes")){
            System.out.println("Do you want to go in the morning, afternoon, or at night?");
            String dayTime = scanner.nextLine();
            if (dayTime.equals("Morning") || dayTime.equals("morning")){
                System.out.println("Great! Will you like to go to the tire mountain, pick some pumpkins, or pet some animals?");
                choice = scanner.nextLine();
            } else if (dayTime.equals("Afternoon") || dayTime.equals("afternoon")) {
                System.out.println("Great! Will you like to ride some wagons or roast marshmallows at a campfire?");
                choice = scanner.nextLine();
            } else if (dayTime.equals("Night") || dayTime.equals("night")) {
                System.out.println("Great! Will you like to go to the tire mountain or roast marshmallows at a campfire?");
                choice = scanner.nextLine();
            } 
            System.out.println("We're going to " + mazeName + " in the " + dayTime + " at " + dateOct + " to " + choice + ". Happy October Festivities!");
        } else {
            System.out.println("That's okay! Have a great day");
        }
    }   
}