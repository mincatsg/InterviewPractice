import java.util.Scanner;
import java.util.*;
public class NNotTwo{
    public static void main(String[] args){
// 不要二
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); //列
        int H = in.nextInt();
        int count = 0;
        //也就是( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) ) = 4
        //也就只有俩种可能 0 4  4 0 那就是行过2 列过2
        // 直接行列 来
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                //第一行第二行 
               if((i / 2) % 2 == 0){
                   if((j / 2) % 2 == 0){
                       count++;
                   }
               }else{
                   if((j / 2) % 2 == 1){
                       count++;
                   }
               }
            }
        }
        System.out.println(count);
    }
}