package Week5;

import java.util.Scanner;

public class jo_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int H = scanner.nextInt();
        int M = scanner.nextInt();


        if (M >=45 && M <=59){
            M=M-45;
        }
        else {
            M = (M+60)-45;
            if(H==0) {
                H = 24;
            }
                H = H-1;

        }
        System.out.print(H);
        System.out.print(" ");
        System.out.print(M);
    }
}
