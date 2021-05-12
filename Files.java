/* CS 1301 Intro to Computer Science
 *Instructor: Logan Chadderdon
 *Files
 *Modified and Submitted by: Janeth Meraz
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Files {
  public static void main(String[] args) throws FileNotFoundException, IOException {
    Scanner scanner = new Scanner(System.in);
    // Ask user if they want to indent or madlib.
    System.out.println("What would you like to do? (indent or madlib) ");
    String userResponse = scanner.nextLine();
    // Convert string to lowercase.
    String lowerCaseResponse = userResponse.toLowerCase();

    // Loop the question until indent or madlib is inputted.
    while (!lowerCaseResponse.equals("indent") && !lowerCaseResponse.equals("madlib")) {
      System.out.println("What would you like to do? (indent or madlib) ");
      userResponse = scanner.nextLine();
      lowerCaseResponse = userResponse.toLowerCase();
    }

    // Send user choice to a method.
    if (lowerCaseResponse.equals("indent")) {
      // Call the indent method if the user inputted indent.
      // Send contents of file to indent.
      indent(fileLoop(lowerCaseResponse));
    } else {
      // Call the madlib method if the user inputted method.
      // Send contents of file to madlib.
      madlib(fileLoop(lowerCaseResponse));
    }
  }

  // Recursively call the function until a file is found.
  // Output FileInputStream to send back to main.
  public static FileInputStream fileLoop(String choice) /*throws IOException*/ {
    Scanner scanner = new Scanner(System.in);
    FileInputStream fileStream;
    String inputFile = "";
    // Ask for the name if the java file if choice is equal to indent.
    if (choice.equals("indent")) {
      System.out.println("What is the name of the input Java file? ");
      inputFile = scanner.next();
      // Check if the file exists.
      try {
        fileStream = new FileInputStream(inputFile);
        // Return the contents of the file.
        return fileStream;
      } catch (FileNotFoundException e) {
        // If file is not found, print an error message.
        System.out.println("File not found");
        // Return a call to the function that will prompt the user to input a file again.
        return fileLoop(choice);
      }

      // Ask for the name if the java file if choice is equal to madlib.
    } else {
      System.out.println("What is the name of the input Madlib file? ");
      inputFile = scanner.next();
      // Check if the file exists.
      try {
        fileStream = new FileInputStream(inputFile);
        // Return the contents of the file.
        return fileStream;
      } catch (FileNotFoundException e) {
        // If file is not found, print an error message.
        System.out.println("File not found");
        // Return a call to the function that will prompt the user to input a file again.
        return fileLoop(choice);
      }
    }
  }

  // Take in a file and output the file with the correct indentation.
  public static void indent(FileInputStream fileStream) throws IOException {
    Scanner scanner = new Scanner(System.in);
    // Declare scanner to read the file.
    Scanner fileScanner = new Scanner(fileStream);

    // Ask the user for the name of the output file.
    System.out.println("What is the name of the output Java file? ");
    String outputFile = scanner.nextLine();

    // Set the outputstream to the name of the file the user inputted.
    FileOutputStream outputStream = new FileOutputStream(outputFile);
    // Initialize a printwriter to be able to write in the file.
    PrintWriter writer = new PrintWriter(outputStream);

    // Set indentation to zero at the beginning of the file.
    int indentation = 0;
    // Check if the file has a next line.
    while (fileScanner.hasNextLine()) {
      // Save the next line as a String variable.
      String line = fileScanner.nextLine();
      // Remove the white spaces from the line.
      String lineTrimmed = line.trim();

      // If the line has } the indentation level decreases by 2.
      if (lineTrimmed.contains("}")) {
        indentation -= 2;
      }
      // Print the number of spaces before the line depending on the level of indentation.
      for (int i = 0; i < indentation; i++) {
        writer.print(" ");
      }
      // Print the line after the indentation spaces are printed.
      writer.println(lineTrimmed);
      // If the line has { the indentation level increases by 2.
      if (lineTrimmed.contains("{")) {
        indentation += 2;
      }
    }
    // Flush whatever the writer has.
    writer.flush();
    // Close the output stream.
    outputStream.close();
  }
  // Take in a file and output the file with the user's choices.
  public static void madlib(FileInputStream fileStream) throws IOException {
    Scanner scanner = new Scanner(System.in);
    // Initialize a scanner to read the file.
    Scanner fileScanner = new Scanner(fileStream);

    // Ask the user for an output file to store the new text in.
    System.out.println("What is the name of the output Madlib file? ");
    String outputFile = scanner.nextLine();
    // Set the outputstream to the name of the file the user inputted.
    FileOutputStream outputStream = new FileOutputStream(outputFile);
    // Initialize a printwriter to be able to write in the file.
    PrintWriter writer = new PrintWriter(outputStream);

    // Read the file word by word.
    while (fileScanner.hasNext()) {
      // Save the next word of the file.
      String nextWord = fileScanner.next();

      // Print the word from the file if the word contains "<".
      if (!nextWord.contains("<")) {
        writer.print(nextWord + " ");
      }
      // Prompt the user for input if the word contains "<".
      if (nextWord.contains("<")) {
        System.out.print("Enter a ");
        // Ask the user for an appropriate variable based on the file.
        System.out.print(nextWord.substring(1, nextWord.indexOf(">")) + ": ");
        String userInput = scanner.nextLine();
        // Print the new word in the file.
        writer.print(userInput);
        // Print the characters after the >.
        writer.print(nextWord.substring((nextWord.indexOf(">") + 1), nextWord.length()) + " ");
      }
    }
    // Flush whatever the writer has.
    writer.flush();
    // Close the output stream.
    outputStream.close();
  }
}
