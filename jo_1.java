import java.util.Scanner;

public class jo_1 {

    public static void main(String args[]) {

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
