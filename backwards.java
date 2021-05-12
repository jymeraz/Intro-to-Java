/* CS 1301 Intro to Computer Science 
*Instructor: Logan 
*backwards
*Modified and Submitted by: Janeth Meraz
*/


public class backwards{
    public static void main(String []args)throws FileNotFoundException {
        FileInputStream fileStream = new FileInputStream("input.txt");
        System.out.print(backwards(fileStream));  
    } 
    public static String backwards(Scanner fileScanner){
        String number = "";
        if (fileScanner = 1){
            System.out.print(fileScanner);
        } else {
            number = (n % 10 + "" backwards(n/10));
        }
        
        return number;
    }
}