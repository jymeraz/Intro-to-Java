/* CS 1101 Intro to Computer Science
 *Instructor: Logan
 *Arrays2
 *Modified and Submitted by: Janeth Meraz
 */

// Java Program to illustrate reading from Text File
// using Scanner Class

// Import the library for files

import java.util.Scanner;

public class Arrays2 {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    // Example code
    char[] letters = new char[] {'a', 'b', 'c'};
    int n = letters.length;
    System.out.println(letters);
    for (int i = 0; i < n; i++) {
      System.out.println(letters[i]);
    }
    System.out.println();
    System.out.println("\n___________________________________________\n");
    /*
    * Array of Strings that represent movie titles
    //Print the contents of the array of movies
    */
    String[] movies = {"cars", "bugs life", "finding nemo", "toy story"};
    // System.out.println(movies);
    System.out.println("The contents of the movies array is: ");
    for (int i = 0; i < movies.length; i++) {
      System.out.println(movies[i]);
    }
    System.out.println();
    System.out.println("\n___________________________________________\n");

    /*
    * Array of doubles that represent the GPA all set to 4.0; Output 4 grades.
    //BONUS: Ask the user (using a Scanner) to input the values of the array elements
    */
    double[] gpa = new double[4];
    System.out.println("Enter four different GPA's out of 4.0.");
    for (int i = 0; i < gpa.length; i++) {
      System.out.print("Enter a GPA: ");
      double gpaValue = scanner.nextDouble();
      gpa[i] = gpaValue;
    }

    System.out.println("The contents of the gpa array is: ");
    for (int i = 0; i < gpa.length; i++) {
      System.out.println(gpa[i]);
    }

    System.out.println("\n___________________________________________\n\n");

    /*
     * Array of chars that represent letters of the alphabet; Output half of the alphabet.
     */

    char[] letters2 = {
      'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
      't', 'u', 'v', 'w', 'x', 'y', 'z'
    };
    System.out.println("The contents of the alphabet array is: ");
    for (int i = 0; i < (letters2.length / 2); i++) {
      System.out.println(letters2[i]);
    }
  }
}
