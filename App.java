public class App {
  private String name;
  private String developer;
  private String version;
  private double size;

  // default constructor
  public App() {
  }

  // constructor with parameters of name and size
  public App(String name, double size) {
    this.name = name;
    this.size = size;
  }


  // constructor with four parameters
  public App(String name, String developer, String version, double size) {
    this.name = name;
    this.developer = developer;
    this.version = version;
    this.size = size;
  }
  
  // setter/mutators
  public void setName(String newName) {
    this.name = newName;
  }

  public void setSize(double newSize) {
    this.size = newSize;
  }

  public void setDeveloper(String newDeveloper) {
    this.developer = newDeveloper;
  }

  public void setVerison(String newVersion) {
    this.version = newVersion;
  }


  // getters/accesors
  public String getName() {
    return this.name;
  }

  public double getSize() {
    return this.size;
  }

  public String getDeveloper() {
    return this.developer;
  }

  public String getVersion() {
    return this.version;
  }

  public void printHomeScreen() {
    System.out.println("This is the home screen " + this.name);
    System.out.printf("I have a size of %.2f Mega Bytes\n", this.size);
  }

  // ACTUATOR that returns a String
  public String toString() {
    String appString = this.name + "\n Developed by: " + this.developer + "\n Verison: " + this.version + "\n Size: "+ this.size;
    return appString;
  }

  // ACTUATOR that will set criteria to compare abjects with each other (will look at in next class)
  public boolean equal(App otherApp) {
   try {
     if (this.name.equals(otherApp.getName())) {
       return true;
     }
   } catch (NullPointerException e) {
     return false;
   }
   return false;
 }
}
