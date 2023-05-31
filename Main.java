import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        if(num1 > num2){
            System.out.println(">");
        }
        else if (num1 < num2) {
            System.out.println("<");
        }
        else {
            System.out.println("==");
        }
        scanner.close();
    }
}