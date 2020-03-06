package NKTest;

import java.util.Scanner;

public class NCalculationCandy {
    //计算糖果
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] num = new int[4];
        for(int i = 0; i < 4; i++){
            num[i] = in.nextInt();
        }
        double A = (double)(num[0] + num[2]) / 2;
        double B = (double)(num[1] + num[3]) / 2;
        double C = (double)num[3] - B;
        if(A == (int)A && B == (int)B && C == (int)C && A >= 0 && B >= 0){
            System.out.println((int)A + " " + (int)B + " " + (int)C);
        }else{
            System.out.println("No");
        }
    }
}
