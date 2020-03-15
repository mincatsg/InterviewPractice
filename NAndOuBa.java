package NKTest;
import java.util.Scanner;
public class NAndOuBa {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String c = in.next();
        for (int i = 0; i < n; i++) {
            System.out.print(c);
        }
        int h = n%2==0 ? n/2 : n/2+1;
        for (int j = 0; j < h -2; j++) {
            System.out.println();
            for (int i = 0; i < n; i++) {
                if(i == 0 || i == n-1) {
                    System.out.print(c);
                } else {
                    System.out.print(" ");
                }
            }
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(c);
        }
    }
}
