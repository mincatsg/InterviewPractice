package NKTest;
import java.util.Scanner;
public class NSodaBottles {
    //汽水瓶
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int empty = in.nextInt();
            int fact = 0;
            while(empty > 1){
                fact = fact + empty / 3;
                empty = (empty % 3) + (empty / 3);
                if(empty == 2){
                    fact = fact + 1;
                    break;
                }
            }
            System.out.println(fact);
        }
    }
}
