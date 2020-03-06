package NKTest;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;

public class NThanN2 {
//    n个数里出现次数大于等于n/2的数

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        String[] line = br.readLine().split(" ");
        for(int i = 0; i < line.length; i++){
            if(map.containsKey(line[i])){
                int count = map.get(line[i]);
                map.put(line[i], count + 1);
            }else{
                map.put(line[i], 1);
            }
        }
        for(String x : map.keySet()){
            if(map.get(x) >= (line.length / 2)){
                System.out.println(x);
            }
        }

    }
}
