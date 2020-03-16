package NKTest;

import java.util.*;
import java.io.*;

public class NNiKe {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = "";
        while((string = br.readLine()) != null) {
            int m = Integer.parseInt(string);
            System.out.println(GetSequeOddNum(m));
        }
    }
    public static String GetSequeOddNum(int m){
        int[] num = new int[m];
        num[0] = m*(m-1)+1;
        StringBuilder sb = new StringBuilder();
        sb.append(num[0]);
        for(int i = 1;i<m;i++){
            num[i] = num[i-1]+2;
            sb.append("+"+num[i]);
        }
        String s = sb.toString();
        return s;
    }
}
