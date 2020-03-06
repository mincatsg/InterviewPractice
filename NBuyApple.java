package NKTest;

import java.util.Scanner;

public class NBuyApple {
    //买苹果

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int apple = in.nextInt();
        int count = -1;
        //先算8袋苹果的最大值,如果不能满足6袋,8袋向下减一袋,再去看6袋的,直到找到.
        for(int i = apple / 8; i >= 0; i--){
            if((apple - i * 8) % 6 == 0){
                count = i + ((apple - i * 8) / 6);
                break;
            }
        }
        System.out.println(count);
    }
}
