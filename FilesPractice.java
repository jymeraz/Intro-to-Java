/* CS 1301 Intro to Computer Science 
*Instructor: Logan Chadderdon 
*classPractice
*Modified and Submitted by: Janeth Meraz
*/

import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FilesPractice{
    public static void main(String []args) throws FileNotFoundException {
        FileInputStream fileStream = new FileInputStream("input.txt");
//        Scanner fileScanner = new Scanner(fileStream);
//        String firstLine = fileScanner.nextLine();
//        System.out.println(firstLine);
//        
        getLineCount(fileStream);
        
        
//        try {
//            FileInputStream fileStream = new FileInputStream("input.txt");
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found");
//        }
//        
        
        
        Scanner scanner = new Scanner(System.in);
 //       System.out.println(getIntWhile("Enter your age: "));
//        System.out.print("Enter your age: ");
//        try{
//            int age = scanner.nextInt();
//        } catch (InputMismatchException e){
//            System.out.println("You didnt enter an integer.");
//            e.printStackTrace();
//        }
        
    }
    
    public static void getLineCount(FileInputStream fis) {
        Scanner fileScanner = new Scanner(fis);
        int lineCount = 0; 
        while(fileScanner.hasNextLine()){
            lineCount++;
            fileScanner.nextLine();
        }
        System.out.printf("There are %d lines.\n", lineCount);
    } 
        
        
        
    //Repeadedly ask the user to enter an int, until they enter a valid int
    public static int getInt(String prompt) {
        //nextInt does not "consume" invalid input, so you will probably need to  yourself
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        boolean check; 
        try {
            int age = scanner.nextInt();
            return age;
        } catch (InputMismatchException e){ //**** unchecked/runtime *****
            System.out.println("You didn't enter an integer.");
            return getInt(prompt);
        } 
    }
    public static int getIntWhile(String prompt) {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false; 
        while (true){
            System.out.print(prompt);
            try {
                int age = scanner.nextInt();
                return age;
            } catch (InputMismatchException e){
                scanner.nextLine();  //clear out the scanner
            }
        }
    }

}
