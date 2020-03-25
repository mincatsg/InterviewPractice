package NKTest;
import java.util.Scanner;
import java.util.*;
public class Buybuy {

    //到底买不买
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            Map<Character, Integer> map = new HashMap<>();
            String bank = in.next();
            String me = in.next();
            for(int i = 0; i < bank.length(); i++){
                char x = bank.charAt(i);
                int count = map.getOrDefault(x, 0);
                map.put(x, count + 1);
            }

            int count = 0;
            for(int i = 0; i < me.length(); i++){
                char x = me.charAt(i);
                if(!map.containsKey(x) || map.get(x) == 0){
                    count += 1;
                }else{
                    int value = map.get(x);
                    map.put(x, value - 1);
                }
            }
            if(count >= 1){
                System.out.println("No " + count);
            }else{
                System.out.println("Yes "  + (bank.length() - me.length()));
            }
        }
    }
}
