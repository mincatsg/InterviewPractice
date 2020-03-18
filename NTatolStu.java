package NKTest;

import java.util.Scanner;
import java.util.*;

//统计学生成绩
public class NTatolStu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int N = in.nextInt();
            if(N == 0){
                break;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < N; i++){
                int a = in.nextInt();
                int count = map.getOrDefault(a, 0);
                map.put(a, count + 1);
            }
            int stat = in.nextInt();
            System.out.println(map.get(stat));

        }
    }
}
