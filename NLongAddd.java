package NKTest;

import java.util.Scanner;

//超长正整数相加
public class NLongAddd {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String a = in.next();
            String b = in.next();
            StringBuilder sb = new StringBuilder();
            int i = a.length() - 1;
            int j = b.length() - 1;
            int sum = 0;
            while(i >= 0 || j >= 0){
                int x = (i >= 0)? Integer.parseInt(String.valueOf(a.charAt(i))) : 0;
                int y = (j >= 0)? Integer.parseInt(String.valueOf(b.charAt(j))) : 0;
                sum = x + y + sum;
                sb.append((sum % 10));
                sum = sum / 10;
                i--;
                j--;
            }
            if(sum != 0){
                sb.append(sum);
            }
            System.out.println(sb.reverse().toString());
        }
    }
}
