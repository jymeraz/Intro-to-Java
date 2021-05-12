/* CS 1101 Intro to Computer Science
 *Instructor: Logan
 *OrangeBox
 *Modified and Submitted by: Janeth Meraz
 */

import java.util.Scanner;

public class OrangeBox {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[][] movies = {
      {"The Lion King", "1.75", "2"},
      {"Toy Story", "1.80", "0"},
      {"Maleficent", "2.30", "5"},
      {"The Joker", "1.50", "3"}
    };
    double cost = 0.0;
    movies(movies, cost);
  }

  public static void movies(String[][] moviesArray, double runningTotal) {
    Scanner scanner = new Scanner(System.in);

    System.out.println();
    System.out.println("Movies\t\tCost\tAmount available");

    for (int i = 0; i < moviesArray.length; i++) {
      for (int j = 0; j < moviesArray[i].length; j++) {
        System.out.print(moviesArray[i][j] + "\t");
      }
      System.out.println();
    }
    System.out.println();

    System.out.println("Which movie will you like to rent?");
    String movieResponse = scanner.nextLine().toLowerCase();

    System.out.println();

    String moreMovies = "no";
    boolean movieFound = false;

    for (int i = 0; i < moviesArray.length; i++) {
      for (int j = 0; j < moviesArray[i].length; j++) {
        String currentMovie = moviesArray[i][j].toLowerCase();
        if (currentMovie.equals(movieResponse)) {
          movieFound = true;
          int quantity = Integer.parseInt(moviesArray[i][j + 2]);
          if (quantity > 0) {
            double costMovie = Double.parseDouble(moviesArray[i][j + 1]);
            runningTotal = runningTotal + costMovie;

            System.out.println(
                "Here is your movie, "
                    + moviesArray[i][j]
                    + ", it costs $"
                    + moviesArray[i][j + 1]);
            System.out.printf("Your running total is $%.2f, thank you.\n", runningTotal);

            moviesArray[i][j + 2] = Integer.toString(quantity - 1);

            System.out.println("Will you like to order another movie?");
            moreMovies = scanner.next().toLowerCase();
          } else {
            System.out.println("Sorry, this movie is out of stock.");
            System.out.println("Will you like to order another movie?");
            moreMovies = scanner.next().toLowerCase();
          }
        }
      }
    }
    if (!movieFound) {
      System.out.println("Sorry, we don't have it.");
      System.out.println("Will you like to order another movie?");
      moreMovies = scanner.next().toLowerCase();
    }

    int i = 0;
    int j = 0;
    if (moviesArray[i][j + 2].equals("0")
        && moviesArray[i + 1][j + 2].equals("0")
        && moviesArray[i + 2][j + 2].equals("0")
        && moviesArray[i + 3][j + 2].equals("0")) {
      System.out.println("Sorry, we are out of movies.");
      return;
    }

    if (moreMovies.equals("yes")) {
      movies(moviesArray, runningTotal);
    } else {
      System.out.println("Okay, Thank You!");
    }
  }
}
