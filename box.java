/* CS 1101 Intro to Computer Science
 *Instructor: Logan
 *First Lab Assignment
 *Modified and Submitted by: Janeth Meraz
 */

import java.util.Scanner;

public class box {
  public static void main(String[] args) {
    char[][] multiArray = boxed();
    for (int i = 0; i < multiArray.length; i++) {
      for (int col = 0; col < result[row].length; col++) {
      System.out.println(multiArray[i]);
    }
  }

  public static char[][] boxed() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a word: ");
    String word = scanner.nextLine();
    char[][] result = new char[3][word.length() + 2];

    for (int row = 0; row < result.length; row++) {
      for (int col = 0; col < result[row].length; col++) {
        if (row == 0 || row == result.length - 1 || col == 0 || col == result[row].length - 1) {
          // Put a hash in.
          result[row][col] = '#';
        } else {
          result[row][col] = word.charAt(col - 1);
        }
      }
    }

    return result;
  }
}
