package NKTest;

import java.util.Scanner;


//洗牌
public class NShuffleDeck {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()){
            int all = scan.nextInt();
            while(all>0){
                int n = scan.nextInt();
                int k = scan.nextInt();
                int[] mark = new int[n*2];
                for(int i=0;i<n*2;i++){
                    mark[i] = scan.nextInt();
                }
                mark = use(mark, k);
                StringBuffer sb = new StringBuffer();

                for(int num: mark) {
                    sb.append(num);
                    sb.append(" ");
                }
                sb.deleteCharAt(sb.length()-1);
                System.out.println(sb.toString());
                all--;
            }
        }
    }

    public static int[] use(int[] mark,int k){
        int[] now = null;
        while(k>0){
            now = mark.clone();
            int count = 0;
            for(int i=0;i<mark.length/2;i++){
                mark[count++] = now[i];
                mark[count++] = now[i+mark.length/2];
            }
            k--;
        }
        return mark;
    }
}
