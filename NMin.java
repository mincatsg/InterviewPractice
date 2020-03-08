import java.util.Scanner;

public class NMin{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        //不管A大还是B大 总是升序.
        if(A >= B){
           int tem = A;
            A = B;
            B = tem;
        }
        //俩个数最小公倍数要么是他俩最大的数,要么是更大的数.
        for(int i = 1; i <= A; i++){
            if((i * B ) % A == 0){
                System.out.println(i * B);
                break;
            }
        }
    }     
}