import java.util.Scanner;
public class NFibonzcci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            int a = in.nextInt();
            int x1 = 0;
            int x2 = 1;
            for(int i = 0; i <= a; i++){
                if(a >= x1 && a <= x2){
                    System.out.println((a- x1 > x2 - a)? (x2 - a) : (a - x1));
                    break;
                }
                x2 = x1 + x2;
                x1 = x2 - x1;
            }
        }
}