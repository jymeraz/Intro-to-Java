/* CS 1301 Intro to Computer Science 
*Instructor: Logan 
*Assistant
*Modified and Submitted by: Janeth Meraz
*/

import java.util.Scanner;
import java.util.Random;

public class Assistant{
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        
        //Ask user for name.
        System.out.print("Hello! I am your Assistant, What is your name? ");
        String userName = scanner.nextLine();
        
        //Ask user what action they will like to complete.
        System.out.println("Hi " + userName + " what action will you like to perform?");
        System.out.println("A) Shape calculator \nB) Play rock-paper-scissors \nC) Calculate my overtime pay \nD) Change calculator \nE) Calculate weight in other planets \nF) Nevermind, I dont want to do anything. ");
        String choice = scanner.next();
        //Converts user's answers to all lower case.
        String userChoice = choice.toLowerCase();
        
        //Have different cases based on the user's answer.
        switch (userChoice){
            case "a":
                String shapeAnswer = shapes();
                boxedOutput(userName, shapeAnswer);
                break;
            case "b":
                String gameAnswer = game();
                boxedOutput(userName, gameAnswer);
                break;
            case "c":
                System.out.println("How many hours have you worked this week? ");
                double userHours = scanner.nextDouble();
        
                System.out.println("What is your hourly pay rate? ");
                double payRate = scanner.nextDouble();
        
                String overtimeAnswer = overtime(userHours, payRate);
                boxedOutput(userName, overtimeAnswer);
                break;
            case "d":
                System.out.println("How many nickels do you have?");
                int numberNickels = scanner.nextInt();
        
                System.out.println("How many pennies do you have?");
                int numberPennies = scanner.nextInt();
        
                System.out.println("How many cents do you want to make in total?");
                int totalCents = scanner.nextInt();
        
                String changeAnswer = change(numberNickels, numberPennies, totalCents);
                boxedOutput(userName, changeAnswer);
                break;
            case "e":
                System.out.println("Which planet will you like to know your weight in? Mercury, Venus, or Mars");
                String planetResponse = scanner.next();
        
                System.out.print("What is your current weight in pounds? ");
                double userWeight = scanner.nextInt();
        
                double earthGravity = 9.81; 
        
                String result = weight(planetResponse, userWeight, earthGravity);
                boxedOutput(userName, result);
                break;
            case "f":
                String goodBye = ("See you next time!");
                boxedOutput(userName, goodBye);
                break;
        }  
    }
    //Method creates a box method by taking in two string parameters, one for the user's name and a second for whichever answer they got.
    public static void boxedOutput(String userName, String output){
        System.out.println("### Thank you for using Java Assistant " + userName + "!");
        System.out.println("# " + output);
        System.out.println("### ");
    }  
    //Method to allow user to choose which action to take based on shapes.
    //Return a string type and receive no parameters.
    public static String shapes(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Which shape will you like?");
        System.out.println("A) Calculate the area of a trapezoid \nB) Calculate the hypotenuse of a right triangle \nC) Calculate the surface area of a rectangular pyramid");
        String choice = scanner.next();
        String shapeChoice = choice.toLowerCase();
        String result = "";
        
        //Switch statement based on user's choices.
        switch (shapeChoice){
            case "a":
                System.out.println("Input the length of the top of the trapezoid:");
                double trapezoidTop = scanner.nextDouble();
                
                System.out.println("Input the length of the bottom of the trapezoid:");
                double trapezoidBottom = scanner.nextDouble();
                
                System.out.println("Input the length of the height of the trapezoid:");
                double trapezoidHeight = scanner.nextDouble();
                
                //Assign result with the result of the method.
                result = trapezoid(trapezoidTop, trapezoidBottom, trapezoidHeight);
                
                break;
            case "b":
                System.out.println("Input the length of one side of a right triangle: ");
                double triangleOne = scanner.nextDouble();
                
                System.out.println("Input the length of the other side of a right triangle: ");
                double triangleTwo = scanner.nextDouble();
                
                //Assign result with the result of the method.
                result = triangle(triangleOne, triangleTwo);
                
                break;
            case "c":
                System.out.println("Input the base width of a pyramid: ");
                double baseWidth = scanner.nextDouble();
                
                System.out.println("Input the base length of a pyramid: ");
                double baseLength = scanner.nextDouble();
                
                System.out.println("Input the height of a pyramid: ");
                double pyramidHeight = scanner.nextDouble();
                
                //Assign result with the result of the method.
                result = pyramid(baseWidth, baseLength, pyramidHeight);
                
                break;            
        } 
        return result; 
    }
    //Method to compute the area of a trapezoid. Returns a string and has two double parameters detailing the length of the sides of the trapezoid.
    public static String trapezoid(double top, double bottom, double height){
        double answer = (((top + bottom)/2) * height);
        String trapezoidAnswer = ("The area of the trapezoid is " + answer);
        
        return trapezoidAnswer;
    }
    //Method to compute the hypotenuse of a triangle. Returns a string and takes in two double type parameters. 
    public static String triangle(double firstLeg, double secondLeg){
        double a = Math.pow(firstLeg, 2);
        double b = Math.pow(secondLeg, 2);
        double c = Math.sqrt(a + b);
        
        String triangleAnswer = ("The hypotenuse of the right triangle is " + c);
        
        return triangleAnswer;
    }
    //Method to compute the surface area of a rectangular pyramid. Returns a string and has three double parameters of the pyramid's dimensions. 
    public static String pyramid(double width, double length, double height){
        double firstSum = length * width;
        double secondSum = length * (Math.sqrt((Math.pow((width/2), 2)) + (Math.pow(height, 2))));
        double thirdSum = width * (Math.sqrt((Math.pow((length/2), 2)) + (Math.pow(height, 2))));
        double surfaceArea = firstSum + secondSum + thirdSum;
        
        String pyramidAnswer = ("The surface area of the rectangular prism is " + surfaceArea);
        
        return pyramidAnswer;
    }
    //Method to play rock, paper, scissors. Takes in no parameters and outputs a string.  
    public static String game(){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int userScore = 0;
        int computerScore = 0;
        int numberRound= 1;
        
        //While statement to make the iteration continue while the conditions are true. A game cannot go over 3 rounds or have someone reach more than 2 points to start. 
        while (userScore < 2 && computerScore < 2 && numberRound < 4){
            System.out.println("Round " + numberRound + ": Pick rock, paper, or scissors. ");
            String choice = scanner.next(); 
            String gameChoice = choice.toLowerCase();
            int number = random.nextInt(3);
            
            //Switch statement based on user's choice.
            switch(gameChoice){
                case "rock":
                    if (number == 0){
                        System.out.println("You threw rock and I threw rock. We tied.");
                    } else if (number == 1){
                        System.out.println("You threw rock and I threw paper. I win.");
                        computerScore = computerScore + 1;
                    } else {
                        System.out.println("You threw rock and I threw scissors. You won.");
                        userScore = userScore + 1;
                    }
                break;
                case "paper":
                    if (number == 0){
                        System.out.println("You threw paper and I threw rock. You win.");
                        userScore = userScore + 1;
                    } else if (number == 1){
                        System.out.println("You threw paper and I threw paper. We tied.");
                    } else {
                        System.out.println("You threw paper and I threw scissors. I win.");
                        computerScore = computerScore + 1;
                    }
                break;
                case "scissors":
                    if (number == 0){
                        System.out.println("You threw scissors and I threw rock. I win.");
                        computerScore = computerScore + 1;
                    } else if (number == 1){
                        System.out.println("You threw scissors and I threw paper. You win.");
                        userScore = userScore + 1;
                    } else {
                        System.out.println("You threw scissors and I threw sissors. We tied.");
                    }
                break;
            }
            numberRound = numberRound + 1; 
            
        }
        
        String gameResults = "";
        //If-else statements to output the results of the game. 
        if (userScore >= 2){
            gameResults = ("You won the game!");
        } else if (computerScore >= 2){
            gameResults = ("I won the game!");
        } else if ((userScore == 1) && (computerScore == 1)){
            gameResults = ("We tied the game!");
        } else if (userScore == 1){
            gameResults = ("You won the game!");
        } else if (computerScore == 1 ){
            gameResults = ("I won the game!");
        } else if ((userScore == 0) || (computerScore == 0)){
            gameResults = ("We tied the game!");
        }
        
        return gameResults; 
    }
    //Method to calculate overtime pay. Returns a string and takes in two double parameters to calculate the base pay and the hours worked. 
    public static String overtime(double hours, double rate){
        String overtimePay = "";
        if (hours > 40.0){
            double nonOvertimeHours = 40.0;
            double overtimeMultiplier = 1.50;
            double overtimeHours = hours - 40.0;
            double total = (rate * nonOvertimeHours) + (rate * overtimeMultiplier * overtimeHours);
            overtimePay = ("You will get paid $" + total + " this week!");
        } else if (hours < 40.0){
            double total = rate * hours; 
            overtimePay = ("You will get paid $" + total + " this week!");
        }
        return overtimePay; 
    }
    //Method to calculate change. Returns a string and takes in three int parameters that detail the amount and the goal amount of change. 
    public static String change(int nickels, int pennies, int cents){
        int sumNickels = (5 * nickels);
        int sumTotal = sumNickels + pennies; 
        
        int calculatedNickels = 0;
        int calculatedPennies = 0;
        int centsCopy = cents;
        String changeValue = ""; 
        
        //Calculate how many nickels if the cent amount is greater than the amount of nickels available.
        if (cents > sumTotal){
          changeValue = ("Sorry, you cannot that make that total amount with the cents that you have. ");  
        } else if (cents < sumNickels){
            while (centsCopy >= 5){
                centsCopy = centsCopy - 5 ;
                calculatedNickels++;
            }
            calculatedPennies = cents - (calculatedNickels * 5); 
        } else if (cents > sumNickels) { //Calculare how many nickels and pennies if the cent amount is greater than the amount of nickels available. 
            calculatedNickels = cents / 5;
            calculatedPennies = cents % 5;
            
            int remainerNickels = nickels - calculatedNickels;
            int remainerPennies = pennies - calculatedPennies;
    
            changeValue = ("You can make " + cents + " cents! You will use " + calculatedNickels + " nickels and " + calculatedPennies + " pennies. You will have a remainder of " + remainerNickels + " nickels and " + remainerPennies + " pennies.");
        }
        
        return changeValue; 
    }
    //Method to calculate weight on other planets. Returns a string and has three double parameters detailing the planet choice, current weight, and earth's acceleration. 
    public static String weight(String planet, double weight, double earth){
        double newWeight;
        String planetChoice = planet.toLowerCase();
        String valueWeight = "";
        switch (planetChoice){
            case "mercury":
                newWeight = (weight / earth) * 3.7;
                valueWeight = ("Your weight at " + planet + " would be " + newWeight + " pounds!");
                break; 
            case "venus":
                newWeight = (weight / earth) * 8.87;
                valueWeight = ("Your weight at " + planet + " would be " + newWeight + " pounds!");
                break;
            case "mars":
                newWeight = (weight / earth) * 3.71;
                valueWeight = ("Your weight at " + planet + " would be " + newWeight + " pounds!");
                break;
        }
        return valueWeight;
    }
}