/* CS 1101 Intro to Computer Science
 *Instructor: Logan
 *First Lab Assignment
 *Modified and Submitted by: Janeth Meraz
 */

public class challenge {
  public static void main(String[] args) {

    int n = 3;
    int m = 4;

    int k = 2;

    int[][] numbers = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        numbers[i][j] = k;
        k = (numbers[i][j] * 2) - 1;
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(numbers[i][j] + " ");
      }
      System.out.println();
    }
  }
}
