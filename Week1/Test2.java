package Week1;

import java.util.Scanner;

public class Test2 {
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    String name = "hello";
    String same = "hello";

    name = scanner.next();
    same = name;

    if (name == same) {
      System.out.println(name + "??!");
    }

  }

}
