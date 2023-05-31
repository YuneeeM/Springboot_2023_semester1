package Week5;

import java.util.Scanner;

public class jo_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int money=0;

        if(a==b && b==c && a==c){
            money=10000+(a*1000);
        }
        else if (a==b || b==c || a==c ){
            if(a==b){
                money=1000+(a*100);
            }
            else if(b==c){
                money=1000+(b*100);
            }
            else if(a==c){
                money=1000+(a*100);
            }
        }
        else{
            int max = 0;
            if(a>b){
                max=a;
                if(max<c){
                    max=c;
                    money = max*100;
                }
                else{
                    money = max*100;
                }
            }
            else{
                max=b;
                if(max<c){
                    max=c;
                    money = max*100;
                }
                else{
                    money = max*100;
                }
            }
        }

        System.out.println(money);

    }
}
