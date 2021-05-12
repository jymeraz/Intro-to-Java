// ---------AppStore Object Class---------
// Author: Caro
// Course: CS 1301/1101 - Fall 2019
// Instructors: Logan | Aguirre
// Last Modified: 11/06/19

public class AppStore2 {
  private App[] catalog; // array of Apps
  private int numOfApps; // the amount of apps inside my catalog

  // default constructor
  public AppStore2() {
    catalog = new App[10]; // default capacity
    numOfApps = 0;
  }

  // Constructor passing the capacity of my AppStore
  public AppStore2(int capacity) {
    catalog = new App[capacity];
    numOfApps = 0;
  }

  /**
   * Method will search for an app
   *
   * @param: App
   * @return: index where app was found, otherwise return -1 if the app is not in the array.
   */
  // return -1; // App not found

  public int findApp(App toFind) {
    for (int i = 0; i < numOfApps; i++) {
      if (catalog[i].equal(toFind)) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Method will add a App to the array catalog.
   *
   * @param: An App object Output: Add newApp into the array catalog based on numOfApps If array is
   *     full the method displays an appropriate message "catalog is full" and does not add the App.
   *     If the title of the App is found in the array, the method displays an appropriate message
   *     "app is already in AppStore" and does not add the App.
   */
  public void addApp(App newApp) {
    if (numOfApps == catalog.length) {
      System.out.println("FULL");
    }
    int count = 0;
    boolean safetocontinue = true;
    while (safetocontinue && count < catalog.length) {
      if (catalog[count] == newApp) {
        System.out.println("ALREADY THERE");
        safetocontinue = false;
      }
      if (catalog[count] == null) {
        catalog[count] = newApp;
        // System.out.println(catalog[count]);
        numOfApps++;
        safetocontinue = false;
      }
      count++;
    }
  } // end of addApp

  /**
   * Method will print all of the elements of the catalog inside object AppStore by using the method
   * toString from the App class
   */
  public void printAppStore() {
    // System.out.println("PRINT CONTENTS");
    for (int i = 0; i < catalog.length; i++) {
      System.out.println(catalog[i].toString());
    }
  }
}
