/* CS 1101 Intro to Computer Science 
*Instructor: Logan 
*WhatToWatch 
*Modified and Submitted by: Janeth Meraz
*/

import java.util.Scanner;

public class WhatToWatch{
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("What rating will you like the movie to be? G, PG, PG-13, or R?");
        String movieRating = scanner.nextLine();
        
        switch(movieRating){
            case "G": 
                System.out.print("Will you like to watch Cars, Monsters Inc., or WALL-E?");
                String movieChoice = scanner.nextLine();
                System.out.println("We will watch " + movieChoice);
            case "PG":
                System.out.print("Will you like to watch Aladdin, The Lion King, or Dumbo?");
                movieChoice = scanner.nextLine();
                System.out.println("We will watch " + movieChoice);
                break;
            case "PG-13":
                System.out.print("Will you like to watch Titanic, Avatar, or Spider Man?");
                movieChoice = scanner.nextLine();
                System.out.println("We will watch " + movieChoice);
                break;   
            case "R":
                System.out.print("Will you like to watch Joker, Hustlers, or Us?");
                movieChoice = scanner.nextLine();
                System.out.println("We will watch " + movieChoice);
                break;
        } 
    }   
}