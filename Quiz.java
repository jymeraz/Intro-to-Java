/* CS 1301 Intro to Computer Science 
*Instructor: Logan Chadderdon 
*Quiz
*Modified and Submitted by: Janeth Meraz
*/

import java.util.Scanner;

public class Quiz{
    public static void main(String []args){
        //Initialize the scanner.
        Scanner scanner = new Scanner(System.in);
        int runningScore = 0;
        int totalPoints = 13;
        
        //Scan and save user's name and ID.
        System.out.print("What is your name? ");
        String nameUser = scanner.nextLine();
        System.out.print("What is your student ID? ");
        int studentId = scanner.nextInt();
        System.out.println();
        
        //Open-ended string type question saves user input.
        System.out.println("Question 1: ");
        System.out.print("What is the charge associated with an electron? ");
        String electronCharge = scanner.next();
        System.out.println();
        
        scanner.nextLine();
        //Open-ended string type question saves user input.
        System.out.println("Question 2: ");
        System.out.print("Who discovered that the square root of 2 is irrational? ");
        String irrationalNum = scanner.nextLine();
        System.out.println();
        
        //Open-ended string type question saves user input.
        System.out.println("Question 3: ");
        System.out.print("What is the fifth planet from the Sun? ");
        String fifthPlanet = scanner.next();
        System.out.println();
        
        //Multiple-choice string-type question saves user input.
        System.out.println("Question 4: ");
        System.out.println("What year were pringles made?");
        System.out.println("A) 1824 \nB) 1968 \nC) 1924 \nD) 1999 ");
        String pringlesYear = scanner.next();
        System.out.println();
        
        //Multiple-choice string-type question saves user input.
        System.out.println("Question 5: ");
        System.out.println("Who created Zybooks?");
        System.out.println("A) Brian Napack \nB) Johannes Gutenberg \nC) Smita Bakshi \nD) Agatha Christie ");
        String zybooksCreator = scanner.next();
        System.out.println();
        
        //Question with more than one correct answer in string type.
        System.out.println("Question 6: ");
        System.out.print("Is light considered an atom, particle, element, charge, or a wave? ");
        String lightDebate = scanner.next();
        System.out.println();
        
        //Numeric question with range of correct answers int type.
        //Acceptable answers range from 635-700.
        System.out.println("Question 7: ");
        System.out.print("What is the wavelength of the color red in nm? ");
        int redWave = scanner.nextInt();
        System.out.println();
        
        //Consume \n from the previous integer input.
        scanner.nextLine();
        
        //Question with a multi-part answer in string type.
        System.out.println("Question 8: ");
        System.out.print("If there is a square fence that is 5 inches long on all of its sides, what is the perimeter and what are the correct units? ");
        String boxPerimeter = scanner.nextLine();
        System.out.println();
        
        //Question with a multi-part answer in string type.
        System.out.println("Question 9: ");
        System.out.print("If there are are 4 leaves and 6 butterflies, are there more butterflies or leaves and by how many? ");
        String leavesButter = scanner.nextLine();
        System.out.println();
        
        //Question with a double type.
        System.out.println("Question 10: ");
        System.out.print("What do you get when you multiply 4.5 by 2.3? ");
        double multiplyAnswer = scanner.nextDouble();
        System.out.println();
        
        //Question with a boolean type.
        System.out.println("Question 11: ");
        System.out.print("There are 27 letters in the alphabet. Is this true or false? ");
        boolean alphabetNumbr = scanner.nextBoolean();
        System.out.println();
        
        //Check the answer for the first question.
        if (electronCharge.equals("negative") || electronCharge.equals("Negative")){
            System.out.println("1) " + electronCharge + " is correct! ");
            //Update the current score the user is getting.
            runningScore = runningScore + 1;
        } else {
            System.out.println("1) " + electronCharge + " is incorrect. The correct answer is negative.");
        }
        
        //Check the answer for the second question. 
        if (irrationalNum.equals("pythagoras") || irrationalNum.equals("Pythagoras")){
            System.out.println("2) " + irrationalNum + " is correct! ");
            runningScore = runningScore + 1;
        } else {
            System.out.println("2) " + irrationalNum + " is incorrect. The correct answer is Pythagoras.");
        } 
        
        //Check the answer for the third question.
        if (fifthPlanet.equals("jupiter") || fifthPlanet.equals("Jupiter")){
            System.out.println("3) " + fifthPlanet + " is correct! ");
            runningScore = runningScore + 1;
        } else {
            System.out.println("3) " + fifthPlanet + " is incorrect. The correct answer is Jupiter.");
        } 
        
        //Check the answer for the fourth question. 
        if (pringlesYear.equals("b") || pringlesYear.equals("B")){
            System.out.println("4) " + pringlesYear + " is correct! ");
            runningScore = runningScore + 1;
        } else {
            System.out.println("4) " + pringlesYear + " is incorrect. The correct answer is B.");
        } 
        
        //Check the answer for the fifth question. 
        if (zybooksCreator.equals("c") || zybooksCreator.equals("C")){
            System.out.println("5) " + zybooksCreator + " is correct! ");
            runningScore = runningScore + 1;
        } else {
            System.out.println("5) " + zybooksCreator + " is incorrect. The correct answer is C.");
        } 
        
        //Check the answer for the sixth question. 
        if (lightDebate.equals("particle") || lightDebate.equals("Particle") || lightDebate.equals("wave") || lightDebate.equals("Wave")){
            System.out.println("6) " + lightDebate + " is correct! ");
            runningScore = runningScore + 1;
        } else {
            System.out.println("6) " + lightDebate + " is incorrect. The correct answer is both particle and wave.");
        } 
        
        //Check the answer for the seventh question. 
        if (redWave >= 635 && redWave <= 700) {
            System.out.println("7) " + redWave + " is correct! ");
            runningScore = runningScore + 1;
        } else {
            System.out.println("7) " + redWave + " is incorrect. The correct answer can be any number from 635-700 including the endpoints.");
        } 
    
        //Check the answer for the eighth question. 
        if (boxPerimeter.equals("20 inches") || boxPerimeter.equals("20 Inches")) {
            System.out.println("8) " + boxPerimeter + " is correct! ");
            runningScore = runningScore + 2;
        } else if (boxPerimeter.equals("20") || boxPerimeter.equals("inches") || boxPerimeter.equals("Inches")) {
            System.out.println("8) " + boxPerimeter + " is partially correct! ");
            runningScore = runningScore + 1;
        } else {
            System.out.println("8) " + boxPerimeter + " is incorrect. The correct answers are 20 inches");
        }
        
        //Check the answer for the ninth question. 
        if (leavesButter.equals("2 butterflies") || leavesButter.equals("2 Butterflies") || leavesButter.equals("butterflies 2") || leavesButter.equals("Butterflies 2")) {
            System.out.println("9) " + leavesButter + " is correct! ");
            runningScore = runningScore + 2;
        } else {
            System.out.println("9) " + leavesButter + " is incorrect. The correct answer is 2 butterflies");
        }
        
        //Check the answer for the tenth question. 
        if (multiplyAnswer == 10.35) {
            System.out.println("10) " + multiplyAnswer + " is correct! ");
            runningScore = runningScore + 1;
        } else {
            System.out.println("10) " + multiplyAnswer + " is incorrect. The correct answer is 10.35");
        }
        
        //Check the answer for the eleventh question. 
        if (!alphabetNumbr) {
            System.out.println("11) " + alphabetNumbr + " is correct! ");
            runningScore = runningScore + 1;
        } else {
            System.out.println("11) " + alphabetNumbr + " is incorrect. The correct answer is false");
        }
        
        //Calculate the score that they user gets and change it to a percent.
        System.out.println();
        float percentScore = (runningScore * 100) / totalPoints; 
        
        //Print out the final message to the user about how they did on the quiz.
        System.out.printf("%s, %d, you got %d out of %d points. This gives you a %.2f%%.\n", nameUser, studentId, runningScore, totalPoints, percentScore);
        
        //Calculate the letter grade that the user gets and print it out.
        if (percentScore >= 90){
            System.out.println("Your letter score is an A.");
        } else if (percentScore >= 80){
            System.out.println("Your letter score is a B.");
        } else if (percentScore >= 70){
           System.out.println("Your letter score is a C."); 
        } else if (percentScore >= 60){
           System.out.println("Your letter score is a D."); 
        } else if (percentScore < 60){
           System.out.println("Your letter score is an F."); 
        }   
    }   
}