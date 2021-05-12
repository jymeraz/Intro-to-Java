/* CS 1101 Intro to Computer Science 
*Instructor: Logan Chadderdon 
*MyFileReader
*Modified and Submitted by: Janeth Meraz
*/
import java.io.File;
import java.util.Scanner;

public class MyFileReader{
    public static void main(String []args) throws Exception{
        File fileName = new File("testing.txt");
        
        Scanner reading = new Scanner(fileName);
        String inFile = "";
            
        //if (reading.hasNextLine()){
        inFile = reading.nextLine();
        //}
        System.out.println("Contents of this file are " + inFile);
    }
}
