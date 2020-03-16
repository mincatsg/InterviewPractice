package NKTest;

import java.util.Scanner;

public class NConsistantMin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] num = new int[10];
        //读取数字0-9的个数
        for (int i = 0; i < num.length; i++) {
            num[i] = in.nextInt();
        }
        in.close();
        //输出除0外最小的数字
        for (int i = 1; i < num.length; i++) {
            if (num[i] != 0) {
                System.out.print(i);
                num[i]--;
                break;
            }
        }
        //由小到大从0开始输出
        for (int i = 0; i < num.length; i++) {
            while(num[i] > 0){
                System.out.print(i);
                num[i]--;
            }
        }
        System.out.println();
    }
}
