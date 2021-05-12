/* CS 1101 Intro to Computer Science
 *Instructor: Logan Chadderdon
 *Electronics_Meraz
 *Modified and Submitted by: Janeth Meraz
 */

import java.io.File;
import java.util.Scanner;

public class Electronics_Meraz {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    File fileName = new File("student.txt");
    // Initialize a scanner to read the file.
    Scanner reading = new Scanner(fileName);

    // Initialize variables.
    String name = "";
    String userName = "";
    String password = "";
    int accountNum = 0;
    int routingNum = 0;
    String address = "";
    String code = "";

    // Read the file with a while loop.
    // Save each line as a different variable.
    while (reading.hasNextLine()) {
      name = reading.nextLine();
      userName = reading.nextLine();
      password = reading.nextLine();
      accountNum = reading.nextInt();
      routingNum = reading.nextInt();
      reading.nextLine();
      address = reading.nextLine();
      code = reading.nextLine();
    }

    // Print greeting to user.
    // Prompt user to input username and password.
    System.out.println("Welcome to UTEP Electronincs!");
    System.out.print("Username: ");
    String nameInput = scanner.nextLine();
    System.out.print("Password: ");
    String passwordInput = scanner.nextLine();

    // Prompt the user to re-enter their username and password if it does not match the ones in the
    // file.
    // Use iteration to ensure the user only gets three tries.
    // The user is prompted a maximum of once outside the loop and twice inside the loop.
    int i = 0;
    while (!nameInput.equals(userName) || !passwordInput.equals(password)) {
      System.out.println();
      System.out.println("Welcome to UTEP Electronincs!");
      System.out.println("Sorry, you entered invalid credentials. Try again.");
      System.out.print("Username: ");
      nameInput = scanner.nextLine();
      System.out.print("Password: ");
      passwordInput = scanner.nextLine();
      i++;
      // Exit the program if the user did not input a correct username and password the first three
      // times.
      // Print a message to the user that they are blocked from the platform.
      if (i > 1 && (!nameInput.equals(userName) || !passwordInput.equals(password))) {
        System.out.println("Sorry, you are temporarily blocked from the platform");
        System.exit(0);
      }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    System.out.println();
    // Greet the user one their credentials are correct.
    System.out.println("Welcome " + name + "!");
    System.out.println(
        "Before you make any purchase, we need some info from your Debit Card to perform a deposit.");

    System.out.println();
    // Prompt the user to input their card credentials.
    System.out.println("Please enter:");
    System.out.print("\tCARDHOLDER NAME: ");
    // Convert the name inputted to lower case.
    String cardHolder = scanner.nextLine().toLowerCase();
    System.out.print("\tACCOUNT NUMBER: ");
    int accountInput = scanner.nextInt();
    System.out.print("\tROUTING NUMBER: ");
    int routingInput = scanner.nextInt();
    scanner.nextLine();
    System.out.print("\tADDRESS: ");
    // Convert the address inputted to lower case.
    String addressInput = scanner.nextLine().toLowerCase();

    // Convert the address and name variables in the file to lower case.
    String lowerAddress = address.toLowerCase();
    String lowerName = name.toLowerCase();

    // Allow the user an infinite amount of times to re-enter their credentials.
    // If one of their credentials is inputted incorrectly, they must reinput all of them.
    while (!cardHolder.equals(lowerName)
        || accountInput != accountNum
        || routingInput != routingNum
        || !addressInput.equals(lowerAddress)) {
      System.out.println();
      System.out.println("Welcome to UTEP Electronincs!");
      System.out.println("Sorry, we do not recognize your Card Information. Please try again.");
      System.out.println("Please enter:");
      System.out.print("\tCARDHOLDER NAME: ");
      cardHolder = scanner.nextLine().toLowerCase();
      System.out.print("\tACCOUNT NUMBER: ");
      accountInput = scanner.nextInt();
      System.out.print("\tROUTING NUMBER: ");
      routingInput = scanner.nextInt();
      scanner.nextLine();
      System.out.print("\tADDRESS: ");
      addressInput = scanner.nextLine().toLowerCase();
    }

    System.out.println();
    // Prompt the user to make a deposit more than $0 and less than $5000.
    System.out.println("Excellent! You are not ready to make a deposit.");
    System.out.print("Enter deposit amount greater than $0.00 and less than $5000.00: ");
    double userDeposit = scanner.nextDouble();

    // If the user inputted an invalid amount, then prompt them to input a different amount.
    // Allow an infinite amount of tries.
    while (userDeposit > 5000.0 || userDeposit <= 0) {
      System.out.println(
          "Sorry, you can only deposit up to $5,000.00 and more than $0.00 into the account. Try entering a lower amount.");
      System.out.print("Enter deposit amount: ");
      userDeposit = scanner.nextDouble();
    }

    // Before the user starts shopping, their cart and subtotal is 0.
    int numItems = 0;
    double subtotal = 0.0;
    // Call the menu method.
    // Send the name, deposit amount, number of items, subtotal, address, and promotional code as
    // arguments.
    menu(name, userDeposit, numItems, subtotal, address, code);
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////////////////////////////////

  public static void menu(
      String name, double deposit, int numItems, double subtotal, String address, String code) {
    Scanner scanner = new Scanner(System.in);
    System.out.println();
    // Print a welcome message to the user.
    // Print the standing of their cart and subtotal.
    System.out.println("Main Menu");
    System.out.println("Welcome " + name + "!");
    System.out.printf("Subtotal amount: $%.2f\n", subtotal);
    System.out.println("Cart: " + numItems);
    // Give the user the choice to search an item or check out.
    System.out.println("\t 1. Search Item");
    System.out.println("\t 2. Check out");
    System.out.print("Answer: ");
    int answer = scanner.nextInt();

    // If the user chooses to search an item, the searchItem method is called.
    // If the user chooses to check out, the code method is called.
    switch (answer) {
      case 1:
        searchItem(name, deposit, numItems, subtotal, address, code);
        break;
      case 2:
        code(name, deposit, numItems, subtotal, address, code);
        break;
      default:
        // Allow for infinite tries if the user did not input one of the two responses.
        System.out.println("Sorry, you did not input an appropriate response. Try again. ");
        menu(name, deposit, numItems, subtotal, address, code);
        break;
    }
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////////////////////////////////

  public static void searchItem(
      String name, double deposit, int numItems, double subtotal, String address, String code) {
    Scanner scanner = new Scanner(System.in);
    System.out.println();
    // Print the selection of choices for the user to see.
    System.out.println("Categories: ");
    System.out.println("\t 1. TVs");
    System.out.println("\t 2. Laptops");
    System.out.println("\t 3. Cell phones");
    System.out.println("\t 4. Accessories");
    System.out.println("\t 5. Go Back");
    System.out.print("Which catalog would you like to see: ");
    int answerCategory = scanner.nextInt();

    // Each choice the user chooses calls a different method that opens a new selection.
    // Each call to the method sends the name, deposit, number of items, address, and promotional
    // code as arguments to the method.
    switch (answerCategory) {
      case 1:
        televisions(name, deposit, numItems, subtotal, address, code);
        break;
      case 2:
        laptops(name, deposit, numItems, subtotal, address, code);
        break;
      case 3:
        cellPhones(name, deposit, numItems, subtotal, address, code);
        break;
      case 4:
        accessories(name, deposit, numItems, subtotal, address, code);
        break;
      case 5:
        menu(name, deposit, numItems, subtotal, address, code);
        break;
      default:
        // Allow for infinite tries if the user did not input one of the five responses.
        System.out.println("Sorry, you did not input an appropriate response. Try again. ");
        searchItem(name, deposit, numItems, subtotal, address, code);
        break;
    }
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////////////////////////////////

  public static void televisions(
      String name, double deposit, int numItems, double subtotal, String address, String code) {
    Scanner scanner = new Scanner(System.in);
    System.out.println();
    // Print out the selection of televisions to the user.
    System.out.println("\t\tTVs:");
    System.out.println("•Vizio 32\" \t\t\t $139.56");
    System.out.println("•LG 50\" \t\t\t $384.12");
    System.out.println("•Samsung 65\" \t\t\t $564.98");
    System.out.println("•Sony 70\" \t\t\t $819.47");

    // Give the user the option to choose an item or go back to the menu.
    System.out.print("Select an item or type 'Go back' to go back to the main menu: ");
    String item = scanner.nextLine().toLowerCase();

    // Initialize the quantity of items, updated subtotal, and updated number of items as zero.
    int numChoice = 0;
    double newSubtotal = 0;
    int numItemsUpdated = 0;

    // Use if statement to update their number of items and subtotal according to the item chosen.
    if (item.equals("vizio 32\"")) {
      // Prompt the user to enter a quantity.
      System.out.print("Select a quantity: ");
      numChoice = scanner.nextInt();
      // Update the number of items as the number of items in their cart plus the number of items
      // they are adding.
      numItemsUpdated = numItems + numChoice;
      // Update the new subtotal as their previous subtotal plus the cost of the items they are
      // adding.
      newSubtotal = subtotal + (numChoice * 139.56);
    } else if (item.equals("lg 50\"")) {
      System.out.print("Select a quantity: ");
      numChoice = scanner.nextInt();
      numItemsUpdated = numItems + numChoice;
      newSubtotal = subtotal + (numChoice * 384.12);
    } else if (item.equals("samsung 65\"")) {
      System.out.print("Select a quantity: ");
      numChoice = scanner.nextInt();
      numItemsUpdated = numItems + numChoice;
      newSubtotal = subtotal + (numChoice * 564.98);
    } else if (item.equals("sony 70\"")) {
      System.out.print("Select a quantity: ");
      numChoice = scanner.nextInt();
      numItemsUpdated = numItems + numChoice;
      newSubtotal = subtotal + (numChoice * 819.47);
    } else if (item.equals("go back")) {
      // If the user chose to go back, call the menu method.
      menu(name, deposit, numItems, subtotal, address, code);
      return;
    } else {
      // If the item is not found, allow the user to re-input an item by calling the televisions
      // method again.
      System.out.println("Error, item not found. Try again.");
      televisions(name, deposit, numItems, subtotal, address, code);
      return;
    }

    if (newSubtotal > deposit) {
      // If the updated subotal is more than the deposit amount, then notify the user that there is
      // not enough money.
      // Call the menu method with the old subtotal and old number of items.
      System.out.println("Not enough funds to add this item to the cart");
      menu(name, deposit, numItems, subtotal, address, code);
    } else {
      // If the updated subtotal is not more than the deposit amount, then call the menu method with
      // the updated number of items and updated subtotal.
      menu(name, deposit, numItemsUpdated, newSubtotal, address, code);
    }
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////////////////////////////////

  public static void laptops(
      String name, double deposit, int numItems, double subtotal, String address, String code) {
    Scanner scanner = new Scanner(System.in);
    System.out.println();
    // Print out the selection of laptops to the user.
    System.out.println("\t\tLaptops:");
    System.out.println("•Surface GO! \t\t\t $549.99");
    System.out.println("•Apple MacBook Air \t\t $1299.99");
    System.out.println("•Lenovo \t\t\t $539.53");
    System.out.println("•HP Laptop \t\t\t $699.99");

    // Give the user the option to choose an item or go back to the menu.
    System.out.print("Select an item or type 'Go back' to go back to the main menu: ");
    String item = scanner.nextLine().toLowerCase();

    // Initialize the quantity of items, updated subtotal, and updated number of items as zero.
    int numChoice = 0;
    int numItemsUpdated = 0;
    double newSubtotal = 0;

    // Use if statement to update their number of items and subtotal according to the item chosen.
    if (item.equals("surface go!")) {
      // Prompt the user to enter a quantity.
      System.out.print("Select a quantity: ");
      numChoice = scanner.nextInt();
      // Update the number of items as the number of items in their cart plus the number of items
      // they are adding.
      numItemsUpdated = numItems + numChoice;
      // Update the new subtotal as their previous subtotal plus the cost of the items they are
      // adding.
      newSubtotal = subtotal + (numChoice * 549.99);
    } else if (item.equals("apple macbook air")) {
      System.out.print("Select a quantity: ");
      numChoice = scanner.nextInt();
      numItemsUpdated = numItems + numChoice;
      newSubtotal = subtotal + (numChoice * 1299.99);
    } else if (item.equals("lenovo")) {
      System.out.print("Select a quantity: ");
      numChoice = scanner.nextInt();
      numItemsUpdated = numItems + numChoice;
      newSubtotal = subtotal + (numChoice * 539.53);
    } else if (item.equals("hp laptop")) {
      System.out.print("Select a quantity: ");
      numChoice = scanner.nextInt();
      numItemsUpdated = numItems + numChoice;
      newSubtotal = subtotal + (numChoice * 699.99);
    } else if (item.equals("go back")) {
      // If the user chose to go back, call the menu method.
      menu(name, deposit, numItems, subtotal, address, code);
      return;
    } else {
      // If the item is not found, allow the user to re-input an item by calling the laptops
      // method again.
      System.out.println("Error, item not found. Try again.");
      laptops(name, deposit, numItems, subtotal, address, code);
      return;
    }

    if (newSubtotal > deposit) {
      // If the updated subotal is more than the deposit amount, then notify the user that there is
      // not enough money.
      // Call the menu method with the old subtotal and old number of items.
      System.out.println("Not enough funds to add this item to the cart");
      menu(name, deposit, numItems, subtotal, address, code);
    } else {
      // If the updated subtotal is not more than the deposit amount, then call the menu method with
      // the updated number of items and updated subtotal.
      menu(name, deposit, numItemsUpdated, newSubtotal, address, code);
    }
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////////////////////////////////

  public static void cellPhones(
      String name, double deposit, int numItems, double subtotal, String address, String code) {
    Scanner scanner = new Scanner(System.in);
    System.out.println();
    // Print out the selection of cell phones to the user.
    System.out.println("\t\tCell phones:");
    System.out.println("•iPhone 11 \t\t\t $749.84");
    System.out.println("•Galaxy Fold \t\t\t $1980.00");
    System.out.println("•Galaxy S10 \t\t\t $998.97");
    System.out.println("•Google Pixel \t\t\t $378.78");

    // Give the user the option to choose an item or go back to the menu.
    System.out.print("Select an item or type 'Go back' to go back to the main menu: ");
    String item = scanner.nextLine().toLowerCase();

    // Initialize the quantity of items, updated subtotal, and updated number of items as zero.
    int numChoice = 0;
    int numItemsUpdated = 0;
    double newSubtotal = 0;

    // Use if statement to update their number of items and subtotal according to the item chosen.
    if (item.equals("iphone 11")) {
      // Prompt the user to enter a quantity.
      System.out.print("Select a quantity: ");
      numChoice = scanner.nextInt();
      // Update the number of items as the number of items in their cart plus the number of items
      // they are adding.
      numItemsUpdated = numItems + numChoice;
      // Update the new subtotal as their previous subtotal plus the cost of the items they are
      // adding.
      newSubtotal = subtotal + (numChoice * 749.84);
    } else if (item.equals("galaxy fold")) {
      System.out.print("Select a quantity: ");
      numChoice = scanner.nextInt();
      numItemsUpdated = numItems + numChoice;
      newSubtotal = subtotal + (numChoice * 1980.00);
    } else if (item.equals("galaxy s10")) {
      System.out.print("Select a quantity: ");
      numChoice = scanner.nextInt();
      numItemsUpdated = numItems + numChoice;
      newSubtotal = subtotal + (numChoice * 998.97);
    } else if (item.equals("google pixel")) {
      System.out.print("Select a quantity: ");
      numChoice = scanner.nextInt();
      numItemsUpdated = numItems + numChoice;
      newSubtotal = subtotal + (numChoice * 378.78);
    } else if (item.equals("go back")) {
      // If the user chose to go back, call the menu method.
      menu(name, deposit, numItems, subtotal, address, code);
      return;
    } else {
      // If the item is not found, allow the user to re-input an item by calling the cell phones
      // method again.
      System.out.println("Error, item not found. Try again.");
      cellPhones(name, deposit, numItems, subtotal, address, code);
      return;
    }
    if (newSubtotal > deposit) {
      // If the updated subotal is more than the deposit amount, then notify the user that there is
      // not enough money.
      // Call the menu method with the old subtotal and old number of items.
      System.out.println("Not enough funds to add this item to the cart");
      menu(name, deposit, numItems, subtotal, address, code);
    } else {
      // If the updated subtotal is not more than the deposit amount, then call the menu method with
      // the updated number of items and updated subtotal.
      menu(name, deposit, numItemsUpdated, newSubtotal, address, code);
    }
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////////////////////////////////

  public static void accessories(
      String name, double deposit, int numItems, double subtotal, String address, String code) {
    Scanner scanner = new Scanner(System.in);
    System.out.println();
    // Print out the selection of accessories to the user.
    System.out.println("\t\tAccessories:");
    System.out.println("•Apple Watch \t\t\t $214.08");
    System.out.println("•Keurig Coffee Maker \t\t $89.00");
    System.out.println("•Amazon Echo \t\t\t $72.51");
    System.out.println("•Nintendo Switch controller \t $61.19");

    // Give the user the option to choose an item or go back to the menu.
    System.out.print("Select an item or type 'Go back' to go back to the main menu: ");
    String item = scanner.nextLine().toLowerCase();

    // Initialize the quantity of items, updated subtotal, and updated number of items as zero.
    int numChoice = 0;
    int numItemsUpdated = 0;
    double newSubtotal = 0;

    // Use if statement to update their number of items and subtotal according to the item chosen.
    if (item.equals("apple watch")) {
      System.out.print("Select a quantity: ");
      numChoice = scanner.nextInt();
      // Update the number of items as the number of items in their cart plus the number of items
      // they are adding.
      numItemsUpdated = numItems + numChoice;
      // Update the new subtotal as their previous subtotal plus the cost of the items they are
      // adding.
      newSubtotal = subtotal + (numChoice * 214.08);
    } else if (item.equals("keurig coffee maker")) {
      System.out.print("Select a quantity: ");
      numChoice = scanner.nextInt();
      numItemsUpdated = numItems + numChoice;
      newSubtotal = subtotal + (numChoice * 89.00);
    } else if (item.equals("amazon echo")) {
      System.out.print("Select a quantity: ");
      numChoice = scanner.nextInt();
      numItemsUpdated = numItems + numChoice;
      newSubtotal = subtotal + (numChoice * 72.51);
    } else if (item.equals("nintendo switch controller")) {
      System.out.print("Select a quantity: ");
      numChoice = scanner.nextInt();
      numItemsUpdated = numItems + numChoice;
      newSubtotal = subtotal + (numChoice * 61.19);
    } else if (item.equals("go back")) {
      // If the user chose to go back, call the menu method.
      menu(name, deposit, numItems, subtotal, address, code);
      return;
    } else {
      // If the item is not found, allow the user to re-input an item by calling the accessories
      // method again.
      System.out.println("Error, item not found. Try again");
      accessories(name, deposit, numItems, subtotal, address, code);
      return;
    }

    if (newSubtotal > deposit) {
      // If the updated subotal is more than the deposit amount, then notify the user that there is
      // not enough money.
      // Call the menu method with the old subtotal and old number of items.
      System.out.println("Not enough funds to add this item to the cart");
      menu(name, deposit, numItems, subtotal, address, code);
    } else {
      // If the updated subtotal is not more than the deposit amount, then call the menu method with
      // the updated number of items and updated subtotal.
      menu(name, deposit, numItemsUpdated, newSubtotal, address, code);
    }
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////////////////////////////////

  public static void code(
      String name, double deposit, int numItems, double subtotal, String address, String code) {
    Scanner scanner = new Scanner(System.in);
    System.out.println();

    // If the number of items is zero, then call the confirmation method.
    if (numItems == 0) {
      confirmation(name, deposit, numItems, subtotal, address, code);
      return;
    }

    // Ask the user if they have a promotional code.
    System.out.println("Do you have a promotional code? Yes/No");
    String userResponse = scanner.next().toLowerCase();
    switch (userResponse) {
      case "yes":
        // If the user responds yes, ask them the name of the code.
        System.out.println("What is the name of the code?");
        String userCode = scanner.next();
        int i = 0;
        // If the user does not input the correct code, prompt them to input it again.
        while (!userCode.equals(code)) {
          System.out.println("You did not input a valid code. Try again.");
          System.out.println("What is the name of the code?");
          userCode = scanner.next();
          i++;
          // If the user does not input the correct code within three times, then call the
          // confirmation method.
          if (i > 1) {
            System.out.println("You did not input a valid code.");
            System.out.println("You will continue with check out.");
            confirmation(name, deposit, numItems, subtotal, address, code);
            return;
          }
        }
        // If the code the user inputted matches the code in the file, then notify the user they
        // inputted the correct code.
        if (userCode.equals(code)) {
          System.out.println(
              "You inputted the correct code, you will receive 20% off of your purchase.");
          // Update the subtotal by subtracting 20% of the subtotal.
          subtotal = subtotal - (subtotal * .2);
          // Call the confirmation method with the updated subtotal.
          confirmation(name, deposit, numItems, subtotal, address, code);
        }

        break;
        // If the user does not have a code, then call the confirmation method.
      case "no":
        System.out.println("No worries, you are ready to check out.");
        confirmation(name, deposit, numItems, subtotal, address, code);
        break;
        // If the user does not input a valid answer, allow for infinite retries by calling the code
        // method.
      default:
        System.out.println("You did not input an appropriate response. Please try again.");
        code(name, deposit, numItems, subtotal, address, code);
        break;
    }
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////////////////////////////////////

  public static void confirmation(
      String name, double deposit, int numItems, double subtotal, String address, String code) {
    Scanner scanner = new Scanner(System.in);
    System.out.println();
    // If the number of items is zero, then print a goodbye message.
    if (numItems == 0) {
      System.out.println("You did not purchase any items, we hope to hear from you soon!");
    } else {
      // If the user has items in their cart, ask the user if they want to proceed with payment.
      System.out.println("Are you sure you want to proceed with payment? Yes/No");
      String confirmation = scanner.next().toLowerCase();
      switch (confirmation) {
        case "yes":
          // If user inputs yes, print a thank you message with their address and subtotal.
          // Calculate miner bucks by subtracting their subtotal from their initial deposit.
          System.out.println("Thank you for your purchase!");
          System.out.println("Your items will be shipped to your address: " + address);
          System.out.printf("Total amount: $%.2f\n", subtotal);
          System.out.printf("Remaining Miner bucks is: $%.2f\n", (deposit - subtotal));
          break;
        case "no":
          // If the user inputs no, then print a goodbye message with their initial deposit.
          System.out.println("No worries, we hope to hear from you soon!");
          System.out.println("Your budget is: $" + deposit);
          System.out.println();
          break;
        default:
          // If the user inputs a reponse that is not yes or no, allow them infinite times to input
          // an appropriate input.
          System.out.println("You did not input an appropriate response. Please try again.");
          confirmation(name, deposit, numItems, subtotal, address, code);
          break;
      }
    }
  }
}
