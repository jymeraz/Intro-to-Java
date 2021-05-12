/* CS 1101 Intro to Computer Science
 *Instructor: Logan
 *First Lab Assignment
 *Modified and Submitted by: Janeth Meraz
 */

public class challenge4 {
  public static void main(String[] args) {
    System.out.println(palindrome("racecar"));
  }

  public static boolean palindrome(String a) {
    if (a.length() == 1) {
      return true;
    }
    if (a.length() == 0) {
      return true;
    }
    // char b = s.substring();
    if (a.charAt(0) == a.charAt((a.length() - 1))) {
      if (palindrome(a.substring(1, a.length() - 1))) {
        return true;
      }
    }
    return false;
  }
}
