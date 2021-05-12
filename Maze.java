/* CS 1301 Intro to Computer Science
 *Instructor: Logan
 *Maze
 *Modified and Submitted by: Janeth Meraz
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
  public static void main(String[] args) /*throws FileNotFoundException*/ {

    // Check if the file in the argument line exists.
    // Scanner scnr = new Scanner();
    // Maze maze = new Maze();

    FileInputStream fileStream;
    try {
      fileStream = new FileInputStream(args[0]);
    } catch (FileNotFoundException e) {
      // If file is not found, print an error message.
      System.out.println("The file " + args[0] + " does not exist. Exiting.");
      return;
    }

    // Initialize a file reader through Scanner.
    // File fileString = new File(args[0]);
    Scanner reading = new Scanner(fileStream);

    // Initialize an empty array to save the information in the file.
    char[][] mazeArray = new char[0][];
    char[] line;

    // Check if the file has lines.
    while (reading.hasNextLine()) {
      // Save each String line and convert it to a character array.
      line = (reading.nextLine().toCharArray());
      // Save the line in the contents of the array.
      mazeArray = append(mazeArray, line);
    }

    int startingRow = 0;
    int startingCol = 0;
    // Find the indexes of the starting position.
    for (int i = 0; i < mazeArray.length; i++) {
      for (int j = 0; j < mazeArray[i].length; j++) {
        if (mazeArray[i][j] == '0') {
          startingRow = i;
          startingCol = j;
        }
      }
    }

    // Assign the previous row and column with the starting row and column to start.
    int previousRow = startingRow;
    int previousCol = startingCol;

    // Call the method to trace the path.
    pathway(mazeArray, startingRow, startingCol, previousRow, previousCol);

    // Print the edited maze.
    for (int row = 0; row < mazeArray.length; row++) {
      for (int col = 0; col < mazeArray[row].length; col++) {
        System.out.print(mazeArray[row][col]);
      }
      System.out.println();
    }
    System.out.println();
  }

  public static char[][] append(char[][] array, char[] newLine) {
    // Create a new array with one length greater than the array in main.
    char[][] result = new char[array.length + 1][];
    int i = 0;
    // Save the contents of the array in main to the new array.
    while (i < array.length) {
      result[i] = array[i];
      i++;
    }
    // Save the new line from the file in the last position.
    result[result.length - 1] = newLine;

    // Return the new array.
    return result;
  }

  public static boolean pathway(
      char[][] maze, int currentRow, int currentCol, int previousRow, int previousCol) {
    // Save the indexes above, below, left, and right, to the current position.
    char top = maze[currentRow - 1][currentCol];
    char bottom = maze[currentRow + 1][currentCol];
    char left = maze[currentRow][currentCol - 1];
    char right = maze[currentRow][currentCol + 1];

    // Check if the end point is on top, bottom, left, or right of the current index.
    if (top == 'X' || bottom == 'X' || left == 'X' || right == 'X') {
      return true;
    }

    // Check if the index on top is a blank space.
    if (maze[currentRow - 1][currentCol] == ' '
        && ((currentRow - 1) != previousRow || currentCol != previousCol)) {
      // Continue calling the method until it returns true or false.
      // Only print the path if the X was found.
      if (pathway(maze, currentRow - 1, currentCol, currentRow, currentCol)) {
        maze[currentRow - 1][currentCol] = '.';
        return true;
      }
    }

    // Check if the index on bottom is a blank space.
    if (maze[currentRow + 1][currentCol] == ' '
        && ((currentRow + 1) != previousRow || currentCol != previousCol)) {
      // Continue calling the method until it returns true or false.
      // Only print the path if the X was found.
      if (pathway(maze, currentRow + 1, currentCol, currentRow, currentCol)) {
        maze[currentRow + 1][currentCol] = '.';
        return true;
      }
    }

    // Check if the index on the left is a blank space.
    if (maze[currentRow][currentCol - 1] == ' '
        && (currentRow != previousRow || (currentCol - 1) != previousCol)) {
      // Continue calling the method until it returns true or false.
      // Only print the path if the X was found.
      if (pathway(maze, currentRow, currentCol - 1, currentRow, currentCol)) {
        maze[currentRow][currentCol - 1] = '.';
        return true;
      }
    }

    // Check if the index on the right is a blank space.
    if (maze[currentRow][currentCol + 1] == ' '
        && (currentRow != previousRow || (currentCol + 1) != previousCol)) {
      // Continue calling the method until it returns true or false.
      // Only print the path if the X was found.
      if (pathway(maze, currentRow, currentCol + 1, currentRow, currentCol)) {
        maze[currentRow][currentCol + 1] = '.';
        return true;
      }
    }

    // Return false if a solution was not found.
    return false;
  }
}
