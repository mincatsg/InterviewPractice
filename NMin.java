import java.util.Scanner;

public class NMin{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        //����A����B�� ��������.
        if(A >= B){
           int tem = A;
            A = B;
            B = tem;
        }
        //��������С������Ҫô������������,Ҫô�Ǹ������.
        for(int i = 1; i <= A; i++){
            if((i * B ) % A == 0){
                System.out.println(i * B);
                break;
            }
        }
    }     
}