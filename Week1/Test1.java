package Week1;

import java.util.Scanner;

public class Test1 {

  public static void main(String args[]) {

    Scanner scanner = new Scanner(System.in);

    int num1 = 0;
    int num2 = 0;

    num1 = scanner.nextInt();
    num2 = scanner.nextInt();

    System.out.println(num1 + num2);
    System.out.println(num1 - num2);
    System.out.println(num1 * num2);
    System.out.println(num1 / num2);
    System.out.println(num1 % num2);

  }

}