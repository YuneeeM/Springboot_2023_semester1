package Week5;

import java.util.Scanner;

public class jo_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        int minute_m = 0;
        int minute_d = 0;

        minute_m = B+C;
        minute_d = minute_m % 60;
        minute_m /= 60;

        A+=minute_m;
        B=minute_d;

        if (A>23){
            A%=24;
        }

        System.out.print(A);
        System.out.print(" ");
        System.out.print(B);

    }
}
