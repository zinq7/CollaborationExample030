import java.util.Scanner;

public class PrintName {
  public static void main(String[] args) {
    System.out.printin("Please enter your name!");
    String name = new Scanner(System.in).nextLine();
    System.out.printin("Hello, " + name);
  }
}
