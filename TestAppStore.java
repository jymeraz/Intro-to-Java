/**
 * ---------Test AppStore Class--------- 
 Author:Caro  Course: CS 1301/1101 - Fall 2019
 * Instructors: Logan && Aguirre 
  Caro Last Modified: 11/06/19
 */
public class TestAppStore {

  public static void main(String[] args) {

    /** ************** Creating App objects ******************* */
    App a1 = new App("Instagram", "Kevin & Mike", "116.0.0.34.121", 38.09);
    App a2 = new App("Snapchat", "Evan, Bobby & Reggie", "10.68.0.0", 45.03);
    App a3 = new App("WhatsApp", "WhatsApp Inc.", "2.19.306", 24.85);
    App a4 = a1; // copy of the first app created
    App a5 = new App("Waze", "Google", "4.56.0.2", 74.26);
    App a6 = new App("Spotify", "Spotify Ltd.", "8.5.29.828", 428);
    App a7 = new App("Venmo", "Andrew & Iqram", "7.40.0", 47.56);

    /** ****** Creating a AppStore with capacity of 5 ******** */
    // AppStore firstAppStore = new AppStore(); //using default constructor
    AppStore2 myAppStore = new AppStore2(5);

    /** ******************Adding apps *********************** */
    myAppStore.addApp(a1);
    myAppStore.addApp(a2);
    myAppStore.addApp(a3);
    myAppStore.addApp(a4); // should return a message that app is already in app store
    myAppStore.addApp(a5);
    myAppStore.addApp(a6);
    myAppStore.addApp(a7); // should return message that app store is full

    /** **********Print contents of myAppStore **************** */
    System.out.println();
    myAppStore.printAppStore();

    /** **********looking for apps in the app store **************** */
    // printIfFound is the method where the actuator "findApp is tested"
    System.out.println();
    printIfFound(myAppStore, new App("Spotify", "Spotify Ltd.", "", 428));
    printIfFound(myAppStore, new App("Uber", 3.3));
    printIfFound(myAppStore, new App("Instagram", "Kevin & Mike", "", 38.09));
  }

  public static void printIfFound(AppStore2 store, App appToFind) {
    int index = store.findApp(appToFind);
    System.out.print(appToFind);
    if(index != -1){
        System.out.println(": App found at index " + index + ".");
    }
    else{
      System.out.println(": App was not found in the app store.");
    }
  }
}
