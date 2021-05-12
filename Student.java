public class Student {
  // public String name2;
  private String name;
  private int credits = 0;

  // default constructor
  public Student() {
    // this.name = "Default Name";
  }

  // custom constructor
  public Student(String name) {
    this.name = name;
  }

  // Getter.
  // gets name of particular student.
  public String getName() {
    return name;
  }

  public String getUpperName() {
    return this.name.toUpperCase();
  }

  // Setter
  public void setName(String name) {
    this.name = name;
    // this.name = name.trim(); to remove extra spaces
  }

  public void enroll(String name, int courseCredits) {
    sayHi();
    System.out.println(this.name + " enrolled in " + name);
    // System.out.println(getName() + " enrolled in");
    this.credits += courseCredits;
  }

  public static void sayHi() {
    System.out.println("Picks up!");
  }

  @Override
  public String toString() {
    return this.name + " is a student.";
  }

  @Override
  public String toString(int x) {
    return " is this called?";
  }
}
