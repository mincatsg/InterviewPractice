package NKTest;

import java.util.Scanner;

public class NHungry {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        System.out.println(getMessage(a));
    }

    public static int getMessage(long a){
        int count = 0;
        int c = 1000000007;
        int k = 4;
        a = a + 1; //等会减一即可.
        for(int i = 2; i < 300000; i++){
            if((k * a - 1) % c == 0){
                count = i / 3 + ((i % 3 > 0)? 1 : 0);
                return count;
            }
            k = k * 2 % c;
        }
        return -1;
    }
}
